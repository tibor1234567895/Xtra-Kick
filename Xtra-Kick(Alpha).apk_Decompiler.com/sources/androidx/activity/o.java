package androidx.activity;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class o implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f492a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f493b;

    public /* synthetic */ o(Runnable runnable, int i10) {
        this.f492a = i10;
        this.f493b = runnable;
    }

    public final void onBackInvoked() {
        switch (this.f492a) {
        }
        this.f493b.run();
    }
}
