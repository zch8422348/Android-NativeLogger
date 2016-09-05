package cn.jesse.nativelogger.util;

/**
 * Created by jesse on 9/5/16.
 */
public class CrashWatcher implements Thread.UncaughtExceptionHandler {
    private static CrashWatcher mInstance = new CrashWatcher();
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private CrashWatcher() {
    }

    public static CrashWatcher getInstance() {
        return mInstance;
    }

    public void init() {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        ex.printStackTrace();
    }

}
