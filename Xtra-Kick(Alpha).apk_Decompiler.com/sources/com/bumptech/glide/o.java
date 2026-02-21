package com.bumptech.glide;

public final class o {
    private o() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x03a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.n a(com.bumptech.glide.c r28, java.util.List r29, q5.a r30) {
        /*
            r0 = r28
            r1 = r30
            e5.c r8 = r0.f3164h
            com.bumptech.glide.h r2 = r0.f3166j
            android.content.Context r9 = r2.getApplicationContext()
            b4.e0 r2 = r2.f3195h
            com.bumptech.glide.n r10 = new com.bumptech.glide.n
            r10.<init>()
            k5.m r3 = new k5.m
            r3.<init>()
            r5.c r4 = r10.f3299g
            monitor-enter(r4)
            java.util.ArrayList r5 = r4.f13823a     // Catch:{ all -> 0x03aa }
            r5.add(r3)     // Catch:{ all -> 0x03aa }
            monitor-exit(r4)
            int r11 = android.os.Build.VERSION.SDK_INT
            r3 = 27
            if (r11 < r3) goto L_0x002f
            k5.a0 r3 = new k5.a0
            r3.<init>()
            r10.j(r3)
        L_0x002f:
            android.content.res.Resources r12 = r9.getResources()
            java.util.ArrayList r3 = r10.f()
            o5.c r4 = new o5.c
            e5.k r5 = r0.f3167k
            r4.<init>(r9, r3, r8, r5)
            k5.t0 r6 = new k5.t0
            k5.r0 r7 = new k5.r0
            r7.<init>()
            r6.<init>(r8, r7)
            k5.w r7 = new k5.w
            java.util.ArrayList r13 = r10.f()
            android.util.DisplayMetrics r14 = r12.getDisplayMetrics()
            r7.<init>(r13, r14, r8, r5)
            r13 = 28
            r14 = 3
            r15 = 0
            if (r11 < r13) goto L_0x0072
            java.lang.Class<com.bumptech.glide.d> r13 = com.bumptech.glide.d.class
            java.lang.Object r2 = r2.f2538i
            java.util.Map r2 = (java.util.Map) r2
            boolean r2 = r2.containsKey(r13)
            if (r2 == 0) goto L_0x0072
            k5.d0 r2 = new k5.d0
            r2.<init>()
            k5.g r13 = new k5.g
            r13.<init>()
            goto L_0x007c
        L_0x0072:
            k5.f r13 = new k5.f
            r13.<init>(r7, r15)
            a5.e r2 = new a5.e
            r2.<init>(r7, r14, r5)
        L_0x007c:
            java.lang.String r14 = "Animation"
            java.lang.Class<java.nio.ByteBuffer> r15 = java.nio.ByteBuffer.class
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            java.lang.Class<java.io.InputStream> r0 = java.io.InputStream.class
            r17 = r4
            r4 = 28
            if (r11 < r4) goto L_0x00ad
            m5.a r4 = new m5.a
            r16 = r11
            k5.a r11 = new k5.a
            r18 = r12
            r12 = 2
            r11.<init>((java.lang.Object) r3, (int) r12, (java.lang.Object) r5)
            r12 = 1
            r4.<init>(r11, r12)
            r10.a(r4, r0, r1, r14)
            m5.a r4 = new m5.a
            k5.a r11 = new k5.a
            r12 = 2
            r11.<init>((java.lang.Object) r3, (int) r12, (java.lang.Object) r5)
            r12 = 0
            r4.<init>(r11, r12)
            r10.a(r4, r15, r1, r14)
            goto L_0x00b1
        L_0x00ad:
            r16 = r11
            r18 = r12
        L_0x00b1:
            m5.e r4 = new m5.e
            r4.<init>(r9)
            k5.b r11 = new k5.b
            r11.<init>(r5)
            p5.a r12 = new p5.a
            r12.<init>()
            r19 = r12
            p5.b r12 = new p5.b
            r12.<init>()
            r20 = r12
            android.content.ContentResolver r12 = r9.getContentResolver()
            r21 = r12
            h5.h r12 = new h5.h
            r12.<init>()
            r10.b(r15, r12)
            b4.e0 r12 = new b4.e0
            r22 = r9
            r9 = 11
            r12.<init>(r9, r5)
            r10.b(r0, r12)
            java.lang.Class<android.graphics.Bitmap> r9 = android.graphics.Bitmap.class
            java.lang.String r12 = "Bitmap"
            r10.a(r13, r15, r9, r12)
            r10.a(r2, r0, r9, r12)
            r23 = r1
            java.lang.String r1 = "robolectric"
            r24 = r4
            java.lang.String r4 = android.os.Build.FINGERPRINT
            boolean r1 = r1.equals(r4)
            r25 = r4
            r4 = 1
            r1 = r1 ^ r4
            java.lang.Class<android.os.ParcelFileDescriptor> r4 = android.os.ParcelFileDescriptor.class
            if (r1 == 0) goto L_0x010d
            k5.f r1 = new k5.f
            r26 = r14
            r14 = 1
            r1.<init>(r7, r14)
            r10.a(r1, r4, r9, r12)
            goto L_0x010f
        L_0x010d:
            r26 = r14
        L_0x010f:
            r10.a(r6, r4, r9, r12)
            k5.t0 r1 = new k5.t0
            k5.m0 r7 = new k5.m0
            r14 = 0
            r7.<init>(r14)
            r1.<init>(r8, r7)
            java.lang.Class<android.content.res.AssetFileDescriptor> r7 = android.content.res.AssetFileDescriptor.class
            r10.a(r1, r7, r9, r12)
            h5.w0 r1 = h5.w0.f7618a
            r10.d(r9, r9, r1)
            k5.i0 r14 = new k5.i0
            r14.<init>()
            r10.a(r14, r9, r9, r12)
            r10.c(r9, r11)
            a5.e r14 = new a5.e
            r27 = r7
            r7 = r18
            r14.<init>(r7, r13)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r13 = android.graphics.drawable.BitmapDrawable.class
            r18 = r9
            java.lang.String r9 = "BitmapDrawable"
            r10.a(r14, r15, r13, r9)
            a5.e r14 = new a5.e
            r14.<init>(r7, r2)
            r10.a(r14, r0, r13, r9)
            a5.e r2 = new a5.e
            r2.<init>(r7, r6)
            r10.a(r2, r4, r13, r9)
            k5.a r2 = new k5.a
            r6 = 0
            r2.<init>((java.lang.Object) r8, (int) r6, (java.lang.Object) r11)
            r10.c(r13, r2)
            o5.l r2 = new o5.l
            r6 = r17
            r2.<init>(r3, r6, r5)
            java.lang.Class<o5.e> r9 = o5.e.class
            r3 = r26
            r10.a(r2, r0, r9, r3)
            r10.a(r6, r15, r9, r3)
            o5.f r2 = new o5.f
            r2.<init>()
            r10.c(r9, r2)
            java.lang.Class<y4.a> r2 = y4.a.class
            r10.d(r2, r2, r1)
            a5.c r3 = new a5.c
            r6 = 1
            r3.<init>(r6, r8)
            r11 = r18
            r10.a(r3, r2, r11, r12)
            java.lang.Class<android.net.Uri> r2 = android.net.Uri.class
            java.lang.String r3 = "legacy_append"
            r12 = r23
            r6 = r24
            r10.a(r6, r2, r12, r3)
            a5.e r14 = new a5.e
            r17 = r9
            r9 = 2
            r14.<init>(r6, r9, r8)
            r10.a(r14, r2, r11, r3)
            l5.a r6 = new l5.a
            r6.<init>()
            r10.k(r6)
            h5.j r6 = new h5.j
            r6.<init>()
            java.lang.Class<java.io.File> r9 = java.io.File.class
            r10.d(r9, r15, r6)
            h5.w r6 = new h5.w
            r6.<init>()
            r10.d(r9, r0, r6)
            n5.a r6 = new n5.a
            r6.<init>()
            r10.a(r6, r9, r9, r3)
            h5.t r6 = new h5.t
            r6.<init>()
            r10.d(r9, r4, r6)
            r10.d(r9, r9, r1)
            com.bumptech.glide.load.data.n r6 = new com.bumptech.glide.load.data.n
            r6.<init>(r5)
            r10.k(r6)
            java.lang.String r5 = "robolectric"
            r6 = r25
            boolean r5 = r5.equals(r6)
            r6 = 1
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x01e5
            com.bumptech.glide.load.data.o r5 = new com.bumptech.glide.load.data.o
            r5.<init>()
            r10.k(r5)
        L_0x01e5:
            h5.n r5 = new h5.n
            r14 = r22
            r6 = 2
            r5.<init>(r14, r6)
            h5.n r6 = new h5.n
            r18 = r8
            r8 = 0
            r6.<init>(r14, r8)
            h5.n r8 = new h5.n
            r22 = r11
            r11 = 1
            r8.<init>(r14, r11)
            java.lang.Class r11 = java.lang.Integer.TYPE
            r10.d(r11, r0, r5)
            r23 = r13
            java.lang.Class<java.lang.Integer> r13 = java.lang.Integer.class
            r10.d(r13, r0, r5)
            r5 = r27
            r10.d(r11, r5, r6)
            r10.d(r13, r5, r6)
            r10.d(r11, r12, r8)
            r10.d(r13, r12, r8)
            h5.n r6 = new h5.n
            r8 = 5
            r6.<init>(r14, r8)
            r10.d(r2, r0, r6)
            h5.n r6 = new h5.n
            r8 = 4
            r6.<init>(r14, r8)
            r10.d(r2, r5, r6)
            h5.r0 r6 = new h5.r0
            r8 = 2
            r6.<init>(r7, r8)
            h5.r0 r8 = new h5.r0
            r24 = r3
            r3 = 0
            r8.<init>(r7, r3)
            h5.r0 r3 = new h5.r0
            r25 = r12
            r12 = 1
            r3.<init>(r7, r12)
            r10.d(r13, r2, r6)
            r10.d(r11, r2, r6)
            r10.d(r13, r5, r8)
            r10.d(r11, r5, r8)
            r10.d(r13, r0, r3)
            r10.d(r11, r0, r3)
            h5.m r3 = new h5.m
            r3.<init>()
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r10.d(r6, r0, r3)
            h5.m r3 = new h5.m
            r3.<init>()
            r10.d(r2, r0, r3)
            h5.u0 r3 = new h5.u0
            r3.<init>()
            r10.d(r6, r0, r3)
            h5.t0 r3 = new h5.t0
            r3.<init>()
            r10.d(r6, r4, r3)
            h5.s0 r3 = new h5.s0
            r3.<init>()
            r10.d(r6, r5, r3)
            h5.b r3 = new h5.b
            android.content.res.AssetManager r6 = r14.getAssets()
            r8 = 1
            r3.<init>(r6, r8)
            r10.d(r2, r0, r3)
            h5.b r3 = new h5.b
            android.content.res.AssetManager r6 = r14.getAssets()
            r8 = 0
            r3.<init>(r6, r8)
            r10.d(r2, r5, r3)
            h5.n r3 = new h5.n
            r6 = 6
            r3.<init>(r14, r6)
            r10.d(r2, r0, r3)
            h5.n r3 = new h5.n
            r6 = 7
            r3.<init>(r14, r6)
            r10.d(r2, r0, r3)
            r3 = 29
            r8 = r16
            if (r8 < r3) goto L_0x02c0
            i5.d r3 = new i5.d
            r6 = 1
            r3.<init>(r14, r6)
            r10.d(r2, r0, r3)
            i5.d r3 = new i5.d
            r11 = 0
            r3.<init>(r14, r11)
            r10.d(r2, r4, r3)
            goto L_0x02c2
        L_0x02c0:
            r6 = 1
            r11 = 0
        L_0x02c2:
            h5.y0 r3 = new h5.y0
            r12 = r21
            r13 = 2
            r3.<init>(r12, r13)
            r10.d(r2, r0, r3)
            h5.y0 r3 = new h5.y0
            r3.<init>(r12, r6)
            r10.d(r2, r4, r3)
            h5.y0 r3 = new h5.y0
            r3.<init>(r12, r11)
            r10.d(r2, r5, r3)
            h5.b1 r3 = new h5.b1
            r3.<init>()
            r10.d(r2, r0, r3)
            i5.g r3 = new i5.g
            r3.<init>()
            java.lang.Class<java.net.URL> r4 = java.net.URL.class
            r10.d(r4, r0, r3)
            h5.n r3 = new h5.n
            r4 = 3
            r3.<init>(r14, r4)
            r10.d(r2, r9, r3)
            i5.a r3 = new i5.a
            r3.<init>()
            java.lang.Class<h5.x> r4 = h5.x.class
            r10.d(r4, r0, r3)
            h5.d r3 = new h5.d
            r3.<init>()
            java.lang.Class<byte[]> r9 = byte[].class
            r10.d(r9, r15, r3)
            h5.g r3 = new h5.g
            r3.<init>()
            r10.d(r9, r0, r3)
            r10.d(r2, r2, r1)
            r0 = r25
            r10.d(r0, r0, r1)
            m5.f r1 = new m5.f
            r1.<init>()
            r2 = r24
            r10.a(r1, r0, r0, r2)
            b4.e0 r1 = new b4.e0
            r1.<init>((android.content.res.Resources) r7)
            r11 = r22
            r12 = r23
            r10.l(r11, r12, r1)
            r1 = r19
            r10.l(r11, r9, r1)
            android.support.v4.media.session.u r13 = new android.support.v4.media.session.u
            r6 = 23
            r15 = 0
            r2 = r13
            r3 = r18
            r4 = r1
            r5 = r20
            r1 = r7
            r7 = r15
            r2.<init>((java.lang.Object) r3, (java.lang.Object) r4, (java.lang.Object) r5, (int) r6, (int) r7)
            r10.l(r0, r9, r13)
            r2 = r17
            r0 = r20
            r10.l(r2, r9, r0)
            r0 = 23
            if (r8 < r0) goto L_0x0374
            k5.t0 r0 = new k5.t0
            k5.o0 r2 = new k5.o0
            r2.<init>()
            r3 = r18
            r0.<init>(r3, r2)
            java.lang.Class<java.nio.ByteBuffer> r2 = java.nio.ByteBuffer.class
            java.lang.String r3 = "legacy_append"
            r10.a(r0, r2, r11, r3)
            a5.e r2 = new a5.e
            r2.<init>(r1, r0)
            java.lang.Class<java.nio.ByteBuffer> r0 = java.nio.ByteBuffer.class
            java.lang.String r1 = "legacy_append"
            r10.a(r2, r0, r12, r1)
        L_0x0374:
            java.util.Iterator r0 = r29.iterator()
        L_0x0378:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x03a0
            java.lang.Object r1 = r0.next()
            q5.c r1 = (q5.c) r1
            r2 = r28
            r1.b(r14, r2, r10)     // Catch:{ AbstractMethodError -> 0x038a }
            goto L_0x0378
        L_0x038a:
            r0 = move-exception
            r2 = r0
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r3 = "Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: "
            java.lang.String r1 = r3.concat(r1)
            r0.<init>(r1, r2)
            throw r0
        L_0x03a0:
            r2 = r28
            r0 = r30
            if (r0 == 0) goto L_0x03a9
            r0.b(r14, r2, r10)
        L_0x03a9:
            return r10
        L_0x03aa:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.o.a(com.bumptech.glide.c, java.util.List, q5.a):com.bumptech.glide.n");
    }
}
