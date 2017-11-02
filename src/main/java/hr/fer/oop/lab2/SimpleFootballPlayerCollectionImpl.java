package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

/**
 * @author Miljenko
 */

public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection
{
    private FootballPlayer[] memory;
    private int Count;
    
    public SimpleFootballPlayerCollectionImpl()
    {
        memory = new FootballPlayer[Constants.INITIAL_FOOTBALL_COLLECTION_SIZE];
        Count = 0;
    }
    
    public SimpleFootballPlayerCollectionImpl(int size)
    {
        if(size < 1)
            throw new IllegalArgumentException("Velicina kolekcije mora biti prirodan broj.");
        else
        {
            memory = new FootballPlayer[size];
            Count = 0;
        }
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public int size()
    {
        return Count;
    }

    @Override
    public boolean contains(FootballPlayer player)
    {
        for(FootballPlayer t : memory)
            if(t != null && ((Person)t).equals((Person)player))
                return true;
        
        return false;
    }

    @Override
    public boolean add(FootballPlayer player)
    {
        if(Count == memory.length || this.contains(player))
            return false;
        
        memory[Count++] = player;
        return true;
    }

    @Override
    public void clear()
    {
        memory = new FootballPlayer[memory.length];
        Count = 0;
    }

    @Override
    public int getMaxSize()
    {
        return memory.length;
    }

    @Override
    public int calculateEmotionSum()
    {
        long sum = 0;
        
        for(FootballPlayer t : memory)
            if(t != null)
                sum += t.getEmotion();
        
        if(sum > Integer.MAX_VALUE)
            System.err.println("Kolicina emocija (" + sum + ") veca je od maksimuma kojeg metoda moze vratiti.");
        else if(sum < 0)
            System.err.println("Kolicina emocija toliko je velika da se ne moze pohraniti ni u longu.");
        
        return (int)(sum & Constants.FIRST_32_BITS);
    }

    @Override
    public int calculateSkillSum()
    {
        long sum = 0;
        
        for(FootballPlayer t : memory)
            if(t != null)
                sum += t.getPlayingSkill();
        
        if(sum > Integer.MAX_VALUE)
            System.err.println("Kolicina iskusnosti (" + sum + ") veca je od maksimuma kojeg metoda moze vratiti.");
        else if(sum < 0)
            System.err.println("Kolicina iskusnosti toliko je velika da se ne moze pohraniti ni u longu.");
        
        return (int)(sum & Constants.FIRST_32_BITS);
    }

    @Override
    public FootballPlayer[] getPlayers()
    {
        return java.util.Arrays.copyOfRange(memory, 0, Count);
    }
}
