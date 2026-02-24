package x4;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public final class e extends ByteArrayOutputStream {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ f f16673h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, int i10) {
        super(i10);
        this.f16673h = fVar;
    }

    public final String toString() {
        int i10 = this.count;
        if (i10 > 0 && this.buf[i10 - 1] == 13) {
            i10--;
        }
        try {
            return new String(this.buf, 0, i10, this.f16673h.f16675i.name());
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}
