package hse.projectx.petdonate_api.google;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;



//// These six fields are included in all Google ID Tokens.
// "iss": "https://accounts.google.com",
//         "sub": "110169484474386276334",
//         "azp": "1008719970978-hb24n2dstb40o45d4feuo2ukqmcc6381.apps.googleusercontent.com",
//         "aud": "1008719970978-hb24n2dstb40o45d4feuo2ukqmcc6381.apps.googleusercontent.com",
//         "iat": "1433978353",
//         "exp": "1433981953",
//
//         // These seven fields are only included when the user has granted the "profile" and
//         // "email" OAuth scopes to the application.
//         "email": "testuser@gmail.com",
//         "email_verified": "true",
//         "name" : "Test User",
//         "picture": "https://lh4.googleusercontent.com/-kYgzyAWpZzJ/ABCDEFGHI/AAAJKLMNOP/tIXL9Ir44LE/s99-c/photo.jpg",
//         "given_name": "Test",
//         "family_name": "User",
//         "locale": "en"
public class GoogleAuthenticator {

    private final NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
    private final JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();
    private final String CLIENT_ID = "1010110510479-p2r12ubpf0e17gh4vjajvr95vmj98d63.apps.googleusercontent.com";
    private GoogleIdToken.Payload payload;

    private GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            // Specify the CLIENT_ID of the app that accesses the backend:
            .setAudience(Collections.singletonList(CLIENT_ID))
            // Or, if multiple clients access the backend:
            //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
            .build();

    public GoogleAuthenticator(String token) throws GeneralSecurityException, IOException {

        GoogleIdToken idToken = verifier.verify(token);
        if (idToken != null)
        {
            payload = idToken.getPayload();
        }
    }

    public GoogleIdToken.Payload getPayload() {
        return payload;
    }
}
