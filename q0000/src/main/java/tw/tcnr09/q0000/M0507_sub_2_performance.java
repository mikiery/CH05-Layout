package tw.tcnr09.q0000;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0507_sub_2_performance extends AppCompatActivity {

          private TextView t001;
          private LinearLayout llayout;
          private Intent intent;


          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0507_sub_2_performance);

                    setViewComponet();


          }

          private void setViewComponet() {
                    intent = new Intent();
                    llayout = (LinearLayout)findViewById(R.id.m0507_sub_2_performance_ll001);
                    t001=(TextView)findViewById(R.id.m0507_sub_2_performance_t001);

                    t001.setText("這是煩躁的轉蛋演出\n請自行想像");
                    llayout.setOnClickListener(onTouch);
          }

          private View.OnClickListener onTouch =new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              t001.setText("演出完成\n準備移至結果畫面");
                              intent.setClass(M0507_sub_2_performance.this, M0507_sub_2.class);
                              startActivity(intent);
                    }
          };
}