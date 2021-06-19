package edu.programacion.central.dto;

public class Card {
    private Number balance;
    private String cardNumber;
    private Integer cvcCode;
    private String expirationDate;
    private String name;
    private String registrationDate;

    public Card(Number balance, String cardNumber, Integer cvcCode, String expirationDate, String name,
            String registrationDate) {
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.cvcCode = cvcCode;
        this.expirationDate = expirationDate;
        this.name = name;
        this.registrationDate = registrationDate;
    }

    public Card() {
    }

    public Number getBalance() {
        return this.balance;
    }

    public void setBalance(Number balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvcCode() {
        return this.cvcCode;
    }

    public void setCvcCode(Integer cvcCode) {
        this.cvcCode = cvcCode;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

}
