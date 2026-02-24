package o6;

import android.content.Context;
import android.content.SharedPreferences;
import com.github.andreyasadchy.xtra.XtraApp;
import com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum;
import com.github.andreyasadchy.xtra.model.ui.FollowSortEnum;
import com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel;
import com.woxthebox.draglistview.R;
import hb.f0;
import hb.h0;
import kb.e1;
import la.v;
import n3.u3;
import pa.e;
import pa.h;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class d extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f12242i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ e f12243j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FollowSortEnum f12244k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FollowOrderEnum f12245l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ CharSequence f12246m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ CharSequence f12247n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f12248o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar, FollowSortEnum followSortEnum, FollowOrderEnum followOrderEnum, CharSequence charSequence, CharSequence charSequence2, boolean z10, e eVar2) {
        super(2, eVar2);
        this.f12243j = eVar;
        this.f12244k = followSortEnum;
        this.f12245l = followOrderEnum;
        this.f12246m = charSequence;
        this.f12247n = charSequence2;
        this.f12248o = z10;
    }

    public final e create(Object obj, e eVar) {
        return new d(this.f12243j, this.f12244k, this.f12245l, this.f12246m, this.f12247n, this.f12248o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f12242i;
        e eVar = this.f12243j;
        if (i10 == 0) {
            h0.O1(obj);
            c cVar = eVar.f12252r0;
            if (cVar != null) {
                u3.f11503c.getClass();
                u3 u3Var = u3.f11504d;
                this.f12242i = 1;
                if (cVar.d(u3Var, this) == aVar) {
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
        int i11 = e.f12249s0;
        FollowedChannelsViewModel s02 = eVar.s0();
        String A = eVar.A(R.string.sort_and_order, this.f12246m, this.f12247n);
        j.e("getString(R.string.sort_…der, sortText, orderText)", A);
        FollowSortEnum followSortEnum = this.f12244k;
        j.f("sort", followSortEnum);
        FollowOrderEnum followOrderEnum = this.f12245l;
        j.f("order", followOrderEnum);
        e1 e1Var = s02.f3407i;
        ((l) e1Var.getValue()).getClass();
        e1Var.k(new l(followSortEnum, followOrderEnum));
        s02.f3406h.l(A);
        boolean z10 = this.f12248o;
        if (z10) {
            h0.b1(h0.I0(s02), (h) null, 0, new m(s02, followSortEnum, followOrderEnum, (e) null), 3);
        }
        XtraApp.f3319k.getClass();
        Context applicationContext = y5.v.a().getApplicationContext();
        j.e("appContext", applicationContext);
        if (z10 != h0.l1(applicationContext).getBoolean("sort_default_followed_channels", false)) {
            SharedPreferences.Editor edit = h0.l1(applicationContext).edit();
            j.e("editor", edit);
            edit.putBoolean("sort_default_followed_channels", z10);
            edit.apply();
        }
        return v.f9814a;
    }
}
