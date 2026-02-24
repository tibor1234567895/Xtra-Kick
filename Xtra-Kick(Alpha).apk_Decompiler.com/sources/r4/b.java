package r4;

import android.graphics.Bitmap;
import dc.i0;
import fb.y;
import hb.h0;
import la.e;
import la.f;
import pb.n0;
import pb.p0;
import pb.r1;
import xa.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final e f13795a = f.a(new a(this, 0));

    /* renamed from: b  reason: collision with root package name */
    public final e f13796b = f.a(new a(this, 1));

    /* renamed from: c  reason: collision with root package name */
    public final long f13797c;

    /* renamed from: d  reason: collision with root package name */
    public final long f13798d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f13799e;

    /* renamed from: f  reason: collision with root package name */
    public final p0 f13800f;

    public b(i0 i0Var) {
        this.f13797c = Long.parseLong(i0Var.K());
        this.f13798d = Long.parseLong(i0Var.K());
        this.f13799e = Integer.parseInt(i0Var.K()) > 0;
        int parseInt = Integer.parseInt(i0Var.K());
        n0 n0Var = new n0();
        int i10 = 0;
        while (i10 < parseInt) {
            String K = i0Var.K();
            Bitmap.Config[] configArr = w4.e.f16080a;
            int t10 = y.t(K, ':', 0, false, 6);
            if (t10 != -1) {
                String substring = K.substring(0, t10);
                j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                String obj = y.R(substring).toString();
                String substring2 = K.substring(t10 + 1);
                j.e("this as java.lang.String).substring(startIndex)", substring2);
                j.f("name", obj);
                h0.N0(obj);
                h0.C(n0Var, obj, substring2);
                i10++;
            } else {
                throw new IllegalArgumentException("Unexpected header: ".concat(K).toString());
            }
        }
        this.f13800f = n0Var.b();
    }

    public final void a(dc.h0 h0Var) {
        long j10;
        h0Var.w0(this.f13797c);
        h0Var.S(10);
        h0Var.w0(this.f13798d);
        h0Var.S(10);
        if (this.f13799e) {
            j10 = 1;
        } else {
            j10 = 0;
        }
        h0Var.w0(j10);
        h0Var.S(10);
        p0 p0Var = this.f13800f;
        h0Var.w0((long) (p0Var.f12931h.length / 2));
        h0Var.S(10);
        int length = p0Var.f12931h.length / 2;
        for (int i10 = 0; i10 < length; i10++) {
            h0Var.v0(p0Var.c(i10));
            h0Var.v0(": ");
            h0Var.v0(p0Var.f(i10));
            h0Var.S(10);
        }
    }

    public b(r1 r1Var) {
        boolean z10 = false;
        this.f13797c = r1Var.f12971r;
        this.f13798d = r1Var.f12972s;
        this.f13799e = r1Var.f12965l != null ? true : z10;
        this.f13800f = r1Var.f12966m;
    }
}
