package app.cosmos.a20180116java.Three.Recycler;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    // 여기서 SwipeRefreshLayout.OnRefreshListener를 implements하고 Refresh() 메소드를 오버라이드 하면된다.
    // 그리고 onCreate() 안에서 SwipeRefreshLayout에 리스너를 달아주면 된다.


    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.refresh_recycler)
    SwipeRefreshLayout refresh_recycler;
    private ArrayList<Itemdata_recycler> itemDatas_recycler; // 사용자 정의 데이터 클래스
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        recycler_view.setHasFixedSize(true); // 사이즈를 고정
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        // 리니어 레이아웃 매니저 객체를 생성하고 수직방향으로 설정한 뒤
        recycler_view.setLayoutManager(layoutManager);
        // 리사이클러뷰에 레이아웃 매니저를 set함

        itemDatas_recycler = new ArrayList<Itemdata_recycler>(); // 사용자 정의 데이터를 갖는 ArrayList를 만듦
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.redtree,"1","이승우"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.greentree,"2","박성준"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.bluetree,"3","김준영"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.redtree,"4","정지현"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.greentree,"5","노준호"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.bluetree,"6","최서정"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.redtree,"7","임수정"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.greentree,"8","조희"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.bluetree,"9","이승수"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.redtree,"10","김유진"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.greentree,"11","서지영"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.bluetree,"12","신태영"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.redtree,"13","고성혁"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.greentree,"14","김현우"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.bluetree,"15","안가현"));
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.redtree,"16","조예원"));


        recyclerAdapter = new RecyclerAdapter(itemDatas_recycler, clickEvent);
        // RecyclerAdapter에 itemDatas_recycler와 clickEvent를 넘겨준다.
        recycler_view.setAdapter(recyclerAdapter);
        // setAdapter를 통해서 리사이클러뷰 완성

        // refresh_recycler에 리스너를 달아준다.
        refresh_recycler.setOnRefreshListener(this);
        refresh_recycler.setColorSchemeResources(R.color.colorAccent);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),new LinearLayoutManager(this).getOrientation());
        recycler_view.addItemDecoration(new VerticalSpaceItemDecoration(48));

    }

    public View.OnClickListener clickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int position = recycler_view.getChildPosition(view);
            final AlertDialog.Builder dialog = new AlertDialog.Builder(RecyclerViewActivity.this);
            dialog.setMessage("해당 항목을 삭제하시겠습니까?");
            dialog.setCancelable(true);
            dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    itemDatas_recycler.remove(position);
                    recyclerAdapter.notifyDataSetChanged();
                }
            });

            dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), (position+1) + "번 리스트", Toast.LENGTH_SHORT).show();

                }
            });
            AlertDialog alert = dialog.create();
            alert.show();
        }
    };

    @Override
    public void onRefresh() {
        itemDatas_recycler.add(new Itemdata_recycler(R.drawable.greentree,"17","쿠티뉴"));
        recyclerAdapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(),"추가",Toast.LENGTH_SHORT).show();
        refresh_recycler.setRefreshing(false);
    }
}