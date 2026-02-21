package h5;

import android.content.Context;
import android.net.Uri;
import b5.n;
import c5.c;
import c5.d;
import c5.e;
import k5.t0;
import v5.b;

public final class e0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7566a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f7567b;

    public e0(Context context, int i10) {
        this.f7566a = i10;
        if (i10 == 1) {
            this.f7567b = context.getApplicationContext();
        } else if (i10 != 2) {
            this.f7567b = context;
        } else {
            this.f7567b = context.getApplicationContext();
        }
    }

    public final /* bridge */ /* synthetic */ h0 a(Object obj, int i10, int i11, n nVar) {
        switch (this.f7566a) {
            case 0:
                return c((Uri) obj, i10, i11, nVar);
            case 1:
                return c((Uri) obj, i10, i11, nVar);
            default:
                return c((Uri) obj, i10, i11, nVar);
        }
    }

    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        switch (this.f7566a) {
            case 0:
                return d((Uri) obj);
            case 1:
                return d((Uri) obj);
            default:
                return d((Uri) obj);
        }
    }

    public final h0 c(Uri uri, int i10, int i11, n nVar) {
        boolean z10;
        boolean z11 = true;
        int i12 = this.f7566a;
        Context context = this.f7567b;
        switch (i12) {
            case 0:
                return new h0(new b(uri), new d0(context, uri));
            case 1:
                if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE || i10 > 512 || i11 > 384) {
                    z11 = false;
                }
                if (z11) {
                    return new h0(new b(uri), e.b(context, uri, new c(context.getContentResolver())));
                }
                return null;
            default:
                if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE || i10 > 512 || i11 > 384) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!z10) {
                    return null;
                }
                Long l10 = (Long) nVar.c(t0.f9176d);
                if (l10 == null || l10.longValue() != -1) {
                    z11 = false;
                }
                if (z11) {
                    return new h0(new b(uri), e.b(context, uri, new d(context.getContentResolver())));
                }
                return null;
        }
    }

    public final boolean d(Uri uri) {
        switch (this.f7566a) {
            case 0:
                return c5.b.a(uri);
            case 1:
                if (!c5.b.a(uri) || uri.getPathSegments().contains("video")) {
                    return false;
                }
                return true;
            default:
                if (!c5.b.a(uri) || !uri.getPathSegments().contains("video")) {
                    return false;
                }
                return true;
        }
    }
}
