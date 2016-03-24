import twitter4j.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import twitter4j.conf.*;

public class trialtwitter4j_allusers {
	
	public static void main(String[] args){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("cIZOUsBEoPMNBSOo43YS24du0");
		cb.setOAuthConsumerSecret("ECknCLAykNAccRM6Gz0QtVsXFsbyooTNBvOCCpx9TLm5aG9q76");
		cb.setOAuthAccessToken("701702184560234496-YGXAeP2cZDQfUEIDzHYjGGdt8TXlfQB");
		cb.setOAuthAccessTokenSecret("lmQyRNtwC2v0zyBqlJv9mhu7glDUfMpLxcTYpbbXetxli");
		
		Twitter unauthenticatedTwitter = new TwitterFactory(cb.build()).getInstance();
		
		List<Status> statuses = new ArrayList<Status>();
		
		String csvFile = "/Users/bhavana/Desktop/BTP/PVQ_part.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		
		try{
			br = new BufferedReader(new FileReader(csvFile));	
			int count=0;
			while((line= br.readLine())!=null){
				String[] user = line.split(csvSplitBy);
				String user_name = user[8];
				System.out.println("user_name: ");
				System.out.println(user_name);
	
				try{
					Paging paging = new Paging(1,17);
					statuses.addAll(unauthenticatedTwitter.getUserTimeline(user_name,paging)); 
				}catch(TwitterException e){
					e.printStackTrace();
				}
				finally{}
		
				for (Status s:statuses){
					System.out.println(s);
				}
				if (count>5)
					break;
				count++;
			}
		}
		catch( FileNotFoundException e){
			e.printStackTrace();
				}
		catch(IOException e){
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
	
}
}	