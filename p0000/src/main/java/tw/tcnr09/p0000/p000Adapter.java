package tw.tcnr09.p0000;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class p000Adapter extends BaseAdapter {

          LayoutInflater inflater;
          List<String> data;

          public p000Adapter(List<String> data, LayoutInflater inflater) {
                    this.inflater = inflater;
                    this.data = data;
          }

          class ViewHolder {
                    ImageView image;
                    TextView name, rank, comment;
          }

          @Override
          public int getCount() {
                    return data.size();
          }

          @Override
          public Object getItem(int position) {
                    return data.get(position);
          }

          @Override
          public long getItemId(int position) {
                    return 0;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {
                    ViewHolder holder;
                    if (convertView == null) {
                              holder = new ViewHolder();
                              convertView = inflater.inflate(R.layout.p0000_simple_lsitem, null);
                              holder.name = (TextView) convertView.findViewById(R.id.p0000_t003);
                              holder.rank = (TextView) convertView.findViewById(R.id.p0000_t002);
                              holder.comment = (TextView) convertView.findViewById(R.id.p0000_t003);
                              convertView.setTag(holder);
                    } else {
                              holder = (ViewHolder) convertView.getTag();
                    }

                    holder.name.setText(data.get(position));

                    return convertView;
          }
}