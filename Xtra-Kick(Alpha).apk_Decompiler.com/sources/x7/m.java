package x7;

import android.graphics.Rect;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.search.SearchBar$ScrollingViewBehavior;
import h0.a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.q2;
import z.e;

public abstract class m extends n {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f16737c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f16738d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public int f16739e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f16740f;

    public m() {
    }

    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
        AppBarLayout v10;
        int i13;
        q2 lastWindowInsets;
        int i14 = view.getLayoutParams().height;
        if ((i14 != -1 && i14 != -2) || (v10 = v(coordinatorLayout.k(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size > 0) {
            WeakHashMap weakHashMap = c1.f10054a;
            if (i0.b(v10) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.b() + lastWindowInsets.e();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        int x10 = x(v10) + size;
        int measuredHeight = v10.getMeasuredHeight();
        if (this instanceof SearchBar$ScrollingViewBehavior) {
            view.setTranslationY((float) (-measuredHeight));
        } else {
            view.setTranslationY(0.0f);
            x10 -= measuredHeight;
        }
        if (i14 == -1) {
            i13 = 1073741824;
        } else {
            i13 = RecyclerView.UNDEFINED_DURATION;
        }
        coordinatorLayout.s(view, i10, i11, View.MeasureSpec.makeMeasureSpec(x10, i13));
        return true;
    }

    public final void u(CoordinatorLayout coordinatorLayout, View view, int i10) {
        int i11;
        AppBarLayout v10 = v(coordinatorLayout.k(view));
        int i12 = 0;
        if (v10 != null) {
            e eVar = (e) view.getLayoutParams();
            int paddingLeft = coordinatorLayout.getPaddingLeft() + eVar.leftMargin;
            int bottom = v10.getBottom() + eVar.topMargin;
            int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin;
            int height = coordinatorLayout.getHeight();
            Rect rect = this.f16737c;
            rect.set(paddingLeft, bottom, width, ((v10.getBottom() + height) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            q2 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null) {
                WeakHashMap weakHashMap = c1.f10054a;
                if (i0.b(coordinatorLayout) && !i0.b(view)) {
                    rect.left = lastWindowInsets.c() + rect.left;
                    rect.right -= lastWindowInsets.d();
                }
            }
            Rect rect2 = this.f16738d;
            int i13 = eVar.f17324c;
            if (i13 == 0) {
                i11 = 8388659;
            } else {
                i11 = i13;
            }
            m0.m.b(i11, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
            if (this.f16740f != 0) {
                float w10 = w(v10);
                int i14 = this.f16740f;
                i12 = a.a((int) (w10 * ((float) i14)), 0, i14);
            }
            view.layout(rect2.left, rect2.top - i12, rect2.right, rect2.bottom - i12);
            i12 = rect2.top - v10.getBottom();
        } else {
            View view2 = view;
            coordinatorLayout.r(view, i10);
        }
        this.f16739e = i12;
    }

    public abstract AppBarLayout v(ArrayList arrayList);

    public float w(View view) {
        return 1.0f;
    }

    public int x(View view) {
        return view.getMeasuredHeight();
    }

    public m(int i10) {
        super(0);
    }
}
