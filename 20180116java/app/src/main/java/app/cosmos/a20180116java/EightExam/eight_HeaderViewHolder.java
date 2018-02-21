package app.cosmos.a20180116java.EightExam;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-02-18.
 */

public class eight_HeaderViewHolder extends RecyclerView.ViewHolder {
    public static TextView header_text;
    public eight_HeaderViewHolder(View itemView) {
        super(itemView);

        header_text = (TextView) itemView.findViewById(R.id.header_text);

    }
}
