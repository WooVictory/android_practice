package app.cosmos.a20180116java.Level1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-19.
 */

public class Level1Adapter extends RecyclerView.Adapter<Level1ViewHolder> {

    private ArrayList<Level1_ItemData> itemDatas;
    private View.OnClickListener clickListener;

    public Level1Adapter(ArrayList<Level1_ItemData> itemDatas, View.OnClickListener clickListener)
    {
        // Level1RecyclerActivity에서 호출할 때 넘겨준 매개변수 itemDatas, clickEvent를
        // 생성자에서 itemDatas와 clickListener로 받고 있다.
        // 그리고 생성자에서 초기화 진행
        this.itemDatas = itemDatas;
        this.clickListener = clickListener;
    }

    @Override
    public Level1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level1_recycler_item,parent,false);
        // 리사이클러뷰에서 반복시킬 아이템을 포함하고 있는 뷰를 inflate를 통해서 가지고 온다.
        Level1ViewHolder viewHolder = new Level1ViewHolder(view);
        // 그리고 가지고 온 뷰를 Level1ViewHolder를 호출할 때 매개변수로 넘겨준다.
        // viewHolder에서 작업을 한 뒤에는 viewHolder는 level1_recycler_item에 있는 textView의 level1_text의 id를 가지고 있고
        // 원하는 텍스트를 설저할 수 있다.
        view.setOnClickListener(clickListener);
        // 그리고 view에 clickListener를 달아준다.
        return viewHolder;
        // viewHolder를 반환한다.
    }

    @Override
    public void onBindViewHolder(Level1ViewHolder holder, int position) {
        // holder는 Level1ViewHolder이므로
        // 이제 level1_recycler_item에 있는 textView인 level1_text에 값을 설정할 수 있다.
        holder.level1_text.setText(itemDatas.get(position).level1_text);
        // Level1RecyclerActivity에서 Level1Adapter를 호출할 때 매개변수로 넘긴 itemDatas가
        // 여기로 들어오면서 생성자를 통해 초기화 되었기 때문에 여기서도 똑같이 접근이 가능하다.
        // 그러니까 itemData의 해당 항목(즉 위치(position))에 해당하는 곳에 텍스트를 추가할 수 있다.

    }

    @Override
    public int getItemCount() {
        return itemDatas.size();
    }
}
