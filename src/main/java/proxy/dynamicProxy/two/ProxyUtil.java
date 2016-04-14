package proxy.dynamicProxy.two;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by kever on 16/4/12.
 */
public class ProxyUtil {
    public static void generateClassFile(Class aClass,String className){
        byte[] bytes = ProxyGenerator.generateProxyClass(className,aClass.getInterfaces());
        String path = aClass.getResource("").getPath();
        OutputStream outputStream=null;
        try {
            outputStream = new FileOutputStream(path + className + ".class");
            outputStream.write(bytes);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
