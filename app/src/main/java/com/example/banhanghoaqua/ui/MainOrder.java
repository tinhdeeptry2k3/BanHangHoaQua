package com.example.banhanghoaqua.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.banhanghoaqua.R;
import com.example.banhanghoaqua.apdapter.AdapterOrder;
import com.example.banhanghoaqua.apdapter.AdapterSanPham;
import com.example.banhanghoaqua.model.ModelOrder;
import com.example.banhanghoaqua.model.ModelSanPham;
import com.example.banhanghoaqua.storage.StorageOrder;
import com.example.banhanghoaqua.utils.Utils;

import java.util.ArrayList;

public class MainOrder extends AppCompatActivity {

    private ListView listView;
    AdapterOrder adapterOrder;

    private Button btnDoneOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_order);

        listView = findViewById(R.id.listOrder);

        StorageOrder storageOrder = StorageOrder.getInstance();
        ArrayList<ModelOrder> listOrder = storageOrder.getData();
        adapterOrder = new AdapterOrder(MainOrder.this,R.layout.item_order,listOrder);
        listView.setAdapter(adapterOrder);

        //Xử lí nút hoàn thành đơn đặt hàng
        btnDoneOrder = findViewById(R.id.btnDoneOrder);
        btnDoneOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDoneOrder(view);
            }
        });
    }

    public void btnDoneOrder(View view)
    {
        Utils utils = new Utils();
        utils.openActivity(MainOrder.this, MainPayment.class);
    }
}