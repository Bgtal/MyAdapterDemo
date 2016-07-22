package blq.ssnb.myapplication.itemview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import blq.ssnb.madapter.MViewItem;
import blq.ssnb.myapplication.model.TestModel;

/**
 * Created by SSNB on 2016/7/22.
 *
 */
public class EntityMView1 implements MViewItem<TestModel> {

    @Override
    public View newConvertView(Context context, ViewGroup viewGroup) {
        return new TextView(context);
    }

    @Override
    public void bindData(View convertView, TestModel data) {
        ((TextView)convertView).setText(data.getTitle());
    }
}
