package v3;

import android.database.sqlite.SQLiteProgram;
import u3.m;
import xa.j;

public class l implements m {

    /* renamed from: h  reason: collision with root package name */
    public final SQLiteProgram f15923h;

    public l(SQLiteProgram sQLiteProgram) {
        j.f("delegate", sQLiteProgram);
        this.f15923h = sQLiteProgram;
    }

    public final void F(int i10) {
        this.f15923h.bindNull(i10);
    }

    public final void L(int i10, double d10) {
        this.f15923h.bindDouble(i10, d10);
    }

    public final void close() {
        this.f15923h.close();
    }

    public final void g0(int i10, long j10) {
        this.f15923h.bindLong(i10, j10);
    }

    public final void q(int i10, String str) {
        j.f("value", str);
        this.f15923h.bindString(i10, str);
    }

    public final void r0(int i10, byte[] bArr) {
        this.f15923h.bindBlob(i10, bArr);
    }
}
