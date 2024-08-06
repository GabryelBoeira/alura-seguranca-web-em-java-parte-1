package br.com.alura.owasp.retrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

@Service
public class GoogleWebClient {

    private static final String SECRET = "6LflbCAqAAAAAP6iuR_UI5pPM2MWDFr9ePg8b7FA";

    @Autowired
    private InicializadorRetrofit retrofit;

    /**
     * Validates the reCAPTCHA response for the given secret and response.
     *
     * @param  gRecaptchaResponse the response from the reCAPTCHA widget
     */
    public boolean validaCaptcha(String gRecaptchaResponse) throws IOException {
        Call<Resposta> call = retrofit.getGoogleService().verificaCaptcha(SECRET, gRecaptchaResponse);

        return call.execute().body().isSuccess();
    }

}
