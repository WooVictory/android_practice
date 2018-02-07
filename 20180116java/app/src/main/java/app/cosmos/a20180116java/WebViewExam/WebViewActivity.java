package app.cosmos.a20180116java.WebViewExam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import app.cosmos.a20180116java.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.urlInput)
    EditText urlInput;
    @BindView(R.id.loadBtn)
    Button loadBtn;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        /*FIXME
        웹뷰의 설정 정보는 WebSettings 객체에 들어있다.
        * */
        WebSettings webSettings = webView.getSettings(); // 웹뷰에 WebSettings 설정
        webSettings.setJavaScriptEnabled(true); // 웹뷰에 자바스크립트 허용, 자바스크립트가 동작할 수 있는 환경이 됨.

        webView.setWebChromeClient(new WebBrowserClient());
        webView.addJavascriptInterface(new JavaScriptMethods(),"sample");
        webView.loadUrl("file://android_assets/www/sample.html");
        // 이 부분을 보면 로컬에 저장된 파일을 읽어 들이라는 것을 알 수 있다.
        // 그 뒤의 android_asset은 프로젝트의 /assets 폴더에 추가된 것을 의미한다.

    }
    @OnClick(R.id.loadBtn)
    void click(View view){
        switch (view.getId()){
            case R.id.loadBtn:
                webView.loadUrl(urlInput.getText().toString());
                break;
        }
    }
    final class JavaScriptMethods {
        JavaScriptMethods() {

        }

        @android.webkit.JavascriptInterface
        public void clickOnFace() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    loadBtn.setText("클릭 후 열기");
                    webView.loadUrl("javascript:changeFace()");
                    // 이 부분이 자바스크립트로 된 changeFace() 함수를 호출하는 부분
                }
            });
        }
    }

    final class WebBrowserClient extends WebChromeClient {
        public boolean onJsAlert(WebView view, String url, String message, JsResult result){
            result.confirm();
            return true;
        }
    }
}
