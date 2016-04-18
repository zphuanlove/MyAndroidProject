/*
 * Copyright 2014-2024 Helome. All rights reserved.
 */
package zphuan.com.peihuanlibrary.util;

import android.content.Context;
import android.widget.Toast;



/**
 * 
 * ToastUtils.java - Toast封装类
 * 
 * @author Huan.zhong
 * 
 *         2014-2-24 下午3:05:47
 */
public class ToastUtils {

    /**
     * Toast - 网络连接或服务器连接失败
     * 
     * @param context
     */
    public static void showNetworkOrServerConnectError(final Context context) {
//        showMessageLong(context, R.string.txt_network_or_server_connect_error);
    }

    /**
     * Show Toast in short time by system
     * 
     * @param context
     * @param strMsg
     */
    public static void showMessage(final Context context, final String strMsg) {
        Toast.makeText(context, strMsg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show Toast in short time by system
     * 
     * @param context
     * @param resId
     */
    public static void showMessage(final Context context, final int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show Toast in long time by system
     * 
     * @param context
     * @param resId
     */
    public static void showMessageLong(final Context context, final int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
    }

    /**
     * Show Toast in long time by system
     * 
     * @param context
     * @param strMsg
     */
    public static void showMessageLong(final Context context, final String strMsg) {
        Toast.makeText(context, strMsg, Toast.LENGTH_LONG).show();
    }

}
