package blq.ssnb.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import blq.ssnb.madapter.MBaseAdapter;
import blq.ssnb.myapplication.controller.EntityMViewController;
import blq.ssnb.myapplication.controller.EntityMViewController2;
import blq.ssnb.myapplication.model.TestModel;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Button btn1;
    private Button btn2;
    private ListView listView;
    private EntityMViewController controller1;
    private EntityMViewController2 controller2;
    private List<TestModel> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.ls_type_1);
        btn2 = (Button) findViewById(R.id.ls_type_2);
        listView = (ListView) findViewById(R.id.main_lv);
        controller1 = new EntityMViewController();
        controller2 = new EntityMViewController2();
        models = getModels();
        bindEvent();
        listView.setAdapter(new MBaseAdapter<>(context,models,controller1));
    }

    private List<TestModel> getModels() {
        List<TestModel> models = new ArrayList<>();
        for (int i = 0 ; i < 50 ; i ++){
            TestModel model = new TestModel();
            model.setType(i%3);
            model.setTitle("title:"+i);
            model.setMessage("我是title"+i+"的message");
            models.add(model);
        }
        return models;
    }

    private void bindEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listView.setAdapter(new MBaseAdapter<>(context,models,controller1));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(new MBaseAdapter<>(context,models,controller2));
            }
        });
    }
}
