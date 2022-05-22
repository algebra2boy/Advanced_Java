package Polygon;

public class Isoscelese extends Scalene
{  

    // Constructors
    public Isoscelese()
    {
        super();
    }

    public Isoscelese(double base,double height)
    {
        super(base,height);
    }

    // Overide abstract method    
    public String getMyType()
    {
        return "Isoscelese";
    }
    public String toString()
    {
        return "Isoscelese and I am also a " + super.toString();
    }
}