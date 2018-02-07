package app.cosmos.a20180116java.Three.Custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomListViewActivity extends AppCompatActivity {

    @BindView(R.id.custom_list_view)
    ListView custom_list_view;
    private ArrayList<Itemdata> itemdatas;
    // 사용자가 정의한 Itemdata 클래스 타입의 ArrayList를 선언
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        ButterKnife.bind(this);

        itemdatas = new ArrayList<Itemdata>();
        // 사용자가 정의한 데이터 클래스를 기반으로 ArrayList인 itemdatas 객체를 생성.
        // Itemdata 타입의 객체들이 배열에 담기는 것이다.
        // 예를 들어서 1번 Itemdata, 2번 Itemdata, 3번 Itemdata 등등 이런 형식

        for(int i=1;i<10;i++)
        {
            Itemdata itemdata_storage = new Itemdata();
            // Itemdata 타입의 객체인 itemdata_storage를 만든다.
            if (i % 3 == 0){ // 3,6,9에는 블루 트리
                itemdata_storage.image = R.drawable.bluetree;
            }else if(i % 3 == 1){ // 1,4,7에는 그린 트리
                itemdata_storage.image = R.drawable.greentree;
            }else if(i % 3 == 2){ // 2,5,8에는 레드 트리
                itemdata_storage.image = R.drawable.redtree;
            }
            itemdata_storage.title = i + "번째 타이틀";
            itemdata_storage.content = i + "번째 컨텐트";
            // 그리고 itemdata_storage 객체에 있는 아이템들에 이미지, 타이틀, 컨텐트를 대입한다.
            // 그리고 대입된 itemdata_storage를 ArrayList인 itemDatas에 넣는다.
            // for문이 반복되는 동안 같은 과정 계속해서 반복!
            itemdatas.add(itemdata_storage);
        }

        customAdapter = new CustomAdapter(itemdatas, this);
        // CustomAdapter에 itemdatas를 매개변수로 넘겨주고 호출하고 객체를 생성한다.
        custom_list_view.setAdapter(customAdapter);
        // 반환된 뷰를 여기 있는 custom_list_view에 setAdapter를 통해 연결한다.
        // 여기서는 10개의 데이터에 대해서 하기 때문에 10개의 데이터가 있는 itemdatas가 CustomAdapter에 매개변수로 전달된다.
        // 그래서 CustomAdapter에 getView에 position이라는 변수가 존재!!!!

        custom_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long l) {
                Toast.makeText(getApplicationContext(), (postion+1)+"번 리스트 클릭",Toast.LENGTH_SHORT).show();

            }
        });





    }
}
