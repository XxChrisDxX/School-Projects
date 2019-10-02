/************************************************************\
****Small program that will examine words in a given text ****
*****file, basketball.txt in this case, and find how many*****
***** times each word appears in the text file. Then, the*****
*** program will display the four most frequent words with ***
*** their frequencies or number of appearances in the text.***
**** The program will list the four most frequent words in****
* ascending order, with the most frequent first. If the words*
** are found the same number of times in the text file, the **
**** program will display the words in alphabetical order.****
****The program also creates a map for the 4 most frequent****
** words and compress the file and decompress the file based**
** on that map. The program rewrites the file with the name **
** compressed.txt with the most frequent words replaced with**
**the symbols #, $, *, and % in that order. Then the program**
**rewrites the file again, replacing those symbols with the **
*******words associated to them in the map, effectively*******
*** decompressing the file again. The decompressed file is ***
***************** saved as decompressed.txt. *****************
\************************************************************/

//import libraries
import java.io.*;
import java.util.*;

class FileStats {
	//instance variables
    private Scanner input = null;
    private ArrayList<String> wordList = new ArrayList<String>();
    private HashSet<String> wordSet = new HashSet<String>();
    private ArrayList<Entry<String>> entryList = new ArrayList<Entry<String>>();
    private Map<String, Character> compDictionary = new TreeMap<String, Character>();
    private Map<Character, String> decompDictionary = new HashMap<Character, String>();

    //Entry class (private) that implements Comparable<Entry<T>>
    private class Entry<T> implements Comparable<Entry<T>> {
    	//instance variables
        public T word;
        public int frequency;

        //public constructor for Entry that accepts T and int inputs
        public Entry(T word, int f) {
        	//sets the global variables equal to the input
            this.word = word;
            frequency = f;
        }
        //returns int and accepts Entry<T> input, is used by Collections.sort
        public int compareTo(Entry<T> e) {
        	//if the frequency is the same, sort alphabetically, ignoring case
			if(e.frequency-frequency == 0) {
        		return word.toString().compareToIgnoreCase(e.word.toString());
        	}else {
        		//returns frequency, to sort words by frequency
        		return e.frequency - frequency;
        	}
        }
    }
    //public constructor for FileStats that accepts String input
    public FileStats(String path) {
        String line = null;

        //try to open the file, catch file not found
        try {
            input = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file..");
            System.exit(1);
        }

        //try to read from the file, catch if the file is empty or no more lines exist
        try {
            while ((line = input.nextLine()) != null) {
            	//grabs the individual words from the line
                StringTokenizer st = new StringTokenizer(line);

                while (st.hasMoreTokens()) {
                	//sets the words to lower case, to ignore case sensitivity
					String nt = st.nextToken().toLowerCase();
					
					//if the String is not null and has something in it
					//and the last character is not a letter, remove it
                    if(nt != null && nt.length() > 0 && !Character.isLetter(nt.charAt(nt.length()-1))) {
              	      	nt = nt.substring(0, nt.length()-1);
                    }
                    
                    //add the word into wordList and wordSet
                    wordList.add(nt);
                    wordSet.add(nt);
				}
            }
        } catch (NoSuchElementException e) {
        	// no more lines in the file
        	// no handler is necessary
        }
        count();
    }

