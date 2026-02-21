package n4;

import android.content.Context;
import java.util.List;
import s4.i;
import s4.k;
import t4.g;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final i f11697a;

    /* renamed from: b  reason: collision with root package name */
    public final List f11698b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11699c;

    /* renamed from: d  reason: collision with root package name */
    public final i f11700d;

    /* renamed from: e  reason: collision with root package name */
    public final g f11701e;

    /* renamed from: f  reason: collision with root package name */
    public final i4.i f11702f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f11703g;

    public m(i iVar, List list, int i10, i iVar2, g gVar, i4.i iVar3, boolean z10) {
        this.f11697a = iVar;
        this.f11698b = list;
        this.f11699c = i10;
        this.f11700d = iVar2;
        this.f11701e = gVar;
        this.f11702f = iVar3;
        this.f11703g = z10;
    }

    public final void a(i iVar, k kVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Context context = iVar.f14249a;
        i iVar2 = this.f11697a;
        boolean z14 = true;
        if (context == iVar2.f14249a) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (iVar.f14250b != k.f14275a) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (iVar.f14251c == iVar2.f14251c) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (iVar.f14271w == iVar2.f14271w) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        if (iVar.f14272x != iVar2.f14272x) {
                            z14 = false;
                        }
                        if (!z14) {
                            throw new IllegalStateException(("Interceptor '" + kVar + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
                        }
                        return;
                    }
                    throw new IllegalStateException(("Interceptor '" + kVar + "' cannot modify the request's lifecycle.").toString());
                }
                throw new IllegalStateException(("Interceptor '" + kVar + "' cannot modify the request's target.").toString());
            }
            throw new IllegalStateException(("Interceptor '" + kVar + "' cannot set the request's data to null.").toString());
        }
        throw new IllegalStateException(("Interceptor '" + kVar + "' cannot modify the request's context.").toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(s4.i r13, pa.e r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof n4.l
            if (r0 == 0) goto L_0x0013
            r0 = r14
            n4.l r0 = (n4.l) r0
            int r1 = r0.f11696l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11696l = r1
            goto L_0x0018
        L_0x0013:
            n4.l r0 = new n4.l
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f11694j
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11696l
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            n4.k r13 = r0.f11693i
            n4.m r0 = r0.f11692h
            hb.h0.O1(r14)
            goto L_0x0071
        L_0x002b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0033:
            hb.h0.O1(r14)
            java.util.List r14 = r12.f11698b
            int r2 = r12.f11699c
            if (r2 <= 0) goto L_0x0047
            int r4 = r2 + -1
            java.lang.Object r4 = r14.get(r4)
            n4.k r4 = (n4.k) r4
            r12.a(r13, r4)
        L_0x0047:
            java.lang.Object r14 = r14.get(r2)
            n4.k r14 = (n4.k) r14
            int r7 = r2 + 1
            t4.g r9 = r12.f11701e
            n4.m r2 = new n4.m
            s4.i r5 = r12.f11697a
            java.util.List r6 = r12.f11698b
            i4.i r10 = r12.f11702f
            boolean r11 = r12.f11703g
            r4 = r2
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0.f11692h = r12
            r0.f11693i = r14
            r0.f11696l = r3
            r13 = r14
            n4.j r13 = (n4.j) r13
            java.lang.Object r14 = r13.d(r2, r0)
            if (r14 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r0 = r12
        L_0x0071:
            s4.j r14 = (s4.j) r14
            s4.i r1 = r14.a()
            r0.a(r1, r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.m.b(s4.i, pa.e):java.lang.Object");
    }
}
