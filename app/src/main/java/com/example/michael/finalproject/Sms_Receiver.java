package com.example.michael.finalproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by michael on 03-Jan-18.
 */

public class Sms_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Object[] PDU = (Object[]) intent.getExtras().get("pdus");
        for (int i = 0; i < PDU.length; i++){
            SmsMessage message = SmsMessage.createFromPdu((byte[]) PDU[i],"3gpp");

            String sender = message.getDisplayOriginatingAddress();
            String content = message.getDisplayMessageBody();

            Toast.makeText(context, sender+" : "+content, Toast.LENGTH_LONG).show();
        }
    }
}
