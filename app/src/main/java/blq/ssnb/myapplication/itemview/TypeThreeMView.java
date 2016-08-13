package blq.ssnb.myapplication.itemview;

import android.view.View;
import android.widget.TextView;

import blq.ssnb.madapter.item.AbsMViewItem;
import blq.ssnb.myapplication.R;
import blq.ssnb.myapplication.model.TypeThreeModel;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/8/13
 * 描述:
 * 添加描述
 * ================================================
 */
public class TypeThreeMView extends AbsMViewItem<TypeThreeModel> {
    @Override
    protected int getLayout() {
        return R.layout.item_style_3;
    }

    @Override
    protected ViewHolder initView(View convertView) {
        MViewHolder viewHolder = new MViewHolder();
        viewHolder.title = (TextView) convertView.findViewById(R.id.title);
        viewHolder.subtitle = (TextView)convertView.findViewById(R.id.msg);
        viewHolder.random = (TextView) convertView.findViewById(R.id.ll_tv_random);
        return viewHolder;
    }

    @Override
    public void bindData(View convertView, TypeThreeModel data) {
        MViewHolder viewHolder = (MViewHolder)convertView.getTag();
        viewHolder.title.setText(data.getTitle());
        viewHolder.subtitle.setText(data.getSubTitle());
        viewHolder.random.setText(data.getRandom());
    }

    private class MViewHolder implements ViewHolder{
        TextView title;
        TextView subtitle;
        TextView random;
    }
}
