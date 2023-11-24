package com.example.banhanghoaqua.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.banhanghoaqua.R;
import com.example.banhanghoaqua.apdapter.AdapterSanPham;
import com.example.banhanghoaqua.model.ModelSanPham;
import com.example.banhanghoaqua.utils.Utils;

import java.util.ArrayList;

public class MainProduct extends AppCompatActivity {

    private ListView listView;
    ArrayList<ModelSanPham> arrayList;
    AdapterSanPham adapterSanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product);

        listView = findViewById(R.id.listProduct);

        arrayList = new ArrayList<>();
        arrayList.add(new ModelSanPham("Bánh mì","100.000 đ", "Mô tả 1" ,R.drawable.ic_launcher_background));
        arrayList.add(new ModelSanPham("Rau muống","150.000 đ","Mô tả 2", R.drawable.ic_launcher_background));
        arrayList.add(new ModelSanPham("Rau cải","100.000 đ", "Mô tả 3",R.drawable.ic_launcher_background));
        arrayList.add(new ModelSanPham("Rau súp lơ","50.000 đ", "Mô tả 4",R.drawable.ic_launcher_foreground));
        arrayList.add(new ModelSanPham("Rau nawin","80.000 đ", "Mô tả 5",R.drawable.ic_launcher_background));


        adapterSanPham = new AdapterSanPham(MainProduct.this,R.layout.item_product,arrayList);
        listView.setAdapter(adapterSanPham);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ModelSanPham sanPham = arrayList.get(i);
                Toast.makeText(MainProduct.this, sanPham.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainProduct.this, MainProductDetails.class);
                intent.putExtra("nameProduct",sanPham.getName());
                intent.putExtra("priceProduct",sanPham.getPrice());
                intent.putExtra("desProduct",sanPham.getDes());
                intent.putExtra("imageProduct",sanPham.getImage());
                startActivity(intent);
            }
        });
    }
}