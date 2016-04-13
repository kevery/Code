package proxy;

import org.junit.Test;
import proxy.dynamicProxy.InvocationHandlerImpl;
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
}
