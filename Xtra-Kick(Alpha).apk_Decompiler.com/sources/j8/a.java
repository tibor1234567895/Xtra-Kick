package j8;

import android.content.Context;
import android.graphics.Color;
import com.woxthebox.draglistview.R;
import q8.c;

public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f8842f = ((int) Math.round(5.1000000000000005d));

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8843a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8844b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8845c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8846d;

    /* renamed from: e  reason: collision with root package name */
    public final float f8847e;

    public a(Context context) {
        boolean b10 = c.b(context, R.attr.elevationOverlayEnabled, false);
        int a10 = g8.a.a(context, R.attr.elevationOverlayColor, 0);
        int a11 = g8.a.a(context, R.attr.elevationOverlayAccentColor, 0);
        int a12 = g8.a.a(context, R.attr.colorSurface, 0);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f8843a = b10;
        this.f8844b = a10;
        this.f8845c = a11;
        this.f8846d = a12;
        this.f8847e = f10;
    }

    public final int a(int i10, float f10) {
        boolean z10;
        float f11;
        int i11;
        if (!this.f8843a) {
            return i10;
        }
        if (e0.a.d(i10, 255) == this.f8846d) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return i10;
        }
        float f12 = this.f8847e;
        if (f12 <= 0.0f || f10 <= 0.0f) {
            f11 = 0.0f;
        } else {
            f11 = Math.min(((((float) Math.log1p((double) (f10 / f12))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        int alpha = Color.alpha(i10);
        int d10 = g8.a.d(e0.a.d(i10, 255), f11, this.f8844b);
        if (f11 > 0.0f && (i11 = this.f8845c) != 0) {
            d10 = e0.a.b(e0.a.d(i11, f8842f), d10);
        }
        return e0.a.d(d10, alpha);
    }
}
