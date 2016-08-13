package blq.ssnb.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import blq.ssnb.madapter.adapter.MAdapter;
import blq.ssnb.madapter.adapter.MBaseAdapter;
import blq.ssnb.myapplication.controller.MethodFourMViewController;
import blq.ssnb.myapplication.controller.MethodThreeMViewController;
import blq.ssnb.myapplication.controller.MethodTwoMViewController;
import blq.ssnb.myapplication.model.BaseModel;
import blq.ssnb.myapplication.model.TypeOneModel;
import blq.ssnb.myapplication.model.TypeThreeModel;
import blq.ssnb.myapplication.model.TypeTwoModel;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ListView listView;
    private LinearLayout headLinearLayout;
    private TextView userMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        headLinearLayout = (LinearLayout) findViewById(R.id.head_hsv_ll);
        userMsg = (TextView) findViewById(R.id.ll_tv_method_msg);
        listView = (ListView) findViewById(R.id.main_lv);
        addUserMethod();
        userMethodOne();
    }

    private void addUserMethod() {
        String[] button = new String[]{"使用一","使用二","使用三","使用四"};

        for (int index = button.length-1 ;index>=0 ;index-- ){
            Button btn = new Button(context);
            btn.setText(button[index]);
            final int finalIndex = index;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(finalIndex){
                        case 0:
                            userMethodOne();
                            break;
                        case 1:
                            userMethodTwo();
                            break;
                        case 2:
                            userMethodThree();
                            break;
                        case 3:
                            userMethodFour();
                            break;
                    }
                }
            });
            headLinearLayout.addView(btn,0);
        }
    }
    private MAdapter fourAdapter;
    private void userMethodFour() {
        if (fourAdapter == null){
            fourAdapter = new MAdapter<>(context,getModels(),new MethodFourMViewController());
        }
        userMsg.setText(getString(R.string.user_method_4_introduce));
        listView.setAdapter(fourAdapter);
    }

    private MAdapter threeAdapter;
    private void userMethodThree() {
        if(threeAdapter == null){
            List<TypeTwoModel> listData = new ArrayList<>();
            for (int i = 0 ;i<30;i++){
                TypeTwoModel model = new TypeTwoModel();
                model.setMessage("我是第"+i+"行的数据");
                listData.add(model);
            }
            threeAdapter = new MAdapter<>(context,listData,new MethodThreeMViewController());
        }
        userMsg.setText(R.string.user_method_3_introduce);
        listView.setAdapter(threeAdapter);
    }

    private MAdapter twoAdapter;
    private void userMethodTwo() {
        if(twoAdapter==null){ List<TypeOneModel> listData = new ArrayList<>();
            for(int i = 0 ; i < 30 ; i ++){
                TypeOneModel model = new TypeOneModel();
                model.setTitle("我是第"+i+"行");
                model.setMessage("我是第"+i+"行的描述信息");
                listData.add(model);
            }
            twoAdapter = new MAdapter<>(context,listData, new MethodTwoMViewController());
        }
        userMsg.setText(R.string.user_method_2_introduce);
        listView.setAdapter(twoAdapter);

    }

    private MBaseAdapter oneAdapter;
    private void userMethodOne() {

        if(oneAdapter == null){
            List<TypeOneModel> listData = new ArrayList<>();
            for(int i = 0 ; i < 30 ; i ++){
                TypeOneModel model = new TypeOneModel();
                model.setTitle("我是第"+i+"行");
                model.setMessage("我是第"+i+"行的描述信息");
                listData.add(model);
            }
            oneAdapter = new MBaseAdapter<TypeOneModel>(context,listData) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView ;
                    if(convertView==null){
                        textView = new TextView(context);
                    }else{
                        textView = (TextView) convertView;
                    }
                    TypeOneModel model = getItem(position);
                    textView.setText(String.format("title:%s\nmessage:%s", model.getTitle(), model.getMessage()));
                    return textView;
                }
            };
        }
        userMsg.setText(R.string.user_method_1_introduce);
        listView.setAdapter(oneAdapter);
    }

    private List<BaseModel> getModels() {
        List<BaseModel> models = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int index = i%3 ;
            BaseModel mModel=null;
            switch (index){
                case 0:
                {
                    TypeOneModel model = new TypeOneModel();
                    model.setTitle("我是第" + i + "行");
                    model.setMessage("我的类型是:" + model.getType());
                    mModel = model;
                }
                break;
                case 1:
                {
                    TypeTwoModel model = new TypeTwoModel();
                    model.setMessage("我是第"+i+"行"+",类型是："+model.getType());
                    mModel = model;
                }
                break;
                case 2:
                {
                    TypeThreeModel model = new TypeThreeModel();
                    model.setTitle("我是第"+i+"行");
                    model.setSubTitle("我的类型是："+model.getType());
                    model.setRandom("我就是个随机数："+Math.random()*1000);
                    mModel =model;
                }
                break;
            }
            if (mModel==null){
                continue;
            }
            models.add(mModel);
        }
        return models;
    }
}