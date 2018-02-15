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
    }
}

