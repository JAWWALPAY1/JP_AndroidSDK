package com.example.android_sdk_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidsdk.IntentKeys;
import com.example.androidsdk.Pay;

public class MainActivity extends AppCompatActivity {
    String paymentKey="ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKSVV6VXhNaUo5LmV5SnZjbVJsY2w5cFpDSTZORFkxTWpVek5pd2liRzlqYTE5dmNtUmxjbDkzYUdWdVgzQmhhV1FpT21aaGJITmxMQ0ppYVd4c2FXNW5YMlJoZEdFaU9uc2labWx5YzNSZmJtRnRaU0k2SWtOc2FXWm1iM0prSWl3aWJHRnpkRjl1WVcxbElqb2lUbWxqYjJ4aGN5SXNJbk4wY21WbGRDSTZJa1YwYUdGdUlFeGhibVFpTENKaWRXbHNaR2x1WnlJNklqZ3dNamdpTENKbWJHOXZjaUk2SWpReUlpd2lZWEJoY25SdFpXNTBJam9pT0RBeklpd2lZMmwwZVNJNklrcGhjMnR2YkhOcmFXSjFjbWRvSWl3aWMzUmhkR1VpT2lKVmRHRm9JaXdpWTI5MWJuUnllU0k2SWtOU0lpd2laVzFoYVd3aU9pSmpiR0YxWkdWMGRHVXdPVUJsZUdFdVkyOXRJaXdpY0dodmJtVmZiblZ0WW1WeUlqb2lLemcyS0RncE9URXpOVEl4TURRNE55SXNJbkJ2YzNSaGJGOWpiMlJsSWpvaU1ERTRPVGdpTENKbGVIUnlZVjlrWlhOamNtbHdkR2x2YmlJNklrNUJJbjBzSW5CdGExOXBjQ0k2SWpFNU5pNHhOVE11TWpBdU1UWXhJaXdpWTNWeWNtVnVZM2tpT2lKSlRGTWlMQ0oxYzJWeVgybGtJam8wTnpBMUxDSmhiVzkxYm5SZlkyVnVkSE1pT2pFd01Dd2lhVzUwWldkeVlYUnBiMjVmYVdRaU9qRXpNekl3TENKbGVIQWlPakV3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREUxT0RNM05qQTBPRFo5LkVtbklnLWlWMFBRZFFtSkxYSFE5cFdYblNNb2swTFpTMEpJWUFWUm1pVGtobE5lVGxmLS05YmUyMEYtOVZyZmZpRUxhdFFqbXNEaVpYaUFYUXlHYmtR";
    int IframeID= 21584;


    private void StartPayActivity(){

      Intent pay_intent = new Intent(this, Pay.class);
      pay_intent.putExtra(IntentKeys.PAYMENT_KEY, paymentKey);
      pay_intent.putExtra(String.valueOf(IntentKeys.IFRAMEID), IframeID);
      startActivity(pay_intent);

  }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartPayActivity();


    }
}
