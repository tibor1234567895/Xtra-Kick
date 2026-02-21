package h3;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6987h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f6988i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f6989j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f6990k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f6991l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f6992m;

    public /* synthetic */ e(g gVar, g3 g3Var, AtomicBoolean atomicBoolean, f fVar, AtomicBoolean atomicBoolean2) {
        this.f6987h = 0;
        this.f6988i = gVar;
        this.f6989j = g3Var;
        this.f6990k = atomicBoolean;
        this.f6992m = fVar;
        this.f6991l = atomicBoolean2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r12 = this;
            int r0 = r12.f6987h
            java.lang.Object r1 = r12.f6991l
            java.lang.Object r2 = r12.f6989j
            java.lang.Object r3 = r12.f6992m
            java.lang.Object r4 = r12.f6990k
            java.lang.Object r5 = r12.f6988i
            switch(r0) {
                case 0: goto L_0x0028;
                case 1: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0054
        L_0x0010:
            h3.y1 r5 = (h3.y1) r5
            java.lang.String r4 = (java.lang.String) r4
            h3.b0 r3 = (h3.b0) r3
            h3.q1 r0 = r5.f7480b
            r0.getClass()
            androidx.emoji2.text.r r0 = new androidx.emoji2.text.r
            r1 = 13
            r0.<init>(r5, r3, r4, r1)
            o1.b0 r1 = r5.f7483e
            r1.execute(r0)
            return
        L_0x0028:
            r0 = r5
            h3.g r0 = (h3.g) r0
            h3.g3 r2 = (h3.g3) r2
            java.util.concurrent.atomic.AtomicBoolean r4 = (java.util.concurrent.atomic.AtomicBoolean) r4
            r5 = r3
            h3.f r5 = (h3.f) r5
            r6 = r1
            java.util.concurrent.atomic.AtomicBoolean r6 = (java.util.concurrent.atomic.AtomicBoolean) r6
            r0.getClass()
            h3.r3 r1 = r2.f7048a
            int r3 = r2.f7051d
            h3.n2 r7 = r2.f7049b
            h3.e2 r2 = r2.f7050c
            java.lang.Object r1 = r1.h(r7, r2, r3)
            h9.e0 r1 = (h9.e0) r1
            v1.c0 r8 = new v1.c0
            r7 = 1
            r2 = r8
            r3 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            h9.q r0 = h9.q.f7765h
            r1.a(r8, r0)
            return
        L_0x0054:
            h3.v2 r5 = (h3.v2) r5
            java.util.concurrent.atomic.AtomicInteger r2 = (java.util.concurrent.atomic.AtomicInteger) r2
            java.util.List r4 = (java.util.List) r4
            java.util.List r1 = (java.util.List) r1
            g1.u1 r3 = (g1.u1) r3
            r5.getClass()
            int r0 = r2.incrementAndGet()
            int r2 = r4.size()
            if (r0 != r2) goto L_0x0119
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2 = 0
            r6 = 0
        L_0x0072:
            int r7 = r1.size()
            if (r6 >= r7) goto L_0x00a8
            java.lang.Object r7 = r1.get(r6)
            h9.e0 r7 = (h9.e0) r7
            r8 = 0
            if (r7 == 0) goto L_0x008b
            java.lang.Object r7 = h9.w.b(r7)     // Catch:{ CancellationException | ExecutionException -> 0x0088 }
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7     // Catch:{ CancellationException | ExecutionException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            j1.v.b()
        L_0x008b:
            r7 = r8
        L_0x008c:
            java.lang.Object r9 = r4.get(r6)
            g1.s0 r9 = (g1.s0) r9
            android.support.v4.media.MediaDescriptionCompat r7 = h3.t3.i(r9, r7)
            r9 = -1
            if (r6 != r9) goto L_0x009c
            r9 = -1
            goto L_0x009d
        L_0x009c:
            long r9 = (long) r6
        L_0x009d:
            android.support.v4.media.session.MediaSessionCompat$QueueItem r11 = new android.support.v4.media.session.MediaSessionCompat$QueueItem
            r11.<init>(r8, r7, r9)
            r0.add(r11)
            int r6 = r6 + 1
            goto L_0x0072
        L_0x00a8:
            int r1 = j1.l0.f8453a
            r4 = 21
            h3.x2 r5 = r5.f7383e
            if (r1 >= r4) goto L_0x0114
            e1.h r1 = h3.t3.f7332a
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.os.Parcel r4 = android.os.Parcel.obtain()
            r6 = 0
        L_0x00bc:
            int r7 = r0.size()     // Catch:{ all -> 0x010f }
            if (r6 >= r7) goto L_0x00d9
            java.lang.Object r7 = r0.get(r6)     // Catch:{ all -> 0x010f }
            android.os.Parcelable r7 = (android.os.Parcelable) r7     // Catch:{ all -> 0x010f }
            r4.writeParcelable(r7, r2)     // Catch:{ all -> 0x010f }
            int r8 = r4.dataSize()     // Catch:{ all -> 0x010f }
            r9 = 262144(0x40000, float:3.67342E-40)
            if (r8 >= r9) goto L_0x00d9
            r1.add(r7)     // Catch:{ all -> 0x010f }
            int r6 = r6 + 1
            goto L_0x00bc
        L_0x00d9:
            r4.recycle()
            int r0 = r1.size()
            int r2 = r3.x()
            if (r0 == r2) goto L_0x0109
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Sending "
            r0.<init>(r2)
            int r2 = r1.size()
            r0.append(r2)
            java.lang.String r2 = " items out of "
            r0.append(r2)
            int r2 = r3.x()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "MediaSessionLegacyStub"
            j1.v.f(r2, r0)
        L_0x0109:
            android.support.v4.media.session.u r0 = r5.f7442l
            r0.M(r1)
            goto L_0x0119
        L_0x010f:
            r0 = move-exception
            r4.recycle()
            throw r0
        L_0x0114:
            android.support.v4.media.session.u r1 = r5.f7442l
            r1.M(r0)
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.e.run():void");
    }

    public /* synthetic */ e(Object obj, Object obj2, Serializable serializable, Cloneable cloneable, Object obj3, int i10) {
        this.f6987h = i10;
        this.f6988i = obj;
        this.f6989j = obj2;
        this.f6990k = serializable;
        this.f6991l = cloneable;
        this.f6992m = obj3;
    }
}
