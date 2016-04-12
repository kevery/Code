package IO;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.*;

/**
 * @author hxt
 */
public class IOTest {
    private static Logger logger = LogManager.getLogger(IOTest.class);
    @Test
    public void testInputStream() throws Exception {
//        File file = new File("new File(\"G:\\\\own\\\\Code\\\\test\\\\data.txt\")");
        File file = new File("target.txt");
        file.createNewFile();
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getName());
        InputStream inputStream1 = new FileInputStream(file);
        String canonicalPath = file.getCanonicalPath();
//        InputStream inputStream = new FileInputStream("G:\\own\\Code\\test\\data.txt");
        byte[] bytes = new byte[1024];
//        inputStream.read(bytes);

        OutputStream outputStream = new FileOutputStream("G:\\own\\Code\\test\\target.txt");
        try {
            outputStream.write(bytes);
        } finally {
            outputStream.flush();
            outputStream.close();
        }

    }

    @Test
    public void testClassLoader() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        logger.info(classLoader);
    }
}
