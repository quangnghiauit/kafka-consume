package com.dacn.kafkadatalake.dto.request;

public class OrderConsumerDTO {

    private int cusID;
    private String createdDate;
    private int status;
    private float totalAmount;
    private String receiverName;
    private int receiverPhone;
    private int receiveLocation;
    private float volumeProduction;
    private String typeProduct;
    private String description;
    private String senderName;
    private long senderPhone;
    private int senderLocation;
    private String expectedDate;
    private String recieveDate;
    private String recieveAddress;
    private String senderAddress;

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public int getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(int receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public int getReceiveLocation() {
        return receiveLocation;
    }

    public void setReceiveLocation(int receiveLocation) {
        this.receiveLocation = receiveLocation;
    }

    public float getVolumeProduction() {
        return volumeProduction;
    }

    public void setVolumeProduction(float volumeProduction) {
        this.volumeProduction = volumeProduction;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public long getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(long senderPhone) {
        this.senderPhone = senderPhone;
    }

    public int getSenderLocation() {
        return senderLocation;
    }

    public void setSenderLocation(int senderLocation) {
        this.senderLocation = senderLocation;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getRecieveDate() {
        return recieveDate;
    }

    public void setRecieveDate(String recieveDate) {
        this.recieveDate = recieveDate;
    }

    public String getRecieveAddress() {
        return recieveAddress;
    }

    public void setRecieveAddress(String recieveAddress) {
        this.recieveAddress = recieveAddress;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
}
