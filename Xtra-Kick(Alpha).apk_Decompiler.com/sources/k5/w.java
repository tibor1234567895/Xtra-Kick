package k5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.u;
import android.util.DisplayMetrics;
import b5.b;
import b5.m;
import b5.o;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import e5.c;
import e5.k;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import w5.n;
import w5.p;

public final class w {

    /* renamed from: f  reason: collision with root package name */
    public static final m f9183f = m.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.PREFER_ARGB_8888);

    /* renamed from: g  reason: collision with root package name */
    public static final m f9184g = new m("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", (Object) null, m.f2630e);

    /* renamed from: h  reason: collision with root package name */
    public static final m f9185h = t.f9174f;

    /* renamed from: i  reason: collision with root package name */
    public static final m f9186i;

    /* renamed from: j  reason: collision with root package name */
    public static final m f9187j;

    /* renamed from: k  reason: collision with root package name */
    public static final Set f9188k = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: l  reason: collision with root package name */
    public static final u f9189l = new u();

    /* renamed from: m  reason: collision with root package name */
    public static final ArrayDeque f9190m = new ArrayDeque(0);

    /* renamed from: a  reason: collision with root package name */
    public final c f9191a;

    /* renamed from: b  reason: collision with root package name */
    public final DisplayMetrics f9192b;

    /* renamed from: c  reason: collision with root package name */
    public final k f9193c;

    /* renamed from: d  reason: collision with root package name */
    public final List f9194d;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f9195e;

    static {
        Boolean bool = Boolean.FALSE;
        f9186i = m.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f9187j = m.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = p.f16126a;
    }

    public w(ArrayList arrayList, DisplayMetrics displayMetrics, c cVar, k kVar) {
        if (c0.f9134j == null) {
            synchronized (c0.class) {
                if (c0.f9134j == null) {
                    c0.f9134j = new c0();
                }
            }
        }
        this.f9195e = c0.f9134j;
        this.f9194d = arrayList;
        n.b(displayMetrics);
        this.f9192b = displayMetrics;
        n.b(cVar);
        this.f9191a = cVar;
        n.b(kVar);
        this.f9193c = kVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0054 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap c(android.support.v4.media.session.u r4, android.graphics.BitmapFactory.Options r5, k5.v r6, e5.c r7) {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto L_0x0020
            r6.d()
            int r0 = r4.f427h
            switch(r0) {
                case 21: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0020
        L_0x000d:
            java.lang.Object r0 = r4.f428i
            com.bumptech.glide.load.data.p r0 = (com.bumptech.glide.load.data.p) r0
            java.lang.Object r0 = r0.f3241b
            k5.e0 r0 = (k5.e0) r0
            monitor-enter(r0)
            byte[] r1 = r0.f9146h     // Catch:{ all -> 0x001d }
            int r1 = r1.length     // Catch:{ all -> 0x001d }
            r0.f9148j = r1     // Catch:{ all -> 0x001d }
            monitor-exit(r0)
            goto L_0x0020
        L_0x001d:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x0020:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = k5.g0.f9158d
            r3.lock()
            android.graphics.Bitmap r4 = r4.n(r5)     // Catch:{ IllegalArgumentException -> 0x0033 }
            r3.unlock()
            return r4
        L_0x0033:
            r3 = move-exception
            java.io.IOException r0 = e(r3, r0, r1, r2, r5)     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x0052 }
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0055
            r7.c(r1)     // Catch:{ IOException -> 0x0054 }
            r1 = 0
            r5.inBitmap = r1     // Catch:{ IOException -> 0x0054 }
            android.graphics.Bitmap r4 = c(r4, r5, r6, r7)     // Catch:{ IOException -> 0x0054 }
            java.util.concurrent.locks.Lock r5 = k5.g0.f9158d
            r5.unlock()
            return r4
        L_0x0052:
            r4 = move-exception
            goto L_0x0056
        L_0x0054:
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0055:
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0056:
            java.util.concurrent.locks.Lock r5 = k5.g0.f9158d
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.w.c(android.support.v4.media.session.u, android.graphics.BitmapFactory$Options, k5.v, e5.c):android.graphics.Bitmap");
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
        ArrayDeque arrayDeque = f9190m;
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
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final d a(u uVar, int i10, int i11, b5.n nVar, v vVar) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        boolean z10;
        b5.n nVar2 = nVar;
        byte[] bArr = (byte[]) this.f9193c.d(65536, byte[].class);
        synchronized (w.class) {
            ArrayDeque arrayDeque = f9190m;
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
        b bVar = (b) nVar2.c(f9183f);
        o oVar = (o) nVar2.c(f9184g);
        t tVar = (t) nVar2.c(t.f9174f);
        boolean booleanValue = ((Boolean) nVar2.c(f9186i)).booleanValue();
        m mVar = f9187j;
        if (nVar2.c(mVar) == null || !((Boolean) nVar2.c(mVar)).booleanValue()) {
            z10 = false;
        } else {
            z10 = true;
        }
        try {
            return d.c(b(uVar, options2, tVar, bVar, oVar, z10, i10, i11, booleanValue, vVar), this.f9191a);
        } finally {
            f(options2);
            this.f9193c.h(bArr);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(android.support.v4.media.session.u r28, android.graphics.BitmapFactory.Options r29, k5.t r30, b5.b r31, b5.o r32, boolean r33, int r34, int r35, boolean r36, k5.v r37) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r32
            r5 = r37
            int r6 = w5.i.f16115a
            android.os.SystemClock.elapsedRealtimeNanos()
            r6 = 1
            r2.inJustDecodeBounds = r6
            e5.c r7 = r0.f9191a
            c(r1, r2, r5, r7)
            r8 = 0
            r2.inJustDecodeBounds = r8
            int r9 = r2.outWidth
            int r10 = r2.outHeight
            r11 = -1
            if (r9 == r11) goto L_0x0029
            if (r10 != r11) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r12 = r33
            goto L_0x002a
        L_0x0029:
            r12 = 0
        L_0x002a:
            int r13 = r1.f427h
            r14 = 24
            switch(r13) {
                case 20: goto L_0x004a;
                case 21: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x0068
        L_0x0032:
            java.lang.Object r11 = r1.f430k
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r13 = r1.f428i
            com.bumptech.glide.load.data.p r13 = (com.bumptech.glide.load.data.p) r13
            java.lang.Object r13 = r13.f3241b
            k5.e0 r13 = (k5.e0) r13
            r13.reset()
            java.lang.Object r15 = r1.f429j
            e5.k r15 = (e5.k) r15
            int r11 = b5.i.a(r15, r13, r11)
            goto L_0x007d
        L_0x004a:
            java.lang.Object r13 = r1.f429j
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r15 = r1.f428i
            java.nio.ByteBuffer r15 = (java.nio.ByteBuffer) r15
            java.nio.ByteBuffer r15 = w5.a.c(r15)
            java.lang.Object r11 = r1.f430k
            e5.k r11 = (e5.k) r11
            if (r15 != 0) goto L_0x005e
            r11 = -1
            goto L_0x007d
        L_0x005e:
            android.support.v4.media.n r8 = new android.support.v4.media.n
            r8.<init>((java.lang.Object) r15, (int) r14, (java.lang.Object) r11)
            int r11 = b5.i.b(r13, r8)
            goto L_0x007d
        L_0x0068:
            java.lang.Object r8 = r1.f429j
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r11 = r1.f430k
            com.bumptech.glide.load.data.p r11 = (com.bumptech.glide.load.data.p) r11
            java.lang.Object r13 = r1.f428i
            e5.k r13 = (e5.k) r13
            b5.g r15 = new b5.g
            r15.<init>(r11, r13)
            int r11 = b5.i.b(r8, r15)
        L_0x007d:
            int r8 = k5.g0.c(r11)
            boolean r13 = k5.g0.d(r11)
            r14 = 90
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r15 = r34
            if (r15 != r6) goto L_0x009f
            if (r8 == r14) goto L_0x0096
            r15 = 270(0x10e, float:3.78E-43)
            if (r8 != r15) goto L_0x0094
            goto L_0x0096
        L_0x0094:
            r15 = 0
            goto L_0x0097
        L_0x0096:
            r15 = 1
        L_0x0097:
            r14 = r35
            if (r15 == 0) goto L_0x009d
            r15 = r10
            goto L_0x00a1
        L_0x009d:
            r15 = r9
            goto L_0x00a1
        L_0x009f:
            r14 = r35
        L_0x00a1:
            if (r14 != r6) goto L_0x00b4
            r6 = 90
            if (r8 == r6) goto L_0x00ae
            r6 = 270(0x10e, float:3.78E-43)
            if (r8 != r6) goto L_0x00ac
            goto L_0x00ae
        L_0x00ac:
            r6 = 0
            goto L_0x00af
        L_0x00ae:
            r6 = 1
        L_0x00af:
            if (r6 == 0) goto L_0x00b3
            r14 = r9
            goto L_0x00b4
        L_0x00b3:
            r14 = r10
        L_0x00b4:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = r28.v()
            r18 = r11
            r19 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r11 = "Downsampler"
            if (r9 <= 0) goto L_0x025e
            if (r10 > 0) goto L_0x00c4
            goto L_0x025e
        L_0x00c4:
            r4 = 90
            if (r8 == r4) goto L_0x00cf
            r4 = 270(0x10e, float:3.78E-43)
            if (r8 != r4) goto L_0x00cd
            goto L_0x00cf
        L_0x00cd:
            r4 = 0
            goto L_0x00d0
        L_0x00cf:
            r4 = 1
        L_0x00d0:
            if (r4 == 0) goto L_0x00d5
            r8 = r9
            r4 = r10
            goto L_0x00d7
        L_0x00d5:
            r4 = r9
            r8 = r10
        L_0x00d7:
            r16 = r12
            float r12 = r3.b(r4, r8, r15, r14)
            r17 = 0
            int r17 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r17 <= 0) goto L_0x0215
            r17 = r13
            int r13 = r3.a(r4, r8, r15, r14)
            if (r13 == 0) goto L_0x020d
            float r0 = (float) r4
            r20 = r10
            float r10 = r12 * r0
            r21 = r9
            double r9 = (double) r10
            r22 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r9 = r9 + r22
            int r9 = (int) r9
            float r10 = (float) r8
            r24 = r11
            float r11 = r12 * r10
            r26 = r14
            r25 = r15
            double r14 = (double) r11
            double r14 = r14 + r22
            int r11 = (int) r14
            int r9 = r4 / r9
            int r11 = r8 / r11
            r14 = 1
            if (r13 != r14) goto L_0x0111
            int r9 = java.lang.Math.max(r9, r11)
            goto L_0x0115
        L_0x0111:
            int r9 = java.lang.Math.min(r9, r11)
        L_0x0115:
            int r11 = android.os.Build.VERSION.SDK_INT
            r14 = 23
            if (r11 > r14) goto L_0x0127
            java.util.Set r14 = f9188k
            java.lang.String r15 = r2.outMimeType
            boolean r14 = r14.contains(r15)
            if (r14 == 0) goto L_0x0127
            r9 = 1
            goto L_0x013b
        L_0x0127:
            int r9 = java.lang.Integer.highestOneBit(r9)
            r14 = 1
            int r9 = java.lang.Math.max(r14, r9)
            if (r13 != r14) goto L_0x013b
            float r13 = (float) r9
            float r12 = r19 / r12
            int r12 = (r13 > r12 ? 1 : (r13 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x013b
            int r9 = r9 << 1
        L_0x013b:
            r2.inSampleSize = r9
            com.bumptech.glide.load.ImageHeaderParser$ImageType r12 = com.bumptech.glide.load.ImageHeaderParser$ImageType.JPEG
            if (r6 != r12) goto L_0x015c
            r4 = 8
            int r6 = java.lang.Math.min(r9, r4)
            float r6 = (float) r6
            float r0 = r0 / r6
            double r11 = (double) r0
            double r11 = java.lang.Math.ceil(r11)
            int r0 = (int) r11
            float r10 = r10 / r6
            double r10 = (double) r10
            double r10 = java.lang.Math.ceil(r10)
            int r6 = (int) r10
            int r9 = r9 / r4
            if (r9 <= 0) goto L_0x01a6
            int r0 = r0 / r9
            int r6 = r6 / r9
            goto L_0x01a6
        L_0x015c:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r12 = com.bumptech.glide.load.ImageHeaderParser$ImageType.PNG
            if (r6 == r12) goto L_0x0197
            com.bumptech.glide.load.ImageHeaderParser$ImageType r12 = com.bumptech.glide.load.ImageHeaderParser$ImageType.PNG_A
            if (r6 != r12) goto L_0x0165
            goto L_0x0197
        L_0x0165:
            boolean r6 = r6.isWebp()
            if (r6 == 0) goto L_0x017b
            r6 = 24
            if (r11 < r6) goto L_0x0197
            float r4 = (float) r9
            float r0 = r0 / r4
            int r0 = java.lang.Math.round(r0)
            float r10 = r10 / r4
            int r6 = java.lang.Math.round(r10)
            goto L_0x01a6
        L_0x017b:
            int r0 = r4 % r9
            if (r0 != 0) goto L_0x0189
            int r0 = r8 % r9
            if (r0 == 0) goto L_0x0184
            goto L_0x0189
        L_0x0184:
            int r0 = r4 / r9
            int r6 = r8 / r9
            goto L_0x01a6
        L_0x0189:
            r0 = 1
            r2.inJustDecodeBounds = r0
            c(r1, r2, r5, r7)
            r0 = 0
            r2.inJustDecodeBounds = r0
            int r0 = r2.outWidth
            int r4 = r2.outHeight
            goto L_0x01a7
        L_0x0197:
            float r4 = (float) r9
            float r0 = r0 / r4
            double r8 = (double) r0
            double r8 = java.lang.Math.floor(r8)
            int r0 = (int) r8
            float r10 = r10 / r4
            double r8 = (double) r10
            double r8 = java.lang.Math.floor(r8)
            int r6 = (int) r8
        L_0x01a6:
            r4 = r6
        L_0x01a7:
            r10 = r25
            r9 = r26
            float r0 = r3.b(r0, r4, r10, r9)
            double r3 = (double) r0
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 > 0) goto L_0x01b8
            r13 = r3
            goto L_0x01ba
        L_0x01b8:
            double r13 = r11 / r3
        L_0x01ba:
            r25 = 4746794007244308480(0x41dfffffffc00000, double:2.147483647E9)
            double r13 = r13 * r25
            long r13 = java.lang.Math.round(r13)
            int r6 = (int) r13
            double r13 = (double) r6
            double r13 = r13 * r3
            double r13 = r13 + r22
            int r8 = (int) r13
            float r13 = (float) r8
            float r6 = (float) r6
            float r13 = r13 / r6
            double r13 = (double) r13
            double r13 = r3 / r13
            double r11 = (double) r8
            double r13 = r13 * r11
            double r13 = r13 + r22
            int r6 = (int) r13
            r2.inTargetDensity = r6
            if (r0 > 0) goto L_0x01dd
            goto L_0x01e1
        L_0x01dd:
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r11 / r3
        L_0x01e1:
            double r3 = r3 * r25
            long r3 = java.lang.Math.round(r3)
            int r0 = (int) r3
            r2.inDensity = r0
            int r3 = r2.inTargetDensity
            if (r3 <= 0) goto L_0x01f4
            if (r0 <= 0) goto L_0x01f4
            if (r3 == r0) goto L_0x01f4
            r0 = 1
            goto L_0x01f5
        L_0x01f4:
            r0 = 0
        L_0x01f5:
            if (r0 == 0) goto L_0x01fb
            r0 = 1
            r2.inScaled = r0
            goto L_0x0200
        L_0x01fb:
            r0 = 0
            r2.inTargetDensity = r0
            r2.inDensity = r0
        L_0x0200:
            r3 = r24
            r0 = 2
            android.util.Log.isLoggable(r3, r0)
            r0 = r27
            r8 = r20
            r4 = r21
            goto L_0x0273
        L_0x020d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot round with null rounding"
            r0.<init>(r1)
            throw r0
        L_0x0215:
            r21 = r9
            r20 = r10
            r9 = r14
            r10 = r15
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
            r4 = r21
            r1.append(r4)
            java.lang.String r2 = "x"
            r1.append(r2)
            r8 = r20
            r1.append(r8)
            java.lang.String r3 = "], target: ["
            r1.append(r3)
            r1.append(r10)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x025e:
            r4 = r9
            r8 = r10
            r3 = r11
            r16 = r12
            r17 = r13
            r9 = r14
            r10 = r15
            r0 = 3
            boolean r11 = android.util.Log.isLoggable(r3, r0)
            if (r11 == 0) goto L_0x0271
            java.util.Objects.toString(r6)
        L_0x0271:
            r0 = r27
        L_0x0273:
            k5.c0 r6 = r0.f9195e
            r12 = r16
            r11 = r17
            boolean r6 = r6.a(r10, r9, r12, r11)
            if (r6 == 0) goto L_0x0289
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.HARDWARE
            r2.inPreferredConfig = r11
            r14 = 0
            r2.inMutable = r14
            goto L_0x028a
        L_0x0289:
            r14 = 0
        L_0x028a:
            if (r6 == 0) goto L_0x028e
        L_0x028c:
            r6 = 1
            goto L_0x02bf
        L_0x028e:
            b5.b r6 = b5.b.PREFER_ARGB_8888
            r11 = r31
            if (r11 == r6) goto L_0x02ba
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = r28.v()     // Catch:{ IOException -> 0x029d }
            boolean r6 = r6.hasAlpha()     // Catch:{ IOException -> 0x029d }
            goto L_0x02a9
        L_0x029d:
            r6 = 3
            boolean r6 = android.util.Log.isLoggable(r3, r6)
            if (r6 == 0) goto L_0x02a8
            java.util.Objects.toString(r31)
        L_0x02a8:
            r6 = 0
        L_0x02a9:
            if (r6 == 0) goto L_0x02ae
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x02b0
        L_0x02ae:
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565
        L_0x02b0:
            r2.inPreferredConfig = r6
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.RGB_565
            if (r6 != r11) goto L_0x028c
            r6 = 1
            r2.inDither = r6
            goto L_0x02bf
        L_0x02ba:
            r6 = 1
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.ARGB_8888
            r2.inPreferredConfig = r11
        L_0x02bf:
            int r11 = android.os.Build.VERSION.SDK_INT
            int r12 = r2.inSampleSize
            if (r4 < 0) goto L_0x02cb
            if (r8 < 0) goto L_0x02cb
            if (r36 == 0) goto L_0x02cb
            r15 = r10
            goto L_0x0304
        L_0x02cb:
            int r9 = r2.inTargetDensity
            if (r9 <= 0) goto L_0x02d7
            int r10 = r2.inDensity
            if (r10 <= 0) goto L_0x02d7
            if (r9 == r10) goto L_0x02d7
            r10 = 1
            goto L_0x02d8
        L_0x02d7:
            r10 = 0
        L_0x02d8:
            if (r10 == 0) goto L_0x02e0
            float r9 = (float) r9
            int r10 = r2.inDensity
            float r10 = (float) r10
            float r19 = r9 / r10
        L_0x02e0:
            float r4 = (float) r4
            float r9 = (float) r12
            float r4 = r4 / r9
            double r12 = (double) r4
            double r12 = java.lang.Math.ceil(r12)
            int r4 = (int) r12
            float r8 = (float) r8
            float r8 = r8 / r9
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r8 = (int) r8
            float r4 = (float) r4
            float r4 = r4 * r19
            int r15 = java.lang.Math.round(r4)
            float r4 = (float) r8
            float r4 = r4 * r19
            int r4 = java.lang.Math.round(r4)
            r8 = 2
            android.util.Log.isLoggable(r3, r8)
            r9 = r4
        L_0x0304:
            r4 = 26
            r8 = 0
            if (r15 <= 0) goto L_0x0326
            if (r9 <= 0) goto L_0x0326
            if (r11 < r4) goto L_0x031b
            android.graphics.Bitmap$Config r10 = r2.inPreferredConfig
            android.graphics.Bitmap$Config r12 = android.graphics.Bitmap.Config.HARDWARE
            if (r10 != r12) goto L_0x0316
            goto L_0x0326
        L_0x0316:
            android.graphics.Bitmap$Config r10 = r29.outConfig
            goto L_0x031c
        L_0x031b:
            r10 = r8
        L_0x031c:
            if (r10 != 0) goto L_0x0320
            android.graphics.Bitmap$Config r10 = r2.inPreferredConfig
        L_0x0320:
            android.graphics.Bitmap r9 = r7.d(r15, r9, r10)
            r2.inBitmap = r9
        L_0x0326:
            r9 = r32
            if (r9 == 0) goto L_0x0364
            r10 = 28
            if (r11 < r10) goto L_0x0357
            b5.o r4 = b5.o.DISPLAY_P3
            if (r9 != r4) goto L_0x0343
            android.graphics.ColorSpace r4 = r29.outColorSpace
            if (r4 == 0) goto L_0x0343
            android.graphics.ColorSpace r4 = r29.outColorSpace
            boolean r4 = r4.isWideGamut()
            if (r4 == 0) goto L_0x0343
            goto L_0x0344
        L_0x0343:
            r6 = 0
        L_0x0344:
            if (r6 == 0) goto L_0x034b
            android.graphics.ColorSpace$Named r4 = android.graphics.ColorSpace.Named.DISPLAY_P3
            goto L_0x034f
        L_0x034b:
            android.graphics.ColorSpace$Named r4 = android.graphics.ColorSpace.Named.SRGB
        L_0x034f:
            android.graphics.ColorSpace r4 = android.graphics.ColorSpace.get(r4)
            r2.inPreferredColorSpace = r4
            goto L_0x0364
        L_0x0357:
            if (r11 < r4) goto L_0x0364
            android.graphics.ColorSpace$Named r4 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r4 = android.graphics.ColorSpace.get(r4)
            r2.inPreferredColorSpace = r4
        L_0x0364:
            android.graphics.Bitmap r1 = c(r1, r2, r5, r7)
            r5.b(r1, r7)
            r4 = 2
            boolean r3 = android.util.Log.isLoggable(r3, r4)
            if (r3 == 0) goto L_0x0384
            d(r1)
            android.graphics.Bitmap r2 = r2.inBitmap
            d(r2)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.getName()
            android.os.SystemClock.elapsedRealtimeNanos()
        L_0x0384:
            if (r1 == 0) goto L_0x039c
            android.util.DisplayMetrics r2 = r0.f9192b
            int r2 = r2.densityDpi
            r1.setDensity(r2)
            r11 = r18
            android.graphics.Bitmap r8 = k5.g0.e(r7, r1, r11)
            boolean r2 = r1.equals(r8)
            if (r2 != 0) goto L_0x039c
            r7.c(r1)
        L_0x039c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.w.b(android.support.v4.media.session.u, android.graphics.BitmapFactory$Options, k5.t, b5.b, b5.o, boolean, int, int, boolean, k5.v):android.graphics.Bitmap");
    }
}
