package com.example.apploto18022022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText mEdtInput;
    Button mBtnRao, mBtnReset, mBtnAdd;
    TextView mTvResult;
    ArrayList<Integer> mArrNumbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        event();
    }

    private void event() {
        // thêm số
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check number
                String textNumber = mEdtInput.getText().toString();

                if (textNumber.isEmpty()){
                    Toast.makeText(MainActivity.this, "Number is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                int number = Integer.parseInt(textNumber);

                if (number < 10){
                    Toast.makeText(MainActivity.this, "Not less than 10 ", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add value into array
                if (mArrNumbers.size() > 0){
                    mArrNumbers.clear();
                }
                for (int i = 1 ;  i <= number ; i++){
                    mArrNumbers.add(i);
                }

                // ẩn button add và edittext , enable button rao và reset
                isEnableView(false,mBtnAdd);
                isEnableView(false,mEdtInput);

                isEnableView(true,mBtnRao);
                isEnableView(true,mBtnReset);
            }
        });

        // Chơi lại
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // - xóa dữ liệu trong mảng
                if (mArrNumbers != null && mArrNumbers.size() > 0){
                    mArrNumbers.clear();
                }
                // - xóa giao diện trong edittext
                mEdtInput.setText("");
                // - disable button rao , button reset
                isEnableView(false,mBtnRao);
                isEnableView(false,mBtnReset);
                // - enable button thêm số , edittext
                isEnableView(true,mBtnAdd);
                isEnableView(true,mEdtInput);


            }
        });
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

        //declare array
        mArrNumbers = new ArrayList<>();
    }

    private void isEnableView(boolean isEnable, View view) {
        view.setEnabled(isEnable);
    }
}