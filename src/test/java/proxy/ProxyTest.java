package proxy;

import org.junit.Test;

import proxy.dynamicProxy.one.InvocationHandlerImpl;
import proxy.dynamicProxy.one.Subject;
import proxy.dynamicProxy.one.SubjectImpl;
import proxy.dynamicProxy.two.AlarmDoor;
import proxy.dynamicProxy.two.ProxyUtil;
import proxy.ticketAgency.StationProxy;
import proxy.ticketAgency.TicketService;
import proxy.ticketAgency.impl.Station;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author hxt
 */
public class ProxyTest {
    @Test
    public void testStationProxy() throws Exception {
        TicketService ticketService = new StationProxy(new Station());
        ticketService.sellTicket();

    }

    @Test
    public void testDynamic() throws Exception {
        TicketService station = new Station();
        InvocationHandler invocationHandler = new InvocationHandlerImpl(station);
        TicketService stationProxy = (TicketService) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), station.getClass().getInterfaces(), invocationHandler);
        System.out.println(stationProxy.getClass().getName());
        stationProxy.sellTicket();
        ClassLoader classLoader = invocationHandler.getClass().getClassLoader();
        System.out.println(classLoader);

    }

    @Test
    public void testSub() throws Exception {
        proxy.dynamicProxy.one.Subject subject = new SubjectImpl();
//        subject.search();
        InvocationHandler invocationHandler = new InvocationHandlerImpl(subject);
        Subject subjectProxy = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), invocationHandler);
        subjectProxy.search();

    }

    @Test
    public void testGetClass() throws Exception {
        AlarmDoor alarmDoor = new AlarmDoor();
//        ClassLoader classLoader = alarmDoor.getClass().getClassLoader();
//        Class<?>[] interfaces = alarmDoor.getClass().getInterfaces();
//        InvocationHandler invocationHandler = new InvocationHandlerImpl(alarmDoor);
        ProxyUtil.generateClassFile(alarmDoor.getClass(),"alertP");
    }
}
