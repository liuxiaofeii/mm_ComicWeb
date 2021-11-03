package com.mm.domain;

/**
 * 收藏类
 *
 */
public class Sc {
    private Integer scId;
    private Integer bookId;
    private Integer userId;
    private Book book;

    public Sc() {
    }

    public Sc(Integer scId, Integer bookId, Integer userId, Book book) {
        this.scId = scId;
        this.bookId = bookId;
        this.userId = userId;
        this.book = book;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Sc{" +
                "scId=" + scId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", book=" + book +
                '}';
    }
}

