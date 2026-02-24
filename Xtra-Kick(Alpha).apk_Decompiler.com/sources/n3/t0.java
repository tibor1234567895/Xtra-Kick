package n3;

import android.content.DialogInterface;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import kb.s0;
import l.h;
import la.v;
import t6.l;
import t6.y0;
import t6.z0;
import wa.p;
import xa.j;
import xa.k;

public final class t0 extends k implements p {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11483h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f11484i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f11485j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t0(Object obj, int i10, Object obj2) {
        super(2);
        this.f11483h = i10;
        this.f11484i = obj;
        this.f11485j = obj2;
    }

    public final Object g(Object obj, Object obj2) {
        s0 s0Var;
        int i10 = this.f11483h;
        Object obj3 = this.f11485j;
        Object obj4 = this.f11484i;
        switch (i10) {
            case 0:
                s0 s0Var2 = (s0) obj;
                s0 s0Var3 = (s0) obj2;
                j.f("prependHint", s0Var2);
                j.f("appendHint", s0Var3);
                a6 a6Var = (a6) obj3;
                if (((d1) obj4) == d1.PREPEND) {
                    s0Var2.f11471a = a6Var;
                    if (a6Var != null) {
                        s0Var = s0Var2.f11472b;
                    }
                    return v.f9814a;
                }
                s0Var3.f11471a = a6Var;
                if (a6Var != null) {
                    s0Var = s0Var3.f11472b;
                }
                return v.f9814a;
                s0Var.h(a6Var);
                return v.f9814a;
            default:
                ((Number) obj2).intValue();
                j.f("<anonymous parameter 0>", (DialogInterface) obj);
                z0 z0Var = (z0) obj4;
                y0 y0Var = z0Var.f14679u0;
                if (y0Var != null) {
                    h hVar = (h) obj3;
                    l lVar = (l) y0Var;
                    lVar.A0((((long) ((NumberPicker) hVar.f9450l).getValue()) * 60000) + (((long) ((NumberPicker) hVar.f9448j).getValue()) * 3600000), ((NumberPicker) hVar.f9448j).getValue(), ((NumberPicker) hVar.f9450l).getValue(), ((CheckBox) hVar.f9449k).isChecked());
                    z0Var.m0(false, false);
                    return v.f9814a;
                }
                j.l("listener");
                throw null;
        }
    }
}
