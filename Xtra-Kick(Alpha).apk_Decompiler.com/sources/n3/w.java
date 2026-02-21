package n3;

import android.support.v4.media.h;
import hb.h0;
import kb.j;
import la.v;
import pa.e;
import ra.i;
import wa.q;

public final class w extends i implements q {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f11533i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f11534j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(Object obj, e eVar, int i10) {
        super(3, eVar);
        this.f11533i = i10;
        this.f11534j = obj;
    }

    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
        switch (this.f11533i) {
            case 0:
                j jVar = (j) obj;
                Throwable th = (Throwable) obj2;
                return l((e) obj3);
            default:
                j jVar2 = (j) obj;
                Throwable th2 = (Throwable) obj2;
                return l((e) obj3);
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i10 = this.f11533i;
        Object obj2 = this.f11534j;
        switch (i10) {
            case 0:
                h0.O1(obj);
                h.y(obj2);
                return v.f9814a;
            default:
                h0.O1(obj);
                ((f1) obj2).getClass();
                return v.f9814a;
        }
    }

    public final v l(e eVar) {
        int i10 = this.f11533i;
        Object obj = this.f11534j;
        switch (i10) {
            case 0:
                h.y(obj);
                return (v) new w((Object) null, eVar, 0).invokeSuspend(v.f9814a);
            default:
                return (v) new w((f1) obj, eVar, 1).invokeSuspend(v.f9814a);
        }
    }
}
