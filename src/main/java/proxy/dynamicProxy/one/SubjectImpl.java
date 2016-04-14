package proxy.dynamicProxy.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by kever on 16/4/12.
 */
public class SubjectImpl implements Subject {
    private static Logger logger = LogManager.getLogger();
    @Override
    public void search() {
        System.out.println("search");
    }

    @Override
    public void buy() {
        System.out.println("buy");
    }
}
