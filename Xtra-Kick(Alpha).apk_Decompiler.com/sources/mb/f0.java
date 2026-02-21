package mb;

import android.support.v4.media.h;
import h3.u1;
import hb.e2;
import pa.k;
import xa.j;

public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f10849a = new u1("NO_THREAD_ELEMENTS", 2);

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f10850b = c0.f10842h;

    /* renamed from: c  reason: collision with root package name */
    public static final d0 f10851c = d0.f10844h;

    /* renamed from: d  reason: collision with root package name */
    public static final e0 f10852d = e0.f10847h;

    public static final void a(k kVar, Object obj) {
        if (obj != f10849a) {
            if (obj instanceof h0) {
                e2[] e2VarArr = ((h0) obj).f10858b;
                int length = e2VarArr.length - 1;
                if (length >= 0) {
                    e2 e2Var = e2VarArr[length];
                    j.c((Object) null);
                    throw null;
                }
                return;
            }
            Object j02 = kVar.j0((Object) null, f10851c);
            j.d("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>", j02);
            h.y(j02);
            throw null;
        }
    }

    public static final Object b(k kVar) {
        Object j02 = kVar.j0(0, f10850b);
        j.c(j02);
        return j02;
    }

    public static final Object c(k kVar, Object obj) {
        if (obj == null) {
            obj = b(kVar);
        }
        if (obj == 0) {
            return f10849a;
        }
        if (obj instanceof Integer) {
            return kVar.j0(new h0(kVar, ((Number) obj).intValue()), f10852d);
        }
        h.y(obj);
        throw null;
    }
}
