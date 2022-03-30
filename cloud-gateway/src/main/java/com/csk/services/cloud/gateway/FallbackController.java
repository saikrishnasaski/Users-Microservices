package com.csk.services.cloud.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/")
public class FallbackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackController.class);

    @GetMapping("userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer time to respond." +
                "Please try again later.";
    }

    @GetMapping("departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        System.out.println("Fallbackkkkkkk...........");
        LOGGER.info("departmentServiceFallBack .....................");
        return "Department Service is taking longer time to respond." +
                "Please try again later.";
    }
}
