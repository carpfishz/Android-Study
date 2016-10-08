package com.example.administrator.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnProduct, btnDivision, btnModulo;
    TextView textResult;
    String num1, num2;
    Double result1, result2; // result1: 실수값 계산, result2: 소수점 2자리 표시

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기(수정)");                            //어플리케이션 제목

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnProduct = (Button) findViewById(R.id.BtnProduct);
        btnDivision = (Button) findViewById(R.id.BtnDivision);
        btnModulo = (Button) findViewById(R.id.BtnModulo);
        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.trim().equals("") || num2.trim().equals("")) {     //입력값이 없을 경우
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    result1 = Double.parseDouble(num1) + Double.parseDouble(num2);
                    result2 = Double.parseDouble(String.format("%.2f", result1));
                    textResult.setText("계산 결과 : " + result2.toString());
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.trim().equals("") || num2.trim().equals("")) {     //입력값이 없을 경우
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    result1 = Double.parseDouble(num1) - Double.parseDouble(num2);
                    result2 = Double.parseDouble(String.format("%.2f", result1));
                    textResult.setText("계산 결과 : " + result2.toString());
                }
            }
        });

        btnProduct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.trim().equals("") || num2.trim().equals("")) {     //입력값이 없을 경우
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    result1 = Double.parseDouble(num1) * Double.parseDouble(num2);
                    result2 = Double.parseDouble(String.format("%.2f", result1));
                    textResult.setText("계산 결과 : " + result2.toString());
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.trim().equals("") || num2.trim().equals("")) {     //입력값이 없을 경우
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    if (num2.trim().equals("0")) {                          //두번째 입력값이 0일 경우
                        Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        result1 = Double.parseDouble(num1) / Double.parseDouble(num2);
                        result2 = Double.parseDouble(String.format("%.2f", result1));
                        textResult.setText("계산 결과 : " + result2.toString());
                    }
                }
            }
        });

        btnModulo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.trim().equals("") || num2.trim().equals("")) {     //입력값이 없을 경우
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    if (num2.trim().equals("0")) {                          //두번째 입력값이 0일 경우
                        Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        result1 = Double.parseDouble(num1) % Double.parseDouble(num2);
                        result2 = Double.parseDouble(String.format("%.2f", result1));
                        textResult.setText("계산 결과 : " + result2.toString());
                    }
                }
            }
        });
    }
}