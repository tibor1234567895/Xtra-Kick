package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.util.Log;
import b5.a;
import com.bumptech.glide.j;
import h5.x;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import p1.d;
import w5.c;
import w5.i;

public final class m implements e {

    /* renamed from: n  reason: collision with root package name */
    public static final l f3232n = new l();

    /* renamed from: h  reason: collision with root package name */
    public final x f3233h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3234i;

    /* renamed from: j  reason: collision with root package name */
    public final l f3235j = f3232n;

    /* renamed from: k  reason: collision with root package name */
    public HttpURLConnection f3236k;

    /* renamed from: l  reason: collision with root package name */
    public InputStream f3237l;

    /* renamed from: m  reason: collision with root package name */
    public volatile boolean f3238m;

    public m(x xVar, int i10) {
        this.f3233h = xVar;
        this.f3234i = i10;
    }

    public final Class a() {
        return InputStream.class;
    }

    public final InputStream b(URL url, int i10, URL url2, Map map) {
        int i11;
        boolean z10;
        InputStream inputStream;
        int i12 = -1;
        if (i10 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new d(-1, "In re-direct loop", (IOException) null);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            boolean z11 = false;
            try {
                this.f3235j.getClass();
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                for (Map.Entry entry : map.entrySet()) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                int i13 = this.f3234i;
                httpURLConnection.setConnectTimeout(i13);
                httpURLConnection.setReadTimeout(i13);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                this.f3236k = httpURLConnection;
                try {
                    httpURLConnection.connect();
                    this.f3237l = this.f3236k.getInputStream();
                    if (this.f3238m) {
                        return null;
                    }
                    try {
                        i11 = this.f3236k.getResponseCode();
                    } catch (IOException unused2) {
                        Log.isLoggable("HttpUrlFetcher", 3);
                        i11 = -1;
                    }
                    int i14 = i11 / 100;
                    if (i14 == 2) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        HttpURLConnection httpURLConnection2 = this.f3236k;
                        try {
                            if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                                inputStream = new c(httpURLConnection2.getInputStream(), (long) httpURLConnection2.getContentLength());
                            } else {
                                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                    httpURLConnection2.getContentEncoding();
                                }
                                inputStream = httpURLConnection2.getInputStream();
                            }
                            this.f3237l = inputStream;
                            return inputStream;
                        } catch (IOException e10) {
                            try {
                                i12 = httpURLConnection2.getResponseCode();
                            } catch (IOException unused3) {
                                Log.isLoggable("HttpUrlFetcher", 3);
                            }
                            throw new d(i12, "Failed to obtain InputStream", e10);
                        }
                    } else {
                        if (i14 == 3) {
                            z11 = true;
                        }
                        if (z11) {
                            String headerField = this.f3236k.getHeaderField("Location");
                            if (!TextUtils.isEmpty(headerField)) {
                                try {
                                    URL url3 = new URL(url, headerField);
                                    c();
                                    return b(url3, i10 + 1, url, map);
                                } catch (MalformedURLException e11) {
                                    throw new d(i11, h.m("Bad redirect url: ", headerField), e11);
                                }
                            } else {
                                throw new d(i11, "Received empty or null redirect url", (IOException) null);
                            }
                        } else if (i11 == -1) {
                            throw new d(i11, 2);
                        } else {
                            try {
                                throw new d(i11, this.f3236k.getResponseMessage(), (IOException) null);
                            } catch (IOException e12) {
                                throw new d(i11, "Failed to get a response message", e12);
                            }
                        }
                    }
                } catch (IOException e13) {
                    try {
                        i12 = this.f3236k.getResponseCode();
                    } catch (IOException unused4) {
                        Log.isLoggable("HttpUrlFetcher", 3);
                    }
                    throw new d(i12, "Failed to connect or obtain data", e13);
                }
            } catch (IOException e14) {
                throw new d(0, "URL.openConnection threw", e14);
            }
        } else {
            throw new d(-1, "Too many (> 5) redirects!", (IOException) null);
        }
    }

    public final void c() {
        InputStream inputStream = this.f3237l;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f3236k;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f3236k = null;
    }

    public final void cancel() {
        this.f3238m = true;
    }

    public final a d() {
        return a.REMOTE;
    }

    /* JADX INFO: finally extract failed */
    public final void f(j jVar, d dVar) {
        x xVar = this.f3233h;
        int i10 = i.f16115a;
        SystemClock.elapsedRealtimeNanos();
        try {
            if (xVar.f7623f == null) {
                xVar.f7623f = new URL(xVar.d());
            }
            dVar.g(b(xVar.f7623f, 0, (URL) null, xVar.f7619b.a()));
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                return;
            }
        } catch (IOException e10) {
            Log.isLoggable("HttpUrlFetcher", 3);
            dVar.e(e10);
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                return;
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                SystemClock.elapsedRealtimeNanos();
            }
            throw th;
        }
        SystemClock.elapsedRealtimeNanos();
    }
}
