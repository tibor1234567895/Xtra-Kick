package y8;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.activity.e;
import com.google.android.material.textfield.TextInputLayout;
import com.woxthebox.draglistview.R;
import e7.b;
import i3.i;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import n0.d;
import n0.h;
import n8.a;

public final class k extends o {

    /* renamed from: e  reason: collision with root package name */
    public final int f17139e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17140f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeInterpolator f17141g;

    /* renamed from: h  reason: collision with root package name */
    public AutoCompleteTextView f17142h;

    /* renamed from: i  reason: collision with root package name */
    public final i f17143i = new i(24, this);

    /* renamed from: j  reason: collision with root package name */
    public final b f17144j = new b(this, 1);

    /* renamed from: k  reason: collision with root package name */
    public final b f17145k = new b(4, (Object) this);

    /* renamed from: l  reason: collision with root package name */
    public boolean f17146l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f17147m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f17148n;

    /* renamed from: o  reason: collision with root package name */
    public long f17149o = Long.MAX_VALUE;

    /* renamed from: p  reason: collision with root package name */
    public AccessibilityManager f17150p;

    /* renamed from: q  reason: collision with root package name */
    public ValueAnimator f17151q;

    /* renamed from: r  reason: collision with root package name */
    public ValueAnimator f17152r;

    public k(n nVar) {
        super(nVar);
        this.f17140f = a.c(nVar.getContext(), R.attr.motionDurationShort3, 67);
        this.f17139e = a.c(nVar.getContext(), R.attr.motionDurationShort3, 50);
        this.f17141g = a.d(nVar.getContext(), R.attr.motionEasingLinearInterpolator, w7.a.f16153a);
    }

    public final void a() {
        boolean z10;
        if (this.f17150p.isTouchExplorationEnabled()) {
            if (this.f17142h.getInputType() != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && !this.f17177d.hasFocus()) {
                this.f17142h.dismissDropDown();
            }
        }
        this.f17142h.post(new e(24, this));
    }

    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    public final View.OnFocusChangeListener e() {
        return this.f17144j;
    }

    public final View.OnClickListener f() {
        return this.f17143i;
    }

    public final d h() {
        return this.f17145k;
    }

    public final boolean i(int i10) {
        return i10 != 0;
    }

    public final boolean j() {
        return this.f17146l;
    }

    public final boolean l() {
        return this.f17148n;
    }

    public final void m(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            this.f17142h = autoCompleteTextView;
            autoCompleteTextView.setOnTouchListener(new i(this));
            this.f17142h.setOnDismissListener(new j(this));
            boolean z10 = false;
            this.f17142h.setThreshold(0);
            TextInputLayout textInputLayout = this.f17174a;
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (editText.getInputType() != 0) {
                z10 = true;
            }
            if (!z10 && this.f17150p.isTouchExplorationEnabled()) {
                WeakHashMap weakHashMap = c1.f10054a;
                i0.s(this.f17177d, 2);
            }
            textInputLayout.setEndIconVisible(true);
            return;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public final void n(n0.i iVar) {
        boolean z10;
        boolean z11 = true;
        if (this.f17142h.getInputType() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            iVar.h(Spinner.class.getName());
        }
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = iVar.f10916a;
        if (i10 >= 26) {
            z11 = accessibilityNodeInfo.isShowingHintText();
        } else {
            Bundle a10 = h.a(accessibilityNodeInfo);
            if (a10 == null || (a10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) != 4) {
                z11 = false;
            }
        }
        if (z11) {
            iVar.j((String) null);
        }
    }

    public final void o(AccessibilityEvent accessibilityEvent) {
        boolean z10;
        if (this.f17150p.isEnabled()) {
            boolean z11 = false;
            if (this.f17142h.getInputType() != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (accessibilityEvent.getEventType() == 32768 && this.f17148n && !this.f17142h.isPopupShowing()) {
                    z11 = true;
                }
                if (accessibilityEvent.getEventType() == 1 || z11) {
                    u();
                    this.f17147m = true;
                    this.f17149o = System.currentTimeMillis();
                }
            }
        }
    }

    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        TimeInterpolator timeInterpolator = this.f17141g;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration((long) this.f17140f);
        ofFloat.addUpdateListener(new i3.e(1, this));
        this.f17152r = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration((long) this.f17139e);
        ofFloat2.addUpdateListener(new i3.e(1, this));
        this.f17151q = ofFloat2;
        ofFloat2.addListener(new androidx.appcompat.widget.d(7, this));
        this.f17150p = (AccessibilityManager) this.f17176c.getSystemService("accessibility");
    }

    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.f17142h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener((View.OnTouchListener) null);
            this.f17142h.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
        }
    }

    public final void t(boolean z10) {
        if (this.f17148n != z10) {
            this.f17148n = z10;
            this.f17152r.cancel();
            this.f17151q.start();
        }
    }

    public final void u() {
        boolean z10;
        if (this.f17142h != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f17149o;
            if (currentTimeMillis < 0 || currentTimeMillis > 300) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f17147m = false;
            }
            if (!this.f17147m) {
                t(!this.f17148n);
                if (this.f17148n) {
                    this.f17142h.requestFocus();
                    this.f17142h.showDropDown();
                    return;
                }
                this.f17142h.dismissDropDown();
                return;
            }
            this.f17147m = false;
        }
    }
}
