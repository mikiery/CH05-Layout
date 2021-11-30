package tw.tcnr09.q0000;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class LoadJSONtoData extends AppCompatActivity {
          public ItemData data;
          private String[] arr = {"name", "description", "detail"};

          public void Load() {
                    data = new ItemData();
                    try {
                              JSONObject jsonObject = new JSONObject(JsonDataFromAsset());
                              JSONArray jsonArray = jsonObject.getJSONArray("item_list");
                              for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject itemData = jsonArray.getJSONObject(i);
                                        Integer key = Integer.parseInt(itemData.getString("ID"));
                                        List<String> map = new ArrayList<String>();

                                        //未實作
                              }
                    } catch (JSONException e) {
                              e.printStackTrace();
                    }
          }

          private String JsonDataFromAsset() {
                    String json = null;
                    try {
                              InputStream inputStream = getAssets().open("jsontest.json");
                              int fileSize = inputStream.available();
                              byte[] bufferData = new byte[fileSize];
                              inputStream.read(bufferData);
                              inputStream.close();
                              json = new String(bufferData, "UTF-8");
                    } catch (IOException e) {
                              e.printStackTrace();
                              return null;
                    }
                    return json;
          }
}