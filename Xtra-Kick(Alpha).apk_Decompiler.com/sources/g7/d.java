package g7;

import androidx.appcompat.widget.j3;
import la.v;
import n3.z;
import pa.e;
import ra.i;
import wa.p;

public final class d extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f6851i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ j3 f6852j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ h f6853k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(j3 j3Var, h hVar, e eVar) {
        super(2, eVar);
        this.f6852j = j3Var;
        this.f6853k = hVar;
    }

    public final e create(Object obj, e eVar) {
        d dVar = new d(this.f6852j, this.f6853k, eVar);
        dVar.f6851i = obj;
        return dVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((d) create((z) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        if ((!fb.w.h((java.lang.CharSequence) r6.t0().f3492h.getValue())) != false) goto L_0x006d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            hb.h0.O1(r10)
            java.lang.Object r10 = r9.f6851i
            n3.z r10 = (n3.z) r10
            androidx.appcompat.widget.j3 r0 = r9.f6852j
            java.lang.Object r1 = r0.f896c
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r2 = "progressBar"
            xa.j.e(r2, r1)
            n3.a1 r2 = r10.f11594a
            boolean r2 = r2 instanceof n3.x0
            r3 = 0
            java.lang.String r4 = "pagingAdapter"
            r5 = 1
            g7.h r6 = r9.f6853k
            r7 = 0
            if (r2 == 0) goto L_0x002f
            m7.h r2 = r6.f6864s0
            if (r2 == 0) goto L_0x002b
            int r2 = r2.getItemCount()
            if (r2 != 0) goto L_0x002f
            r2 = 1
            goto L_0x0030
        L_0x002b:
            xa.j.l(r4)
            throw r3
        L_0x002f:
            r2 = 0
        L_0x0030:
            r8 = 8
            if (r2 == 0) goto L_0x0036
            r2 = 0
            goto L_0x0038
        L_0x0036:
            r2 = 8
        L_0x0038:
            r1.setVisibility(r2)
            java.lang.Object r0 = r0.f895b
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "nothingHere"
            xa.j.e(r1, r0)
            n3.a1 r10 = r10.f11594a
            boolean r10 = r10 instanceof n3.x0
            if (r10 != 0) goto L_0x006c
            m7.h r10 = r6.f6864s0
            if (r10 == 0) goto L_0x0068
            int r10 = r10.getItemCount()
            if (r10 != 0) goto L_0x006c
            com.github.andreyasadchy.xtra.ui.search.videos.VideoSearchViewModel r10 = r6.t0()
            kb.e1 r10 = r10.f3492h
            java.lang.Object r10 = r10.getValue()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = fb.w.h(r10)
            r10 = r10 ^ r5
            if (r10 == 0) goto L_0x006c
            goto L_0x006d
        L_0x0068:
            xa.j.l(r4)
            throw r3
        L_0x006c:
            r5 = 0
        L_0x006d:
            if (r5 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r7 = 8
        L_0x0072:
            r0.setVisibility(r7)
            la.v r10 = la.v.f9814a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.d.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
