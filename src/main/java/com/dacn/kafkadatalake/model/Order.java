package com.dacn.kafkadatalake.model;


import com.dacn.kafkadatalake.dto.request.OrderConsumerDTO;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;

    @Column(name ="RulID")
    private int rulID;

    @Column(name ="CusID")
    private int cusID;

    @Column(name ="CreatedDate")
    private String createdDate;

    @Column(name ="Status")
    private int status;

    @Column(name ="TotalAmount")
    private float totalAmount;

    @Column(name ="ReceiveName")
    private String receiveName;

    @Column(name ="ReceivePhone")
    private int receivePhone;

    @Column(name ="ReceiveLocation")
    private int receiveLocation;

    @Column(name ="VolumeProduction")
    private float volumeProduction;

    @Column(name ="TypeProduct")
    private String typeProduct;

    @Column(name ="Description")
    private String description;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRulID() {
        return rulID;
    }

    public void setRulID(int rulID) {
        this.rulID = rulID;
    }

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

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public int getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(int receivePhone) {
        this.receivePhone = receivePhone;
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

    public int getReceiveLocation() {
        return receiveLocation;
    }

    public void setReceiveLocation(int receiveLocation) {
        this.receiveLocation = receiveLocation;
    }

    public void doMappingEntity(OrderConsumerDTO request) {
        this.rulID = request.getRulID();
        this.cusID = request.getCusID();
        this.status = request.getStatus();
        this.totalAmount = request.getTotalAmount();
        this.receiveName = request.getReceiverName();
        this.receivePhone = Integer.parseInt(request.getReceiverPhone());
        this.receiveLocation = request.getReceiveLocation();
        this.volumeProduction = request.getVolumeProduction();
        this.typeProduct = request.getTypeProduct();
        this.description = request.getDescription();
        this.createdDate = request.getCreatedDate();
    }
}
