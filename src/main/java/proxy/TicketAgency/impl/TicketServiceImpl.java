package proxy.TicketAgency.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import proxy.TicketAgency.TicketService;

/**
 * @author hxt
 */
public class TicketServiceImpl implements TicketService {
    private Logger logger = LogManager.getLogger(TicketServiceImpl.class);

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
