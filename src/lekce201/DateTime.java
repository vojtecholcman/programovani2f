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
public class DateTime {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        
//        long start = System.currentTimeMillis();
        long start = System.nanoTime();
        for(int i = 0; i < 2_000_000_000; i++){
        //
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }
    
}
