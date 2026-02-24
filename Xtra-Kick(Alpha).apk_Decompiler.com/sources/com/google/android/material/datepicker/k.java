package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a1;
import androidx.recyclerview.widget.g2;

public final class k extends LinearLayoutManager {
    public final /* synthetic */ int L;
    public final /* synthetic */ n M;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(n nVar, int i10, int i11) {
        super(i10);
        this.M = nVar;
        this.L = i11;
    }

    public final void K0(RecyclerView recyclerView, int i10) {
        a1 a1Var = new a1(3, recyclerView.getContext(), this);
        a1Var.f1983a = i10;
        L0(a1Var);
    }

    public final void N0(g2 g2Var, int[] iArr) {
        int i10 = this.L;
        n nVar = this.M;
        if (i10 == 0) {
            iArr[0] = nVar.f3775l0.getWidth();
            iArr[1] = nVar.f3775l0.getWidth();
            return;
        }
        iArr[0] = nVar.f3775l0.getHeight();
        iArr[1] = nVar.f3775l0.getHeight();
    }
}
