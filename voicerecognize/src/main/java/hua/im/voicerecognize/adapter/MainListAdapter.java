package hua.im.voicerecognize.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import junit.framework.Assert;

import java.util.List;

import hua.im.voicerecognize.R;
import hua.im.voicerecognize.entity.ItemMainList;

/**
 * Created by hua on 15-5-2.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainListHolder> {

    private Activity activity;

    private List<ItemMainList> itemMainLists;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public MainListAdapter(Activity activity,List<ItemMainList> itemMainLists) {
        Assert.assertNotNull("MainListAdapter: itemMainLists can not be null",itemMainLists);
        Assert.assertNotNull("MainListAdapter: activity can not be null",activity);

        this.itemMainLists = itemMainLists;
        this.activity = activity;
    }

    @Override
    public void onBindViewHolder(MainListHolder mainListHolder, int i) {
        Assert.assertNotNull("MainListAdapter: itemMainLists can not be null",itemMainLists);

        mainListHolder.textView.setText(itemMainLists.get(i).getText());

    }

    @Override
    public MainListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = activity.getLayoutInflater().inflate(R.layout.item_main_list, null);

        return new MainListHolder(rootView);
    }

    @Override
    public int getItemCount() {
        return itemMainLists.size();
    }


    class MainListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;

        public MainListHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_main_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Assert.assertNotNull("MainListAdapter: onItemClickListener can not be null",onItemClickListener);

            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
