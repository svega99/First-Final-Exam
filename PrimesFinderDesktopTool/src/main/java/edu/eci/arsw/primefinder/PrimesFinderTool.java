package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {
        
       static boolean running=true;
    
	public static void main(String[] args) {
		            
            int maxPrim=1000;
            
            
            PrimesResultSet prs=new PrimesResultSet("jon");
            
            PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("100"), prs);
            running=false;
            
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());
            
                        
            
            
            
            
	}
	
        
       public static boolean isRunning(){
           return running;
       }
}


