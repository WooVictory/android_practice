package app.cosmos.a20180116java.Level2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-19.
 */

public class Level2Adapter extends RecyclerView.Adapter<Level2ViewHolder> {

    private ArrayList<Level2_itemData> level2_itemDatas;
    private ArrayList<Level2_itemData> filterDatas;
    private View.OnClickListener clickListener;

    public Level2Adapter(ArrayList<Level2_itemData> level2_itemDatas, View.OnClickListener clickListener)
    {
        this.level2_itemDatas = level2_itemDatas;
        this.filterDatas = new ArrayList<Level2_itemData>();
        // 똑같이 사용자 데이터를 가질 수 있도록 함.
        filterDatas.addAll(level2_itemDatas);
        // level2_itemDatas의 내용을 전부 가지고 있는 filterDatas 생성
        // 복사본 역할을 하며, 아래 검색함수에서 사용됨.
        this.clickListener = clickListener;
    }
    @Override
    public Level2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level2_recycler_item,parent,false);
        view.setOnClickListener(clickListener);
        Level2ViewHolder level2ViewHolder = new Level2ViewHolder(view);
        return level2ViewHolder;
    }

    @Override
    public void onBindViewHolder(Level2ViewHolder holder, int position) {
        holder.level2_text.setText(level2_itemDatas.get(position).level2_text);

    }

    @Override
    public int getItemCount() {
        return level2_itemDatas.size();
    }

    public void filter(String text)
    {
        text = text.toLowerCase();
        // 입력으로 들어온 text가 대문자/소문자로 변환되어서 저장되고
        level2_itemDatas.clear();
        // 원래 가지고 있던 데이터들을 싹 지우고
        if(text.length() == 0)
        {
            level2_itemDatas.addAll(filterDatas);
            // 입력으로 들어온 text의 길이가 0이라는 것은
            // 검색하려는 것이 없다는 것이다.
            // 그러므로 지웠던 데이터를 복사본을 통해서 다시 채워준다.
        }else
        {
            for(Level2_itemData itemData : filterDatas)
            {
                if(itemData.level2_text.toLowerCase().contains(text))
                {
                    level2_itemDatas.add(itemData);
                }
            }
        }
        notifyDataSetChanged();

    }

}

/*FIXME
  Level2RecyclerActivity에서 입력된 text가 filter 함수에 들어온다.
  그리고 대문자를 소문자로 변경
  level2_itemDatas 출력부를 전부 지워준다.
  입력으로 들어온 text가 없다면 다시 level2_itemDatas를 채운다.
  0이 아니라 입력으로 들어온 text가 존재한다면
  for 반복문을 실행한다. filterData 배열에 남아있는 원소가 없을 때까지 반복문이 실행된다.
  filterDatas에는 복사본이 들어있기 때문에 그 복사본 데이터들을 Level2_itemData타입의 itemData에 넣으면서
  내가 입력으로 받은 text가 포함되는지 if문을 통해서 확인한다.
  text가 포함된다면 복사본인 filterDatas가 itemData에 담겨 있기 때문에
  itemData를 앞에서 전부 지워진 level2_itemDatas에 추가해준다.
  그리고 마지막에 갱신해서 출력해준다.

* */