package com.mm.domain;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer orderId;
    private Integer bookId;
    private Integer userId;
    private User user;
    private Date addTime;
    private double orderTotal;
    private Integer isDelete;
    //订单状态
    private Integer orderStatus;

    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(Integer orderId, Integer bookId, Integer userId, User user, Date addTime, double orderTotal, Integer isDelete, Integer orderStatus, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.userId = userId;
        this.user = user;
        this.addTime = addTime;
        this.orderTotal = orderTotal;
        this.isDelete = isDelete;
        /**
         * 订单状态
         * 待发货 0
         * 已取消 1
         * 已发货 2
         * 已收获 3
         */
        this.orderStatus = orderStatus;
        this.orderDetails = orderDetails;
    }

    public Integer getorderId() {
        return orderId;
    }

    public void setorderId(Integer orderId) {
        this.orderId = orderId;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }


    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", user=" + user +
                ", addTime=" + addTime +
                ", orderTotal=" + orderTotal +
                ", isDelete=" + isDelete +
                ", orderStatus=" + orderStatus +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
