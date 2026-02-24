package h3;

import d9.r0;
import n1.h;

public final /* synthetic */ class s1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ y1 f7309h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ g2 f7310i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ r0 f7311j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ h f7312k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f7313l;

    public /* synthetic */ s1(y1 y1Var, g2 g2Var, r0 r0Var, h hVar, boolean z10) {
        this.f7309h = y1Var;
        this.f7310i = g2Var;
        this.f7311j = r0Var;
        this.f7312k = hVar;
        this.f7313l = z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0347  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r23 = this;
            r1 = r23
            h3.y1 r2 = r1.f7309h
            h3.q1 r0 = r2.f7480b
            r3 = r0
            h3.l r3 = (h3.l) r3
            r3.getClass()
            int r0 = j1.l0.f8453a
            r4 = 26
            java.lang.String r5 = r3.f7164c
            android.content.Context r6 = r3.f7162a
            if (r0 < r4) goto L_0x0028
            android.app.NotificationManager r0 = r3.f7166e
            android.app.NotificationChannel r4 = r0.getNotificationChannel(r5)
            if (r4 == 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            int r4 = r3.f7165d
            java.lang.String r4 = r6.getString(r4)
            h3.j.a(r0, r5, r4)
        L_0x0028:
            h3.g2 r4 = r1.f7310i
            g1.k1 r7 = r4.b()
            b0.p r8 = new b0.p
            r8.<init>(r6, r5)
            f3.a r0 = r3.f7163b
            r0.getClass()
            f1.b r5 = new f1.b
            r5.<init>()
            g1.g1 r0 = r7.w()
            boolean r9 = r7.y()
            r11 = 1
            if (r9 == 0) goto L_0x0051
            int r9 = r7.b()
            r12 = 4
            if (r9 == r12) goto L_0x0051
            r9 = 1
            goto L_0x0052
        L_0x0051:
            r9 = 0
        L_0x0052:
            d9.o0 r12 = new d9.o0
            r12.<init>()
            r13 = 2
            int[] r14 = new int[r13]
            r14 = {7, 6} // fill-array
            g1.y r15 = r0.f6385h
            boolean r14 = r15.a(r14)
            r15 = -1
            java.lang.String r10 = "androidx.media3.session.command.COMPACT_VIEW_INDEX"
            if (r14 == 0) goto L_0x0095
            android.os.Bundle r14 = new android.os.Bundle
            r14.<init>()
            r14.putInt(r10, r15)
            h3.c r13 = new h3.c
            r13.<init>()
            r15 = 6
            r13.b(r15)
            r15 = 2131231030(0x7f080136, float:1.807813E38)
            r13.f6945c = r15
            r15 = 2131952117(0x7f1301f5, float:1.9540668E38)
            java.lang.String r15 = r6.getString(r15)
            r13.f6946d = r15
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r14)
            r13.f6947e = r15
            h3.d r13 = r13.a()
            r12.c(r13)
        L_0x0095:
            boolean r13 = r0.i(r11)
            if (r13 == 0) goto L_0x00d4
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            r14 = -1
            r13.putInt(r10, r14)
            h3.c r14 = new h3.c
            r14.<init>()
            r14.b(r11)
            if (r9 == 0) goto L_0x00b2
            r15 = 2131231025(0x7f080131, float:1.807812E38)
            goto L_0x00b5
        L_0x00b2:
            r15 = 2131231026(0x7f080132, float:1.8078121E38)
        L_0x00b5:
            r14.f6945c = r15
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r13)
            r14.f6947e = r15
            if (r9 == 0) goto L_0x00c4
            r9 = 2131952112(0x7f1301f0, float:1.9540658E38)
            goto L_0x00c7
        L_0x00c4:
            r9 = 2131952113(0x7f1301f1, float:1.954066E38)
        L_0x00c7:
            java.lang.String r9 = r6.getString(r9)
            r14.f6946d = r9
            h3.d r9 = r14.a()
            r12.c(r9)
        L_0x00d4:
            r9 = 2
            int[] r13 = new int[r9]
            r13 = {9, 8} // fill-array
            g1.y r0 = r0.f6385h
            boolean r0 = r0.a(r13)
            r9 = 8
            if (r0 == 0) goto L_0x0111
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r13 = -1
            r0.putInt(r10, r13)
            h3.c r13 = new h3.c
            r13.<init>()
            r13.b(r9)
            r14 = 2131231029(0x7f080135, float:1.8078127E38)
            r13.f6945c = r14
            android.os.Bundle r14 = new android.os.Bundle
            r14.<init>(r0)
            r13.f6947e = r14
            r0 = 2131952116(0x7f1301f4, float:1.9540666E38)
            java.lang.String r0 = r6.getString(r0)
            r13.f6946d = r0
            h3.d r0 = r13.a()
            r12.c(r0)
        L_0x0111:
            r0 = 0
        L_0x0112:
            d9.r0 r13 = r1.f7311j
            int r14 = r13.size()
            if (r0 >= r14) goto L_0x012e
            java.lang.Object r13 = r13.get(r0)
            h3.d r13 = (h3.d) r13
            h3.f4 r14 = r13.f6971h
            if (r14 == 0) goto L_0x012b
            int r14 = r14.f7034h
            if (r14 != 0) goto L_0x012b
            r12.c(r13)
        L_0x012b:
            int r0 = r0 + 1
            goto L_0x0112
        L_0x012e:
            d9.r1 r0 = r12.e()
            r12 = 3
            int[] r13 = new int[r12]
            r14 = -1
            java.util.Arrays.fill(r13, r14)
            r14 = 0
            r15 = 0
        L_0x013b:
            int r9 = r0.f4660k
            j0.h r12 = r2.f7481c
            h3.n2 r11 = r4.f7047a
            if (r14 >= r9) goto L_0x0238
            java.lang.Object r9 = r0.get(r14)
            h3.d r9 = (h3.d) r9
            r16 = r0
            h3.f4 r0 = r9.f6971h
            r17 = r2
            java.lang.CharSequence r2 = r9.f6974k
            int r1 = r9.f6973j
            r18 = r3
            int r3 = r9.f6972i
            if (r0 == 0) goto L_0x01d5
            r12.getClass()
            h3.f4 r0 = r9.f6971h
            r19 = r7
            if (r0 == 0) goto L_0x0168
            int r7 = r0.f7034h
            if (r7 != 0) goto L_0x0168
            r7 = 1
            goto L_0x0169
        L_0x0168:
            r7 = 0
        L_0x0169:
            j1.a.b(r7)
            r0.getClass()
            b0.o r7 = new b0.o
            r20 = r5
            java.lang.Object r5 = r12.f8396i
            android.app.Service r5 = (android.app.Service) r5
            android.graphics.PorterDuff$Mode r21 = androidx.core.graphics.drawable.IconCompat.f1210k
            r5.getClass()
            r21 = r13
            android.content.res.Resources r13 = r5.getResources()
            java.lang.String r5 = r5.getPackageName()
            androidx.core.graphics.drawable.IconCompat r1 = androidx.core.graphics.drawable.IconCompat.f(r13, r5, r1)
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r13 = "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION"
            r5.<init>(r13)
            android.net.Uri r11 = r11.f7229b
            r5.setData(r11)
            android.content.ComponentName r11 = new android.content.ComponentName
            java.lang.Object r13 = r12.f8396i
            android.app.Service r13 = (android.app.Service) r13
            r22 = r14
            java.lang.Class r14 = r13.getClass()
            r11.<init>(r13, r14)
            r5.setComponent(r11)
            java.lang.String r11 = "androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION"
            java.lang.String r13 = r0.f7035i
            r5.putExtra(r11, r13)
            java.lang.String r11 = "androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS"
            android.os.Bundle r0 = r0.f7036j
            r5.putExtra(r11, r0)
            java.lang.Object r0 = r12.f8396i
            android.app.Service r0 = (android.app.Service) r0
            int r11 = r12.f8395h
            r13 = 1
            int r11 = r11 + r13
            r12.f8395h = r11
            int r12 = j1.l0.f8453a
            r13 = 23
            if (r12 < r13) goto L_0x01c9
            r12 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x01ca
        L_0x01c9:
            r12 = 0
        L_0x01ca:
            r13 = 134217728(0x8000000, float:3.85186E-34)
            r12 = r12 | r13
            android.app.PendingIntent r0 = android.app.PendingIntent.getService(r0, r11, r5, r12)
            r7.<init>(r1, r2, r0)
            goto L_0x0201
        L_0x01d5:
            r20 = r5
            r19 = r7
            r21 = r13
            r22 = r14
            r0 = -1
            if (r3 == r0) goto L_0x01e2
            r0 = 1
            goto L_0x01e3
        L_0x01e2:
            r0 = 0
        L_0x01e3:
            j1.a.e(r0)
            android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.f1210k
            r6.getClass()
            android.content.res.Resources r0 = r6.getResources()
            java.lang.String r5 = r6.getPackageName()
            androidx.core.graphics.drawable.IconCompat r0 = androidx.core.graphics.drawable.IconCompat.f(r0, r5, r1)
            b0.o r7 = new b0.o
            long r13 = (long) r3
            android.app.PendingIntent r1 = r12.i(r4, r13)
            r7.<init>(r0, r2, r1)
        L_0x0201:
            java.util.ArrayList r0 = r8.f2386b
            r0.add(r7)
            r1 = 3
            if (r15 != r1) goto L_0x020a
            goto L_0x0222
        L_0x020a:
            android.os.Bundle r0 = r9.f6975l
            r2 = -1
            int r0 = r0.getInt(r10, r2)
            if (r0 < 0) goto L_0x021a
            if (r0 >= r1) goto L_0x021a
            int r15 = r15 + 1
            r21[r0] = r22
            goto L_0x0222
        L_0x021a:
            r1 = 1
            if (r3 != r1) goto L_0x0222
            if (r15 != 0) goto L_0x0222
            r1 = 0
            r21[r1] = r22
        L_0x0222:
            int r14 = r22 + 1
            r1 = r23
            r0 = r16
            r2 = r17
            r3 = r18
            r7 = r19
            r5 = r20
            r13 = r21
            r9 = 8
            r11 = 1
            r12 = 3
            goto L_0x013b
        L_0x0238:
            r17 = r2
            r18 = r3
            r20 = r5
            r19 = r7
            r21 = r13
            r1 = 0
        L_0x0243:
            r2 = 3
            if (r1 >= r2) goto L_0x0257
            r0 = r21[r1]
            r2 = -1
            if (r0 != r2) goto L_0x0252
            r0 = r21
            int[] r13 = java.util.Arrays.copyOf(r0, r1)
            goto L_0x025a
        L_0x0252:
            r0 = r21
            int r1 = r1 + 1
            goto L_0x0243
        L_0x0257:
            r0 = r21
            r13 = r0
        L_0x025a:
            r1 = r20
            r1.f5433b = r13
            r0 = 18
            r2 = r19
            boolean r0 = r2.L0(r0)
            if (r0 == 0) goto L_0x02d3
            g1.v0 r0 = r2.C0()
            java.lang.CharSequence r3 = r0.f6651h
            java.lang.CharSequence r3 = b0.p.b(r3)
            r8.f2389e = r3
            java.lang.CharSequence r3 = r0.f6652i
            java.lang.CharSequence r3 = b0.p.b(r3)
            r8.f2390f = r3
            h3.a r3 = r11.f7240m
            h9.e0 r0 = r3.a(r0)
            if (r0 == 0) goto L_0x02d3
            r3 = r18
            h3.k r5 = r3.f7167f
            if (r5 == 0) goto L_0x028d
            r6 = 1
            r5.f7148j = r6
        L_0x028d:
            boolean r5 = r0.isDone()
            if (r5 == 0) goto L_0x02b9
            java.lang.Object r0 = h9.w.b(r0)     // Catch:{ ExecutionException -> 0x029d }
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch:{ ExecutionException -> 0x029d }
            r8.d(r0)     // Catch:{ ExecutionException -> 0x029d }
            goto L_0x02b5
        L_0x029d:
            r0 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed to load bitmap: "
            r5.<init>(r6)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.String r5 = "NotificationProvider"
            j1.v.g(r5, r0)
        L_0x02b5:
            r5 = 3
            r6 = r23
            goto L_0x02d8
        L_0x02b9:
            h3.k r5 = new h3.k
            r6 = r23
            n1.h r7 = r6.f7312k
            r5.<init>(r8, r7)
            r3.f7167f = r5
            android.os.Handler r7 = r11.f7239l
            java.util.Objects.requireNonNull(r7)
            o1.b0 r9 = new o1.b0
            r10 = 2
            r9.<init>(r10, r7)
            h9.w.a(r0, r5, r9)
            goto L_0x02d7
        L_0x02d3:
            r6 = r23
            r3 = r18
        L_0x02d7:
            r5 = 3
        L_0x02d8:
            boolean r0 = r2.L0(r5)
            r5 = 21
            r9 = 3
            if (r0 != 0) goto L_0x02e6
            int r0 = j1.l0.f8453a
            if (r0 >= r5) goto L_0x02e9
        L_0x02e6:
            r12.i(r4, r9)
        L_0x02e9:
            int r0 = j1.l0.f8453a
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 < r5) goto L_0x031d
            boolean r0 = r2.I()
            if (r0 == 0) goto L_0x031d
            boolean r0 = r2.o()
            if (r0 != 0) goto L_0x031d
            boolean r0 = r2.M0()
            if (r0 != 0) goto L_0x031d
            g1.e1 r0 = r2.i()
            float r0 = r0.f6355h
            r5 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x031d
            long r18 = java.lang.System.currentTimeMillis()
            long r20 = r2.t()
            long r18 = r18 - r20
            r9 = r18
            goto L_0x031e
        L_0x031d:
            r9 = r13
        L_0x031e:
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x0324
            r0 = 1
            goto L_0x0325
        L_0x0324:
            r0 = 0
        L_0x0325:
            android.app.Notification r2 = r8.f2404t
            r2.when = r9
            r8.f2393i = r0
            r8.f2394j = r0
            android.app.PendingIntent r0 = r11.f7238k
            r8.f2391g = r0
            r9 = 3
            android.app.PendingIntent r0 = r12.i(r4, r9)
            r2.deleteIntent = r0
            r5 = 8
            r7 = 1
            r8.c(r5, r7)
            int r0 = r3.f7168g
            r2.icon = r0
            b0.q r0 = r8.f2395k
            if (r0 == r1) goto L_0x034c
            r8.f2395k = r1
            r1.d(r8)
        L_0x034c:
            r1 = 1
            r8.f2401q = r1
            r1 = 2
            r2 = 0
            r8.c(r1, r2)
            android.app.Notification r0 = r8.a()
            h3.r1 r1 = new h3.r1
            r2 = 1001(0x3e9, float:1.403E-42)
            r1.<init>(r2, r0)
            androidx.fragment.app.f r0 = new androidx.fragment.app.f
            boolean r2 = r6.f7313l
            r3 = r17
            r0.<init>((h3.y1) r3, (h3.g2) r4, (h3.r1) r1, (boolean) r2)
            o1.b0 r1 = r3.f7483e
            r1.execute(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.s1.run():void");
    }
}
