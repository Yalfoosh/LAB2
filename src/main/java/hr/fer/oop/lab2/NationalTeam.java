package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;
import hr.fer.oop.lab2.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

/**
 * @author Miljenko
 */

public class NationalTeam extends Team implements ManageableTeam
{
    private final String country;
    
    public NationalTeam()
    {
        super();
        
        country = Constants.DEFAULT_COUNTRY;
        registeredPlayers = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_NATIONAL);
    }
    
    public NationalTeam(String name, Formation formation, String country)
    {
        super(name, formation);
        
        this.country = country;
        registeredPlayers = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_NATIONAL);
    }
    
    //--------------------------------------------------------------------------
    
    public String getCountry()
    {
        return country;
    }
    
    
    
    public boolean isDomestic(FootballPlayer player)
    {
        return player.getCountry().equals(country);
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
    public boolean registerPlayer(FootballPlayer player)
    {
        return isDomestic(player) ? registeredPlayers.add(player) : false;
    }

    @Override
    public void clearStartingEleven()
    {
        startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
    }

    @Override
    public double calculateRating()
    {
        return Constants.THIRTY_PERCENT * registeredPlayers.calculateSkillSum() + 
               Constants.SEVENTY_PERCENT * registeredPlayers.calculateEmotionSum();
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
}