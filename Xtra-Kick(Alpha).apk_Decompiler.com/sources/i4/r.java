package i4;

import android.graphics.Bitmap;
import hb.f0;
import hb.h0;
import java.util.ArrayList;
import la.v;
import n4.m;
import pa.e;
import qa.a;
import ra.i;
import t4.g;
import wa.p;

public final class r extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f8265i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s4.i f8266j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ t f8267k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ g f8268l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ i f8269m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Bitmap f8270n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(s4.i iVar, t tVar, g gVar, i iVar2, Bitmap bitmap, e eVar) {
        super(2, eVar);
        this.f8266j = iVar;
        this.f8267k = tVar;
        this.f8268l = gVar;
        this.f8269m = iVar2;
        this.f8270n = bitmap;
    }

    public final e create(Object obj, e eVar) {
        return new r(this.f8266j, this.f8267k, this.f8268l, this.f8269m, this.f8270n, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((r) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f8265i;
        if (i10 == 0) {
            h0.O1(obj);
            s4.i iVar = this.f8266j;
            ArrayList arrayList = this.f8267k.f8278g;
            g gVar = this.f8268l;
            i iVar2 = this.f8269m;
            if (this.f8270n != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            m mVar = new m(iVar, arrayList, 0, iVar, gVar, iVar2, z10);
            this.f8265i = 1;
            obj = mVar.b(iVar, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
