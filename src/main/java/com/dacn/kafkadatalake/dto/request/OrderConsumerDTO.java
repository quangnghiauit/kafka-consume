package com.dacn.kafkadatalake.dto.request;

public class OrderConsumerDTO {
    private int cusID;
    private int rulID;
    private int status;
    private float totalAmount;
    private float volumeProduction;
    private String createdDate;
    private String receiverName;
    private String receiverPhone;
    private int receiveLocation;
    private String typeProduct;
    private String description;

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public int getRulID() {
        return rulID;
    }

    public void setRulID(int rulID) {
        this.rulID = rulID;
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

    public float getVolumeProduction() {
        return volumeProduction;
    }

    public void setVolumeProduction(float volumeProduction) {
        this.volumeProduction = volumeProduction;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public int getReceiveLocation() {
        return receiveLocation;
    }

    public void setReceiveLocation(int receiveLocation) {
        this.receiveLocation = receiveLocation;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
