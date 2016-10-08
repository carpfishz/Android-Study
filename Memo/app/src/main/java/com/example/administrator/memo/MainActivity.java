package com.example.administrator.memo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText memo_content;
    Button btnFileLoad, btnFileSave, btnFileDelete;
    public static String FILE_NAME = "Memo.txt";

    public void save(String str) {
        if(str == null || str.equals("")) {
            return;
        }

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(str.getBytes());
        } catch(Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    public String load() {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte [] memoStr = new byte[fis.available()];
            while(fis.read(memoStr) != -1) {}
            return new String(memoStr);
        } catch (IOException IOEX) {
            System.out.print(IOEX.getMessage());
        }
        return "";
    }

    public void delete() {
        deleteFile(FILE_NAME);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memo_content = (EditText) findViewById(R.id.memo_content);
        btnFileLoad = (Button) findViewById(R.id.btnFileLoad);
        btnFileSave = (Button) findViewById(R.id.btnFileSave);
        btnFileDelete = (Button) findViewById(R.id.btnFileDelete);

        btnFileLoad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String memo_str = load();
                memo_content.setText(memo_str);

                Toast.makeText(getApplicationContext(), "파일을 불러왔습니다~.", Toast.LENGTH_SHORT).show();
            }
        });

        btnFileSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String memo_str = memo_content.getText().toString();
                save(memo_str);
                memo_content.setText("");

                Toast.makeText(getApplicationContext(), "저장 되었습니다~.", Toast.LENGTH_SHORT).show();
            }
        });

        btnFileDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                delete();
                memo_content.setText("");

                Toast.makeText(getApplicationContext(), "삭제 되었습니다~", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
