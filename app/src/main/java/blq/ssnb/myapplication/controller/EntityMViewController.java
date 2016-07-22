package blq.ssnb.myapplication.controller;


import blq.ssnb.madapter.AbsMViewController;
import blq.ssnb.madapter.MViewItem;
import blq.ssnb.myapplication.itemview.EntityMView1;
import blq.ssnb.myapplication.model.TestModel;

/**
 * Created by SSNB on 2016/7/22.
 * 当子view只有一种类的时候直接继承AbsMViewController返回一个MViewItem就可以了
 * 当然可以直接继承{@link blq.ssnb.madapter.MBaseAdapter}重写adapter
 */
public class EntityMViewController extends AbsMViewController<TestModel> {


    @Override
    public MViewItem<TestModel> newViewItem(int type) {
        return new EntityMView1();
    }
}
