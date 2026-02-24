package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

public final class y0 extends z0 {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2249d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y0(q1 q1Var, int i10) {
        super(q1Var);
        this.f2249d = i10;
    }

    public final int d(View view) {
        int F;
        int i10;
        int i11 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i11) {
            case 0:
                q1Var.getClass();
                F = q1.Q(view) + view.getRight();
                i10 = ((r1) view.getLayoutParams()).rightMargin;
                break;
            default:
                q1Var.getClass();
                F = q1.F(view) + view.getBottom();
                i10 = ((r1) view.getLayoutParams()).bottomMargin;
                break;
        }
        return F + i10;
    }

    public final int e(View view) {
        int measuredHeight;
        int i10;
        int i11 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i11) {
            case 0:
                r1 r1Var = (r1) view.getLayoutParams();
                q1Var.getClass();
                Rect rect = ((r1) view.getLayoutParams()).f2185i;
                measuredHeight = view.getMeasuredWidth() + rect.left + rect.right + r1Var.leftMargin;
                i10 = r1Var.rightMargin;
                break;
            default:
                r1 r1Var2 = (r1) view.getLayoutParams();
                q1Var.getClass();
                Rect rect2 = ((r1) view.getLayoutParams()).f2185i;
                measuredHeight = view.getMeasuredHeight() + rect2.top + rect2.bottom + r1Var2.topMargin;
                i10 = r1Var2.bottomMargin;
                break;
        }
        return measuredHeight + i10;
    }

    public final int f(View view) {
        int top;
        int i10;
        int i11 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i11) {
            case 0:
                q1Var.getClass();
                top = view.getLeft() - q1.N(view);
                i10 = ((r1) view.getLayoutParams()).leftMargin;
                break;
            default:
                q1Var.getClass();
                top = view.getTop() - q1.S(view);
                i10 = ((r1) view.getLayoutParams()).topMargin;
                break;
        }
        return top - i10;
    }

    public final int g() {
        int i10 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i10) {
            case 0:
                return q1Var.f2156u;
            default:
                return q1Var.f2157v;
        }
    }

    public final int h() {
        int i10;
        int paddingBottom;
        int i11 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i11) {
            case 0:
                i10 = q1Var.f2156u;
                paddingBottom = q1Var.getPaddingRight();
                break;
            default:
                i10 = q1Var.f2157v;
                paddingBottom = q1Var.getPaddingBottom();
                break;
        }
        return i10 - paddingBottom;
    }

    public final int i() {
        int i10 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i10) {
            case 0:
                return q1Var.f2154s;
            default:
                return q1Var.f2155t;
        }
    }

    public final int j() {
        int i10 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i10) {
            case 0:
                return q1Var.getPaddingLeft();
            default:
                return q1Var.getPaddingTop();
        }
    }

    public final int k() {
        int paddingTop;
        int paddingBottom;
        int i10 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i10) {
            case 0:
                paddingTop = q1Var.f2156u - q1Var.getPaddingLeft();
                paddingBottom = q1Var.getPaddingRight();
                break;
            default:
                paddingTop = q1Var.f2157v - q1Var.getPaddingTop();
                paddingBottom = q1Var.getPaddingBottom();
                break;
        }
        return paddingTop - paddingBottom;
    }

    public final int m(View view) {
        int i10 = this.f2249d;
        Rect rect = this.f2272c;
        q1 q1Var = this.f2270a;
        switch (i10) {
            case 0:
                q1Var.T(view, rect);
                return rect.right;
            default:
                q1Var.T(view, rect);
                return rect.bottom;
        }
    }

    public final int n(View view) {
        int i10 = this.f2249d;
        Rect rect = this.f2272c;
        q1 q1Var = this.f2270a;
        switch (i10) {
            case 0:
                q1Var.T(view, rect);
                return rect.left;
            default:
                q1Var.T(view, rect);
                return rect.top;
        }
    }

    public final void o(int i10) {
        int i11 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i11) {
            case 0:
                q1Var.X(i10);
                return;
            default:
                q1Var.Y(i10);
                return;
        }
    }

    public final int p(View view) {
        int measuredWidth;
        int i10;
        int i11 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i11) {
            case 0:
                r1 r1Var = (r1) view.getLayoutParams();
                q1Var.getClass();
                Rect rect = ((r1) view.getLayoutParams()).f2185i;
                measuredWidth = view.getMeasuredHeight() + rect.top + rect.bottom + r1Var.topMargin;
                i10 = r1Var.bottomMargin;
                break;
            default:
                r1 r1Var2 = (r1) view.getLayoutParams();
                q1Var.getClass();
                Rect rect2 = ((r1) view.getLayoutParams()).f2185i;
                measuredWidth = view.getMeasuredWidth() + rect2.left + rect2.right + r1Var2.leftMargin;
                i10 = r1Var2.rightMargin;
                break;
        }
        return measuredWidth + i10;
    }

    public final int q() {
        int i10 = this.f2249d;
        q1 q1Var = this.f2270a;
        switch (i10) {
            case 0:
                return q1Var.getPaddingRight();
            default:
                return q1Var.getPaddingBottom();
        }
    }
}
