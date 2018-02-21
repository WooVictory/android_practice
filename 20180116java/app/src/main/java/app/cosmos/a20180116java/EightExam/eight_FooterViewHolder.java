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
    @BindView(R.id.eight_comment_writer_edit)
    EditText writer_edit;
    @BindView(R.id.eight_comment_content_edit)
    EditText content_edit;
    @BindView(R.id.eight_commentBtn)
    Button eight_commentBtn;
    public eight_FooterViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        writer_edit = (EditText) itemView.findViewById(R.id.eight_comment_writer_edit);
        content_edit = (EditText) itemView.findViewById(R.id.eight_comment_content_edit);
        eight_commentBtn = (Button) itemView.findViewById(R.id.eight_commentBtn);

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
