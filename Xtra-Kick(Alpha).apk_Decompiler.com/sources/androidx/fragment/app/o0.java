package androidx.fragment.app;

import android.content.res.Configuration;
import b0.l;
import l0.a;

public final /* synthetic */ class o0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c1 f1520b;

    public /* synthetic */ o0(c1 c1Var, int i10) {
        this.f1519a = i10;
        this.f1520b = c1Var;
    }

    public final void b(Object obj) {
        int i10 = this.f1519a;
        c1 c1Var = this.f1520b;
        switch (i10) {
            case 0:
                Configuration configuration = (Configuration) obj;
                if (c1Var.K()) {
                    c1Var.h(false, configuration);
                    return;
                }
                return;
            case 1:
                Integer num = (Integer) obj;
                if (c1Var.K() && num.intValue() == 80) {
                    c1Var.l(false);
                    return;
                }
                return;
            case 2:
                l lVar = (l) obj;
                if (c1Var.K()) {
                    c1Var.m(lVar.f2369a, false);
                    return;
                }
                return;
            default:
                b0.o0 o0Var = (b0.o0) obj;
                if (c1Var.K()) {
                    c1Var.r(o0Var.f2384a, false);
                    return;
                }
                return;
        }
    }
}
