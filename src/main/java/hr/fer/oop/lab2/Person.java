package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import java.util.Objects;

/**
 * @author Miljenko
 */

public class Person
{
    private final String name;
    private final String country;
    private int emotion;

    public Person()
    {
        this.name = Constants.DEFAULT_PLAYER_NAME;
        this.country = Constants.DEFAULT_COUNTRY;
        this.emotion = Constants.DEFAULT_EMOTION;
    }
    
    public Person(String name, String country, int emotion)
    {
        if(name == null || name.isEmpty())
        {
            System.err.println("Varijabla <name> " + Constants.CANT_BE_NULL_OR_EMPTY);
            this.name = Constants.DEFAULT_PLAYER_NAME;
        }
        else
            this.name = name;
        
        if(country == null || country.isEmpty())
        {
            System.err.println("Varijabla <country> " + Constants.CANT_BE_NULL_OR_EMPTY);
            this.country = Constants.DEFAULT_COUNTRY;
        }
        else
            this.country = country;
        
        if(emotion < 0 || emotion > 100)
        {
            System.err.println("Varijable <emotion> " + Constants.IN_RANGE_OF + " " + 
                               Constants.Range(Constants.MIN_EMOTION, Constants.MAX_EMOTION));
            this.emotion = Constants.DEFAULT_EMOTION;
        }
        else
            this.emotion = emotion;
    }
    
    //--------------------------------------------------------------------------
    
    public String getName()
    {
        return name;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public int getEmotion()
    {
        //System.out.println("Emocije: " + emotion);
        return emotion;
    }
    
    
    
    public void setEmotion(int emotion)
    {
        if(emotion < 0 || emotion > 100)
            System.err.println("Varijable <emotion> " + Constants.IN_RANGE_OF + " " + 
                               Constants.Range(Constants.MIN_EMOTION, Constants.MAX_EMOTION));
        else
            this.emotion = emotion;
    }
    
    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Person)
            return ((Person)other).getName().equals(this.getName()) && ((Person)other).getCountry().equals(this.getCountry());
        else
            throw new IllegalArgumentException("Argument (other) ne pripada klasi <Person>.");
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.country);
        hash = 37 * hash + this.emotion;
        return hash;
    }
}