package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import com.woxthebox.draglistview.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import m0.c1;
import m0.e1;
import m0.f1;
import m0.i0;
import m0.l0;

public final class h5 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: r  reason: collision with root package name */
    public static h5 f855r;

    /* renamed from: s  reason: collision with root package name */
    public static h5 f856s;

    /* renamed from: h  reason: collision with root package name */
    public final View f857h;

    /* renamed from: i  reason: collision with root package name */
    public final CharSequence f858i;

    /* renamed from: j  reason: collision with root package name */
    public final int f859j;

    /* renamed from: k  reason: collision with root package name */
    public final g5 f860k = new g5(this, 0);

    /* renamed from: l  reason: collision with root package name */
    public final g5 f861l = new g5(this, 1);

    /* renamed from: m  reason: collision with root package name */
    public int f862m;

    /* renamed from: n  reason: collision with root package name */
    public int f863n;

    /* renamed from: o  reason: collision with root package name */
    public i5 f864o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f865p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f866q;

    public h5(View view, CharSequence charSequence) {
        int i10;
        this.f857h = view;
        this.f858i = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = f1.f10074a;
        if (Build.VERSION.SDK_INT >= 28) {
            i10 = e1.a(viewConfiguration);
        } else {
            i10 = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.f859j = i10;
        this.f866q = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(h5 h5Var) {
        h5 h5Var2 = f855r;
        if (h5Var2 != null) {
            h5Var2.f857h.removeCallbacks(h5Var2.f860k);
        }
        f855r = h5Var;
        if (h5Var != null) {
            h5Var.f857h.postDelayed(h5Var.f860k, (long) ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        boolean z10;
        h5 h5Var = f856s;
        View view = this.f857h;
        if (h5Var == this) {
            f856s = null;
            i5 i5Var = this.f864o;
            if (i5Var != null) {
                View view2 = (View) i5Var.f875c;
                if (view2.getParent() != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    ((WindowManager) ((Context) i5Var.f874b).getSystemService("window")).removeView(view2);
                }
                this.f864o = null;
                this.f866q = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f855r == this) {
            b((h5) null);
        }
        view.removeCallbacks(this.f861l);
    }

    public final void c(boolean z10) {
        boolean z11;
        int i10;
        int i11;
        int i12;
        String str;
        long j10;
        long j11;
        long j12;
        String str2;
        int i13;
        boolean z12;
        WeakHashMap weakHashMap = c1.f10054a;
        View view = this.f857h;
        if (l0.b(view)) {
            b((h5) null);
            h5 h5Var = f856s;
            if (h5Var != null) {
                h5Var.a();
            }
            f856s = this;
            this.f865p = z10;
            i5 i5Var = new i5(view.getContext());
            this.f864o = i5Var;
            int i14 = this.f862m;
            int i15 = this.f863n;
            boolean z13 = this.f865p;
            Object obj = i5Var.f875c;
            if (((View) obj).getParent() != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Object obj2 = i5Var.f874b;
            if (z11) {
                View view2 = (View) obj;
                if (view2.getParent() != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    ((WindowManager) ((Context) obj2).getSystemService("window")).removeView(view2);
                }
            }
            ((TextView) i5Var.f876d).setText(this.f858i);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) i5Var.f877e;
            layoutParams.token = view.getApplicationWindowToken();
            Context context = (Context) obj2;
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                i14 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                i10 = i15 + dimensionPixelOffset2;
                i11 = i15 - dimensionPixelOffset2;
            } else {
                i10 = view.getHeight();
                i11 = 0;
            }
            layoutParams.gravity = 49;
            Resources resources = context.getResources();
            if (z13) {
                i12 = R.dimen.tooltip_y_offset_touch;
            } else {
                i12 = R.dimen.tooltip_y_offset_non_touch;
            }
            int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i12);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    } else if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    } else {
                        context2 = ((ContextWrapper) context2).getBaseContext();
                    }
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                str = "window";
            } else {
                rootView.getWindowVisibleDisplayFrame((Rect) i5Var.f878f);
                Rect rect = (Rect) i5Var.f878f;
                if (rect.left >= 0 || rect.top >= 0) {
                    str2 = "window";
                } else {
                    Resources resources2 = context.getResources();
                    int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                    if (identifier != 0) {
                        i13 = resources2.getDimensionPixelSize(identifier);
                    } else {
                        i13 = 0;
                    }
                    DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                    str2 = "window";
                    ((Rect) i5Var.f878f).set(0, i13, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen((int[]) i5Var.f880h);
                view.getLocationOnScreen((int[]) i5Var.f879g);
                int[] iArr = (int[]) i5Var.f879g;
                int i16 = iArr[0];
                int[] iArr2 = (int[]) i5Var.f880h;
                int i17 = i16 - iArr2[0];
                iArr[0] = i17;
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (i17 + i14) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                View view3 = (View) obj;
                view3.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = view3.getMeasuredHeight();
                int i18 = ((int[]) i5Var.f879g)[1];
                int i19 = ((i11 + i18) - dimensionPixelOffset3) - measuredHeight;
                int i20 = i18 + i10 + dimensionPixelOffset3;
                if (!z13 ? measuredHeight + i20 > ((Rect) i5Var.f878f).height() : i19 >= 0) {
                    layoutParams.y = i19;
                } else {
                    layoutParams.y = i20;
                }
                str = str2;
            }
            ((WindowManager) context.getSystemService(str)).addView((View) obj, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.f865p) {
                j10 = 2500;
            } else {
                if ((i0.g(view) & 1) == 1) {
                    j12 = (long) ViewConfiguration.getLongPressTimeout();
                    j11 = 3000;
                } else {
                    j12 = (long) ViewConfiguration.getLongPressTimeout();
                    j11 = 15000;
                }
                j10 = j11 - j12;
            }
            g5 g5Var = this.f861l;
            view.removeCallbacks(g5Var);
            view.postDelayed(g5Var, j10);
        }
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        int i10;
        if (this.f864o != null && this.f865p) {
            return false;
        }
        View view2 = this.f857h;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action != 7) {
            if (action == 10) {
                this.f866q = true;
                a();
            }
        } else if (view2.isEnabled() && this.f864o == null) {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (this.f866q || Math.abs(x10 - this.f862m) > (i10 = this.f859j) || Math.abs(y10 - this.f863n) > i10) {
                this.f862m = x10;
                this.f863n = y10;
                this.f866q = false;
            } else {
                z10 = false;
            }
            if (z10) {
                b(this);
            }
        }
        return false;
    }

    public final boolean onLongClick(View view) {
        this.f862m = view.getWidth() / 2;
        this.f863n = view.getHeight() / 2;
        c(true);
        return true;
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        a();
    }
}
