package g;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.t1;
import com.woxthebox.draglistview.R;
import java.lang.reflect.Constructor;
import q.k;

public class p0 {

    /* renamed from: b  reason: collision with root package name */
    public static final Class[] f6190b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f6191c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f6192d = {16844160};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f6193e = {16844156};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f6194f = {16844148};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f6195g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h  reason: collision with root package name */
    public static final k f6196h = new k();

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f6197a = new Object[2];

    public a0 a(Context context, AttributeSet attributeSet) {
        return new a0(context, attributeSet);
    }

    public c0 b(Context context, AttributeSet attributeSet) {
        return new c0(context, attributeSet, R.attr.buttonStyle);
    }

    public d0 c(Context context, AttributeSet attributeSet) {
        return new d0(context, attributeSet, R.attr.checkboxStyle);
    }

    public s0 d(Context context, AttributeSet attributeSet) {
        return new s0(context, attributeSet);
    }

    public t1 e(Context context, AttributeSet attributeSet) {
        return new t1(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String str3;
        k kVar = f6196h;
        Constructor<? extends U> constructor = (Constructor) kVar.getOrDefault(str, (Object) null);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f6190b);
            kVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f6197a);
    }
}
