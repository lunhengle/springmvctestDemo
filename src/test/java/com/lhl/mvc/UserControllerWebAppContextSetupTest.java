package com.lhl.mvc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by lenovo on 2016/3/24.
 * 集成web方式测试
 */
//注解风格
/*@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(name = "parent", classes = AppConfig.class),
        @ContextConfiguration(name = "child", classes = MvcConfig.class)
})*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:spring-config.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")
})
public class UserControllerWebAppContextSetupTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testView() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("user/getUser/1"))
                .andExpect(MockMvcResultMatchers.view().name("user/view"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        Assert.assertNotNull(result.getModelAndView().getModel().get("user"));
    }
}
