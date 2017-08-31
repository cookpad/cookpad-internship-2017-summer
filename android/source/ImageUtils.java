package com.
.android.cookpatodon;

import android.content.Context;
import android.text.TextUtils;

public class ImageUtils {

    public static String[] imageList = {
            "arupaka",
            "buta",
            "hamster",
            "hiyoko",
            "inu",
            "kuma",
            "mitsubachi",
            "neko",
            "panda",
            "penguin",
            "usagi",
            "zou",
            "kani",
            "neko2",
    };


    public static int getDrawableResource(Context context, String resourceName) {
        if (TextUtils.isEmpty(resourceName)) {
            return R.drawable.unknown;
        }
        int resourceId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        if (resourceId == 0) {
            return R.drawable.unknown;
        }
        return resourceId;
    }
}
