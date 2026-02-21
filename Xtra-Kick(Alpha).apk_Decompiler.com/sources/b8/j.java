package b8;

import android.view.View;
import android.view.WindowInsets;
import java.util.Iterator;
import java.util.List;
import m0.a2;
import m0.q2;
import w7.a;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public WindowInsets f2690a;

    /* renamed from: b  reason: collision with root package name */
    public final View f2691b;

    /* renamed from: c  reason: collision with root package name */
    public int f2692c;

    /* renamed from: d  reason: collision with root package name */
    public int f2693d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f2694e = new int[2];

    public j(View view) {
        this.f2691b = view;
    }

    public final void a(q2 q2Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a2 a2Var = (a2) it.next();
            if ((a2Var.f10039a.c() & 8) != 0) {
                this.f2691b.setTranslationY((float) a.b(this.f2693d, a2Var.f10039a.b(), 0));
                return;
            }
        }
    }
}
