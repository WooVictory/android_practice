package app.cosmos.a20180116java.EightExam;

import android.os.Bundle;
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

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        eight_recyclerView.setLayoutManager(linearLayoutManager);

        eight_recyclerView.setHasFixedSize(true);

        eight_recyclerView_itemDatas = new ArrayList<eight_recyclerView_ItemData>();
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
            if(itemPosition == 0)
            {
                eight_recyclerAdapter.showToast("헤더입니다.");
            }else if(itemPosition != eight_recyclerView_itemDatas.size()+2){
                eight_recyclerAdapter.showToast(itemPosition+"번 댓글입니다.");
                String temp_header = eight_recyclerAdapter.eight_recyclerView_itemDatas.get(itemPosition-1).writer;
                eight_HeaderViewHolder.header_text.setText(temp_header);
            }
        }
    };
    public void trans(int cnt){
        this.count = cnt;
        Log.v("1154",String.valueOf(count));
    }
}
