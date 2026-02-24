package u3;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import fb.w;
import java.io.File;
import v3.d;
import xa.j;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f15351a;

    static {
        new g(0);
    }

    public h(int i10) {
        this.f15351a = i10;
    }

    public static void a(String str) {
        int i10;
        boolean z10;
        if (!w.g(str, ":memory:")) {
            boolean z11 = true;
            int length = str.length() - 1;
            int i11 = 0;
            boolean z12 = false;
            while (i11 <= length) {
                if (!z12) {
                    i10 = i11;
                } else {
                    i10 = length;
                }
                if (j.h(str.charAt(i10), 32) <= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z12) {
                    if (!z10) {
                        z12 = true;
                    } else {
                        i11++;
                    }
                } else if (!z10) {
                    break;
                } else {
                    length--;
                }
            }
            if (str.subSequence(i11, length + 1).toString().length() != 0) {
                z11 = false;
            }
            if (!z11) {
                Log.w("SupportSQLite", "deleting the database file: ".concat(str));
                try {
                    File file = new File(str);
                    int i12 = c.f15348a;
                    SQLiteDatabase.deleteDatabase(file);
                } catch (Exception e10) {
                    Log.w("SupportSQLite", "delete failed: ", e10);
                }
            }
        }
    }

    public abstract void b(d dVar);

    public abstract void c(d dVar);

    public abstract void d(d dVar, int i10, int i11);

    public abstract void e(d dVar);

    public abstract void f(d dVar, int i10, int i11);
}
