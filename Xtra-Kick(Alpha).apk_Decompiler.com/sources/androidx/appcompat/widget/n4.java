package androidx.appcompat.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import b4.e;
import b4.g0;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;
import m0.k0;

public final class n4 extends Property {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f969a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n4(Class cls, String str, int i10) {
        super(cls, str);
        this.f969a = i10;
    }

    public final Float a(View view) {
        switch (this.f969a) {
            case 6:
                return Float.valueOf(g0.f2543a.c(view));
            case 8:
                return Float.valueOf((float) view.getLayoutParams().width);
            case 9:
                return Float.valueOf((float) view.getLayoutParams().height);
            case 10:
                WeakHashMap weakHashMap = c1.f10054a;
                return Float.valueOf((float) j0.f(view));
            default:
                WeakHashMap weakHashMap2 = c1.f10054a;
                return Float.valueOf((float) j0.e(view));
        }
    }

    public final void b(View view, PointF pointF) {
        switch (this.f969a) {
            case 3:
                g0.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
                return;
            case 4:
                g0.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
                return;
            default:
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                g0.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
                return;
        }
    }

    public final void c(View view, Float f10) {
        switch (this.f969a) {
            case 6:
                g0.f2543a.d(view, f10.floatValue());
                return;
            case 8:
                view.getLayoutParams().width = f10.intValue();
                view.requestLayout();
                return;
            case 9:
                view.getLayoutParams().height = f10.intValue();
                view.requestLayout();
                return;
            case 10:
                int intValue = f10.intValue();
                int paddingTop = view.getPaddingTop();
                WeakHashMap weakHashMap = c1.f10054a;
                j0.k(view, intValue, paddingTop, j0.e(view), view.getPaddingBottom());
                return;
            default:
                WeakHashMap weakHashMap2 = c1.f10054a;
                j0.k(view, j0.f(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
                return;
        }
    }

    public final void d(e eVar, PointF pointF) {
        switch (this.f969a) {
            case 1:
                eVar.getClass();
                eVar.f2530a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                eVar.f2531b = round;
                int i10 = eVar.f2535f + 1;
                eVar.f2535f = i10;
                if (i10 == eVar.f2536g) {
                    g0.a(eVar.f2534e, eVar.f2530a, round, eVar.f2532c, eVar.f2533d);
                    eVar.f2535f = 0;
                    eVar.f2536g = 0;
                    return;
                }
                return;
            default:
                eVar.getClass();
                eVar.f2532c = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                eVar.f2533d = round2;
                int i11 = eVar.f2536g + 1;
                eVar.f2536g = i11;
                if (eVar.f2535f == i11) {
                    g0.a(eVar.f2534e, eVar.f2530a, eVar.f2531b, eVar.f2532c, round2);
                    eVar.f2535f = 0;
                    eVar.f2536g = 0;
                    return;
                }
                return;
        }
    }

    public final Object get(Object obj) {
        switch (this.f969a) {
            case 0:
                return Float.valueOf(((SwitchCompat) obj).G);
            case 1:
                e eVar = (e) obj;
                return null;
            case 2:
                e eVar2 = (e) obj;
                return null;
            case 3:
                View view = (View) obj;
                return null;
            case 4:
                View view2 = (View) obj;
                return null;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                View view3 = (View) obj;
                return null;
            case 6:
                return a((View) obj);
            case 7:
                WeakHashMap weakHashMap = c1.f10054a;
                return k0.a((View) obj);
            case 8:
                return a((View) obj);
            case 9:
                return a((View) obj);
            case 10:
                return a((View) obj);
            default:
                return a((View) obj);
        }
    }

    public final void set(Object obj, Object obj2) {
        switch (this.f969a) {
            case 0:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                return;
            case 1:
                d((e) obj, (PointF) obj2);
                return;
            case 2:
                d((e) obj, (PointF) obj2);
                return;
            case 3:
                b((View) obj, (PointF) obj2);
                return;
            case 4:
                b((View) obj, (PointF) obj2);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                b((View) obj, (PointF) obj2);
                return;
            case 6:
                c((View) obj, (Float) obj2);
                return;
            case 7:
                WeakHashMap weakHashMap = c1.f10054a;
                k0.c((View) obj, (Rect) obj2);
                return;
            case 8:
                c((View) obj, (Float) obj2);
                return;
            case 9:
                c((View) obj, (Float) obj2);
                return;
            case 10:
                c((View) obj, (Float) obj2);
                return;
            default:
                c((View) obj, (Float) obj2);
                return;
        }
    }
}
