package app.cosmos.a20180116java.MenuExam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    @BindView(R.id.my_toolbar)
    Toolbar my_toolbar;
    EditText edit_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        setSupportActionBar(my_toolbar); // 툴바 설정

        // Toolbar의 왼쪽에 버튼을 추가하고 버튼의 아이콘을 바꿈
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        getSupportActionBar().setTitle("");
        // 타이틀명 지우기
    }
    public void showToast(String data)
    {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        View v = menu.findItem(R.id.menu_search).getActionView();
        if(v !=null){
            edit_search = (EditText) v.findViewById(R.id.edit_search);

            if(edit_search !=null){
                edit_search.setOnEditorActionListener(onSearchListener);
            }
        }
        return true;
    }
    private TextView.OnEditorActionListener onSearchListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

            if(keyEvent == null || keyEvent.getAction() == KeyEvent.ACTION_UP){
                search();

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(),0);
            }
            return false;
        }
    };
    public void search()
    {
        String search_text = edit_search.getText().toString();
        Toast.makeText(getApplicationContext(), search_text,Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch (curId)
        {
            case R.id.menu_refresh:
                showToast("새로고침 메뉴가 선택되었습니다. ");
                break;
            case R.id.menu_settings:
                showToast("설정 메뉴가 선택되었습니다. ");
                break;
            case R.id.menu_search:
                showToast("검색 메뉴가 선택되었습니다. ");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
