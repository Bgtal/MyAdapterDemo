package blq.ssnb.myapplication.itemview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import blq.ssnb.madapter.item.MViewItem;
import blq.ssnb.myapplication.model.TypeOneModel;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/8/13
 * 描述:
 * 添加描述
 * ================================================
 */
public class TypeOneMView implements MViewItem<TypeOneModel> {
    @Override
    public View newConvertView(Context context, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setTextColor(0xFF00FFFF);
        textView.setHeight(100);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void bindData(View convertView, TypeOneModel data) {
        ((TextView) convertView).setText(
                String.format(
                        "title:%s\nmessage:%s",
                        data.getTitle(),
                        data.getMessage()
                )
        );
    }
}
