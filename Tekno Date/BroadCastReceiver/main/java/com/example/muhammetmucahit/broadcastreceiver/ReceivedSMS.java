package com.example.muhammetmucahit.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Muhammet Mucahit on 8/20/2017.
 */

public class ReceivedSMS extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            Object[] pdus = (Object[]) bundle.get("pdus");

            for (int i = 0; i < pdus.length; i++) {
                SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String sentFromWho = message.getDisplayOriginatingAddress();
                String messageBody = message.getDisplayMessageBody();
                Toast.makeText(context, "" + sentFromWho + "\n" + messageBody, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
