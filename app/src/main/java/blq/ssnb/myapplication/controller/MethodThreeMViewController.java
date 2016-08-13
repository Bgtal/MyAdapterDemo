package blq.ssnb.myapplication.controller;

import blq.ssnb.madapter.adapter.MBaseAdapter;
import blq.ssnb.madapter.controller.AbsMViewController;
import blq.ssnb.madapter.item.MViewItem;
import blq.ssnb.myapplication.itemview.TypeTwoMView;
import blq.ssnb.myapplication.model.TypeTwoModel;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/8/13
 * 描述:当子view只有一种类的时候直接继承AbsMViewController返回一个MViewItem就可以了
 * 当然可以直接继承{@link MBaseAdapter}重写adapter
 * ================================================
 */
public class MethodThreeMViewController extends AbsMViewController<TypeTwoModel> {
    @Override
    public MViewItem<TypeTwoModel> newViewItem(int type) {
        return new TypeTwoMView();
    }
}
