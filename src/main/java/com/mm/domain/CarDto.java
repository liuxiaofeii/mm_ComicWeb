package com.mm.domain;

public class CarDto {
    private Integer carId;
    private Integer purchaseNum;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "carId=" + carId +
                ", purchaseNum=" + purchaseNum +
                '}';
    }
}
