package com.company;

public class Date {
    private int day;
    private int year;
    private int month;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }


    public String monthName(int day) {
        switch (day) {

            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                throw new IllegalStateException("Unexpected value: " + day);
        }
    }

    //mutators


    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //accessors

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return monthName(month);
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "" + getDay() + " " + getMonth() + ", " + getYear();
    }

    public boolean equals(Date other) {
        return (getDay() == other.getDay()) &&
                getMonth().equals(other.getMonth()) &&
                getYear() == other.getYear();
    }
}
