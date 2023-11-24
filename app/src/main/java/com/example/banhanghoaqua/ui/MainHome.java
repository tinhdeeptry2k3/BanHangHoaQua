package com.example.banhanghoaqua.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.banhanghoaqua.R;
import com.example.banhanghoaqua.utils.Utils;

public class MainHome extends AppCompatActivity {

    private Button btnProduct;
    private Button btnOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        //Xử lý nút sản phẩm
        btnProduct = (Button) findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils utils = new Utils();
                utils.openActivity(MainHome.this,MainProduct.class);
            }
        });

        //Xử lý nút order
        btnOrder = (Button) findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils utils = new Utils();
                utils.openActivity(MainHome.this,MainOrder.class);
            }
        });
    }
}