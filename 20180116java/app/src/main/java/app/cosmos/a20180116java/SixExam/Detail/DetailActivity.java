package app.cosmos.a20180116java.SixExam.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import app.cosmos.a20180116java.FontExam.ApplicationController;
import app.cosmos.a20180116java.R;
import app.cosmos.a20180116java.SixExam.Network.NetworkService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.titleTextview)
    TextView titleTextView;
    @BindView(R.id.writerTextview)
    TextView writerTextView;
    @BindView(R.id.contentTextview)
    TextView contentTextView;
    @BindView(R.id.imgView)
    public ImageView imgView;
    @BindView(R.id.closeBtn)
    public Button closeBtn;
    private String id;
    private NetworkService networkService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        networkService = ApplicationController.getInstance().getNetworkService();
        // 네트워크 서비스 초기화 꼭 필요한 작업임!!

        // 넘어 온 아이디값 전달 받기
        Intent intent = getIntent();
        id = intent.getExtras().getString("id");

        Networking();
        // 통신을 진행하는 함수

    }

    @OnClick(R.id.closeBtn)
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.closeBtn:
                finish();
                break;
        }
    }

    public void Networking()
    {
        Call<DetailResult> requestDetail = networkService.getDetailResult(id);
        // Main 액티비티에서 넘어 온 id 값을 서버로 넘겨서 통신을 진행한다.
        // 받을 때는 DetailResult 타입의 형태로 받겠다는 것!!!
        requestDetail.enqueue(new Callback<DetailResult>() {
            @Override
            public void onResponse(Call<DetailResult> call, Response<DetailResult> response) {
                if(response.isSuccessful())
                {
                    titleTextView.setText("제목 :"+response.body().result.title);
                    writerTextView.setText(response.body().result.username);
                    contentTextView.setText("내용 :"+response.body().result.content);
                    /*FIXME
                    값들을 받아서 텍스트뷰에 뿌려준다.
                    그리고 서버에서 받아온 이미지가 null이 아니면 즉, 값이 존재하면
                    Glide를 통해서 이미지를 imgView에 넣어준다.
                    * */

                    if(response.body().result.image !="")
                    {
                        Glide.with(getApplicationContext())
                                .load(response.body().result.image)
                                .into(imgView);
                    }
                }
            }

            @Override
            public void onFailure(Call<DetailResult> call, Throwable t) {
                Log.v("Failure3",t.getMessage());
            }
        });
    }
}
