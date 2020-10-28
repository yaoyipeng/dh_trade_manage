package com.giao.ssm.controller;

import com.giao.ssm.domain.ContractC;
import com.giao.ssm.print.ContractPrint;
import com.giao.ssm.service.ContractCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 影耀子
 * 购销合同控制层
 *
 */
@Controller
@RequestMapping("/contractC")
public class ContractCController {
    @Autowired
    private ContractCService contractCService;

    /**
     * 打印合同
     * @param contractId
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/print")
    public void print(String contractId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(contractId);
        ContractPrint cp = new ContractPrint();
        List<ContractC> contractCS = contractCService.view(contractId);
        System.out.println("打印的数据"+contractCS);
        for (ContractC obj : contractCS) {
            cp.print(obj, request.getSession().getServletContext().getRealPath("/"), response);
        }
    }
    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findContractCAll")
    public ModelAndView findContractCAll(){
        ModelAndView mv = new ModelAndView();
        List<ContractC> contractCAll = contractCService.findContractCAll();
        mv.addObject("dataList",contractCAll);
        mv.setViewName("cargo/contract/jContractList");
        return mv;
    }
    /**
     * 跳转添加页面
     */
    @RequestMapping("/goinsertContractC")
    public String goinsertContractC(){
        return "cargo/contract/jContractCreate";
    }
    /**
     * 添加购销合同
     * @param contractC
     * @return
     */
    @RequestMapping("/insertContractC")
    public String insertContractC(ContractC contractC){
//        System.out.println(contractC);
        contractCService.insertContractC(contractC);
        return "redirect:/contractC/findContractCAll";
    }

    /**
     * 批量删除
     * @param contractId
     * @return
     */
    @RequestMapping("/deleteContractCById")
    public String deleteContractCById(String[] contractId){
//        System.out.println(contractId.length);
//        System.out.println(contractId);
        for (String id : contractId) {
            contractCService.deleteContractCById(id);
        }
        return "redirect:/contractC/findContractCAll";
    }
    /**
     * 批量上报
     */
    @RequestMapping("/updateStateById")
    public String updateStateById(String[] contractId){
        for (String id : contractId) {
            contractCService.updateStateById(id);
        }
        return "redirect:/contractC/findContractCAll";
    }
    /**
     * 批量取消
     */
    @RequestMapping("/updateCancelStateById")
    public String updateCancelStateById(String[] contractId){
        for (String id : contractId) {
            contractCService.updateCancelStateById(id);
        }
        return "redirect:/contractC/findContractCAll";
    }
    /**
     * 跳转到修改页面
     * (根据id查询一个)
     */
    @RequestMapping("/goupdateContractC")
    public ModelAndView goupdateContractC(String contractId){
        ModelAndView mv = new ModelAndView();
        ContractC contractC = contractCService.findContractCById(contractId);
        System.out.println(contractC);
        mv.addObject("obj",contractC);
        mv.setViewName("cargo/contract/jContractUpdate");
        return mv;
    }

    /**
     * 根据id修改
     * @param contractC
     * @return
     */
    @RequestMapping("/updateContractC")
    public String updateContractC(ContractC contractC){
//        System.out.println(contractC);
        contractCService.updateContractC(contractC);
        return "redirect:/contractC/findContractCAll";
    }

    /**
     * 根据id查询一个
     * 浏览购销合同信息
     * @param contractId
     * @return
     */
    @RequestMapping("/findContractCById")
    public ModelAndView findContractCById(String contractId){
        ModelAndView mv = new ModelAndView();
        // 购销合同信息
        ContractC contractC = contractCService.findContractCById(contractId);
        mv.addObject("obj",contractC);
        mv.setViewName("cargo/contract/jContractView");
        return mv;
    }
}
