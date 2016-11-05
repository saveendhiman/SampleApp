package com.sampleapp.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by saveen_dhiman on 05-November-16.
 * Custom editText to remove error on editText field when onTextChange is called
 */
public class RemoveErrorEditText extends EditText {
    public RemoveErrorEditText(Context context) {
        super(context);
        removeError();
    }

    public RemoveErrorEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        removeError();
    }

    public RemoveErrorEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        removeError();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RemoveErrorEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        removeError();
    }


    private void removeError() {

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setError(null);
            }
        });
    }
}
