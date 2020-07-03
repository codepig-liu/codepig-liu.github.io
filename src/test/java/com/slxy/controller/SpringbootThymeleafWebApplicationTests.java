package com.slxy.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootThymeleafWebApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {

        //System.out.println("I am test!!!");
        logger.info("I am test!!!");
    }

}
