package tw.tcnr09.q0000;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0507_sub extends AppCompatActivity {


          private LayoutInflater inflater;
          private ListView sub_lv001;
          private TextView sub_t001;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0507_sub);

                    setViewComponent();
          }

          private void setViewComponent() {
                    //不懂，但我的理解：Layout生成器，宣告
                    inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    //設定Adapter
                    CustomAdapter adapter = new CustomAdapter(M0507.data, inflater);

                    sub_lv001=(ListView)findViewById(R.id.m0507_sub_lv001);
                    sub_t001=(TextView)findViewById(R.id.m0507_sub_t001);

                    sub_lv001.setAdapter(adapter);

          }
}