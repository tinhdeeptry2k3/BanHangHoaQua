package com.example.banhanghoaqua.apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banhanghoaqua.R;
import com.example.banhanghoaqua.model.ModelOrder;
import com.example.banhanghoaqua.model.ModelSanPham;

import java.util.List;

public class AdapterOrder extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ModelOrder> arrayList;

    public AdapterOrder(Context context, int layout, List<ModelOrder> arrayList) {
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
        ModelOrder order = arrayList.get(i);

        TextView textv1 = view.findViewById(R.id.nameOrder);
        TextView textv2 = view.findViewById(R.id.priceOrder);
        TextView textv3 = view.findViewById(R.id.quantityOrder);
        ImageView imageView = view.findViewById(R.id.imageOrder);

        textv1.setText(order.getName());
        textv2.setText(order.getPrice());
        Integer q = order.getQuantity();
        textv3.setText("Số lượng: " + q.toString());
        imageView.setImageResource(order.getImage());
        return view;
    }
}
