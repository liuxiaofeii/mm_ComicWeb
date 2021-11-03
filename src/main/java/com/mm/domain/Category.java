package com.mm.domain;

public class Category {
    private Integer categoryId;
    private String categoryName;
    private String isDelete;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, String isDelete) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.isDelete = isDelete;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}
