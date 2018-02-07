package app.cosmos.a20180116java.SixExam.Network;

import app.cosmos.a20180116java.SixExam.Detail.DetailResult;
import app.cosmos.a20180116java.SixExam.Main.MainResult;
import app.cosmos.a20180116java.SixExam.Register.RegisterResult;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by sec on 2018-01-26.
 */

public interface NetworkService {

    /*FIXME
    *GET : 주로 정보를 요청하기 위해서 사용
    *POST : 서버에 정보를 저장하기 위해서 사용
    *PUT : 정보를 업데이트하기 위해서 사용
    *DELETE : 정보를 삭제하기 위해서 사용
    **/
    @GET("/")
    Call<MainResult> getMainResult();
    // getMainResult()라는 함수를 호출하고
    // 서버로부터 정보(응답)를(을) 받을 때는 Call을 호출하고 MainResult 형태로 받겠다.

    @GET("/{id}")
    Call<DetailResult> getDetailResult(@Path("id") String id);

    @Multipart
    @POST("/")
    Call<RegisterResult> registerImageNotice(@Part MultipartBody.Part file,
                                             @Part("username")RequestBody writer,
                                             @Part("title")RequestBody title,
                                             @Part("content")RequestBody contents);


}
