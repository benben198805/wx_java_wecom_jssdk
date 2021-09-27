package com.github.binarywang.demo.wx.cp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SendRequest {

    private String content;
    private String user;
}
