package app.cosmos.a20180116java.Level3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Level3RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.level3_add_edit)
    EditText level3_add_edit;
    @BindView(R.id.level3_add_btn)
    Button level3_add_btn;
    @BindView(R.id.level3_recycler)
    RecyclerView level3_recycler;
    @BindView(R.id.level3_search_edit)
    EditText level3_search_edit;
    @BindView(R.id.level3_previous_btn)
    Button previous_btn;
    @BindView(R.id.level3_next_btn)
    Button next_btn;
    @BindView(R.id.select_image_num)
    TextView select_image_num;
    private ArrayList<Level3_itemData> level3_itemDatas;
    private Level3Adapter level3Adapter;
    private LinearLayoutManager layoutManager;
    int count=1;
    int imageId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3_recycler);
        ButterKnife.bind(this);

        level3_recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        level3_recycler.setLayoutManager(layoutManager);

        level3_itemDatas = new ArrayList<Level3_itemData>();
        level3_itemDatas.add(new Level3_itemData(R.drawable.redtree,"1번"));
        level3_itemDatas.add(new Level3_itemData(R.drawable.bluetree,"2번"));
        level3_itemDatas.add(new Level3_itemData(R.drawable.greentree,"3번"));
        // 사전에 데이터를 3개 집어넣음

        level3Adapter = new Level3Adapter(level3_itemDatas,clickEvent);
        level3_recycler.setAdapter(level3Adapter);

        level3_search_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 입력되기 전에

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 변경되는 동안에

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 입력이 된 후에
                String text = level3_search_edit.getText().toString().toLowerCase();
                level3Adapter.filter(text);
                // 입력받은 text를 level3Adapter에 있는 filter함수에 넣어준다.
                //level3Adapter.refreshAdapter(level3_itemDatas);


            }
        });

    }

    @OnClick({R.id.level3_next_btn,R.id.level3_previous_btn,R.id.level3_search_edit,R.id.level3_add_btn})
    void click(View view)
    {
        switch (view.getId())
        {
            case R.id.level3_previous_btn :
                if(count>0) // count가 계속 감소하는 것을 방지
                    count--;
                select_image_num.setText(count+"");
                changeImage(count);
                break;
            case R.id.level3_next_btn :
                if(count<2) // count가 계속 증가하는 것을 방지
                    count++;
                select_image_num.setText(count+"");
                changeImage(count);
                //Log.v("535",String.valueOf(count));
                break;
            case R.id.level3_add_btn :
                if(level3_add_edit.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "추가할 제목을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }else {
                    level3_itemDatas.add(new Level3_itemData(imageId, level3_add_edit.getText().toString()));
                    level3_add_edit.setText("");
                    update();
                }
                break;
        }
    }

    public void changeImage(int count)
    {
        switch (count)
        {
            case 0 :
                imageId = R.drawable.redtree;
                break;
            case 1 :
                imageId = R.drawable.bluetree;
                break;
            case 2 :
                imageId = R.drawable.greentree;
                break;
        }

    }
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int itemPosition = level3_recycler.getChildPosition(view);
            final AlertDialog.Builder dialog = new AlertDialog.Builder(Level3RecyclerActivity.this);
            dialog.setMessage("해당 항목을 삭제하시겠습니까?");
            dialog.setCancelable(true);
            dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    level3_itemDatas.remove(itemPosition);
                    update();
                    // 삭제하고 나서 update를 해주지 않으면
                    // 돌아갔을 때도 삭제한 데이터가 남아있어서
                    // update 함수를 호출해서 갱신해주어야 한다.

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
        }
    };
    public void update()
    {
        level3Adapter = new Level3Adapter(level3_itemDatas, clickEvent);
        level3_recycler.setAdapter(level3Adapter);
        level3Adapter.notifyDataSetChanged();
        // 실시간으로 리사이클러뷰의 내용을 추가, 변경해야하는 경우 유용하게 사용 가능하다.
        // ViewHolder를 사용할 경우 더욱 유용하다.
    }
    /*FIXME
    추가, 검색 이벤트 처리 후에 어댑터를 새로 생성하는 이유는
    onCreate에서 선언된 어댑터 객체에 인자로 전달된 itemData가 항목이 추가된 후 갱신된
    itemData가 아니라 초기의 itemData이기 때문이다.
    * */
}
