package app.cosmos.a20180116java;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sec on 2018-02-04.
 */

public class SingerItemView extends LinearLayout {
    @BindView(R.id.singer_text)
    TextView singer_text;
    @BindView(R.id.singer_text2)
    TextView singer_text2;
    @BindView(R.id.singer_text3)
    TextView singer_text3;
    @BindView(R.id.singer_image)
    ImageView singer_image;

    public SingerItemView(Context context)
    {
        super(context);
        init(context);
    }
    public SingerItemView(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        init(context);
    }

    public void init(Context context)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item,this,true);
        ButterKnife.bind(this);
    }

    public void setName(String name) {
        singer_text.setText(name); // 이름
    }

    public void setMobile(String mobile) {
        singer_text2.setText(mobile);
    }

    public void setAge(int age) {
        singer_text3.setText(String.valueOf(age));
    }

    public void setImage(int resId) {
        singer_image.setImageResource(resId);
    }

    public TextView getSinger_text() {
        return singer_text;
    }

    public TextView getSinger_text2() {
        return singer_text2;
    }

    public TextView getSinger_text3() {
        return singer_text3;
    }

    public ImageView getSinger_image() {
        return singer_image;
    }
}
