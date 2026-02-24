package y8;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import n0.d;
import n0.i;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout f17174a;

    /* renamed from: b  reason: collision with root package name */
    public final n f17175b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f17176c;

    /* renamed from: d  reason: collision with root package name */
    public final CheckableImageButton f17177d;

    public o(n nVar) {
        this.f17174a = nVar.f17155h;
        this.f17175b = nVar;
        this.f17176c = nVar.getContext();
        this.f17177d = nVar.f17161n;
    }

    public void a() {
    }

    public void b() {
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public d h() {
        return null;
    }

    public boolean i(int i10) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof k;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText editText) {
    }

    public void n(i iVar) {
    }

    public void o(AccessibilityEvent accessibilityEvent) {
    }

    public void p(boolean z10) {
    }

    public final void q() {
        this.f17175b.e(false);
    }

    public abstract void r();

    public void s() {
    }
}
