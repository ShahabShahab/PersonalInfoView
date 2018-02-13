package com.faranegar.personalinformationlayout;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by faranegar on 2/13/18...
 */

public class Personal_Info_Row {

    private TextInputLayout textInputLayout;
    private EditText editText;
    private TextView errorView;

    public Personal_Info_Row(Context context, String hint, String error_text) {
        textInputLayout = new TextInputLayout(context);
//        textInputLayout.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/font_bold.ttf"));
        textInputLayout.setHint(hint);
        textInputLayout.setGravity(Gravity.RIGHT);
        editText = new EditText(context);
        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        editText.setMaxLines(1);
        editText.setSingleLine(true);
        editText.setGravity(Gravity.RIGHT);
        errorView = new TextView(context);
        errorView.setText(error_text);
        errorView.setFocusableInTouchMode(true);
        errorView.setFocusable(true);
//        this.errorView.setVisibility(View.GONE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textInputLayout.setLayoutParams(layoutParams);
        textInputLayout.addView(editText);
        textInputLayout.addView(errorView);
    }

    public TextInputLayout getTextInputLayout() {
        return textInputLayout;
    }

    public EditText getEditText() {
        return editText;
    }

    public TextView getErrorView() {
        return errorView;
    }

}
