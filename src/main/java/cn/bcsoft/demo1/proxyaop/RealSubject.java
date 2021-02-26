package cn.bcsoft.demo1.proxyaop;

/**
 * RealSubject
 * 目标对象，即需要被代理的对象
 * @author blackchen @ 2020/12/3 16:56
 */
public class RealSubject implements Subject{
    public void sayHello() {
         System.out.println("hello world");
    }
}
