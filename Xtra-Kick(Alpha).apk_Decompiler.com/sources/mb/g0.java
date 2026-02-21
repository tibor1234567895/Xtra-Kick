package mb;

import hb.u0;
import hb.v0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import xa.j;

public class g0 {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10854b = AtomicIntegerFieldUpdater.newUpdater(g0.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    public u0[] f10855a;

    public final void a(u0 u0Var) {
        u0Var.e((v0) this);
        u0[] u0VarArr = this.f10855a;
        if (u0VarArr == null) {
            u0VarArr = new u0[4];
            this.f10855a = u0VarArr;
        } else if (b() >= u0VarArr.length) {
            Object[] copyOf = Arrays.copyOf(u0VarArr, b() * 2);
            j.e("copyOf(this, newSize)", copyOf);
            u0VarArr = (u0[]) copyOf;
            this.f10855a = u0VarArr;
        }
        int b10 = b();
        f10854b.set(this, b10 + 1);
        u0VarArr[b10] = u0Var;
        u0Var.f7858i = b10;
        f(b10);
    }

    public final int b() {
        return f10854b.get(this);
    }

    public final u0 c() {
        u0 u0Var;
        synchronized (this) {
            u0[] u0VarArr = this.f10855a;
            if (u0VarArr != null) {
                u0Var = u0VarArr[0];
            } else {
                u0Var = null;
            }
        }
        return u0Var;
    }

    public final void d(u0 u0Var) {
        synchronized (this) {
            if (u0Var.b() != null) {
                e(u0Var.f7858i);
            }
        }
    }

    public final u0 e(int i10) {
        u0[] u0VarArr = this.f10855a;
        j.c(u0VarArr);
        f10854b.set(this, b() - 1);
        if (i10 < b()) {
            g(i10, b());
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                u0 u0Var = u0VarArr[i10];
                j.c(u0Var);
                u0 u0Var2 = u0VarArr[i11];
                j.c(u0Var2);
                if (u0Var.compareTo(u0Var2) < 0) {
                    g(i10, i11);
                    f(i11);
                }
            }
            while (true) {
                int i12 = (i10 * 2) + 1;
                if (i12 >= b()) {
                    break;
                }
                u0[] u0VarArr2 = this.f10855a;
                j.c(u0VarArr2);
                int i13 = i12 + 1;
                if (i13 < b()) {
                    u0 u0Var3 = u0VarArr2[i13];
                    j.c(u0Var3);
                    u0 u0Var4 = u0VarArr2[i12];
                    j.c(u0Var4);
                    if (u0Var3.compareTo(u0Var4) < 0) {
                        i12 = i13;
                    }
                }
                u0 u0Var5 = u0VarArr2[i10];
                j.c(u0Var5);
                u0 u0Var6 = u0VarArr2[i12];
                j.c(u0Var6);
                if (u0Var5.compareTo(u0Var6) <= 0) {
                    break;
                }
                g(i10, i12);
                i10 = i12;
            }
        }
        u0 u0Var7 = u0VarArr[b()];
        j.c(u0Var7);
        u0Var7.e((v0) null);
        u0Var7.f7858i = -1;
        u0VarArr[b()] = null;
        return u0Var7;
    }

    public final void f(int i10) {
        while (i10 > 0) {
            u0[] u0VarArr = this.f10855a;
            j.c(u0VarArr);
            int i11 = (i10 - 1) / 2;
            u0 u0Var = u0VarArr[i11];
            j.c(u0Var);
            u0 u0Var2 = u0VarArr[i10];
            j.c(u0Var2);
            if (u0Var.compareTo(u0Var2) > 0) {
                g(i10, i11);
                i10 = i11;
            } else {
                return;
            }
        }
    }

    public final void g(int i10, int i11) {
        u0[] u0VarArr = this.f10855a;
        j.c(u0VarArr);
        u0 u0Var = u0VarArr[i11];
        j.c(u0Var);
        u0 u0Var2 = u0VarArr[i10];
        j.c(u0Var2);
        u0VarArr[i10] = u0Var;
        u0VarArr[i11] = u0Var2;
        u0Var.f7858i = i10;
        u0Var2.f7858i = i11;
    }
}
