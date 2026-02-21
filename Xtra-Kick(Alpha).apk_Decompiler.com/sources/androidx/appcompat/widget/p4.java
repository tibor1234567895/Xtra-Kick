package androidx.appcompat.widget;

import android.widget.EditText;
import androidx.emoji2.text.l;
import java.lang.ref.WeakReference;
import w0.n;

public final class p4 extends l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f989a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference f990b;

    public p4(EditText editText) {
        this.f990b = new WeakReference(editText);
    }

    public final void a() {
        switch (this.f989a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f990b.get();
                if (switchCompat != null) {
                    switchCompat.d();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void b() {
        WeakReference weakReference = this.f990b;
        switch (this.f989a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) weakReference.get();
                if (switchCompat != null) {
                    switchCompat.d();
                    return;
                }
                return;
            default:
                n.a((EditText) weakReference.get(), 1);
                return;
        }
    }

    public p4(SwitchCompat switchCompat) {
        this.f990b = new WeakReference(switchCompat);
    }
}
