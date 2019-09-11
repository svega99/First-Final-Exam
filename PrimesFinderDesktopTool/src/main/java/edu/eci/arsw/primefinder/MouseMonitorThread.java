/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2133832
 */
public class MouseMonitorThread extends Thread{
    
    public static boolean pausa;
    
    
    public void run(){
        while(PrimesFinderTool.isRunning()){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(1000);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Hilos corriendo");
                        PrimeFinder.getPF1().renaudar();
                        PrimeFinder.getPF2().renaudar();
                        PrimeFinder.getPF3().renaudar();
                        PrimeFinder.getPF4().renaudar();
                        pausa=false;
                    }
                    else{
                        System.out.println("Movimiento del mouse detectado, hilos inactivos");
                        pausa=true;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public static boolean isPausa(){
        return pausa;
    }
    
}
/*PrimeFinder.getPF1().isAlive() &&
               PrimeFinder.getPF2().isAlive() &&
                PrimeFinder.getPF3().isAlive() &&
                PrimeFinder.getPF4().isAlive() 

*/