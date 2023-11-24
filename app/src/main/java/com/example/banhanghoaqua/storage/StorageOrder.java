package com.example.banhanghoaqua.storage;

import com.example.banhanghoaqua.model.ModelOrder;

import java.util.ArrayList;
import java.util.List;

public class StorageOrder {
    private static StorageOrder instance;
    private ArrayList<ModelOrder> data;

    private StorageOrder() {
        data = new ArrayList<ModelOrder>();
    }

    public static synchronized StorageOrder getInstance() {
        if (instance == null) {
            instance = new StorageOrder();
        }
        return instance;
    }

    public ArrayList<ModelOrder> getData() {
        return data;
    }

    public void setData(ArrayList<ModelOrder> data) {
        this.data = data;
    }
}
