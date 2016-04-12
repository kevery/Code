package proxy.ticketAgency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import proxy.ticketAgency.impl.Station;

/**
 * @author hxt
 */
public class StationProxy implements TicketService {
    private static Logger logger = LogManager.getLogger(StationProxy.class);
    private Station station;

    public StationProxy(Station station) {
        this.station = station;
    }

    @Override
    public void sellTicket() {
        logger.info("售票代理开始");
        station.sellTicket();
    }

    @Override
    public void inquire() {
        logger.info("查票代理开始");
        station.inquire();
    }

    @Override
    public void withdraw() {
        logger.info("退票代理开始");
        station.withdraw();
    }
}
