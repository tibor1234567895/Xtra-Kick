package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import h.a;
import m.e;

public final class h1 extends Spinner {

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f846p = {16843505};

    /* renamed from: h  reason: collision with root package name */
    public final b0 f847h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f848i;

    /* renamed from: j  reason: collision with root package name */
    public final j f849j;

    /* renamed from: k  reason: collision with root package name */
    public SpinnerAdapter f850k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f851l;

    /* renamed from: m  reason: collision with root package name */
    public final g1 f852m;

    /* renamed from: n  reason: collision with root package name */
    public int f853n;

    /* renamed from: o  reason: collision with root package name */
    public final Rect f854o = new Rect();

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r6 != null) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h1(android.content.Context r12, android.util.AttributeSet r13) {
        /*
            r11 = this;
            r0 = 2130969682(0x7f040452, float:1.7548053E38)
            r11.<init>(r12, r13, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r11.f854o = r1
            android.content.Context r1 = r11.getContext()
            androidx.appcompat.widget.q4.a(r1, r11)
            int[] r1 = f.a.f5413w
            r2 = 0
            android.content.res.TypedArray r3 = r12.obtainStyledAttributes(r13, r1, r0, r2)
            androidx.appcompat.widget.b0 r4 = new androidx.appcompat.widget.b0
            r4.<init>(r11)
            r11.f847h = r4
            r4 = 4
            int r4 = r3.getResourceId(r4, r2)
            if (r4 == 0) goto L_0x0031
            l.f r5 = new l.f
            r5.<init>((android.content.Context) r12, (int) r4)
            r11.f848i = r5
            goto L_0x0033
        L_0x0031:
            r11.f848i = r12
        L_0x0033:
            r4 = -1
            r5 = 0
            int[] r6 = f846p     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            android.content.res.TypedArray r6 = r12.obtainStyledAttributes(r13, r6, r0, r2)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            boolean r7 = r6.hasValue(r2)     // Catch:{ Exception -> 0x004a }
            if (r7 == 0) goto L_0x005b
            int r4 = r6.getInt(r2, r2)     // Catch:{ Exception -> 0x004a }
            goto L_0x005b
        L_0x0046:
            r12 = move-exception
            r5 = r6
            goto L_0x00ce
        L_0x004a:
            r7 = move-exception
            goto L_0x0052
        L_0x004c:
            r12 = move-exception
            goto L_0x00ce
        L_0x004f:
            r6 = move-exception
            r7 = r6
            r6 = r5
        L_0x0052:
            java.lang.String r8 = "AppCompatSpinner"
            java.lang.String r9 = "Could not read android:spinnerMode"
            android.util.Log.i(r8, r9, r7)     // Catch:{ all -> 0x0046 }
            if (r6 == 0) goto L_0x005e
        L_0x005b:
            r6.recycle()
        L_0x005e:
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x0096
            if (r4 == r7) goto L_0x0065
            goto L_0x00a3
        L_0x0065:
            androidx.appcompat.widget.d1 r4 = new androidx.appcompat.widget.d1
            android.content.Context r8 = r11.f848i
            r4.<init>(r11, r8, r13)
            android.content.Context r8 = r11.f848i
            androidx.appcompat.widget.u4 r1 = androidx.appcompat.widget.u4.m(r8, r13, r1, r0)
            android.content.res.TypedArray r8 = r1.f1100b
            r9 = 3
            r10 = -2
            int r8 = r8.getLayoutDimension(r9, r10)
            r11.f853n = r8
            android.graphics.drawable.Drawable r8 = r1.e(r7)
            r4.i(r8)
            java.lang.String r6 = r3.getString(r6)
            r4.K = r6
            r1.n()
            r11.f852m = r4
            androidx.appcompat.widget.j r1 = new androidx.appcompat.widget.j
            r1.<init>(r11, r11, r4, r7)
            r11.f849j = r1
            goto L_0x00a3
        L_0x0096:
            androidx.appcompat.widget.a1 r1 = new androidx.appcompat.widget.a1
            r1.<init>(r11)
            r11.f852m = r1
            java.lang.String r4 = r3.getString(r6)
            r1.f723j = r4
        L_0x00a3:
            java.lang.CharSequence[] r1 = r3.getTextArray(r2)
            if (r1 == 0) goto L_0x00ba
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r2.<init>(r12, r4, r1)
            r12 = 2131558596(0x7f0d00c4, float:1.8742512E38)
            r2.setDropDownViewResource(r12)
            r11.setAdapter((android.widget.SpinnerAdapter) r2)
        L_0x00ba:
            r3.recycle()
            r11.f851l = r7
            android.widget.SpinnerAdapter r12 = r11.f850k
            if (r12 == 0) goto L_0x00c8
            r11.setAdapter((android.widget.SpinnerAdapter) r12)
            r11.f850k = r5
        L_0x00c8:
            androidx.appcompat.widget.b0 r12 = r11.f847h
            r12.e(r13, r0)
            return
        L_0x00ce:
            if (r5 == 0) goto L_0x00d3
            r5.recycle()
        L_0x00d3:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.h1.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        Rect rect = this.f854o;
        drawable.getPadding(rect);
        return i11 + rect.left + rect.right;
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f847h;
        if (b0Var != null) {
            b0Var.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        g1 g1Var = this.f852m;
        return g1Var != null ? g1Var.c() : super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        g1 g1Var = this.f852m;
        return g1Var != null ? g1Var.n() : super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        return this.f852m != null ? this.f853n : super.getDropDownWidth();
    }

    public final g1 getInternalPopup() {
        return this.f852m;
    }

    public Drawable getPopupBackground() {
        g1 g1Var = this.f852m;
        return g1Var != null ? g1Var.e() : super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f848i;
    }

    public CharSequence getPrompt() {
        g1 g1Var = this.f852m;
        return g1Var != null ? g1Var.o() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        b0 b0Var = this.f847h;
        if (b0Var != null) {
            return b0Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b0 b0Var = this.f847h;
        if (b0Var != null) {
            return b0Var.d();
        }
        return null;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g1 g1Var = this.f852m;
        if (g1Var != null && g1Var.b()) {
            g1Var.dismiss();
        }
    }

    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f852m != null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f1 f1Var = (f1) parcelable;
        super.onRestoreInstanceState(f1Var.getSuperState());
        if (f1Var.f819h && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new e(3, this));
        }
    }

    public final Parcelable onSaveInstanceState() {
        f1 f1Var = new f1(super.onSaveInstanceState());
        g1 g1Var = this.f852m;
        f1Var.f819h = g1Var != null && g1Var.b();
        return f1Var;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        j jVar = this.f849j;
        if (jVar == null || !jVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public final boolean performClick() {
        g1 g1Var = this.f852m;
        if (g1Var == null) {
            return super.performClick();
        }
        if (g1Var.b()) {
            return true;
        }
        g1Var.m(y0.b(this), y0.a(this));
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b0 b0Var = this.f847h;
        if (b0Var != null) {
            b0Var.f();
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b0 b0Var = this.f847h;
        if (b0Var != null) {
            b0Var.g(i10);
        }
    }

    public void setDropDownHorizontalOffset(int i10) {
        g1 g1Var = this.f852m;
        if (g1Var != null) {
            g1Var.k(i10);
            g1Var.l(i10);
            return;
        }
        super.setDropDownHorizontalOffset(i10);
    }

    public void setDropDownVerticalOffset(int i10) {
        g1 g1Var = this.f852m;
        if (g1Var != null) {
            g1Var.j(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    public void setDropDownWidth(int i10) {
        if (this.f852m != null) {
            this.f853n = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        g1 g1Var = this.f852m;
        if (g1Var != null) {
            g1Var.i(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(a.a(getPopupContext(), i10));
    }

    public void setPrompt(CharSequence charSequence) {
        g1 g1Var = this.f852m;
        if (g1Var != null) {
            g1Var.h(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f847h;
        if (b0Var != null) {
            b0Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f847h;
        if (b0Var != null) {
            b0Var.j(mode);
        }
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f851l) {
            this.f850k = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        g1 g1Var = this.f852m;
        if (g1Var != null) {
            Context context = this.f848i;
            if (context == null) {
                context = getContext();
            }
            g1Var.p(new b1(spinnerAdapter, context.getTheme()));
        }
    }
}
