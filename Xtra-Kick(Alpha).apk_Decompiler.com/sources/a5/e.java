package a5;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.media.session.u;
import b5.n;
import b5.p;
import d5.o0;
import e5.c;
import e5.k;
import java.io.InputStream;
import java.util.ArrayDeque;
import k5.a;
import k5.d;
import k5.e0;
import k5.w;
import k5.y;
import w5.l;

public final class e implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f147a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f148b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f149c;

    public e(Resources resources, p pVar) {
        this.f147a = 1;
        this.f149c = resources;
        this.f148b = pVar;
    }

    public final boolean a(Object obj, n nVar) {
        switch (this.f147a) {
            case 0:
                InputStream inputStream = (InputStream) obj;
                return d(nVar);
            case 1:
                return ((p) this.f148b).a(obj, nVar);
            case 2:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                InputStream inputStream2 = (InputStream) obj;
                return d(nVar);
        }
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        int i12 = this.f147a;
        Object obj2 = this.f149c;
        Object obj3 = this.f148b;
        switch (i12) {
            case 0:
                return c((InputStream) obj, i10, i11, nVar);
            case 1:
                o0 b10 = ((p) obj3).b(obj, i10, i11, nVar);
                Resources resources = (Resources) obj2;
                if (b10 == null) {
                    return null;
                }
                return new d(resources, b10);
            case 2:
                o0 c10 = ((m5.e) obj3).c((Uri) obj, nVar);
                if (c10 == null) {
                    return null;
                }
                return y.a((c) obj2, (Drawable) ((m5.c) c10).get(), i10, i11);
            default:
                return c((InputStream) obj, i10, i11, nVar);
        }
    }

    public final o0 c(InputStream inputStream, int i10, int i11, n nVar) {
        e0 e0Var;
        boolean z10;
        w5.d dVar;
        switch (this.f147a) {
            case 0:
                return ((l) this.f148b).a(inputStream, i10, i11, nVar);
            default:
                if (inputStream instanceof e0) {
                    e0Var = (e0) inputStream;
                    z10 = false;
                } else {
                    e0Var = new e0(inputStream, (k) this.f149c);
                    z10 = true;
                }
                ArrayDeque arrayDeque = w5.d.f16110j;
                synchronized (arrayDeque) {
                    dVar = (w5.d) arrayDeque.poll();
                }
                if (dVar == null) {
                    dVar = new w5.d();
                }
                dVar.f16111h = e0Var;
                l lVar = new l(dVar);
                a aVar = new a((Object) e0Var, 1, (Object) dVar);
                try {
                    w wVar = (w) this.f148b;
                    return wVar.a(new u(wVar.f9193c, lVar, wVar.f9194d), i10, i11, nVar, aVar);
                } finally {
                    dVar.c();
                    if (z10) {
                        e0Var.e();
                    }
                }
        }
    }

    public final boolean d(n nVar) {
        int i10 = this.f147a;
        Object obj = this.f148b;
        switch (i10) {
            case 0:
                ((l) obj).getClass();
                ((Boolean) nVar.c(l.f167e)).booleanValue();
                return false;
            default:
                ((w) obj).getClass();
                return true;
        }
    }

    public /* synthetic */ e(Object obj, int i10, Object obj2) {
        this.f147a = i10;
        this.f148b = obj;
        this.f149c = obj2;
    }
}
