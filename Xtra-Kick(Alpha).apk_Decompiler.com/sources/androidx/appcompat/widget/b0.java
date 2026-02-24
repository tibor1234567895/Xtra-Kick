package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Base64;
import android.view.View;
import java.util.List;
import java.util.WeakHashMap;
import l0.f;
import m0.c1;
import m0.o0;
import q8.d;
import t8.n;
import v7.a;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f729a;

    /* renamed from: b  reason: collision with root package name */
    public int f730b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f731c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f732d;

    /* renamed from: e  reason: collision with root package name */
    public Object f733e;

    /* renamed from: f  reason: collision with root package name */
    public Object f734f;

    /* renamed from: g  reason: collision with root package name */
    public Object f735g;

    public b0(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, n nVar, Rect rect) {
        this.f729a = 2;
        f.b(rect.left);
        f.b(rect.top);
        f.b(rect.right);
        f.b(rect.bottom);
        this.f731c = rect;
        this.f732d = colorStateList2;
        this.f733e = colorStateList;
        this.f734f = colorStateList3;
        this.f730b = i10;
        this.f735g = nVar;
    }

    public static b0 b(Context context, int i10) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        f.a("Cannot create a CalendarItemStyle with a styleResId of 0", z10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, a.f15950s);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList a10 = d.a(context, obtainStyledAttributes, 4);
        ColorStateList a11 = d.a(context, obtainStyledAttributes, 9);
        ColorStateList a12 = d.a(context, obtainStyledAttributes, 7);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        n nVar = new n(n.a(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0), new t8.a((float) 0)));
        obtainStyledAttributes.recycle();
        return new b0(a10, a11, a12, dimensionPixelSize, nVar, rect);
    }

    public final void a() {
        boolean z10;
        View view = (View) this.f731c;
        Drawable background = view.getBackground();
        if (background != null) {
            int i10 = Build.VERSION.SDK_INT;
            boolean z11 = true;
            if (i10 <= 21 ? i10 != 21 : ((s4) this.f733e) == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                if (((s4) this.f735g) == null) {
                    this.f735g = new s4();
                }
                s4 s4Var = (s4) this.f735g;
                s4Var.f1055a = null;
                s4Var.f1058d = false;
                s4Var.f1056b = null;
                s4Var.f1057c = false;
                WeakHashMap weakHashMap = c1.f10054a;
                ColorStateList g10 = o0.g(view);
                if (g10 != null) {
                    s4Var.f1058d = true;
                    s4Var.f1055a = g10;
                }
                PorterDuff.Mode h10 = o0.h(view);
                if (h10 != null) {
                    s4Var.f1057c = true;
                    s4Var.f1056b = h10;
                }
                if (s4Var.f1058d || s4Var.f1057c) {
                    h0.e(background, s4Var, view.getDrawableState());
                } else {
                    z11 = false;
                }
                if (z11) {
                    return;
                }
            }
            s4 s4Var2 = (s4) this.f734f;
            if (s4Var2 != null) {
                h0.e(background, s4Var2, view.getDrawableState());
                return;
            }
            s4 s4Var3 = (s4) this.f733e;
            if (s4Var3 != null) {
                h0.e(background, s4Var3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList c() {
        Object obj = this.f734f;
        if (((s4) obj) != null) {
            return ((s4) obj).f1055a;
        }
        return null;
    }

    public final PorterDuff.Mode d() {
        Object obj = this.f734f;
        if (((s4) obj) != null) {
            return ((s4) obj).f1056b;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009b, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009c, code lost:
        r7.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
        throw r9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f731c
            r1 = r0
            android.view.View r1 = (android.view.View) r1
            android.content.Context r2 = r1.getContext()
            int[] r3 = f.a.B
            androidx.appcompat.widget.u4 r7 = androidx.appcompat.widget.u4.m(r2, r9, r3, r10)
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r7.f1100b
            r4 = r9
            r6 = r10
            m0.c1.o(r1, r2, r3, r4, r5, r6)
            r9 = 0
            boolean r10 = r7.l(r9)     // Catch:{ all -> 0x009b }
            r1 = -1
            if (r10 == 0) goto L_0x0046
            int r10 = r7.i(r9, r1)     // Catch:{ all -> 0x009b }
            r8.f730b = r10     // Catch:{ all -> 0x009b }
            java.lang.Object r10 = r8.f732d     // Catch:{ all -> 0x009b }
            androidx.appcompat.widget.h0 r10 = (androidx.appcompat.widget.h0) r10     // Catch:{ all -> 0x009b }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x009b }
            android.content.Context r2 = r2.getContext()     // Catch:{ all -> 0x009b }
            int r3 = r8.f730b     // Catch:{ all -> 0x009b }
            monitor-enter(r10)     // Catch:{ all -> 0x009b }
            androidx.appcompat.widget.q3 r4 = r10.f845a     // Catch:{ all -> 0x0043 }
            android.content.res.ColorStateList r2 = r4.i(r2, r3)     // Catch:{ all -> 0x0043 }
            monitor-exit(r10)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x0046
            r8.h(r2)     // Catch:{ all -> 0x009b }
            goto L_0x0046
        L_0x0043:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x009b }
            throw r9     // Catch:{ all -> 0x009b }
        L_0x0046:
            r10 = 1
            boolean r2 = r7.l(r10)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x0057
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x009b }
            android.content.res.ColorStateList r3 = r7.b(r10)     // Catch:{ all -> 0x009b }
            m0.c1.r(r2, r3)     // Catch:{ all -> 0x009b }
        L_0x0057:
            r2 = 2
            boolean r3 = r7.l(r2)     // Catch:{ all -> 0x009b }
            if (r3 == 0) goto L_0x0097
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x009b }
            int r1 = r7.h(r2, r1)     // Catch:{ all -> 0x009b }
            r2 = 0
            android.graphics.PorterDuff$Mode r1 = androidx.appcompat.widget.i2.d(r1, r2)     // Catch:{ all -> 0x009b }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x009b }
            m0.o0.r(r0, r1)     // Catch:{ all -> 0x009b }
            r1 = 21
            if (r2 != r1) goto L_0x0097
            android.graphics.drawable.Drawable r1 = r0.getBackground()     // Catch:{ all -> 0x009b }
            android.content.res.ColorStateList r2 = m0.o0.g(r0)     // Catch:{ all -> 0x009b }
            if (r2 != 0) goto L_0x0082
            android.graphics.PorterDuff$Mode r2 = m0.o0.h(r0)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x0083
        L_0x0082:
            r9 = 1
        L_0x0083:
            if (r1 == 0) goto L_0x0097
            if (r9 == 0) goto L_0x0097
            boolean r9 = r1.isStateful()     // Catch:{ all -> 0x009b }
            if (r9 == 0) goto L_0x0094
            int[] r9 = r0.getDrawableState()     // Catch:{ all -> 0x009b }
            r1.setState(r9)     // Catch:{ all -> 0x009b }
        L_0x0094:
            m0.i0.q(r0, r1)     // Catch:{ all -> 0x009b }
        L_0x0097:
            r7.n()
            return
        L_0x009b:
            r9 = move-exception
            r7.n()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b0.e(android.util.AttributeSet, int):void");
    }

    public final void f() {
        this.f730b = -1;
        h((ColorStateList) null);
        a();
    }

    public final void g(int i10) {
        ColorStateList colorStateList;
        this.f730b = i10;
        h0 h0Var = (h0) this.f732d;
        if (h0Var != null) {
            Context context = ((View) this.f731c).getContext();
            synchronized (h0Var) {
                colorStateList = h0Var.f845a.i(context, i10);
            }
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((s4) this.f733e) == null) {
                this.f733e = new s4();
            }
            Object obj = this.f733e;
            ((s4) obj).f1055a = colorStateList;
            ((s4) obj).f1058d = true;
        } else {
            this.f733e = null;
        }
        a();
    }

    public final void i(ColorStateList colorStateList) {
        if (((s4) this.f734f) == null) {
            this.f734f = new s4();
        }
        s4 s4Var = (s4) this.f734f;
        s4Var.f1055a = colorStateList;
        s4Var.f1058d = true;
        a();
    }

    public final void j(PorterDuff.Mode mode) {
        if (((s4) this.f734f) == null) {
            this.f734f = new s4();
        }
        s4 s4Var = (s4) this.f734f;
        s4Var.f1056b = mode;
        s4Var.f1057c = true;
        a();
    }

    public final String toString() {
        switch (this.f729a) {
            case 1:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("FontRequest {mProviderAuthority: " + ((String) this.f731c) + ", mProviderPackage: " + ((String) this.f732d) + ", mQuery: " + ((String) this.f733e) + ", mCertificates:");
                for (int i10 = 0; i10 < ((List) this.f734f).size(); i10++) {
                    sb2.append(" [");
                    List list = (List) ((List) this.f734f).get(i10);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        sb2.append(" \"");
                        sb2.append(Base64.encodeToString((byte[]) list.get(i11), 0));
                        sb2.append("\"");
                    }
                    sb2.append(" ]");
                }
                sb2.append("}");
                sb2.append("mCertificatesArray: " + this.f730b);
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public b0(View view) {
        this.f729a = 0;
        this.f730b = -1;
        this.f731c = view;
        this.f732d = h0.a();
    }

    public b0(String str, String str2, String str3, List list) {
        this.f729a = 1;
        str.getClass();
        this.f731c = str;
        str2.getClass();
        this.f732d = str2;
        this.f733e = str3;
        list.getClass();
        this.f734f = list;
        this.f730b = 0;
        this.f735g = str + "-" + str2 + "-" + str3;
    }
}
