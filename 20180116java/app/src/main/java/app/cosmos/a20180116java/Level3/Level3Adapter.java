package app.cosmos.a20180116java.Level3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-19.
 */

public class Level3Adapter extends RecyclerView.Adapter<Level3ViewHolder> {

    private ArrayList<Level3_itemData> level3_itemDatas;
    private ArrayList<Level3_itemData> filterDatas;
    private View.OnClickListener clickListener;
    public Level3Adapter(ArrayList<Level3_itemData> level3_itemDatas, View.OnClickListener clickListener){
        this.level3_itemDatas = level3_itemDatas;
        this.filterDatas = new ArrayList<Level3_itemData>();
        filterDatas.addAll(level3_itemDatas);
        this.clickListener = clickListener;
    }

    @Override
    public Level3ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level3_recycler_item,parent,false);
        Level3ViewHolder level3ViewHolder = new Level3ViewHolder(view);
        view.setOnClickListener(clickListener);
        return level3ViewHolder;
    }

    @Override
    public void onBindViewHolder(Level3ViewHolder holder, int position) {
        holder.image_three.setImageResource(level3_itemDatas.get(position).level3_image);
        holder.title_three.setText(level3_itemDatas.get(position).level3_title);

    }

    @Override
    public int getItemCount() {
        return level3_itemDatas.size();
    }
    public void filter(String text)
    {
        text = text.toLowerCase();
        level3_itemDatas.clear();
        if(text.length() == 0)
        {
            level3_itemDatas.addAll(filterDatas);
        }else
        {
            for(Level3_itemData itemData : filterDatas)
            {
                if(itemData.level3_title.toLowerCase().contains(text))
                {
                    level3_itemDatas.add(itemData);
                }
            }
        }
        notifyDataSetChanged();
        // 데이터를 갱신

    }
    public void refreshAdapter(ArrayList<Level3_itemData> level3_itemDatas)
    {
        this.level3_itemDatas = level3_itemDatas;
        notifyDataSetChanged();

    }
}
