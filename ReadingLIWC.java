import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class ReadingLIWC {
	public static void main(String[] args){
		String[][] words = new String[5690][2];
		
		String LIWCFile = "/Users/bhavana/Desktop/BTP/LIWC.all.txt";
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
	
	}
	
}