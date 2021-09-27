package com.github.binarywang.demo.wx.cp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Controller
@RequestMapping("/")
public class WxHomeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public String getAuth() {
        return "index";
    }

}
