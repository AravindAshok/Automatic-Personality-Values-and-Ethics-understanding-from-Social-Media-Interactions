import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadingLIWC_new {
	public static void main(String[] args){
		String LIWCFile = "/home/syamkumar/Desktop/LIWC.txt";
		String UserTweets = "/home/syamkumar/Desktop/user1text.txt";
		Map frequency = new HashMap();
		String[][] words = new String[5690][2];
		int index[]=new int[26];
		
		sortLIWC(LIWCFile, words, index, frequency);
		categorise(UserTweets, words, index, frequency);
		reset_frequency(frequency);
	}
		
	public static void sortLIWC(String LIWCFile, String[][] words, int index[], Map frequency) {
		
		
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		int i = 0;
		int j = 0;

		
		try{
			br = new BufferedReader(new FileReader(LIWCFile));	
			while((line= br.readLine())!=null){
				String[] liwc = line.split(splitBy);
				words[i][j] = liwc[0].trim();
				words[i][j+1] = liwc[1];
				
				frequency.put(liwc[1], 0);
					
				i = i+1;		
				j = 0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Arrays.sort(words,new Comparator<String[]>(){
			@Override
			public int compare(final String[] entry1,final String[] entry2){
				final String word1 = entry1[0];
				final String word2 = entry2[0];
				return word1.compareTo(word2);
			}
		});
		
		char ch='a';
		for(i=0;i<words.length;i++)
		{
			if(ch=='x')
				ch='y';
			if(words[i][0].charAt(0) == ch)
			{
				index[ch-'a']=i;
				ch=(char) (ch+1);
			}
		}
	}
	
	public static void categorise(String UserTweets, String[][] words, int index[], Map frequency) {
	try{
		int i,j;
		BufferedReader br = null;
		String line = "";
		br = new BufferedReader(new FileReader(UserTweets));	
		while((line= br.readLine())!=null){
			String[] text = line.split(" ");
		
			for (j=1;j<text.length;j++)
			{
				String word=text[j];
				word = word.toLowerCase().trim();
				int ind=0, flag = 0;
				
				if(word.length()>0 && Character.isLetter(word.charAt(0)))
				{
					ind = word.charAt(0)-'a';
				}
				for(i=index[ind];i<5690;i++)
				{
					Pattern r = Pattern.compile(words[i][0]);
					Matcher m = r.matcher(word);
					if(m.find()){
						if(m.group(0) == word){
							flag=1;
							int freq = (int) frequency.get(words[i][1]);
							frequency.put(words[i][1], freq+1);
						}
						else if(flag == 1)
							break;
					}
				}
			}
		}	
		System.out.println();
		System.out.println(" Map Elements");
		System.out.print("\t" + frequency.size());
			
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	public static void categorise_from_array(String[] text, String[][] words, int index[], Map frequency) {
	try{
		int i,j;			
		for (j=0;j<text.length;j++)
		{
			String word=text[j];
			word = word.toLowerCase().trim();
			int ind=0, flag = 0;
			
			if(word.length()>0 && Character.isLetter(word.charAt(0)))
			{
				ind = word.charAt(0)-'a';
			}
			for(i=index[ind];i<5690;i++)
			{
				Pattern r = Pattern.compile(words[i][0]);
				Matcher m = r.matcher(word);
				if(m.find()){
					if(m.group(0) == word){
						flag=1;
						int freq = (int) frequency.get(words[i][1]);
						frequency.put(words[i][1], freq+1);
					}
					else if(flag == 1)
						break;
				}
			}
		}
		System.out.print(" " + frequency);
			
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	public static void reset_frequency(Map frequenc) {
		try{
			Map<String, Integer> frequency = (Map<String, Integer>) frequenc;
			for (Map.Entry<String, Integer> entry : frequency.entrySet())
			{
				frequency.put(entry.getKey(), 0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	
	public static void print_frequency(Map frequenc) {
	try{
		Map<String, Integer> frequency = (Map<String, Integer>) frequenc;
		for (Map.Entry<String, Integer> entry : frequency.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}