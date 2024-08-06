package br.com.alura.owasp.retrofit;

import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class InicializadorRetrofit {

    private static final String BASE_URL = "https://www.google.com/recaptcha/api";
    private static Retrofit retrofit;

    public InicializadorRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public GoogleService getGoogleService() {
        return retrofit.create(GoogleService.class);
    }

}
