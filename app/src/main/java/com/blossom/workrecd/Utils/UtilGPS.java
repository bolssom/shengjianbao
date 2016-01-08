package com.blossom.workrecd.Utils;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class UtilGPS {
	private Context context;
	private LocationClient mLocationClient;
	public static UtilGPS utilGPS;

	public UtilGPS() {

	}

	public static UtilGPS getUtilGPS() {
		if (utilGPS == null) {
			utilGPS = new UtilGPS();
		}
		return utilGPS;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public void open(BDLocationListener bdLocationListener) {
		System.out.println("open1");
		mLocationClient = new LocationClient(context); // 声明LocationClient类
		mLocationClient.registerLocationListener(bdLocationListener); // 注册监听函数
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开GPS
		option.setAddrType("all");// 返回的定位结果包含地址信息
		option.setCoorType("bd09ll");// 返回的定位结果是百度纬度，默认值gcj02
		option.setScanSpan(3000);// 设置发起定位3000ms
		option.disableCache(false);// 禁止启用缓存定位
		option.setPriority(LocationClientOption.NetWorkFirst);// 网络优先
		mLocationClient.setLocOption(option);// 使用设置
		mLocationClient.start();// 开启定位SDK
		mLocationClient.requestLocation();// 开始请求位置
		System.out.println("open2");
	}

	public void stopSetting() {
		if (mLocationClient != null && mLocationClient.isStarted()) {
			mLocationClient.stop();// 关闭定位SDK
			mLocationClient = null;
		}
	}

	public String getCity(BDLocation location) {

		return location.getCity();
	}
}
