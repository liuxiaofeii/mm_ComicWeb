package com.mm.domain;

public class Content {
    private Integer contentId;
    private Integer contentNum;
    private Integer contentNumId;
    private String isDelete;
    private Integer bookId;

    public Content() {
    }

    public Content(Integer contentId, Integer contentNum, Integer contentNumId, String isDelete, Integer bookId) {
        this.contentId = contentId;
        this.contentNum = contentNum;
        this.contentNumId = contentNumId;
        this.isDelete = isDelete;
        this.bookId = bookId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getContentNum() {
        return contentNum;
    }

    public void setContentNum(Integer contentNum) {
        this.contentNum = contentNum;
    }

    public Integer getContentNumId() {
        return contentNumId;
    }

    public void setContentNumId(Integer contentNumId) {
        this.contentNumId = contentNumId;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", contentNum=" + contentNum +
                ", contentNumId=" + contentNumId +
                ", isDelete='" + isDelete + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
