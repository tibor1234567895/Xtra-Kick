package a5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import b5.b;
import b5.m;
import e5.c;
import e5.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import k5.d;
import k5.t;
import k5.w;
import w5.n;
import w5.p;

public final class l {

    /* renamed from: e  reason: collision with root package name */
    public static final m f167e = m.a("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);

    /* renamed from: f  reason: collision with root package name */
    public static final k f168f = new k();

    /* renamed from: g  reason: collision with root package name */
    public static final ArrayDeque f169g = new ArrayDeque(0);

    /* renamed from: a  reason: collision with root package name */
    public final c f170a;

    /* renamed from: b  reason: collision with root package name */
    public final DisplayMetrics f171b;

    /* renamed from: c  reason: collision with root package name */
    public final k f172c;

    /* renamed from: d  reason: collision with root package name */
    public final List f173d;

    static {
        char[] cArr = p.f16126a;
    }

    public l(ArrayList arrayList, DisplayMetrics displayMetrics, c cVar, k kVar) {
        this.f173d = arrayList;
        n.b(displayMetrics);
        this.f171b = displayMetrics;
        n.b(cVar);
        this.f170a = cVar;
        n.b(kVar);
        this.f172c = kVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap c(java.io.InputStream r5, android.graphics.BitmapFactory.Options r6, a5.k r7, e5.c r8) {
        /*
            boolean r0 = r6.inJustDecodeBounds
            if (r0 == 0) goto L_0x000a
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r5.mark(r0)
            goto L_0x000d
        L_0x000a:
            r7.getClass()
        L_0x000d:
            int r0 = r6.outWidth
            int r1 = r6.outHeight
            java.lang.String r2 = r6.outMimeType
            java.util.concurrent.locks.Lock r3 = k5.g0.f9158d
            r3.lock()
            r4 = 0
            android.graphics.Bitmap r7 = com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeStream(r5, r4, r6)     // Catch:{ IllegalArgumentException -> 0x0028 }
            r3.unlock()
            boolean r6 = r6.inJustDecodeBounds
            if (r6 == 0) goto L_0x0027
            r5.reset()
        L_0x0027:
            return r7
        L_0x0028:
            r3 = move-exception
            java.io.IOException r0 = e(r3, r0, r1, r2, r6)     // Catch:{ all -> 0x004b }
            java.lang.String r1 = "WebpDownsampler"
            r2 = 3
            android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x004b }
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x004e
            r5.reset()     // Catch:{ IOException -> 0x004d }
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch:{ IOException -> 0x004d }
            r8.c(r1)     // Catch:{ IOException -> 0x004d }
            r6.inBitmap = r4     // Catch:{ IOException -> 0x004d }
            android.graphics.Bitmap r5 = c(r5, r6, r7, r8)     // Catch:{ IOException -> 0x004d }
            java.util.concurrent.locks.Lock r6 = k5.g0.f9158d
            r6.unlock()
            return r5
        L_0x004b:
            r5 = move-exception
            goto L_0x004f
        L_0x004d:
            throw r0     // Catch:{ all -> 0x004b }
        L_0x004e:
            throw r0     // Catch:{ all -> 0x004b }
        L_0x004f:
            java.util.concurrent.locks.Lock r6 = k5.g0.f9158d
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.l.c(java.io.InputStream, android.graphics.BitmapFactory$Options, a5.k, e5.c):android.graphics.Bitmap");
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static IOException e(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + d(options.inBitmap), illegalArgumentException);
    }

    public static void f(BitmapFactory.Options options) {
        g(options);
        ArrayDeque arrayDeque = f169g;
        synchronized (arrayDeque) {
            arrayDeque.offer(options);
        }
    }

    public static void g(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final d a(InputStream inputStream, int i10, int i11, b5.n nVar) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        k kVar = f168f;
        n.a("You must provide an InputStream that supports mark()", inputStream.markSupported());
        byte[] bArr = (byte[]) this.f172c.d(65536, byte[].class);
        synchronized (l.class) {
            ArrayDeque arrayDeque = f169g;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                g(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        b bVar = (b) nVar.c(w.f9183f);
        t tVar = (t) nVar.c(w.f9185h);
        boolean booleanValue = ((Boolean) nVar.c(w.f9186i)).booleanValue();
        m mVar = w.f9187j;
        if (nVar.c(mVar) != null) {
            boolean booleanValue2 = ((Boolean) nVar.c(mVar)).booleanValue();
        }
        try {
            return d.c(b(inputStream, options2, tVar, bVar, i10, i11, booleanValue, kVar), this.f170a);
        } finally {
            f(options2);
            this.f172c.h(bArr);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x013d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(java.io.InputStream r23, android.graphics.BitmapFactory.Options r24, k5.t r25, b5.b r26, int r27, int r28, boolean r29, a5.k r30) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r30
            int r5 = w5.i.f16115a
            android.os.SystemClock.elapsedRealtimeNanos()
            r5 = 1
            r2.inJustDecodeBounds = r5
            e5.c r6 = r0.f170a
            c(r1, r2, r4, r6)
            r7 = 0
            r2.inJustDecodeBounds = r7
            int r8 = r2.outWidth
            int r9 = r2.outHeight
            e5.k r10 = r0.f172c
            java.util.List r11 = r0.f173d
            int r12 = b5.i.a(r10, r1, r11)
            int r13 = k5.g0.c(r12)
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
            r15 = r27
            r7 = r28
            if (r15 != r14) goto L_0x0033
            r15 = r8
        L_0x0033:
            if (r7 != r14) goto L_0x0036
            r7 = r9
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r14 = b5.i.c(r10, r1, r11)
            r16 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r5 = "WebpDownsampler"
            if (r8 <= 0) goto L_0x019e
            if (r9 > 0) goto L_0x0044
            goto L_0x019e
        L_0x0044:
            r17 = r12
            r12 = 90
            if (r13 == r12) goto L_0x0054
            r12 = 270(0x10e, float:3.78E-43)
            if (r13 != r12) goto L_0x004f
            goto L_0x0054
        L_0x004f:
            float r12 = r3.b(r8, r9, r15, r7)
            goto L_0x0058
        L_0x0054:
            float r12 = r3.b(r9, r8, r15, r7)
        L_0x0058:
            r13 = 0
            int r13 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r13 <= 0) goto L_0x015f
            int r13 = r3.a(r8, r9, r15, r7)
            if (r13 == 0) goto L_0x0157
            float r0 = (float) r8
            r18 = r10
            float r10 = r12 * r0
            r19 = r11
            double r10 = (double) r10
            r20 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r10 = r10 + r20
            int r10 = (int) r10
            float r11 = (float) r9
            r28 = r5
            float r5 = r12 * r11
            double r3 = (double) r5
            double r3 = r3 + r20
            int r3 = (int) r3
            int r4 = r8 / r10
            int r3 = r9 / r3
            r5 = 1
            if (r13 != r5) goto L_0x0085
            int r3 = java.lang.Math.max(r4, r3)
            goto L_0x0089
        L_0x0085:
            int r3 = java.lang.Math.min(r4, r3)
        L_0x0089:
            int r3 = java.lang.Integer.highestOneBit(r3)
            int r3 = java.lang.Math.max(r5, r3)
            if (r13 != r5) goto L_0x009c
            float r4 = (float) r3
            float r5 = r16 / r12
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x009c
            int r3 = r3 << 1
        L_0x009c:
            r2.inSampleSize = r3
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser$ImageType.JPEG
            if (r14 != r4) goto L_0x00bd
            r4 = 8
            int r5 = java.lang.Math.min(r3, r4)
            float r5 = (float) r5
            float r0 = r0 / r5
            double r12 = (double) r0
            double r12 = java.lang.Math.ceil(r12)
            int r0 = (int) r12
            float r11 = r11 / r5
            double r10 = (double) r11
            double r10 = java.lang.Math.ceil(r10)
            int r5 = (int) r10
            int r3 = r3 / r4
            if (r3 <= 0) goto L_0x00dc
            int r0 = r0 / r3
            int r5 = r5 / r3
            goto L_0x00dc
        L_0x00bd:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser$ImageType.PNG
            if (r14 == r4) goto L_0x0105
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser$ImageType.PNG_A
            if (r14 != r4) goto L_0x00c6
            goto L_0x0105
        L_0x00c6:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser$ImageType.WEBP
            if (r14 == r4) goto L_0x00f1
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.ImageHeaderParser$ImageType.WEBP_A
            if (r14 != r4) goto L_0x00cf
            goto L_0x00f1
        L_0x00cf:
            int r0 = r8 % r3
            if (r0 != 0) goto L_0x00e1
            int r0 = r9 % r3
            if (r0 == 0) goto L_0x00d8
            goto L_0x00e1
        L_0x00d8:
            int r0 = r8 / r3
            int r5 = r9 / r3
        L_0x00dc:
            r3 = r25
            r4 = r30
            goto L_0x0118
        L_0x00e1:
            r0 = 1
            r2.inJustDecodeBounds = r0
            r4 = r30
            c(r1, r2, r4, r6)
            r0 = 0
            r2.inJustDecodeBounds = r0
            int r0 = r2.outWidth
            int r5 = r2.outHeight
            goto L_0x0116
        L_0x00f1:
            r4 = r30
            int r5 = android.os.Build.VERSION.SDK_INT
            r10 = 24
            if (r5 < r10) goto L_0x0107
            float r3 = (float) r3
            float r0 = r0 / r3
            int r0 = java.lang.Math.round(r0)
            float r11 = r11 / r3
            int r5 = java.lang.Math.round(r11)
            goto L_0x0116
        L_0x0105:
            r4 = r30
        L_0x0107:
            float r3 = (float) r3
            float r0 = r0 / r3
            double r12 = (double) r0
            double r12 = java.lang.Math.floor(r12)
            int r0 = (int) r12
            float r11 = r11 / r3
            double r10 = (double) r11
            double r10 = java.lang.Math.floor(r10)
            int r5 = (int) r10
        L_0x0116:
            r3 = r25
        L_0x0118:
            float r0 = r3.b(r0, r5, r15, r7)
            double r10 = (double) r0
            r12 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r12 = r12 * r10
            double r12 = r12 + r20
            int r0 = (int) r12
            float r3 = (float) r0
            r5 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r5
            double r12 = (double) r3
            double r10 = r10 / r12
            double r12 = (double) r0
            double r10 = r10 * r12
            double r10 = r10 + r20
            int r0 = (int) r10
            r2.inTargetDensity = r0
            r3 = 1000000000(0x3b9aca00, float:0.0047237873)
            r2.inDensity = r3
            if (r0 <= 0) goto L_0x0141
            if (r0 == r3) goto L_0x0141
            r0 = 1
            goto L_0x0142
        L_0x0141:
            r0 = 0
        L_0x0142:
            if (r0 == 0) goto L_0x014b
            r0 = 1
            r2.inScaled = r0
            r5 = r28
            r0 = 0
            goto L_0x0152
        L_0x014b:
            r0 = 0
            r2.inTargetDensity = r0
            r2.inDensity = r0
            r5 = r28
        L_0x0152:
            r3 = 2
            android.util.Log.isLoggable(r5, r3)
            goto L_0x01a5
        L_0x0157:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot round with null rounding"
            r0.<init>(r1)
            throw r0
        L_0x015f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Cannot scale with factor: "
            r1.<init>(r2)
            r1.append(r12)
            java.lang.String r2 = " from: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = ", source: ["
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = "x"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r3 = "], target: ["
            r1.append(r3)
            r1.append(r15)
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x019e:
            r18 = r10
            r19 = r11
            r17 = r12
            r0 = 0
        L_0x01a5:
            b5.b r3 = b5.b.PREFER_ARGB_8888
            r10 = r26
            if (r10 == r3) goto L_0x01e0
            r3 = r18
            r11 = r19
            com.bumptech.glide.load.ImageHeaderParser$ImageType r3 = b5.i.c(r3, r1, r11)     // Catch:{ IOException -> 0x01b8 }
            boolean r3 = r3.hasAlpha()     // Catch:{ IOException -> 0x01b8 }
            goto L_0x01c4
        L_0x01b8:
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r5, r3)
            if (r3 == 0) goto L_0x01c3
            java.util.Objects.toString(r26)
        L_0x01c3:
            r3 = 0
        L_0x01c4:
            if (r3 == 0) goto L_0x01c9
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x01cb
        L_0x01c9:
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.RGB_565
        L_0x01cb:
            r2.inPreferredConfig = r3
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.RGB_565
            if (r3 == r10) goto L_0x01dc
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_4444
            if (r3 == r10) goto L_0x01dc
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ALPHA_8
            if (r3 != r10) goto L_0x01da
            goto L_0x01dc
        L_0x01da:
            r3 = 1
            goto L_0x01e5
        L_0x01dc:
            r3 = 1
            r2.inDither = r3
            goto L_0x01e5
        L_0x01e0:
            r3 = 1
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            r2.inPreferredConfig = r10
        L_0x01e5:
            int r10 = android.os.Build.VERSION.SDK_INT
            int r11 = r2.inSampleSize
            if (r29 == 0) goto L_0x01ec
            goto L_0x0222
        L_0x01ec:
            int r7 = r2.inTargetDensity
            if (r7 <= 0) goto L_0x01f7
            int r12 = r2.inDensity
            if (r12 <= 0) goto L_0x01f7
            if (r7 == r12) goto L_0x01f7
            r0 = 1
        L_0x01f7:
            if (r0 == 0) goto L_0x01ff
            float r0 = (float) r7
            int r3 = r2.inDensity
            float r3 = (float) r3
            float r16 = r0 / r3
        L_0x01ff:
            float r0 = (float) r8
            float r3 = (float) r11
            float r0 = r0 / r3
            double r7 = (double) r0
            double r7 = java.lang.Math.ceil(r7)
            int r0 = (int) r7
            float r7 = (float) r9
            float r7 = r7 / r3
            double r7 = (double) r7
            double r7 = java.lang.Math.ceil(r7)
            int r3 = (int) r7
            float r0 = (float) r0
            float r0 = r0 * r16
            int r15 = java.lang.Math.round(r0)
            float r0 = (float) r3
            float r0 = r0 * r16
            int r7 = java.lang.Math.round(r0)
            r0 = 2
            android.util.Log.isLoggable(r5, r0)
        L_0x0222:
            if (r15 <= 0) goto L_0x023b
            if (r7 <= 0) goto L_0x023b
            r0 = 26
            if (r10 < r0) goto L_0x0233
            android.graphics.Bitmap$Config r0 = r2.inPreferredConfig
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.HARDWARE
            if (r0 != r3) goto L_0x0233
            goto L_0x023b
        L_0x0233:
            android.graphics.Bitmap$Config r0 = r2.inPreferredConfig
            android.graphics.Bitmap r0 = r6.d(r15, r7, r0)
            r2.inBitmap = r0
        L_0x023b:
            android.graphics.Bitmap r0 = c(r1, r2, r4, r6)
            r30.getClass()
            r1 = 2
            boolean r1 = android.util.Log.isLoggable(r5, r1)
            if (r1 == 0) goto L_0x025b
            d(r0)
            android.graphics.Bitmap r1 = r2.inBitmap
            d(r1)
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.getName()
            android.os.SystemClock.elapsedRealtimeNanos()
        L_0x025b:
            if (r0 == 0) goto L_0x0276
            r1 = r22
            android.util.DisplayMetrics r2 = r1.f171b
            int r2 = r2.densityDpi
            r0.setDensity(r2)
            r2 = r17
            android.graphics.Bitmap r2 = k5.g0.e(r6, r0, r2)
            boolean r3 = r0.equals(r2)
            if (r3 != 0) goto L_0x0279
            r6.c(r0)
            goto L_0x0279
        L_0x0276:
            r1 = r22
            r2 = 0
        L_0x0279:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.l.b(java.io.InputStream, android.graphics.BitmapFactory$Options, k5.t, b5.b, int, int, boolean, a5.k):android.graphics.Bitmap");
    }
}
