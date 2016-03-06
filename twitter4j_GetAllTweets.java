import java.util.*;
import twitter4j.*;
import twitter4j.conf.*;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class twitter4j_GetAllTweets {
	public static void main(String[] args) throws Exception{
	
	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setOAuthConsumerKey("cIZOUsBEoPMNBSOo43YS24du0");
	cb.setOAuthConsumerSecret("ECknCLAykNAccRM6Gz0QtVsXFsbyooTNBvOCCpx9TLm5aG9q76");
	cb.setOAuthAccessToken("701702184560234496-YGXAeP2cZDQfUEIDzHYjGGdt8TXlfQB");
	cb.setOAuthAccessTokenSecret("lmQyRNtwC2v0zyBqlJv9mhu7glDUfMpLxcTYpbbXetxli");

	Twitter twitter = new TwitterFactory(cb.build()).getInstance();

	int pageno = 1;
	String user = "@speerwill";
	//List status = new ArrayList();
	List<Status> statuses = new ArrayList();
	
	while (true) {

	  try {  
	    int size = statuses.size(); 
	    Paging page = new Paging(pageno++, 1000);
	    statuses = twitter.getUserTimeline(user, page);
	    if (statuses.size() == size)
	      break;
	  }
	  catch(TwitterException e) {

	    e.printStackTrace();
	  }
	}

	PrintStream out = new PrintStream(new FileOutputStream("/Users/bhavana/Desktop/BTP/user_2.txt"));
		
	for(Status status1: statuses){
		String s = status1.getText();
		out.println(s);
	}
	out.flush();
	out.close();
}
}
