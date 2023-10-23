package com.annlu.springbootmall.dto;

import com.annlu.springbootmall.constant.ProductCategory;

public class ProductQueryParams {

    //將前端傳過來的參數 整理在ProductQueryParams中 方便做管理 程式較好維護

    private ProductCategory category;
    private String search;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
