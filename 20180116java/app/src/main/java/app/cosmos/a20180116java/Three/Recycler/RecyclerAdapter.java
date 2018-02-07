package app.cosmos.a20180116java.Three.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {


    private ArrayList<Itemdata_recycler> itemdatas;
    View.OnClickListener clickListener;

    public RecyclerAdapter(ArrayList<Itemdata_recycler> itemdatas, View.OnClickListener clickListener)
    { // 생성자를 통해 호출될 때 매개변수로 받은 데이터로 초기화를 진행
        this.itemdatas = itemdatas;
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview_item,parent,false);
        // 리사이클러뷰에 반복될 item을 담고 있는 뷰를 inflate 한다.
        MyViewHolder viewHolder = new MyViewHolder(view);
        // 그리고 그 view를 MyViewHolder에 넘겨준다.
        view.setOnClickListener(clickListener);
        // 그리고 view에 clickListener를 달아준다.
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 리턴받은 viewHolder를 가지고
        // holder에 custom_item_iamge,custom_item_title,custom_item_content에
        // itemdatas는 itemDatas_recycler로 초기화 되었다.
        // 그리고 itemdatas에 있는 데이터들로 holder에 값들을 할당해주고 있다.
        holder.custom_item_image.setImageResource(itemdatas.get(position).image);
        holder.custom_item_title.setText(itemdatas.get(position).title);
        holder.custom_item_content.setText(itemdatas.get(position).content);
        // 여기까지가 setAdapter를 하기 전까지 상황
    }

    @Override
    public int getItemCount() {
        return itemdatas.size();
    }
}
