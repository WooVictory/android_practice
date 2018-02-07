package app.cosmos.a20180116java.Three;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BasicListViewActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView list_view;
    @BindView(R.id.list_text)
    TextView list_text;
    @BindView(R.id.refresh_list)
    SwipeRefreshLayout refresh_list;
    private ArrayList<String> itemData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);
        ButterKnife.bind(this);

        itemData = new ArrayList<String>();
        // layout의 xml 파일에 있는 ListView를 이용해야 함
        // 그리고 Adapter를 생성하여 이 ListView와 연결시켜야 하는데
        // Adapter는 한마디로 리스트 객체와 ListView의 연결고리라고 생각하면 쉽다.
        // 리스트 객체 안에 저장된 데이터들을 우리가 볼 수 있게 ListView로 뿌려주는 역할을 한다.
        // Adapter의 종류는 기본적으로 세가지 정도가 있는데, 가장 간단한 ArrayAdapter를 사용한다.

        itemData.add("list_data_1");
        itemData.add("list_data_2");
        itemData.add("list_data_3");
        itemData.add("list_data_4");
        itemData.add("list_data_5");
        itemData.add("list_data_6");
        itemData.add("list_data_7");
        itemData.add("list_data_8");
        itemData.add("list_data_9");
        itemData.add("list_data_10");
        itemData.add("list_data_11");
        itemData.add("list_data_12");
        itemData.add("list_data_13");
        itemData.add("list_data_14");
        itemData.add("list_data_15");
        itemData.add("list_data_16");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemData);
        // android.R.layout.simple_list_item_1는 리스트의 한 항목당 한 줄의 text만을 표시하는 layout이다.
        list_view.setAdapter(adapter);


        refresh_list.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                itemData.add("list_data_17");
                Toast.makeText(getApplicationContext(),"추가",Toast.LENGTH_SHORT).show();
                refresh_list.setRefreshing(false);
            }
        });


        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {   // 해당 아이템을 클릭했을 때의 이벤트를 처리할 수 있는 함수
            // 포지션 값을 가져 올 수 있어서 유용함
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                list_text.setText(position+1+"번 데이터");
                Toast.makeText(getApplicationContext(), (position+1) + "번 리스트 클릭!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
