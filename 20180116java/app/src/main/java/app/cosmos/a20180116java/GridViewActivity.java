package app.cosmos.a20180116java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridViewActivity extends AppCompatActivity {

    @BindView(R.id.Grid_add_btn)
    Button Grid_add_btn;
    @BindView(R.id.Grid_editText)
    EditText Grid_editText;
    @BindView(R.id.gridView)
    GridView gridView;
    SingerAdapter singerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        ButterKnife.bind(this);

        singerAdapter = new SingerAdapter();

        singerAdapter.addItem(new SingerItem("정지현","010-5590-0837",22,R.drawable.jung));
        singerAdapter.addItem(new SingerItem("박성준","010-5590-0837",22,R.drawable.park));

        gridView.setAdapter(singerAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SingerItem item = (SingerItem) singerAdapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택:"+item.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


    class SingerAdapter extends BaseAdapter{
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }
        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            SingerItemView singerItemView = new SingerItemView(getApplicationContext());
            SingerItem singerItem = items.get(position);
            singerItemView.setName(singerItem.getName());
            singerItemView.setMobile(singerItem.getMobile());
            singerItemView.setAge(singerItem.getAge());
            singerItemView.setImage(singerItem.getResId());
            return singerItemView;
        }
    }


}
