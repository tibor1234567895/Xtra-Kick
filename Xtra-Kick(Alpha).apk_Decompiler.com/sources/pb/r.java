package pb;

import java.util.ArrayList;
import java.util.Arrays;
import xa.j;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12948a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f12949b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f12950c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12951d;

    public r() {
        this.f12948a = true;
    }

    public final t a() {
        return new t(this.f12948a, this.f12951d, this.f12949b, this.f12950c);
    }

    public final void b(String... strArr) {
        j.f("cipherSuites", strArr);
        if (this.f12948a) {
            if (!(strArr.length == 0)) {
                Object clone = strArr.clone();
                j.d("null cannot be cast to non-null type kotlin.Array<kotlin.String>", clone);
                this.f12949b = (String[]) clone;
                return;
            }
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        }
        throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
    }

    public final void c(p... pVarArr) {
        j.f("cipherSuites", pVarArr);
        if (this.f12948a) {
            ArrayList arrayList = new ArrayList(pVarArr.length);
            for (p pVar : pVarArr) {
                arrayList.add(pVar.f12929a);
            }
            Object[] array = arrayList.toArray(new String[0]);
            j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
            String[] strArr = (String[]) array;
            b((String[]) Arrays.copyOf(strArr, strArr.length));
            return;
        }
        throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
    }

    public final void d() {
        if (this.f12948a) {
            this.f12951d = true;
            return;
        }
        throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
    }

    public final void e(String... strArr) {
        j.f("tlsVersions", strArr);
        if (this.f12948a) {
            if (!(strArr.length == 0)) {
                Object clone = strArr.clone();
                j.d("null cannot be cast to non-null type kotlin.Array<kotlin.String>", clone);
                this.f12950c = (String[]) clone;
                return;
            }
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        }
        throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
    }

    public final void f(x1... x1VarArr) {
        if (this.f12948a) {
            ArrayList arrayList = new ArrayList(x1VarArr.length);
            for (x1 x1Var : x1VarArr) {
                arrayList.add(x1Var.f13034h);
            }
            Object[] array = arrayList.toArray(new String[0]);
            j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
            String[] strArr = (String[]) array;
            e((String[]) Arrays.copyOf(strArr, strArr.length));
            return;
        }
        throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
    }

    public r(t tVar) {
        j.f("connectionSpec", tVar);
        this.f12948a = tVar.f12983a;
        this.f12949b = tVar.f12985c;
        this.f12950c = tVar.f12986d;
        this.f12951d = tVar.f12984b;
    }
}
