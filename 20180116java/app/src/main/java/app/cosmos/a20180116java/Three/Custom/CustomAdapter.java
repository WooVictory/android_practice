package app.cosmos.a20180116java.Three.Custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-18.
 */

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Itemdata> itemdata;
    private Context context;

    public CustomAdapter(ArrayList<Itemdata> itemdata, Context context)
    { // 생성자 정의
        this.itemdata = itemdata;
        this.context = context;
        // 호출할 때 매개변수로 itemdatas와 this 가 넘어왔고
        // 생성자를 통해서 초기화를 진행한다.
    }

    @Override
    public int getCount() {
        return itemdata !=null ? itemdata.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view ==null)
        { // 클래스로 작성되었기 때문에 view가 없어서 inflate를 통해서 뷰를 연결하고 있다.
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_listview_item,parent,false);
        }

        ImageView item_image = view.findViewById(R.id.custom_image_item);
        TextView item_title = view.findViewById(R.id.custom_title_item);
        TextView item_content = view.findViewById(R.id.custom_content_item);

        // 지금 여기서 사용하고 있는 itemdata는 CustomListViewActivity에서 CustomAdapter를 호출할 때
        // 매개변수로 사용한 데이터가 저장되어 있는 itemdatas
        // 그 itemdatas가 여기서는 itemdata로 사용되고 있다.
        item_image.setImageResource(itemdata.get(position).image);
        item_title.setText(itemdata.get(position).title);
        item_content.setText(itemdata.get(position).content);
        // custom_listview_item xml에 있는 각 뷰 요소들에게 데이터를 할당하고
        // 뷰를 반환한다.
        return view;
    }
}
