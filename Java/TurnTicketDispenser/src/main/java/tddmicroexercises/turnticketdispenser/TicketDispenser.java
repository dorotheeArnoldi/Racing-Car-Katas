package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
	
	private TurnNumberSequence sequence;
	
	public TicketDispenser() {
		this(new TurnNumberSequence());
	}
	
		
	TicketDispenser(TurnNumberSequence sequence) {
		this.sequence = sequence;
	}
	
	
	public TurnTicket getTurnTicket()
    {
		   int newTurnNumber = sequence.getNextTurnNumberInstance();
	        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);
	        return newTurnTicket;
    }

}
