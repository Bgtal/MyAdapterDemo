package blq.ssnb.madapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SSNB on 2016/7/21.
 * 对Adapter的分装
 */
public class MBaseAdapter<T> extends BaseAdapter {

    private Context mContext;
    private List<T> listData;
    private MViewController<T> mViewController;
    private final HashMap<Integer,MViewItem<T>> mViewItems;

    /**
     * 创建一个MBaseAdapter 对象
     * @param context 上下文对象
     * @param listData 数据对象
     * @param controller Item控制器对象
     */
    public MBaseAdapter(Context context,List<T> listData, MViewController<T> controller){
        this.mContext = context;
        this.listData=(listData == null?new ArrayList<T>():listData);
        this.mViewController = controller;
        this.mViewItems= new HashMap<>(controller.getViewTypeCount());
        Log.e("TAG","listSize:"+this.listData.size());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCount() {
        return listData==null?0:listData.size();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public T getItem(int position) {
        return listData==null?null:listData.get(position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemViewType(int position) {
        return mViewController.getItemViewType(getItem(position),position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getViewTypeCount() {
        return mViewController.getViewTypeCount();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        T data = getItem(position);
        int type = getItemViewType(position);
        MViewItem<T> item = mViewItems.get(type);
        if(item==null){
            item = mViewController.newViewItem(type);
            mViewItems.put(type,item);
            Log.e("TAG","new Item");
        }
        if (convertView==null){
            item = mViewController.newViewItem(type);
            convertView = item.newConvertView(mContext,parent);
            Log.e("TAG","new convertView");
        }
        item.bindData(convertView,data);
        return convertView;
    }
}
