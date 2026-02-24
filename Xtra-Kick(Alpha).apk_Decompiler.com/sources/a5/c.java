package a5;

import b5.n;
import b5.p;
import d5.o0;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import k5.d;
import y4.a;

public final class c implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f142a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f143b;

    public /* synthetic */ c(int i10, Object obj) {
        this.f142a = i10;
        this.f143b = obj;
    }

    public final boolean a(Object obj, n nVar) {
        switch (this.f142a) {
            case 0:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                ((l) this.f143b).getClass();
                ((Boolean) nVar.c(l.f167e)).booleanValue();
                return false;
            default:
                a aVar = (a) obj;
                return true;
        }
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        int i12 = this.f142a;
        Object obj2 = this.f143b;
        switch (i12) {
            case 0:
                AtomicReference atomicReference = w5.a.f16106a;
                return ((l) obj2).a(new j4.n((ByteBuffer) obj), i10, i11, nVar);
            default:
                return d.c(((a) obj).b(), (e5.c) obj2);
        }
    }
}
