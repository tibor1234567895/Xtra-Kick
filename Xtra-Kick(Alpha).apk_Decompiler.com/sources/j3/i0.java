package j3;

import android.os.Bundle;
import la.v;
import ma.b0;
import wa.l;
import xa.j;
import xa.k;
import xa.q;

public final class i0 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8561h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f8562i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f8563j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f8564k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f8565l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        super(1);
        this.f8561h = i10;
        this.f8562i = obj;
        this.f8563j = obj2;
        this.f8564k = obj3;
        this.f8565l = obj4;
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: type inference failed for: r9v6, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Boolean r9) {
        /*
            r8 = this;
            int r0 = r8.f8561h
            r1 = 0
            java.lang.String r2 = "closeOnPip"
            java.lang.Object r3 = r8.f8565l
            java.lang.Object r4 = r8.f8562i
            java.lang.Object r5 = r8.f8563j
            java.lang.Object r6 = r8.f8564k
            java.lang.String r7 = "it"
            switch(r0) {
                case 1: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x005c
        L_0x0013:
            xa.j.e(r7, r9)
            boolean r9 = r9.booleanValue()
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            if (r9 == 0) goto L_0x0048
            if (r4 == 0) goto L_0x0023
            hb.h0.S(r4)
        L_0x0023:
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x002a
            hb.h0.S(r5)
        L_0x002a:
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
            if (r6 == 0) goto L_0x0031
            hb.h0.S(r6)
        L_0x0031:
            u6.d r3 = (u6.d) r3
            androidx.fragment.app.c1 r9 = r3.u()
            androidx.fragment.app.c0 r9 = r9.E(r2)
            boolean r0 = r9 instanceof t6.d0
            if (r0 == 0) goto L_0x0042
            r1 = r9
            t6.d0 r1 = (t6.d0) r1
        L_0x0042:
            if (r1 == 0) goto L_0x005b
            r3.C0()
            goto L_0x005b
        L_0x0048:
            if (r4 == 0) goto L_0x004d
            hb.h0.O(r4)
        L_0x004d:
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x0054
            hb.h0.O(r5)
        L_0x0054:
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
            if (r6 == 0) goto L_0x005b
            hb.h0.O(r6)
        L_0x005b:
            return
        L_0x005c:
            xa.j.e(r7, r9)
            boolean r9 = r9.booleanValue()
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            if (r9 == 0) goto L_0x0091
            if (r4 == 0) goto L_0x006c
            hb.h0.S(r4)
        L_0x006c:
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x0073
            hb.h0.S(r5)
        L_0x0073:
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
            if (r6 == 0) goto L_0x007a
            hb.h0.S(r6)
        L_0x007a:
            x6.h r3 = (x6.h) r3
            androidx.fragment.app.c1 r9 = r3.u()
            androidx.fragment.app.c0 r9 = r9.E(r2)
            boolean r0 = r9 instanceof t6.d0
            if (r0 == 0) goto L_0x008b
            r1 = r9
            t6.d0 r1 = (t6.d0) r1
        L_0x008b:
            if (r1 == 0) goto L_0x00a4
            r3.C0()
            goto L_0x00a4
        L_0x0091:
            if (r4 == 0) goto L_0x0096
            hb.h0.O(r4)
        L_0x0096:
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x009d
            hb.h0.O(r5)
        L_0x009d:
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
            if (r6 == 0) goto L_0x00a4
            hb.h0.O(r6)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.i0.a(java.lang.Boolean):void");
    }

    public final Object invoke(Object obj) {
        switch (this.f8561h) {
            case 0:
                r rVar = (r) obj;
                j.f("it", rVar);
                ((q) this.f8562i).f16814h = true;
                ((k0) this.f8563j).a((c1) this.f8564k, (Bundle) this.f8565l, rVar, b0.f10801h);
                return v.f9814a;
            case 1:
                a((Boolean) obj);
                return v.f9814a;
            default:
                a((Boolean) obj);
                return v.f9814a;
        }
    }
}
