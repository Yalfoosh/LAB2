package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;
import hr.fer.oop.lab2.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

/**
 * @author Miljenko
 */

public class ClubTeam extends Team implements ManageableTeam
{
    private int reputation;
    
    public ClubTeam()
    {
        super();
        
        reputation = Constants.DEFAULT_REPUTATION;
        registeredPlayers = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
    }
    
    public ClubTeam(String name, Formation formation, int reputation)
    {
        super(name, formation);
        
        if(reputation < 0 || reputation > 100)
        {
            this.reputation = Constants.DEFAULT_REPUTATION;
            System.err.println("Varijable <reputation> " + Constants.IN_RANGE_OF + " " + Constants.Range(Constants.MIN_REPUTATION, Constants.MAX_REPUTATION));
        }
        else
            this.reputation = reputation;
        
        registeredPlayers = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
    }
    
    //--------------------------------------------------------------------------
    
    public int getReputation()
    {
        return reputation;
    }
    
    
    
    public void setReputation(int reputation)
    {
        
        if(reputation < 0 || reputation > 100)
            System.err.println("Varijable <reputation> " + Constants.IN_RANGE_OF + " " + Constants.Range(Constants.MIN_REPUTATION, Constants.MAX_REPUTATION));
        else
            this.reputation = reputation;
    }
    
    
    
    public boolean isSkillfulEnough(FootballPlayer player)
    {
        return player.getPlayingSkill() >= reputation;
    }

    @Override
    public boolean addPlayerToStartingEleven(FootballPlayer player)
    {
        return registeredPlayers.contains(player) ? startingEleven.add(player) : false;
    }

    @Override
    public boolean isPlayerRegistered(FootballPlayer player)
    {
        return registeredPlayers.contains(player);
    }

    @Override
    public SimpleFootballPlayerCollection getRegisteredPlayers()
    {
        if(registeredPlayers == null || registeredPlayers.size() == 0)
        {
            System.err.println("Varijabla <registeredPlayers> je prazna.");
            return null;
        }
        else
            return registeredPlayers;
    }

    @Override
    public SimpleFootballPlayerCollection getStartingEleven()
    {
        if(startingEleven == null || startingEleven.size() == 0)
        {
            System.err.println("Varijabla <startingEleven> je prazna.");
            return null;
        }
        else
            return startingEleven;
    }

    @Override
    public boolean registerPlayer(FootballPlayer player)
    {
        return isSkillfulEnough(player) ? registeredPlayers.add(player) : false;
    }

    @Override
    public void clearStartingEleven()
    {
        startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
    }

    @Override
    public double calculateRating()
    {
        return Constants.THIRTY_PERCENT * registeredPlayers.calculateEmotionSum() + 
               Constants.SEVENTY_PERCENT * registeredPlayers.calculateSkillSum();
    }
}
