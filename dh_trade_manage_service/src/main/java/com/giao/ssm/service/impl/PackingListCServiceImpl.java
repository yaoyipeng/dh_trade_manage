package com.giao.ssm.service.impl;

import com.giao.ssm.dao.ExportCDao;
import com.giao.ssm.dao.PackingListCDao;
import com.giao.ssm.domain.ExportC;
import com.giao.ssm.domain.PackingListC;
import com.giao.ssm.service.PackingListCService;
import com.giao.ssm.utils.UtilFuns;
import com.giao.ssm.utils.UuidUtil;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-12 23:06
 * 装箱单serviceImpl
 **/
@Service
public class PackingListCServiceImpl implements PackingListCService {

    @Autowired
    private PackingListCDao packingListCDao;
    @Autowired
    private ExportCDao exportCDao;

    /**
     * 查询全部装箱单
     * @return
     */
    @Override
    public List<PackingListC> findAllPackingListC() {
        return packingListCDao.findAllPackingListC();
    }

    /**
     * 只查询一个，常用于修改
     * @param packingListId
     * @return
     */
    @Override
    public PackingListC findPackingListCById(String packingListId) {
        return packingListCDao.findPackingListCById(packingListId);
    }

    /**
     * 获取div在新增页面展示数据
     * @return
     */
    @Override
    public String getDivDataCreate(String[] exportId) {

        StringBuffer sBuf = new StringBuffer();
        for(int i=0;i<exportId.length;i++){
            ExportC export = exportCDao.findById(exportId[i]);
            sBuf.append("<input type=\"checkbox\" name=\"exportIds\" checked value=\"").append(exportId[i]).append("|").append(export.getCustomerContract()).append("\" class=\"input\"/>");
            sBuf.append(export.getCustomerContract()).append("&nbsp;&nbsp;");
        }

        return sBuf.toString();
    }

    /**
     * 新增装箱单
     * @param packingList
     */
    @Override
    public void insertPackingListC(PackingListC packingList) {
        this.spellString(packingList);
        packingList.setPackingListId(UuidUtil.getUuid());
        packingList.setState(0);					//0草稿1已上报
        packingList.setCreateTime(new Date());
        packingListCDao.insertPackingListC(packingList);
    }

    /**
     * 批量上报state==1
     * @param packingListId
     */
    @Override
    public void updateSubmit(String[] packingListId) {
        packingListCDao.updateSubmit(packingListId);
    }

    /**
     * 批量取消state==0
     * @param packingListId
     */
    @Override
    public void updateCancel(String[] packingListId) {
        packingListCDao.updateCancel(packingListId);
    }

    /**
     * 拼接HTML片段(修改)
     * 获取div在修改页面展示数据
      * @param exportIds
     * @param exportNos
     * @return
     */
    @Override
    public String getDivDataUpdate(String[] exportIds, String[] exportNos) {
        StringBuffer sBuf = new StringBuffer();
        for(int i=0;i<exportIds.length;i++){
            sBuf.append("<input type=\"checkbox\" name=\"exportIds\" checked value=\"").append(exportIds[i]).append("|").append(exportNos[i]).append("\" class=\"input\"/>");
            sBuf.append(exportNos[i]).append("&nbsp;&nbsp;");
        }

        return sBuf.toString();
    }

    /**
     * 修改装箱单
     * @param packingListC
     */
    @Override
    public void update(PackingListC packingListC) {
        this.spellString(packingListC);
        packingListCDao.updatePackingListC(packingListC);
    }

    /**
     * 获取div在查看页面展示数据
     * 拼接HMTL片段(查看)
     * @param exportNos
     * @return
     */
    @Override
    public String getDivDataView(String[] exportNos) {
        StringBuffer sBuf = new StringBuffer();
        for(int i=0;i<exportNos.length;i++){
            sBuf.append(exportNos[i]).append("&nbsp;&nbsp;");
        }
        return sBuf.toString();
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @Override
    public List<PackingListC> findPage(Page page) {
        return null;
    }

    //拆串，拼串
    private PackingListC spellString(PackingListC packingList){
        String _exportIds = "";
        String _exportNos = "";

        String[] _s = packingList.getExportIds().split(",");		//id|no
        for(int i=0;i<_s.length;i++){
            String[] _tmp = _s[i].split("\\|");						//正则表达式，转义
            _exportIds +=  _tmp[0] + "|";
            _exportNos +=  _tmp[1] + "|";
        }
        _exportIds = UtilFuns.delLastChar(_exportIds);
        _exportNos = UtilFuns.delLastChar(_exportNos);

        packingList.setExportIds(_exportIds);
        packingList.setExportNos(_exportNos);

        return packingList;
    }
}
