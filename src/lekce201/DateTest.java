/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce201;

import java.util.Date;

/**
 *
 * @author vojtech.holcman.s
 */
public class DateTest {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        Date a = null,b = null;
        if(a.getTime() < b.getTime()){}
        System.out.println(now.getTime());
    }
}
