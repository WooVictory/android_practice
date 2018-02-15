package app.cosmos.a20180116java.SixExam.Detail;

import java.util.ArrayList;

/**
 * Created by sec on 2018-01-26.
 */

public class DetailResult {
    public ResultData result;
    public String message;

    public class ResultData{
        public DetailData post;
        public ArrayList<CommentData> comment;

    }

    class DetailData{
        public int id;
        public String username;
        public String title;
        public String image;
        public String content;
    }
    class CommentData{
        public String writer;
        public String written_time;
        public String content;
        // 통신할 때 사용하고, 리사이클러뷰에 데이터를 뿌릴 때도 사용한다.
        // 통신할 때 사용하는 데이터 클래스와 리사이클러뷰에 포함될 item_list의 데이터 클래스는 같아야 한다.
        // 그래야 통신할 때 편함.

    }
}

