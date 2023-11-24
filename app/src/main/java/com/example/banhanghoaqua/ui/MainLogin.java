package com.example.banhanghoaqua.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.banhanghoaqua.R;
import com.example.banhanghoaqua.model.ModelOrder;
import com.example.banhanghoaqua.utils.Utils;

import java.util.List;

public class MainLogin extends AppCompatActivity {

    private Button btnLogin;
    private TextView username;
    private TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Xử lí đăng nhập
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLogin(view);
            }
        });
    }

    public void btnLogin(View view)
    {
        Utils utils = new Utils();
        username = findViewById(R.id.editUsername);
        password = findViewById(R.id.editPassword);
        if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
        {
            utils.showMessage(MainLogin.this,"Tài khoản hoặc mật khẩu không được để trống !",1);
            return;
        }
        utils.openActivity(MainLogin.this,MainHome.class);
    }
}