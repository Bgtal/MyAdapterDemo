package blq.ssnb.myapplication.controller;


import android.widget.AbsListView;
import android.widget.ListAdapter;

import blq.ssnb.madapter.AbsMViewController;
import blq.ssnb.madapter.MViewItem;
import blq.ssnb.myapplication.itemview.EntityMView1;
import blq.ssnb.myapplication.itemview.EntityMView2;
import blq.ssnb.myapplication.itemview.EntityMView3;
import blq.ssnb.myapplication.model.TestModel;

/**
 * Created by SSNB on 2016/7/22.
 * 当item的类型有多种的时候需要重写{@link #getViewTypeCount()}
 * 和{@link #getItemViewType(TestModel, int)}
 */
public class EntityMViewController2 extends AbsMViewController<TestModel> {
    /**
     * 需要注意到是TYPE类型是从0开始依次增加的
     * 原因是Android源码中
     *     public void setViewTypeCount(int viewTypeCount) {
     *     if (viewTypeCount < 1) {
     *     throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
     *     }
     *     //noinspection unchecked
     *     ArrayList<View>[] scrapViews = new ArrayList[viewTypeCount];
     *     for (int i = 0; i < viewTypeCount; i++) {
     *     scrapViews[i] = new ArrayList<View>();
     *     }
     *     mViewTypeCount = viewTypeCount;
     *     mCurrentScrap = scrapViews[0];
     *     mScrapViews = scrapViews;
     *     }
     * 源码位置
     *  {@link android.widget.ListView#setAdapter(ListAdapter)}中的
     *  mRecycler.setViewTypeCount(mAdapter.getViewTypeCount());
     *  mRecycler为 {@link AbsListView}中的内部类RecycleBin
     *  mRecycler.setViewTypeCount的实现就是上面代码他创建了大小为viewTypeCount的ArrayList
     *  而取ItemViewType的时候
     *
     *   View getScrapView(int position) {
     *      final int whichScrap = mAdapter.getItemViewType(position);
     *      if (whichScrap < 0) {
     *          return null;
     *      }
     *      if (mViewTypeCount == 1) {
     *          return retrieveFromScrap(mCurrentScrap, position);
     *      } else if (whichScrap < mScrapViews.length) {
     *          return retrieveFromScrap(mScrapViews[whichScrap], position);
     *      }
     *      return null;
     *   }
     *  直接用mScrapViews[whichScrap]下标来取所以type类型不能超过{@link #getViewTypeCount()}
     */

    private final static int ITEM_TYPE_1=0;
    private final static int ITEM_TYPE_2=1;
    private final static int ITEM_TYPE_3=2;
    private final static int ITEM_TYPE_4=3;

    /**
     * 这里返回的type个数会决定adapter
     * @return type的个数
     */
    @Override
    public int getViewTypeCount() {
        return 5;
    }

    /**
     * 这里返回type不能大于type的个数
     * @param data item所匹配的数据
     * @param position item所在的点
     * @return type < {@link #getViewTypeCount()}
     */
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
