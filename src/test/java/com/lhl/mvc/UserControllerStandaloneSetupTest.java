package com.lhl.mvc;

import com.lhl.mvc.controller.UserController;
import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by lenovo on 2016/3/24.
 * 独立测试模式
 */
public class UserControllerStandaloneSetupTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        UserController userController = new UserController();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
}
