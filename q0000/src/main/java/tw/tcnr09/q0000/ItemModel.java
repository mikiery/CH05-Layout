package tw.tcnr09.q0000;

//"基礎的道具"模型(model)之類別(class)
public class ItemModel {
          public Integer itemID;//道具Id
          protected String _name, _description, _detail;
          //String _iconName;
          // Integer _rare;

          //回傳名稱或ID
          public String getName() {
                    return _name;
          }

          public String getDescription() {
                    return _description;
          }

          public String getDetail() {
                    return _detail;
          }

          //指定道具Id後生成道具
          public void LoadItemById(ItemData data, Integer itemId) {

                  //未實作
//                    this._name = strset.get(0);
//                    //_iconName;
//                    //_rare;
//                    this._description = strset.get(1);
//                    this._detail = strset.get(2);
          }

          //持有就有效果
          public void OnHold(){}

          //以下不在此做
          //道具地圖選單使用效果
          public void OnMenuUse() {
          }

          //道具戰鬥中使用效果
          public void OnBattleUse() {
          }

          //道具裝備效果
          public void OnEquip() {
          }

          //道具消失或損毀
          public void OnDestroy() {
          }

          private void set_itemType(int itemType_Code) {
                    switch (itemType_Code) {
                              case 0:
                                        //0為垃圾，專門拿來販賣換錢
                                        break;
                              case 1:
                                        //1為重要道具，無法販賣
                                        break;
                              case 2:
                                        //2為可使用
                                        break;
                              case 3:
                                        //3為重要的可使用道具
                                        break;
                              case 4:
                                        //4為裝備
                                        break;
                              case 5:
                                        //5為重要的裝備，無法販賣
                                        break;
                              case 7:
                                        //7為有使用效果的重要裝備
                                        break;
                              default:
                                        break;
                    }
          }
}