package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.media.h;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import m0.c1;
import m0.m0;
import m0.q2;
import xa.j;
import y0.a;

public final class FragmentContainerView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f1311h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f1312i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1313j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1314k = true;

    public FragmentContainerView(Context context) {
        super(context);
    }

    public final void a(View view) {
        if (this.f1312i.contains(view)) {
            this.f1311h.add(view);
        }
    }

    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        c0 c0Var;
        j.f("child", view);
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof c0) {
            c0Var = (c0) tag;
        } else {
            c0Var = null;
        }
        if (c0Var != null) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        q2 q2Var;
        j.f("insets", windowInsets);
        q2 h10 = q2.h((View) null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1313j;
        if (onApplyWindowInsetsListener != null) {
            i0.f1463a.getClass();
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            j.e("onApplyWindowInsetsListe…lyWindowInsets(v, insets)", onApplyWindowInsets);
            q2Var = q2.h((View) null, onApplyWindowInsets);
        } else {
            WeakHashMap weakHashMap = c1.f10054a;
            WindowInsets g10 = h10.g();
            if (g10 != null) {
                WindowInsets b10 = m0.b(this, g10);
                if (!b10.equals(g10)) {
                    h10 = q2.h(this, b10);
                }
            }
            q2Var = h10;
        }
        if (!q2Var.f10131a.m()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                WeakHashMap weakHashMap2 = c1.f10054a;
                WindowInsets g11 = q2Var.g();
                if (g11 != null) {
                    WindowInsets a10 = m0.a(childAt, g11);
                    if (!a10.equals(g11)) {
                        q2.h(childAt, a10);
                    }
                }
            }
        }
        return windowInsets;
    }

    public final void dispatchDraw(Canvas canvas) {
        j.f("canvas", canvas);
        if (this.f1314k) {
            Iterator it = this.f1311h.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public final boolean drawChild(Canvas canvas, View view, long j10) {
        j.f("canvas", canvas);
        j.f("child", view);
        if (this.f1314k) {
            ArrayList arrayList = this.f1311h;
            if ((!arrayList.isEmpty()) && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    public final void endViewTransition(View view) {
        j.f("view", view);
        this.f1312i.remove(view);
        if (this.f1311h.remove(view)) {
            this.f1314k = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends c0> F getFragment() {
        f0 f0Var;
        c0 c0Var;
        c1 c1Var;
        View view = this;
        while (true) {
            f0Var = null;
            if (view == null) {
                c0Var = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            if (tag instanceof c0) {
                c0Var = (c0) tag;
            } else {
                c0Var = null;
            }
            if (c0Var != null) {
                break;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        if (c0Var == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof f0) {
                    f0Var = (f0) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (f0Var != null) {
                c1Var = f0Var.A();
            } else {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
        } else if (c0Var.F()) {
            c1Var = c0Var.u();
        } else {
            throw new IllegalStateException("The Fragment " + c0Var + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        return c1Var.D(getId());
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        j.f("insets", windowInsets);
        return windowInsets;
    }

    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View childAt = getChildAt(childCount);
                j.e("view", childAt);
                a(childAt);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    public final void removeView(View view) {
        j.f("view", view);
        a(view);
        super.removeView(view);
    }

    public final void removeViewAt(int i10) {
        View childAt = getChildAt(i10);
        j.e("view", childAt);
        a(childAt);
        super.removeViewAt(i10);
    }

    public final void removeViewInLayout(View view) {
        j.f("view", view);
        a(view);
        super.removeViewInLayout(view);
    }

    public final void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            j.e("view", childAt);
            a(childAt);
        }
        super.removeViews(i10, i11);
    }

    public final void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            j.e("view", childAt);
            a(childAt);
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f1314k = z10;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        j.f("listener", onApplyWindowInsetsListener);
        this.f1313j = onApplyWindowInsetsListener;
    }

    public final void startViewTransition(View view) {
        j.f("view", view);
        if (view.getParent() == this) {
            this.f1312i.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        j.f("context", context);
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f16857b, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, c1 c1Var) {
        super(context, attributeSet);
        View view;
        j.f("context", context);
        j.f("attrs", attributeSet);
        j.f("fm", c1Var);
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f16857b, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        c0 D = c1Var.D(id);
        if (classAttribute != null && D == null) {
            if (id == -1) {
                throw new IllegalStateException(h.n("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            c0 a10 = c1Var.G().a(context.getClassLoader(), classAttribute);
            j.e("fm.fragmentFactory.insta…ontext.classLoader, name)", a10);
            a10.T(context, attributeSet, (Bundle) null);
            a aVar = new a(c1Var);
            aVar.f1548p = true;
            a10.L = this;
            aVar.d(getId(), a10, string, 1);
            if (!aVar.f1539g) {
                aVar.f1540h = false;
                aVar.f1319q.z(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        Iterator it = c1Var.f1373c.d().iterator();
        while (it.hasNext()) {
            m1 m1Var = (m1) it.next();
            c0 c0Var = m1Var.f1502c;
            if (c0Var.E == getId() && (view = c0Var.M) != null && view.getParent() == null) {
                c0Var.L = this;
                m1Var.b();
            }
        }
    }
}
