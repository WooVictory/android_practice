package app.cosmos.a20180116java.SixExam.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import app.cosmos.a20180116java.SixExam.ViewHolder.SixViewHolder;

/**
 * Created by sec on 2018-01-29.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<SixViewHolder> {

    public ArrayList<MainListData> mainListDatas;
    public View.OnClickListener clickListener;

    public RecyclerAdapter(ArrayList<MainListData> mainListDatas, View.OnClickListener clickListener)
    {
        this.mainListDatas = mainListDatas;
        this.clickListener = clickListener;
    }

    /*FIXME
    RefreshAdapter 느낌이다.
    다시 갱신해주는 어답터
    * */
    public void setAdapter(ArrayList<MainListData> mainListDatas)
    {
        this.mainListDatas=mainListDatas;
        notifyDataSetChanged();
    }


    @Override
    public SixViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_content,parent,false);
        SixViewHolder sixViewHolder = new SixViewHolder(view);
        view.setOnClickListener(clickListener);
        return sixViewHolder;
    }

    @Override
    public void onBindViewHolder(SixViewHolder holder, int position) {
        holder.VH_MainList_title.setText(mainListDatas.get(position).title);
        holder.VH_MainList_writer.setText(mainListDatas.get(position).username);

    }

    @Override
    public int getItemCount() {
        return mainListDatas.size();
    }
}
