package p8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.s0;
import com.woxthebox.draglistview.R;
import m8.r;
import q0.b;
import q8.d;

public final class a extends s0 {

    /* renamed from: n  reason: collision with root package name */
    public static final int[][] f12627n = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f12628l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f12629m;

    public a(Context context, AttributeSet attributeSet) {
        super(a9.a.a(context, attributeSet, R.attr.radioButtonStyle, 2132018313), attributeSet, 0);
        Context context2 = getContext();
        TypedArray d10 = r.d(context2, attributeSet, v7.a.f15952u, R.attr.radioButtonStyle, 2132018313, new int[0]);
        if (d10.hasValue(0)) {
            b.c(this, d.a(context2, d10, 0));
        }
        this.f12629m = d10.getBoolean(1, false);
        d10.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f12628l == null) {
            int b10 = g8.a.b(this, R.attr.colorControlActivated);
            int b11 = g8.a.b(this, R.attr.colorOnSurface);
            int b12 = g8.a.b(this, R.attr.colorSurface);
            this.f12628l = new ColorStateList(f12627n, new int[]{g8.a.d(b12, 1.0f, b10), g8.a.d(b12, 0.54f, b11), g8.a.d(b12, 0.38f, b11), g8.a.d(b12, 0.38f, b11)});
        }
        return this.f12628l;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12629m && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        ColorStateList colorStateList;
        this.f12629m = z10;
        if (z10) {
            colorStateList = getMaterialThemeColorsTintList();
        } else {
            colorStateList = null;
        }
        b.c(this, colorStateList);
    }
}
