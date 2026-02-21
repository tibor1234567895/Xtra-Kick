package d9;

import c9.q;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public Object[] f4663a;

    /* renamed from: b  reason: collision with root package name */
    public int f4664b;

    public s0() {
        this(4);
    }

    public t0 a() {
        int i10 = this.f4664b;
        Object[] objArr = this.f4663a;
        if (i10 == 0) {
            return w1.f4691n;
        }
        w1 w1Var = w1.f4691n;
        if (i10 == 1) {
            Objects.requireNonNull(objArr[0]);
            Objects.requireNonNull(objArr[1]);
            return new w1(1, (Object) null, objArr);
        }
        q.d(i10, objArr.length >> 1);
        return new w1(i10, w1.g(objArr, i10, u0.h(i10), 0), objArr);
    }

    public s0 b(Object obj, Object obj2) {
        int i10 = (this.f4664b + 1) * 2;
        Object[] objArr = this.f4663a;
        if (i10 > objArr.length) {
            this.f4663a = Arrays.copyOf(objArr, l0.a(objArr.length, i10));
        }
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
            sb2.append("null key in entry: null=");
            sb2.append(valueOf);
            throw new NullPointerException(sb2.toString());
        } else if (obj2 != null) {
            Object[] objArr2 = this.f4663a;
            int i11 = this.f4664b;
            int i12 = i11 * 2;
            objArr2[i12] = obj;
            objArr2[i12 + 1] = obj2;
            this.f4664b = i11 + 1;
            return this;
        } else {
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 26);
            sb3.append("null value in entry: ");
            sb3.append(valueOf2);
            sb3.append("=null");
            throw new NullPointerException(sb3.toString());
        }
    }

    public void c(Map.Entry entry) {
        b(entry.getKey(), entry.getValue());
    }

    public s0 d(Iterable iterable) {
        if (iterable instanceof Collection) {
            int size = (((Collection) iterable).size() + this.f4664b) * 2;
            Object[] objArr = this.f4663a;
            if (size > objArr.length) {
                this.f4663a = Arrays.copyOf(objArr, l0.a(objArr.length, size));
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c((Map.Entry) it.next());
        }
        return this;
    }

    public s0(int i10) {
        this.f4663a = new Object[(i10 * 2)];
        this.f4664b = 0;
    }
}
