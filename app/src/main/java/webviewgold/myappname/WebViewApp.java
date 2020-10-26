package webviewgold.myappname;

import android.app.Application;

import com.onesignal.OneSignal;

public class WebViewApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        if(Config.PUSH_ENABLED)
        {
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.DEBUG, OneSignal.LOG_LEVEL.NONE);
            OneSignal.startInit(this)
                    .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                    .setNotificationOpenedHandler(new MyNotificationOpenedHandler(this))
                    .unsubscribeWhenNotificationsAreDisabled(true)
                    .init();

        }
    }
}