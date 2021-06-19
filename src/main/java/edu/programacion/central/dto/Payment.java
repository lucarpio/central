package edu.programacion.central.dto;

public class Payment {
    private Number amount;
    private String cardName;
    private String cardNumber;
    private Integer customerId;
    private Integer cvcCode;
    private String documentNumber;
    private String expirationDate;

    public Payment(Number amount, String cardName, String cardNumber, Integer customerId, Integer cvcCode,
            String documentNumber, String expirationDate) {
        this.amount = amount;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.customerId = customerId;
        this.cvcCode = cvcCode;
        this.documentNumber = documentNumber;
        this.expirationDate = expirationDate;
    }

    public Payment() {
    }

    public Number getAmount() {
        return this.amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
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

    public Integer getCvcCode() {
        return this.cvcCode;
    }

    public void setCvcCode(Integer cvcCode) {
        this.cvcCode = cvcCode;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
