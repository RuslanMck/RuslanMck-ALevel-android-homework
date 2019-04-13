package ua.home_studying.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;

public class FontTextVIew extends AppCompatTextView {

    private static final String TAG = FontTextVIew.class.getSimpleName();

    public FontTextVIew(Context context) {
        super(context);
    }

    public FontTextVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public FontTextVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArrayWrapper.readTypedArray(context,attrs,R.styleable.FontTextView, this::readArray);
    }

    private void readArray(TypedArray array) {
        int fontType = array.getInt(R.styleable.FontTextView_ftv_font,0);
        setupTypeafeByEnum(fontType);
    }

     void setupTypeafeByEnum(int fontType) {
        Typeface typeface = readTypeFace(fontType);
        if (typeface == null) {
            Log.e(TAG, "ErrorTypeFace from res " + fontType);
            return;
        }
        setTypeface(typeface);
    }

    private Typeface readTypeFace(int fontType) {
        String fileName = "";
        switch (fontType) {
            case 1:
                fileName = "Gorgeous Grafix.ttf";
                break;
            case 2:
                fileName = "font/Redtowns.ttf";
                break;
        }
        if (TextUtils.isEmpty(fileName)) return null;
        return Typeface.createFromAsset(getContext().getAssets(), fileName);
    }
}
