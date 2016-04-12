package proxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/**
 * Created by hxt on 2016/4/6.
 */
public class Programmer {
    public void code() {
        System.out.println("just coding");
    }

    public void code(String name) {
        System.out.println(name + "just coding");
    }

    public static void main(String[] args) throws IOException {
        URL systemResource1 = ClassLoader.getSystemResource("/");
        System.out.println(systemResource1);
        URL systemResource = ClassLoader.getSystemResource("");
        System.out.println(systemResource);
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("target.txt");
        byte[] bytes = new byte[1024];
        systemResourceAsStream.read(bytes);
        for (byte aByte : bytes) {
            System.out.print((char)aByte);
        }
    }
}
