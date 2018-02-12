package com.faranegar.shahabshahab.personalinfo;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements PersonalInfo.OnFirstNameValidationListener {

    PersonalInfo mPersonalInfo;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPersonalInfo = findViewById(R.id.personal_info);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "" +"fonts/font_bold.ttf");
        mPersonalInfo.setFontTypeFace(typeface);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPersonalInfo.firstNameVailidate();
            }
        });

    }

    @Override
    public void onFirstName() {

    }
}
