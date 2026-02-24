package j3;

import u3.f;
import wa.l;
import xa.j;
import xa.k;

public final class j0 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8571h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f8572i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(String str, int i10) {
        super(1);
        this.f8571h = i10;
        this.f8572i = str;
    }

    public final Object invoke(Object obj) {
        int i10 = this.f8571h;
        String str = this.f8572i;
        switch (i10) {
            case 0:
                return Boolean.valueOf(j.a((String) obj, str));
            case 1:
                f fVar = (f) obj;
                j.f("db", fVar);
                fVar.p(str);
                return null;
            default:
                String str2 = (String) obj;
                j.f("line", str2);
                return str + str2;
        }
    }
}
