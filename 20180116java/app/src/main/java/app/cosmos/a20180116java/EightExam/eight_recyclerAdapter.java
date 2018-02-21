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

    private static final int TYPE_HEADER = 0; // 헤더 구분
    private static final int TYPE_ITEM = 1; // item 구분
    private static final int TYPE_FOOTER = 2; // 푸터 구분

    public ArrayList<eight_recyclerView_ItemData> eight_recyclerView_itemDatas; // eight_recyclerView_ItemData 타입의 list를 생성
    Context context; // context 객체 생성
    View.OnClickListener clickListener; // 클릭 리스너를 달기 위해서

    /*FIXME
    * 생성자 : 초기화를 위해서
    * */
    public eight_recyclerAdapter(ArrayList<eight_recyclerView_ItemData> eight_recyclerView_itemDatas, View.OnClickListener clickListener,Context context)
    {
        this.eight_recyclerView_itemDatas = eight_recyclerView_itemDatas;
        this.context = context;
        this.clickListener = clickListener;
    }
    /*FIXME
    * 뷰홀더를 생성하고 뷰를 붙여주는 부분이다.
    * onCreateViewHolder가 호출되기 전에 viewType을 매개변수로 하기 때문에
    * getItemViewType이 먼저 호출되면서 view의 position에 따라서 위에서 정의한
    * TYPE 상수를 return 한다.
    * 그리고 onCreateViewHolder에서는 viewType에 따라서 분기를 한다.
    * 따라서 getItemViewType() -> onCreateViewHolder()
    * */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        /*FIXME
        * TYPE_HEADER일 경우를 예로 들어서
        * 먼저, eight_recyclerview_header.xml을 inflate를 통해서 객체로 view 객체로 가져온다.
        * 그리고 .setOnClickListener을 통해서 클릭 리스너를 달아준다.
        * 마지막으로 eight_HeaderViewHolder()를 호출하면서 eight_recyclerview_header.xml를 객체화한 header_view를 넘겨준다.
        * 나머지도 똑같은 과정을 거친다.
        * */
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



    /*FIXME
    * 재활용되는 뷰가 호출하여 실행되는 메소드, 뷰홀더를 전달하고 어답터는 position의 데이터를 결합시킨다.
    * 메소드가 자동으로 뷰홀더와 position을 전달한다.
    * onBindViewHolder에서는 매개변수로 ViewHolder와 position이 들어온다.
    * ViewHolder에 따라서 분기를 다르게 하여 처리한다.
    * */


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof eight_HeaderViewHolder){

        }else if(holder instanceof eight_FooterViewHolder){
            /*FIXME
            * footer라면 작성자 이름을 입력하고 댓글을 입력하고 등록을 한다.
            * 그리고 작성자 이름이나 댓글 내용이 없다면 토스트 메시지로 띄워주고
            * 그렇지 않다면, 작성자의 이름과 댓글 내용을 가지고 와서 String 변수에 담아준다.
            * 그리고 위에서 선언한 리스트에 add()를 호출해서 추가해준다.
            * 그리고 notifyDataSetChanged()를 통해서 갱신된 사항들을 적용해준다.
            * */
            final eight_FooterViewHolder eight_footerViewHolder = (eight_FooterViewHolder) holder;
            // 등록 버튼에 대한 이벤트 처리
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
                        eight_footerViewHolder.writer_edit.setText("");
                        eight_footerViewHolder.content_edit.setText("");
                        showToast("댓글 등록");
                    }
                }
            });

        }else if(holder instanceof eight_BaseViewHolder){
            /*FIXME
            * header도 아니고 footer도 아닌 item일 경우
            * currentItem은 원래의 itemDatas에서 1을 뺀 position을 가지고 있다.
            * 이유는 맨 위에 header_view가 있기 때문에 하나를 뺀 다음부터의 position을 넘겨준다.
            * 그리고 item의 뷰에 있는 writer와 content에 값들을 할당하여 준다.
            * */
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

    /*FIXME
    * eight_recyclerView_itemDatas의 size에 header와 footer를 추가해서 +2를
    * 해서 return을 한다.
    * */
    @Override
    public int getItemCount() {
        return eight_recyclerView_itemDatas.size()+2;
    }

    public void showToast(String data){
        Toast.makeText(context,data,Toast.LENGTH_LONG).show();
    }
}
