package com.mm.domain;

/**
 * 购物车
 */
public class Car {
    private Integer carId;
    private Integer bookId;
    private Integer userId;
    private double bookPrice;
    private Integer purchaseNum;
    private double purchaseTotal;

    private  User user;
    private Book book;

    public Car() {
    }

    public Car(Integer carId, Integer bookId, Integer userId, double bookPrice, Integer purchaseNum, double purchaseTotal, User user, Book book) {
        this.carId = carId;
        this.bookId = bookId;
        this.userId = userId;
        this.bookPrice = bookPrice;
        this.purchaseNum = purchaseNum;
        this.purchaseTotal = purchaseTotal;
        this.user = user;
        this.book = book;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public double getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(double purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", bookPrice=" + bookPrice +
                ", purchaseNum=" + purchaseNum +
                ", purchaseTotal=" + purchaseTotal +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
