package net.ganjoor.utils;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

import net.ganjoor.MyApplication;


public class AppUtils {
    public static final String BASE_URL = "http://localhost:7080/";
    public static final String TOKEN = "TOKEN";

    /**
     * Converting dp to pixel
     */
    public static int dpToPx(int dp, Resources r) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static int getRandomMaterialColor(String typeColor) {
        Resources r = MyApplication.getAppContext().getResources();
        String packageName = MyApplication.getAppContext().getPackageName();
        int returnColor = Color.GRAY;
        int arrayId = r.getIdentifier("mdcolor_" + typeColor, "array", packageName);

        if (arrayId != 0) {
            TypedArray colors = r.obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }
}
