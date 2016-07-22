package blq.ssnb.myapplication.controller;


import blq.ssnb.madapter.AbsMViewController;
import blq.ssnb.madapter.MViewItem;
import blq.ssnb.myapplication.itemview.EntityMView1;
import blq.ssnb.myapplication.itemview.EntityMView2;
import blq.ssnb.myapplication.itemview.EntityMView3;
import blq.ssnb.myapplication.model.TestModel;

/**
 * Created by SSNB on 2016/7/22.
 *
 */
public class EntityMViewController2 extends AbsMViewController<TestModel> {

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(TestModel data, int position) {
        return data.getType();
    }

    @Override
    public MViewItem<TestModel> newViewItem(int type) {
        MViewItem<TestModel> item ;
        switch (type){
            case 0:
                item = new EntityMView1();
                break;
            case 1:
                item = new EntityMView2();
                break;
            case 2:
                item = new EntityMView3();
                break;
            default:
                item = new EntityMView1();
        }
        return item;
    }
}
