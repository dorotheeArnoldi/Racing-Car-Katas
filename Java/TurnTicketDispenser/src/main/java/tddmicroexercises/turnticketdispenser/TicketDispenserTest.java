package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicketDispenserTest {
	TicketDispenser tickDisp = new TicketDispenser();
	
	@Test
	public void turnTicketsFollowingASequenceRegardlessOfTheDispenser() throws Exception {
		int num = tickDisp.getTurnTicket().getTurnNumber();
		assertEquals(++num,tickDisp.getTurnTicket().getTurnNumber());
		assertEquals(++num,tickDisp.getTurnTicket().getTurnNumber());
		
		TicketDispenser tickDisp2 =  new TicketDispenser();
		assertEquals(++num,tickDisp2.getTurnTicket().getTurnNumber());
	}
	
	@Test
	public void turnTicketsFollowingASequenceRegardlessOfTheDispenserAgain() throws Exception {
		int num = tickDisp.getTurnTicket().getTurnNumber();

		assertEquals(++num,tickDisp.getTurnTicket().getTurnNumber());
		assertEquals(++num,tickDisp.getTurnTicket().getTurnNumber());
		
		TicketDispenser tickDisp2 =  new TicketDispenser();
		assertEquals(++num,tickDisp2.getTurnTicket().getTurnNumber());
	}
	
	@Test
	public void turnTicketsMock() throws Exception {
		TurnNumberSequence turnNumberSequence = new TurnNumberSequence() {
			@Override 
			public int getNextTurnNumberInstance() {
				return 4;
			}
		};
		TicketDispenser tickDisp3 = new TicketDispenser(turnNumberSequence);
		assertEquals(4, tickDisp3.getTurnTicket().getTurnNumber());
	}
	
}
