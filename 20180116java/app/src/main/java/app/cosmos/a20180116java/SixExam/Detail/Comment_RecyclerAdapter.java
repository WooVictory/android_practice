package app.cosmos.a20180116java.SixExam.Detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import app.cosmos.a20180116java.SixExam.ViewHolder.SixViewHolder;

/**
 * Created by sec on 2018-02-15.
 */

public class Comment_RecyclerAdapter extends RecyclerView.Adapter<SixViewHolder> {
    private ArrayList<DetailResult.CommentData> commentDatas;
    public Comment_RecyclerAdapter(ArrayList<DetailResult.CommentData> commentDatas)
    {
        this.commentDatas = commentDatas;
    }
    public void setAdapter(ArrayList<DetailResult.CommentData> commentDatas)
    {
        this.commentDatas = commentDatas;
        notifyDataSetChanged();
    }

    @Override
    public SixViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_content,parent,false);
        SixViewHolder sixViewHolder = new SixViewHolder(view);
        return sixViewHolder;
    }

    @Override
    public void onBindViewHolder(SixViewHolder holder, int position) {
        holder.VH_Comment_writer.setText(commentDatas.get(position).writer);
        holder.VH_Comment_content.setText(commentDatas.get(position).content);
        holder.VH_Comment_written_time.setText(commentDatas.get(position).written_time);

    }

    @Override
    public int getItemCount() {
        return commentDatas.size();
    }
}
