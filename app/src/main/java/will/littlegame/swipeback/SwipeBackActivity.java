package will.littlegame.swipeback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import will.littlegame.R;

/**
 * Created by Administrator on 2016/9/7 0007.
 */
public class SwipeBackActivity extends Activity {

    protected SwipeBackLayout layout;
    protected Boolean SwipeBackEnable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSwipeBackEnable()) {
            layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                    R.layout.base, null);
            layout.attachToActivity(this);
        }

    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        // if (getSwipeBackEnable()) {
        overridePendingTransition(R.anim.base_slide_right_in,
                R.anim.base_slide_remain);
        // }
    }

    // Press the back button in mobile phone
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // if (getSwipeBackEnable()) {
        // overridePendingTransition(0, R.anim.base_slide_right_out);
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
        // }
    }

    private Boolean getSwipeBackEnable() {
        return SwipeBackEnable;
    }

    protected Boolean setSwipeBackEnable(Boolean mBoolean) {
        SwipeBackEnable = mBoolean;
        return SwipeBackEnable;
    }

}
