package androidx.emoji2.text;

import android.util.SparseArray;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f1247a;

    /* renamed from: b  reason: collision with root package name */
    public u f1248b;

    private d0() {
        this(1);
    }

    public final void a(u uVar, int i10, int i11) {
        d0 d0Var;
        int a10 = uVar.a(i10);
        SparseArray sparseArray = this.f1247a;
        if (sparseArray == null) {
            d0Var = null;
        } else {
            d0Var = (d0) sparseArray.get(a10);
        }
        if (d0Var == null) {
            d0Var = new d0();
            sparseArray.put(uVar.a(i10), d0Var);
        }
        if (i11 > i10) {
            d0Var.a(uVar, i10 + 1, i11);
        } else {
            d0Var.f1248b = uVar;
        }
    }

    public d0(int i10) {
        this.f1247a = new SparseArray(i10);
    }
}
