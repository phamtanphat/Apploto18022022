package com.example.apploto18022022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText mEdtInput;
    Button mBtnRao, mBtnReset, mBtnAdd;
    TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        event();
    }

    private void event() {

        // Arraylist

        // Create
        ArrayList<String> arrNames = new ArrayList<>();

        // Thêm
        arrNames.add("Tèo"); // 0
        arrNames.add("Tý"); // 1
        arrNames.add("Tủn");  // 2

        // Cập nhật
        arrNames.set(2, "Tuấn");

        // Xóa
        arrNames.remove(0);

        // Lấy dữ liệu
        Log.d("BBB",arrNames.get(0));
    }

    private void initView() {
        mEdtInput = findViewById(R.id.editTextNumberCount);
        mBtnRao = findViewById(R.id.buttonRao);
        mBtnReset = findViewById(R.id.buttonReset);
        mTvResult = findViewById(R.id.textViewResult);
        mBtnAdd = findViewById(R.id.buttonAdd);

        // disable View
        isEnableView(false, mBtnRao);
        isEnableView(false, mBtnReset);
    }

    private void isEnableView(boolean isEnable, View view) {
        view.setEnabled(isEnable);
    }
}