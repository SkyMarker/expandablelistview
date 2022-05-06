package com.example.expandablelistview;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ExpandableListView explv_city;
    String[] provinces = {"山东省","江苏省","浙江省","福建省","山西省","辽宁省","黑龙江省"};
    String[][] cities = {{"济南市", "青岛市", "临沂市", "济宁市", "菏泽市", "烟台市", "淄博市", "滨州市", "德州市", "东营市", "聊城市", "日照市", "泰安市", "潍坊市", "威海市", "枣庄市"},
            {"常州市", "淮安市", "连云港市", "南京市", "南通市", "宿迁市", "苏州市", "泰州市", "无锡市", "徐州市", "盐城市", "扬州市", "镇江市"},
            {"杭州市", "湖州市", "嘉兴市", "金华市", "丽水市", "宁波市", "衢州市", "绍兴市", "台州市", "温州市", "舟山市"},
            {"福州市", "龙岩市", "南平市", "宁德市", "莆田市", "泉州市", "三明市", "厦门市", "漳州市"},
            {"长治市", "大同市", "晋城市", "晋中市", "临汾市", "吕梁市", "朔州市", "太原市", "忻州市", "阳泉市", "运城市"},
            {"鞍山市", "本溪市", "朝阳市", "大连市", "丹东市", "阜新市", "抚顺市", "葫芦岛市", "锦州市", "辽阳市", "盘锦市", "沈阳市", "铁岭市", "营口市"},
            {"大庆市", "哈尔滨市", "鹤岗市", "黑河市", "鸡西市", "佳木斯市", "牡丹江市", "齐齐哈尔市", "七台河市", "双鸭山市", "绥化市", "伊春市"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView();
    }
    private void intView() {
        explv_city = (ExpandableListView) findViewById(R.id.explv_city);
        ExpandableListViewAdapter expada = new ExpandableListViewAdapter(this,provinces,cities);
        explv_city.setAdapter(expada);
        explv_city.expandGroup(0);
        explv_city.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You have clicked:"+provinces[i], Toast.LENGTH_SHORT).show();
                return false;
            }});
        explv_city.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this, "You have clicked:"+cities[i][i1], Toast.LENGTH_SHORT).show();
                return false;
            }});
        explv_city.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
                public void onGroupCollapse(int i) {
                Toast.makeText(MainActivity.this, "You have folded:"+provinces[i], Toast.LENGTH_SHORT).show();
            }});
        explv_city.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
                public void onGroupExpand(int i) {
                Toast.makeText(MainActivity.this, "You have expanded:"+provinces[i], Toast.LENGTH_SHORT).show();
            }});
    }
}