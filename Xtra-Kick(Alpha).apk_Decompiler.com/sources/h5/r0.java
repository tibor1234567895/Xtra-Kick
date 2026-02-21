package h5;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.InputStream;

public final class r0 implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7614a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f7615b;

    public /* synthetic */ r0(Resources resources, int i10) {
        this.f7614a = i10;
        this.f7615b = resources;
    }

    public final i0 a(q0 q0Var) {
        int i10 = this.f7614a;
        Class<Uri> cls = Uri.class;
        Resources resources = this.f7615b;
        switch (i10) {
            case 0:
                return new q(resources, q0Var.c(cls, AssetFileDescriptor.class));
            case 1:
                return new q(resources, q0Var.c(cls, InputStream.class));
            default:
                return new q(resources, (i0) x0.f7626a);
        }
    }

    public final void b() {
    }
}
