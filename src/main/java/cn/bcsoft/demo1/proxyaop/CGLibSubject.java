package cn.bcsoft.demo1.proxyaop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLibSubject
 *  CGLib代理
 * @author blackchen @ 2020/12/4 10:32
 */
public class CGLibSubject implements MethodInterceptor {
    //
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);//设置需要代理的类
        enhancer.setCallback(this);//设置回调方法
        //用于创建无参的目标对象代理类，
        // 对于有参构造器则调用Enhancer.create(Class[] argumentTypes, Object[] arguments)，第一个参数表示参数类型，第二个参数表示参数的值。
        return enhancer.create();
    }

    @Override
    public Object intercept (Object object, Method method, Object [] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib调用前");
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("CGLib调用后");

        return result;
    }
}
