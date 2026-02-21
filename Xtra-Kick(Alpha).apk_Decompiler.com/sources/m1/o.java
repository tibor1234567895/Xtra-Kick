package m1;

import android.content.Context;
import p1.e0;
import s1.i;
import s1.v;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final Context f10413a;

    /* renamed from: b  reason: collision with root package name */
    public final i f10414b = new i();

    /* renamed from: c  reason: collision with root package name */
    public final long f10415c = 5000;

    /* renamed from: d  reason: collision with root package name */
    public final e0 f10416d = v.f14082a;

    public o(Context context) {
        this.f10413a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        if (r7 != false) goto L_0x007d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final m1.f[] a(android.os.Handler r13, m1.k0 r14, m1.k0 r15, m1.k0 r16, m1.k0 r17) {
        /*
            r12 = this;
            r0 = r12
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.content.Context r3 = r0.f10413a
            p1.e0 r10 = r0.f10416d
            long r6 = r0.f10415c
            b2.g r11 = new b2.g
            s1.i r4 = r0.f10414b
            r2 = r11
            r5 = r10
            r8 = r13
            r9 = r14
            r2.<init>(r3, r4, r5, r6, r8, r9)
            r1.add(r11)
            o1.w r2 = new o1.w
            r2.<init>()
            o1.b r3 = o1.b.f11855c
            android.content.IntentFilter r3 = new android.content.IntentFilter
            java.lang.String r4 = "android.media.action.HDMI_AUDIO_PLUG"
            r3.<init>(r4)
            r4 = 0
            android.content.Context r5 = r0.f10413a
            android.content.Intent r3 = r5.registerReceiver(r4, r3)
            int r4 = j1.l0.f8453a
            r6 = 17
            r7 = 1
            r11 = 0
            if (r4 < r6) goto L_0x004b
            java.lang.String r6 = j1.l0.f8455c
            java.lang.String r8 = "Amazon"
            boolean r8 = r8.equals(r6)
            if (r8 != 0) goto L_0x0049
            java.lang.String r8 = "Xiaomi"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x004b
        L_0x0049:
            r6 = 1
            goto L_0x004c
        L_0x004b:
            r6 = 0
        L_0x004c:
            if (r6 == 0) goto L_0x005d
            android.content.ContentResolver r6 = r5.getContentResolver()
            java.lang.String r8 = "external_surround_sound_enabled"
            int r6 = android.provider.Settings.Global.getInt(r6, r8, r11)
            if (r6 != r7) goto L_0x005d
            o1.b r3 = o1.b.f11856d
            goto L_0x00a7
        L_0x005d:
            r6 = 29
            r8 = 8
            if (r4 < r6) goto L_0x0087
            boolean r6 = j1.l0.F(r5)
            if (r6 != 0) goto L_0x007d
            r6 = 23
            if (r4 < r6) goto L_0x007a
            android.content.pm.PackageManager r4 = r5.getPackageManager()
            java.lang.String r5 = "android.hardware.type.automotive"
            boolean r4 = r4.hasSystemFeature(r5)
            if (r4 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r7 = 0
        L_0x007b:
            if (r7 == 0) goto L_0x0087
        L_0x007d:
            o1.b r3 = new o1.b
            int[] r4 = o1.a.a()
            r3.<init>(r4, r8)
            goto L_0x00a7
        L_0x0087:
            if (r3 == 0) goto L_0x00a5
            java.lang.String r4 = "android.media.extra.AUDIO_PLUG_STATE"
            int r4 = r3.getIntExtra(r4, r11)
            if (r4 != 0) goto L_0x0092
            goto L_0x00a5
        L_0x0092:
            o1.b r4 = new o1.b
            java.lang.String r5 = "android.media.extra.ENCODINGS"
            int[] r5 = r3.getIntArrayExtra(r5)
            java.lang.String r6 = "android.media.extra.MAX_CHANNEL_COUNT"
            int r3 = r3.getIntExtra(r6, r8)
            r4.<init>(r5, r3)
            r3 = r4
            goto L_0x00a7
        L_0x00a5:
            o1.b r3 = o1.b.f11855c
        L_0x00a7:
            r3.getClass()
            r2.f12041a = r3
            r2.f12043c = r11
            r2.f12044d = r11
            r2.f12045e = r11
            android.support.v4.media.session.u r3 = r2.f12042b
            if (r3 != 0) goto L_0x00bf
            android.support.v4.media.session.u r3 = new android.support.v4.media.session.u
            h1.c[] r4 = new h1.c[r11]
            r3.<init>((h1.c[]) r4)
            r2.f12042b = r3
        L_0x00bf:
            o1.e0 r3 = new o1.e0
            r3.<init>(r2)
            android.content.Context r5 = r0.f10413a
            o1.j0 r2 = new o1.j0
            s1.i r6 = r0.f10414b
            r4 = r2
            r7 = r10
            r8 = r13
            r9 = r15
            r10 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r1.add(r2)
            android.os.Looper r2 = r13.getLooper()
            y1.g r3 = new y1.g
            r4 = r16
            r3.<init>(r4, r2)
            r1.add(r3)
            android.os.Looper r2 = r13.getLooper()
            t1.c r3 = new t1.c
            r4 = r17
            r3.<init>(r4, r2)
            r1.add(r3)
            c2.b r2 = new c2.b
            r2.<init>()
            r1.add(r2)
            m1.f[] r2 = new m1.f[r11]
            java.lang.Object[] r1 = r1.toArray(r2)
            m1.f[] r1 = (m1.f[]) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.o.a(android.os.Handler, m1.k0, m1.k0, m1.k0, m1.k0):m1.f[]");
    }
}
