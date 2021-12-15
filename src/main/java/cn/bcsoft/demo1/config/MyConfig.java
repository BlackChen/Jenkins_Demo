package cn.bcsoft.demo1.config;

import com.bcsoft.autoconfig.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyConfig
 *
 * @author blackchen @ 2021/7/29 11:52
 * @version 1.0
 */
@Configuration
public class MyConfig {
    @Bean
    public HelloService helloService() {// 这里有了,就不加载starter里面了
        HelloService helloService = new HelloService();
        return helloService;

        // Test5

        // Test2

        // Test3
        
        // Test2
        
        // Test1

       
    }
}
