package b4;

import android.view.View;
import java.util.ArrayList;
import q.e;

public final class g extends v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2540a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2541b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2542c;

    public /* synthetic */ g(Object obj, int i10, Object obj2) {
        this.f2540a = i10;
        this.f2542c = obj;
        this.f2541b = obj2;
    }

    public final void a(u uVar) {
        int i10 = this.f2540a;
        Object obj = this.f2541b;
        switch (i10) {
            case 0:
                i0 i0Var = g0.f2543a;
                i0Var.d((View) obj, 1.0f);
                i0Var.getClass();
                uVar.v(this);
                return;
            case 1:
                ((ArrayList) ((e) obj).getOrDefault(((w) this.f2542c).f2608i, (Object) null)).remove(uVar);
                uVar.v(this);
                return;
            default:
                ((u) obj).y();
                uVar.v(this);
                return;
        }
    }
}
