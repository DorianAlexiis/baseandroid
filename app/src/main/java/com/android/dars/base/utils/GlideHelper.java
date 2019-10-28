package com.android.dars.base.utils;


import androidx.annotation.DrawableRes;

import com.android.dars.base.R;

import java.util.Random;

public class GlideHelper {

    public static @DrawableRes int getRandomCircularColor(){
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0:
                return R.drawable.circle_blue;
            case 1:
                return R.drawable.circle_green;
            case 2:
                return R.drawable.circle_pink;
            default:
                return R.drawable.circle_gray;
        }
    }
}
