package g8;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import c0.g;
import q8.c;

public final class a {
    private a() {
    }

    public static int a(Context context, int i10, int i11) {
        TypedValue a10 = c.a(context, i10);
        if (a10 == null) {
            return i11;
        }
        int i12 = a10.resourceId;
        if (i12 != 0) {
            return g.b(context, i12);
        }
        return a10.data;
    }

    public static int b(View view, int i10) {
        Context context = view.getContext();
        TypedValue c10 = c.c(i10, view.getContext(), view.getClass().getCanonicalName());
        int i11 = c10.resourceId;
        if (i11 != 0) {
            return g.b(context, i11);
        }
        return c10.data;
    }

    public static boolean c(int i10) {
        double d10;
        double d11;
        double d12;
        if (i10 != 0) {
            ThreadLocal threadLocal = e0.a.f4854a;
            double[] dArr = (double[]) threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int red = Color.red(i10);
            int green = Color.green(i10);
            int blue = Color.blue(i10);
            if (dArr.length == 3) {
                double d13 = ((double) red) / 255.0d;
                if (d13 < 0.04045d) {
                    d10 = d13 / 12.92d;
                } else {
                    d10 = Math.pow((d13 + 0.055d) / 1.055d, 2.4d);
                }
                double d14 = ((double) green) / 255.0d;
                if (d14 < 0.04045d) {
                    d11 = d14 / 12.92d;
                } else {
                    d11 = Math.pow((d14 + 0.055d) / 1.055d, 2.4d);
                }
                double d15 = ((double) blue) / 255.0d;
                if (d15 < 0.04045d) {
                    d12 = d15 / 12.92d;
                } else {
                    d12 = Math.pow((d15 + 0.055d) / 1.055d, 2.4d);
                }
                dArr[0] = ((0.1805d * d12) + (0.3576d * d11) + (0.4124d * d10)) * 100.0d;
                double d16 = ((0.0722d * d12) + (0.7152d * d11) + (0.2126d * d10)) * 100.0d;
                dArr[1] = d16;
                double d17 = d12 * 0.9505d;
                dArr[2] = (d17 + (d11 * 0.1192d) + (d10 * 0.0193d)) * 100.0d;
                if (d16 / 100.0d > 0.5d) {
                    return true;
                }
            } else {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
        }
        return false;
    }

    public static int d(int i10, float f10, int i11) {
        return e0.a.b(e0.a.d(i11, Math.round(((float) Color.alpha(i11)) * f10)), i10);
    }
}
