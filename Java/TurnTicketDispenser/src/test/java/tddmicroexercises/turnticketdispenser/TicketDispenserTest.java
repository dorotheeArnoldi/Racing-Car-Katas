package tddmicroexercises.turnticketdispenser;

import junit.framework.Assert;
import org.junit.Test;

public class TicketDispenserTest {

    @Test
    public void dispensesATurnTicket() {
        TicketDispenser ticketDispenser = new TicketDispenser();
        Assert.assertEquals(ticketDispenser.getTurnTicket(2).getTurnNumber(), new TurnTicket(2).getTurnNumber());
    }

    @Test
    public void dispensesATurnTicketUsingAIntSupplier() {
        TicketDispenser ticketDispenser = new TicketDispenser(() -> 5);

        Assert.assertEquals(ticketDispenser.getTurnTicket().getTurnNumber(), new TurnTicket(5).getTurnNumber());

    }
}