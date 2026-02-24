package h5;

import android.net.Uri;
import b5.n;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class c1 implements i0 {

    /* renamed from: b  reason: collision with root package name */
    public static final Set f7561b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a  reason: collision with root package name */
    public final i0 f7562a;

    public c1(i0 i0Var) {
        this.f7562a = i0Var;
    }

    public final h0 a(Object obj, int i10, int i11, n nVar) {
        return this.f7562a.a(new x(((Uri) obj).toString()), i10, i11, nVar);
    }

    public final boolean b(Object obj) {
        return f7561b.contains(((Uri) obj).getScheme());
    }
}
