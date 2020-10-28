package com.giao.ssm.controller;

import com.giao.ssm.domain.ContractProductC;
import com.giao.ssm.domain.FactoryC;
import com.giao.ssm.service.ContractProductCService;
import com.giao.ssm.service.FactoryCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 影耀子
 * 合同商品明细控制层
 */
@Controller
@RequestMapping("/contractProductC")
public class ContractProductCController {

    @Autowired
    private ContractProductCService contractProductCService;

    @Autowired
    private FactoryCService factoryCService;

    /**
     * 根据contractId查询货物
     * @param contractId
     * @return
     */
    @RequestMapping("/findAllByContractId")
    public ModelAndView findAllByContractId(String contractId){
        ModelAndView mv = new ModelAndView();
        List<FactoryC> factoryCS = factoryCService.findFactorycAll();
        mv.addObject("factoryList",factoryCS);
        mv.addObject("contractId",contractId);
        List<ContractProductC> contractProductCS = contractProductCService.findAllByContractId(contractId);
        mv.addObject("dataList",contractProductCS);
        mv.setViewName("cargo/contract/jContractProductCreate");
        return mv;
    }

    /**
     * 添加货物
     * @param contractProductC
     * @return
     */
    @RequestMapping("/insertContractProductC")
    public ModelAndView insertContractProductC(ContractProductC contractProductC){
        contractProductCService.insertContractProductC(contractProductC);
        ModelAndView mv = findAllByContractId(contractProductC.getContractId());
        return mv;
    }

    /**
     * 删除货物
     * 级联删除
     * @param contractProductId
     * @param contractId
     * @return
     */
    @RequestMapping("/deleteContractProductCById")
    public ModelAndView deleteContractProductCById(String contractProductId,String contractId){
        contractProductCService.deleteContractProductCById(contractProductId);
        ModelAndView mv = findAllByContractId(contractId);
        return mv;
    }
    /**
     * 跳转到修改页面
     */
    @RequestMapping("goUpdateContractProductCById")
    public ModelAndView  goUpdateContractProductCById(String contractProductId,String contractId){
        ModelAndView mv = new ModelAndView();
        List<FactoryC> factoryCS = factoryCService.findFactorycAll();
        mv.addObject("factoryList",factoryCS);
        ContractProductC contractProductC =contractProductCService.findContractProductCById(contractProductId);
        System.out.println(contractProductC);
        mv.addObject("pro",contractProductC);
        mv.addObject("contractId",contractId);
        mv.setViewName("cargo/contract/jContractProductUpdate");
        return mv;
    }

    /**
     * 修改货物
     * @param contractProductC
     * @return
     */
    @RequestMapping("/updateContractProductC")
    public ModelAndView updateContractProductC(ContractProductC contractProductC){
        contractProductCService.updateContractProductC(contractProductC);
        ModelAndView mv = findAllByContractId(contractProductC.getContractId());
        return mv;
    }

}
