package cn.bcsoft.demo1.controller;

import cn.bcsoft.demo1.proxyaop.CGLibSubject;
import cn.bcsoft.demo1.proxyaop.ProxySubject;
import cn.bcsoft.demo1.proxyaop.RealSubject;
import cn.bcsoft.demo1.proxyaop.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

/**
 * AOPController
 *
 * @author blackchen @ 2020/12/3 16:05
 */
@RestController
public class AOPController {
    @RequestMapping(value = "/Curry")
    public void curry() {
        System.out.println("库里上场打球了！！");
    }

    @RequestMapping(value = "/Harden")
    public String harden (){
        System.out.println("哈登上场打球了！！");

        return "哈登上场打球了！！";
    }

    @RequestMapping(value = "/Antetokounmpo")
    public void antetokounmpo (){
        System.out.println("字母哥上场打球了！！");
    }

    @RequestMapping(value = "/Jokic")
    public void jokic (){
        System.out.println("约基奇上场打球了！！");
    }

    @RequestMapping(value = "/Durant/{point}")
    public void durant (@PathVariable("point")  int point){
        System.out.println("杜兰特上场打球了！！");
    }

    public static void main (String[] args) {
        // 通过Proxy. newProxyInstance生成了一个代理类，显然这个类是在Run-Time（运行时）生成的，
        // 也就是说，JDK动态代理中代理类的生成来自于Java反射机制的支撑。
        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(), new ProxySubject(new RealSubject()));

        subject.sayHello();

        //查看subject对象的类型
        System.out.println(subject.getClass().getName());

        //CGLib测试
        RealSubject sub = (RealSubject) new CGLibSubject().getProxy(RealSubject.class);
        sub.sayHello();

        System.out.println(sub.getClass().getName());

    }
}
