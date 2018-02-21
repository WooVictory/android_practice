package app.cosmos.a20180116java.EightExam;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sec on 2018-02-18.
 */

public class eight_BaseViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.eight_writer_text)
    TextView eight_writer_text;
    @BindView(R.id.eight_content_text)
    TextView eight_content_text;
    public eight_BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        eight_writer_text = (TextView) itemView.findViewById(R.id.eight_writer_text);
        eight_content_text = (TextView) itemView.findViewById(R.id.eight_content_text);
    }
}
