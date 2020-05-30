package hse.projectx.petdonate_api.sberbank;

import lombok.Data;

@Data
public class PaymentData {
    private String merchant;
    private String orderNumber;
    private String language = "RU";
    private String description;
    private AdditionalParameters additionalParameters;
    private String paymentToken;
    private String ip;
    private String amount;
    private int currencyCode = 643;
    private String returnUrl;
}

class AdditionalParameters
{

}
