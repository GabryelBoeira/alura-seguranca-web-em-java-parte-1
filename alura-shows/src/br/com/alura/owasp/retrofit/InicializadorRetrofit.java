package br.com.alura.owasp.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class InicializadorRetrofit {

    private static final String BASE_URL = "https://www.google.com/recaptcha/api/";
    private static final Log log = LogFactory.getLog(InicializadorRetrofit.class);
    private static Retrofit retrofit;

    public InicializadorRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    /**
     * Returns an instance of the GoogleService class created using the Retrofit library.
     *
     * @return an instance of the GoogleService class
     */
    public GoogleService getGoogleService() {
        return retrofit.create(GoogleService.class);
    }

}
