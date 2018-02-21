package app.cosmos.a20180116java.EightExam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-02-18.
 */

public class eight_recyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    public ArrayList<eight_recyclerView_ItemData> eight_recyclerView_itemDatas;
    Context context;
    View.OnClickListener clickListener;

    public eight_recyclerAdapter(ArrayList<eight_recyclerView_ItemData> eight_recyclerView_itemDatas, View.OnClickListener clickListener,Context context)
    {
        this.eight_recyclerView_itemDatas = eight_recyclerView_itemDatas;
        this.context = context;
        this.clickListener = clickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER)
        {
            View header_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eight_recyclerview_header,parent,false);
            header_view.setOnClickListener(clickListener);
            return new eight_HeaderViewHolder(header_view);
        }else if(viewType == TYPE_FOOTER){
            View footer_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eight_recyclerview_footer,parent,false);
            footer_view.setOnClickListener(clickListener);
            return new eight_FooterViewHolder(footer_view);
        }else if(viewType == TYPE_ITEM){
            View item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eight_reycyelerview_item,parent,false);
            item_view.setOnClickListener(clickListener);
            return new eight_BaseViewHolder(item_view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof eight_HeaderViewHolder){

        }else if(holder instanceof eight_FooterViewHolder){
            final eight_FooterViewHolder eight_footerViewHolder = (eight_FooterViewHolder) holder;
            eight_footerViewHolder.eight_commentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(eight_footerViewHolder.writer_edit.length() == 0 || eight_footerViewHolder.content_edit.length() == 0)
                    {
                        showToast("내용을 입력해주세요.");
                    }else{
                        String temp_writer = eight_footerViewHolder.writer_edit.getText().toString();
                        String temp_content = eight_footerViewHolder.content_edit.getText().toString();
                        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData(temp_writer,temp_content));
                        notifyDataSetChanged();
                        showToast("댓글 등록");
                    }
                }
            });

        }else if(holder instanceof eight_BaseViewHolder){
            eight_recyclerView_ItemData currentItem = eight_recyclerView_itemDatas.get(position-1);
            eight_BaseViewHolder eight_baseViewHolder = (eight_BaseViewHolder) holder;
            eight_baseViewHolder.eight_writer_text.setText("작성자 : "+currentItem.writer);
            eight_baseViewHolder.eight_content_text.setText("내용 : "+currentItem.content);

        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }else if(position == eight_recyclerView_itemDatas.size()+1) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return eight_recyclerView_itemDatas.size()+2;
    }

    public void showToast(String data){
        Toast.makeText(context,data,Toast.LENGTH_LONG).show();
    }
}
