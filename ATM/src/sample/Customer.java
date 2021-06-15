package sample;

public class Customer {

    private String name;
    private String surname;
    private String patronymic;
    private int passport_ser;
    private int passport_num;
    private String login;
    private String pass;

    public Customer(){

    }

    public Customer(String name, String surname, String patronymic, int passport_ser, int passport_num, String login, String pass) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.passport_ser = passport_ser;
        this.passport_num = passport_num;
        this.login = login;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getPassport_ser() {
        return passport_ser;
    }

    public int getPassport_num() {
        return passport_num;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPassport_ser(int passport_ser) {
        this.passport_ser = passport_ser;
    }

    public void setPassport_num(int passport_num) {
        this.passport_num = passport_num;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

