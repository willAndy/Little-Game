package will.littlegame;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import util.OpenIntent;
import util.VersionUtils;
import will.littlegame.base.ActivityUtil;
import will.littlegame.base.GrowcnBaseActivity;

public class SettingActivity extends GrowcnBaseActivity {

    private Context mContext;
    //进度条
    public ProgressDialog dialog=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setSwipeBackEnable(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mContext=this;
        mActivityUtil=new ActivityUtil(this);
        mActivityUtil.setBrowserSetting();
        mActivityUtil.setTitle("设置");
    }

    public void onResume(){
        super.onResume();
        initView();
    }

    public void initView(){
        TextView mVers=(TextView) findViewById(R.id.version_value);
        TextView mCacheSize=(TextView) findViewById(R.id.clear_cache_value);
        LinearLayout ToAbout=(LinearLayout) findViewById(R.id.setting_about);
        LinearLayout ToFeedback=(LinearLayout) findViewById(R.id.setting_feedback);
        LinearLayout Upgrape=(LinearLayout) findViewById(R.id.setting_feedback);
        LinearLayout mClearCache=(LinearLayout) findViewById(R.id.setting_clear_cache);

        mVers.setText(new VersionUtils(mContext).getName());

        mClearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowProgressBarDialog();
                CloseProgressBarDialog();
                onResume();
            }
        });

        ToFeedback.setOnClickListener(MyOnClickListener);
        ToAbout.setOnClickListener(MyOnClickListener);
        Upgrape.setOnClickListener(MyOnClickListener);


    }

    View.OnClickListener MyOnClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.setting_about:
                    OpenIntent.about(mContext);
                    break;
                case R.id.setting_upgrade:
                    upgrade_app(true);
                    break;
                default:
                    break;
            }
        }
    };

    public void ShowProgressBarDialog(){
        dialog=new ProgressDialog(this);
        dialog.setMessage("正在清空........");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void CloseProgressBarDialog(){dialog.dismiss();}
}
