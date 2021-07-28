package com.example.android_sdk_example;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.androidsdk.IntentKeys;
import com.example.androidsdk.Pay;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String paymentKey = "ZXlKaGJHY2lPaUpJVXpVeE1pSXNJblI1Y0NJNklrcFhWQ0o5LmV5SnBiblJsWjNKaGRHbHZibDlwWkNJNk5EVXhNakVzSW14dlkydGZiM0prWlhKZmQyaGxibDl3WVdsa0lqcG1ZV3h6WlN3aVltbHNiR2x1WjE5a1lYUmhJanA3SW1acGNuTjBYMjVoYldVaU9pSkJZbVJ2ZFd3aUxDSnNZWE4wWDI1aGJXVWlPaUpCWkdWc0lpd2ljM1J5WldWMElqb2lSWFJvWVc0Z1RHRnVaQ0lzSW1KMWFXeGthVzVuSWpvaU9EQXlPQ0lzSW1ac2IyOXlJam9pTkRJaUxDSmhjR0Z5ZEcxbGJuUWlPaUk0TURNaUxDSmphWFI1SWpvaVNtRnphMjlzYzJ0cFluVnlaMmdpTENKemRHRjBaU0k2SWs1Qklpd2lZMjkxYm5SeWVTSTZJa05oYVhKdklpd2laVzFoYVd3aU9pSmhZbVJsYkhKb2JXRnVZV1JsYkVCd1lYbHRiMkl1WTI5dElpd2ljR2h2Ym1WZmJuVnRZbVZ5SWpvaU1EQTVOekExTmprMU5qZ3lNaklpTENKd2IzTjBZV3hmWTI5a1pTSTZJakF4T0RrNElpd2laWGgwY21GZlpHVnpZM0pwY0hScGIyNGlPaUpPUVNKOUxDSnZjbVJsY2w5cFpDSTZNVFExTWpnME5qVXNJblZ6WlhKZmFXUWlPakk0TVRZMkxDSndiV3RmYVhBaU9pSXhPVFl1TVRNeUxqRXhOQzR5TkRnaUxDSmhiVzkxYm5SZlkyVnVkSE1pT2pFek1EQXNJbVY0Y0NJNk16WXdOamd3TlRneE9EQTFNalE1TENKamRYSnlaVzVqZVNJNklrbE1VeUo5LmV3X2Z4Sm1pdDRLNm9XQ0hfZmd2enJ0bEQxVERwN01rV2FvT2FRV1lSTzZiTTVPV1Vkb2FHSGlEWFY3MDRaVlJ5bURrenJwYXRlTUJVa2ZtcUM0VFZn";
    int IframeID = 162960;
    String Endpoint = "https://checkoutapi.jawwalpay.ps/api/acceptance/post_pay";
    String success = "";
    String Id = "";
    String amount_cents = "";
    Boolean userCancelled;
    String integration_id = "";
    String has_parent_transaction = "";
    String txn_response_code = "";
    JSONObject payData;
    String Data;

    private static final String TAG = "tag";
     String DataMessage="";

    private void StartPayActivity() {

        Intent pay_intent = new Intent(this, Pay.class);
        pay_intent.putExtra(IntentKeys.PAYMENT_KEY, paymentKey);
        pay_intent.putExtra(String.valueOf(IntentKeys.IFRAMEID), IframeID);
        pay_intent.putExtra(IntentKeys.ENDPOINT_URL, Endpoint);

        startActivityForResult(pay_intent, 1);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartPayActivity();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Data = data.getStringExtra("data");

                if (Data != null) {

                    try {
                        payData = new JSONObject(Data);

                        Id = payData.getString("id");
                        Log.d(TAG, "ID:" + " " + Id);
                        success = payData.getString("success");
                        Log.d(TAG, "success:" + " " + success);
                        DataMessage = payData.getString("data.message");
                        Log.d(TAG, "DataMessage:" + " " + DataMessage);
                        amount_cents = payData.getString("amount_cents");
                        Log.d(TAG, "amount cents:" + " " + amount_cents);
                        has_parent_transaction = payData.getString("has_parent_transaction");
                        Log.d(TAG, "Has parent transaction:" + " " + has_parent_transaction);
                        integration_id = payData.getString("integration_id");
                        Log.d(TAG, "integration ID:" + " " + integration_id);
                        txn_response_code = payData.getString("txn_response_code");
                        Log.d(TAG, "txn_response_code:" + " " + txn_response_code);
                        Log.d(TAG,"full data:"+ " " + Data);

                    } catch (JSONException e) {

                      String  Error = data.getStringExtra("notifyError");
                        Log.d(TAG, "Error:" + " " + Error);

                        e.printStackTrace();

                    }

                }
                else {
                    userCancelled = data.getBooleanExtra("userCancelled",false);
                    Log.d(TAG,"user cancelled:" + " "+ userCancelled);


                }


            }
        }
    }
}
