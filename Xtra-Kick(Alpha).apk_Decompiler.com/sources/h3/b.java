package h3;

import android.net.Uri;
import android.support.v4.media.session.u;
import g1.v0;
import h9.e0;
import j1.a;
import java.util.Arrays;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final a f6920a;

    /* renamed from: b  reason: collision with root package name */
    public u f6921b;

    public b(p4 p4Var) {
        this.f6920a = p4Var;
    }

    public final e0 a(v0 v0Var) {
        byte[] bArr = v0Var.f6660q;
        if (bArr != null) {
            return b(bArr);
        }
        Uri uri = v0Var.f6662s;
        if (uri != null) {
            return c(uri);
        }
        return null;
    }

    public final e0 b(byte[] bArr) {
        boolean z10;
        u uVar = this.f6921b;
        if (uVar != null) {
            byte[] bArr2 = (byte[]) uVar.f428i;
            if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                e0 e0Var = (e0) this.f6921b.f430k;
                a.f(e0Var);
                return e0Var;
            }
        }
        e0 b10 = this.f6920a.b(bArr);
        this.f6921b = new u(bArr, b10);
        return b10;
    }

    public final e0 c(Uri uri) {
        boolean z10;
        u uVar = this.f6921b;
        if (uVar != null) {
            Uri uri2 = (Uri) uVar.f429j;
            if (uri2 == null || !uri2.equals(uri)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                e0 e0Var = (e0) this.f6921b.f430k;
                a.f(e0Var);
                return e0Var;
            }
        }
        e0 c10 = this.f6920a.c(uri);
        this.f6921b = new u(uri, c10);
        return c10;
    }
}
