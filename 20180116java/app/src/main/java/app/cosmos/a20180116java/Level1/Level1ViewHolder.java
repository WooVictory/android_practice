package app.cosmos.a20180116java.Level1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-19.
 */

public class Level1ViewHolder extends RecyclerView.ViewHolder {

    TextView level1_text;
    public Level1ViewHolder(View itemView)
    {
        // 생성자의 itemView에는 Level1Adapter에서 넘겨준 level1_recycler_item을 받는다.
        // 그리고 그 level1_recycler_item의 textView의 id를 가지고 온다.
        super(itemView);

        level1_text = itemView.findViewById(R.id.level1_text);
    }
}
