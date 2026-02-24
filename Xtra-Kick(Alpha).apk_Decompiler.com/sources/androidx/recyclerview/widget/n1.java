package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public abstract class n1 {

    /* renamed from: a  reason: collision with root package name */
    public l1 f2096a = null;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f2097b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final long f2098c = 120;

    /* renamed from: d  reason: collision with root package name */
    public final long f2099d = 120;

    /* renamed from: e  reason: collision with root package name */
    public final long f2100e = 250;

    /* renamed from: f  reason: collision with root package name */
    public final long f2101f = 250;

    public static int e(k2 k2Var) {
        int i10 = k2Var.mFlags & 14;
        if (k2Var.isInvalid()) {
            return 4;
        }
        if ((i10 & 4) != 0) {
            return i10;
        }
        int oldPosition = k2Var.getOldPosition();
        int absoluteAdapterPosition = k2Var.getAbsoluteAdapterPosition();
        return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i10 : i10 | 2048;
    }

    public abstract boolean a(k2 k2Var, m1 m1Var, m1 m1Var2);

    public abstract boolean b(k2 k2Var, k2 k2Var2, m1 m1Var, m1 m1Var2);

    public abstract boolean c(k2 k2Var, m1 m1Var, m1 m1Var2);

    public abstract boolean d(k2 k2Var, m1 m1Var, m1 m1Var2);

    public boolean f(k2 k2Var) {
        return true;
    }

    public boolean g(k2 k2Var, List list) {
        return f(k2Var);
    }

    public final void h(k2 k2Var) {
        l1 l1Var = this.f2096a;
        if (l1Var != null) {
            e1 e1Var = (e1) l1Var;
            e1Var.getClass();
            k2Var.setIsRecyclable(true);
            if (k2Var.mShadowedHolder != null && k2Var.mShadowingHolder == null) {
                k2Var.mShadowedHolder = null;
            }
            k2Var.mShadowingHolder = null;
            if (!k2Var.shouldBeKeptAsChild()) {
                View view = k2Var.itemView;
                RecyclerView recyclerView = e1Var.f1972a;
                if (!recyclerView.removeAnimatingView(view) && k2Var.isTmpDetached()) {
                    recyclerView.removeDetachedView(k2Var.itemView, false);
                }
            }
        }
    }

    public abstract void i(k2 k2Var);

    public abstract void j();

    public abstract boolean k();

    public abstract void l();
}
