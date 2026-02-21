package z1;

import g1.a2;
import j1.l0;
import m1.o1;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final int f17487a;

    /* renamed from: b  reason: collision with root package name */
    public final o1[] f17488b;

    /* renamed from: c  reason: collision with root package name */
    public final s[] f17489c;

    /* renamed from: d  reason: collision with root package name */
    public final a2 f17490d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f17491e;

    public y(o1[] o1VarArr, s[] sVarArr, a2 a2Var, u uVar) {
        this.f17488b = o1VarArr;
        this.f17489c = (s[]) sVarArr.clone();
        this.f17490d = a2Var;
        this.f17491e = uVar;
        this.f17487a = o1VarArr.length;
    }

    public final boolean a(y yVar, int i10) {
        return yVar != null && l0.a(this.f17488b[i10], yVar.f17488b[i10]) && l0.a(this.f17489c[i10], yVar.f17489c[i10]);
    }

    public final boolean b(int i10) {
        return this.f17488b[i10] != null;
    }
}
