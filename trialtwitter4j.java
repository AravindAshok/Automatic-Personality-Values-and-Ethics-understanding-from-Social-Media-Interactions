import twitter4j.*;
import java.util.*;
import twitter4j.conf.*;

public class trialtwitter4j {
	
	public static void main(String[] args){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("cIZOUsBEoPMNBSOo43YS24du0");
		cb.setOAuthConsumerSecret("ECknCLAykNAccRM6Gz0QtVsXFsbyooTNBvOCCpx9TLm5aG9q76");
		cb.setOAuthAccessToken("701702184560234496-YGXAeP2cZDQfUEIDzHYjGGdt8TXlfQB");
		cb.setOAuthAccessTokenSecret("lmQyRNtwC2v0zyBqlJv9mhu7glDUfMpLxcTYpbbXetxli");
		
		Twitter unauthenticatedTwitter = new TwitterFactory(cb.build()).getInstance();
		
		List<Status> statuses = new ArrayList<Status>();
		String user  = "@joannamoore99";
		try{
			Paging paging = new Paging(1,17);
			statuses.addAll(unauthenticatedTwitter.getUserTimeline(user,paging)); 
		}catch(TwitterException e){
			e.printStackTrace();
		}
		
		 for (Status s:statuses){
			 System.out.println(s);
		 }
		
	}
}