package app.cosmos.a20180116java.SixExam.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sec on 2018-01-29.
 */

public class SixViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.MainList_writer)
    public TextView VH_MainList_writer;
    @BindView(R.id.MainList_title)
    public TextView VH_MainList_title;
    @BindView(R.id.MainList_date)
    public TextView VH_MainList_date;
    @BindView(R.id.MainList_count)
    public TextView VH_MainList_count;

    public SixViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        VH_MainList_title = itemView.findViewById(R.id.MainList_title);
        VH_MainList_writer = itemView.findViewById(R.id.MainList_writer);
        VH_MainList_date = itemView.findViewById(R.id.MainList_date);
        VH_MainList_count = itemView.findViewById(R.id.MainList_count);
    }

    public TextView getVH_MainList_writer() {
        return VH_MainList_writer;
    }

    public void setVH_MainList_writer(TextView VH_MainList_writer) {
        this.VH_MainList_writer = VH_MainList_writer;
    }

    public TextView getVH_MainList_title() {
        return VH_MainList_title;
    }

    public void setVH_MainList_title(TextView VH_MainList_title) {
        this.VH_MainList_title = VH_MainList_title;
    }

    public TextView getVH_MainList_date() {
        return VH_MainList_date;
    }

    public void setVH_MainList_date(TextView VH_MainList_date) {
        this.VH_MainList_date = VH_MainList_date;
    }

    public TextView getVH_MainList_count() {
        return VH_MainList_count;
    }

    public void setVH_MainList_count(TextView VH_MainList_count) {
        this.VH_MainList_count = VH_MainList_count;
    }
}
