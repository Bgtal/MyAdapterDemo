package blq.ssnb.myapplication.itemview;

import android.view.View;
import android.widget.TextView;

import blq.ssnb.madapter.AbsMViewItem;
import blq.ssnb.myapplication.R;
import blq.ssnb.myapplication.model.TestModel;

/**
 * Created by SSNB on 2016/7/22.
 */
public class EntityMView2 extends AbsMViewItem<TestModel> {

    @Override
    protected int getLayout() {
        return R.layout.item_style_2;
    }

    @Override
    protected ViewHolder initView(View convertView) {
        mViewHolder viewHolder = new mViewHolder();
        viewHolder.title = (TextView) convertView.findViewById(R.id.title);
        return viewHolder;
    }

    @Override
    public void bindData(View convertView, TestModel data) {
        mViewHolder holder = (mViewHolder)convertView.getTag();
        holder.title.setText(data.getTitle());
    }
    private class mViewHolder implements ViewHolder{
        TextView title ;
    }
}
