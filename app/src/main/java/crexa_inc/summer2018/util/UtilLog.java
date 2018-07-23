package crexa_inc.summer2018.util;

import android.util.Log;

public class UtilLog {
    private static boolean LogSwitch=false;

    public static boolean isLogSwitch() {
        return LogSwitch;
    }

    public static void setLogSwitch(boolean logSwitch) {
        LogSwitch = logSwitch;
    }

    public static void LogD (String tag, String msg){
        if(isLogSwitch()){
            Log.d(tag,msg);
        }
    }
    public static void LogI (String tag, String msg){
        if(isLogSwitch()){
            Log.i(tag,msg);
        }
    }
    public static void LogE (String tag, String msg){
        if(isLogSwitch()){
            Log.e(tag,msg);
        }
    }

}
