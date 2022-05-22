import java.util.*;
public class ScrambleParagraph
{
    private String scramble;
    public ScrambleParagraph(String word)
    {
        this.scramble = word;
    }
    // pre: a given word
    // post:String with length of 1,2,3 can't be scrambled
    public boolean canScramble(String word)
    {
        return word.length()>3;
    }

    /*
     * 
    This method takes in a single word and scrambles it, if is scramble-able.
    It returns the scrambled word.  
    Note: if there is any punctuation at the end of a sentence 
    such as a period, comma, question mark, or exclamation point, 
    then that stays at the end.  If the word is hyphenated, 
    then scramble it in parts but do NOT cross over the hypen.  
     * 
     * 
     */
    public String scrambleWord(String word)
    {        
        String s = "";
        if(canScramble(word)){
            ArrayList scramble = new ArrayList();
            for(int i = 1;i<word.length()-1;i++)
            {
                scramble.add(word.charAt(i));
            }
            Collections.shuffle(scramble);
            s+=word.charAt(0);//first doens't change
            Iterator itr = scramble.iterator();
            while(itr.hasNext())
            {
                s+=itr.next();
            }
            s+=word.charAt(word.length()-1); // last doesn't change
            return s;
        }else
        {
            return word;
        }
    }

    /*
     * This method calls srambleWord(w) continuously, where w is a word in the sentence.  
     * This method should return the sentence as a string when it is completely scrambled.
     * 
     */
    public String scrambleSentence(String sen)
    {
        String s = "";
        Scanner read = new Scanner(sen);
        // reading each word 
        while(read.hasNext())
        {
            String word = read.next();            
            s+=scrambleWord(word)+" ";
        }
        return s; // return scrambleSentence
    }

    /*
     * This method calls scrableSentence(s) continuously, 
     * where s is a sentence in the paragraph.  
     * This method should return the paragraph as a string when it is completely scrambled.
     * 
     */
    public String scrambleParagraph(String p)
    {
        String scramble ="";
        int index = 0;
        String sentence ="";
        
        Scanner read = new Scanner(p);        
        while(read.hasNext())
        {
            String word = read.next();
            sentence+=word+" ";
            index+=word.length()+1; //+1 is because including spaces(I assume spacing is 1)
            if(word.contains(".")||word.contains("?")||word.contains("!")||word.contains(","))
            {
                scramble+=scrambleSentence(sentence)+"\n"; 
                sentence="";
                p = p.substring(index); // get rid of the sentence that is already scrambled
                index = 0;
                read = new Scanner(p);
            }
        }
        return scramble;
    }

    public String toString()
    {
        return scramble;
    }
}
