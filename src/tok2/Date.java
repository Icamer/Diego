package tok2;

import java.util.concurrent.TimeUnit;

/**
 * Created by icamer on 17.02.17.
 */
public class Date {
    int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        System.out.println(day + " " + month + " " +year);
    }

    int count(){
        int amountOfDays = 0;
        int startingDay = 1;
        int startingMonth = 1;
        int startingYear = 0;
        while(startingDay != this.day || startingMonth != this.month || startingYear != this.year){

            if (startingMonth == 13){

                if((0 < startingDay && startingDay < 5)){
                    startingDay++;
                    amountOfDays++;
                    System.out.println("B");
                }else if (startingDay == 5  && (startingYear % 4 == 0 && startingYear % 400 != 0)){
                    startingDay++;
                    amountOfDays++;
                    System.out.println("KLE");
                }else{
                    startingYear++;
                    startingDay = 1;
                    startingMonth = 1;
                    amountOfDays++;
                    System.out.println("C");
                }
                System.out.println("A: " + startingDay + " " + startingMonth + " " + startingYear);
                System.out.println("A: " + this.day + " " + this.month + " " + this.year);
                continue;
            }

            System.out.println("D");
            if(0 < startingDay && startingDay < 30 && startingMonth <13){
                startingDay++;
                amountOfDays++;
                System.out.print("E");

            }else if(0 < startingMonth && startingMonth < 13){
                startingDay = 1;
                startingMonth++;
                amountOfDays++;
                System.out.println("F");
            }
            System.out.println("G" + amountOfDays);

        }


        return amountOfDays;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
