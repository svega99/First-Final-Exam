package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrimeFinder {
        
    
        static PrimeFinderThread pf1;
        static PrimeFinderThread pf2;
        static PrimeFinderThread pf3;
        static PrimeFinderThread pf4;
       
        
	
        
	public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs) {
            
                BigInteger a=_a;
                BigInteger b=_b;
                
                long bint = b.longValueExact();
                long aint = a.longValueExact();

                long dif = bint-aint;
                
                long dif1=dif/4;
                long dif2=2*(dif/4);
                long dif3=3*(dif/4);

                
                pf1= new PrimeFinderThread(a,new BigInteger (Integer.toString((int) ((int) aint+(dif1)))),prs);
                pf2= new PrimeFinderThread(new BigInteger (Integer.toString((int) ((int) aint+(dif1))+1)),new BigInteger (Integer.toString((int) ((int) aint+(dif2)))),prs);
                pf3= new PrimeFinderThread(new BigInteger (Integer.toString((int) ((int) aint+(dif2))+1)),new BigInteger (Integer.toString((int) ((int) aint+(dif3)))),prs);
                pf4= new PrimeFinderThread(new BigInteger (Integer.toString((int) ((int) aint+(dif3))+1)),b,prs);
                
                
                MouseMonitorThread mmt = new MouseMonitorThread();
                
                mmt.start();
                pf1.start();
                pf2.start();
                pf3.start();
                pf4.start();
                
            try {
                pf1.join();
                pf2.join();
                  pf3.join();
                   pf4.join();
   
            } catch (InterruptedException ex) {
                Logger.getLogger(PrimeFinder.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
             
            
            
                    /*
                MathUtilities mt=new MathUtilities();
                
                int itCount=0;
            
                BigInteger i=a;
                while (i.compareTo(b)<=0){
                    itCount++;
                    if (mt.isPrime(i)){
                        prs.addPrime(i);
                    }

                    i=i.add(BigInteger.ONE);
                }
         */     
	}
	
	
	public static PrimeFinderThread getPF1(){
        
            return pf1;
        }
        
        public static PrimeFinderThread getPF2(){
        
            return pf2;
        }
        
        public static PrimeFinderThread getPF3(){
        
            return pf3;
        }
        
        public static PrimeFinderThread getPF4(){
        
            return pf4;
        }
	
	
}
