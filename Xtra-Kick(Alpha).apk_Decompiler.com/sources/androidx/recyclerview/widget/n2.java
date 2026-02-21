package androidx.recyclerview.widget;

import android.view.View;

public final class n2 {
    private n2() {
    }

    public static int a(g2 g2Var, z0 z0Var, View view, View view2, q1 q1Var, boolean z10) {
        if (q1Var.H() == 0 || g2Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(q1.O(view) - q1.O(view2)) + 1;
        }
        return Math.min(z0Var.k(), z0Var.d(view2) - z0Var.f(view));
    }

    public static int b(g2 g2Var, z0 z0Var, View view, View view2, q1 q1Var, boolean z10, boolean z11) {
        if (q1Var.H() == 0 || g2Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z11 ? Math.max(0, (g2Var.b() - Math.max(q1.O(view), q1.O(view2))) - 1) : Math.max(0, Math.min(q1.O(view), q1.O(view2)));
        if (!z10) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(z0Var.d(view2) - z0Var.f(view))) / ((float) (Math.abs(q1.O(view) - q1.O(view2)) + 1)))) + ((float) (z0Var.j() - z0Var.f(view))));
    }

    public static int c(g2 g2Var, z0 z0Var, View view, View view2, q1 q1Var, boolean z10) {
        if (q1Var.H() == 0 || g2Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return g2Var.b();
        }
        return (int) ((((float) (z0Var.d(view2) - z0Var.f(view))) / ((float) (Math.abs(q1.O(view) - q1.O(view2)) + 1))) * ((float) g2Var.b()));
    }
}
