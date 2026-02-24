package w0;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.f0;

public final class d extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f16020a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f16021b;

    /* renamed from: c  reason: collision with root package name */
    public static Class f16022c;

    @SuppressLint({"PrivateApi"})
    private d() {
        try {
            f16022c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, d.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f16021b == null) {
            synchronized (f16020a) {
                if (f16021b == null) {
                    f16021b = new d();
                }
            }
        }
        return f16021b;
    }

    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f16022c;
        if (cls != null) {
            return new f0(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
