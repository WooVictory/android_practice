package app.cosmos.a20180116java.EightExam;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.eight_recyclerView)
    RecyclerView eight_recyclerView;
    private ArrayList<eight_recyclerView_ItemData> eight_recyclerView_itemDatas;
    private eight_recyclerAdapter eight_recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    public int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

        /*레이아웃 매니저 객체 초기화*/
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // 방향을 vertical로 설정
        eight_recyclerView.setLayoutManager(linearLayoutManager);
        // 그리고 리사이클러뷰에 setLayoutManager을 통해서 방향을 가지고 있는 linearLayoutManager 객체를 넘겨준다.

        eight_recyclerView.setHasFixedSize(true);
        // 리사이클러뷰의 크기를 고정

        /* eight_recyclerView_itemDatas를 위에서 선언만 해주었기 때문에 초기화를 통해서 eight_recyclerView_itemData 타입의 list를 만든다. */
        eight_recyclerView_itemDatas = new ArrayList<eight_recyclerView_ItemData>();
        // 리스트에 데이터를 추가할 때는 add() 함수를 이용하고 ()안에는 저런 형식으로 들어간다.
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("이승우","댓글1"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("정지현","댓글2"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("탁형민","댓글3"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("홍주영","댓글4"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("이승우","댓글1"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("정지현","댓글2"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("탁형민","댓글3"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("홍주영","댓글4"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("이승우","댓글1"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("정지현","댓글2"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("탁형민","댓글3"));
        eight_recyclerView_itemDatas.add(new eight_recyclerView_ItemData("홍주영","댓글4"));
        // eight_recyclerAdapter 객체를 생성해주고 매개변수로 itemDatas와 클릭 리스너, 그리고 getApplicationContext()를 넘겨준다.
        eight_recyclerAdapter = new eight_recyclerAdapter(eight_recyclerView_itemDatas, onClickListener,getApplicationContext());
        eight_recyclerView.setAdapter(eight_recyclerAdapter);
    }
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int itemPosition = eight_recyclerView.getChildPosition(view);
            Log.v("1144",String.valueOf(itemPosition));
            trans(itemPosition);
            Log.v("1147",String.valueOf(count));
            // 다이얼로그 객체를 만들었다.
            // 다이얼로그 객체를 통해서 해당 항목을 삭제할 수도 있고, 삭제하지 않으면 header_view에 text를 지정할 수도 있다.
            final AlertDialog.Builder dialog = new AlertDialog.Builder(RecyclerActivity.this);
            dialog.setMessage("해당 항목을 삭제하시겠습니까??");
            dialog.setCancelable(true);
            dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    /*FIXME
                    * 해당 항목을 클릭하면 dialog 창을 띄워주면서 "예"를 클릭하면 아이템을 삭제한다.
                    * itempPosition을 하면 어떤 항목을 클릭해도 뒤에 있는 item이 삭제되기 때문에
                    * itemPosition-1을 하였다. 이렇게 하면 클릭된 item이 삭제된다.
                    * 그리고 eight_recyclerAdapter.notifyDataSetChanged()를 통해 바뀐 내용을 갱신한다.
                    * */
                    eight_recyclerView_itemDatas.remove(itemPosition-1);
                    eight_recyclerAdapter.notifyDataSetChanged();
                }
            });
            /*FIXME
            * "아니오"를 클릭하였을 때는 삭제하지 않고, 헤더일 경우에는
            * 토스트 메시지를 통해 알려주고, footer가 아닌 경우에는 item이기 때문에
            * 해당 item의 위치를 토스트 메시지로 알려주고
            * 해당 항목의 writer를 헤더의 text에 설정해준다.
            * */
            dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(itemPosition == 0)
                    {
                        eight_recyclerAdapter.showToast("헤더입니다.");
                    }

                    else if(itemPosition != eight_recyclerView_itemDatas.size()+2){
                        eight_recyclerAdapter.showToast(itemPosition+"번 댓글입니다.");
                        String temp_header = eight_recyclerView_itemDatas.get(itemPosition-1).writer;
                        eight_HeaderViewHolder.header_text.setText(temp_header);
                    }
                }
            });

            /*FIXME
            * itemPosition : 리사이클러뷰가 뷰 전체를 잡고 있기 때문에 그곳에서 Header의 위치는 0이고 Footer의 위치는 eight_recyclerView_itemDatas.size()+2이다.
            * 그래서 토스트 메시지로 몇번째 댓글인지 확인할 때는 itemPosition만 넘겨도 Header와 Footer 사이에 존재하는 항목이기 때문에 그대로 사용해도 된다.
            * 그리고 header에 존재하는 TextView에 text를 설정하기 위해서 eight_recyclerView_itemDatas.get(itemPosition-1).writer
            * eight_recyclerView_itemDatas 여기서는 위에 존재하는 header를 빼주어야 하기 때문에 -1을 한 itemPosition을 넘겨주게 된다.
            * itemPosition을 그대로 header에 존재하는 TextView에 할당하면 그 다음 항목의 작성자가 할당되기 때문에 -1을 해주어야 된다.
            *
            * */

            AlertDialog alert = dialog.create();
            alert.show();
        }
    };
    public void trans(int cnt){
        this.count = cnt;
        Log.v("1154",String.valueOf(count));
    }
}
