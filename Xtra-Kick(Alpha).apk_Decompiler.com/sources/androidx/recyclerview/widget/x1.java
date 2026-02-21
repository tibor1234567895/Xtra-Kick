package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public final class x1 {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f2232a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    public int f2233b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Set f2234c = Collections.newSetFromMap(new IdentityHashMap());

    public final w1 a(int i10) {
        SparseArray sparseArray = this.f2232a;
        w1 w1Var = (w1) sparseArray.get(i10);
        if (w1Var != null) {
            return w1Var;
        }
        w1 w1Var2 = new w1();
        sparseArray.put(i10, w1Var2);
        return w1Var2;
    }
}
