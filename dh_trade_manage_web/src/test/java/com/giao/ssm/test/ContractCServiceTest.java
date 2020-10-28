package com.giao.ssm.test;

import com.giao.ssm.domain.ContractC;
import com.giao.ssm.service.ContractCService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-09-27 12:18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ContractCServiceTest {

    @Autowired
    private ContractCService contractCService;

    @Test
    public void findContractCById(){
        ContractC contractCById = contractCService.findContractCById("11");
        System.out.println(contractCById);
    }

}
