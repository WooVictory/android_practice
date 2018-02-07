package app.cosmos.a20180116java.Three.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-18.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView custom_item_image;
    TextView custom_item_title;
    TextView custom_item_content;


    public MyViewHolder(View itemView) {
        // 생성자의 인자로  RecyclerAdapter에서 넘어온 custom_recyclerview_item 즉 리사이클러뷰에 반복될 아이템들을
        // 가지고 있는 뷰가 들어온다.
        super(itemView);

        custom_item_image = itemView.findViewById(R.id.custom_recycler_item_img);
        custom_item_title = itemView.findViewById(R.id.custom_recycler_item_title);
        custom_item_content = itemView.findViewById(R.id.custom_recycler_item_content);
    }
}
