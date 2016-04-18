package zphuan.com.peihuanlibrary.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by huan on 15/9/6.
 */
public class SharePreUtil {

    private static SharePreUtil instance;
    private SharedPreferences mySharedPreferences;
    private SharedPreferences.Editor edit;

    private SharePreUtil(Context context) {
        mySharedPreferences = context.getSharedPreferences("blast",
                Activity.MODE_PRIVATE);
        edit = mySharedPreferences.edit();
    }

    public static SharePreUtil getInstance(Context context){
        if(instance == null){
            return new SharePreUtil(context);
        }
        return instance;
    }

    private String searchGps="searchGps";
    private String gps_speak="gps_speak";
    private String sevenday_no_open="sevenday_no_open";
    private String guide_main="guide_main";
    private String guide_sport="guide_sport";

    public void saveGuideSport(boolean guide){
        edit.putBoolean(guide_sport,guide);
        edit.commit();
    }

    public boolean getIsGuideSport(){
        return mySharedPreferences.getBoolean(guide_sport,false);
    }
    public void saveGuideMain(boolean guide){
        edit.putBoolean(guide_main,guide);
        edit.commit();
    }

    public boolean getIsGuideMain(){
        return mySharedPreferences.getBoolean(guide_main,false);
    }

    /**
     * 保存是否正在搜索gps
     * @param isSearching
     */
    public void saveIsGpsSearching(boolean isSearching){
        edit.putBoolean(searchGps,isSearching);
        edit.commit();
    }

    public boolean getIsGpsSearching(){
        return mySharedPreferences.getBoolean(searchGps,false);
    }

    public void saveSpeakOn(boolean speak){
        edit.putBoolean(gps_speak,speak);
        edit.commit();
    }

    public boolean getGpsSpeak(){
        return mySharedPreferences.getBoolean(gps_speak,true);
    }

    public void saveSevenDayNoOpenTime(long time){
        edit.putLong(sevenday_no_open,time);
        edit.commit();
    }

    public long getSevenDayNoOpenTime(){
       return mySharedPreferences.getLong(sevenday_no_open,0);
    }

}
