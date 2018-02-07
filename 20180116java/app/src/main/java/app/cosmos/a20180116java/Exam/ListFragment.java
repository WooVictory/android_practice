package app.cosmos.a20180116java.Exam;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import app.cosmos.a20180116java.R;

/**
 * Created by sec on 2018-01-25.
 */

public class ListFragment extends Fragment {
    String[] values = {"첫 번째 이미지","두 번째 이미지","세 번째 이미지"};

    public static interface ImageSelectionCallback {
        public void onImageSelected(int position);
    }
    public ImageSelectionCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof ImageSelectionCallback){
            callback = (ImageSelectionCallback) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list,container,false);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
        /*FIXME
        화면에 추가된 리스트뷰에 세 개의 데이터를 보여주려 하는데 이 데이터를 넣어 리스트뷰에 보여줄 수 있는
        가장 간단한 방법이 ArrayAdapter를 사용하는 것이다.
        ArrayAdapter를 리스트뷰의 setAdapter() 메소드로 설정하면 그 안에 들어 있는 각각의 데이터가 리스트뷰의 각 줄에 보이게 된다.
        * */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(callback !=null){
                    callback.onImageSelected(position);
                }
            }
        });
        return rootView;
    }
}
/*FIXME
리스트뷰의 한 아이템을 선택했을 때 어떤 아이템을 선택했는지 알아낸 후 처리하고 싶다면 이 메소드를 사용하면 된다.
여기에서 선택된 값으로 다른 프래그먼트의 이미지를 바꿔주면 액티비티 쪽으로 데이터를 전달해야 하므로 액티비티에 onImageSelected 메소드를 정의한 후
그 메소드를 호출하도록 한다.
그런데 매번 액티비티마다 다른 이름의 메소드를 만들면 프래그먼트가 올라간 액티비티가 다른 액티비티로 변경되었을 때
해당 액티비티가 무엇인지 매번 확인해야 하는 번거로움이 있다. 이 때문에 인터페이스를 하나 정의한 후 액티비티가 이 인터페이스를
구현하도록 하는 것이 좋다.
* */