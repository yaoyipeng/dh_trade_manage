package com.giao.ssm.controller;

import com.giao.ssm.domain.ExtCproductC;
import com.giao.ssm.domain.FactoryC;
import com.giao.ssm.domain.SysCodeB;
import com.giao.ssm.service.ExtCproductCService;
import com.giao.ssm.service.FactoryCService;
import com.giao.ssm.service.SysCodeBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 影耀子
 * 合同商品附件控制层
 */
@Controller
@RequestMapping("/extCproductC")
public class ExtCproductCController {

    @Autowired
    private ExtCproductCService extCproductCService;

    @Autowired
    private FactoryCService factoryCService;

    @Autowired
    private SysCodeBService sysCodeBService;

    /**
     * 根据外键contractProductId查询多个合同商品附件
     * @param contractProductId
     * @return
     */
    @RequestMapping("/findMultipleExtCproductCById")
    public ModelAndView findMultipleExtCproductCById(String contractProductId){
        ModelAndView mv = new ModelAndView();
        List<FactoryC> factoryCS = factoryCService.findFactorycAll();
        mv.addObject("factoryList",factoryCS);
        mv.addObject("contractProductId",contractProductId);
        List<SysCodeB> sysCodeBS = sysCodeBService.findSysCodeBAll();
        mv.addObject("ctypeList",sysCodeBS);
        List<ExtCproductC> extCproductCS = extCproductCService.findMultipleExtCproductCById(contractProductId);
        mv.addObject("dataList",extCproductCS);
        mv.setViewName("cargo/contract/jExtCproductCreate");
        return mv;
    }

    /**
     * 根据id删除合同商品附件
     * @param extCproductId
     * @param contractProductId
     * @return
     */
    @RequestMapping("/deleteExtCproductCById")
    public ModelAndView deleteExtCproductCById(String extCproductId, String contractProductId){
        extCproductCService.deleteExtCproductCById(extCproductId);
        ModelAndView mv = this.findMultipleExtCproductCById(contractProductId);
        return mv;
    }

    /**
     * 添加合同商品附件
     * @param extCproductC
     * @return
     */
    @RequestMapping("/insertExtCproductC")
    public ModelAndView insertExtCproductC(ExtCproductC extCproductC){
        extCproductCService.insertExtCproductC(extCproductC);
        ModelAndView mv = this.findMultipleExtCproductCById(extCproductC.getContractProductId());
        return mv;
    }

    /**
     * 跳转到修改商品附件页面
     * 根据主键extCproductId查询一个
     * @param extCproductId
     * @param contractProductId
     * @return
     */
    @RequestMapping("/goUpdateExtCproductCById")
    public ModelAndView goUpdateExtCproductCById(String extCproductId,String contractProductId){
        ModelAndView mv = new ModelAndView();
        List<FactoryC> factoryCS = factoryCService.findFactorycAll();
        mv.addObject("factoryList",factoryCS);
        mv.addObject("contractProductId",contractProductId);
        List<SysCodeB> sysCodeBS = sysCodeBService.findSysCodeBAll();
        mv.addObject("ctypeList",sysCodeBS);
        ExtCproductC extCproductC = extCproductCService.findExtCproductCById(extCproductId);
        mv.addObject("obj",extCproductC);
        mv.setViewName("cargo/contract/jExtCproductUpdate");
        return mv;
    }

    /**
     * 修改商品附件
     * @param extCproductC
     * @return
     */
    @RequestMapping("/updateExtCproductCById")
    public ModelAndView updateExtCproductCById(ExtCproductC extCproductC){
        extCproductCService.updateExtCproductCById(extCproductC);
        ModelAndView mv = this.findMultipleExtCproductCById(extCproductC.getContractProductId());
        return mv;
    }

}
