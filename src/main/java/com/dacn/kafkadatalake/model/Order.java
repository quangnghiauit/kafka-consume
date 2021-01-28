package com.dacn.kafkadatalake.model;


import com.dacn.kafkadatalake.dto.request.OrderConsumerDTO;

import javax.persistence.*;

@Entity
@Table(name = "datalakeorders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;

//    @Column(name ="RulID")
//    private int rulID;

    @Column(name ="CusID")
    private int cusID;

    @Column(name ="CreatedDate")
    private String createdDate;

    @Column(name ="Status")
    private int status;

    @Column(name ="TotalAmount")
    private float totalAmount;

    @Column(name ="ReceiverName")
    private String receiverName;

    @Column(name ="ReceiverPhone")
    private int receiverPhone;

    @Column(name ="ReceiverLocation")
    private int receiveLocation;

    @Column(name ="VolumeProduction")
    private float volumeProduction;

    @Column(name ="TypeProduct")
    private String typeProduct;

    @Column(name ="Description")
    private String description;

    @Column(name ="SenderName")
    private String senderName;

    @Column(name ="SenderPhone")
    private long senderPhone;

    @Column(name ="SenderLocation")
    private int senderLocation;

    @Column(name ="ExpectedDate")
    private String expectedDate;

    @Column(name ="RecieveDate")
    private String recieveDate;

    @Column(name ="RecieveAddress")
    private String recieveAddress;

    @Column(name ="SenderAddress")
    private String senderAddress;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void doMappingEntity(OrderConsumerDTO request) {
        this.cusID = request.getCusID();
        this.createdDate = request.getCreatedDate();
        this.status = request.getStatus();
        this.totalAmount = request.getTotalAmount();
        this.receiverName = request.getReceiverName();
        this.receiverPhone = request.getReceiverPhone();
        this.receiveLocation = request.getReceiveLocation();
        this.volumeProduction = request.getVolumeProduction();
        this.typeProduct = request.getTypeProduct();
        this.description = request.getDescription();
        this.senderName = request.getSenderName();
        this.senderPhone = request.getSenderPhone();
        this.senderLocation = request.getSenderLocation();
        this.expectedDate = request.getExpectedDate();
        this.recieveDate = request.getRecieveDate();
        this.recieveAddress = request.getRecieveAddress();
        this.senderAddress = request.getSenderAddress();
    }
}
