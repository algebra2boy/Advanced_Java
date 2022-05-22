
// ==============================================

/**
 * Person_Comparable_Dates class does the following:
 * 
 *  (1) implements "Comparable" and thus, YOU write the "compareTo()" method.
 *                    Rem:  public int compareTo(Object x)
 *                    
 *  (2) has the needed instance variables: myFirstName & myLastName of type String,
 *                                         myBirthDate of type Date (Compositioned inside of Person
 *                                                                   in other words, Person "hasA" Date)  
 *  (3) has the needed constructors: default and regular that takes in 2 Strings for the name &
 *                                   3 ints for the Date object.
 *                                   
 *  (4) has getMyBirthDate() that returns the Person's myBirthDate. 
 *  
 *  (5) has a toString() method
 *  
 */
public class Person_Comparable_Dates extends Date implements Comparable<Date>
{
    private String firstName, lastName;
    private Date myBirthDate;
    public Person_Comparable_Dates()
    {
        this("","",0,0,0);
    }
    public Person_Comparable_Dates(String myFirstName, String myLastName,int month, int day,int year)
    {
        super(month,day,year);
        this.firstName = myFirstName;
        this.lastName = myLastName;
    }
    public Date getMyBirthDate()
    {
        return myBirthDate;
    }
    public String toString()
    {
        return firstName +","+ lastName +" Date of Birth:"+super.toString();
    }
    public int compareTo(Date other)
    {
       if(this.getYear()!=other.getYear())
       {
           return this.getYear()-other.getYear();
       }else //same year
       {
           //compare month
           if(this.getMonth()!=other.getMonth())
           {
               return this.getMonth()-other.getMonth();  
           }else
           {
               return this.getDay() - other.getDay();
           }
       }   
    }
}


// ======================================================================

