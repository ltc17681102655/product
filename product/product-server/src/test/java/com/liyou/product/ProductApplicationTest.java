package com.liyou.product;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * <pre>
 * @description
 * @copyright: Copyright (c)2017
 * @author: vincent
 * @version: 1.0
 * @date: 2018/10/10
 * </pre>
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
public abstract class ProductApplicationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void contextLoads() {
        //单个构建 controller 会跳过拦截器
        //       mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }

    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
}
