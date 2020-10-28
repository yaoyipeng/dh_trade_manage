package com.giao.ssm.test;

import com.giao.ssm.utils.UuidUtil;
import org.junit.Test;

import java.util.UUID;

public class UuidTest {

    @Test
    public void uuid(){
        String factoryId = UUID.randomUUID().toString().replace("-", "");
        System.out.println(UuidUtil.getUuid());
        System.out.println(factoryId);
    }

}
