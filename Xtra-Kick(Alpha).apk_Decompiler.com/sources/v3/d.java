package v3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import java.util.List;
import u3.b;
import u3.c;
import u3.f;
import u3.n;
import u3.o;
import xa.j;

public final class d implements f {

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f15902i = new String[0];

    /* renamed from: h  reason: collision with root package name */
    public final SQLiteDatabase f15903h;

    static {
        new b(0);
    }

    public d(SQLiteDatabase sQLiteDatabase) {
        j.f("delegate", sQLiteDatabase);
        this.f15903h = sQLiteDatabase;
    }

    public final Cursor C0(String str) {
        j.f("query", str);
        return T(new b(str));
    }

    public final Cursor T(n nVar) {
        j.f("query", nVar);
        Cursor rawQueryWithFactory = this.f15903h.rawQueryWithFactory(new a(1, new c(nVar)), nVar.c(), f15902i, (String) null);
        j.e("delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)", rawQueryWithFactory);
        return rawQueryWithFactory;
    }

    public final boolean U() {
        return this.f15903h.inTransaction();
    }

    public final List c() {
        return this.f15903h.getAttachedDbs();
    }

    public final boolean c0() {
        int i10 = c.f15348a;
        SQLiteDatabase sQLiteDatabase = this.f15903h;
        j.f("sQLiteDatabase", sQLiteDatabase);
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public final void close() {
        this.f15903h.close();
    }

    public final String e() {
        return this.f15903h.getPath();
    }

    public final void g() {
        this.f15903h.endTransaction();
    }

    public final void h() {
        this.f15903h.beginTransaction();
    }

    public final void h0() {
        this.f15903h.setTransactionSuccessful();
    }

    public final boolean isOpen() {
        return this.f15903h.isOpen();
    }

    public final void l0(String str, Object[] objArr) {
        j.f("sql", str);
        j.f("bindArgs", objArr);
        this.f15903h.execSQL(str, objArr);
    }

    public final void n0() {
        this.f15903h.beginTransactionNonExclusive();
    }

    public final void o(int i10) {
        this.f15903h.setVersion(i10);
    }

    public final void p(String str) {
        j.f("sql", str);
        this.f15903h.execSQL(str);
    }

    public final Cursor t0(n nVar, CancellationSignal cancellationSignal) {
        j.f("query", nVar);
        String c10 = nVar.c();
        j.c(cancellationSignal);
        a aVar = new a(0, nVar);
        int i10 = c.f15348a;
        SQLiteDatabase sQLiteDatabase = this.f15903h;
        j.f("sQLiteDatabase", sQLiteDatabase);
        j.f("sql", c10);
        String[] strArr = f15902i;
        j.f("selectionArgs", strArr);
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(aVar, c10, strArr, (String) null, cancellationSignal);
        j.e("sQLiteDatabase.rawQueryW…ationSignal\n            )", rawQueryWithFactory);
        return rawQueryWithFactory;
    }

    public final o y(String str) {
        j.f("sql", str);
        SQLiteStatement compileStatement = this.f15903h.compileStatement(str);
        j.e("delegate.compileStatement(sql)", compileStatement);
        return new m(compileStatement);
    }
}
