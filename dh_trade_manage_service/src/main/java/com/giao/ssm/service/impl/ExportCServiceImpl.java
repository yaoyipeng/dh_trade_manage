package com.giao.ssm.service.impl;

import com.giao.ssm.dao.ContractCDao;
import com.giao.ssm.dao.ExportCDao;
import com.giao.ssm.dao.ExportProductCDao;
import com.giao.ssm.dao.ExtEproductCDao;
import com.giao.ssm.domain.*;
import com.giao.ssm.service.ExportCService;
import com.giao.ssm.utils.UtilFuns;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.Serializable;
import java.util.*;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-11 20:36
 * 报运单serviceImpl
 **/
@Service
@WebService
public class ExportCServiceImpl implements ExportCService {

    @Autowired
    private ExportCDao exportCDao;

    @Autowired
    private ContractCDao contractCDao;

    @Autowired
    private ExportProductCDao exportProductCDao;

    @Autowired
    private ExtEproductCDao extEproductCDao;

    //利用set方法，在cxf中注入dao，这样cxf的WebService才可以查询我们系统的数据
    @WebMethod(exclude = true)
    public void setExportCDao(ExportCDao exportCDao) {
        this.exportCDao = exportCDao;
    }


    /**
     * 查询报运单
     * @return
     */
    @Override
    @WebMethod(exclude=true)
    public List<ExportC> find(int page,int size) {
        // 参数pageNum是页码值，pageSize是每页显示条数
        PageHelper.startPage(page,size);
        return exportCDao.find();
    }
    /**
     * 获取购销合同列表（已上报）
     * @return
     */
    @Override
    @WebMethod(exclude=true)
    public List<ContractC> getContractCList() {
        Integer state = 1;
        return contractCDao.findContractCByCondition(state);
    }

    /**
     * 插入数据
     * @param contractIds
     */
    @Override
    @WebMethod(exclude=true)
    public void insert(String[] contractIds) {
        /*
         * 步骤：
         * 1、根据合同id获得合同对象，获取合同号
         * 2、将合同下的货物信息搬家到报运下的货物表中
         * 3、将合同下的附件信息搬家到报运下的附件表中
         */

        //拼接合同号，报运号
        String contractNos = "";
        for(int i=0;i<contractIds.length;i++){
            List<ContractC> contract = contractCDao.view(contractIds[i]);
            for (ContractC c : contract) {
                contractNos += c.getContractNo() + " ";
            }
            //以空格作为分隔符
        }
        //工具类，删除最后一个字符
        contractNos = UtilFuns.delLastChar(contractNos);

        ExportC export = new ExportC();
        export.setExportId(UUID.randomUUID().toString());

        //工具类，拼串
        export.setContractIds(UtilFuns.joinStr(contractIds, ","));
        export.setCustomerContract(contractNos);
        //0草稿
        export.setState(0);
        export.setInputDate(new Date());
        export.setCreateTime(new Date());
        exportCDao.insert(export);

        //处理货物信息
        for(int i=0;i<contractIds.length;i++){

            List<ContractC> contract = contractCDao.view(contractIds[i]);
            for (ContractC c : contract) {
                for(ContractProductC cp : c.getContractProductCS()){
                    ExportProductC ep = new ExportProductC();
                    ep.setExportProductId(UUID.randomUUID().toString());
                    ep.setExportId(export.getExportId());					//绑定外键

                    //数据搬家，将合同下的对应的货物信息写入到报运下的货物信息中
                    ep.setFactoryId(cp.getFactoryC().getFactoryId());
                    ep.setFactory(cp.getFactoryC().getFullName());
                    ep.setProductNo(cp.getProductNo());
                    ep.setPackingUnit(cp.getPackingUnit());
                    ep.setCnumber(cp.getCnumber());
                    ep.setBoxNum(cp.getBoxNum());
                    ep.setPrice(cp.getPrice());

                    exportProductCDao.insert(ep);
                    List<ExtCproductC> extCproducts=cp.getExtCproductCS();
                    //处理附件信息
                    for(ExtCproductC extcp : extCproducts){
                        ExtEproductC extep = new ExtEproductC();

                        //copyProperties spring
                        BeanUtils.copyProperties(extcp, extep);		//spring工具类，数据的拷贝

                        extep.setExtEproductId(UUID.randomUUID().toString());
                        extep.setExportProductId(ep.getExportProductId());		//绑定外键

                        extep.setFactoryId(extcp.getFactoryC().getFactoryId());
                        extep.setFactory(extcp.getFactoryC().getFullName());

                        extEproductCDao.insert(extep);
                    }
                }
            }

        }
    }

    /**
     * 根据exportId查询一个，多用于修改
     * @param exportId
     * @return
     */
    @Override
    public ExportC findById(String exportId) {
        return exportCDao.findById(exportId);
    }

    /**
     * 拼接JS串
     *  function addTRRecord(objId, id, productNo, cnumber, grossWeight,
     *  netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax)
     * @param exportId
     * @return
     */
    @Override
    @WebMethod(exclude=true)
    public String getMrecordData(String exportId) {
        List<ExportProductC> oList = exportProductCDao.findByExportId(exportId);
        StringBuffer sBuf = new StringBuffer();
        for (ExportProductC ep : oList) {
            sBuf.append("addTRRecord(\"mRecordTable\", \"").append(ep.getExportProductId()).append("\", \"")
                    .append(ep.getProductNo()).append("\", \"").append(ep.getCnumber()).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getGrossWeight())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getNetWeight())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getSizeLenght())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getSizeWidth())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getSizeHeight())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getExPrice())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getTax())).append("\");");
        }
        return sBuf.toString();
    }
    // 修改，用实体做参数
    @Override
    @WebMethod(exclude=true)
    public void updateExportC(ExportC exportC, String[] mr_id, Integer[] mr_orderNo, Integer[] mr_cnumber, Double[] mr_grossWeight, Double[] mr_netWeight, Double[] mr_sizeLength, Double[] mr_sizeWidth, Double[] mr_sizeHeight, Double[] mr_exPrice, Double[] mr_tax, Integer[] mr_changed) {
        exportCDao.updateExportC(exportC);
        //批量修改货物信息

        for(int i=0;i<mr_id.length;i++){
//            if(mr_changed[i]!=null && mr_changed[i]==1){			//修改标识，只有用户修改的行才进行更新
                ExportProductC ep = exportProductCDao.findById(mr_id[i]);

                ep.setOrderNo(mr_orderNo[i]);
                ep.setCnumber(mr_cnumber[i]);
                ep.setGrossWeight(mr_grossWeight[i]);
                ep.setNetWeight(mr_netWeight[i]);
                ep.setSizeLenght(mr_sizeLength[i]);
                ep.setSizeWidth(mr_sizeWidth[i]);
                ep.setSizeHeight(mr_sizeHeight[i]);
                ep.setExPrice(mr_exPrice[i]);
                ep.setTax(mr_tax[i]);
                System.out.println(ep);
                exportProductCDao.updateExportProductC(ep);
//            }
        }

    }

    /**
     * 批量上报state=1
     * @param exportId
     */
    @Override
    @WebMethod(exclude=true)
    public void submit(String[] exportId) {
        exportCDao.updateExportCSubmit(exportId);
    }

    /**
     * 批量取消state=0
     * @param exportId
     */
    @Override
    @WebMethod(exclude=true)
    public void cancel(String[] exportId) {
        exportCDao.updateExportCCancel(exportId);
    }
}
