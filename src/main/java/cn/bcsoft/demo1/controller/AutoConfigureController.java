package cn.bcsoft.demo1.controller;

import com.bcsoft.autoconfig.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AutoConfigureController
 *
 * @author blackchen @ 2021/7/29 11:20
 * @version 1.0
 */
@RestController
public class AutoConfigureController {
    @Autowired
    HelloService helloService;

    @GetMapping("/say")
    public String sayHelloWorld () {
        System.out.println("进入方法");
        return helloService.sayHelloWorld("张三");
    }
}
