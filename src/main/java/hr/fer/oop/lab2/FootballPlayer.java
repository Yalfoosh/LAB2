package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.welcomepack.Constants;
import java.util.Objects;

/**
 * @author Miljenko
 */

public class FootballPlayer extends Person
{
    private int playingSkill;
    private PlayingPosition playingPosition;
    
    public FootballPlayer()
    {
        super();
        
        playingSkill = Constants.DEFAULT_PLAYING_SKILL;
        playingPosition = Constants.DEFAULT_PLAYING_POSITION;
    }
    
    public FootballPlayer(String name, String country, int emotion, int playingSkill, PlayingPosition playingPosition)
    {
        super(name, country, emotion);
        
        if(playingSkill < 0 || playingSkill > 100)
        {
            this.playingSkill = Constants.DEFAULT_PLAYING_SKILL;
            
            System.err.println("Varijabla <playingSkill> " + Constants.IN_RANGE_OF + " " + 
                               Constants.Range(Constants.MIN_PLAYING_SKILL, Constants.MAX_PLAYING_SKILL) + ".");
        }
        else
            this.playingSkill = playingSkill;
        
        if(playingPosition == null)
        {
            this.playingPosition = Constants.DEFAULT_PLAYING_POSITION;
            
            System.err.println("Varijabla <playingSkill> " + Constants.CANT_BE_NULL_OR_EMPTY + ".");
        }
        else
            this.playingPosition = playingPosition;
    }
    
    //--------------------------------------------------------------------------
    
    public int getPlayingSkill()
    {
        return playingSkill;
    }
    
    public PlayingPosition getPlayingPosition()
    {
        return playingPosition;
    }
    

    
    public void setPlayingSkill(int playingSkill)
    {
        if(playingSkill < 0 || playingSkill > 100)
            System.err.println("Varijable <playingSkill> " + Constants.IN_RANGE_OF + " " + 
                               Constants.Range(Constants.MIN_PLAYING_SKILL, Constants.MAX_PLAYING_SKILL) + ".");
        else
            this.playingSkill = playingSkill;
    }
    
    public void setPlayingPosition(PlayingPosition playingPosition)
    {
        if(playingPosition == null)
            System.err.println("Varijabla <playingPosition> " + Constants.CANT_BE_NULL_OR_EMPTY + ".");
        else
            this.playingPosition = playingPosition;
    }
    
    @Override
    public boolean equals(Object player)
    {
        if(player.getClass() == FootballPlayer.class)
        return ((FootballPlayer)player).getName().equals(this.getName()) &&
               ((FootballPlayer)player).getCountry().equals(this.getCountry());
        else
            throw new IllegalArgumentException("Argument (other) ne pripada klasi <FootballPlayer>.");
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 29 * hash + this.playingSkill;
        hash = 29 * hash + Objects.hashCode(this.playingPosition);
        return hash;
    }
}