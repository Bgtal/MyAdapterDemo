package blq.ssnb.madapter;

/**
 * Created by SSNB on 2016/7/21.
 *
 */
public interface MViewController<T> {

    /**
     * 获取某个Item的显示类型
     * @param data item所匹配的数据
     * @param position item所在的点
     * @return 返回view的类型
     */
    int getItemViewType(T data, int position);

    /**
     * 获取View的类型个数
     * @return 类型个数
     */
    int getViewTypeCount();

    /**
     *
     * 更具item的类型来获取一个ViewItem对象
     * @param type item的类型
     * @return 返回一个ItemView对象
     */
    MViewItem<T> newViewItem(int type);
}
