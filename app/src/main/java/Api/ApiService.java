package Api;

import java.util.List;

import Model.User;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {


    @GET("get_img.php")
    Call<List<String>> getImg();
    @Multipart
    @POST("post_img.php")
    Call<ResponseBody> putImg(@Part MultipartBody.Part avatar);
    @FormUrlEncoded
    @POST("post_user.php")
    Call<ResponseBody> postUser(@Field("user") String user,@Field("pass") String pass,@Field("old") int old,
                                @Field("address") String address,@Field("phone") String phone ,@Field("img") String img);
    @FormUrlEncoded
    @POST("get_user.php")
    Call<User> getUser(@Field("user1") String user, @Field("pass1") String pass);
}
