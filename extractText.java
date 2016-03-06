import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class extractText {
		public static void main(String[] args) throws Exception{
			String textFile = "/Users/bhavana/Desktop/BTP/user1.txt";
			PrintStream out = new PrintStream(new FileOutputStream("/Users/bhavana/Desktop/BTP/user1text.txt"));
			BufferedReader br = null;
			String line = "";
			String SplitBy = ",";
			
			try{
				br = new BufferedReader(new FileReader(textFile));
				while((line= br.readLine())!=null){
							String[] tweet = line.split(SplitBy);
							if(tweet.length == 0){
								continue;
							}
							else{
							out.println(tweet[2]);
							}
					}
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(br!=null){
					try{
						br.close();
						
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}
			out.flush();
			out.close();
		}
		
		}
