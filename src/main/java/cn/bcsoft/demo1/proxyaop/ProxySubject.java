package cn.bcsoft.demo1.proxyaop;

import javafx.beans.InvalidationListener;
import net.sf.cglib.proxy.Enhancer;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ProxySubject
 * 在不更改原有代码逻辑的基础上增强该类的sayHello方法，
 * 利用JDK动态代理技术需要我们实现InvocationHandler接口中的invoke方法：
 * @author blackchen @ 2020/12/3 16:58
 */
public class ProxySubject implements InvocationHandler {//JDK动态代理需要实现 InvocationHandler类
    /**
     * 用于判断目标对象实现的接口是否定义了equals方法
     * 如果我们需要Spring AOP增强equals或hashCode方法则必须要在其目标对象的实现接口定义equals或hashCode方法。
     */
    private boolean equalsDefined;
    /**
     * 用于判断目标对象实现的接口是否定义了hashCode方法
     */
    private boolean hashCodeDefined;

    private Object target;

    public ProxySubject(Object target){
        this.target = target;
    }

    public ProxySubject () {

    }

    /**
     *
     * @param proxy 代理的那个真实的对象；
     * @param method 代理的那个真实对象的某个方法的Method对象；
     * @param args 调用那个真实对象方法的参数。
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object [] args) throws Throwable{
        

        System.out.println("调用前");
        //在invoke方法中可以看到，在调用目标对象的方法前后我们对方法进行了增加，
        // 这其实就是AOP中Before和After通知的奥义所在。
        Object o = method.invoke(target, args);
        System.out.println("调用后");
        return o;
    }


}
