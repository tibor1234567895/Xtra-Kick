package b4;

import java.util.ArrayList;

public final class k extends v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f2551a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2552b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2553c = null;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2554d = null;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f2555e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2556f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ m f2557g;

    public k(m mVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f2557g = mVar;
        this.f2551a = obj;
        this.f2552b = arrayList;
        this.f2555e = obj2;
        this.f2556f = arrayList2;
    }

    public final void a(u uVar) {
        uVar.v(this);
    }

    public final void b(u uVar) {
        m mVar = this.f2557g;
        Object obj = this.f2551a;
        if (obj != null) {
            mVar.s(obj, this.f2552b, (ArrayList) null);
        }
        Object obj2 = this.f2553c;
        if (obj2 != null) {
            mVar.s(obj2, this.f2554d, (ArrayList) null);
        }
        Object obj3 = this.f2555e;
        if (obj3 != null) {
            mVar.s(obj3, this.f2556f, (ArrayList) null);
        }
    }
}
