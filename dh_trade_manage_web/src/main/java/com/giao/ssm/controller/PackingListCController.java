package com.giao.ssm.controller;

import com.giao.ssm.domain.PackingListC;
import com.giao.ssm.service.PackingListCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-12 23:08
 * 装箱单Controller
 **/
@Controller
@RequestMapping("packingListC")
public class PackingListCController {

    @Autowired
    private PackingListCService packingListCService;

    /**
     * 查询全部装箱单
     * @return
     */
    @RequestMapping("findAllPackingListC")
    public ModelAndView findAllPackingListC(){
        ModelAndView mv = new ModelAndView();
        List<PackingListC> dataList = packingListCService.findAllPackingListC();
        mv.addObject("dataList", dataList);
        mv.setViewName("cargo/packinglist/jPackingListList");
        return mv;
    }

    /**
     * 跳转至新增页面
     * @return
     */
    @RequestMapping("tocreate")
    public ModelAndView tocreate(String[] exportId){
        ModelAndView mv = new ModelAndView();
        mv.addObject("divData",packingListCService.getDivDataCreate(exportId));
        mv.setViewName("cargo/packinglist/jPackingListCreate");
        return mv;
    }

    /**
     * 真正新增
     * @param packingList
     * @return
     */
    @RequestMapping("/insertPackingListC")
    public String insertPackingListC(PackingListC packingList){
        packingListCService.insertPackingListC(packingList);
        return "redirect:/packingListC/findAllPackingListC";
    }

    /**
     * 批量上报state==1
     * @return
     */
    @RequestMapping("submit")
    public String submit(String[] packingListId){
        packingListCService.updateSubmit(packingListId);
        return "redirect:/packingListC/findAllPackingListC";
    }
    /**
     * 批量取消state==0
     * 草稿
     * @return
     */
    @RequestMapping("cancel")
    public String cancel(String[] packingListId){
        packingListCService.updateCancel(packingListId);
        return "redirect:/packingListC/findAllPackingListC";
    }

    /**
     * 去修改页面
     * @return
     */
    @RequestMapping("toupdate")
    public ModelAndView toupdate(String packingListId){
        ModelAndView mv = new ModelAndView();
        PackingListC obj = packingListCService.findPackingListCById(packingListId);
        mv.addObject("obj",obj);
        String _s = packingListCService.getDivDataUpdate(obj.getExportIds().split("\\|"), obj.getExportNos().split("\\|"));
        mv.addObject("divData", _s);
        mv.setViewName("cargo/packinglist/jPackingListUpdate");
        return mv;
    }

    /**
     * 真正修改
     * @param packingListC
     * @return
     */
    @RequestMapping("update")
    public String update(PackingListC packingListC){
        packingListCService.update(packingListC);
        return "redirect:/packingListC/findAllPackingListC";
    }

    @RequestMapping("toview")
    public ModelAndView toview(String packingListId){
        ModelAndView mv = new ModelAndView();
        PackingListC obj = packingListCService.findPackingListCById(packingListId);
        mv.addObject("obj",obj);
        mv.addObject("divData", packingListCService.getDivDataView(obj.getExportNos().split("\\|")));
        mv.setViewName("cargo/packinglist/jPackingListView");
        return mv;
    }
}
