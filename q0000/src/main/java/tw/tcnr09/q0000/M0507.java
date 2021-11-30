package tw.tcnr09.q0000;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;

public class M0507 extends AppCompatActivity {

          static HashMap<Integer, HashMap<String, String>> data;
          private int keyInMap;
          private HashMap<String, String> valueInMap;
          private TextView t001;
          private Button b001, b002;
          private Intent intent;
          private Bundle bundle;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.m0507);

                    setViewComponent();

//                    CustomAdapter adapter04 = new CustomAdapter(data, inflater);

//                    arr = getResources().getStringArray(R.array.test_item_list);//從res中抓取設定好的字串陣列方法
//                    ArrayAdapter adapter01 =
//                              new ArrayAdapter(this,//是誰要顯示，是這個this
//                                        R.layout.support_simple_spinner_dropdown_item,//設定的樣式，填入ResourseID
//                                        itemList);//資料來源、內容物，內容必須是Array[T]或是List<T>
//                    ArrayAdapter<ItemModel> adapter02 =
//                              new ArrayAdapter<>(this,
//                                        R.layout.p0000_itme_test,//樣式
//                                        R.id.TestText,
//                                        itemList);//內容物
//                    ItemAdapter adapter03 =
//                              new ItemAdapter(this,
//                                        itemList);
//
//
//                ArrayAdapter<CharSequence>
//                ArrayAdapter.createFromResource(this,從res抓資料(內容) ,從res抓樣式 )
//


          }


//          class ItemAdapter extends ArrayAdapter<ItemModel> {
//                    //Context c;
//
//                    public ItemAdapter(Context context, List<ItemModel> objects) {
//                              super(context, R.layout.p0000_itme_test,R.id.TestText, objects);
//                              //this.c =context;
//
//                    }
//          }

          //設定物件
          private void setViewComponent() {

                    //子頁面(下一頁)生成
                    intent = new Intent();

                    //帶到下一頁的參數，未做
                    bundle = new Bundle();

                    t001 = (TextView) findViewById(R.id.m0507_t001);
                    b001 = (Button) findViewById(R.id.m0507_b001);
                    b002 = (Button) findViewById(R.id.m0507_b002);

                    //讀取Xml內的資料，並儲存在data變數內
                    try {
                              getAssetsStream();
                    } catch (Exception e) {
                              t001.setText("報錯");
                              e.printStackTrace();
                    }

                    b001.setOnClickListener(b001On);
                    b002.setOnClickListener(b002On);
          }

          private View.OnClickListener b001On = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              t001.setText("已按下b001");
                              //移動到子頁面(下一頁)，道具欄
                              intent.setClass(M0507.this, M0507_sub.class);
                              startActivity(intent);
                    }
          };

          private View.OnClickListener b002On = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                              t001.setText("已按下b002");
                              //移動到子頁面(下一頁)，十連抽
                              intent.setClass(M0507.this, M0507_sub_2_performance.class);
                              startActivity(intent);
                    }
          };

          //讀取Xml的方法，須能拋出例外
          void getAssetsStream() throws Exception {

                    data = new HashMap<>();
                    keyInMap = 0;
                    valueInMap = new HashMap<>();//因為是紀錄位址不是紀錄值，一定要new一個，不然會被當作同一個物件


//                    InputStream inputStream = getAssets().open("xmltest.xml");//指定路徑得到資料來源
//                    XmlPullParser xmlPullParser = Xml.newPullParser();//宣告Xml的Pull
//                    xmlPullParser.setInput(inputStream, "UTF-8");//設定Pull的資料來源

                    XmlResourceParser xmlPullParser = getResources().getXml(R.xml.xmltest);//用XmlResourceParser作上面的三行的事

                    int event = xmlPullParser.getEventType();
                    while (event != XmlPullParser.END_DOCUMENT) {
                              switch (event) {
                                        case XmlPullParser.START_DOCUMENT:
                                                  //TODO
                                                  break;
                                        case XmlPullParser.START_TAG:
                                                  String str = xmlPullParser.getName();
                                                  switch (str) {
                                                            case "itemID":
                                                                      keyInMap = Integer.valueOf(xmlPullParser.getAttributeValue(0));
                                                                      break;
                                                            case "name":
                                                                      valueInMap.put("name", xmlPullParser.nextText());
                                                                      break;
                                                            case "description":
                                                                      valueInMap.put("description", xmlPullParser.nextText());
                                                                      break;
                                                            case "detail":
                                                                      valueInMap.put("detail", xmlPullParser.nextText());
                                                                      break;
                                                            default:
                                                                      break;
                                                  }
                                                  break;
                                        case XmlPullParser.END_TAG:
                                                  if ("itemID".equals(xmlPullParser.getName())) {
                                                            //將對應的<K,V>存進data內
                                                            data.put(keyInMap, valueInMap);
                                                            //因為是存位址不是存值，所以必須要new一個新的
                                                            valueInMap = new HashMap<>();
                                                  }
                                                  break;
                              }
                              //為了抓取下一筆資料，將event設定為下一筆資料的類型(以int形式)
                              event = xmlPullParser.next();
                    }

                    //實作方法
          }

}