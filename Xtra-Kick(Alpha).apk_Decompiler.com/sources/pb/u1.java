package pb;

import android.support.v4.media.h;
import dc.l;
import dc.n;
import fb.c;
import hb.h0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import la.a;
import qb.f;
import xa.j;

public abstract class u1 implements Closeable {
    public static final t1 Companion = new t1(0);
    private Reader reader;

    public static final u1 create(l lVar, x0 x0Var, long j10) {
        Companion.getClass();
        return t1.a(lVar, x0Var, j10);
    }

    public final InputStream byteStream() {
        return source().G0();
    }

    public final n byteString() throws IOException {
        n nVar;
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            l source = source();
            Throwable th = null;
            try {
                nVar = source.m();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                nVar = null;
                th = th3;
            }
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        a.a(th, th4);
                    }
                }
            }
            if (th == null) {
                j.c(nVar);
                int d10 = nVar.d();
                if (contentLength == -1 || contentLength == ((long) d10)) {
                    return nVar;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + d10 + ") disagree");
            }
            throw th;
        }
        throw new IOException(h.k("Cannot buffer entire body for content length: ", contentLength));
    }

    public final byte[] bytes() throws IOException {
        byte[] bArr;
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            l source = source();
            Throwable th = null;
            try {
                bArr = source.M();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bArr = null;
                th = th3;
            }
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        a.a(th, th4);
                    }
                }
            }
            if (th == null) {
                j.c(bArr);
                int length = bArr.length;
                if (contentLength == -1 || contentLength == ((long) length)) {
                    return bArr;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
            }
            throw th;
        }
        throw new IOException(h.k("Cannot buffer entire body for content length: ", contentLength));
    }

    public final Reader charStream() {
        Charset a10;
        Reader reader2 = this.reader;
        if (reader2 == null) {
            l source = source();
            x0 contentType = contentType();
            Charset charset = c.f5986b;
            j.f("defaultValue", charset);
            if (!(contentType == null || (a10 = contentType.a(charset)) == null)) {
                charset = a10;
            }
            reader2 = new s1(source, charset);
            this.reader = reader2;
        }
        return reader2;
    }

    public void close() {
        f.b(source());
    }

    public abstract long contentLength();

    public abstract x0 contentType();

    public abstract l source();

    public final String string() throws IOException {
        l source = source();
        try {
            x0 contentType = contentType();
            Charset charset = c.f5986b;
            j.f("defaultValue", charset);
            if (contentType != null) {
                Charset a10 = contentType.a(charset);
                if (a10 != null) {
                    charset = a10;
                }
            }
            String E0 = source.E0(qb.h.h(source, charset));
            h0.A(source, (Throwable) null);
            return E0;
        } catch (Throwable th) {
            h0.A(source, th);
            throw th;
        }
    }

    public static final u1 create(n nVar, x0 x0Var) {
        t1 t1Var = Companion;
        t1Var.getClass();
        j.f("<this>", nVar);
        dc.j jVar = new dc.j();
        jVar.N0(nVar);
        t1Var.getClass();
        return t1.a(jVar, x0Var, (long) nVar.d());
    }

    public static final u1 create(String str, x0 x0Var) {
        Companion.getClass();
        return t1.b(str, x0Var);
    }

    public static final u1 create(x0 x0Var, long j10, l lVar) {
        Companion.getClass();
        j.f("content", lVar);
        return t1.a(lVar, x0Var, j10);
    }

    public static final u1 create(x0 x0Var, n nVar) {
        t1 t1Var = Companion;
        t1Var.getClass();
        j.f("content", nVar);
        dc.j jVar = new dc.j();
        jVar.N0(nVar);
        t1Var.getClass();
        return t1.a(jVar, x0Var, (long) nVar.d());
    }

    public static final u1 create(x0 x0Var, String str) {
        Companion.getClass();
        j.f("content", str);
        return t1.b(str, x0Var);
    }

    public static final u1 create(x0 x0Var, byte[] bArr) {
        Companion.getClass();
        j.f("content", bArr);
        return t1.c(bArr, x0Var);
    }

    public static final u1 create(byte[] bArr, x0 x0Var) {
        Companion.getClass();
        return t1.c(bArr, x0Var);
    }
}
