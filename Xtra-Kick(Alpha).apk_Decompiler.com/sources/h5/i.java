package h5;

import android.util.Log;
import b5.a;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class i implements e {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7578h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f7579i;

    public /* synthetic */ i(int i10, Object obj) {
        this.f7578h = i10;
        this.f7579i = obj;
    }

    public final Class a() {
        switch (this.f7578h) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.f7579i.getClass();
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
        int i10 = this.f7578h;
        Object obj = this.f7579i;
        switch (i10) {
            case 0:
                try {
                    dVar.g(w5.a.a((File) obj));
                    return;
                } catch (IOException e10) {
                    Log.isLoggable("ByteBufferFileLoader", 3);
                    dVar.e(e10);
                    return;
                }
            default:
                dVar.g(obj);
                return;
        }
    }
}
