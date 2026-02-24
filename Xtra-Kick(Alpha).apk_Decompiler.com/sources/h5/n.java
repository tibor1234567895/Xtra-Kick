package h5;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import java.io.InputStream;

public final class n implements j0, p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7594a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f7595b;

    public /* synthetic */ n(Context context, int i10) {
        this.f7594a = i10;
        this.f7595b = context;
    }

    public final i0 a(q0 q0Var) {
        int i10 = this.f7594a;
        Class<Integer> cls = Integer.class;
        Context context = this.f7595b;
        switch (i10) {
            case 0:
                return new q(context, (p) this);
            case 1:
                return new q(context, (p) this);
            case 2:
                return new q(context, (p) this);
            case 3:
                return new e0(context, 0);
            case 4:
                return new q(context, q0Var.c(cls, AssetFileDescriptor.class));
            case Constants.MAX_COMPATIBILITY_VERSION:
                return new q(context, q0Var.c(cls, InputStream.class));
            case 6:
                return new e0(context, 1);
            default:
                return new e0(context, 2);
        }
    }

    public final void b() {
    }
}
