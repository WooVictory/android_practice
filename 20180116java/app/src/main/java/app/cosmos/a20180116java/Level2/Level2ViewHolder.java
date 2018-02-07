package app.cosmos.a20180116java.Level2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-19.
 */

public class Level2ViewHolder extends RecyclerView.ViewHolder {
    TextView level2_text;
    public Level2ViewHolder(View itemView) {
        super(itemView);
        level2_text = itemView.findViewById(R.id.level2_text);
        // 레이아웃에 존재하는 id를 가질 수 있도록 함
    }
}
