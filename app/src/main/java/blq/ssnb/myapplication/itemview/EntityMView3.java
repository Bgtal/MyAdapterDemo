package blq.ssnb.myapplication.itemview;

import android.view.View;
import android.widget.TextView;

import blq.ssnb.madapter.AbsMViewItem;
import blq.ssnb.myapplication.R;
import blq.ssnb.myapplication.model.TestModel;

/**
 * Created by SSNB on 2016/7/22.
 */
public class EntityMView3 extends AbsMViewItem<TestModel> {
    @Override
    protected int getLayout() {
        return R.layout.item_style_3;
    }

    @Override
    protected ViewHolder initView(View convertView) {
        mViewHolder holder = new mViewHolder();
        holder.title = (TextView) convertView.findViewById(R.id.title);
        holder.msg = (TextView)convertView.findViewById(R.id.msg);
        return holder;
    }


    @Override
    public void bindData(View convertView, TestModel data) {
        mViewHolder holder = (mViewHolder)convertView.getTag();
        holder.title.setText(data.getTitle());
        holder.msg.setText(data.getMessage());
    }

    private class mViewHolder implements ViewHolder{
        TextView title;
        TextView msg;
    }
}
