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

    /*FIXME
    *생성자를 통해서 초기화를 진행*/
    public RecyclerAdapter(ArrayList<MainListData> mainListDatas, View.OnClickListener clickListener)
    {
        this.mainListDatas = mainListDatas;
        this.clickListener = clickListener;
    }

    /*FIXME
    RefreshAdapter 느낌이다.
    다시 갱신해주는 어답터
    처음에는 데이터가 없는데 setAdapter를 통해서 갱신을 하니까
    받은 데이터를 넣어서 초기화해주고
    notifyDataSetChanged()를 호출한다.
    그러면 첫 호출이기 때문에 onCreateViewHolder,onBindViewHolder에서 하는 과정이 일어나는 것 같다.
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
        holder.VH_MainList_writer.setText(mainListDatas.get(position).writer);
        holder.VH_MainList_date.setText(mainListDatas.get(position).written_time);
        holder.VH_MainList_count.setText(mainListDatas.get(position).view_number+ " ");

    }

    @Override
    public int getItemCount() {
        return mainListDatas.size();
    }
}
