package n1;

import g1.u1;
import j1.q;
import java.util.HashMap;
import v1.a0;

public final /* synthetic */ class n implements q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10979h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f10980i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f10981j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f10982k;

    public /* synthetic */ n(b bVar, int i10, long j10, long j11, int i11) {
        this.f10979h = i11;
        this.f10980i = bVar;
        this.f10981j = i10;
        this.f10982k = j10;
    }

    public final void invoke(Object obj) {
        String str;
        long j10;
        switch (this.f10979h) {
            case 0:
                ((c) obj).getClass();
                return;
            default:
                c0 c0Var = (c0) ((c) obj);
                c0Var.getClass();
                b bVar = this.f10980i;
                a0 a0Var = bVar.f10924d;
                if (a0Var != null) {
                    z zVar = c0Var.f10932b;
                    u1 u1Var = bVar.f10922b;
                    synchronized (zVar) {
                        str = zVar.b(u1Var.p(a0Var.f6678a, zVar.f11016b).f6544j, a0Var).f11006a;
                    }
                    HashMap hashMap = c0Var.f10938h;
                    Long l10 = (Long) hashMap.get(str);
                    HashMap hashMap2 = c0Var.f10937g;
                    Long l11 = (Long) hashMap2.get(str);
                    long j11 = 0;
                    if (l10 == null) {
                        j10 = 0;
                    } else {
                        j10 = l10.longValue();
                    }
                    hashMap.put(str, Long.valueOf(j10 + this.f10982k));
                    if (l11 != null) {
                        j11 = l11.longValue();
                    }
                    hashMap2.put(str, Long.valueOf(j11 + ((long) this.f10981j)));
                    return;
                }
                return;
        }
    }
}
