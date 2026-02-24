package q0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import m0.c;
import n0.g;
import n0.i;
import n0.n;

public final class k extends c {
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        boolean z10;
        super.c(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        if (nestedScrollView.getScrollRange() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        accessibilityEvent.setScrollable(z10);
        accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
        accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
        n.c(accessibilityEvent, nestedScrollView.getScrollX());
        n.d(accessibilityEvent, nestedScrollView.getScrollRange());
    }

    public final void d(View view, i iVar) {
        int scrollRange;
        this.f10052a.onInitializeAccessibilityNodeInfo(view, iVar.f10916a);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        iVar.h(ScrollView.class.getName());
        if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
            iVar.k(true);
            if (nestedScrollView.getScrollY() > 0) {
                iVar.b(g.f10905g);
                iVar.b(g.f10909k);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                iVar.b(g.f10904f);
                iVar.b(g.f10910l);
            }
        }
    }

    public final boolean g(View view, int i10, Bundle bundle) {
        if (super.g(view, i10, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int height = nestedScrollView.getHeight();
        Rect rect = new Rect();
        if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
            height = rect.height();
        }
        if (i10 != 4096) {
            if (i10 == 8192 || i10 == 16908344) {
                int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (max == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.v(0 - nestedScrollView.getScrollX(), max - nestedScrollView.getScrollY(), true);
                return true;
            } else if (i10 != 16908346) {
                return false;
            }
        }
        int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
        if (min == nestedScrollView.getScrollY()) {
            return false;
        }
        nestedScrollView.v(0 - nestedScrollView.getScrollX(), min - nestedScrollView.getScrollY(), true);
        return true;
    }
}
