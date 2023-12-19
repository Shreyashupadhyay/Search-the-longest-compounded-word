import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.io.IOException;


//   TrieNode class represents a node in the Trie data structure
class Tries{
    char ch;
    Tries[] child;
    boolean Ended;
    // Constructor to initialize a TrieNode
    Tries(char ch){
        this.ch=ch;
        this.child = new Tries[26];
        this.Ended=false;
    }
}

// Answer class contains methods for processing an array of words using the Trie data structure
class Answer {

    // Method to check if a given string is part of a compound word
    public boolean isFinalEnded(Tries root,String str,boolean isSecond){
        Tries temp=root;
        boolean result=false;
        int count=0;
        // Iterate through characters of the string
        for(char ch:str.toCharArray()){
            count++;
            if(temp.child[ch-'a']==null)
                return false; // If the character is not found in Trie, the word is not part of any compound word
            temp=temp.child[ch-'a'];
            if(temp.Ended ) {
                if(str.length()>count) // If the end of a word is reached in Trie
                    result =result|| isFinalEnded(root, str.substring(count), false);
                else
                    result=true; // The entire string is part of a compound word
            }
            if(result)
                return true; // If the result is already true, return true

        }
        return result;
    }

    // Method to add a string to the Trie

    public void addingStringinsideTries(Tries root,String str){
        Tries temp = root;
        for(char ch:str.toCharArray()){
            if(temp.child[ch-'a']==null){
                temp.child[ch-'a']=new Tries(ch);
            }
            temp=temp.child[ch-'a'];
        }
        temp.Ended=true;
    }

    // Method to get all words in the dictionary and identify compound words
    public ArrayList<String> getAllthewordsinDectionary(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        Arrays.sort(words,(String a,String b)->a.length()-b.length());

        // Initialize the Trie root
        Tries root=new Tries('*');

        for(String word:words){ //  // Iterate through sorted words
            // Check if the word is part of a compound word
            if(!isFinalEnded(root,word,true)) {

                // Add the word to the Trie
                addingStringinsideTries(root, word);
            }else{

                result.add(word); // Add the word to the result if it's a compound word
            }
        }
        return result;
    }


}

public class  Search_the_longest_compounded_word_Tries{

    /*
       Reads lines from a file (Input_01.txt).
       Initializes the Answer class.
       Processes the input array of words using the "getAllthewordsinDectionary" method.
       Prints the longest and second-longest compound words and the time taken to process the input.
     */

    public static void main(String args[]) throws IOException {
        long start = System.currentTimeMillis();
        Answer obj = new Answer();
        List<String> mainResult = new ArrayList<>();
        ArrayList<String> list;
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader("Input_01.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                mainResult.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        String[] str = new String[mainResult.size()];

        for (int i = 0; i < mainResult.size(); i++) {
            str[i] = mainResult.get(i);
        }
        // Process the input array of words using the Answer class
        list = obj.getAllthewordsinDectionary(str);

        // Get the longest and second-longest compound words
        String longestCompoundWords = list.get(list.size() - 1);
        String secondlongestCompoundWords = list.get(list.size() - 2);

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("Longest Compound Word : " + longestCompoundWords);
        System.out.println("Second Longest Compound Word : " + secondlongestCompoundWords);
        System.out.println("Time taken to process the input file: " + elapsedTime);
    }

}
