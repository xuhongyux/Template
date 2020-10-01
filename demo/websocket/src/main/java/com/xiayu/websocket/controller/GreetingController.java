package com.xiayu.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/3/15 11:56
 */
@Controller
public class GreetingController {

    // MessageMapping   专门来处理Stomp 的请求     配置代理的URL
    @MessageMapping("/hello")
    //SendTo 处理消息监听的代理   给前端返回消息
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //spring提供的发送消息模板
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    /**
     * 单独聊天请求
     */
    @MessageMapping(value = "/along")
    public void along(HelloMessage message) {
        System.out.println(message.getName());

        Response response = new Response();
        response.setName("我真的爱死你了");
        response.setMessage("你好啊"+ message.getName());
        /**
         *   如上，这里虽然我还是用了认证的信息得到用户名。但是，其实大可不必这样，因为 convertAndSendToUser 方法可以指定要发送给哪个用户。
         *   也就是说，完全可以把用户名的当作一个参数传递给控制器方法，从而绕过身份认证！convertAndSendToUser
         *   方法最终会把消息发送到 /user/第一个参数/第二个参数    目的地上。
         */
        //发送到订阅的 /queue
        messagingTemplate.convertAndSendToUser(message.getName(),"/queue/alone",response);


        //messagingTemplate.convertAndSendToUser(user.getName(), "/queue/shouts", shout);

    }

}
