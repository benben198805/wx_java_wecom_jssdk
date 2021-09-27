package com.github.binarywang.demo.wx.cp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthResponse {
    private String appid;
    private String timestamp;
    private String noncestr;
    private String signature;
    private String agentSignature;
}
