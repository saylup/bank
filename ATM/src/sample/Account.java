package sample;

public class Account {

    private int number;
    private int numberCard;
    private int pinCode;
    private String type;
    private float sum;

    public Account(int number, int numberCard, int pinCode, String type, float sum) {
        this.number = number;
        this.numberCard = numberCard;
        this.pinCode = pinCode;
        this.type = type;
        this.sum = sum;
    }

    public Account(){}

    public int getPinCode() { return pinCode; }

    public void setPinCode(int pinCode) { this.pinCode = pinCode; }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public float getSum() {
        return sum;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}