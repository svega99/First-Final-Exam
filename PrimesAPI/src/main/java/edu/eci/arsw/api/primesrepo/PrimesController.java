package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import edu.eci.arsw.api.primesrepo.service.PrimeServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController
public class PrimesController
{
    @Autowired
    @Qualifier("primeService")
    PrimeService primeService;


    @RequestMapping( value = "/primes", method = GET )
    public List<FoundPrime> getPrimes()
    {
        return primeService.getFoundPrimes();
    }
    
    
    @RequestMapping(value="/primes/{primenumber}",method = GET)
    public FoundPrime getOnePrime(@PathVariable("primenumber") String primenumber){
            return primeService.getPrime(primenumber);
        } 
    
    
    @RequestMapping(method = POST)	
    public ResponseEntity<?> addFoundPrime(@RequestBody FoundPrime fp){
        
        try {
            primeService.addFoundPrime(fp);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PrimeServiceException pse) {
             return new ResponseEntity<>(pse.getMessage(),HttpStatus.FORBIDDEN);
        }
        
 
    }
    
    

}
    //TODO implement additional methods provided by PrimeService




