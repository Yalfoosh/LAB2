package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;
import hr.fer.oop.lab2.welcomepack.Manager;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

/**
 * @author Miljenko
 */

public class Coach extends Person implements Manager
{
    private int coachingSkill;
    private Formation formation;
    ManageableTeam managingTeam;
    
    public Coach()
    {
        super();
        
        coachingSkill = Constants.DEFAULT_COACHING_SKILL;
        formation = Constants.DEFAULT_FORMATION;
    }
    
    public Coach(String name, String country, int emotion, int coachingSkill, Formation formation)
    {
        super(name, country, emotion);
        
        
        if(coachingSkill < 0 || coachingSkill > 100)
        {
            this.coachingSkill = Constants.DEFAULT_PLAYING_SKILL;
            
            System.err.println("Varijabla <coachingSkill> " + Constants.IN_RANGE_OF + " " + 
                               Constants.Range(Constants.MIN_COACHING_SKILL, Constants.MAX_COACHING_SKILL));
        }
        else
            this.coachingSkill = coachingSkill;
        
        if(formation == null)
        {
            this.formation = Constants.DEFAULT_FORMATION;
            
            System.err.println("Varijabla <formation> " + Constants.CANT_BE_NULL_OR_EMPTY);
        }
        else
            this.formation = formation;
    }
    
    //--------------------------------------------------------------------------
    
    public int getCoachingSkill()
    {
        return coachingSkill;
    }
    
    public Formation getFormation()
    {
        return formation;
    }
    
    
    
    public void setCoachingSkill(int coachingSkill)
    {
        if(coachingSkill < 0 || coachingSkill > 100)
            System.err.println("Varijable <coachingSkill> " + Constants.IN_RANGE_OF + " " + 
                               Constants.Range(Constants.MIN_COACHING_SKILL, Constants.MAX_COACHING_SKILL));
        else
            this.coachingSkill = coachingSkill;
    }
    
    public void setFormation(Formation formation)
    {
        if(formation == null)
            System.err.println("Varijabla <formation> " + Constants.CANT_BE_NULL_OR_EMPTY);
        else
            this.formation = formation;
    }

    @Override
    public void pickStartingEleven()
    {
        if(managingTeam.getStartingEleven() != null && managingTeam.getStartingEleven().size() > 0)
            managingTeam.getStartingEleven().clear();
        
        FootballPlayer[] players = managingTeam.getRegisteredPlayers().getPlayers();
        Formation form = managingTeam.getFormation();
        
        int[] number = managingTeam.getFormation().getVector();
        
        for(int i = 0; i < players.length && i < Constants.STARTING_ELEVEN_SIZE; ++i)
        {
            if(number[form.formationIndex(players[i].getPlayingPosition())]-- > 0)
                managingTeam.addPlayerToStartingEleven(players[i]);
        }
    }

    @Override
    public void forceMyFormation()
    {
        managingTeam.setFormation(formation);
    }

    @Override
    public void setManagingTeam(ManageableTeam team)
    {
        if(team != null)
            managingTeam = team;
        else
            System.err.println("Varijable <tim> " + Constants.CANT_BE_NULL_OR_EMPTY + ".");
    }
}
