package tw.tcnr09.m0503;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class M0503 extends AppCompatActivity {

      private CheckBox chb01, chb02, chb03, chb04;
      private Button b001;
      private TextView t001;
      private CheckBox[] checks;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0503);
            setViewComponent();
      }

      private void setViewComponent() {
            chb01 = (CheckBox) findViewById(R.id.m0503_chb01);
            chb02 = (CheckBox) findViewById(R.id.m0503_chb02);
            chb03 = (CheckBox) findViewById(R.id.m0503_chb03);
            chb04 = (CheckBox) findViewById(R.id.m0503_chb04);

            checks = new CheckBox[]{chb01, chb02, chb03, chb04};

            b001 = (Button) findViewById(R.id.m0503_b001);

            t001 = (TextView) findViewById(R.id.m0503_t001);

            b001.setOnClickListener(b001On);
      }

      private View.OnClickListener b001On = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  String ans = getString(R.string.m0503_t001)+"\n";

                  for (int i = 0; i < checks.length; i++) {
                        if (checks[i].isChecked()) {
                              ans += checks[i].getText()+" \n";
                        }
                  }

                  t001.setText(ans);
            }
      };
}