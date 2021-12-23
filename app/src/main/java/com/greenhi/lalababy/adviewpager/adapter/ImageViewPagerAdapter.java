package com.greenhi.lalababy.adviewpager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

public class ImageViewPagerAdapter extends PagerAdapter {

	private ImageView[] imageViews;
	private int size;
	private Context context;

	public ImageViewPagerAdapter(Context context, ImageView[] imageViews) {
		this.context = context;
		this.imageViews = imageViews;
		size = imageViews.length;
	}

	@Override
	public int getCount() {
		return imageViews.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
//		((ViewPager) container).removeView((View) object);// 完全溢出view,避免数据多时出现重复现象
		container.removeView(imageViews[position]);//删除页卡
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(imageViews[position], 0);
		return imageViews[position];
	}

}
