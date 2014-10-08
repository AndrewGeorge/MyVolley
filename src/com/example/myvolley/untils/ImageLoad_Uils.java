package com.example.myvolley.untils;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.myvolley.MainActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.StorageUtils;
/*******************************
 * 
 * @ClassName ImageLoad_Uils
 * @ClassDescription 设置图片加载 
 * @version 1.0.0
 * @author dafuShao
 * @time  2014-10-8 16:30:01
 */
public class ImageLoad_Uils {

	private static com.nostra13.universalimageloader.core.ImageLoader imageLoader = com.nostra13.universalimageloader.core.ImageLoader
			.getInstance();
	private static ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

	/**
	 * 
	 * @param imageView
	 *            要设置图片的ImageView
	 * @param imageUrl
	 *            图片URL
	 * @param isCache
	 *            是否缓存
	 * @param scaleType
	 *            设置图片类型
	 * @param defaultImage
	 *            图片未获取到的默认图片
	 */
	public static void setImage(ImageView imageView, String imageUrl,
			boolean isCache, ScaleType scaleType, int defaultImage,
			Context context) {
		//设置缓存目录
		//File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache");
		
		
		imageView.setScaleType(scaleType);
		DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
				.cacheInMemory(isCache)// 是否缓存到内存
				.cacheOnDisk(isCache)// 是否缓存到SDK
				.considerExifParams(true)// 是否考虑JPEG图像EXIF参数（旋转，翻转）
				.showImageOnLoading(defaultImage)// 图片在加载过程中显示的图片
				.showImageForEmptyUri(defaultImage)// 图片uri为空时显示的图片
				.displayer(new RoundedBitmapDisplayer(20))// 是否设置为圆角，弧度为多少
				.displayer(new FadeInBitmapDisplayer(100))// 是否图片加载好后渐入的动画时间
				.showImageOnFail(defaultImage).build();// 资源加载失败时显示的图片

		imageLoader.displayImage(imageUrl, imageView, displayImageOptions,
				animateFirstListener);

	}

	private static class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener {

		static final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}

}
