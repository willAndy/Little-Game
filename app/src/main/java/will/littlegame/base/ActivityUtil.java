package will.littlegame.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import util.OpenIntent;
import will.littlegame.R;

/**
 * Created by Administrator on 2016/9/7 0007.
 */
public class ActivityUtil {

    private Context mContext;
    private Activity mActivity;
    public static Boolean isExit = false;
    // 返回键
    private ImageView mBarBack;
    // 标题
    private TextView mBarTitile;
    // 设置
    private ImageView mBarSetting;

    public ActivityUtil(Activity mActivity) {
        this.mContext = mActivity;
        this.mActivity = mActivity;
        initView();
    }

    private void initView() {
        mBarBack = (ImageView) mActivity.findViewById(R.id.bar_back);
        mBarTitile = (TextView) mActivity.findViewById(R.id.bar_titile);
        mBarSetting = (ImageView) mActivity.findViewById(R.id.bar_setting);

        mBarBack.setVisibility(View.GONE);
        mBarSetting.setVisibility(View.GONE);
    }

    public Context getmContext() {
        return this.mContext;
    }

    public void setBrowserSetting() {
        mBarSetting.setVisibility(View.VISIBLE);
        mBarSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenIntent.setting(mContext);
            }
        });
    }

    // 标题
    public void setTitle(String title) {
        mBarTitile.setText(title);
    }

    // 返回键
    public void setBrowserBackButton() {
        mBarBack.setVisibility(View.VISIBLE);
        mBarBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mActivity.onBackPressed();
                mActivity.finish();
            }
        });
    }

    public void showExitDialog() {
        Dialog dialog = new AlertDialog.Builder(mContext).setTitle("提示退出")
                .setMessage("确认要退出吗？")
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        CloseApp();
                    }
                }).setNegativeButton("取消", null).create();
        dialog.show();
    }

    //

    // 退出整个应用
    public void CloseApp() {
        // MyApp.getInstance().exit();
        // android.os.Process.killProcess(android.os.Process.myPid());
        // System.exit(0);
    }

}
