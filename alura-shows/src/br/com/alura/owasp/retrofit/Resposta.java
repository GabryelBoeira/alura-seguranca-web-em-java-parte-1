package br.com.alura.owasp.retrofit;

import java.io.Serializable;
import java.util.List;


public class Resposta implements Serializable {

    private static final long serialVersionUID = 5768458682061548334L;

    private boolean success;
    private String hostname; ;
    private String challenge_ts;
    private List<String> errorCodes;

    public Resposta() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getChallenge_ts() {
        return challenge_ts;
    }

    public void setChallenge_ts(String challenge_ts) {
        this.challenge_ts = challenge_ts;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
}
