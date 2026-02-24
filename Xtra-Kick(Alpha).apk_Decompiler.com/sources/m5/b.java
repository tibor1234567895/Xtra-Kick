package m5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import c0.c;
import c0.g;
import d0.k;
import d0.s;
import h.a;
import l.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f10605a = true;

    private b() {
    }

    public static Drawable a(Context context, Context context2, int i10, Resources.Theme theme) {
        try {
            if (f10605a) {
                return b(context2, i10, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f10605a = false;
        } catch (IllegalStateException e10) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                Object obj = g.f2717a;
                return c.b(context2, i10);
            }
            throw e10;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal threadLocal = s.f4115a;
        return k.a(resources, i10, theme);
    }

    public static Drawable b(Context context, int i10, Resources.Theme theme) {
        if (theme != null) {
            f fVar = new f(context, theme);
            fVar.a(theme.getResources().getConfiguration());
            context = fVar;
        }
        return a.a(context, i10);
    }
}
