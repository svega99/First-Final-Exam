/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.api.primesrepo.service;

/**
 *
 * @author 2133832
 */
public class PrimeServiceException extends Exception{

    public PrimeServiceException(String message) {
        super(message);
    }

    public PrimeServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}