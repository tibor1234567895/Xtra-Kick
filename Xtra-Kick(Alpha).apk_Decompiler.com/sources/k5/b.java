package k5;

import b5.c;
import b5.m;
import b5.n;
import b5.q;
import e5.k;

public final class b implements q {

    /* renamed from: i  reason: collision with root package name */
    public static final m f9126i = m.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: j  reason: collision with root package name */
    public static final m f9127j = new m("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", (Object) null, m.f2630e);

    /* renamed from: h  reason: collision with root package name */
    public final k f9128h;

    @Deprecated
    public b() {
        this.f9128h = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.bumptech.glide.load.data.c} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084 A[SYNTHETIC, Splitter:B:40:0x0084] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.lang.Object r7, java.io.File r8, b5.n r9) {
        /*
            r6 = this;
            d5.o0 r7 = (d5.o0) r7
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r7 = r7.get()
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
            b5.m r1 = f9127j
            java.lang.Object r2 = r9.c(r1)
            android.graphics.Bitmap$CompressFormat r2 = (android.graphics.Bitmap.CompressFormat) r2
            if (r2 == 0) goto L_0x0015
            goto L_0x0020
        L_0x0015:
            boolean r2 = r7.hasAlpha()
            if (r2 == 0) goto L_0x001e
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG
            goto L_0x0020
        L_0x001e:
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
        L_0x0020:
            r7.getWidth()
            r7.getHeight()
            int r3 = w5.i.f16115a
            android.os.SystemClock.elapsedRealtimeNanos()
            b5.m r3 = f9126i
            java.lang.Object r3 = r9.c(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = 0
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0059 }
            r5.<init>(r8)     // Catch:{ IOException -> 0x0059 }
            e5.k r8 = r6.f9128h
            if (r8 == 0) goto L_0x004b
            com.bumptech.glide.load.data.c r4 = new com.bumptech.glide.load.data.c     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            r4.<init>(r5, r8)     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            goto L_0x004c
        L_0x0047:
            r7 = move-exception
            goto L_0x0082
        L_0x0049:
            r4 = r5
            goto L_0x0059
        L_0x004b:
            r4 = r5
        L_0x004c:
            r7.compress(r2, r3, r4)     // Catch:{ IOException -> 0x0059 }
            r4.close()     // Catch:{ IOException -> 0x0059 }
            r4.close()     // Catch:{ IOException -> 0x0055, all -> 0x0063 }
        L_0x0055:
            r8 = 1
            goto L_0x0066
        L_0x0057:
            r7 = move-exception
            goto L_0x0081
        L_0x0059:
            r8 = 3
            android.util.Log.isLoggable(r0, r8)     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0065
            r4.close()     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
            goto L_0x0065
        L_0x0063:
            r7 = move-exception
            goto L_0x0088
        L_0x0065:
            r8 = 0
        L_0x0066:
            r3 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r3)
            if (r0 == 0) goto L_0x0080
            java.util.Objects.toString(r2)
            w5.p.c(r7)
            android.os.SystemClock.elapsedRealtimeNanos()
            java.lang.Object r9 = r9.c(r1)
            java.util.Objects.toString(r9)
            r7.hasAlpha()
        L_0x0080:
            return r8
        L_0x0081:
            r5 = r4
        L_0x0082:
            if (r5 == 0) goto L_0x0089
            r5.close()     // Catch:{ IOException -> 0x0089, all -> 0x0063 }
            goto L_0x0089
        L_0x0088:
            throw r7
        L_0x0089:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.b.c(java.lang.Object, java.io.File, b5.n):boolean");
    }

    public final c g(n nVar) {
        return c.TRANSFORMED;
    }

    public b(k kVar) {
        this.f9128h = kVar;
    }
}
