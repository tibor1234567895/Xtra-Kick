package h5;

import android.util.Log;
import b4.e0;
import b5.a;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class l implements e {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7581h;

    /* renamed from: i  reason: collision with root package name */
    public Object f7582i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f7583j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f7584k;

    public /* synthetic */ l(Object obj, int i10, Object obj2) {
        this.f7581h = i10;
        this.f7583j = obj;
        this.f7584k = obj2;
    }

    public final Class a() {
        int i10 = this.f7581h;
        Object obj = this.f7584k;
        switch (i10) {
            case 0:
                switch (((e0) obj).f2537h) {
                    case 8:
                        return ByteBuffer.class;
                    default:
                        return InputStream.class;
                }
            default:
                return ((u) obj).a();
        }
    }

    public final void c() {
        int i10 = this.f7581h;
        Object obj = this.f7584k;
        switch (i10) {
            case 0:
                try {
                    Object obj2 = this.f7582i;
                    ((e0) obj).getClass();
                    ((InputStream) obj2).close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            default:
                Object obj3 = this.f7582i;
                if (obj3 != null) {
                    try {
                        ((u) obj).c(obj3);
                        return;
                    } catch (IOException unused2) {
                        return;
                    }
                } else {
                    return;
                }
        }
    }

    public final void cancel() {
    }

    public final a d() {
        return a.LOCAL;
    }

    public final void f(j jVar, d dVar) {
        int i10 = this.f7581h;
        Object obj = this.f7583j;
        Object obj2 = this.f7584k;
        switch (i10) {
            case 0:
                try {
                    ((e0) obj2).getClass();
                    ByteArrayInputStream h10 = e0.h((String) obj);
                    this.f7582i = h10;
                    dVar.g(h10);
                    return;
                } catch (IllegalArgumentException e10) {
                    dVar.e(e10);
                    return;
                }
            default:
                try {
                    Object b10 = ((u) obj2).b((File) obj);
                    this.f7582i = b10;
                    dVar.g(b10);
                    return;
                } catch (FileNotFoundException e11) {
                    Log.isLoggable("FileLoader", 3);
                    dVar.e(e11);
                    return;
                }
        }
    }
}
