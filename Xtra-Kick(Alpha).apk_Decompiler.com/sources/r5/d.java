package r5;

import android.support.v4.media.session.u;
import d5.l0;
import d5.o;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import p5.f;
import q.e;
import w5.m;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final l0 f13824c = new l0(Object.class, Object.class, Object.class, Collections.singletonList(new o(Object.class, Object.class, Object.class, Collections.emptyList(), new f(), (u) null)), (u) null);

    /* renamed from: a  reason: collision with root package name */
    public final e f13825a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference f13826b = new AtomicReference();

    public final void a(Class cls, Class cls2, Class cls3, l0 l0Var) {
        synchronized (this.f13825a) {
            e eVar = this.f13825a;
            m mVar = new m(cls, cls2, cls3);
            if (l0Var == null) {
                l0Var = f13824c;
            }
            eVar.put(mVar, l0Var);
        }
    }
}
