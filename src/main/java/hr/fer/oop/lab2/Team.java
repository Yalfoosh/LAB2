package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;
import hr.fer.oop.lab2.SimpleFootballPlayerCollectionImpl;

/**
 * @author Miljenko
 */
public class Team 
{
    private final String name;
    private Formation formation;
    protected SimpleFootballPlayerCollection registeredPlayers, startingEleven;
    
    public Team()
    {
        name = Constants.DEFAULT_TEAM_NAME;
        formation = Constants.DEFAULT_FORMATION;
        startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
    }
    
    public Team(String name, Formation formation)
    {
        if(name == null || name.isEmpty())
        {
            this.name = Constants.DEFAULT_TEAM_NAME;
            System.err.println("Varijabla <name> " + Constants.CANT_BE_NULL_OR_EMPTY + ".");
        }
        else
            this.name = name;
        
        if(formation == null)
        {
            this.formation = Constants.DEFAULT_FORMATION;
            System.err.println("Varijable <formation> " + Constants.CANT_BE_NULL_OR_EMPTY + ".");
        }
        else
            this.formation = formation;
        
        startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
    }
    
    //--------------------------------------------------------------------------
    
    public String getName()
    {
        return name;
    }
    
    public Formation getFormation()
    {
        return formation;
    }
    
    
    
    public void setFormation(Formation formation)
    {
        if(formation == null)
            System.err.println("Varijabla <formation> " + Constants.CANT_BE_NULL_OR_EMPTY + ".");
        else
            this.formation = formation;
    }
}