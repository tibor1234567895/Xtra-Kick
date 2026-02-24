package androidx.appcompat.widget;

import android.view.View;
import m0.o1;

public final class a implements o1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f714a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ActionBarContextView f716c;

    public a(ActionBarContextView actionBarContextView) {
        this.f716c = actionBarContextView;
    }

    public final void a() {
        if (!this.f714a) {
            ActionBarContextView actionBarContextView = this.f716c;
            actionBarContextView.f590m = null;
            a.super.setVisibility(this.f715b);
        }
    }

    public final void b(View view) {
        this.f714a = true;
    }

    public final void c() {
        a.super.setVisibility(0);
        this.f714a = false;
    }
}
