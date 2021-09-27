package com.github.binarywang.demo.wx.cp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/")
public class WxSecretController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("WW_verify_Zik1vNKuHk3so63J.txt")
    public String getTxt() {
        return "Zik1vNKuHk3so63J";
    }

}
