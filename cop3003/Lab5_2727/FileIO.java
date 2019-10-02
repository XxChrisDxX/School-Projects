import java.io.*;
import java.util.*;

class FileStats{
	private Scanner input;
	private ArrayList <String> wordList=new ArrayList<String>();
	private HashSet <String> wordSet=new HashSet<String>();
	private ArrayList <Entry<String>> entryList=new ArrayList<Entry<String>>();

	private class Entry <T> implements Comparable<Entry<T>>{
		public T word;
		public int frequency;
		public Entry(T word, int f){
			this.word=word;
			frequency=f;
		}
		public int compareTo(Entry<T> e){
			/* insert your code */
		}
	}

	public FileStats(String path) {

		/* insert your code here */

		/* open the file, named path */


		count();
	}

	/*
	 * This method is supposed to
	 * 1. find the frequency of each word in the file.
	 * 2. display the four most frequent words and their frequencies.
	 */
	private void count() {
		/* insert your code here */
	}
}

public class FileIO {
	public static void main(String args[]) throws IOException{
		FileStats fs=new FileStats("basketball.txt");
	}
}
