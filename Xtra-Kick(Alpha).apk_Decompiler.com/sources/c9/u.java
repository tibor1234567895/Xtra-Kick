package c9;

import b4.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final g f3052a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f3053b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3054c = Integer.MAX_VALUE;

    public u(e0 e0Var) {
        f fVar = f.f3032i;
        this.f3053b = e0Var;
        this.f3052a = fVar;
    }

    public final List a(CharSequence charSequence) {
        charSequence.getClass();
        e0 e0Var = this.f3053b;
        e0Var.getClass();
        t tVar = new t(e0Var, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (tVar.hasNext()) {
            arrayList.add((String) tVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
