package sample;

public class Operation {

    private int startAcc;
    private int endAcc;
    private float sum;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String status;
    private int id;

    public Operation(int startAcc, int endAcc, float sum, int year, int month, int day, int hour, int minute, String status) {
        this.startAcc = startAcc;
        this.endAcc = endAcc;
        this.sum = sum;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.status = status;
    }

    public Operation(){
        status = "awaiting";
    }

    public int getStartAcc() {
        return startAcc;
    }

    public int getEndAcc() {
        return endAcc;
    }

    public float getSum() {
        return sum;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartAcc(int startAcc) {
        this.startAcc = startAcc;
    }

    public void setEndAcc(int endAcc) {
        this.endAcc = endAcc;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
