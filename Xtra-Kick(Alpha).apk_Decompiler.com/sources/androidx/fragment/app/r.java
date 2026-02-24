package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.p0;
import java.util.Objects;

public final class r implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t f1554a;

    public r(t tVar) {
        this.f1554a = tVar;
    }

    public final void b(Object obj) {
        if (((d0) obj) != null) {
            t tVar = this.f1554a;
            if (tVar.f1570k0) {
                View h02 = tVar.h0();
                if (h02.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } else if (tVar.f1574o0 != null) {
                    if (c1.I(3)) {
                        Objects.toString(tVar.f1574o0);
                    }
                    tVar.f1574o0.setContentView(h02);
                }
            }
        }
    }
}
