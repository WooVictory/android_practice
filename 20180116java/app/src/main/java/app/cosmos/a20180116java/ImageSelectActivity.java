package app.cosmos.a20180116java;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageSelectActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_select);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.previous_btn, R.id.next_btn, R.id.image_sign_btn})
    void Click(View view)
    {
        switch (view.getId())
        {
            case R.id.previous_btn:
                if(count>0)
                    count--;
                changeImage(count);
                break;
            case R.id.next_btn:
                if(count<2)
                    count++;
                changeImage(count);
                break;
            case R.id.image_sign_btn:
                final AlertDialog.Builder dialog = new AlertDialog.Builder(ImageSelectActivity.this);
                dialog.setTitle("Message");
                dialog.setMessage("회원 가입을 하시겠습니까?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                        intent.putExtra("select img",count);
                        startActivity(intent);
                        finish();
                    }
                });

                dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        return;
                    }
                });

                AlertDialog alert = dialog.create();
                alert.show();
                break;
        }
    }

    public void changeImage(int count)
    {
        switch (count)
        {
            case 0:
                imageView.setImageResource(R.drawable.redtree);
                break;
            case 1:
                imageView.setImageResource(R.drawable.bluetree);
                break;
            case 2:
                imageView.setImageResource(R.drawable.greentree);
                break;
        }
    }
}
