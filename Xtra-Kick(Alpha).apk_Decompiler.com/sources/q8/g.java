package q8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import d0.p;
import d0.s;
import v7.a;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f13417a;

    /* renamed from: b  reason: collision with root package name */
    public final String f13418b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13419c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13420d;

    /* renamed from: e  reason: collision with root package name */
    public final float f13421e;

    /* renamed from: f  reason: collision with root package name */
    public final float f13422f;

    /* renamed from: g  reason: collision with root package name */
    public final float f13423g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f13424h;

    /* renamed from: i  reason: collision with root package name */
    public final float f13425i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f13426j;

    /* renamed from: k  reason: collision with root package name */
    public float f13427k;

    /* renamed from: l  reason: collision with root package name */
    public final int f13428l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f13429m = false;

    /* renamed from: n  reason: collision with root package name */
    public Typeface f13430n;

    public g(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, a.H);
        this.f13427k = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f13426j = d.a(context, obtainStyledAttributes, 3);
        d.a(context, obtainStyledAttributes, 4);
        d.a(context, obtainStyledAttributes, 5);
        this.f13419c = obtainStyledAttributes.getInt(2, 0);
        this.f13420d = obtainStyledAttributes.getInt(1, 1);
        int i11 = !obtainStyledAttributes.hasValue(12) ? 10 : 12;
        this.f13428l = obtainStyledAttributes.getResourceId(i11, 0);
        this.f13418b = obtainStyledAttributes.getString(i11);
        obtainStyledAttributes.getBoolean(14, false);
        this.f13417a = d.a(context, obtainStyledAttributes, 6);
        this.f13421e = obtainStyledAttributes.getFloat(7, 0.0f);
        this.f13422f = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f13423g = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i10, a.f15954w);
        this.f13424h = obtainStyledAttributes2.hasValue(0);
        this.f13425i = obtainStyledAttributes2.getFloat(0, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f13430n;
        int i10 = this.f13419c;
        if (typeface == null && (str = this.f13418b) != null) {
            this.f13430n = Typeface.create(str, i10);
        }
        if (this.f13430n == null) {
            int i11 = this.f13420d;
            this.f13430n = i11 != 1 ? i11 != 2 ? i11 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.f13430n = Typeface.create(this.f13430n, i10);
        }
    }

    public final Typeface b(Context context) {
        Typeface typeface;
        if (this.f13429m) {
            return this.f13430n;
        }
        if (!context.isRestricted()) {
            try {
                int i10 = this.f13428l;
                ThreadLocal threadLocal = s.f4115a;
                if (context.isRestricted()) {
                    typeface = null;
                } else {
                    typeface = s.b(context, i10, new TypedValue(), 0, (p) null, false, false);
                }
                this.f13430n = typeface;
                if (typeface != null) {
                    this.f13430n = Typeface.create(typeface, this.f13419c);
                }
            } catch (Resources.NotFoundException | Exception | UnsupportedOperationException unused) {
            }
        }
        a();
        this.f13429m = true;
        return this.f13430n;
    }

    public final void c(Context context, h hVar) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i10 = this.f13428l;
        if (i10 == 0) {
            this.f13429m = true;
        }
        if (this.f13429m) {
            hVar.b(this.f13430n, true);
            return;
        }
        try {
            e eVar = new e(this, hVar);
            ThreadLocal threadLocal = s.f4115a;
            if (context.isRestricted()) {
                eVar.a(-4);
                return;
            }
            s.b(context, i10, new TypedValue(), 0, eVar, false, false);
        } catch (Resources.NotFoundException unused) {
            this.f13429m = true;
            hVar.a(1);
        } catch (Exception unused2) {
            this.f13429m = true;
            hVar.a(-3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001f A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(android.content.Context r8) {
        /*
            r7 = this;
            int r1 = r7.f13428l
            if (r1 == 0) goto L_0x001c
            java.lang.ThreadLocal r0 = d0.s.f4115a
            boolean r0 = r8.isRestricted()
            if (r0 == 0) goto L_0x000d
            goto L_0x001c
        L_0x000d:
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1
            r0 = r8
            android.graphics.Typeface r8 = d0.s.b(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x001d
        L_0x001c:
            r8 = 0
        L_0x001d:
            if (r8 == 0) goto L_0x0021
            r8 = 1
            goto L_0x0022
        L_0x0021:
            r8 = 0
        L_0x0022:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.g.d(android.content.Context):boolean");
    }

    public final void e(Context context, TextPaint textPaint, h hVar) {
        f(context, textPaint, hVar);
        ColorStateList colorStateList = this.f13426j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f13417a;
        textPaint.setShadowLayer(this.f13423g, this.f13421e, this.f13422f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, h hVar) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.f13430n);
        c(context, new f(this, context, textPaint, hVar));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        boolean z10;
        float f10;
        Typeface a10 = j.a(context.getResources().getConfiguration(), typeface);
        if (a10 != null) {
            typeface = a10;
        }
        textPaint.setTypeface(typeface);
        int i10 = (~typeface.getStyle()) & this.f13419c;
        if ((i10 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        textPaint.setFakeBoldText(z10);
        if ((i10 & 2) != 0) {
            f10 = -0.25f;
        } else {
            f10 = 0.0f;
        }
        textPaint.setTextSkewX(f10);
        textPaint.setTextSize(this.f13427k);
        if (this.f13424h) {
            textPaint.setLetterSpacing(this.f13425i);
        }
    }
}
