package lekce201;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        // Fixní datum (24. 12. 2008 00:00:00)
        Calendar fixDate = Calendar.getInstance();
        fixDate.clear();
        fixDate.set(2008, Calendar.DECEMBER, 24, 0, 0, 0);

        // Aktuální čas
        Calendar now = Calendar.getInstance();

        // Je fixní datum v budoucnosti?
        boolean isInFuture = fixDate.after(now);

        // Nastav startDate a endDate
        Calendar startDate;
        Calendar endDate;
        if (isInFuture) {
            startDate = now;      // POZOR: bude se posouvat
            endDate   = fixDate;
        } else {
            startDate = fixDate;  // POZOR: bude se posouvat
            endDate   = now;
        }

        // Výpočet rozdílu
        int[] difference = countDifference(startDate, endDate);

        // Výpis
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
    }

    // Vrátí [roky, měsíce, dny, hodiny, minuty, sekundy]
    public static int[] countDifference(Calendar startDate, Calendar endDate) {
        int[] difference = new int[6];
        difference[0] = count(startDate, endDate, Calendar.YEAR);
        difference[1] = count(startDate, endDate, Calendar.MONTH);
        difference[2] = count(startDate, endDate, Calendar.DAY_OF_MONTH);
        difference[3] = count(startDate, endDate, Calendar.HOUR_OF_DAY);
        difference[4] = count(startDate, endDate, Calendar.MINUTE);
        difference[5] = count(startDate, endDate, Calendar.SECOND);
        return difference;
    }

    // „Odtiká“ danou jednotku od startDate k endDate a vrátí počet kroků
    public static int count(Calendar startDate, Calendar endDate, int unit) {
        int c = 0;
        while (startDate.before(endDate)) {
            startDate.add(unit, 1);
            if (startDate.after(endDate)) {
                startDate.add(unit, -1);
                break;
            }
            c++;
        }
        return c;
    }
}
