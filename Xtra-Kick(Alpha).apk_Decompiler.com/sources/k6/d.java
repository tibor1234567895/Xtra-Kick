package k6;

import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woxthebox.draglistview.R;
import hb.f0;
import hb.h0;
import kb.e1;
import la.v;
import n3.u3;
import n3.x3;
import pa.e;
import pa.h;
import qa.a;
import ra.i;
import wa.p;
import xa.j;
import z5.f;

public final class d extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9206i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ e f9207j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ VideoPeriodEnum f9208k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f9209l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ CharSequence f9210m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ CharSequence f9211n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f9212o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f9213p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar, VideoPeriodEnum videoPeriodEnum, int i10, CharSequence charSequence, CharSequence charSequence2, boolean z10, boolean z11, e eVar2) {
        super(2, eVar2);
        this.f9207j = eVar;
        this.f9208k = videoPeriodEnum;
        this.f9209l = i10;
        this.f9210m = charSequence;
        this.f9211n = charSequence2;
        this.f9212o = z10;
        this.f9213p = z11;
    }

    public final e create(Object obj, e eVar) {
        return new d(this.f9207j, this.f9208k, this.f9209l, this.f9210m, this.f9211n, this.f9212o, this.f9213p, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9206i;
        e eVar = this.f9207j;
        if (i10 == 0) {
            h0.O1(obj);
            f fVar = eVar.f9215q0;
            j.c(fVar);
            FloatingActionButton floatingActionButton = (FloatingActionButton) fVar.f17638b.f898e;
            j.e("binding.recyclerViewLayout.scrollTop", floatingActionButton);
            h0.J0(floatingActionButton);
            x3 x3Var = eVar.f9218t0;
            if (x3Var != null) {
                u3.f11503c.getClass();
                u3 u3Var = u3.f11504d;
                this.f9206i = 1;
                if (x3Var.d(u3Var, this) == aVar) {
                    return aVar;
                }
            } else {
                j.l("pagingAdapter");
                throw null;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i11 = e.f9214u0;
        ClipsViewModel s02 = eVar.s0();
        int i12 = this.f9209l;
        String A = eVar.A(R.string.sort_and_period, this.f9210m, this.f9211n);
        j.e("getString(R.string.sort_…od, sortText, periodText)", A);
        boolean z10 = this.f9212o;
        boolean z11 = this.f9213p;
        VideoPeriodEnum videoPeriodEnum = this.f9208k;
        j.f("period", videoPeriodEnum);
        e1 e1Var = s02.f3375i;
        Boolean valueOf = Boolean.valueOf(z10);
        ((g) e1Var.getValue()).getClass();
        e1Var.k(new g(valueOf, videoPeriodEnum, i12));
        s02.f3373g.l(A);
        h0.b1(h0.I0(s02), (h) null, 0, new h(s02, z10, videoPeriodEnum, i12, z11, (e) null), 3);
        return v.f9814a;
    }
}
