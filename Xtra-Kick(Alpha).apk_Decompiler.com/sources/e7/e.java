package e7;

import androidx.appcompat.widget.j3;
import la.v;
import n3.z;
import ra.i;
import wa.p;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5301i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ j3 f5302j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g f5303k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(j3 j3Var, g gVar, pa.e eVar) {
        super(2, eVar);
        this.f5302j = j3Var;
        this.f5303k = gVar;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        e eVar2 = new e(this.f5302j, this.f5303k, eVar);
        eVar2.f5301i = obj;
        return eVar2;
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((z) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        if ((!fb.w.h((java.lang.CharSequence) ((com.github.andreyasadchy.xtra.ui.search.streams.StreamSearchViewModel) r6.f5309q0.getValue()).f3482d.getValue())) != false) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            hb.h0.O1(r10)
            java.lang.Object r10 = r9.f5301i
            n3.z r10 = (n3.z) r10
            androidx.appcompat.widget.j3 r0 = r9.f5302j
            java.lang.Object r1 = r0.f896c
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            java.lang.String r2 = "progressBar"
            xa.j.e(r2, r1)
            n3.a1 r2 = r10.f11594a
            boolean r2 = r2 instanceof n3.x0
            r3 = 0
            java.lang.String r4 = "pagingAdapter"
            r5 = 1
            e7.g r6 = r9.f5303k
            r7 = 0
            if (r2 == 0) goto L_0x002f
            i7.c r2 = r6.f5310r0
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
            if (r10 != 0) goto L_0x0070
            i7.c r10 = r6.f5310r0
            if (r10 == 0) goto L_0x006c
            int r10 = r10.getItemCount()
            if (r10 != 0) goto L_0x0070
            androidx.lifecycle.x1 r10 = r6.f5309q0
            java.lang.Object r10 = r10.getValue()
            com.github.andreyasadchy.xtra.ui.search.streams.StreamSearchViewModel r10 = (com.github.andreyasadchy.xtra.ui.search.streams.StreamSearchViewModel) r10
            kb.e1 r10 = r10.f3482d
            java.lang.Object r10 = r10.getValue()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = fb.w.h(r10)
            r10 = r10 ^ r5
            if (r10 == 0) goto L_0x0070
            goto L_0x0071
        L_0x006c:
            xa.j.l(r4)
            throw r3
        L_0x0070:
            r5 = 0
        L_0x0071:
            if (r5 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r7 = 8
        L_0x0076:
            r0.setVisibility(r7)
            la.v r10 = la.v.f9814a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e7.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
