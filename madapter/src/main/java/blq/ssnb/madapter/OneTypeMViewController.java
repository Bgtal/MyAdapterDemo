package blq.ssnb.madapter;

/**
 * Created by SSNB on 2016/7/25.
 * 单独的一个Item
 */
public class OneTypeMViewController<T> extends AbsMViewController<T> {
    private MViewItem<T> mViewItem;
    public OneTypeMViewController(MViewItem<T> mViewItem){
        this.mViewItem = mViewItem;
    }

    @Override
    public MViewItem<T> newViewItem(int type) {
        return mViewItem;
    }
}
