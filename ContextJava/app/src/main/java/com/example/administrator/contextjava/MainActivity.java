package com.example.administrator.contextjava;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button Btn1, Btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(Java 코드)");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        Btn1 = (Button) findViewById(R.id.Btn1);
        registerForContextMenu(Btn1);

        Btn2 = (Button) findViewById(R.id.Btn2);
        registerForContextMenu(Btn2);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == Btn1) {
            menu.setHeaderTitle("배경색 변경");
            menu.add(0, 1, 0, "배경색(빨강)");
            menu.add(0, 2, 0, "배경색(초록)");
            menu.add(0, 3, 0, "배경색(파랑)");

        }
        if (v == Btn2) {
            menu.add(0, 4, 0, "버튼 45도 회전");
            menu.add(0, 5, 0, "버튼 2배 확대");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                Btn2.setRotation(45);
                return true;
            case 5:
                Btn2.setScaleX(2);
                return true;
        }
        return false;
    }
}
