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
public class TimeConsumer {
    public static void main(String[] args) {
        System.out.println(test(100, new Runnable() {
            @Override
            public void run() {
                double t = 10d;
                double s = 1.0 / 2.0 * 9.81 * Math.pow(t, 2);
            }
            }));
    }
    
    public static long test(int count, Runnable run){
        long start = System.nanoTime();
        for(int i = 0; i < count; i++){
            run.run();
        }
        long end = System.nanoTime();
        return end - start;
    }
}
