package j3;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import la.v;
import ma.b0;
import wa.l;
import xa.j;
import xa.k;
import xa.q;
import xa.s;

public final class f0 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ q f8529h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List f8530i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s f8531j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ k0 f8532k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Bundle f8533l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(q qVar, ArrayList arrayList, s sVar, k0 k0Var, Bundle bundle) {
        super(1);
        this.f8529h = qVar;
        this.f8530i = arrayList;
        this.f8531j = sVar;
        this.f8532k = k0Var;
        this.f8533l = bundle;
    }

    public final Object invoke(Object obj) {
        List list;
        r rVar = (r) obj;
        j.f("entry", rVar);
        this.f8529h.f16814h = true;
        List list2 = this.f8530i;
        int indexOf = list2.indexOf(rVar);
        if (indexOf != -1) {
            s sVar = this.f8531j;
            int i10 = indexOf + 1;
            list = list2.subList(sVar.f16816h, i10);
            sVar.f16816h = i10;
        } else {
            list = b0.f10801h;
        }
        this.f8532k.a(rVar.f8661i, this.f8533l, rVar, list);
        return v.f9814a;
    }
}
