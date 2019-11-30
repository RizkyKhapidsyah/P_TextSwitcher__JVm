package com.rizkykhapidsyah.p_textswitcher__jvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    TextSwitcher TS_Demo_IDJAVA;
    Button B_Sebelumnya_IDJAVA, B_Selanjutnya_IDJAVA;
    String strTextSwitcher[] = {
            "Text Switcher 1",
            "Text Switcher 2",
            "Text Switcher 3",
            "Text Switcher 4",
            "Text Switcher 5",
            "Text Switcher 6",
            "Text Switcher 7"
    };

    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B_Sebelumnya_IDJAVA = findViewById(R.id.B_Sebelumnya_IDXML);
        B_Selanjutnya_IDJAVA = findViewById(R.id.B_Selanjutnya_IDXML);
        TS_Demo_IDJAVA = findViewById(R.id.TS_Demo_IDXML);

        TS_Demo_IDJAVA.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView T = new TextView(MainActivity.this);
                T.setGravity(Gravity.TOP | Gravity.CENTER);
                T.setTextSize(36);
                return T;
            }
        });

        TS_Demo_IDJAVA.setCurrentText("Klik Tombol 'Selanjutnya'");

        B_Sebelumnya_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex = currentIndex - 1;
                    TS_Demo_IDJAVA.setText(strTextSwitcher[currentIndex]);
                }
            }
        });

        B_Selanjutnya_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < strTextSwitcher.length - 1) {
                    currentIndex = currentIndex + 1;
                    TS_Demo_IDJAVA.setText(strTextSwitcher[currentIndex]);
                }
            }
        });

    }
}
