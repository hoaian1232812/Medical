package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class FunctionChoose extends AppCompatActivity {

    /*
    use case 2 Đăng ký lịch khám mới
    2. oncreate()
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_choose);
            /*
        use case 2 Đăng ký lịch khám mới
        3. Chọn chức năng đăng ký lịch khám mới
        */
        LinearLayout layout = findViewById(R.id.left_layout);
        layout.setOnClickListener(v ->{
//            Intent intent
        });
    }
}