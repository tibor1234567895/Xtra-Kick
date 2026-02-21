package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.f5;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.t1;
import f.a;
import m.b;
import m.c;
import m.d0;
import m.n;
import m.q;

public class ActionMenuItemView extends t1 implements d0, View.OnClickListener, o {

    /* renamed from: o  reason: collision with root package name */
    public q f546o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f547p;

    /* renamed from: q  reason: collision with root package name */
    public Drawable f548q;

    /* renamed from: r  reason: collision with root package name */
    public n f549r;

    /* renamed from: s  reason: collision with root package name */
    public b f550s;

    /* renamed from: t  reason: collision with root package name */
    public c f551t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f552u = m();

    /* renamed from: v  reason: collision with root package name */
    public boolean f553v;

    /* renamed from: w  reason: collision with root package name */
    public final int f554w;

    /* renamed from: x  reason: collision with root package name */
    public int f555x;

    /* renamed from: y  reason: collision with root package name */
    public final int f556y;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f5393c, 0, 0);
        this.f554w = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f556y = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f555x = -1;
        setSaveEnabled(false);
    }

    public final boolean a() {
        return l();
    }

    public final void b(q qVar) {
        int i10;
        this.f546o = qVar;
        setIcon(qVar.getIcon());
        setTitle(qVar.getTitleCondensed());
        setId(qVar.f9999a);
        if (qVar.isVisible()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        setVisibility(i10);
        setEnabled(qVar.isEnabled());
        if (qVar.hasSubMenu() && this.f550s == null) {
            this.f550s = new b(this);
        }
    }

    public final boolean c() {
        return l() && this.f546o.getIcon() == null;
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public q getItemData() {
        return this.f546o;
    }

    public final boolean l() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean m() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        return i10 >= 480 || (i10 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void n() {
        CharSequence charSequence;
        boolean z10;
        boolean z11 = true;
        boolean z12 = !TextUtils.isEmpty(this.f547p);
        if (this.f548q != null) {
            if ((this.f546o.f10023y & 4) == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 || (!this.f552u && !this.f553v)) {
                z11 = false;
            }
        }
        boolean z13 = z12 & z11;
        CharSequence charSequence2 = null;
        if (z13) {
            charSequence = this.f547p;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence charSequence3 = this.f546o.f10015q;
        if (TextUtils.isEmpty(charSequence3)) {
            if (z13) {
                charSequence3 = null;
            } else {
                charSequence3 = this.f546o.f10003e;
            }
        }
        setContentDescription(charSequence3);
        CharSequence charSequence4 = this.f546o.f10016r;
        if (TextUtils.isEmpty(charSequence4)) {
            if (!z13) {
                charSequence2 = this.f546o.f10003e;
            }
            f5.a(this, charSequence2);
            return;
        }
        f5.a(this, charSequence4);
    }

    public final void onClick(View view) {
        n nVar = this.f549r;
        if (nVar != null) {
            nVar.d(this.f546o);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f552u = m();
        n();
    }

    public final void onMeasure(int i10, int i11) {
        int i12;
        boolean l10 = l();
        if (l10 && (i12 = this.f555x) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int i13 = this.f554w;
        int min = mode == Integer.MIN_VALUE ? Math.min(size, i13) : i13;
        if (mode != 1073741824 && i13 > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i11);
        }
        if (!l10 && this.f548q != null) {
            super.setPadding((getMeasuredWidth() - this.f548q.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (!this.f546o.hasSubMenu() || (bVar = this.f550s) == null || !bVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f553v != z10) {
            this.f553v = z10;
            q qVar = this.f546o;
            if (qVar != null) {
                m.o oVar = qVar.f10012n;
                oVar.f9982k = true;
                oVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f548q = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f556y;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i10) / ((float) intrinsicWidth)));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i10) / ((float) intrinsicHeight)));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        n();
    }

    public void setItemInvoker(n nVar) {
        this.f549r = nVar;
    }

    public final void setPadding(int i10, int i11, int i12, int i13) {
        this.f555x = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(c cVar) {
        this.f551t = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f547p = charSequence;
        n();
    }
}
