package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.j5;
import androidx.fragment.app.f0;
import b0.e;
import b0.m;
import b0.q0;
import com.woxthebox.draglistview.R;
import g.b1;
import g.k0;
import g.n;
import g.o;
import g.p;
import g.s0;
import g.t;
import hb.h0;
import xa.j;

public class a extends f0 implements p {
    public k0 D;

    public a() {
        this.f451l.f14540b.c("androidx:appcompat", new n(this));
        p(new o(this, 0));
    }

    public final t D() {
        if (this.D == null) {
            s0 s0Var = t.f6208h;
            this.D = new k0(this, (Window) null, this, this);
        }
        return this.D;
    }

    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        D().a(view, layoutParams);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(D().c(context));
    }

    public final void closeOptionsMenu() {
        ((k0) D()).S();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    public final void d() {
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((k0) D()).S();
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void f() {
    }

    public final View findViewById(int i10) {
        return D().d(i10);
    }

    public final void g() {
    }

    public final MenuInflater getMenuInflater() {
        return D().j();
    }

    public final Resources getResources() {
        int i10 = j5.f901a;
        return super.getResources();
    }

    public final void invalidateOptionsMenu() {
        D().m();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        D().o();
    }

    public final void onContentChanged() {
    }

    public void onDestroy() {
        super.onDestroy();
        D().q();
    }

    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        boolean z10;
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        Intent a10;
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        k0 k0Var = (k0) D();
        k0Var.S();
        b1 b1Var = k0Var.f6171v;
        if (menuItem.getItemId() != 16908332 || b1Var == null || (b1Var.b() & 4) == 0 || (a10 = b0.n.a(this)) == null) {
            return false;
        }
        if (m.c(this, a10)) {
            q0 q0Var = new q0(this);
            Intent a11 = b0.n.a(this);
            if (a11 == null) {
                a11 = b0.n.a(this);
            }
            if (a11 != null) {
                ComponentName component = a11.getComponent();
                if (component == null) {
                    component = a11.resolveActivity(q0Var.f2408i.getPackageManager());
                }
                q0Var.a(component);
                q0Var.f2407h.add(a11);
            }
            q0Var.b();
            try {
                int i11 = e.f2338b;
                b0.a.a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            m.b(this, a10);
            return true;
        }
    }

    public final boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    public final void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((k0) D()).M();
    }

    public final void onPostResume() {
        super.onPostResume();
        D().r();
    }

    public final void onStart() {
        super.onStart();
        D().s();
    }

    public final void onStop() {
        super.onStop();
        D().t();
    }

    public final void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        D().B(charSequence);
    }

    public final void openOptionsMenu() {
        ((k0) D()).S();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public final void setContentView(int i10) {
        u();
        D().x(i10);
    }

    public final void setTheme(int i10) {
        super.setTheme(i10);
        D().A(i10);
    }

    public final void u() {
        h0.B1(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        j.f("<this>", decorView);
        decorView.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView2 = getWindow().getDecorView();
        j.f("<this>", decorView2);
        decorView2.setTag(R.id.view_tree_saved_state_registry_owner, this);
        h0.A1(getWindow().getDecorView(), this);
    }

    public void setContentView(View view) {
        u();
        D().y(view);
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        D().z(view, layoutParams);
    }
}
