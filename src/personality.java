import java.io.*;
import java.util.*;
public class personality {
	
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception { 
        String LIWCFile = "/home/syamkumar/Desktop/LIWC.txt";
        Map frequency = new HashMap();
		String[][] words = new String[5690][2];
		int index[]=new int[26];
		
		ReadingLIWC_new.sortLIWC(LIWCFile, words, index, frequency);
		
		final File folder = new File("/home/syamkumar/Desktop/mypersonality_final/data/");
        listFilesForFolder(folder, words, index, frequency);
       
    }//main method close
    
    public static void listFilesForFolder(final File folder,String[][] words, int[] index, Map frequency) throws IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry, words, index, frequency);
            } else {
                System.out.println(fileEntry.getName());
                Read_data_from_csv(fileEntry.getName(), words, index, frequency);
            }
        }
    }//listFilesForFolder method close
	
    private static void Read_data_from_csv(String name, String[][] words, int[] index, Map frequency) throws IOException {
		 
		/////Reading liwc file//////
/*		String splitBy1 = ",";
	        BufferedReader br1 = new BufferedReader(new FileReader("/home/syamkumar/Desktop/LIWC.txt"));
	        String line1 = br1.readLine();  
	        while ((line1 = br1.readLine()) !=null) {
	        String[] b1 = line1.split(splitBy1);
	             System.out.println(b1[0]);
	             System.out.println(b1[1]);

	        }
	        br1.close();
	*/        
	        ////////Reading users fb status files///////// 
		 String whole_data="";
		 String splitBy = ",";
	        BufferedReader br = new BufferedReader(new FileReader("/home/syamkumar/Desktop/mypersonality_final/data/"+name));
	        String line = br.readLine();  
	        while ((line = br.readLine()) !=null) {
	        String[] b = line.split(splitBy);
	            // System.out.println(b[0]);
	              whole_data=whole_data+b[1];         
	        }
	        br.close();
	        //System.out.println(whole_data); 
	        String[] text = whole_data.split("\\s+");
	        for (int i = 0; i < text.length; i++) {
		            text[i] = text[i].replaceAll("[^\\w]", "").toLowerCase().trim();
	        }
	        
	        ReadingLIWC_new.categorise_from_array(text, words, index, frequency);
	        System.out.println(Arrays.toString(text));
			
	}//Read_data_from_csv method close
}//class close