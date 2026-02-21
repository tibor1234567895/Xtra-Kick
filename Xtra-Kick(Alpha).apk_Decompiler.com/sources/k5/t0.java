package k5;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.support.v4.media.h;
import b5.m;
import b5.n;
import b5.p;
import d5.o0;
import e5.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class t0 implements p {

    /* renamed from: d  reason: collision with root package name */
    public static final m f9176d = new m("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new k0());

    /* renamed from: e  reason: collision with root package name */
    public static final m f9177e = new m("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new l0());

    /* renamed from: f  reason: collision with root package name */
    public static final q0 f9178f = new q0();

    /* renamed from: g  reason: collision with root package name */
    public static final List f9179g = Collections.unmodifiableList(Arrays.asList(new String[]{"TP1A", "TD1A.220804.031"}));

    /* renamed from: a  reason: collision with root package name */
    public final p0 f9180a;

    /* renamed from: b  reason: collision with root package name */
    public final c f9181b;

    /* renamed from: c  reason: collision with root package name */
    public final q0 f9182c = f9178f;

    public t0(c cVar, p0 p0Var) {
        this.f9181b = cVar;
        this.f9180a = p0Var;
    }

    public final boolean a(Object obj, n nVar) {
        return true;
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        int i12;
        long longValue = ((Long) nVar.c(f9176d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) nVar.c(f9177e);
            if (num == null) {
                num = 2;
            }
            t tVar = (t) nVar.c(t.f9174f);
            if (tVar == null) {
                tVar = t.f9173e;
            }
            t tVar2 = tVar;
            this.f9182c.getClass();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                this.f9180a.a(mediaMetadataRetriever, obj);
                Bitmap c10 = c(obj, mediaMetadataRetriever, longValue, num.intValue(), i10, i11, tVar2);
                if (i12 < 29) {
                    mediaMetadataRetriever.release();
                }
                return d.c(c10, this.f9181b);
            } finally {
                if (Build.VERSION.SDK_INT >= 29) {
                    mediaMetadataRetriever.close();
                } else {
                    mediaMetadataRetriever.release();
                }
            }
        } else {
            throw new IllegalArgumentException(h.k("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", longValue));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        android.util.Log.isLoggable("VideoDecoder", 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        if (r4 == null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x018e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x018f, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0190, code lost:
        if (r4 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0192, code lost:
        r4.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0195, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0064 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x017f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap c(java.lang.Object r17, android.media.MediaMetadataRetriever r18, long r19, int r21, int r22, int r23, k5.t r24) {
        /*
            r16 = this;
            r0 = r18
            r1 = r22
            r2 = r23
            r3 = r24
            java.lang.String r4 = android.os.Build.DEVICE
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x0018
            java.lang.String r5 = ".+_cheets|cheets_.+"
            boolean r4 = r4.matches(r5)
            if (r4 == 0) goto L_0x0018
            r4 = 1
            goto L_0x0019
        L_0x0018:
            r4 = 0
        L_0x0019:
            r9 = 3
            java.lang.String r10 = "VideoDecoder"
            r11 = 0
            if (r4 != 0) goto L_0x0020
            goto L_0x002e
        L_0x0020:
            r4 = 12
            java.lang.String r4 = r0.extractMetadata(r4)     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "video/webm"
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x0061 }
            if (r4 != 0) goto L_0x0032
        L_0x002e:
            r4 = 0
            r12 = r16
            goto L_0x006d
        L_0x0032:
            android.media.MediaExtractor r4 = new android.media.MediaExtractor     // Catch:{ all -> 0x0061 }
            r4.<init>()     // Catch:{ all -> 0x0061 }
            r12 = r16
            k5.p0 r5 = r12.f9180a     // Catch:{ all -> 0x0064 }
            r6 = r17
            r5.b(r4, r6)     // Catch:{ all -> 0x0064 }
            int r5 = r4.getTrackCount()     // Catch:{ all -> 0x0064 }
            r6 = 0
        L_0x0045:
            if (r6 >= r5) goto L_0x0069
            android.media.MediaFormat r13 = r4.getTrackFormat(r6)     // Catch:{ all -> 0x0064 }
            java.lang.String r14 = "mime"
            java.lang.String r13 = r13.getString(r14)     // Catch:{ all -> 0x0064 }
            java.lang.String r14 = "video/x-vnd.on2.vp8"
            boolean r13 = r14.equals(r13)     // Catch:{ all -> 0x0064 }
            if (r13 == 0) goto L_0x005e
            r4.release()
            r4 = 1
            goto L_0x006d
        L_0x005e:
            int r6 = r6 + 1
            goto L_0x0045
        L_0x0061:
            r12 = r16
            r4 = r11
        L_0x0064:
            android.util.Log.isLoggable(r10, r9)     // Catch:{ all -> 0x018e }
            if (r4 == 0) goto L_0x006c
        L_0x0069:
            r4.release()
        L_0x006c:
            r4 = 0
        L_0x006d:
            if (r4 != 0) goto L_0x0186
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 27
            r13 = 24
            if (r4 < r5) goto L_0x00ca
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r4) goto L_0x00ca
            if (r2 == r4) goto L_0x00ca
            k5.s r4 = k5.t.f9172d
            if (r3 == r4) goto L_0x00ca
            r4 = 18
            java.lang.String r4 = r0.extractMetadata(r4)     // Catch:{ all -> 0x00c7 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ all -> 0x00c7 }
            r5 = 19
            java.lang.String r5 = r0.extractMetadata(r5)     // Catch:{ all -> 0x00c7 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r0.extractMetadata(r13)     // Catch:{ all -> 0x00c7 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ all -> 0x00c7 }
            r14 = 90
            if (r6 == r14) goto L_0x00a5
            r14 = 270(0x10e, float:3.78E-43)
            if (r6 != r14) goto L_0x00a8
        L_0x00a5:
            r15 = r5
            r5 = r4
            r4 = r15
        L_0x00a8:
            float r1 = r3.b(r4, r5, r1, r2)     // Catch:{ all -> 0x00c7 }
            float r2 = (float) r4     // Catch:{ all -> 0x00c7 }
            float r2 = r2 * r1
            int r6 = java.lang.Math.round(r2)     // Catch:{ all -> 0x00c7 }
            float r2 = (float) r5     // Catch:{ all -> 0x00c7 }
            float r1 = r1 * r2
            int r14 = java.lang.Math.round(r1)     // Catch:{ all -> 0x00c7 }
            r1 = r18
            r2 = r19
            r4 = r21
            r5 = r6
            r6 = r14
            android.graphics.Bitmap r11 = r1.getScaledFrameAtTime(r2, r4, r5, r6)     // Catch:{ all -> 0x00c7 }
            goto L_0x00ca
        L_0x00c7:
            android.util.Log.isLoggable(r10, r9)
        L_0x00ca:
            if (r11 != 0) goto L_0x00d0
            android.graphics.Bitmap r11 = r18.getFrameAtTime(r19, r21)
        L_0x00d0:
            java.lang.String r1 = android.os.Build.MODEL
            java.lang.String r2 = "Pixel"
            boolean r1 = r1.startsWith(r2)
            r2 = 33
            if (r1 == 0) goto L_0x00fb
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 != r2) goto L_0x00fb
            java.util.List r1 = f9179g
            java.util.Iterator r1 = r1.iterator()
        L_0x00e6:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0105
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = android.os.Build.ID
            boolean r2 = r3.startsWith(r2)
            if (r2 == 0) goto L_0x00e6
            goto L_0x0103
        L_0x00fb:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r1 < r3) goto L_0x0105
            if (r1 >= r2) goto L_0x0105
        L_0x0103:
            r1 = 1
            goto L_0x0106
        L_0x0105:
            r1 = 0
        L_0x0106:
            if (r1 != 0) goto L_0x010a
            goto L_0x017d
        L_0x010a:
            r1 = 36
            java.lang.String r1 = r0.extractMetadata(r1)     // Catch:{ NumberFormatException -> 0x013f }
            r2 = 35
            java.lang.String r2 = r0.extractMetadata(r2)     // Catch:{ NumberFormatException -> 0x013f }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x013f }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x013f }
            r3 = 7
            r4 = 6
            if (r1 == r3) goto L_0x0124
            if (r1 != r4) goto L_0x0128
        L_0x0124:
            if (r2 != r4) goto L_0x0128
            r1 = 1
            goto L_0x0129
        L_0x0128:
            r1 = 0
        L_0x0129:
            if (r1 == 0) goto L_0x0142
            java.lang.String r0 = r0.extractMetadata(r13)     // Catch:{ NumberFormatException -> 0x013f }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x013f }
            int r0 = java.lang.Math.abs(r0)     // Catch:{ NumberFormatException -> 0x013f }
            r1 = 180(0xb4, float:2.52E-43)
            if (r0 != r1) goto L_0x013c
            goto L_0x013d
        L_0x013c:
            r7 = 0
        L_0x013d:
            r8 = r7
            goto L_0x0142
        L_0x013f:
            android.util.Log.isLoggable(r10, r9)
        L_0x0142:
            if (r8 != 0) goto L_0x0145
            goto L_0x017d
        L_0x0145:
            android.util.Log.isLoggable(r10, r9)
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            int r1 = r11.getWidth()
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            int r3 = r11.getHeight()
            float r3 = (float) r3
            float r3 = r3 / r2
            r2 = 1127481344(0x43340000, float:180.0)
            r0.postRotate(r2, r1, r3)
            r1 = 0
            r2 = 0
            int r3 = r11.getWidth()
            int r4 = r11.getHeight()
            r5 = 1
            r17 = r11
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            r22 = r0
            r23 = r5
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r17, r18, r19, r20, r21, r22, r23)
        L_0x017d:
            if (r11 == 0) goto L_0x0180
            return r11
        L_0x0180:
            k5.s0 r0 = new k5.s0
            r0.<init>()
            throw r0
        L_0x0186:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Cannot decode VP8 video on CrOS."
            r0.<init>(r1)
            throw r0
        L_0x018e:
            r0 = move-exception
            r1 = r0
            if (r4 == 0) goto L_0x0195
            r4.release()
        L_0x0195:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.t0.c(java.lang.Object, android.media.MediaMetadataRetriever, long, int, int, int, k5.t):android.graphics.Bitmap");
    }
}
