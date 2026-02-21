package v3;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import u3.n;
import wa.r;
import xa.j;

public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f15899a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f15900b;

    public /* synthetic */ a(int i10, Object obj) {
        this.f15899a = i10;
        this.f15900b = obj;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        int i10 = this.f15899a;
        Object obj = this.f15900b;
        switch (i10) {
            case 0:
                n nVar = (n) obj;
                j.f("$query", nVar);
                j.c(sQLiteQuery);
                nVar.e(new l(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            default:
                r rVar = (r) obj;
                j.f("$tmp0", rVar);
                return (Cursor) rVar.k(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
        }
    }
}
