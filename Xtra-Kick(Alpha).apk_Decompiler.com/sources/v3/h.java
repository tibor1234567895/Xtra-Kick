package v3;

import android.database.sqlite.SQLiteDatabase;
import com.google.gson.internal.bind.l;
import xa.j;

public final class h {
    private h() {
    }

    public /* synthetic */ h(int i10) {
        this();
    }

    public static d a(l lVar, SQLiteDatabase sQLiteDatabase) {
        j.f("refHolder", lVar);
        j.f("sqLiteDatabase", sQLiteDatabase);
        d dVar = (d) lVar.f4038a;
        if (dVar != null && j.a(dVar.f15903h, sQLiteDatabase)) {
            return dVar;
        }
        d dVar2 = new d(sQLiteDatabase);
        lVar.f4038a = dVar2;
        return dVar2;
    }
}
