package com.example.banhanghoaqua.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banhanghoaqua.R;
import com.example.banhanghoaqua.model.ModelOrder;
import com.example.banhanghoaqua.storage.StorageOrder;
import com.example.banhanghoaqua.utils.Utils;

import java.util.ArrayList;

public class MainProductDetails extends AppCompatActivity {

    public String nameProduct;
    public String priceProduct;
    public String desProduct;
    public int imageProduct;

    public TextView textNameProduct;
    public TextView textPriceProduct;
    public TextView texDesProduct;
    public ImageView _imageProduct;
    public Button btnBuy;

    public TextView textBuyQuantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product_details);

        textNameProduct = findViewById(R.id.nameProductDetails);
        textPriceProduct = findViewById(R.id.priceProductDetails);
        texDesProduct = findViewById(R.id.desProductDetails);
        _imageProduct = findViewById(R.id.imageProductDetails);
        btnBuy = findViewById(R.id.btnBuy);
        textBuyQuantity = findViewById(R.id.editBuyQuantity);

        Intent intent = getIntent();
        this.nameProduct = intent.getStringExtra("nameProduct");
        this.priceProduct = intent.getStringExtra("priceProduct");
        this.desProduct = intent.getStringExtra("desProduct");
        this.imageProduct = intent.getIntExtra("imageProduct",R.drawable.ic_launcher_background);
        textNameProduct.setText(this.nameProduct);
        textPriceProduct.setText(this.priceProduct);
        texDesProduct.setText(this.desProduct);
        _imageProduct.setImageResource(this.imageProduct);

        //Xử lý sự kiện mua hàng
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyProduct(view);
            }
        });

    }

    public void buyProduct(View view)
    {
        Utils utils = new Utils();
        if(textBuyQuantity.getText().toString().isEmpty())
        {
            utils.showMessage(MainProductDetails.this,"Bạn cần nhập số lượng để mua!",1);
            return;
        }

        if(Integer.parseInt(textBuyQuantity.getText().toString()) == 0)
        {
            utils.showMessage(MainProductDetails.this,"So luong mua phai lon hon 0",1);
            return;
        }

        StorageOrder storageOrder = StorageOrder.getInstance();
        ArrayList<ModelOrder> listOrder = storageOrder.getData();
        listOrder.add(new ModelOrder(this.nameProduct,this.priceProduct,this.desProduct,this.imageProduct,Integer.parseInt(textBuyQuantity.getText().toString())));
        storageOrder.setData(listOrder);
        utils.showMessage(MainProductDetails.this,"Mua hang thanh cong!",1);
    }
}