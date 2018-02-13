package com.faranegar.shahabshahab.personalinfo;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements
        PersonalInfo.OnFirstNameValidationListener,
        PersonalInfo.OnPhoneNumberValidationListener{

    PersonalInfo mPersonalInfo;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPersonalInfo = findViewById(R.id.personal_info);
        mPersonalInfo.setOnFirstNameValidationListener(this);
        mPersonalInfo.setOnPhoneNumberValidationListener(this);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/font_bold.ttf");
        mPersonalInfo.setFontTypeFace(typeface);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onFirstName(String firstName) {
        if( firstName.length() == 0 ){
//            mPersonalInfo.getTextInputLayouts().get(0).setError("درست وارد کنید:");
        }
    }

    @Override
    public void onPhone(String phoneNumber) {
        if( phoneNumber.equals("09383181063") ){
//            mPersonalInfo.getTextInputLayouts().get(5).setError("eyvallah");
        }else{

        }
    }
}
