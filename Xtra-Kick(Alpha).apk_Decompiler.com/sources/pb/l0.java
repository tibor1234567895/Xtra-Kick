package pb;

import androidx.lifecycle.h2;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import ma.b0;
import wa.a;
import xa.k;

public final class l0 extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12894h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ a f12895i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l0(a aVar, int i10) {
        super(0);
        this.f12894h = i10;
        this.f12895i = aVar;
    }

    public final Object b() {
        int i10 = this.f12894h;
        a aVar = this.f12895i;
        switch (i10) {
            case 0:
                try {
                    return (List) aVar.b();
                } catch (SSLPeerUnverifiedException unused) {
                    return b0.f10801h;
                }
            default:
                return (h2) aVar.b();
        }
    }
}
