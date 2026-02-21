package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v1;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

public final class m extends v1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y f3764a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialButton f3765b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f3766c;

    public m(n nVar, y yVar, MaterialButton materialButton) {
        this.f3766c = nVar;
        this.f3764a = yVar;
        this.f3765b = materialButton;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        if (i10 == 0) {
            recyclerView.announceForAccessibility(this.f3765b.getText());
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        int i12;
        n nVar = this.f3766c;
        if (i10 < 0) {
            i12 = ((LinearLayoutManager) nVar.f3775l0.getLayoutManager()).X0();
        } else {
            i12 = ((LinearLayoutManager) nVar.f3775l0.getLayoutManager()).Y0();
        }
        y yVar = this.f3764a;
        Calendar b10 = c0.b(yVar.f3807a.f3744h.f3791h);
        b10.add(2, i12);
        nVar.f3771h0 = new u(b10);
        Calendar b11 = c0.b(yVar.f3807a.f3744h.f3791h);
        b11.add(2, i12);
        this.f3765b.setText(new u(b11).w());
    }
}
