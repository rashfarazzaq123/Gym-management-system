public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public int getDay() {

        return day;
    }

    public void setDay(int day) {

    }

    public void setMonth(int month) {

    }
}