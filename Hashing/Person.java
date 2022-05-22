 

public class Person
{
    String myName;

    Person() {}

    Person(String name)
    {
        myName = name;
    }

    public String toString()
    {
        return myName;
    }

    public int hashCode()
    {
        return super.hashCode();
    }

}