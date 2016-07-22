package blq.ssnb.madapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SSNB on 2016/7/21.
 *
 */
public interface MViewItem<T> {
    /**
     * 创建一个ItemView
     * @param context 上下文对象
     * @param viewGroup 父视图的ViewGroup
     * @return 返回一个ItemView
     */
    View newConvertView(Context context, ViewGroup viewGroup);

    /**
     * 将View 和数据进行绑定
     * @param convertView 待绑定的View
     * @param data 待绑定的数据
     */
    void bindData(View convertView, T data);
}
