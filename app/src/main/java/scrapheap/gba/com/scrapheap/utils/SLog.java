package scrapheap.gba.com.scrapheap.utils;

import android.util.Log;

/**
 * Created by Ifa on 2014-11-18.
 */
public class SLog {

    private final static String LOG_TAG = "Scrapheap";

    public static void d(String msg) {
        Log.d(LOG_TAG, msg);
    }


    public static void e(String msg) {
        Log.e(LOG_TAG, msg);
    }

    public static void i(String msg) {
        Log.i(LOG_TAG, msg);
    }
}
