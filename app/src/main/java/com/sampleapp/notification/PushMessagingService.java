package com.sampleapp.notification;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import timber.log.Timber;

/**
 * Created by saveen_dhiman on 05-November-16.
 * To display push notifications to user
 */
public class PushMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MY_RITE_SERVICE";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Handle data payload of FCM messages.
        Timber.e(TAG, "FCM Data Message: " + remoteMessage.getData());
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private void sendNotification(RemoteMessage messageBody) {
    }

}
