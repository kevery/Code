package proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * Created by hxt on 2016/4/6.
 */
public class MyGenerator {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass aDefault = classPool.makeClass("Default");
        CtMethod method = CtNewMethod.make("public void code(){}", aDefault);
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        aDefault.addMethod(method);
        aDefault.writeFile("G:\\own\\Code\\out\\production\\Code\\proxy");
    }
}
