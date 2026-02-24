package v3;

import android.database.sqlite.SQLiteStatement;
import u3.o;

public final class m extends l implements o {

    /* renamed from: i  reason: collision with root package name */
    public final SQLiteStatement f15924i;

    public m(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f15924i = sQLiteStatement;
    }

    public final long A0() {
        return this.f15924i.executeInsert();
    }

    public final int x() {
        return this.f15924i.executeUpdateDelete();
    }
}
