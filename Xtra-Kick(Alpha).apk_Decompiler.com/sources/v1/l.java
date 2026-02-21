package v1;

import androidx.appcompat.widget.i5;
import c9.w;
import d2.a0;
import k1.g;

public final /* synthetic */ class l implements w {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f15703h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f15704i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f15705j;

    public /* synthetic */ l(Object obj, g gVar, int i10) {
        this.f15703h = i10;
        this.f15704i = obj;
        this.f15705j = gVar;
    }

    public final Object get() {
        int i10 = this.f15703h;
        g gVar = this.f15705j;
        Object obj = this.f15704i;
        switch (i10) {
            case 0:
                return n.d((Class) obj, gVar);
            case 1:
                return n.d((Class) obj, gVar);
            case 2:
                return n.d((Class) obj, gVar);
            default:
                return new t0(gVar, (a0) ((i5) obj).f874b);
        }
    }
}
