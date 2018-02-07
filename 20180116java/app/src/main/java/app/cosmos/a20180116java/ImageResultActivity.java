package app.cosmos.a20180116java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageResultActivity extends AppCompatActivity {

    @BindView(R.id.result_image)
    ImageView result_image;
    @BindView(R.id.result_text)
    TextView result_text;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_result);
        ButterKnife.bind(this);
        Intent getData = getIntent();
        count = getData.getExtras().getInt("select img");
        switch (count)
        {
            case 0 :
                result_image.setImageResource(R.drawable.redtree);
                break;
            case 1 :
                result_image.setImageResource(R.drawable.bluetree);
                break;
            case 2 :
                result_image.setImageResource(R.drawable.greentree);
                break;
        }

        String id = getData.getExtras().getString("id");
        String pwd = getData.getExtras().getString("pwd");
        String name = getData.getExtras().getString("name");
        String major = getData.getExtras().getString("major");
        String part = getData.getExtras().getString("part");
        String gender = getData.getExtras().getString("gender");
        int select_img = getData.getExtras().getInt("select img");
        String result = id + "\n" + pwd + "\n" + name + "\n" + major + "\n" + part + "\n" + gender;

        result_text.setText(result);

    }
}
