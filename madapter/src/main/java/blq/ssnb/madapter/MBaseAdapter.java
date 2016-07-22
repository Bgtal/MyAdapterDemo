package blq.ssnb.madapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SSNB on 2016/7/22.
 *
 */
public abstract class MBaseAdapter<T> extends BaseAdapter{

    private Context mContext;
    private List<T> listData;
    public MBaseAdapter(Context context, List<T> listData){
        this.mContext = context;
        this.listData = (listData==null?new ArrayList<T>():listData);
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

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }
    public List<T> getListData(){
        return listData;
    }
    public void setListData(List<T> listData){
        if(listData!=null){
            this.listData=listData;
        }else{
            this.listData.clear();
        }
    }

    public void addItem(T data){
        listData.add(data);
        notifyDataSetChanged();
    }

    public void addItemAtIndex(T data,int index){
        listData.add(index,data);
        notifyDataSetChanged();
    }

    public void addItems(List<T> datas){
        if(listData == null){
            listData = datas;
        }else{
            listData.addAll(datas);
        }
        notifyDataSetChanged();
    }

    public void removeItem(T data){
        listData.remove(data);
        notifyDataSetChanged();
    }

    public void removeItemByIndex(int index){
        listData.remove(index);
        notifyDataSetChanged();
    }

    public void removeAllItem(){
        if(listData!=null){
            listData.clear();
        } else {
            listData=new ArrayList<>();
        }
        notifyDataSetChanged();
    }
}
