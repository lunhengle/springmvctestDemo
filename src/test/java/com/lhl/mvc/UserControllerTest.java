package com.lhl.mvc;

import com.lhl.mvc.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lenovo on 2016/3/24.
 */
public class UserControllerTest {
    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testView() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        ModelAndView mv = userController.view(1L, req);
        ModelAndViewAssert.assertViewName(mv,"user/view");
        ModelAndViewAssert.assertModelAttributeAvailable(mv,"user");
    }

}
