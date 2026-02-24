package androidx.recyclerview.widget;

public final class d0 extends v1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f1958a;

    public d0(g0 g0Var) {
        this.f1958a = g0Var;
    }

    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        boolean z10;
        boolean z11;
        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        g0 g0Var = this.f1958a;
        int computeVerticalScrollRange = g0Var.f2010s.computeVerticalScrollRange();
        int i12 = g0Var.f2009r;
        int i13 = computeVerticalScrollRange - i12;
        int i14 = g0Var.f1992a;
        if (i13 <= 0 || i12 < i14) {
            z10 = false;
        } else {
            z10 = true;
        }
        g0Var.f2011t = z10;
        int computeHorizontalScrollRange = g0Var.f2010s.computeHorizontalScrollRange();
        int i15 = g0Var.f2008q;
        if (computeHorizontalScrollRange - i15 <= 0 || i15 < i14) {
            z11 = false;
        } else {
            z11 = true;
        }
        g0Var.f2012u = z11;
        boolean z12 = g0Var.f2011t;
        if (z12 || z11) {
            if (z12) {
                float f10 = (float) i12;
                g0Var.f2003l = (int) ((((f10 / 2.0f) + ((float) computeVerticalScrollOffset)) * f10) / ((float) computeVerticalScrollRange));
                g0Var.f2002k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
            }
            if (g0Var.f2012u) {
                float f11 = (float) computeHorizontalScrollOffset;
                float f12 = (float) i15;
                g0Var.f2006o = (int) ((((f12 / 2.0f) + f11) * f12) / ((float) computeHorizontalScrollRange));
                g0Var.f2005n = Math.min(i15, (i15 * i15) / computeHorizontalScrollRange);
            }
            int i16 = g0Var.f2013v;
            if (i16 == 0 || i16 == 1) {
                g0Var.d(1);
            }
        } else if (g0Var.f2013v != 0) {
            g0Var.d(0);
        }
    }
}
