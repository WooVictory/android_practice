package app.cosmos.a20180116java.Level3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-19.
 */

public class Level3ViewHolder extends RecyclerView.ViewHolder{

    ImageView image_three;
    TextView title_three;

    public Level3ViewHolder(View itemView) {
        super(itemView);

        image_three = itemView.findViewById(R.id.level3_recycler_item_img);
        title_three = itemView.findViewById(R.id.level3_recycler_item_title);
    }
}
