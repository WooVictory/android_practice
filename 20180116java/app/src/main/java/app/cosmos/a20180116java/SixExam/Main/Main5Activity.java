package app.cosmos.a20180116java.SixExam.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import app.cosmos.a20180116java.FontExam.ApplicationController;
import app.cosmos.a20180116java.R;
import app.cosmos.a20180116java.SixExam.Detail.DetailActivity;
import app.cosmos.a20180116java.SixExam.Network.NetworkService;
import app.cosmos.a20180116java.SixExam.Register.RegisterActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main5Activity extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener{
    private ArrayList<MainListData> mDatas;
    private LinearLayoutManager mlinearLayoutManager;
    private RecyclerAdapter recyclerAdapter;
    @BindView(R.id.Six_recyclerView)
    RecyclerView Six_recyclerView;
    @BindView(R.id.addBtn)
    ImageView imageView_addBtn;
    MainListData data;
    NetworkService networkService;
    SwipeRefreshLayout refreshLayout;
    Context context;

    private final long FINISH_INTERVAL_TIME=2000;
    private long backPressedTime=0;
    /* Back 키 두번 클릭 방지 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);

        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.RefreshLayout);
        networkService = ApplicationController.getInstance().getNetworkService();
        // 서비스 객체 초기화

        refreshLayout.setOnRefreshListener(this);
        Six_recyclerView.setHasFixedSize(true);

        // 레이아웃 매니저 초기화
        mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Six_recyclerView.setLayoutManager(mlinearLayoutManager);

        mDatas = new ArrayList<MainListData>();
        // 사용자 정의 데이터를 갖는 배열을 생성


        // 리사이클러뷰와 어답터 연동
        // 매개변수로 ArrayList와 clickEvent를 넘겨준다.
        recyclerAdapter = new RecyclerAdapter(mDatas, clickEvent);
        Six_recyclerView.setAdapter(recyclerAdapter);

        /*FIXME
        onCreate() - 생명주기 내의 통신
        액티비티가 지워지지 않고 재생성 되지 않는 이상 한번만 실행된다.
        이러한 이유로 아래 쪽에 onRestart()를 오버라이드하여 메인 액티비티가 재 실행 되는 경우에
        onRestart() 안에서 리스트를 갱신한다.
        * */
        Call<MainResult> requestMainData = networkService.getMainResult();
        requestMainData.enqueue(new Callback<MainResult>() {
            @Override
            public void onResponse(Call<MainResult> call, Response<MainResult> response) {
                if(response.isSuccessful())
                {
                    mDatas = response.body().results;
                    recyclerAdapter.setAdapter(mDatas);
                }

            }

            @Override
            public void onFailure(Call<MainResult> call, Throwable t) {
                Log.v("Fail",t.getMessage());
            }
        });

    }

    /*FIXME
    리스트 추가 버튼에 대한 이벤트 정의
    * */
    @OnClick(R.id.addBtn)
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.addBtn:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
        }
    }

    /*FIXME
    * 클릭 이벤트 정의
    * 리사이클러뷰의 해당 아이템에 대한 포지션을 가지고 와서
    * 사용자 데이터 중에서 몇번째 아이템에 대한 id를  클릭했는지에 대한
    * 값을 가지고 와서 DetailActivity로 넘어갈 때 값을 같이 넘겨준다.
    * */
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int itemPosition = Six_recyclerView.getChildPosition(view);
            final int tempId = mDatas.get(itemPosition).id;
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("id",String.valueOf(tempId));
            startActivity(intent);
        }
    };


    /*FIXME
    onRestart() 메소드를 오버라이드 하여
    onPause() -> onRestart() 시 리스트를 갱신하는 ListReload() 메소드 호출
    * */
    @Override
    protected void onRestart() {
        super.onRestart();
        ListReload();
    }
    /*FIXME
    리스트를 감싸고 있는 SwipeRefreshLayout을 당기면 갱신되는 메소드이다.
    implements SwipeRefreshLayout.OnRefreshListener 와
    xml에서 리스트를 감싸는 SwipeRefreshLayout 가 필요합니다!!
    * */
    @Override
    public void onRefresh() {
        ListReload();
        refreshLayout.setRefreshing(false);
        Toast.makeText(getApplicationContext(),"페이지 갱신",Toast.LENGTH_SHORT).show();

    }

    /*FIXME
    * 리스트를 갱신하는 메소드
    * 서버와 재통신을 하는 부분이다.
    * */
    public void ListReload()
    {
        Call<MainResult> requestMainData = networkService.getMainResult();
        requestMainData.enqueue(new Callback<MainResult>() {
            @Override
            public void onResponse(Call<MainResult> call, Response<MainResult> response) {
                if(response.isSuccessful())
                {
                    mDatas = response.body().results;
                    recyclerAdapter.setAdapter(mDatas);
                }
            }

            @Override
            public void onFailure(Call<MainResult> call, Throwable t) {
                Log.v("Failure2",t.getMessage());
            }
        });
    }

    /*FIXME
    취소 버튼을 오버라이드
    * */
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        /*
        * Back 키 두번 입력시 앱 종료
        * */
        if(0 <=intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "뒤로 가기 버튼을 한번 더 누르시면 종료됩니다. ", Toast.LENGTH_SHORT).show();
        }

    }
}
