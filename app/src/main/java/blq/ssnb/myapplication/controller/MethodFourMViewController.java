package blq.ssnb.myapplication.controller;


import android.widget.AbsListView;
import android.widget.ListAdapter;

import blq.ssnb.madapter.controller.MViewController;
import blq.ssnb.madapter.item.MViewItem;
import blq.ssnb.myapplication.itemview.TypeOneMView;
import blq.ssnb.myapplication.itemview.TypeThreeMView;
import blq.ssnb.myapplication.itemview.TypeTwoMView;
import blq.ssnb.myapplication.model.BaseModel;

/**
 * Created by SSNB on 2016/7/22.
 * 当item的类型有多种的时候需要重写{@link #getViewTypeCount()}
 * 和{@link #getItemViewType(BaseModel, int)}
 */
public class MethodFourMViewController implements MViewController<BaseModel> {
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

    /**
     * 这里返回的type个数会决定adapter
     * @return type的个数
     */
    @Override
    public int getViewTypeCount() {
        return 3;
    }

    /**
     * 这里返回type不能大于type的个数
     * @param data item所匹配的数据
     * @param position item所在的点
     * @return type < {@link #getViewTypeCount()}
     */
    @Override
    public int getItemViewType(BaseModel data, int position) {
        return data.getType();
    }

    @Override
    public MViewItem<BaseModel> newViewItem(int type) {
        MViewItem item = null;
        switch (type){
            case ITEM_TYPE_1:
                item = new TypeOneMView();
                break;
            case ITEM_TYPE_2:
                item = new TypeTwoMView();
                break;
            case ITEM_TYPE_3:
                item = new TypeThreeMView();
                break;
        }
        return item;
    }
}
