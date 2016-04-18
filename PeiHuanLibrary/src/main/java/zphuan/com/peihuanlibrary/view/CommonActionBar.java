/*
 * Copyright 2014-2024 Helome. All rights reserved. 
 */
package zphuan.com.peihuanlibrary.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import zphuan.com.peihuanlibrary.R;
import zphuan.com.peihuanlibrary.util.Logger;


/**
 * 
 * CommonActionBar.java - 通用ActionBar
 * 
 * @author peiHuan
 * 
 *         2014-3-17 下午1:44:07
 */
public class CommonActionBar extends RelativeLayout {

	/**
	 * 左边图标按钮
	 */
	private ImageButton mImgBtnLeft;
	/**
	 * 左边文字按钮
	 */
	private TextView mTxtViewLeft;

	/**
	 * 中间文字标题
	 */
	private TextView mTxtViewTitle;

	/**
	 * 中间图片LOGO
	 */
	private ImageView mImgViewLogo;

	/**
	 * 右边图标按钮
	 */
	private ImageButton mImgBtnRight;

	/**
	 * 右边文字按钮
	 */
	private TextView mTxtViewRight;
	private ImageView mIvRight;

	private RelativeLayout mTitleBar;
	
	public void SetTitleRightImg(){
		mIvRight.setVisibility(View.VISIBLE);
	}
	
	public void SetTitleRightImgGone(){
		mIvRight.setVisibility(View.GONE);
	}

	public CommonActionBar(Context context) {
		super(context);
		initViews(context);
	}

	private void initViews(Context context) {
		View rootLayout = LayoutInflater.from(context).inflate(R.layout.actionbar_common_layout, this);
		mTitleBar = (RelativeLayout)rootLayout.findViewById(R.id.mRlTitleBarOuter);
		mImgBtnLeft = (ImageButton) rootLayout.findViewById(R.id.actionbar_img_btn_left);
		mTxtViewLeft = (TextView)rootLayout.findViewById(R.id.actionbar_text_view_left);
		mTxtViewTitle = (TextView) rootLayout.findViewById(R.id.actionbar_txt_view_title);
		mImgViewLogo = (ImageView) rootLayout.findViewById(R.id.actionbar_img_view_logo);
		mIvRight = (ImageView) rootLayout.findViewById(R.id.mIvRight);
		mImgBtnRight = (ImageButton) rootLayout.findViewById(R.id.actionbar_img_btn_right);
		mTxtViewRight = (TextView) rootLayout.findViewById(R.id.actionbar_txt_view_right);
	}

	/**
	 * 设置中间文字标题（不设置则显示图片LOGO）
	 * 
	 * @param titleResId
	 *            资源ID
	 */
	public void setActionBarTitle(int titleResId) {
		mTxtViewTitle.setText(titleResId);
		mTxtViewTitle.setVisibility(View.VISIBLE);
		mImgViewLogo.setVisibility(View.GONE);
	}

	/**
	 * 设置中间文字标题（不设置则显示图片LOGO）
	 * 
	 */
	public void setActionBarTitle(String strTitle) {
		mTxtViewTitle.setText(strTitle);
		mTxtViewTitle.setVisibility(View.VISIBLE);
		mImgViewLogo.setVisibility(View.GONE);
	}

	public void showImageLogoTitle() {
		mImgViewLogo.setVisibility(View.VISIBLE);
		mTxtViewTitle.setVisibility(View.GONE);
	}

	/**
	 * 设置左边图标按钮及事件
	 * 
	 * @param imageResId
	 *            资源ID
	 * @param onClickListener
	 *            事件
	 */
	public void setLeftImgBtn(int imageResId, OnClickListener onClickListener) {
		mImgBtnLeft.setVisibility(View.VISIBLE);
		mImgBtnLeft.setImageResource(imageResId);
		mImgBtnLeft.setOnClickListener(onClickListener);
	}
	

	/**
	 * 设置右边文字按钮及事件
	 * 
	 * @param onClickListener
	 *            事件
	 */
	public void setRightImageBtn(int imageResId, OnClickListener onClickListener) {
		Logger.d("base", "bar right=" + mImgBtnRight);
		mImgBtnRight.setVisibility(View.VISIBLE);
		mImgBtnRight.setImageResource(imageResId);
		mImgBtnRight.setOnClickListener(onClickListener);
	}

	/**
	 * 设置右边文字按钮图片资源
	 * 
	 * @param imageResId
	 */
	public void setRightImageBtn(int imageResId) {
		mImgBtnRight.setImageResource(imageResId);
	}

	public void hideRightImageBtn() {
		mImgBtnRight.setVisibility(View.GONE);
	}

	public void showRightImageBtn() {
		mImgBtnRight.setVisibility(View.VISIBLE);
	}

	public void hideLeftImageBtn() {
		mImgBtnLeft.setVisibility(View.GONE);
	}

	public void showLeftImageBtn() {
		mImgBtnLeft.setVisibility(View.VISIBLE);
	}

	/**
	 * 设置右边图标按钮及事件
	 * 
	 * @param onClickListener
	 *            事件
	 */
	public void setRightTxtView(String text, OnClickListener onClickListener) {
		mTxtViewRight.setVisibility(View.VISIBLE);
		mTxtViewRight.setText(text);
		mTxtViewRight.setOnClickListener(onClickListener);
	}
	public void setRightText(String text){
		mTxtViewRight.setVisibility(View.VISIBLE);
		mTxtViewRight.setText(text);
	}

	public void setRightTxtViewEnabled(boolean enable) {
		mTxtViewRight.setEnabled(enable);
	}

	public void setRightImageBtnEnabled(boolean enable) {
		mImgBtnRight.setEnabled(enable);
	}

	/**
	 * 隐藏右边文字按钮
	 */
	public void hideRightTxtView() {
		mTxtViewRight.setVisibility(View.GONE);
	}

	public void showRightTxtView() {
		mTxtViewRight.setVisibility(View.VISIBLE);
	}

	/**
	 * 设置左边文字按钮及事件
	 *
	 * @param onClickListener
	 *            事件
	 */
	public void setLeftTxtView(String text, OnClickListener onClickListener) {
		mTxtViewLeft.setVisibility(View.VISIBLE);
		mTxtViewLeft.setText(text);
		mTxtViewLeft.setOnClickListener(onClickListener);
		mImgBtnLeft.setVisibility(View.GONE);
	}

	/**
	 * 设置中间文字标题（不设置则显示图片LOGO）
	 *
	 */
	public void setActionBarTitleAndColor(String strTitle,int color) {
		mTxtViewTitle.setTextColor(color);
		mTxtViewTitle.setText(strTitle);
		mTxtViewTitle.setVisibility(View.VISIBLE);
		mImgViewLogo.setVisibility(View.GONE);
	}

	public void setTitleBarBackgroundColor(int color){
		mTitleBar.setBackgroundColor(color);
	}

}
