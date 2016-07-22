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
    private final static int ITEM_TYPE_1=0;
    private final static int ITEM_TYPE_2=1;
    private final static int ITEM_TYPE_3=2;
    private final static int ITEM_TYPE_4=3;
    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(TestModel data, int position) {
        int type ;
        switch (data.getType()){
            case 0:
                type = ITEM_TYPE_1 ;
                break;
            case 1:
                type = ITEM_TYPE_2 ;
                break;
            case 2:
                type = ITEM_TYPE_3;
                break;
            default:
                type=ITEM_TYPE_4;
        }
        return type;
    }

    @Override
    public MViewItem<TestModel> newViewItem(int type) {
        MViewItem<TestModel> item ;
        switch (type){
            case ITEM_TYPE_1:
                item = new EntityMView1();
                break;
            case ITEM_TYPE_2:
                item = new EntityMView2();
                break;
            case ITEM_TYPE_3:
                item = new EntityMView3();
                break;
            default:
                item = new EntityMView1();
        }
        return item;
    }
}
