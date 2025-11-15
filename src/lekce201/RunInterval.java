/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce201;

/**
 *
 * @author vojtech.holcman.s
 */
public class RunInterval {
    public static void main(String[] args) {
        int i = 0;
        long finished = System.nanoTime() + 1_000_000_000;
        
        while(System.nanoTime() < finished){
            i++;
            System.out.println(i);
        }
        System.out.println("Last number: " + i);
    }
    
//    private static void doIt(int i){
//        
//    }

}
