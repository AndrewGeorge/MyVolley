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
 * @ClassDescription ����ͼƬ���� 
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
	 *            Ҫ����ͼƬ��ImageView
	 * @param imageUrl
	 *            ͼƬURL
	 * @param isCache
	 *            �Ƿ񻺴�
	 * @param scaleType
	 *            ����ͼƬ����
	 * @param defaultImage
	 *            ͼƬδ��ȡ����Ĭ��ͼƬ
	 */
	public static void setImage(ImageView imageView, String imageUrl,
			boolean isCache, ScaleType scaleType, int defaultImage,
			Context context) {
		//���û���Ŀ¼
		//File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache");
		
		
		imageView.setScaleType(scaleType);
		DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
				.cacheInMemory(isCache)// �Ƿ񻺴浽�ڴ�
				.cacheOnDisk(isCache)// �Ƿ񻺴浽SDK
				.considerExifParams(true)// �Ƿ���JPEGͼ��EXIF��������ת����ת��
				.showImageOnLoading(defaultImage)// ͼƬ�ڼ��ع�������ʾ��ͼƬ
				.showImageForEmptyUri(defaultImage)// ͼƬuriΪ��ʱ��ʾ��ͼƬ
				.displayer(new RoundedBitmapDisplayer(20))// �Ƿ�����ΪԲ�ǣ�����Ϊ����
				.displayer(new FadeInBitmapDisplayer(100))// �Ƿ�ͼƬ���غú���Ķ���ʱ��
				.showImageOnFail(defaultImage).build();// ��Դ����ʧ��ʱ��ʾ��ͼƬ

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
