/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import static edu.eci.arsw.primefinder.PrimeFinder.findPrimes;
import java.math.BigInteger;

/**
 *
 * @author 2133832
 */
public class PrimeFinderThread extends Thread{
    
    BigInteger a;
    BigInteger b;
    PrimesResultSet prs;
    
    
    
     public PrimeFinderThread(BigInteger a, BigInteger b, PrimesResultSet prs){
            this.a=a;
            this.b=b;
            this.prs=prs;
            
        }
    
    
    
    public void run(){
            calculate();
        
        }
    
    
    public synchronized void renaudar(){
        this.notify();
    }
    
    public  void calculate(){
            
          

                MathUtilities mt=new MathUtilities();
                
                int itCount=0;
            
                BigInteger i=a;
                while (i.compareTo(b)<=0){
                    itCount++;
                    if (mt.isPrime(i)){
                        prs.addPrime(i);
                    }

                    i=i.add(BigInteger.ONE);
                    synchronized (this) {
                    if (MouseMonitorThread.isPausa()) {
                        try {
                            wait();
                                 } catch (InterruptedException e) {
                           e.printStackTrace();
                                  }
                        }
                    }
                    
                }
                
	}
}
