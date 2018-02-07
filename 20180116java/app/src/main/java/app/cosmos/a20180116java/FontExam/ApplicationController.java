package app.cosmos.a20180116java.FontExam;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

import app.cosmos.a20180116java.SixExam.Network.NetworkService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sec on 2018-01-26.
 */

public class ApplicationController extends Application {

    private static ApplicationController instance;
    // 먼저 어플리케이션컨트롤러 인스턴스 객체를 하나 선언
    private static String baseUrl = "http://52.78.120.216:3000";
    // 베이스 url 초기화
    private NetworkService networkService;
    // 네트워크 서비스 객체 선언

    public static ApplicationController getInstance() {
        return instance;
    }
    // 인스턴스 객체 반환
    // 왜 static 인가?
    // 안드로이드에서 static 으로 선언된 변수는 매번 객체를 새로 생성하지 않아도 다른 액티비티에서
    // 자유롭게 사용 가능합니다.

    public NetworkService getNetworkService() {
        return networkService;
    }
    // 네트워크서비스 객체 반환


    @Override
    public void onCreate() {
        super.onCreate();

        // 폰트 적용
        Typekit.getInstance()
                .add("Normal",Typekit.createFromAsset(this,"NanumBarunGothicBold.ttf"))
                .add("Bold",Typekit.createFromAsset(this, "NanumBarunGothic.ttf"))
                .add("Custom1",Typekit.createFromAsset(this,"NanumMyeongjo.ttc"))
                .add("Custom2",Typekit.createFromAsset(this,"NanumMyeongjoExtraBold.ttf"));

        ApplicationController.instance = this;
        //인스턴스 객체 초기화
        buildService();
    }

    public void buildService() {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // baseUrl에 할당된 주소로 연결하고
        // GsonConverter를 통해서 Json 형식의 데이터를 사용할 수 있게끔 GsonConverterFactory를 추가해서 사용한다.
        // 그리고 build()로 마무리
        networkService = retrofit.create(NetworkService.class);
        // NetworkSerice를 기반으로 하는 retrofit을 만들고
        // 위에서 생성한 NetworkService 객체를 초기화한다.
    }
}
