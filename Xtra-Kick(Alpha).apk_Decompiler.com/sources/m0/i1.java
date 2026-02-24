package m0;

import android.view.View;
import android.view.ViewGroup;
import eb.j;
import la.v;
import pa.e;
import ra.h;
import wa.p;

public final class i1 extends h implements p {

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f10100i;

    /* renamed from: j  reason: collision with root package name */
    public View f10101j;

    /* renamed from: k  reason: collision with root package name */
    public int f10102k;

    /* renamed from: l  reason: collision with root package name */
    public int f10103l;

    /* renamed from: m  reason: collision with root package name */
    public int f10104m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f10105n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f10106o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i1(ViewGroup viewGroup, e eVar) {
        super(eVar);
        this.f10106o = viewGroup;
    }

    public final e create(Object obj, e eVar) {
        i1 i1Var = new i1(this.f10106o, eVar);
        i1Var.f10105n = obj;
        return i1Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((i1) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r13.f10104m
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            int r1 = r13.f10103l
            int r4 = r13.f10102k
            android.view.ViewGroup r5 = r13.f10100i
            java.lang.Object r6 = r13.f10105n
            eb.j r6 = (eb.j) r6
            hb.h0.O1(r14)
            r14 = r13
            r8 = r0
            goto L_0x00a5
        L_0x001d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0025:
            int r1 = r13.f10103l
            int r4 = r13.f10102k
            android.view.View r5 = r13.f10101j
            android.view.ViewGroup r6 = r13.f10100i
            java.lang.Object r7 = r13.f10105n
            eb.j r7 = (eb.j) r7
            hb.h0.O1(r14)
            r14 = r13
            r8 = r0
            goto L_0x006c
        L_0x0037:
            hb.h0.O1(r14)
            java.lang.Object r14 = r13.f10105n
            eb.j r14 = (eb.j) r14
            android.view.ViewGroup r1 = r13.f10106o
            int r4 = r1.getChildCount()
            r5 = 0
            r6 = r13
            r7 = r0
        L_0x0047:
            if (r5 >= r4) goto L_0x00b7
            android.view.View r8 = r1.getChildAt(r5)
            java.lang.String r9 = "getChildAt(index)"
            xa.j.e(r9, r8)
            r6.f10105n = r14
            r6.f10100i = r1
            r6.f10101j = r8
            r6.f10102k = r5
            r6.f10103l = r4
            r6.f10104m = r3
            r14.a(r8, r6)
            if (r0 != r7) goto L_0x0064
            return r7
        L_0x0064:
            r11 = r7
            r7 = r14
            r14 = r6
            r6 = r1
            r1 = r4
            r4 = r5
            r5 = r8
            r8 = r11
        L_0x006c:
            boolean r9 = r5 instanceof android.view.ViewGroup
            if (r9 == 0) goto L_0x00ad
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            java.lang.String r9 = "<this>"
            xa.j.f(r9, r5)
            m0.i1 r9 = new m0.i1
            r10 = 0
            r9.<init>(r5, r10)
            r14.f10105n = r7
            r14.f10100i = r6
            r14.f10101j = r10
            r14.f10102k = r4
            r14.f10103l = r1
            r14.f10104m = r2
            r7.getClass()
            eb.i r5 = new eb.i
            r5.<init>()
            pa.e r9 = qa.d.a(r5, r5, r9)
            r5.f5348k = r9
            java.lang.Object r5 = r7.b(r5, r14)
            if (r5 != r0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            la.v r5 = la.v.f9814a
        L_0x00a0:
            if (r5 != r8) goto L_0x00a3
            return r8
        L_0x00a3:
            r5 = r6
            r6 = r7
        L_0x00a5:
            r7 = r8
            r11 = r6
            r6 = r14
            r14 = r11
            r12 = r5
            r5 = r1
            r1 = r12
            goto L_0x00b2
        L_0x00ad:
            r5 = r1
            r1 = r6
            r6 = r14
            r14 = r7
            r7 = r8
        L_0x00b2:
            int r4 = r4 + r3
            r11 = r5
            r5 = r4
            r4 = r11
            goto L_0x0047
        L_0x00b7:
            la.v r14 = la.v.f9814a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.i1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
