package b0;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.d1;
import androidx.lifecycle.g0;
import androidx.lifecycle.g1;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import m0.n;
import m0.o;

public class k extends Activity implements d0, n {

    /* renamed from: h  reason: collision with root package name */
    public final g0 f2368h = new g0(this);

    public k() {
        new q.k();
    }

    public final boolean b(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !o.a(decorView, keyEvent)) {
            return o.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !o.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public t o() {
        return this.f2368h;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g1.f1694i.getClass();
        d1.b(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        s sVar = s.CREATED;
        g0 g0Var = this.f2368h;
        g0Var.getClass();
        g0Var.e("markState");
        g0Var.h(sVar);
        super.onSaveInstanceState(bundle);
    }
}