	/*
	 * This method is supposed to
	 * 1. find the frequency of each word in the file.
	 * 2. display the four most frequent words and their frequencies.
	 * 3. construct the dictionary that four key-value pairs. The keys
	 *    are the most frequent words and the values are the characters,
	 *    used to represent the words.
	 */
    private void count() {
		//runs for each word in wordSet
		for(String ws : wordSet) {
			//finds the amount of times the word in wordSet is found in wordList (the frequency)
            int freq = Collections.frequency(wordList, ws);

            //creates a new entry for the word and frequency of the word
            Entry<String> newEntry = new Entry<String> (ws, freq);
            
            //adds the word into entryList 
            entryList.add(newEntry);
        }
		//sorts entryList by frequency, and alphabetically if the frequency is the same
        Collections.sort(entryList);
		
        //display the 4 most frequent words only
		for(int i=0;i<4;i++) {
			System.out.println(entryList.get(i).word + " appears " +
					entryList.get(i).frequency + " time(s).");
		}
		//places the values in the dictionaries
		compDictionary.put(entryList.get(0).word, '#');
		compDictionary.put(entryList.get(1).word, '$');
		compDictionary.put(entryList.get(2).word, '*');
		compDictionary.put(entryList.get(3).word, '%');
		
		decompDictionary.put('#', entryList.get(0).word);
		decompDictionary.put('$', entryList.get(1).word);
		decompDictionary.put('*', entryList.get(2).word);
		decompDictionary.put('%', entryList.get(3).word);
	}
    //returns the dictionary for testing purposes
    public void printDictionary() {
        System.out.println("\n" + compDictionary + "\n");
    }
    //returns the compressions dictionary
    public Map<String, Character> getDictionary() {
        return compDictionary;
    }
    //returns the decompression dictionary
    public Map<Character, String> getDcompDictionary() {
        return decompDictionary;

    }
}

class FileCompressor {

    private static ArrayList<String> wordList = new ArrayList<String>();
    private static Scanner input;
    //returns void and rewrites the file with words replaced with their corresponding characters
    public static void compress(String src, String dest, Map<String, Character> compDictionary) throws IOException {
        String line = null;
        BufferedWriter out = new BufferedWriter(new FileWriter(dest, true));

        try {
            input = new Scanner(new File(src));
        }catch(FileNotFoundException e) {
            System.out.println("Error opening file..");
            System.exit(1);
        }
        try {
            while((line = input.nextLine()) != null) {
	                StringTokenizer st = new StringTokenizer(line);
	                //if the line is empty, add a blank space into the wordList
	                if(line.isEmpty()){
	            		wordList.add("");
	            	}
	                //adds all tokens to arrayList to be read and replaced with the dictionaries
	                while (st.hasMoreTokens()) {
	                    String string = st.nextToken().toLowerCase();
	                    wordList.add(string); 
	                }
            }
        }catch(NoSuchElementException e) {
        	// no more lines in the file
        	// no handler is necessary
        }
        for(int i = 0; i < wordList.size(); i++) {
            String key = wordList.get(i);
           
            //replace word with character if found in dictionary
            if(compDictionary.containsKey(key)) {
                out.write(compDictionary.get(key) + " ");
            }
            //if the wordList contains a blank space, insert two new lines to put a blank line between text
            else if(key == ""){
            	out.newLine();
            	out.newLine();
            }
            else {
                out.write(key + " ");
            }
        }
        //closes the file
        out.close(); 
    }
    //returns void and rewrites the file with characters replaced with their corresponding words
    public static void decompress(String src, String dest, Map<Character, String> decompDictionary) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(dest, true));

        try {
            input = new Scanner(new File(src));
        }catch(FileNotFoundException e) {
            System.out.println("Error opening file..");
            System.exit(1);
        }
        for(int i = 0; i < wordList.size(); i++) {
            String key = wordList.get(i);
            
            //replace character with word if found in dictionary
            if(decompDictionary.containsKey(key)) {
                out.write(decompDictionary.get(key) + " ");
            }
            //if the wordList contains a blank space, insert two new lines to put a blank line between text
            else if(key == ""){
            	out.newLine();
            	out.newLine();
            }
            else {
                out.write(key + " ");
            }
        }
        //closes the file
        out.close(); 
    }
}
//testing driver
public class FileIO {
	
    public static void main(String args[]) throws IOException {
    	//instantiates a new FileStats class with the given String, basketball.txt (file to be opened)
        FileStats fs = new FileStats("basketball.txt");
        //prints the key/values for the specific words in the dictionaries
        fs.printDictionary(); 

        Map<String, Character> m1 = fs.getDictionary();
        //Original file --> Compressed file
        FileCompressor.compress("basketball.txt", "compressed.txt", m1);

        Map<Character, String> m2 = fs.getDcompDictionary();
        //Compressed file --> Decompressed file
        FileCompressor.decompress("compressed.txt", "decompressed.txt", m2); 
    }
}
