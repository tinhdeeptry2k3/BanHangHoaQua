package com.example.banhanghoaqua.utils;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Utils {
    public void openActivity(AppCompatActivity parent, Class<?> childClass) {
        Intent intent = new Intent(parent, childClass);
        parent.startActivity(intent);
    }

    public  void showMessage(AppCompatActivity parent, String message, Integer timeout)
    {
        Toast.makeText(parent, message, timeout).show();
    }
}
