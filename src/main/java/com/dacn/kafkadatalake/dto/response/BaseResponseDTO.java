package com.dacn.kafkadatalake.dto.response;

import com.dacn.kafkadatalake.enumeration.ReturnCodeEnum;
import com.dacn.kafkadatalake.enumeration.TransStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

public class BaseResponseDTO<T> {

    @JsonProperty("returnCode") //Jackson annotation
    @SerializedName(value = "returnCode", alternate = "returncode")// Gson annotation
    protected int returncode;

    @JsonProperty("returnMessage")
    protected String returnmessage;

    @SerializedName(value = "data", alternate = "result")
    private T data;

    @SerializedName(value = "datas", alternate = "listResult")
    private List<T> datas;

    public BaseResponseDTO() {
    }

    public BaseResponseDTO(int returncode, @Nullable String returnmessage) {
        this.returncode = returncode;
        this.returnmessage = returnmessage;
    }

    public BaseResponseDTO(int returncode, @Nullable String returnmessage, @Nullable T result) {
        this(returncode, returnmessage);
        this.data = result;
    }

    public BaseResponseDTO(int returncode, @Nullable String returnmessage, @Nullable List<T> datas) {
        this(returncode, returnmessage);
        this.datas = datas;
    }

    public BaseResponseDTO success(String returnmessage) {
        this.returncode = 1;
        this.returnmessage = returnmessage;
        return this;
    }

    public BaseResponseDTO success(int returnCode, String returnmessage) {
        this.returncode = returnCode;
        this.returnmessage = returnmessage;
        return this;
    }

    public BaseResponseDTO success(ReturnCodeEnum type) {
        this.returncode = type.getValue();
        this.returnmessage = type.getMessage();
        return this;
    }

    public BaseResponseDTO fail(String returnmessage) {
        this.returncode = TransStatusEnum.EXCEPTION.getValue();
        this.returnmessage = returnmessage;
        return this;
    }

    public BaseResponseDTO fail(int returnCode, String returnmessage) {
        this.returncode = returnCode;
        this.returnmessage = returnmessage;
        return this;
    }

    public BaseResponseDTO<T> success(@NonNull String returnmessage, @NonNull T data) {
        this.returncode = TransStatusEnum.SUCCESSFUL.getValue();
        this.returnmessage = returnmessage;
        this.data = data;
        return this;
    }

    public BaseResponseDTO<T> success(@NonNull String returnmessage, @NonNull List<T> datas) {
        this.returncode = TransStatusEnum.SUCCESSFUL.getValue();
        this.returnmessage = returnmessage;
        this.datas = datas;
        return this;
    }

    public BaseResponseDTO<T> fail(TransStatusEnum type, @NonNull String returnmessage,
                                   @NonNull T data) {
        this.returncode = type.getValue();
        this.returnmessage = returnmessage;
        this.data = data;
        return this;
    }

    public BaseResponseDTO cloneByOne(@NonNull BaseResponseDTO<T> src) {
        returncode = src.getReturncode();
        returnmessage = src.getReturnmessage();
        data = src.getData();
        return this;
    }

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getReturnmessage() {
        return returnmessage;
    }

    public void setReturnmessage(String returnmessage) {
        this.returnmessage = returnmessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
