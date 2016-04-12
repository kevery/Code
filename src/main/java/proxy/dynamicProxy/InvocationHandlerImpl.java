package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hxt
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Object object;

    public InvocationHandlerImpl(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始");
        method.invoke(object, args);
        return null;
    }
}
