package com.github.binarywang.demo.wx.cp.controller;

import com.github.binarywang.demo.wx.cp.config.WxCpConfiguration;
import com.github.binarywang.demo.wx.cp.dto.AuthRequest;
import com.github.binarywang.demo.wx.cp.dto.AuthResponse;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wx/cp/auth")
public class WxAuthController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/{agentId}")
    public AuthResponse getAuth(@PathVariable Integer agentId, @RequestBody AuthRequest request) throws WxErrorException {
        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);

        String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳

        String accessToken = wxCpService.getAccessToken();
        String jsapi_ticket = wxCpService.getJsapiTicket();
        System.out.println("accessToken:" + accessToken + "\njsapi_ticket:" + jsapi_ticket + "\n时间戳：" + timestamp + "\n随机字符串：" + noncestr);

        String url = request.getUrl();
        String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url;
        String signature = SHA1(str);

        String agent_jsapi_ticket = wxCpService.getAgentJsapiTicket();
        System.out.println("accessToken:" + accessToken + "\nagent_jsapi_ticket:" + agent_jsapi_ticket + "\n时间戳：" + timestamp + "\n随机字符串：" + noncestr);

        String agent_signature = SHA1("jsapi_ticket=" + agent_jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url);

        return AuthResponse.builder().appid("ww5cc8b382c9573b88").noncestr(noncestr).timestamp(timestamp).signature(signature).agentSignature(agent_signature).build();
    }

    public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
