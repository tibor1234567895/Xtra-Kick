package l;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import m0.n1;
import m0.o1;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f9492a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f9493b = -1;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f9494c;

    /* renamed from: d  reason: collision with root package name */
    public o1 f9495d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9496e;

    /* renamed from: f  reason: collision with root package name */
    public final m f9497f = new m(this);

    public final void a() {
        if (this.f9496e) {
            Iterator it = this.f9492a.iterator();
            while (it.hasNext()) {
                ((n1) it.next()).b();
            }
            this.f9496e = false;
        }
    }

    public final void b() {
        View view;
        if (!this.f9496e) {
            Iterator it = this.f9492a.iterator();
            while (it.hasNext()) {
                n1 n1Var = (n1) it.next();
                long j10 = this.f9493b;
                if (j10 >= 0) {
                    n1Var.c(j10);
                }
                Interpolator interpolator = this.f9494c;
                if (!(interpolator == null || (view = (View) n1Var.f10125a.get()) == null)) {
                    view.animate().setInterpolator(interpolator);
                }
                if (this.f9495d != null) {
                    n1Var.d(this.f9497f);
                }
                View view2 = (View) n1Var.f10125a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f9496e = true;
        }
    }
}
