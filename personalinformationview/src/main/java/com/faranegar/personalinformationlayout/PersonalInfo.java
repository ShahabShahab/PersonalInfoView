package com.faranegar.personalinformationlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by faranegar on 2/12/18.
 */

public class PersonalInfo extends TextInputLayout {

    Boolean isPersianFirstNameIncluded, isPersianLastNameInCluded, isEnglishFirstNameIncluded, isEnglishLastNameIncluded;
    Boolean isNationalIDIncluded, isPhoneNumberIncluded, isBirthDayIncluded;
    Typeface mTypeface = null;
    private OnFirstNameValidationListener onFirstNameValidationListener;
    private OnPhoneNumberValidationListener onPhoneNumberValidationListener;
    private View parent_view = null;

    public OnPhoneNumberValidationListener getOnPhoneNumberValidationListener() {
        return onPhoneNumberValidationListener;
    }

    public void setOnPhoneNumberValidationListener(OnPhoneNumberValidationListener onPhoneNumberValidationListener) {
        this.onPhoneNumberValidationListener = onPhoneNumberValidationListener;
    }

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

    public OnFirstNameValidationListener getOnFirstNameValidationListener() {
        return onFirstNameValidationListener;
    }

    public void setOnFirstNameValidationListener(OnFirstNameValidationListener onFirstNameValidationListener) {
        this.onFirstNameValidationListener = onFirstNameValidationListener;
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
        parent_view = LayoutInflater.from(context).inflate(R.layout.personal_info_row, this, true);
        TypedArray a = context.obtainStyledAttributes(attr, R.styleable.PersonalInfo, 0,0);
        LinearLayout mTextInputLayout = parent_view.findViewById(R.id.parent_personal);

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

        if( a.hasValue(R.styleable.PersonalInfo_birthDay) ) {
            isBirthDayIncluded = a.getBoolean(R.styleable.PersonalInfo_birthDay, false);
            number_of_views_included++;
        }
        makeViews(context, attr, mTextInputLayout, isPersianLastNameInCluded, isPersianFirstNameIncluded, isEnglishLastNameIncluded, isEnglishFirstNameIncluded,
                isPhoneNumberIncluded, isBirthDayIncluded, isNationalIDIncluded);

    }

    private void makeViews(Context context, AttributeSet attr, LinearLayout mLinearLayout, Boolean isPersianLastNameInCluded, Boolean isPersianFirstNameIncluded, Boolean isEnglishLastNameIncluded, Boolean isEnglishFirstNameIncluded, Boolean isPhoneNumberIncluded, Boolean isBirthDayIncluded, Boolean isNationalIDIncluded) {
        if( isPersianFirstNameIncluded ){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("نام");
            textInputLayout.addView(editText);
            TextView textView = new TextView(context);
            textView.setText("نام را به درستی وارد کنید!");
            textView.setTextColor(context.getResources().getColor(R.color.error_color));
            textView.setVisibility(View.GONE);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayout.addView(textView);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if( isPersianLastNameInCluded ){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("نام فامیلی");
            textInputLayout.addView(editText);
            TextView textView = new TextView(context);
            textView.setText("نام فامیلی را به درستی وارد کنید!");
            textView.setTextColor(context.getResources().getColor(R.color.error_color));
            textView.setVisibility(View.GONE);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if(isEnglishFirstNameIncluded ){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("English name");
            textInputLayout.addView(editText);
            TextView textView = new TextView(context);
            textView.setText("نام ا را به درستی وارد کنید!");
            textView.setTextColor(context.getResources().getColor(R.color.error_color));
            textView.setVisibility(View.GONE);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if(isEnglishLastNameIncluded){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("English last name");
            textInputLayout.addView(editText);
            TextView textView = new TextView(context);
            textView.setText("نام را به درستی وارد کنید!");
            textView.setTextColor(context.getResources().getColor(R.color.error_color));
            textView.setVisibility(View.GONE);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if(isNationalIDIncluded){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("کد ملی");
            TextView textView = new TextView(context);
            textView.setText("نام ا را به درستی وارد کنید!");
            textView.setTextColor(context.getResources().getColor(R.color.error_color));
            textView.setVisibility(View.GONE);
            textInputLayout.addView(editText);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if( isPhoneNumberIncluded ){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextInputLayout textInputLayout = new TextInputLayout(context);
            EditText editText = new EditText(context);
            editText.setHint("شماره تماس");
            TextView textView = new TextView(context);
            textView.setText("نام ا را به درستی وارد کنید!");
            textView.setTextColor(context.getResources().getColor(R.color.error_color));
            textView.setVisibility(View.GONE);
            textInputLayout.addView(editText);
            textInputLayout.setLayoutParams(layoutParams);
            textInputLayouts.add(textInputLayout);
            mLinearLayout.addView(textInputLayout);
        }
        if( isBirthDayIncluded ){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layoutInflater.inflate(R.layout.birth_day_layout, mLinearLayout);
        }

    }

    public interface OnPhoneNumberValidationListener {
        void onPhone(String phoneNumber);
    }
    public interface OnFirstNameValidationListener {
        void onFirstName(String firstName);
    }
    public interface OnLastNameValidationListener {
        void onLastName(String lastName);
    }
     public void phoneNumberValidate(){
        onPhoneNumberValidationListener.onPhone(textInputLayouts.get(5).getEditText().getText().toString());
     }

     public void firstNameValidator(){
         onFirstNameValidationListener.onFirstName(textInputLayouts.get(0).getEditText().getText().toString());
     }

}
