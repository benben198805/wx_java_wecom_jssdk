package com.github.binarywang.demo.wx.cp.controller;

import com.github.binarywang.demo.wx.cp.config.WxCpConfiguration;
import com.github.binarywang.demo.wx.cp.dto.SendRequest;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.impl.WxCpMessageServiceImpl;
import me.chanjar.weixin.cp.bean.message.WxCpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wx/cp/portal/{agentId}/msg")
public class WxMsgController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(produces = "application/xml; charset=UTF-8")
    public void post(@PathVariable Integer agentId,
                     @RequestBody SendRequest request) throws WxErrorException {
        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);
        this.logger.info("content: " + request.getContent() + ". users: " + request.getUser());


//        "wmveVhDQAAQbANqwIGzq68J3OF-zc7BQ",
//       "wmveVhDQAApszvkdRqEKoaRm5aqfbAbA",
//      "wmveVhDQAAKRd37hxRccYuNnPE0SIvUw",
//     "wmveVhDQAAo9Y9lIINxAA5R1tJY1OuMA",
//    "wmveVhDQAAa3PgiPvEXXcYQOtLp_QUQQ"

//        客服消息
//        WxCpMessage message = WxCpMessage.TEXT().agentId(agentId)
//                                         .toUser(request.getUser())
//                                         .content(request.getContent())
//                                         .build();
//        WxCpMessageServiceImpl wxCpMessageService = new WxCpMessageServiceImpl(wxCpService);
//        wxCpMessageService.send(message);
    }
}
