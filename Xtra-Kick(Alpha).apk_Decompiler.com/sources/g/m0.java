package g;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.m;
import m0.o;

public class m0 extends m implements p {

    /* renamed from: j  reason: collision with root package name */
    public k0 f6180j;

    /* renamed from: k  reason: collision with root package name */
    public final l0 f6181k;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m0(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 2130968981(0x7f040195, float:1.754663E38)
            if (r6 != 0) goto L_0x0015
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r5.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L_0x0016
        L_0x0015:
            r2 = r6
        L_0x0016:
            r4.<init>(r5, r2)
            g.l0 r2 = new g.l0
            r2.<init>(r4)
            r4.f6181k = r2
            g.t r2 = r4.e()
            if (r6 != 0) goto L_0x0034
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r5.resolveAttribute(r1, r6, r0)
            int r6 = r6.resourceId
        L_0x0034:
            r5 = r2
            g.k0 r5 = (g.k0) r5
            r5.f6152b0 = r6
            r2.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.m0.<init>(android.content.Context, int):void");
    }

    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e().a(view, layoutParams);
    }

    public final void d() {
    }

    public final void dismiss() {
        super.dismiss();
        e().q();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return o.b(this.f6181k, getWindow().getDecorView(), this, keyEvent);
    }

    public final t e() {
        if (this.f6180j == null) {
            s0 s0Var = t.f6208h;
            this.f6180j = new k0(getContext(), getWindow(), this, this);
        }
        return this.f6180j;
    }

    public final void f() {
    }

    public final View findViewById(int i10) {
        return e().d(i10);
    }

    public final void g() {
    }

    /* access modifiers changed from: package-private */
    public final boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void invalidateOptionsMenu() {
        e().m();
    }

    public void onCreate(Bundle bundle) {
        e().k();
        super.onCreate(bundle);
        e().p();
    }

    public final void onStop() {
        super.onStop();
        e().t();
    }

    public void setContentView(int i10) {
        e().x(i10);
    }

    public final void setTitle(int i10) {
        super.setTitle(i10);
        e().B(getContext().getString(i10));
    }

    public void setContentView(View view) {
        e().y(view);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().B(charSequence);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e().z(view, layoutParams);
    }
}
