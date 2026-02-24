package y8;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.woxthebox.draglistview.R;
import i3.i;

public final class u extends o {

    /* renamed from: e  reason: collision with root package name */
    public final int f17219e = R.drawable.design_password_eye;

    /* renamed from: f  reason: collision with root package name */
    public EditText f17220f;

    /* renamed from: g  reason: collision with root package name */
    public final i f17221g = new i(25, this);

    public u(n nVar, int i10) {
        super(nVar);
        if (i10 != 0) {
            this.f17219e = i10;
        }
    }

    public final void b() {
        q();
    }

    public final int c() {
        return R.string.password_toggle_content_description;
    }

    public final int d() {
        return this.f17219e;
    }

    public final View.OnClickListener f() {
        return this.f17221g;
    }

    public final boolean k() {
        return true;
    }

    public final boolean l() {
        EditText editText = this.f17220f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    public final void m(EditText editText) {
        this.f17220f = editText;
        q();
    }

    public final void r() {
        boolean z10;
        EditText editText = this.f17220f;
        if (editText == null || !(editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            this.f17220f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final void s() {
        EditText editText = this.f17220f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
