package com.example.firstservice.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/first-service")
@RequiredArgsConstructor
@RestController
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final Environment env;


    @GetMapping("/welcome")
    public String welcome(@RequestHeader("first-request") String header){
        logger.info(header);

        return "Welcome to first Service" + header;
    }


    @GetMapping("/check")
    public String check(HttpServletRequest request){

        logger.info("Server port={}", request.getServerPort());

        return String.format("this is a message from first service on Port %s", env.getProperty("local.server.port"));
    }


}
