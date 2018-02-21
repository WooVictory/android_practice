package app.cosmos.a20180116java.EightExam;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sec on 2018-02-18.
 */

public class eight_FooterViewHolder extends RecyclerView.ViewHolder{
    /*FIXME
    eight_recyclerview_footer에 있는 뷰들의 id를 가지고 와서 객체화시킨다.
    ViewHolder는 res 폴더에 존재하는 View에서 id를 가지고 와서 보관할 수 있다.
    그래서 객체화시켜서 view들한테 접근할 수 있도록 해준다.
    * */
    @BindView(R.id.eight_comment_writer_edit)
    EditText writer_edit;
    @BindView(R.id.eight_comment_content_edit)
    EditText content_edit;
    @BindView(R.id.eight_commentBtn)
    Button eight_commentBtn;
    public eight_FooterViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);


        writer_edit = (EditText) itemView.findViewById(R.id.eight_comment_writer_edit); // 작성자 이름
        content_edit = (EditText) itemView.findViewById(R.id.eight_comment_content_edit); // 댓글 내용
        eight_commentBtn = (Button) itemView.findViewById(R.id.eight_commentBtn); // 등록 버튼

    }
    @OnClick(R.id.eight_commentBtn)
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.eight_commentBtn:

        }
    }
}
