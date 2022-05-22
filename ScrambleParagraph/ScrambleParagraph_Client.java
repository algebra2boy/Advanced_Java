public class ScrambleParagraph_Client
{
    public static void main()
    {
        String s = "According to a research at an English University,\n" +
        "it does not matter in what order the letters in a word are,\n" +
        "the only important thing is that the first and last letter is at the right place.\n" +
        "The rest can be a total mess and you can still read it without a problem.\n"+
        "This is becuase we do not read every letter by itself, but the word as-a-whole!\n";
              // s="Hello, what is going. Bro! ere.";
        ScrambleParagraph w = new ScrambleParagraph(s);
        System.out.println(s+"\n\n");
        System.out.println(w.scrambleParagraph(s));
        System.out.println(w.scrambleParagraph(s));
    }
}
