package h3;

import h9.b;
import o1.b0;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7390h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c0 f7391i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b0 f7392j;

    public /* synthetic */ w(c0 c0Var, b0 b0Var, int i10) {
        this.f7390h = i10;
        this.f7391i = c0Var;
        this.f7392j = b0Var;
    }

    public final void run() {
        switch (this.f7390h) {
            case 0:
                c0 c0Var = this.f7391i;
                b0 b0Var = this.f7392j;
                c0Var.f6951p = b0Var;
                if (b0Var != null && c0Var.f6952q) {
                    c0Var.l(b0Var);
                }
                c0Var.a(new w(c0Var, b0Var, 1), new b0(7, c0Var));
                return;
            default:
                c0 c0Var2 = this.f7391i;
                b0 b0Var2 = this.f7392j;
                int i10 = c0.f6949r;
                if (c0Var2.f7762h instanceof b) {
                    b0Var2.a();
                    return;
                }
                return;
        }
    }
}
