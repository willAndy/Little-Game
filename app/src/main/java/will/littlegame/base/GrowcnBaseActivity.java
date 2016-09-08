package will.littlegame.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;

import util.OpenIntent;
import will.littlegame.R;
import will.littlegame.swipeback.SwipeBackActivity;

/**
 * Created by Administrator on 2016/9/7 0007.
 */
public class GrowcnBaseActivity extends SwipeBackActivity {

    protected ActivityUtil mActivityUtil;
    protected AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this); // 统计时长
    }

    // @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (mActivityUtil != null) {
            ActivityUtil w = mActivityUtil;
            w = null;
            mActivityUtil = null;
        }

        if (adView != null) {
            AdView w = adView;
            w.removeAllViews();
            w.destroy();
            w = null;
            adView = null;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionItemSeleted(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                OpenIntent.setting(this);
                break;
            case R.id.action_about:
                OpenIntent.about(this);
                break;
            case R.id.action_upgrade:
                upgrade_app(true);
                break;
        }
        return true;
    }

    protected void upgrade_app(Boolean mBoolean){

    }

    protected void ToastShow(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();}

}
