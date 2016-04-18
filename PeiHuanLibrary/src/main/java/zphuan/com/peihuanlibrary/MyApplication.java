package zphuan.com.peihuanlibrary;

import android.util.DisplayMetrics;

import org.litepal.LitePalApplication;

import zphuan.com.peihuanlibrary.util.CrashHandler;

/**
 * Created by huan on 15/12/7.
 */
public class MyApplication extends LitePalApplication {

    private static MyApplication mContext;
    private DisplayMetrics displayMetrics = null;
    /**
     * 获取全局的context
     * @return
     */
    public static MyApplication getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        /**在这里为应用设置异常处理程序，然后我们的程序才能捕获未处理的异常*/
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }

    public void setDisplayMetrics(DisplayMetrics DisplayMetrics) {
        this.displayMetrics = DisplayMetrics;
    }

    /**
     * 获取屏幕高度
     * @return
     */
    public int getScreenHeight() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.heightPixels;
    }

    /**
     * 获取屏幕宽度
     * @return
     */
    public int getScreenWidth() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.widthPixels;
    }

    public int dp2px(float f)
    {
        return (int)(0.5F + f * getScreenDensity());
    }

    public int px2dp(float pxValue) {
        return (int) (pxValue / getScreenDensity() + 0.5f);
    }

    /**
     * 获取屏幕
     * @return
     */
    public float getScreenDensity() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.density;
    }

    /**
     * 获取应用的data/data/....File目录
     */
    public String getFilesDirPath() {
        return getFilesDir().getAbsolutePath();
    }

    /**
     * 获取应用的data/data/....Cache目录
     */
    public String getCacheDirPath() {
        return getCacheDir().getAbsolutePath();
    }

}
