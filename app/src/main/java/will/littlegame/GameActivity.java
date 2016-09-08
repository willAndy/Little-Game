package will.littlegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import will.littlegame.base.GrowcnBaseActivity;

public class GameActivity extends GrowcnBaseActivity implements View.OnClickListener{

    ImageView barSetting;
    Button b_plus,b_minus,b_check;
    TextView tv_number,tv_title;
    int current_number,number_to_guess,tries;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tries=0;
        r=new Random();
        number_to_guess=r.nextInt(51);

        b_plus=(Button) this.findViewById(R.id.b_plus);
        b_minus=(Button) this.findViewById(R.id.b_minus);
        b_check=(Button) this.findViewById(R.id.b_check);
        tv_number=(TextView) this.findViewById(R.id.tv_number);
        tv_title=(TextView) this.findViewById(R.id.tv_title);

        current_number=0;
        tv_number.setText(""+current_number);

        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_number==number_to_guess){
                    tv_title.setText("Congratulation!"+tries+"tries");
                    b_check.setEnabled(false);
                    b_minus.setEnabled(false);
                    b_plus.setEnabled(false);
                }else if(current_number>number_to_guess){
                    tv_title.setText("Down!");
                    tries++;
                }else if(current_number<number_to_guess){
                    tv_title.setText("Up!");
                    tries++;
                }
            }
        });

        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_number<50){
                    current_number++;
                }
                tv_number.setText(""+current_number);
            }
        });

        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_number>0){
                    current_number--;
                }
                tv_number.setText(""+current_number);
            }
        });

        barSetting = (ImageView) this.findViewById(R.id.bar_setting);
        barSetting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(this,SettingActivity.class));

    }
}
