package zphuan.com.peihuanlibrary.ui;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import zphuan.com.peihuanlibrary.R;
import zphuan.com.peihuanlibrary.util.Logger;
import zphuan.com.peihuanlibrary.view.CommonActionBar;

/**
 * Created by huan on 15/12/7.
 */
public class BaseActivity extends FragmentActivity {

    protected ActionBar mSupportActionBar;
    /**
     * 是否显示或者隐藏ActionBar
     */
    protected boolean isHideActionBar = false;
    protected CommonActionBar mcActionBar;
    protected Dialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSupportActionBar = getActionBar();
        if (null != mSupportActionBar) {
            if (isHideActionBar) {
                mSupportActionBar.hide();
            } else {
                // 隐藏Home图标和Title文字
                Logger.d("base", "mSupportActionBar=" + mSupportActionBar + " ");
                mSupportActionBar.setDisplayShowHomeEnabled(false);
                mSupportActionBar.setDisplayShowTitleEnabled(false);

                // 对ActionBar启用自定义View
                mSupportActionBar.setDisplayShowCustomEnabled(true);
            }
        }
    }

    /**
     * 显示title  ： 左边返回键  ＋   中间标题
     *
     * @param title ：需要显示的中间标题
     */
    protected void initActionBar(String title) {
        Logger.d("base","init title");
        mcActionBar = new CommonActionBar(this);
        mcActionBar.setActionBarTitle(title);
        mcActionBar.setLeftImgBtn(R.drawable.btn_return_selector, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (null != mSupportActionBar) {
            mSupportActionBar.setCustomView(mcActionBar);
        }
        Logger.d("base","mcActionBar ="+mcActionBar);
    }

    /**
     * 显示title  ： 左边返回键  ＋   中间标题 +右边文字与事件
     *
     * @param title
     * @param rightText
     * @param rightAction
     */
    protected void initActionBar(String title, String rightText, View.OnClickListener rightAction) {
        initActionBar(title);
        mcActionBar.setRightTxtView(rightText, rightAction);
    }


    /**
     * 设置左边文字及事件
     *
     * @param leftText
     * @param leftAction
     */
    protected void setActionBarLeftTextAndAction(String leftText, View.OnClickListener leftAction) {
        mcActionBar.setLeftTxtView(leftText, leftAction);
    }

    /**
     * 设置title及右边按钮图片及事件
     *
     * @param title
     * @param resource
     * @param rightAction
     */
    protected void initActionBar(String title, int resource, View.OnClickListener rightAction) {
        //initActionBar(title);
        Logger.d("base","init title");
        mcActionBar = new CommonActionBar(this);
        mcActionBar.setActionBarTitle(title);
        mcActionBar.setLeftImgBtn(R.drawable.btn_return_selector, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (null != mSupportActionBar) {
            mSupportActionBar.setCustomView(mcActionBar);
        }
        Logger.d("base","mcActionBar ="+mcActionBar);
        Logger.d("base", "mCactionBar=" + mcActionBar + " resource=" + resource + " action=" + rightAction);
        mcActionBar.setRightImageBtn(resource, rightAction);
    }


    /**
     * 先初始化加载对话框，为了可以顺利显示gif图
     */
    private void createLoadDialog() {

        pDialog = new ProgressDialog(this, R.style.dialog);
//        View view = LayoutInflater.from(this).inflate(R.layout.loading_dialog, null);
//        pDialog.setContentView(view);
//        Window window = pDialog.getWindow();
//        WindowManager.LayoutParams lp = window.getAttributes();
//        lp.width = MyApplication.getAppContext().dp2px(120);
//        lp.height = lp.width;
//        window.setAttributes(lp);
//        pDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                ImageView imageView = (ImageView) pDialog.findViewById(R.id.image);
//                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
//                if (animationDrawable != null) {
//                    animationDrawable.stop();
//                    imageView.setImageDrawable(null);
//                }
//            }
//        });
    }

    /**
     * 显示等待对话框
     *
     * @param hint
     */
    public void showProgreessDialog(String hint, boolean cancelable) {
        if (pDialog == null) {
            createLoadDialog();
        }
        if (pDialog.isShowing() || isFinishing()) {
            return;
        }
//        final ImageView imageView = (ImageView) pDialog.findViewById(R.id.image);
//        imageView.setImageResource(R.drawable.loading_animation);
//        final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
//        animationDrawable.start();
        pDialog.setCancelable(cancelable);
        pDialog.setCanceledOnTouchOutside(cancelable);
        pDialog.show();
    }

    /**
     * 销毁对话框
     */
    public void dismissProgressDialog() {
        try {
            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
