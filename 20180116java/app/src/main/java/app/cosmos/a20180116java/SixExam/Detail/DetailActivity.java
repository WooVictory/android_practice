package app.cosmos.a20180116java.SixExam.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

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
    @BindView(R.id.commentBtn)
    Button commentBtn;
    @BindView(R.id.comment_writer_edit)
    EditText comment_writer_edit;
    @BindView(R.id.comment_content_edit)
    EditText comment_content_edit;
    @BindView(R.id.recyclerView_comment)
    RecyclerView recyclerView_comment;
    private String id;
    private NetworkService networkService;
    private Comment_RecyclerAdapter comment_recyclerAdapter;
    private ArrayList<DetailResult.CommentData> commentDatas;
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

    @OnClick({R.id.closeBtn,R.id.commentBtn})
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.closeBtn:
                finish();
                break;
            case R.id.commentBtn:
                /*FIXME
                * 댓글을 작성하는 부분에 대한 통신이다.
                * */
                final CommentInfo commentInfo = new CommentInfo(); // POST로 넘길 객체
                commentInfo.writer = comment_writer_edit.getText().toString(); // 작성자를 가져온다.
                commentInfo.content = comment_content_edit.getText().toString(); // 내용을 가져온다.
                if(commentInfo.writer.length() == 0 || commentInfo.content.length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "댓글 작성자 혹은 내용을 입력해주세요.",Toast.LENGTH_LONG).show();
                }else {
                    Call<CommentResult> commentResultCall = networkService.getCommentResult(id, commentInfo);
                    // POST로 Main에서 넘어온 id와 commentInfo 객체를 넘겨준다.
                    // commentInfo 객체에는 writer와 content 정보가 담겨있다.
                    commentResultCall.enqueue(new Callback<CommentResult>() {
                        @Override
                        public void onResponse(Call<CommentResult> call, Response<CommentResult> response) {
                            if(response.isSuccessful())
                            {

                                if (response.body().message.equals("ok")) {
                                    Toast.makeText(getApplicationContext(),"댓글 등록 성공",Toast.LENGTH_LONG).show();
                                    comment_writer_edit.setText("");
                                    comment_content_edit.setText("");
                                    // 빈칸으로 만들어준다.
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<CommentResult> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"댓글 등록 실패! err message : "+t.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    });
                }
                break;
        }
    }

    public void Networking()
    {
        final Call<DetailResult> requestDetail = networkService.getDetailResult(id);
        // Main 액티비티에서 넘어 온 id 값을 서버로 넘겨서 통신을 진행한다.
        // 받을 때는 DetailResult 타입의 형태로 받겠다는 것!!!
        requestDetail.enqueue(new Callback<DetailResult>() {
            @Override
            public void onResponse(Call<DetailResult> call, Response<DetailResult> response) {
                if(response.isSuccessful())
                {
                    titleTextView.setText("제목 :"+response.body().result.post.title); // 댓글 제목
                    writerTextView.setText(response.body().result.post.username); // 댓글 작성자
                    contentTextView.setText("내용 :"+response.body().result.post.content); // 댓글 내용
                    /*FIXME
                    값들을 받아서 텍스트뷰에 뿌려준다.
                    그리고 서버에서 받아온 이미지가 null이 아니면 즉, 값이 존재하면
                    Glide를 통해서 이미지를 imgView에 넣어준다.
                    * */

                    if(response.body().result.post.image !="")
                    {
                        Glide.with(getApplicationContext())
                                .load(response.body().result.post.image)
                                .into(imgView);
                    }
                    /*FIXME
                    * 이 부분에 댓글을 뿌려줘야 한다.
                    * 그리고 리사이클러뷰에 들어갈 item_list를 작성할 때 통신할 때 서버의 API 부분과 맞추도록
                    * 노력해야 한다. 왜냐하면 나중에 서버에서 받아서 값을 리사이클러뷰에 뿌릴 때
                    * 똑같아으면 그대로 받아서 바로 뿌리면 되기 때문이다. 주의####!!!!!****
                    * */

                    commentDatas = response.body().result.comment;
                    comment_recyclerAdapter.setAdapter(commentDatas);

                }
            }

            @Override
            public void onFailure(Call<DetailResult> call, Throwable t) {
                Log.v("Failure3",t.getMessage());
            }
        });
    }
}
