package Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("post_user.php")
    Call<ResponseBody> putUSer(@Field("user") String user ,@Field("pass") String pass,
                               @Field("address") String address ,@Field("phone") String phone);
    @FormUrlEncoded
    @POST("post_user.php")
    Call<ResponseBody> checkUser(@Field("user") String user );

}
