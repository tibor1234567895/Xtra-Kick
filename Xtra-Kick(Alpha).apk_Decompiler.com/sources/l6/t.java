package l6;

import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.j3;
import com.github.andreyasadchy.xtra.ui.view.CustomSwipeRefreshLayout;
import hb.h0;
import la.v;
import n3.a1;
import n3.x0;
import n3.x3;
import n3.z;
import pa.e;
import ra.i;
import wa.p;
import xa.j;

public final class t extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f9666i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ j3 f9667j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ x3 f9668k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f9669l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(j3 j3Var, x3 x3Var, e eVar, boolean z10) {
        super(2, eVar);
        this.f9667j = j3Var;
        this.f9668k = x3Var;
        this.f9669l = z10;
    }

    public final e create(Object obj, e eVar) {
        t tVar = new t(this.f9667j, this.f9668k, eVar, this.f9669l);
        tVar.f9666i = obj;
        return tVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((t) create((z) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        int i10;
        boolean z11;
        h0.O1(obj);
        z zVar = (z) this.f9666i;
        j3 j3Var = this.f9667j;
        ProgressBar progressBar = (ProgressBar) j3Var.f896c;
        j.e("progressBar", progressBar);
        boolean z12 = zVar.f11594a instanceof x0;
        boolean z13 = true;
        x3 x3Var = this.f9668k;
        int i11 = 0;
        if (!z12 || x3Var.getItemCount() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        progressBar.setVisibility(i10);
        boolean z14 = this.f9669l;
        a1 a1Var = zVar.f11594a;
        if (z14) {
            CustomSwipeRefreshLayout customSwipeRefreshLayout = (CustomSwipeRefreshLayout) j3Var.f899f;
            if (!(a1Var instanceof x0) || x3Var.getItemCount() == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            customSwipeRefreshLayout.setRefreshing(z11);
        }
        TextView textView = (TextView) j3Var.f895b;
        j.e("nothingHere", textView);
        if ((a1Var instanceof x0) || x3Var.getItemCount() != 0) {
            z13 = false;
        }
        if (!z13) {
            i11 = 8;
        }
        textView.setVisibility(i11);
        return v.f9814a;
    }
}
