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

    @GET("/")
    Call<MainResult> getMainResult();

    @GET("/{id}")
    Call<DetailResult> getDetailResult(@Path("id") String id);

    @Multipart
    @POST("/")
    Call<RegisterResult> registerImageNotice(@Part MultipartBody.Part file,
                                             @Part("username")RequestBody writer,
                                             @Part("title")RequestBody title,
                                             @Part("content")RequestBody contents);


}
