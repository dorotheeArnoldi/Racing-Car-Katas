package tddmicroexercises.turnticketdispenser;

import java.util.function.IntSupplier;

public class TicketDispenser
{

    private IntSupplier intSupplier;

    public TicketDispenser(IntSupplier intSupplier) {
        this.intSupplier = intSupplier;
    }

    public TicketDispenser() {
        this(TurnNumberSequence::getNextTurnNumber);
    }

    public TurnTicket getTurnTicket() {
        int newTurnNumber = this.intSupplier.getAsInt();
        return getTurnTicket(newTurnNumber);
    }

    TurnTicket getTurnTicket(int newTurnNumber) {
        return new TurnTicket(newTurnNumber);
    }
}
