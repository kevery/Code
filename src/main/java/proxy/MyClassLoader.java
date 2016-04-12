package proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hxt on 2016/4/6.
 */
public class MyClassLoader extends ClassLoader {
    public Class<?> defineMyClass(String name, byte[] b, int off, int len) {
        return super.defineClass(name, b, off, len);
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //从class文件读字节流至byte数组
        String canonicalPath = new File("").getCanonicalPath();
        FileInputStream fileInputStream = new FileInputStream(new File(canonicalPath + "\\out\\production\\Code\\Proxy\\Programmer.class"));
        byte[] bytes = new byte[1024];
        int read = fileInputStream.read(bytes);

        //从byte数组加载类
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> myClass = myClassLoader.defineMyClass(null, bytes, 0, read);
        String canonicalName = myClass.getCanonicalName();
        Object instance = myClass.newInstance();

        //反射调用无参方法
        Method code = myClass.getMethod("code");
        code.invoke(instance);

        //反射调用有参方法
        Method codeStr = myClass.getMethod("code", String.class);
        codeStr.invoke(instance, "kever");

    }
}
