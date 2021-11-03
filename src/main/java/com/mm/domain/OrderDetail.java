package com.mm.domain;

public class OrderDetail {
    private Integer orderDetailId;
    private Integer bookId;
    private Book book;
    private Integer orderId;
    private Integer orderStatus;
    private Integer orderNum;
    private double orderTotal;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId, Integer bookId, Book book, Integer orderId, Integer orderStatus, Integer orderNum, double orderTotal) {
        this.orderDetailId = orderDetailId;
        this.bookId = bookId;
        this.book = book;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderNum = orderNum;
        this.orderTotal = orderTotal;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", bookId=" + bookId +
                ", book=" + book +
                ", orderId=" + orderId +
                ", orderStatus=" + orderStatus +
                ", orderNum=" + orderNum +
                ", orderTotal=" + orderTotal  +
                '}';
    }
}
