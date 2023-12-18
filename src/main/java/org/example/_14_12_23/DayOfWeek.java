package org.example._14_12_23;

public enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;


    public DayOfWeek getNextDayOfWeek() {

//        int result = this.ordinal();
//        DayOfWeek day = null;
//        if (result == 6){
//            day=DayOfWeek.valueOf((values()[0]).toString());
//        }else day=values()[result + 1];
//        return day;

        int nextIndex = (this.ordinal() + 1) % DayOfWeek.values().length;
        return DayOfWeek.values()[nextIndex];
    }


}