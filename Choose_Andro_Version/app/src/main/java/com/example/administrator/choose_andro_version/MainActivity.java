package com.example.administrator.choose_andro_version;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch startSwitch;
    RadioGroup radioGroup;
    RadioButton radioArray[] = new RadioButton[3];
    ImageView image;
    Button btnQuit, btnBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.text1);
        startSwitch = (Switch) findViewById(R.id.startSwitch);
        text2 = (TextView) findViewById(R.id.text2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioArray[0] = (RadioButton) findViewById(R.id.radioAnd43);
        radioArray[1] = (RadioButton) findViewById(R.id.radioAnd44);
        radioArray[2] = (RadioButton) findViewById(R.id.radioAnd50);
        image = (ImageView) findViewById(R.id.image);
        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnBegin = (Button) findViewById(R.id.btnBegin);

        startSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if (startSwitch.isChecked() == true) {                                          //true면 위젯들이 보임
                    text2.setVisibility(android.view.View.VISIBLE);
                    radioGroup.setVisibility(android.view.View.VISIBLE);
                    image.setVisibility(android.view.View.VISIBLE);
                    btnQuit.setVisibility(android.view.View.VISIBLE);
                    btnBegin.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    radioGroup.setVisibility(android.view.View.INVISIBLE);
                    image.setVisibility(android.view.View.INVISIBLE);
                    btnQuit.setVisibility(android.view.View.INVISIBLE);
                    btnBegin.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        final int draw[] = { R.drawable.jellybean, R.drawable.kitkat, R.drawable.lollipop };

        for (int i = 0; i < radioArray.length; i++) {
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    image.setImageResource(draw[index]);
                }
            });
        }

        btnQuit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

        btnBegin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                text2.setVisibility(android.view.View.INVISIBLE);
                radioGroup.setVisibility(android.view.View.INVISIBLE);
                image.setVisibility(android.view.View.INVISIBLE);
                btnQuit.setVisibility(android.view.View.INVISIBLE);
                btnBegin.setVisibility(android.view.View.INVISIBLE);
                radioGroup.clearCheck();
                startSwitch.setChecked(false);
            }
        });
    }
}
