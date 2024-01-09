package com.qa.unittest;

import com.qa.config.EnvironmentConfig;
import com.qa.config.FrameworkConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest{
    @Test
    public void testFrameworkConfig() {
        System.out.println(EnvironmentConfig.getUserName());
        Assert.assertNotNull(FrameworkConfig.getBrowser());
    }
}
