package app.cosmos.a20180116java.EightExam;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-02-18.
 */

public class eight_HeaderViewHolder extends RecyclerView.ViewHolder {
    /*FIXME
    * eight_recyclerview_header에 존재하는 TextView의 id를 가져와서 객체화시킨다.
    * */
    public static TextView header_text;
    public eight_HeaderViewHolder(View itemView) {
        super(itemView);

        header_text = (TextView) itemView.findViewById(R.id.header_text);
        /*FIXME
        * eight_recyclerAdapter에 있는 onCreateViewHolder에서 이 클래스를 호출하면서 eight_recyclerview_header.xml을 객체화한 header_view를 넘겨주었다.
        * 그리고 여기서는 eight_recyclerview_header에 존재하는 뷰들의 id를 가져오면서 객체화해서 가지고 있는다.
        * View들을 재활용하기 위해서 ViewHolder를 사용한다.
        * */

    }
}
