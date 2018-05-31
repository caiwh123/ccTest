package com.bluemobi.wx.util;

import java.security.cert.X509Certificate;

import com.sun.net.ssl.X509TrustManager;

public class MyX509TrustManager implements X509TrustManager{

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClientTrusted(X509Certificate[] arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isServerTrusted(X509Certificate[] arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
