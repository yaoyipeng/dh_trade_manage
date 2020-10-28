package com.giao.ssm.controller;

import com.giao.ssm.domain.ContractC;
import com.giao.ssm.domain.ExportC;
import com.giao.ssm.service.ExportCService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-11 20:35
 * 报运单控制层
 **/
@Controller
@RequestMapping("exportc")
public class ExportCController {

    @Autowired
    private ExportCService exportCService;

    /**
     *  查询查询所有出口货运
     *  报运单
     * @return
     */
    @RequestMapping("list")
    public ModelAndView list(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                             @RequestParam(name = "size",required = true,defaultValue = "4")int size){
        ModelAndView mv = new ModelAndView();
        List<ExportC> dataList = exportCService.find(page,size);
        //PageInfo是一个分页bean
        PageInfo pageInfo = new PageInfo(dataList);
        System.out.println(dataList.size());
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("cargo/export/jExportList");
        return mv;
    }

    /**
     * 获取购销合同列表（已上报）
     * @return
     */
    @RequestMapping("contractCList")
    public ModelAndView contractCList(){
        ModelAndView mv = new ModelAndView();
        List<ContractC> dataList = exportCService.getContractCList();
        System.out.println(dataList.size());
        mv.addObject("contractList",dataList);
        mv.setViewName("cargo/export/jContractList");
        return mv;
    }

    /**
     * 报运新增，直接进行后台保存
     * @param contractIds
     * @return
     */
    @RequestMapping("insert")
    public String insert(@RequestParam("contractId") String[] contractIds) { // 合同的id集合
        exportCService.insert(contractIds);
        return "redirect:/exportc/contractCList";
    }

    /**
     * 跳转修改页面
     * @param exportId
     * @return
     */
    @RequestMapping("goUpdate")
    public ModelAndView goUpdate(String exportId){
        ModelAndView mv = new ModelAndView();
        ExportC exportC = exportCService.findById(exportId);
        mv.addObject("obj", exportC);
        String mRecordTable = exportCService.getMrecordData(exportId);
        mv.addObject("mRecordTable", mRecordTable);
        mv.setViewName("cargo/export/jExportUpdate");
        return mv;
    }

    /**
     * 修改报运单
     * @param exportC
     * @param mr_id
     * @param mr_orderNo
     * @param mr_cnumber
     * @param mr_grossWeight
     * @param mr_netWeight
     * @param mr_sizeLength
     * @param mr_sizeWidth
     * @param mr_sizeHeight
     * @param mr_exPrice
     * @param mr_tax
     * @param mr_changed
     * @return
     */
    @RequestMapping("updateExportC")
    public String updateExportC(ExportC exportC,
                                String[] mr_id,
                                Integer[] mr_orderNo,
                                Integer[] mr_cnumber,
                                Double[] mr_grossWeight,
                                Double[] mr_netWeight,
                                Double[] mr_sizeLength,
                                Double[] mr_sizeWidth,
                                Double[] mr_sizeHeight,
                                Double[] mr_exPrice,
                                Double[] mr_tax,
                                Integer[] mr_changed){
        exportCService.updateExportC(exportC,
                mr_id,
                mr_orderNo,
                mr_cnumber,
                mr_grossWeight,
                mr_netWeight,
                mr_sizeLength,
                mr_sizeWidth,
                mr_sizeHeight,
                mr_exPrice,
                mr_tax,
                mr_changed);

        return "redirect:/exportc/list";
    }

    /**
     * 批量上报state=1
     * @param exportId
     * @return
     */
    @RequestMapping("submit")
    public String submit(String[] exportId){
        exportCService.submit(exportId);
        return "redirect:/exportc/list";
    }

    /**
     * 批量取消state=0
     * @param exportId
     * @return
     */
    @RequestMapping("cancel")
    public String cancel(String[] exportId){
        exportCService.cancel(exportId);
        return "redirect:/exportc/list";
    }
}
