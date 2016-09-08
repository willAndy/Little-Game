package util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import will.littlegame.AboutActivity;
import will.littlegame.SettingActivity;

/**
 * Created by Administrator on 2016/9/7 0007.
 */
public class OpenIntent {


    public static void about(Context mContext) {
        Intent intent = new Intent(mContext, AboutActivity.class);
        mContext.startActivity(intent);
    }

    public static void setting(Context mContext) {
        Intent intent = new Intent(mContext, SettingActivity.class);
        mContext.startActivity(intent);
    }






}
