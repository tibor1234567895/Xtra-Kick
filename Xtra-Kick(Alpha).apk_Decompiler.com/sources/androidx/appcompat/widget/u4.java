package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import c0.g;
import d0.s;

public final class u4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1099a;

    /* renamed from: b  reason: collision with root package name */
    public final TypedArray f1100b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f1101c;

    public u4(Context context, TypedArray typedArray) {
        this.f1099a = context;
        this.f1100b = typedArray;
    }

    public static u4 m(Context context, AttributeSet attributeSet, int[] iArr, int i10) {
        return new u4(context, context.obtainStyledAttributes(attributeSet, iArr, i10, 0));
    }

    public final boolean a(int i10, boolean z10) {
        return this.f1100b.getBoolean(i10, z10);
    }

    public final ColorStateList b(int i10) {
        int resourceId;
        ColorStateList c10;
        TypedArray typedArray = this.f1100b;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (c10 = g.c(this.f1099a, resourceId)) == null) {
            return typedArray.getColorStateList(i10);
        }
        return c10;
    }

    public final int c(int i10, int i11) {
        return this.f1100b.getDimensionPixelOffset(i10, i11);
    }

    public final int d(int i10, int i11) {
        return this.f1100b.getDimensionPixelSize(i10, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r0.getResourceId(r3, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable e(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1100b
            boolean r1 = r0.hasValue(r3)
            if (r1 == 0) goto L_0x0016
            r1 = 0
            int r1 = r0.getResourceId(r3, r1)
            if (r1 == 0) goto L_0x0016
            android.content.Context r3 = r2.f1099a
            android.graphics.drawable.Drawable r3 = h.a.a(r3, r1)
            return r3
        L_0x0016:
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u4.e(int):android.graphics.drawable.Drawable");
    }

    public final Drawable f(int i10) {
        int resourceId;
        Drawable g10;
        if (!this.f1100b.hasValue(i10) || (resourceId = this.f1100b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        h0 a10 = h0.a();
        Context context = this.f1099a;
        synchronized (a10) {
            g10 = a10.f845a.g(context, resourceId, true);
        }
        return g10;
    }

    public final Typeface g(int i10, int i11, j1 j1Var) {
        int resourceId = this.f1100b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1101c == null) {
            this.f1101c = new TypedValue();
        }
        TypedValue typedValue = this.f1101c;
        ThreadLocal threadLocal = s.f4115a;
        Context context = this.f1099a;
        if (context.isRestricted()) {
            return null;
        }
        return s.b(context, resourceId, typedValue, i11, j1Var, true, false);
    }

    public final int h(int i10, int i11) {
        return this.f1100b.getInt(i10, i11);
    }

    public final int i(int i10, int i11) {
        return this.f1100b.getResourceId(i10, i11);
    }

    public final String j(int i10) {
        return this.f1100b.getString(i10);
    }

    public final CharSequence k(int i10) {
        return this.f1100b.getText(i10);
    }

    public final boolean l(int i10) {
        return this.f1100b.hasValue(i10);
    }

    public final void n() {
        this.f1100b.recycle();
    }
}
