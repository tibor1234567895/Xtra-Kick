package h5;

import b4.e0;
import b5.a;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class f implements e {

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f7568h;

    /* renamed from: i  reason: collision with root package name */
    public final e f7569i;

    public f(byte[] bArr, e eVar) {
        this.f7568h = bArr;
        this.f7569i = eVar;
    }

    public final Class a() {
        switch (((e0) this.f7569i).f2537h) {
            case 8:
                return ByteBuffer.class;
            default:
                return InputStream.class;
        }
    }

    public final void c() {
    }

    public final void cancel() {
    }

    public final a d() {
        return a.LOCAL;
    }

    public final void f(j jVar, d dVar) {
        Object obj;
        int i10 = ((e0) this.f7569i).f2537h;
        byte[] bArr = this.f7568h;
        switch (i10) {
            case 8:
                obj = ByteBuffer.wrap(bArr);
                break;
            default:
                obj = new ByteArrayInputStream(bArr);
                break;
        }
        dVar.g(obj);
    }
}
