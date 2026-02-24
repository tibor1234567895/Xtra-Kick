package j3;

import java.io.IOException;
import sb.c;
import wa.a;
import wb.g0;
import wb.p0;
import wb.q;
import wb.v;
import xa.j;
import xa.k;
import xa.u;

public final class x extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8719h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8720i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f8721j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f8722k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(y yVar, r rVar, boolean z10) {
        super(0);
        this.f8721j = yVar;
        this.f8722k = rVar;
        this.f8720i = z10;
    }

    public final void a() {
        int i10;
        long a10;
        int i11;
        g0[] g0VarArr;
        g0[] g0VarArr2;
        boolean z10;
        switch (this.f8719h) {
            case 0:
                x.super.d((r) this.f8722k, this.f8720i);
                return;
            default:
                q qVar = (q) this.f8721j;
                boolean z11 = this.f8720i;
                p0 p0Var = (p0) this.f8722k;
                qVar.getClass();
                j.f("settings", p0Var);
                u uVar = new u();
                v vVar = qVar.f16295i;
                synchronized (vVar.F) {
                    synchronized (vVar) {
                        try {
                            p0 p0Var2 = vVar.f16329z;
                            if (!z11) {
                                p0 p0Var3 = new p0();
                                j.f("other", p0Var2);
                                int i12 = 0;
                                while (true) {
                                    boolean z12 = true;
                                    if (i12 < 10) {
                                        if (((1 << i12) & p0Var2.f16292a) == 0) {
                                            z12 = false;
                                        }
                                        if (z12) {
                                            p0Var3.b(i12, p0Var2.f16293b[i12]);
                                        }
                                        i12++;
                                    } else {
                                        for (int i13 = 0; i13 < 10; i13++) {
                                            if (((1 << i13) & p0Var.f16292a) != 0) {
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            if (z10) {
                                                p0Var3.b(i13, p0Var.f16293b[i13]);
                                            }
                                        }
                                        p0Var = p0Var3;
                                    }
                                }
                            }
                            uVar.f16818h = p0Var;
                            a10 = ((long) p0Var.a()) - ((long) p0Var2.a());
                            i11 = (a10 > 0 ? 1 : (a10 == 0 ? 0 : -1));
                            if (i11 != 0) {
                                if (!vVar.f16313j.isEmpty()) {
                                    Object[] array = vVar.f16313j.values().toArray(new g0[0]);
                                    j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
                                    g0VarArr = (g0[]) array;
                                    g0VarArr2 = g0VarArr;
                                    p0 p0Var4 = (p0) uVar.f16818h;
                                    j.f("<set-?>", p0Var4);
                                    vVar.f16329z = p0Var4;
                                    c.c(vVar.f16321r, vVar.f16314k + " onSettings", 0, new l3.j(vVar, 8, uVar), 6);
                                    la.v vVar2 = la.v.f9814a;
                                }
                            }
                            g0VarArr = null;
                            g0VarArr2 = g0VarArr;
                            p0 p0Var42 = (p0) uVar.f16818h;
                            j.f("<set-?>", p0Var42);
                            vVar.f16329z = p0Var42;
                            c.c(vVar.f16321r, vVar.f16314k + " onSettings", 0, new l3.j(vVar, 8, uVar), 6);
                            la.v vVar22 = la.v.f9814a;
                        } finally {
                        }
                    }
                    try {
                        vVar.F.c((p0) uVar.f16818h);
                    } catch (IOException e10) {
                        vVar.e(e10);
                    }
                    la.v vVar3 = la.v.f9814a;
                }
                if (g0VarArr2 != null) {
                    for (g0 g0Var : g0VarArr2) {
                        synchronized (g0Var) {
                            g0Var.f16243f += a10;
                            if (i11 > 0) {
                                g0Var.notifyAll();
                            }
                            la.v vVar4 = la.v.f9814a;
                        }
                    }
                    return;
                }
                return;
        }
    }

    public final /* bridge */ /* synthetic */ Object b() {
        switch (this.f8719h) {
            case 0:
                a();
                return la.v.f9814a;
            default:
                a();
                return la.v.f9814a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(q qVar, p0 p0Var) {
        super(0);
        this.f8721j = qVar;
        this.f8720i = false;
        this.f8722k = p0Var;
    }
}
