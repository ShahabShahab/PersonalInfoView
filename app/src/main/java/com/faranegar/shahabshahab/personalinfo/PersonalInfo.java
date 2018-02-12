package com.faranegar.shahabshahab.personalinfo;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by faranegar on 2/12/18.
 */

public class PersonalInfo extends TextInputLayout {

    Boolean isPersianFirstNameIncluded, isPersianLastNameInCluded, isEnglishFirstNameIncluded, isEnglishLastNameIncluded;
    Boolean isNationalIDIncluded, isPhoneNumberIncluded;
    Typeface mTypeface = null;
    private OnFirstNameValidationListener mOnFirstNameValidationListener;


    int number_of_views_included = 0;
    private List<TextInputLayout> textInputLayouts = new ArrayList<>();

    public List<TextInputLayout> getTextInputLayouts() {
        return textInputLayouts;
    }

    public void setTextInputLayouts(List<TextInputLayout> textInputLayouts) {
        this.textInputLayouts = textInputLayouts;
    }

    public void setFontTypeFace(Typeface mTypeFace){
        this.mTypeface = mTypeFace;
        for( TextInputLayout textInputLayout: textInputLayouts )
            textInputLayout.setTypeface(getFontTypeFace());
    }

    public Typeface getFontTypeFace(){
            return this.mTypeface;
    }

    public OnFirstNameValidationListener getmOnFirstNameValidationListener() {
        return mOnFirstNameValidationListener;
    }

    public void setmOnFirstNameValidationListener(OnFirstNameValidationListener mOnFirstNameValidationListener) {
        this.mOnFirstNameValidationListener = mOnFirstNameValidationListener;
    }

    public PersonalInfo(Context context) {

        super(context);
        setParams(context, null);
    }


    public PersonalInfo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setParams(context, attrs);
    }

    public PersonalInfo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void setParams(Context context, @Nullable AttributeSet attr) {
        TypedArray a = context.obtainStyledAttributes(attr, R.styleable.PersonalInfo, 0,0);
        View view = LayoutInflater.from(context).inflate(R.layout.personal_info_row, this, true);
        LinearLayout mLinearLayout = view.findViewById(R.id.parent_personal);
        if( a.hasValue(R.styleable.PersonalInfo_persianFirstName) ){
            isPersianFirstNameIncluded = a.getBoolean(R.styleable.PersonalInfo_persianFirstName, false);
            number_of_views_included++;
        }
        if( a.hasValue(R.styleable.PersonalInfo_persianLastName) ){
            isPersianLastNameInCluded = a.getBoolean(R.styleable.PersonalInfo_persianLastName, false);
            number_of_views_included++;
        }
        if( a.hasValue(R.styleable.PersonalInfo_englishFirstName) ){
            isEnglishFirstNameIncluded = a.getBoolean(R.styleable.PersonalInfo_englishFirstName, false);
            number_of_views_included++;
        }
        if( a.hasValue(R.styleable.PersonalInfo_englishLastName) ){
            isEnglishLastNameIncluded = a.getBoolean(R.styleable.PersonalInfo_englishLastName, false);
            number_of_views_included++;
        }
        if( a.hasValue(R.styleable.PersonalInfo_nationalID) ){
            isNationalIDIncluded = a.getBoolean(R.styleable.PersonalInfo_nationalID, false);
            number_of_views_included++;
        }
        if( a.hasValue(R.styleable.PersonalInfo_phoneNumber) ){
            isPhoneNumberIncluded = a.getBoolean(R.styleable.PersonalInfo_phoneNumber, false);
            number_of_views_included++;
        }

        makeViews(context, attr, mLinearLayout, isPersianLastNameInCluded, isPersianFirstNameIncluded, isEnglishLastNameIncluded, isEnglishFirstNameIncluded,
                isPhoneNumberIncluded, isNationalIDIncluded);

    }

    private void makeViews(Context context, AttributeSet attr, LinearLayout mLinearLayout, Boolean isPersianLastNameInCluded, Boolean isPersianFirstNameIncluded, Boolean isEnglishLastNameIncluded, Boolean isEnglishFirstNameIncluded, Boolean isPhoneNumberIncluded, Boolean isNationalIDIncluded) {
        if( isPersianFirstNameIncluded ){
            LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("نام");
            textInputLayout.addView(editText);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if( isPersianLastNameInCluded ){
            LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("نام فارسی");
            textInputLayout.addView(editText);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }

        if(isEnglishFirstNameIncluded ){
            LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("English name");
            textInputLayout.addView(editText);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if(isEnglishLastNameIncluded){
            LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("English last name");
            textInputLayout.addView(editText);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if(isNationalIDIncluded){
            LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("کد ملی");
            textInputLayout.addView(editText);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if(isPhoneNumberIncluded){
            LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("شماره تماس");
            textInputLayout.addView(editText);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }

    }

    public interface OnPhoneNumberValidationListener {
        void onPhone();
    }
    public interface OnFirstNameValidationListener {
        void onFirstName();
    }
    public interface OnLastNameValidationListener {
        void onLastName();
    }

    public void firstNameVailidate(){
        if(textInputLayouts.get(0).getEditText().getText().length() == 0){
            textInputLayouts.get(0).setError("متسنماشیتشی");
        }
     }
}
