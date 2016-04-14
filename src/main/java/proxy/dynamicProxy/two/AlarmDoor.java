package proxy.dynamicProxy.two;

/**
 * Created by kever on 16/4/12.
 */
public class AlarmDoor implements Alarm,Door {
    @Override
    public void sound() {
        System.out.println("尖叫");
    }

    @Override
    public void open() {
        System.out.println("打开");
    }
}
