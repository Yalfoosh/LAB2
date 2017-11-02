package hr.fer.oop.lab2.welcomepack;

import hr.fer.oop.lab2.welcomepack.PlayingPosition;

/**
 * Football team formation. E.g., F442 = 4 defenders, 4 midfielders, 2 forwards, 1 goalkeeper
 * 
 * @author OOP
 */

public enum Formation {

	F442(4, 4, 2), F352(3, 5, 2), F541(5, 4, 1);

	private int noDF;
	private int noMF;
	private int noFW;
	private final int noGK = 1;

	Formation(int noDF, int noMF, int noFW) {
		this.noDF = noDF;
		this.noMF = noMF;
		this.noFW = noFW;
	}

	public int getNoDF() {
		return noDF;
	}

	public int getNoFW() {
		return noFW;
	}

	public int getNoGK() {
		return noGK;
	}

	public int getNoMF() {
		return noMF;
	}
    
    public int[] getVector()
    {
        int[] toRet = new int[Constants.NUMBER_OF_POSITIONS];
        
        toRet[0] = 1;
        toRet[1] = noDF;
        toRet[2] = noMF;
        toRet[3] = noFW;
        
        return toRet;
    }
    
    public int formationIndex(PlayingPosition position)
    {
        switch(position)
        {
            case GK:
                return 0;
            case DF:
                return 1;
            case MF:
                return 2;
            case FW:
                return 3;
        }
        
        throw new IllegalArgumentException();
    }
}