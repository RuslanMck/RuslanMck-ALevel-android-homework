package ua.home_studying.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class TypedArrayWrapper {

    public static void readTypedArray(Context context,
                                      AttributeSet attrs,
                                      int[] styleRes,
                                      ReadTypedArray readTypedArrayCallback) {
        if (attrs == null) return;
        TypedArray array = context.obtainStyledAttributes(attrs,styleRes);
        try {
            readTypedArrayCallback.readArray(array);
        } finally {
            if (array != null)
                array.recycle();
        }
    }


    interface ReadTypedArray {
        void readArray(TypedArray array);
    }

}
