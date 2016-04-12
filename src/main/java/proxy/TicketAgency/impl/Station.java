package proxy.ticketAgency.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import proxy.ticketAgency.TicketService;

/**
 * @author hxt
 */
public class Station implements TicketService {
    private Logger logger = LogManager.getLogger(Station.class);

    @Override
    public void sellTicket() {
        logger.info("售票");
    }

    @Override
    public void inquire() {
        logger.info("查询");
    }

    @Override
    public void withdraw() {
        logger.info("退票");
    }
}
