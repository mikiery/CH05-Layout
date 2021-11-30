package tw.tcnr09.q0000;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class CustomAdapter extends BaseAdapter {

          //宣告資料來源
          //這個資料來源是HashMap不適合用在這裡，將資料簡化後用List取代
          private HashMap<Integer, HashMap<String, String>> data;

          private LayoutInflater inflater;//Layout讀取器，用來讀取版型xml檔


          //建構子，設定初始值
          public CustomAdapter(HashMap<Integer, HashMap<String, String>> data, LayoutInflater inflater) {
                    this.data = data;
                    this.inflater = inflater;
          }

          ////配合BaseAdapter用的，避免重複生成View物件造成資源浪費，不打會重複getView方法
          //以下宣告版型所用到且會依資料變更的物件
          class ViewHolder {
                    LinearLayout ll;
                    ImageView icon;
                    TextView name, description, detail, count;
          }

          //以下皆為繼承BaseAdapter來的。必須實作的部分
          @Override
          public int getCount() {
                    return data.size();
          }

          @Override
          public HashMap<String, String> getItem(int position) {
                    return data.get(position);
          }

          @Override
          public long getItemId(int position) {
                    return position;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {//convertView指的是
                    ViewHolder holder;
                    if (convertView == null) {
                              //if判斷開始
                              //配合BaseAdapter用的，避免重複生成View物件造成資源浪費
                              holder = new ViewHolder();
                              //抓取物件、設定物件
                              convertView = inflater.inflate(R.layout.p0000_itme_test, null);//讀取版型

                              holder.name = (TextView) convertView.findViewById(R.id.label_item_name);
                              holder.icon = (ImageView) convertView.findViewById(R.id.label_item_icon);
                              holder.description = (TextView) convertView.findViewById(R.id.label_item_description);
                              holder.detail = (TextView) convertView.findViewById(R.id.label_item_detail);
                              holder.count = (TextView) convertView.findViewById(R.id.label_item_count);

                              holder.ll = (LinearLayout) convertView.findViewById(R.id.label_item_llayout);

                              convertView.setTag(holder);
                              //if判斷結束
                    } else {
                              holder = (ViewHolder) convertView.getTag();
                    }

//                  由於data裡key值只有1~3，position初始值為0會當機，必須要修改data來源
//                  為了方便解決這個問題，在道具清單增加一個"0"key和相對應的"dummy"value來解決
//                    int i =++position;
//                    HashMap<String, String> valueInMap = data.get(i);


//                    name.setText(valueInMap.get("name"));
//                    description.setText(valueInMap.get("description"));
//                    detail.setText(valueInMap.get("detail"));

                    holder.name.setText(data.get(position).get("name"));
                    holder.description.setText(data.get(position).get("description"));
                    holder.detail.setText(data.get(position).get("detail"));
                    holder.count.setText(0 + "");


                    return convertView;
          }
}