package edu.programacion.central.dto;

public class RegisterCard {
    private String cardName;
    private String cardNumber;
    private Integer customerId;
    private String expirationDate;

    public RegisterCard(String cardName, String cardNumber, Integer customerId, String expirationDate) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.customerId = customerId;
        this.expirationDate = expirationDate;
    }

    public RegisterCard() {
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
