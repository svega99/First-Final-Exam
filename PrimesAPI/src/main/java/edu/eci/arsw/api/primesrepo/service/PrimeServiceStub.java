package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */

@Component("primeService")
public class PrimeServiceStub implements PrimeService
{
    List<FoundPrime> primes =  new ArrayList<FoundPrime>();
    
    @Override
    public void addFoundPrime( FoundPrime foundPrime ) throws PrimeServiceException
    {
         synchronized (primes) {
            FoundPrime fp =getPrime(foundPrime.getPrime());
            try{
                fp.equals(foundPrime);   
                if (!foundPrime.getUser().equals(fp.getUser())){
                    throw new PrimeServiceException("Ya existe ese numero primo con otro usuario");
                }
                else{
                    primes.add(foundPrime);
                }
            }
            catch(NullPointerException n){
                primes.add(foundPrime);
            }

         }
        
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        return primes;
    }

    @Override
    public FoundPrime getPrime( String prime )
    {
        synchronized (primes) {
            FoundPrime fp = null;
            for (FoundPrime p:primes){
                if(p.getPrime().equals(prime)){
                    fp=p;
                }
            }
           
            return fp;
        }
    }
}
