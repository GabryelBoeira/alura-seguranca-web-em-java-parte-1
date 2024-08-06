package br.com.alura.owasp.retrofit;

import retrofit2.Retrofit;

public class InicializadorRetrofit {

    private static final String BASE_URL = "https://www.google.com/recaptcha/api";
    private static Retrofit retrofit;

    public InicializadorRetrofit() {

        String a = "6LflbCAqAAAAAP6iuR_UI5pPM2MWDFr9ePg8b7FA";

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)

                .build();
    }


}
