package IO;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * @author hxt
 */
public class IOTest {
    private static Logger logger = LogManager.getLogger(IOTest.class);

    @Test
    public void testInputStream() throws Exception {
//        File file = new File("new File(\"G:\\\\own\\\\Code\\\\test\\\\data.txt\")");
        String systemResource = ClassLoader.getSystemResource("").getPath();
        System.out.println(systemResource);
        File file = new File(systemResource + "target.txt");
        logger.info(file.getCanonicalPath());
        logger.info(file.getName());
        InputStream inputStream1 = new FileInputStream(file);
        String canonicalPath = file.getCanonicalPath();
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
//        inputStream.read(bytes);

        OutputStream outputStream = new FileOutputStream(file);
        try {
            outputStream.write(bytes);
        } finally {
            outputStream.flush();
            outputStream.close();
        }

    }

    @Test
    public void testClassLoader() throws Exception {

    }

}
