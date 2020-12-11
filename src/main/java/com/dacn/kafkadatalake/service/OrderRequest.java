package com.dacn.kafkadatalake.service;

public class OrderRequest {
    private int cusID;
    private int rulID;
    private int status;
    private float totalAmount;
    private float volumeProduction;
    private String createdDate;
    private String receiverName;
    private String receiverPhone;
    private String wardIdReceiver;
    private String districtIdReceiver;
    private String provinceIdReceiver;
    private String locDescriptionReceiver;
    private String typeProduct;
    private String description;

    public OrderRequest() {
        this.cusID = 2;
        this.rulID = 1;
        this.status = 1;
        this.totalAmount = 756456545;
        this.volumeProduction = 1;
        this.createdDate = "2020-12-09 00:00:00";
        this.receiverName = "Nghia";
        this.receiverPhone = "097876765767";
        this.wardIdReceiver = "4";
        this.districtIdReceiver = "5";
        this.provinceIdReceiver = "6";
        this.locDescriptionReceiver = "184 Lê Đại Hành";
        this.typeProduct = "AirPods Pro";
        this.description = "Tai nghe AirPods Pro sạc không dây Apple MWP22";
    }

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

    public String getWardIdReceiver() {
        return wardIdReceiver;
    }

    public void setWardIdReceiver(String wardIdReceiver) {
        this.wardIdReceiver = wardIdReceiver;
    }

    public String getDistrictIdReceiver() {
        return districtIdReceiver;
    }

    public void setDistrictIdReceiver(String districtIdReceiver) {
        this.districtIdReceiver = districtIdReceiver;
    }

    public String getProvinceIdReceiver() {
        return provinceIdReceiver;
    }

    public void setProvinceIdReceiver(String provinceIdReceiver) {
        this.provinceIdReceiver = provinceIdReceiver;
    }

    public String getLocDescriptionReceiver() {
        return locDescriptionReceiver;
    }

    public void setLocDescriptionReceiver(String locDescriptionReceiver) {
        this.locDescriptionReceiver = locDescriptionReceiver;
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
