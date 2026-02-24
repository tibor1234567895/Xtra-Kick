package k1;

import android.net.Uri;
import android.support.v4.media.h;
import c9.r;
import d9.w1;
import j1.l0;
import j1.v;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class s extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f9051e;

    /* renamed from: f  reason: collision with root package name */
    public final int f9052f;

    /* renamed from: g  reason: collision with root package name */
    public final int f9053g;

    /* renamed from: h  reason: collision with root package name */
    public final String f9054h;

    /* renamed from: i  reason: collision with root package name */
    public final a0 f9055i;

    /* renamed from: j  reason: collision with root package name */
    public final a0 f9056j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f9057k;

    /* renamed from: l  reason: collision with root package name */
    public final r f9058l;

    /* renamed from: m  reason: collision with root package name */
    public HttpURLConnection f9059m;

    /* renamed from: n  reason: collision with root package name */
    public InputStream f9060n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f9061o;

    /* renamed from: p  reason: collision with root package name */
    public int f9062p;

    /* renamed from: q  reason: collision with root package name */
    public long f9063q;

    /* renamed from: r  reason: collision with root package name */
    public long f9064r;

    @Deprecated
    public s() {
        this((String) null, 8000, 8000, (a0) null);
    }

    public static void z(HttpURLConnection httpURLConnection, long j10) {
        int i10;
        if (httpURLConnection != null && (i10 = l0.f8453a) >= 19 && i10 <= 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j10 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j10 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Class<? super Object> superclass = inputStream.getClass().getSuperclass();
                    superclass.getClass();
                    Method declaredMethod = superclass.getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void A(long j10) {
        if (j10 != 0) {
            byte[] bArr = new byte[4096];
            while (j10 > 0) {
                int min = (int) Math.min(j10, (long) 4096);
                InputStream inputStream = this.f9060n;
                int i10 = l0.f8453a;
                int read = inputStream.read(bArr, 0, min);
                if (Thread.currentThread().isInterrupted()) {
                    throw new x((IOException) new InterruptedIOException(), 2000, 1);
                } else if (read != -1) {
                    j10 -= (long) read;
                    r(read);
                } else {
                    throw new x();
                }
            }
        }
    }

    public final void close() {
        try {
            InputStream inputStream = this.f9060n;
            if (inputStream != null) {
                long j10 = this.f9063q;
                long j11 = -1;
                if (j10 != -1) {
                    j11 = j10 - this.f9064r;
                }
                z(this.f9059m, j11);
                inputStream.close();
            }
            this.f9060n = null;
            v();
            if (this.f9061o) {
                this.f9061o = false;
                s();
            }
        } catch (IOException e10) {
            int i10 = l0.f8453a;
            throw new x(e10, 2000, 3);
        } catch (Throwable th) {
            this.f9060n = null;
            v();
            if (this.f9061o) {
                this.f9061o = false;
                s();
            }
            throw th;
        }
    }

    public final Map e() {
        HttpURLConnection httpURLConnection = this.f9059m;
        if (httpURLConnection == null) {
            return w1.f4691n;
        }
        return new r(httpURLConnection.getHeaderFields());
    }

    public final Uri j() {
        HttpURLConnection httpURLConnection = this.f9059m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final int o(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        try {
            long j10 = this.f9063q;
            if (j10 != -1) {
                long j11 = j10 - this.f9064r;
                if (j11 == 0) {
                    return -1;
                }
                i11 = (int) Math.min((long) i11, j11);
            }
            InputStream inputStream = this.f9060n;
            int i12 = l0.f8453a;
            int read = inputStream.read(bArr, i10, i11);
            if (read != -1) {
                this.f9064r += (long) read;
                r(read);
                return read;
            }
            return -1;
        } catch (IOException e10) {
            int i13 = l0.f8453a;
            throw x.a(e10, 2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0135 A[Catch:{ IOException -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long q(k1.m r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = 0
            r1.f9064r = r2
            r1.f9063q = r2
            r21.t()
            r4 = 1
            java.net.HttpURLConnection r5 = r21.y(r22)     // Catch:{ IOException -> 0x01ed }
            r1.f9059m = r5     // Catch:{ IOException -> 0x01ed }
            int r6 = r5.getResponseCode()     // Catch:{ IOException -> 0x01ed }
            r1.f9062p = r6     // Catch:{ IOException -> 0x01ed }
            r5.getResponseMessage()     // Catch:{ IOException -> 0x01ed }
            int r6 = r1.f9062p
            r7 = -1
            java.lang.String r9 = "Content-Range"
            r10 = 200(0xc8, float:2.8E-43)
            long r11 = r0.f9027f
            long r13 = r0.f9028g
            if (r6 < r10) goto L_0x0169
            r15 = 299(0x12b, float:4.19E-43)
            if (r6 <= r15) goto L_0x0031
            goto L_0x0169
        L_0x0031:
            java.lang.String r6 = r5.getContentType()
            c9.r r15 = r1.f9058l
            if (r15 == 0) goto L_0x0049
            boolean r15 = r15.apply(r6)
            if (r15 == 0) goto L_0x0040
            goto L_0x0049
        L_0x0040:
            r21.v()
            k1.y r0 = new k1.y
            r0.<init>(r6)
            throw r0
        L_0x0049:
            int r6 = r1.f9062p
            if (r6 != r10) goto L_0x0052
            int r6 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r11 = r2
        L_0x0053:
            java.lang.String r6 = "Content-Encoding"
            java.lang.String r6 = r5.getHeaderField(r6)
            java.lang.String r10 = "gzip"
            boolean r6 = r10.equalsIgnoreCase(r6)
            if (r6 != 0) goto L_0x0127
            int r10 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x0067
            goto L_0x0127
        L_0x0067:
            java.lang.String r7 = "Content-Length"
            java.lang.String r7 = r5.getHeaderField(r7)
            java.lang.String r8 = r5.getHeaderField(r9)
            java.util.regex.Pattern r9 = k1.b0.f8971a
            java.lang.String r9 = "Inconsistent headers ["
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r13 = "]"
            java.lang.String r14 = "HttpUtil"
            if (r10 != 0) goto L_0x0098
            long r15 = java.lang.Long.parseLong(r7)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x009a
        L_0x0084:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r15 = "Unexpected Content-Length ["
            r10.<init>(r15)
            r10.append(r7)
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            j1.v.c(r14, r10)
        L_0x0098:
            r15 = -1
        L_0x009a:
            r17 = r15
            boolean r10 = android.text.TextUtils.isEmpty(r8)
            if (r10 != 0) goto L_0x0110
            java.util.regex.Pattern r10 = k1.b0.f8971a
            java.util.regex.Matcher r10 = r10.matcher(r8)
            boolean r15 = r10.matches()
            if (r15 == 0) goto L_0x0110
            r15 = 2
            java.lang.String r15 = r10.group(r15)     // Catch:{ NumberFormatException -> 0x00f8 }
            r15.getClass()     // Catch:{ NumberFormatException -> 0x00f8 }
            long r15 = java.lang.Long.parseLong(r15)     // Catch:{ NumberFormatException -> 0x00f8 }
            java.lang.String r4 = r10.group(r4)     // Catch:{ NumberFormatException -> 0x00f8 }
            r4.getClass()     // Catch:{ NumberFormatException -> 0x00f8 }
            long r19 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x00f8 }
            long r15 = r15 - r19
            r19 = 1
            r10 = r5
            long r4 = r15 + r19
            r0 = r17
            int r15 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r15 >= 0) goto L_0x00d5
            r17 = r4
            goto L_0x0115
        L_0x00d5:
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0113
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00fb }
            r2.<init>(r9)     // Catch:{ NumberFormatException -> 0x00fb }
            r2.append(r7)     // Catch:{ NumberFormatException -> 0x00fb }
            java.lang.String r3 = "] ["
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x00fb }
            r2.append(r8)     // Catch:{ NumberFormatException -> 0x00fb }
            r2.append(r13)     // Catch:{ NumberFormatException -> 0x00fb }
            java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x00fb }
            j1.v.g(r14, r2)     // Catch:{ NumberFormatException -> 0x00fb }
            long r17 = java.lang.Math.max(r0, r4)     // Catch:{ NumberFormatException -> 0x00fb }
            goto L_0x0115
        L_0x00f8:
            r10 = r5
            r0 = r17
        L_0x00fb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected Content-Range ["
            r2.<init>(r3)
            r2.append(r8)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            j1.v.c(r14, r2)
            goto L_0x0113
        L_0x0110:
            r10 = r5
            r0 = r17
        L_0x0113:
            r17 = r0
        L_0x0115:
            r0 = -1
            int r2 = (r17 > r0 ? 1 : (r17 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x011e
            long r17 = r17 - r11
            goto L_0x0120
        L_0x011e:
            r17 = -1
        L_0x0120:
            r4 = r21
            r0 = r17
            r4.f9063q = r0
            goto L_0x012b
        L_0x0127:
            r4 = r1
            r10 = r5
            r4.f9063q = r13
        L_0x012b:
            r1 = 2000(0x7d0, float:2.803E-42)
            java.io.InputStream r0 = r10.getInputStream()     // Catch:{ IOException -> 0x015e }
            r4.f9060n = r0     // Catch:{ IOException -> 0x015e }
            if (r6 == 0) goto L_0x013e
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x015e }
            java.io.InputStream r2 = r4.f9060n     // Catch:{ IOException -> 0x015e }
            r0.<init>(r2)     // Catch:{ IOException -> 0x015e }
            r4.f9060n = r0     // Catch:{ IOException -> 0x015e }
        L_0x013e:
            r0 = 1
            r4.f9061o = r0
            r21.u(r22)
            r4.A(r11)     // Catch:{ IOException -> 0x014a }
            long r0 = r4.f9063q
            return r0
        L_0x014a:
            r0 = move-exception
            r2 = r0
            r21.v()
            boolean r0 = r2 instanceof k1.x
            if (r0 == 0) goto L_0x0157
            r0 = r2
            k1.x r0 = (k1.x) r0
            throw r0
        L_0x0157:
            k1.x r0 = new k1.x
            r3 = 1
            r0.<init>((java.io.IOException) r2, (int) r1, (int) r3)
            throw r0
        L_0x015e:
            r0 = move-exception
            r2 = 1
            r21.v()
            k1.x r3 = new k1.x
            r3.<init>((java.io.IOException) r0, (int) r1, (int) r2)
            throw r3
        L_0x0169:
            r4 = r1
            r10 = r5
            java.util.Map r0 = r10.getHeaderFields()
            int r1 = r4.f9062p
            r5 = 416(0x1a0, float:5.83E-43)
            if (r1 != r5) goto L_0x01af
            java.lang.String r1 = r10.getHeaderField(r9)
            java.util.regex.Pattern r6 = k1.b0.f8971a
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L_0x0182
            goto L_0x019b
        L_0x0182:
            java.util.regex.Pattern r6 = k1.b0.f8972b
            java.util.regex.Matcher r1 = r6.matcher(r1)
            boolean r6 = r1.matches()
            if (r6 == 0) goto L_0x019b
            r6 = 1
            java.lang.String r1 = r1.group(r6)
            r1.getClass()
            long r7 = java.lang.Long.parseLong(r1)
            goto L_0x019e
        L_0x019b:
            r6 = 1
            r7 = -1
        L_0x019e:
            int r1 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x01af
            r4.f9061o = r6
            r21.u(r22)
            r0 = -1
            int r5 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x01ae
            r2 = r13
        L_0x01ae:
            return r2
        L_0x01af:
            java.io.InputStream r1 = r10.getErrorStream()
            if (r1 == 0) goto L_0x01d0
            int r2 = j1.l0.f8453a     // Catch:{ IOException -> 0x01d3 }
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x01d3 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01d3 }
            r3.<init>()     // Catch:{ IOException -> 0x01d3 }
        L_0x01c0:
            int r6 = r1.read(r2)     // Catch:{ IOException -> 0x01d3 }
            r7 = -1
            if (r6 == r7) goto L_0x01cc
            r7 = 0
            r3.write(r2, r7, r6)     // Catch:{ IOException -> 0x01d3 }
            goto L_0x01c0
        L_0x01cc:
            r3.toByteArray()     // Catch:{ IOException -> 0x01d3 }
            goto L_0x01d5
        L_0x01d0:
            int r1 = j1.l0.f8453a     // Catch:{ IOException -> 0x01d3 }
            goto L_0x01d5
        L_0x01d3:
            int r1 = j1.l0.f8453a
        L_0x01d5:
            r21.v()
            int r1 = r4.f9062p
            if (r1 != r5) goto L_0x01e4
            k1.i r1 = new k1.i
            r2 = 2008(0x7d8, float:2.814E-42)
            r1.<init>(r2)
            goto L_0x01e5
        L_0x01e4:
            r1 = 0
        L_0x01e5:
            k1.z r2 = new k1.z
            int r3 = r4.f9062p
            r2.<init>(r3, r1, r0)
            throw r2
        L_0x01ed:
            r0 = move-exception
            r4 = r1
            r21.v()
            r1 = 1
            k1.x r0 = k1.x.a(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.s.q(k1.m):long");
    }

    public final void v() {
        HttpURLConnection httpURLConnection = this.f9059m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e10) {
                v.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e10);
            }
            this.f9059m = null;
        }
    }

    public final URL w(URL url, String str) {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    throw new x(h.m("Unsupported protocol redirect: ", protocol), 2001);
                } else if (this.f9051e || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    throw new x("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", 2001);
                }
            } catch (MalformedURLException e10) {
                throw new x((IOException) e10, 2001, 1);
            }
        } else {
            throw new x("Null location redirect", 2001);
        }
    }

    public final HttpURLConnection x(URL url, int i10, byte[] bArr, long j10, long j11, boolean z10, boolean z11, Map map) {
        Map map2;
        String str;
        String str2;
        boolean z12;
        String str3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f9052f);
        httpURLConnection.setReadTimeout(this.f9053g);
        HashMap hashMap = new HashMap();
        a0 a0Var = this.f9055i;
        if (a0Var != null) {
            hashMap.putAll(a0Var.a());
        }
        a0 a0Var2 = this.f9056j;
        synchronized (a0Var2) {
            if (a0Var2.f8965b == null) {
                a0Var2.f8965b = Collections.unmodifiableMap(new HashMap(a0Var2.f8964a));
            }
            map2 = a0Var2.f8965b;
        }
        hashMap.putAll(map2);
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        Pattern pattern = b0.f8971a;
        if (j10 == 0 && j11 == -1) {
            str = null;
        } else {
            StringBuilder sb2 = new StringBuilder("bytes=");
            sb2.append(j10);
            sb2.append("-");
            if (j11 != -1) {
                sb2.append((j10 + j11) - 1);
            }
            str = sb2.toString();
        }
        if (str != null) {
            httpURLConnection.setRequestProperty("Range", str);
        }
        String str4 = this.f9054h;
        if (str4 != null) {
            httpURLConnection.setRequestProperty("User-Agent", str4);
        }
        if (z10) {
            str2 = "gzip";
        } else {
            str2 = Constants.DEFAULT_KEY_FORMAT;
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", str2);
        httpURLConnection.setInstanceFollowRedirects(z11);
        if (bArr != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        httpURLConnection.setDoOutput(z12);
        int i11 = m.f9021k;
        if (i10 == 1) {
            str3 = "GET";
        } else if (i10 == 2) {
            str3 = "POST";
        } else if (i10 == 3) {
            str3 = "HEAD";
        } else {
            throw new IllegalStateException();
        }
        httpURLConnection.setRequestMethod(str3);
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public final HttpURLConnection y(m mVar) {
        boolean z10;
        HttpURLConnection x10;
        boolean z11;
        m mVar2 = mVar;
        URL url = new URL(mVar2.f9022a.toString());
        int i10 = mVar2.f9024c;
        byte[] bArr = mVar2.f9025d;
        long j10 = mVar2.f9027f;
        long j11 = mVar2.f9028g;
        if ((mVar2.f9030i & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z12 = this.f9051e;
        boolean z13 = this.f9057k;
        if (!z12 && !z13) {
            return x(url, i10, bArr, j10, j11, z10, true, mVar2.f9026e);
        }
        int i11 = 0;
        URL url2 = url;
        int i12 = i10;
        byte[] bArr2 = bArr;
        while (true) {
            int i13 = i11 + 1;
            if (i11 <= 20) {
                int i14 = i13;
                URL url3 = url2;
                int i15 = i12;
                boolean z14 = z13;
                long j12 = j11;
                x10 = x(url2, i12, bArr2, j10, j11, z10, false, mVar2.f9026e);
                int responseCode = x10.getResponseCode();
                String headerField = x10.getHeaderField("Location");
                if ((i15 == 1 || i15 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    x10.disconnect();
                    url2 = w(url3, headerField);
                    i12 = i15;
                } else if (i15 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return x10;
                } else {
                    x10.disconnect();
                    if (!z14 || responseCode != 302) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (!z11) {
                        bArr2 = null;
                        i12 = 1;
                    } else {
                        i12 = i15;
                    }
                    url2 = w(url3, headerField);
                }
                mVar2 = mVar;
                i11 = i14;
                z13 = z14;
                j11 = j12;
            } else {
                throw new x((IOException) new NoRouteToHostException(h.i("Too many redirects: ", i13)), 2001, 1);
            }
        }
        return x10;
    }

    public s(String str, int i10, int i11, a0 a0Var) {
        super(true);
        this.f9054h = str;
        this.f9052f = i10;
        this.f9053g = i11;
        this.f9051e = false;
        this.f9055i = a0Var;
        this.f9058l = null;
        this.f9056j = new a0();
        this.f9057k = false;
    }
}
