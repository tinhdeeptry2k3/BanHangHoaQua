package com.example.banhanghoaqua.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.banhanghoaqua.R;
import com.example.banhanghoaqua.model.ModelOrder;
import com.example.banhanghoaqua.storage.StorageOrder;
import com.example.banhanghoaqua.utils.PushOrder;
import com.example.banhanghoaqua.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;

public class MainPayment extends AppCompatActivity {

    private Button btnPaymentNow;
    private TextView tFullname;
    private TextView tAddress;
    private TextView tPhone;

    private Integer totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_payment);

        StorageOrder storageOrder = StorageOrder.getInstance();
        ArrayList<ModelOrder> listOrder = storageOrder.getData();

        totalPrice = 0;
        for(int i = 0; i < listOrder.size();i++)
        {
            totalPrice = totalPrice + (Integer.parseInt(listOrder.get(i).getPrice().replace(" đ","").replace(".","")) * listOrder.get(i).getQuantity());
        }

        TextView myTextView = findViewById(R.id.textTotalPrice);

        // Đặt nội dung cho TextView
        myTextView.setText("Tổng tiền: " + totalPrice.toString() + " đ");

        //Xử lý nút thanh toán
        btnPaymentNow = findViewById(R.id.btnPaymentnow);
        btnPaymentNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPaymentNow(view);
            }
        });
    }

    public void btnPaymentNow(View view)
    {
        Utils utils = new Utils();
        tFullname = findViewById(R.id.textFullname);
        tAddress = findViewById(R.id.textAddress);
        tPhone = findViewById(R.id.textPhone);

        StorageOrder storageOrder = StorageOrder.getInstance();
        ArrayList<ModelOrder> listOrder = storageOrder.getData();


        try {
            String lstProduct = "\n";
            for(int i = 0; i < listOrder.size();i++)
            {
                String name = listOrder.get(i).getName();
                Integer quantity = listOrder.get(i).getQuantity();
                lstProduct = lstProduct + "Sản phẩm: " + name  + " Số lượng: " + quantity.toString();
            }
            PushOrder pushOrder = new PushOrder();
            pushOrder.send(String.format("Thông tin đơn hàng:\nHọ tên: %s\nĐịa chỉ: %s\nSố điện thoại: %s\n Tổng tiền: %s\nChi tiết đơn hàng: %s",tFullname,tAddress,tPhone,totalPrice,lstProduct));
        } catch (Exception e) {
            //utils.showMessage(MainPayment.this,e.toString(),1);
        }

        utils.showMessage(MainPayment.this,"Thanh toán thành công !",1);
        utils.openActivity(MainPayment.this,MainHome.class);
        storageOrder.setData(new ArrayList<ModelOrder>());

    }
}