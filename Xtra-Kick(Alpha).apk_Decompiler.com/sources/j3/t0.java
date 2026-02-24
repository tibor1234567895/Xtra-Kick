package j3;

import android.os.Bundle;
import wa.l;
import xa.j;
import xa.k;

public final class t0 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8683h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Bundle f8684i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t0(int i10, Bundle bundle) {
        super(1);
        this.f8683h = i10;
        this.f8684i = bundle;
    }

    public final Boolean a(String str) {
        int i10 = this.f8683h;
        Bundle bundle = this.f8684i;
        switch (i10) {
            case 0:
                j.f("argName", str);
                return Boolean.valueOf(!bundle.containsKey(str));
            default:
                j.f("key", str);
                return Boolean.valueOf(!bundle.containsKey(str));
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f8683h) {
            case 0:
                return a((String) obj);
            default:
                return a((String) obj);
        }
    }
}
