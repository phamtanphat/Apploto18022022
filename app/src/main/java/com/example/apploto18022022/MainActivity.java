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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtInput;
    Button mBtnRao, mBtnReset, mBtnAdd;
    TextView mTvResult;
    ArrayList<Integer> mArrNumbers;
    Random mRandom;
    String mResult = "";
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

                // clear result
                mResult = "";
                mTvResult.setText(mResult);
            }
        });

        mBtnRao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mArrNumbers.size() > 0){
                    // random trả về 1 vị trí ngẫu nhiên
                    int index = mRandom.nextInt(mArrNumbers.size());
                    int value = mArrNumbers.get(index);
                    // lấy giá trị ở vị trí đó và hiển thị lên ui
                    if(mArrNumbers.size() == 1){
                        mResult += value;
                    }else{
                        mResult += value + " - ";
                    }

                    mTvResult.setText(mResult);
                    // xóa giá trị ở vị trí đó
                    mArrNumbers.remove(index);
                }else{
                    Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                }
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

        //declare random
        mRandom = new Random();
    }

    private void isEnableView(boolean isEnable, View view) {
        view.setEnabled(isEnable);
    }
}