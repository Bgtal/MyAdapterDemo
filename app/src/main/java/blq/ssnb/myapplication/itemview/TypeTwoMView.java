package blq.ssnb.myapplication.itemview;

import android.view.View;
import android.widget.TextView;

import blq.ssnb.madapter.item.AbsMViewItem;
import blq.ssnb.myapplication.R;
import blq.ssnb.myapplication.model.TypeTwoModel;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/8/13
 * 描述:
 * 添加描述
 * ================================================
 */
public class TypeTwoMView extends AbsMViewItem<TypeTwoModel> {
    @Override
    protected int getLayout() {
        return R.layout.item_style_2;
    }

    @Override
    protected ViewHolder initView(View convertView) {
        MViewHolder viewHolder = new MViewHolder();
        viewHolder.title = (TextView) convertView.findViewById(R.id.title);
        return viewHolder;
    }

    @Override
    public void bindData(View convertView, TypeTwoModel data) {
        MViewHolder viewHolder = (MViewHolder) convertView.getTag();
        viewHolder.title.setText(data.getMessage());
    }

    private class MViewHolder implements ViewHolder{
        TextView title ;
    }
}
