package v3;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import u3.n;
import wa.r;
import xa.j;
import xa.k;

public final class c extends k implements r {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ n f15901h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(n nVar) {
        super(4);
        this.f15901h = nVar;
    }

    public final Object k(Object obj, Object obj2, Object obj3, Object obj4) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        SQLiteQuery sQLiteQuery = (SQLiteQuery) obj4;
        j.c(sQLiteQuery);
        this.f15901h.e(new l(sQLiteQuery));
        return new SQLiteCursor((SQLiteCursorDriver) obj2, (String) obj3, sQLiteQuery);
    }
}
