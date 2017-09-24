package knockknockserver;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static final int WAITING = 0;
    private static final int SENTWORD = 1;
    private static final int NEWWORD = 2;
    private static final int ANOTHER = 3;

    private int state = WAITING;
    private int currentJoke = 0;

    //private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
    private String[] newWords ;
    
    
    private static Map<String, String> dictionary= new HashMap();;

    public String processInput(String wordToSearch) 
    {
        dictionary.put("dog", "type of animal");
        dictionary.put("trust","belief");dictionary.put("intelligent","clever");dictionary.put("rub","strok");
        dictionary.put("feed","give food to");dictionary.put("strange","foreign");dictionary.put("dangerous","unsafe");
        dictionary.put("land","ground");dictionary.put("adult","mature");dictionary.put("warning","caution");
        dictionary.put("deaf","unable to hear");dictionary.put("direction","way");dictionary.put("bee","insrct");
        dictionary.put("blind","unable to see");
        
        String theOutput = null;
        String meaning = null;

        switch (state) {
            case WAITING:
                theOutput = "Hey, Enter a word to find its meaning!";
                state = SENTWORD;
                break;
            case SENTWORD:
                if (dictionary.containsKey(wordToSearch)) {
                    meaning=dictionary.get(wordToSearch);////return this
                    theOutput = "Would you like to search for another word?";
                    state = ANOTHER;
                    return meaning +"\n\t"+theOutput+"[y/n]";
                    
                } else {
                    theOutput = "Sorry, the dictionarry doesn't contain this word!!\nWould you like to add "
                            +wordToSearch+" to the dictionary[y/n]";
                    state = NEWWORD;
                    break;
                }   
            case NEWWORD: 
                if (wordToSearch.equalsIgnoreCase("y")) {
                    theOutput = "Enter the word's meaning: ";                   
                    state = SENTWORD;
                    break;
                } else {
                    theOutput = "Would you like to search for another word?";
                    state = ANOTHER;
                    
                }   break;
            
                //add the word to the dictionary
                
            case ANOTHER:
                if (wordToSearch.equalsIgnoreCase("y")) {
                    theOutput = "Hey again! Enter the word to search for";
                   
                    state = SENTWORD;
                    return theOutput;
                } else {
                    theOutput = "Bye.";
                    state = WAITING;
                }   break;
            
            default:
                break;
        }
        return theOutput;
    }
}