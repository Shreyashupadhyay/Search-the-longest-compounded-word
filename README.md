
# Search the longest compounded word




## Aproach

The provided Java code implements a solution for identifying compound words within a given list of words using a "Trie data structure". The Trie is a tree-like structure where each node represents a character, and paths from the root to nodes form words. The Tries class defines the Trie node structure, including a character value, an array of child nodes, and a boolean flag indicating the end of a word.

The main logic resides in the Answer class, featuring methods to process the input array of words. The getAllthewordsinDectionary method sorts the words by length and iterates through them. For each word, it checks if the word is part of any existing compound word using the Trie. If not, the word is added to the Trie; otherwise, it is added to the result list. The addingStringinsideTries method inserts a given string into the Trie, creating nodes for each character. The isFinalEnded method recursively checks if a given string is part of a compound word by traversing the Trie.

In the Main class, the program reads words from an input file, instantiates the Answer class, processes the input array using the Trie-based solution, and prints the longest and second-longest compound words, along with the execution time.

The overall flow involves initializing a Trie, reading and sorting input words, processing words with the Trie, and printing the results. While the code achieves its goal, there's room for improvement in variable/method naming, detailed comments, and exception handling. The program measures execution time using System.nanoTime() before and after processing the input file, providing insights into performance.
## How to use 

1 - Clone this Repo in your system.\
2 - Open Search_the_longest_compounded_word_Tries.java and Replace "Input_01.txt" with exact file path of input file.\
3 = Now run the code