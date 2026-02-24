package g6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import c0.c;
import c0.g;
import com.woxthebox.draglistview.R;
import f0.b;
import f0.d;
import xa.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6840a = new a();

    private a() {
    }

    public static Drawable a(Context context) {
        j.f("context", context);
        Object obj = g.f2717a;
        Drawable b10 = c.b(context, R.drawable.baseline_arrow_back_black_24);
        j.c(b10);
        Drawable g10 = d.g(b10);
        j.e("wrap(ContextCompat.getDr…e_arrow_back_black_24)!!)", g10);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.textColor, typedValue, true);
        b.g(g10, typedValue.data);
        f0.a.e(g10, true);
        return g10;
    }
}
