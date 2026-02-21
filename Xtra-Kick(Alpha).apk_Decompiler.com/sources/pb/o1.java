package pb;

import dc.f0;
import dc.k;
import dc.n;
import dc.r;
import java.io.File;
import java.io.FileDescriptor;
import xa.j;

public abstract class o1 {
    public static final n1 Companion = new n1(0);

    public static final o1 create(n nVar, x0 x0Var) {
        Companion.getClass();
        j.f("<this>", nVar);
        return new k1(x0Var, nVar, 2);
    }

    public static final o1 gzip(o1 o1Var) {
        Companion.getClass();
        j.f("<this>", o1Var);
        return new m1(o1Var);
    }

    public long contentLength() {
        return -1;
    }

    public abstract x0 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(k kVar);

    public static final o1 create(f0 f0Var, r rVar, x0 x0Var) {
        Companion.getClass();
        j.f("<this>", f0Var);
        j.f("fileSystem", rVar);
        return new l1(f0Var, rVar, x0Var);
    }

    public static final o1 create(File file, x0 x0Var) {
        Companion.getClass();
        j.f("<this>", file);
        return new k1(x0Var, file, 0);
    }

    public static final o1 create(FileDescriptor fileDescriptor, x0 x0Var) {
        Companion.getClass();
        j.f("<this>", fileDescriptor);
        return new k1(x0Var, fileDescriptor, 1);
    }

    public static final o1 create(String str, x0 x0Var) {
        Companion.getClass();
        return n1.a(str, x0Var);
    }

    public static final o1 create(x0 x0Var, n nVar) {
        Companion.getClass();
        j.f("content", nVar);
        return new k1(x0Var, nVar, 2);
    }

    public static final o1 create(x0 x0Var, File file) {
        Companion.getClass();
        j.f("file", file);
        return new k1(x0Var, file, 0);
    }

    public static final o1 create(x0 x0Var, String str) {
        Companion.getClass();
        j.f("content", str);
        return n1.a(str, x0Var);
    }

    public static final o1 create(x0 x0Var, byte[] bArr) {
        Companion.getClass();
        j.f("content", bArr);
        return n1.b(bArr, x0Var, 0, bArr.length);
    }

    public static final o1 create(x0 x0Var, byte[] bArr, int i10) {
        Companion.getClass();
        j.f("content", bArr);
        return n1.b(bArr, x0Var, i10, bArr.length);
    }

    public static final o1 create(x0 x0Var, byte[] bArr, int i10, int i11) {
        Companion.getClass();
        j.f("content", bArr);
        return n1.b(bArr, x0Var, i10, i11);
    }

    public static final o1 create(byte[] bArr) {
        n1 n1Var = Companion;
        n1Var.getClass();
        j.f("<this>", bArr);
        return n1.c(n1Var, bArr, (x0) null, 0, 7);
    }

    public static final o1 create(byte[] bArr, x0 x0Var) {
        n1 n1Var = Companion;
        n1Var.getClass();
        j.f("<this>", bArr);
        return n1.c(n1Var, bArr, x0Var, 0, 6);
    }

    public static final o1 create(byte[] bArr, x0 x0Var, int i10) {
        n1 n1Var = Companion;
        n1Var.getClass();
        j.f("<this>", bArr);
        return n1.c(n1Var, bArr, x0Var, i10, 4);
    }

    public static final o1 create(byte[] bArr, x0 x0Var, int i10, int i11) {
        Companion.getClass();
        return n1.b(bArr, x0Var, i10, i11);
    }
}
