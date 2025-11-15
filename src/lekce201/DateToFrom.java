/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce201;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author admin
 */
public class DateToFrom {
    public static void main(String[] args) {
        Calendar fixDate = Calendar.getInstance();
        fixDate.clear();
        fixDate.set(2008, Calendar.DECEMBER, 24, 0, 0, 0);
        
        Calendar now = Calendar.getInstance();
        
        boolean isInFuture = fixDate.after(now);

        Calendar startDate;
        Calendar endDate;
        
        if (isInFuture) {
            startDate = now;
            endDate = fixDate;
        } else {
            startDate = fixDate;
            endDate = now;
        }

        int[] difference = countDifference(startDate, endDate);

        if (isInFuture) {
            System.out.printf(
                "Zbývá %d let, %d měsíců, %d dnů, %d hodin, %d minut a %d sekund.%n",
                difference[0], difference[1], difference[2], difference[3], difference[4], difference[5]
            );
        } else {
            System.out.printf(
                "Uplynulo %d let, %d měsíců, %d dnů, %d hodin, %d minut a %d sekund.%n",
                difference[0], difference[1], difference[2], difference[3], difference[4], difference[5]
            );
        }

        Calendar nextAnniversary = Calendar.getInstance();

        nextAnniversary.set(Calendar.YEAR, now.get(Calendar.YEAR));
        nextAnniversary.set(Calendar.MONTH, fixDate.get(Calendar.MONTH));
        nextAnniversary.set(Calendar.DAY_OF_MONTH, fixDate.get(Calendar.DAY_OF_MONTH));
        nextAnniversary.set(Calendar.HOUR_OF_DAY, fixDate.get(Calendar.HOUR_OF_DAY));
        nextAnniversary.set(Calendar.MINUTE, fixDate.get(Calendar.MINUTE));
        nextAnniversary.set(Calendar.SECOND, fixDate.get(Calendar.SECOND));

        if (!nextAnniversary.after(now)) {
            nextAnniversary.add(Calendar.YEAR, 1);
        }

        int[] untilNext = countDifference(now, nextAnniversary);

        System.out.printf("Nejbližší výročí bude %tF %tT a zbývá do něj %d let, %d měsíců, %d dnů, %d hodin, %d minut a %d sekund.%n",
                nextAnniversary, nextAnniversary,untilNext[0], untilNext[1], untilNext[2], untilNext[3], untilNext[4], untilNext[5]);
      }

    public static int[] countDifference(Calendar startDate, Calendar endDate) {
        
        Calendar start = (Calendar) startDate.clone();
        Calendar end   = (Calendar) endDate.clone();

        int[] difference = new int[6];
        difference[0] = count(start, end, Calendar.YEAR);
        difference[1] = count(start, end, Calendar.MONTH);
        difference[2] = count(start, end, Calendar.DAY_OF_MONTH);
        difference[3] = count(start, end, Calendar.HOUR_OF_DAY);
        difference[4] = count(start, end, Calendar.MINUTE);
        difference[5] = count(start, end, Calendar.SECOND);
        return difference;
    }

    public static int count (Calendar startDate, Calendar endDate, int unit){
        int count = 0;
        while(startDate.before(endDate)){
            startDate.add(unit, 1);
            if(startDate.after(endDate)){
                startDate.add(unit, -1);
                break;
            }
            count++;     
        }
        return count;
    }
}