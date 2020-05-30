package hse.projectx.petdonate_api.sberbank;

//docs
//https://securepayments.sberbank.ru/wiki/doku.php/integration:api:rest:requests:payment_googlepay
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class PaymentProcess {
    PaymentData data = new PaymentData();

    Response post() throws IOException {
        JSONObject json = new JSONObject(data);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json.toString());
        Request request = new Request.Builder()
                .url("https://3dsec.sberbank.ru/payment/google/payment.do")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        return client.newCall(request).execute();
    }
}
