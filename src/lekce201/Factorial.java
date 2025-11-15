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
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(170));
        
        System.out.println(findMaxFactorial());
        System.out.println(findMaxFactorialBetter());
        
        System.out.println(factorialOtherWay(170));
        System.out.println(factorialOtherWay(171));
        
        System.out.println(TimeConsumer.test(10000, () -> findMaxFactorial()));
        System.out.println(TimeConsumer.test(10000, () -> findMaxFactorialBetter()));
    }
    public static double factorial(int n){
        if (n > 1){
            return n * factorial(n-1);
        } else{
            return 1;
        }
    }    
    public static int findMaxFactorial(){
        for (int n = 1; ; n++){
            double f = factorial(n);
            if(f == Double.POSITIVE_INFINITY){
                return n;
            }
        }
    }
    public static int findMaxFactorialBetter(){
        double f = 1;
        for(int n = 1; ; n++){
            f = n * f;
            if(f == Double.POSITIVE_INFINITY){
                return n;
            }
        }
    }
    public static double factorialOtherWay(int n){
        double f = n;
        for(int i = n - 1; i > 1; i--){
            f = f * i;
        }
        return f;
    }

}
