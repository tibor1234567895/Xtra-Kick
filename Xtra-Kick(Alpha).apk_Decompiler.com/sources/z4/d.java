package z4;

import b4.e0;
import b5.n;
import h5.e;
import h5.f;
import h5.h0;
import h5.i0;
import h5.l;
import h5.u;
import h5.x;
import java.io.File;
import pb.h;
import v5.b;

public final class d implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17577a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f17578b;

    public /* synthetic */ d(int i10, Object obj) {
        this.f17577a = i10;
        this.f17578b = obj;
    }

    public final h0 a(Object obj, int i10, int i11, n nVar) {
        int i12 = this.f17577a;
        Object obj2 = this.f17578b;
        switch (i12) {
            case 0:
                x xVar = (x) obj;
                return new h0(xVar, new b((h) obj2, xVar));
            case 1:
                byte[] bArr = (byte[]) obj;
                return new h0(new b(bArr), new f(bArr, (e) obj2));
            case 2:
                return new h0(new b(obj), new l(obj.toString(), 0, (e0) obj2));
            default:
                File file = (File) obj;
                return new h0(new b(file), new l(file, 1, (u) obj2));
        }
    }

    public final boolean b(Object obj) {
        switch (this.f17577a) {
            case 0:
                x xVar = (x) obj;
                return true;
            case 1:
                byte[] bArr = (byte[]) obj;
                return true;
            case 2:
                return obj.toString().startsWith("data:image");
            default:
                File file = (File) obj;
                return true;
        }
    }
}
