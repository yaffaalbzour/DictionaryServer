package DictionaryServer;

import java.util.HashMap;
import java.util.Map;

public class Dictionary 
{
    private static final int WAITING = 0;
    private static final int SENDMEAN = 1;
    private static final int ANOTHER = 2;
    private int state = WAITING;
    
    private static Map<String, String> dictionary= new HashMap();;

    public String processInput(String wordToSearch) 
    {
        dictionary.put("dog", "type of animal");
        dictionary.put("trust","belief");dictionary.put("intelligent","clever");dictionary.put("rub","strok");
        dictionary.put("feed","give food to");dictionary.put("strange","foreign");dictionary.put("dangerous","unsafe");
        dictionary.put("land","ground");dictionary.put("adult","mature");dictionary.put("warning","caution");
        dictionary.put("deaf","unable to hear");dictionary.put("direction","way");dictionary.put("bee","insect");
        dictionary.put("blind","unable to see");
        
        String theOutput = null;
        String meaning ;

        switch (state)
        {
            case WAITING:
                theOutput = "Enter a word to find its meaning!";
                state = SENDMEAN;
                break;
                
            case SENDMEAN:
                if (dictionary.containsKey(wordToSearch)) 
                {
                    meaning=dictionary.get(wordToSearch.toLowerCase());////return this
                    theOutput = meaning+".Would you like to search for another word?[y/n]";
                    state = ANOTHER;
                    break;
                    } 
                else 
                {
                   theOutput = "Sorry, the dictionarry doesn't contain this word!!";
                    state = WAITING;
                   break;
               }  
                
                
            case ANOTHER:
                if (wordToSearch.equalsIgnoreCase("n")) 
                {
                    theOutput = "Bye.";break;
                } 
                else 
                {
                    theOutput = "Press Enter";
                    state = WAITING;break;
                    
                }   
                
                
            default:
                break;
        }
        return theOutput;
    }
}