package mapADT_hashADT;


/** May-15-2016
 *  page 405 (Map and Hash)
 * 	
 * 	Allen
 */
import java.util.Scanner;

public class WordCount {
	public static void main(String[] args){
		Map<String, Integer> freq = new ChainHashMap(); 
		Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
		while(doc.hasNext()){
			String word = doc.next().toLowerCase();
			Integer count = freq.get(word);
			if (count == null) 	
				count = 0;
			freq.put(word, 1 + count); // store in the Map
		}
		
		int maxCount = 0;
		String maxWord = "no word";
		for(Entry<String, Integer> ent : freq.entrySet()){
			if (ent.getValue() > maxCount){ //getting the most frequent word
				maxWord = ent.getKey();
				maxCount = ent.getValue();
			}				
		}
		System.out.print("The most frequent word is '" + maxWord);
		System.out.print("' with " + maxCount + " occurrences.");
	}
}
