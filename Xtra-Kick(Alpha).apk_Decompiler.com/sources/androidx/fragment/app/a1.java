package androidx.fragment.app;

import java.util.ArrayList;

public final class a1 implements z0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1323a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1324b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1325c = 1;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c1 f1326d;

    public a1(c1 c1Var, String str, int i10) {
        this.f1326d = c1Var;
        this.f1323a = str;
        this.f1324b = i10;
    }

    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        c0 c0Var = this.f1326d.f1395y;
        if (c0Var != null && this.f1324b < 0 && this.f1323a == null && c0Var.u().Q()) {
            return false;
        }
        return this.f1326d.S(arrayList, arrayList2, this.f1323a, this.f1324b, this.f1325c);
    }
}
