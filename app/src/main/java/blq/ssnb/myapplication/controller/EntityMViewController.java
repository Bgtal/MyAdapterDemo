package blq.ssnb.myapplication.controller;


import blq.ssnb.madapter.AbsMViewController;
import blq.ssnb.madapter.MViewItem;
import blq.ssnb.myapplication.itemview.EntityMView1;
import blq.ssnb.myapplication.model.TestModel;

/**
 * Created by SSNB on 2016/7/22.
 */
public class EntityMViewController extends AbsMViewController<TestModel> {


    @Override
    public MViewItem<TestModel> newViewItem(int type) {
        return new EntityMView1();
    }
}
