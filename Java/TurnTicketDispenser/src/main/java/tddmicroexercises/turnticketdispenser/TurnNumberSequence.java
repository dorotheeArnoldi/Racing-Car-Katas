package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence
{
    private static int _turnNumber = 0;

    @Deprecated
    public static int getNextTurnNumber()
    {
        return _turnNumber++;
    }
    
    public int getNextTurnNumberInstance() {
    	return _turnNumber++;
    }
}
