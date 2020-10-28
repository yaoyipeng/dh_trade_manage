package com.giao.ssm.controller;

import com.giao.ssm.domain.FactoryC;
import com.giao.ssm.service.FactoryCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 影耀子
 * 生产工厂Controller
 */
@Controller
@RequestMapping("/factoryc")
public class FactoryCController {

    @Autowired
    private FactoryCService factoryCService;

    /**
     * 查询全部生产厂家
     * @return
     */
    @RequestMapping("/findFactorycAll")
    public ModelAndView findFactorycAll(){
        ModelAndView mv = new ModelAndView();
        List<FactoryC> factoryCS = factoryCService.findFactorycAll();
//        System.out.println(factoryCS);
        mv.addObject("dataList",factoryCS);
        mv.setViewName("basicinfo/factory/jFactoryList");
        return mv;
    }
    /**
     * 跳转到新增页面
     */
    @RequestMapping("/goInsertFactoryc")
    public String goInsertFactoryc(){
        return "basicinfo/factory/jFactoryCreate";
    }

    /**
     * 添加生产厂家
     */
    @RequestMapping("/insertFactoryc")
    public String insertFactoryc(FactoryC factoryC){
//        System.out.println(factoryC);
        factoryCService.insertFactoryc(factoryC);
        return "redirect:/factoryc/findFactorycAll";
    }

    /**
     * 查询一个
     * @param factoryId
     * @return
     */
    @RequestMapping("/goUpdateFactoryc")
    public ModelAndView goUpdateFactoryc(String factoryId){
        ModelAndView mv = new ModelAndView();
        FactoryC factoryC = factoryCService.findFactorycById(factoryId);
//        System.out.println(factoryC);
        mv.addObject("obj",factoryC);
        mv.setViewName("basicinfo/factory/jFactoryUpdate");
        return mv;
    }
    /**
     * 修改生产厂家
     */
    @RequestMapping("/UpdateFactoryc")
    public String UpdateFactoryc(FactoryC factoryC){
        factoryCService.UpdateFactoryc(factoryC);
        return "redirect:/factoryc/findFactorycAll";
    }

    /**
     * 根据id删除生产厂家
     * @return
     */
    @RequestMapping("/deleteFactoryc")
    public String deleteFactorycByFactoryId(String factoryId){
        factoryCService.deleteFactorycByFactoryId(factoryId);
        return "redirect:/factoryc/findFactorycAll";
    }
    /**
     * 批量删除
     */
    @RequestMapping("/deleteFactorycs")
    public String deleteFactorycs(String[] factoryId){
        for (String id: factoryId) {
            factoryCService.deleteFactorycByFactoryId(id);
        }

        return "redirect:/factoryc/findFactorycAll";
    }
    /**
     * 停用生产工厂
     */
    @RequestMapping("/stopFactoryc")
    public String stopFactoryc(String id){
        factoryCService.stopFactoryc(id);
        return "redirect:/factoryc/findFactorycAll";
    }
    /**
     * 启用生产工厂
     */
    @RequestMapping("/startFactoryc")
    public String startFactoryc(String id){
        factoryCService.startFactoryc(id);
        return "redirect:/factoryc/findFactorycAll";
    }

    /**
     * 批量启用生产工厂
     * @param id
     * @return
     */
    @RequestMapping("/startFactorycByIds")
    public String startFactorycByIds(String[] factoryId){
        for (String id : factoryId) {
            factoryCService.startFactoryc(id);
        }
        return "redirect:/factoryc/findFactorycAll";
    }

    /**
     * 批量停用生产工厂
     * @param factoryId
     * @return
     */
    @RequestMapping("/stopFactorycByIds")
    public String stopFactorycByIds(String[] factoryId){
        for (String id : factoryId) {
            factoryCService.stopFactoryc(id);
        }
        return "redirect:/factoryc/findFactorycAll";
    }

    /**
     * 根据id查询一个，浏览生产厂家信息
     * @param factoryId
     * @return
     */
    @RequestMapping("/findFactorycById")
    public ModelAndView findFactorycById(String factoryId){
        ModelAndView mv = new ModelAndView();
        FactoryC factoryC = factoryCService.findFactorycById(factoryId);
        mv.addObject("obj",factoryC);
        mv.setViewName("basicinfo/factory/jFactoryView");
        return mv;
    }

}
