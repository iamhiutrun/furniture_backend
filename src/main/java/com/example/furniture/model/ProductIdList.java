package com.example.furniture.model;

import java.util.List;

public class ProductIdList {
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public ProductIdList(List<Long> ids) {
        this.ids = ids;
    }

    public ProductIdList() {
    }
}
