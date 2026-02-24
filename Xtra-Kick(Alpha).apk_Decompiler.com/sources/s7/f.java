package s7;

import javax.inject.Inject;
import p9.i;
import t9.m;
import xa.j;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final i f14372a;

    /* renamed from: b  reason: collision with root package name */
    public m f14373b;

    @Inject
    public f(i iVar) {
        j.f("configurationBuilder", iVar);
        this.f14372a = iVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r5 != false) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p9.h a(java.lang.Integer r32) {
        /*
            r31 = this;
            r1 = r31
            t9.m r0 = r1.f14373b
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x000d
            goto L_0x0010
        L_0x000d:
            r3 = r1
            goto L_0x01ae
        L_0x0010:
            p9.g r0 = p9.h.f12657a
            p9.i r2 = r1.f14372a
            y5.v r3 = com.github.andreyasadchy.xtra.XtraApp.f3319k
            r3.getClass()
            android.app.Application r3 = y5.v.a()
            android.content.Context r3 = r3.getApplicationContext()
            java.lang.String r4 = "XtraApp.INSTANCE.applicationContext"
            xa.j.e(r4, r3)
            android.content.SharedPreferences r3 = hb.h0.l1(r3)
            java.lang.String r4 = "download_concurrent_limit"
            r5 = 10
            int r3 = r3.getInt(r4, r5)
            if (r3 < 0) goto L_0x01b9
            r2.f12660c = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Fetch #"
            r3.<init>(r4)
            r4 = r32
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L_0x0053
            int r5 = r3.length()
            if (r5 != 0) goto L_0x0050
            r5 = 1
            goto L_0x0051
        L_0x0050:
            r5 = 0
        L_0x0051:
            if (r5 == 0) goto L_0x0055
        L_0x0053:
            java.lang.String r3 = "LibGlobalFetchLib"
        L_0x0055:
            r2.f12659b = r3
            la.v r3 = la.v.f9814a
            y9.l r3 = r2.f12665h
            boolean r5 = r3 instanceof y9.l
            if (r5 == 0) goto L_0x0077
            boolean r5 = r2.f12662e
            r3.f17265a = r5
            java.lang.String r5 = r3.f17266b
            java.lang.String r6 = "fetch2"
            boolean r5 = xa.j.a(r5, r6)
            if (r5 == 0) goto L_0x007b
            java.lang.String r5 = r2.f12659b
            java.lang.String r6 = "<set-?>"
            xa.j.g(r6, r5)
            r3.f17266b = r5
            goto L_0x007b
        L_0x0077:
            boolean r5 = r2.f12662e
            r3.f17265a = r5
        L_0x007b:
            p9.j r26 = new p9.j
            r5 = r26
            java.lang.String r7 = "appContext"
            android.content.Context r14 = r2.f12658a
            r6 = r14
            xa.j.b(r7, r14)
            java.lang.String r15 = r2.f12659b
            r7 = r15
            int r8 = r2.f12660c
            long r9 = r2.f12661d
            boolean r11 = r2.f12662e
            y9.h r12 = r2.f12663f
            p9.p r13 = r2.f12664g
            boolean r4 = r2.f12666i
            r1 = r15
            r15 = r4
            boolean r4 = r2.f12667j
            r16 = r4
            p9.k r4 = r2.f12668k
            r17 = r4
            boolean r4 = r2.f12669l
            r18 = r4
            r27 = r14
            y9.b r14 = r2.f12670m
            r19 = r14
            p9.s r14 = r2.f12671n
            r20 = r14
            r28 = r0
            r29 = r1
            long r0 = r2.f12672o
            r21 = r0
            boolean r0 = r2.f12673p
            r23 = r0
            int r0 = r2.f12674q
            r24 = r0
            boolean r0 = r2.f12675r
            r25 = r0
            r0 = r27
            r14 = r3
            r5.<init>(r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25)
            r28.getClass()
            t9.c r1 = t9.m.f14874n
            t9.p r2 = t9.p.f14899d
            r2.getClass()
            java.lang.Object r2 = t9.p.f14896a
            monitor-enter(r2)
            java.util.LinkedHashMap r15 = t9.p.f14897b     // Catch:{ all -> 0x01b4 }
            r14 = r29
            java.lang.Object r5 = r15.get(r14)     // Catch:{ all -> 0x01b4 }
            t9.n r5 = (t9.n) r5     // Catch:{ all -> 0x01b4 }
            if (r5 == 0) goto L_0x00fb
            z5.k r0 = new z5.k     // Catch:{ all -> 0x01b4 }
            y9.p r8 = r5.f14887a     // Catch:{ all -> 0x01b4 }
            q9.h r9 = r5.f14888b     // Catch:{ all -> 0x01b4 }
            u9.a r10 = r5.f14889c     // Catch:{ all -> 0x01b4 }
            l.h r11 = r5.f14890d     // Catch:{ all -> 0x01b4 }
            android.os.Handler r12 = r5.f14891e     // Catch:{ all -> 0x01b4 }
            s9.a r13 = r5.f14892f     // Catch:{ all -> 0x01b4 }
            z5.i r14 = r5.f14893g     // Catch:{ all -> 0x01b4 }
            r6 = r0
            r7 = r26
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x01b4 }
            r32 = r1
            goto L_0x0177
        L_0x00fb:
            y9.p r13 = new y9.p     // Catch:{ all -> 0x01b4 }
            r13.<init>(r14)     // Catch:{ all -> 0x01b4 }
            t9.x r10 = new t9.x     // Catch:{ all -> 0x01b4 }
            r10.<init>(r14)     // Catch:{ all -> 0x01b4 }
            q9.g r12 = new q9.g     // Catch:{ all -> 0x01b4 }
            q9.c r5 = com.tonyodev.fetch2.database.DownloadDatabase.f4074o     // Catch:{ all -> 0x01b4 }
            r5.getClass()     // Catch:{ all -> 0x01b4 }
            r9.a[] r9 = q9.c.a()     // Catch:{ all -> 0x01b4 }
            y9.b r11 = new y9.b     // Catch:{ all -> 0x01b4 }
            java.lang.String r5 = hb.h0.n0(r0)     // Catch:{ all -> 0x01b4 }
            r11.<init>(r0, r5)     // Catch:{ all -> 0x01b4 }
            r5 = r12
            r6 = r0
            r7 = r14
            r8 = r3
            r0 = r11
            r11 = r4
            r3 = r12
            r12 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x01b4 }
            q9.h r0 = new q9.h     // Catch:{ all -> 0x01b4 }
            r0.<init>(r3)     // Catch:{ all -> 0x01b4 }
            u9.a r3 = new u9.a     // Catch:{ all -> 0x01b4 }
            r4 = 1
            r3.<init>(r0, r4)     // Catch:{ all -> 0x01b4 }
            s9.a r4 = new s9.a     // Catch:{ all -> 0x01b4 }
            r4.<init>(r14)     // Catch:{ all -> 0x01b4 }
            l.h r5 = new l.h     // Catch:{ all -> 0x01b4 }
            r5.<init>((java.lang.String) r14, (u9.a) r3)     // Catch:{ all -> 0x01b4 }
            z5.i r12 = new z5.i     // Catch:{ all -> 0x01b4 }
            android.os.Handler r11 = t9.p.f14898c     // Catch:{ all -> 0x01b4 }
            r12.<init>(r14, r5, r3, r11)     // Catch:{ all -> 0x01b4 }
            z5.k r10 = new z5.k     // Catch:{ all -> 0x01b4 }
            r6 = r10
            r7 = r26
            r8 = r13
            r9 = r0
            r32 = r1
            r1 = r10
            r10 = r3
            r21 = r11
            r11 = r5
            r23 = r12
            r12 = r21
            r17 = r13
            r13 = r4
            r30 = r14
            r14 = r23
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x01b4 }
            t9.n r6 = new t9.n     // Catch:{ all -> 0x01b4 }
            java.lang.Object r7 = r1.f17687d     // Catch:{ all -> 0x01b4 }
            r24 = r7
            w9.a r24 = (w9.a) r24     // Catch:{ all -> 0x01b4 }
            r16 = r6
            r18 = r0
            r19 = r3
            r20 = r5
            r22 = r4
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x01b4 }
            r0 = r30
            r15.put(r0, r6)     // Catch:{ all -> 0x01b4 }
            r0 = r1
        L_0x0177:
            java.lang.Object r1 = r0.f17690g     // Catch:{ all -> 0x01b4 }
            y9.p r1 = (y9.p) r1     // Catch:{ all -> 0x01b4 }
            r1.c()     // Catch:{ all -> 0x01b4 }
            monitor-exit(r2)
            r32.getClass()
            t9.m r1 = new t9.m
            java.lang.Object r2 = r0.f17689f
            r5 = r2
            p9.j r5 = (p9.j) r5
            java.lang.String r4 = r5.f12677b
            java.lang.Object r2 = r0.f17690g
            r6 = r2
            y9.p r6 = (y9.p) r6
            java.lang.Object r2 = r0.f17694k
            r7 = r2
            android.os.Handler r7 = (android.os.Handler) r7
            java.lang.Object r2 = r0.f17688e
            r8 = r2
            t9.a r8 = (t9.a) r8
            y9.l r9 = r5.f12683h
            java.lang.Object r2 = r0.f17695l
            r10 = r2
            z5.i r10 = (z5.i) r10
            java.lang.Object r0 = r0.f17691h
            r11 = r0
            q9.h r11 = (q9.h) r11
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = r31
            r3.f14373b = r1
        L_0x01ae:
            t9.m r0 = r3.f14373b
            xa.j.c(r0)
            return r0
        L_0x01b4:
            r0 = move-exception
            r3 = r31
            monitor-exit(r2)
            throw r0
        L_0x01b9:
            r3 = r1
            r2.getClass()
            androidx.fragment.app.y r0 = new androidx.fragment.app.y
            java.lang.String r1 = "Concurrent limit cannot be less than 0"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.f.a(java.lang.Integer):p9.h");
    }
}
