/**
 *  Person_Comparable_Dates_CLIENT:
 * Mr. Marques
 * 
 * This program will help you to understand how the interface Comparable works.
 * Remember, it is a Java "built-in" interface that has one and only one method 
 * that you MUST override.  
 *      
 *          It is ALWAYS of the form:
 *          
 *             public int compareTo(Object x) // It ALWAYS takes in an 'Object' and
 *                                            // returns an 'int'. ALWAYS!!!
 *                                            // Remember this!!
 * 
 *   This program will have you write a Person_Comparable_Dates class that creates an ArrayList called 'people' 
 *   that holds the type 'Person_Comparable_Dates'.  A 'Person_Comparable_Dates' has a firstName and lastName as well as it hasA
 *   Date class that holds the Person_Comparable_Datess birthdate.  
 *   
 *   Your task:  Find the youngest and oldest Person_Comparable_Dates in the ArrayList 'people'. Create the 
 *   'Person_Comparable_Dates' class and have it "implement" Comparable.  Thus, you have to write the compareTo()
 *   method for Person_Comparable_Dates that compares each 'Person_Comparable_Dates' first by year, then month, then day.
 *   
OutPut:

The list of people are: 
[George Washington(2/22/1732), Paul Marques(3/27/1969), Kermit The Frog(9/27/1976), SquarePants SpongeBob(5/1/1999), Charlie Brown(10/3/1950), Rocky Horror(8/14/1975), Moses RedSea(4/3/-2345), Isaac Newton(1/4/1643), William Shakespeare(4/26/1564), Oprah Winfrey(1/29/1954)]

The oldest Person_Comparable_Dates: Moses RedSea(4/3/-2345)

The youngest Person_Comparable_Dates: SquarePants SpongeBob(5/1/1999)

 */

import java.util.*;
public class Person_Comparable_Dates_CLIENT_SHELL
{

    public static void main()
    {
        ArrayList<Person_Comparable_Dates> people = new ArrayList<Person_Comparable_Dates>();
        Person_Comparable_Dates theOldest, theYoungest;

        people.add(new Person_Comparable_Dates("George","Washington", 2, 22, 1732));
        people.add(new Person_Comparable_Dates("Paul","Marques",3,27,1969));
        people.add(new Person_Comparable_Dates("Kermit","The Frog",9,27,1976));
        people.add(new Person_Comparable_Dates("SquarePants","SpongeBob",5,1,1999));
        people.add(new Person_Comparable_Dates("Charlie","Brown",10,3,1950));
        people.add(new Person_Comparable_Dates("Rocky","Horror",8,14,1975));
        people.add(new Person_Comparable_Dates("Moses","RedSea",4,3,-2345));
        people.add(new Person_Comparable_Dates("Isaac","Newton",1,4,1643));
        people.add(new Person_Comparable_Dates("William","Shakespeare",4,26,1564));
        people.add(new Person_Comparable_Dates("Oprah","Winfrey",1,29,1954));

        theOldest = findOldest(people);
        theYoungest = findYoungest(people);

        System.out.println("The list of people are: \n" + people + "\n");        
        System.out.println(" The oldest Person_Comparable_Dates: " + theOldest + "\n");
        System.out.println(" The youngest Person_Comparable_Dates: " + theYoungest);

    } // main

    public static Person_Comparable_Dates findOldest(ArrayList<Person_Comparable_Dates> Person_Comparable_DatesList)
    {
        Person_Comparable_Dates Oldest = Person_Comparable_DatesList.get(0);
        for(int i = 1; i<Person_Comparable_DatesList.size();i++)
        {
            if(Oldest.compareTo(Person_Comparable_DatesList.get(i))>0)
            {
                Oldest = Person_Comparable_DatesList.get(i);
            }
        }
        return Oldest;         
    } // findOldest

    public static Person_Comparable_Dates findYoungest(ArrayList<Person_Comparable_Dates> Person_Comparable_DatesList)
    {
        Person_Comparable_Dates Youngest = Person_Comparable_DatesList.get(0);
        for(int i = 1; i<Person_Comparable_DatesList.size();i++)
        {
            if(Youngest.compareTo(Person_Comparable_DatesList.get(i))<0)
            {
                Youngest = Person_Comparable_DatesList.get(i);
            }
        }
        return Youngest;    

    } // findYoungest

}

