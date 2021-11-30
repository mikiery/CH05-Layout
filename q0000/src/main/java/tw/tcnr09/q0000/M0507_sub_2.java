package tw.tcnr09.q0000;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0507_sub_2 extends AppCompatActivity {

          private LayoutInflater inflater;
          private GridView sub_2_gv001;
          private TextView sub_2_t001;
          private Button sub_2_b001, sub_2_b002;
          private Intent intent;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0507_sub_2);
                    setViewComponent();
          }

          private void setViewComponent() {
                    //不懂，但我的理解：Layout生成器，宣告
                    inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    //設定Adapter

                    intent = new Intent();

                    sub_2_gv001 = (GridView) findViewById(R.id.m0507_sub_2_gv001);
                    sub_2_t001 = (TextView) findViewById(R.id.m0507_sub_2_t001);
                    sub_2_b001 = (Button) findViewById(R.id.m0507_sub_2_b001);
                    sub_2_b002 = (Button) findViewById(R.id.m0507_sub_2_b002);

                    sub_2_b001.setOnClickListener(b001On);
                    sub_2_b002.setOnClickListener(b002On);

//                    sub_gv001.setAdapter(adapter);
          }

          private View.OnClickListener b001On = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                              intent.setClass(M0507_sub_2.this, M0507.class);
                              startActivity(intent);
                    }
          };

          private View.OnClickListener b002On = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                              intent.setClass(M0507_sub_2.this, M0507_sub_2_performance.class);
                              startActivity(intent);
                    }
          };
}