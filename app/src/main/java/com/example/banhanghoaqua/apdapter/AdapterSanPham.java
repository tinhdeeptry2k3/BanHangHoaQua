package com.example.banhanghoaqua.apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banhanghoaqua.R;
import com.example.banhanghoaqua.model.ModelSanPham;

import java.util.List;

public class AdapterSanPham  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ModelSanPham> arrayList;

    public AdapterSanPham(Context context, int layout, List<ModelSanPham> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        ModelSanPham sanPham = arrayList.get(i);

        TextView textv1 = view.findViewById(R.id.nameProduct);
        TextView textv2 = view.findViewById(R.id.priceProduct);
        TextView textv3 = view.findViewById(R.id.desProduct);
        ImageView imageView = view.findViewById(R.id.imageProduct);

        textv1.setText(sanPham.getName());
        textv2.setText(sanPham.getPrice());
        textv3.setText(sanPham.getDes());
        imageView.setImageResource(sanPham.getImage());
        return view;
    }
}
