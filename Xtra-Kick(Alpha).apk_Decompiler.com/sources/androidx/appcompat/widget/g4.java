package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.os.Build;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

public final class g4 {

    /* renamed from: a  reason: collision with root package name */
    public final Method f836a = null;

    /* renamed from: b  reason: collision with root package name */
    public final Method f837b = null;

    /* renamed from: c  reason: collision with root package name */
    public final Method f838c = null;

    @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
    public g4() {
        Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
        a();
        try {
            Method declaredMethod = cls.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.f836a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        try {
            Method declaredMethod2 = cls.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.f837b = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.f838c = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused3) {
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
