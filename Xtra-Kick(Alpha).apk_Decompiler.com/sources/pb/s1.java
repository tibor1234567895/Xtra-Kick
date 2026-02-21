package pb;

import dc.l;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import la.v;
import qb.h;
import xa.j;

public final class s1 extends Reader {

    /* renamed from: h  reason: collision with root package name */
    public final l f12977h;

    /* renamed from: i  reason: collision with root package name */
    public final Charset f12978i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12979j;

    /* renamed from: k  reason: collision with root package name */
    public InputStreamReader f12980k;

    public s1(l lVar, Charset charset) {
        j.f("source", lVar);
        j.f("charset", charset);
        this.f12977h = lVar;
        this.f12978i = charset;
    }

    public final void close() {
        v vVar;
        this.f12979j = true;
        InputStreamReader inputStreamReader = this.f12980k;
        if (inputStreamReader != null) {
            inputStreamReader.close();
            vVar = v.f9814a;
        } else {
            vVar = null;
        }
        if (vVar == null) {
            this.f12977h.close();
        }
    }

    public final int read(char[] cArr, int i10, int i11) {
        j.f("cbuf", cArr);
        if (!this.f12979j) {
            InputStreamReader inputStreamReader = this.f12980k;
            if (inputStreamReader == null) {
                l lVar = this.f12977h;
                inputStreamReader = new InputStreamReader(lVar.G0(), h.h(lVar, this.f12978i));
                this.f12980k = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i10, i11);
        }
        throw new IOException("Stream closed");
    }
}
