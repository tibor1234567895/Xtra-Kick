package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

public final class i implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3758h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y f3759i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ n f3760j;

    public /* synthetic */ i(n nVar, y yVar, int i10) {
        this.f3758h = i10;
        this.f3760j = nVar;
        this.f3759i = yVar;
    }

    public final void onClick(View view) {
        int i10 = this.f3758h;
        y yVar = this.f3759i;
        n nVar = this.f3760j;
        switch (i10) {
            case 0:
                int Y0 = ((LinearLayoutManager) nVar.f3775l0.getLayoutManager()).Y0() - 1;
                if (Y0 >= 0) {
                    Calendar b10 = c0.b(yVar.f3807a.f3744h.f3791h);
                    b10.add(2, Y0);
                    nVar.m0(new u(b10));
                    return;
                }
                return;
            default:
                int X0 = ((LinearLayoutManager) nVar.f3775l0.getLayoutManager()).X0() + 1;
                if (X0 < nVar.f3775l0.getAdapter().getItemCount()) {
                    Calendar b11 = c0.b(yVar.f3807a.f3744h.f3791h);
                    b11.add(2, X0);
                    nVar.m0(new u(b11));
                    return;
                }
                return;
        }
    }
}
