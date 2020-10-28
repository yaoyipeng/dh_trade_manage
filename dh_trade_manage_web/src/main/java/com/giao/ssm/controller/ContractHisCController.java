package com.giao.ssm.controller;

import com.giao.ssm.domain.ContractC;
import com.giao.ssm.service.ContractHisCService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-10-14 15:52
 * 历史合同表CONTRACT_HIS_C控制层
 **/
@Controller
@RequestMapping("contractHisC")
public class ContractHisCController {
    @Resource
    private ContractHisCService contractHisService;

    //历史列表
    @RequestMapping("list")
    public String list(Model model){
        List<ContractC> dataList = contractHisService.findAll();
        model.addAttribute("dataList", dataList);

        return "cargo/contracthis/jContractHisList";
    }
    //归档
    @RequestMapping("pigeinhole")
    public String pigeinhole(String[] contractId){
        contractHisService.pigeinhole(contractId);
        return "redirect:/contractC/findContractCAll";
    }
    //取消归档
    @RequestMapping("pigeouthole")
    public String pigeouthole(String[] contractId){
        contractHisService.pigeouthole(contractId);

        return "redirect:/contractHisC/list";
    }

}
