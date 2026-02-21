package dagger.hilt.android.internal.managers;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import androidx.fragment.app.c0;

public final class l extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f4740a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f4741b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Context context, c0 c0Var) {
        super(context);
        context.getClass();
        ViewComponentManager$FragmentContextWrapper$1 viewComponentManager$FragmentContextWrapper$1 = new ViewComponentManager$FragmentContextWrapper$1(this);
        this.f4740a = null;
        c0Var.getClass();
        c0Var.V.a(viewComponentManager$FragmentContextWrapper$1);
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f4741b == null) {
            if (this.f4740a == null) {
                this.f4740a = (LayoutInflater) getBaseContext().getSystemService("layout_inflater");
            }
            this.f4741b = this.f4740a.cloneInContext(this);
        }
        return this.f4741b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(android.view.LayoutInflater r2, androidx.fragment.app.c0 r3) {
        /*
            r1 = this;
            r2.getClass()
            android.content.Context r0 = r2.getContext()
            r0.getClass()
            r1.<init>(r0)
            dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper$1 r0 = new dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper$1
            r0.<init>(r1)
            r1.f4740a = r2
            r3.getClass()
            androidx.lifecycle.g0 r2 = r3.V
            r2.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dagger.hilt.android.internal.managers.l.<init>(android.view.LayoutInflater, androidx.fragment.app.c0):void");
    }
}
