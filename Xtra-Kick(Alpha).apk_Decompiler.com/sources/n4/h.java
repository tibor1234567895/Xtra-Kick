package n4;

import hb.f0;
import la.v;
import pa.e;
import q4.d;
import ra.i;
import s4.m;
import wa.p;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11668i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ j f11669j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ s4.i f11670k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f11671l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ m f11672m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ i4.i f11673n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ d f11674o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ m f11675p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(j jVar, s4.i iVar, Object obj, m mVar, i4.i iVar2, d dVar, m mVar2, e eVar) {
        super(2, eVar);
        this.f11669j = jVar;
        this.f11670k = iVar;
        this.f11671l = obj;
        this.f11672m = mVar;
        this.f11673n = iVar2;
        this.f11674o = dVar;
        this.f11675p = mVar2;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f11669j, this.f11670k, this.f11671l, this.f11672m, this.f11673n, this.f11674o, this.f11675p, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r14.f11668i
            r2 = 1
            if (r1 == 0) goto L_0x0015
            if (r1 != r2) goto L_0x000d
            hb.h0.O1(r15)
            goto L_0x002c
        L_0x000d:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0015:
            hb.h0.O1(r15)
            n4.j r3 = r14.f11669j
            s4.i r4 = r14.f11670k
            java.lang.Object r5 = r14.f11671l
            s4.m r6 = r14.f11672m
            i4.i r7 = r14.f11673n
            r14.f11668i = r2
            r8 = r14
            java.lang.Object r15 = n4.j.b(r3, r4, r5, r6, r7, r8)
            if (r15 != r0) goto L_0x002c
            return r0
        L_0x002c:
            n4.b r15 = (n4.b) r15
            n4.j r0 = r14.f11669j
            q4.g r0 = r0.f11691c
            r0.getClass()
            s4.i r1 = r14.f11670k
            int r1 = r1.J
            boolean r1 = q0.f.e(r1)
            r3 = 0
            r4 = 0
            q4.d r5 = r14.f11674o
            if (r1 != 0) goto L_0x0044
            goto L_0x0099
        L_0x0044:
            i4.m r0 = r0.f13329a
            i4.t r0 = (i4.t) r0
            la.e r0 = r0.f8273b
            java.lang.Object r0 = r0.getValue()
            q4.h r0 = (q4.h) r0
            if (r0 == 0) goto L_0x0099
            if (r5 != 0) goto L_0x0055
            goto L_0x0099
        L_0x0055:
            android.graphics.drawable.Drawable r1 = r15.f11619a
            boolean r6 = r1 instanceof android.graphics.drawable.BitmapDrawable
            if (r6 == 0) goto L_0x005e
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            goto L_0x005f
        L_0x005e:
            r1 = r4
        L_0x005f:
            if (r1 == 0) goto L_0x0099
            android.graphics.Bitmap r1 = r1.getBitmap()
            if (r1 != 0) goto L_0x0068
            goto L_0x0099
        L_0x0068:
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            boolean r7 = r15.f11620b
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "coil#is_sampled"
            r6.put(r8, r7)
            java.lang.String r7 = r15.f11622d
            if (r7 == 0) goto L_0x0081
            java.lang.String r8 = "coil#disk_cache_key"
            r6.put(r8, r7)
        L_0x0081:
            java.util.Map r7 = r5.f13326i
            java.util.Map r7 = hb.h0.V1(r7)
            q4.d r8 = new q4.d
            java.lang.String r9 = r5.f13325h
            r8.<init>(r9, r7)
            java.util.Map r6 = hb.h0.V1(r6)
            q4.o r0 = r0.f13331a
            r0.c(r8, r1, r6)
            r0 = 1
            goto L_0x009a
        L_0x0099:
            r0 = 0
        L_0x009a:
            android.graphics.drawable.Drawable r7 = r15.f11619a
            s4.i r8 = r14.f11670k
            int r9 = r15.f11621c
            if (r0 == 0) goto L_0x00a4
            r10 = r5
            goto L_0x00a5
        L_0x00a4:
            r10 = r4
        L_0x00a5:
            java.lang.String r11 = r15.f11622d
            boolean r12 = r15.f11620b
            android.graphics.Bitmap$Config[] r15 = w4.e.f16080a
            n4.m r15 = r14.f11675p
            boolean r0 = r15 instanceof n4.m
            if (r0 == 0) goto L_0x00b7
            boolean r15 = r15.f11703g
            if (r15 == 0) goto L_0x00b7
            r13 = 1
            goto L_0x00b8
        L_0x00b7:
            r13 = 0
        L_0x00b8:
            s4.r r15 = new s4.r
            r6 = r15
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.h.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
