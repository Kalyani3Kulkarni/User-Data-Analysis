package UserDataAnalysis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessData {
	private  InputStream stream = this.getClass().getResourceAsStream("users-1.json");
	
	 /*********************************Variables********************************/
    int count=0,i=0,balancecount=0,unreadcount=0;
    double balancesum=0;
    long unreadsum = 0;
    
    /********************************Data Structures*******************************/

    PriorityQueue<Integer> maxheapAge = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minheapAge = new PriorityQueue<>();
    
    PriorityQueue<Integer> maxheapfriends = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minheapfriends = new PriorityQueue<>();
    
    HashMap<Integer,Integer> hash = new HashMap<>();
    
	public static void main(String[] args) {
		ProcessData pd = new ProcessData();
		pd.readStream();
	}
	
	
	public void readStream() {
		try {
			JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
            Gson gson = new GsonBuilder().create();

            // Read file in stream mode
            reader.beginArray();
            
    		/***************************File reading using stream**************************/
            
            while (reader.hasNext()) {
                // Read data into object model
                UserModel user = gson.fromJson(reader, UserModel.class);
                count++;
                String userinfo = "";
                
                
                //////////////////////// Number of Users registered in each year ////////////////////
                if((userinfo=user.getRegistered()) != null) {
                	userinfo = userinfo.substring(0, 4);
                	int res = Integer.parseInt(userinfo);
                	hash.put(res,hash.getOrDefault(res, 0)+1);
                }
                
                
                /////////////////////// Mean Balance Amount ////////////////////////////
                if((userinfo=user.getBalance()) != null) {
                	userinfo = userinfo.substring(1);
                	userinfo = userinfo.replaceAll(",", "");
                	balancesum += Double.parseDouble(userinfo);
                	balancecount++;
                }
                
                ////////////////////// Unread messages /////////////////////////////////
                if((userinfo = user.getGreeting())!= null) {
                	String[] temp = userinfo.split(" ");
                	unreadsum += Integer.parseInt(temp[temp.length-3]);
                	unreadcount++;
                }
                
                /////////////////// Median for Age ///////////////////////
                maxheapAge.offer(user.getAge());
                minheapAge.offer(maxheapAge.poll());
                if(maxheapAge.size() < minheapAge.size())
                	maxheapAge.offer(minheapAge.poll());
                
                
                /////////////////// Median for Number of Friends ///////////////////////
                List<FriendModel> li = user.getFriends();
                maxheapfriends.offer(li.size());
                minheapfriends.offer(maxheapfriends.poll());
                if(maxheapfriends.size() < minheapfriends.size())
                	maxheapfriends.offer(minheapfriends.poll());
                
          
                
                /////////////////////Print after 1000 records //////////////////////////
                if(count == 1000) {
                	i++;
                	double medianage = 0;
                	if(maxheapAge.size() == minheapAge.size()) 
                		medianage = (double)(maxheapAge.peek()+minheapAge.peek())/2;
                	else 
                		medianage = maxheapAge.peek();
                	
                	
                	double mediannumoffriends=0;
                	if(maxheapfriends.size() == minheapfriends.size()) 
                		mediannumoffriends = (double)((maxheapfriends.peek()+minheapfriends.peek())/2);
                	else 
                		mediannumoffriends = maxheapfriends.peek();
                	
                	System.out.println("------------"+"After "+(i*count)+" records"+"------------");
                	System.out.println("Median of number of friends is "+mediannumoffriends);
                	System.out.println("Median of age is "+medianage);
                	System.out.println("Mean balance amount is :" +(balancesum/balancecount));
                	System.out.println("Mean of unread messages are :" +(unreadsum/unreadcount));
                	for ( Integer key : hash.keySet()) 
                	    System.out.println(key + ":"+hash.get(key));
                	count = 0;
               }
            }
            reader.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Gson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Gson.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
}
