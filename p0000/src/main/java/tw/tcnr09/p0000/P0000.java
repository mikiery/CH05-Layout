package tw.tcnr09.p0000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0000 extends AppCompatActivity {

          private Intent intent;

          private ListView lv001;
          private List<String> data;

          private String[] arr = {"大里", "烏日", "霧峰", "太平", "豐原", "神岡", "大肚"};


          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.p0000);
                    setViewComponent();
          }

          private void setViewComponent() {
                    data = Arrays.asList(arr);


                    lv001 = (ListView) findViewById(R.id.p0000_main_lv001);

                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    intent = new Intent();

                    p000Adapter adapter = new p000Adapter(data, inflater);

                    lv001.setAdapter(adapter);
                    lv001.setOnItemClickListener(lv001On);
          }

          private AdapterView.OnItemClickListener lv001On = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                              intent.setClass(P0000.this, P0002.class);
                              startActivity(intent);
                    }
          };
}