package w0;

import android.widget.EditText;
import g1.a0;
import j1.b0;
import j1.l0;
import j1.v;
import u2.b;
import u2.f;

public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public int f16017a;

    /* renamed from: b  reason: collision with root package name */
    public int f16018b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f16019c;

    public c(EditText editText) {
        this.f16017a = Integer.MAX_VALUE;
        this.f16018b = 0;
        if (editText != null) {
            this.f16019c = new a(editText);
            return;
        }
        throw new NullPointerException("editText cannot be null");
    }

    public final int a() {
        return this.f16017a;
    }

    public final int b() {
        return this.f16018b;
    }

    public final int c() {
        int i10 = this.f16017a;
        return i10 == -1 ? ((b0) this.f16019c).y() : i10;
    }

    public c(b bVar, a0 a0Var) {
        b0 b0Var = bVar.f15199c;
        this.f16019c = b0Var;
        b0Var.G(12);
        int y10 = b0Var.y();
        if ("audio/raw".equals(a0Var.f6276s)) {
            int u10 = l0.u(a0Var.H, a0Var.F);
            if (y10 == 0 || y10 % u10 != 0) {
                v.g("AtomParsers", "Audio sample size mismatch. stsd sample size: " + u10 + ", stsz sample size: " + y10);
                y10 = u10;
            }
        }
        this.f16017a = y10 == 0 ? -1 : y10;
        this.f16018b = b0Var.y();
    }

    public c(byte[] bArr, int i10, int i11) {
        this.f16019c = bArr;
        this.f16017a = i10;
        this.f16018b = i11;
    }
}
