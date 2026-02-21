package v3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.gson.internal.bind.l;
import java.util.UUID;
import u3.f;
import u3.h;
import w3.b;
import xa.j;

public final class i extends SQLiteOpenHelper {

    /* renamed from: o  reason: collision with root package name */
    public static final h f15908o = new h(0);

    /* renamed from: h  reason: collision with root package name */
    public final Context f15909h;

    /* renamed from: i  reason: collision with root package name */
    public final l f15910i;

    /* renamed from: j  reason: collision with root package name */
    public final h f15911j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f15912k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f15913l;

    /* renamed from: m  reason: collision with root package name */
    public final b f15914m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f15915n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Context context, String str, l lVar, h hVar, boolean z10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, hVar.f15351a, new f(hVar, lVar));
        j.f("context", context);
        j.f("callback", hVar);
        this.f15909h = context;
        this.f15910i = lVar;
        this.f15911j = hVar;
        this.f15912k = z10;
        if (str == null) {
            str = UUID.randomUUID().toString();
            j.e("randomUUID().toString()", str);
        }
        this.f15914m = new b(str, context.getCacheDir(), false);
    }

    public final f c(boolean z10) {
        b bVar = this.f15914m;
        try {
            bVar.a(!this.f15915n && getDatabaseName() != null);
            this.f15913l = false;
            SQLiteDatabase v10 = v(z10);
            if (this.f15913l) {
                close();
                return c(z10);
            }
            d e10 = e(v10);
            bVar.b();
            return e10;
        } finally {
            bVar.b();
        }
    }

    public final void close() {
        b bVar = this.f15914m;
        try {
            bVar.a(bVar.f16069a);
            super.close();
            this.f15910i.f4038a = null;
            this.f15915n = false;
        } finally {
            bVar.b();
        }
    }

    public final d e(SQLiteDatabase sQLiteDatabase) {
        j.f("sqLiteDatabase", sQLiteDatabase);
        f15908o.getClass();
        return h.a(this.f15910i, sQLiteDatabase);
    }

    public final SQLiteDatabase k(boolean z10) {
        SQLiteDatabase writableDatabase = z10 ? getWritableDatabase() : getReadableDatabase();
        j.e("{\n                super.…eDatabase()\n            }", writableDatabase);
        return writableDatabase;
    }

    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        j.f("db", sQLiteDatabase);
        boolean z10 = this.f15913l;
        h hVar = this.f15911j;
        if (!z10 && hVar.f15351a != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            hVar.b(e(sQLiteDatabase));
        } catch (Throwable th) {
            throw new g(1, th);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        j.f("sqLiteDatabase", sQLiteDatabase);
        try {
            this.f15911j.c(e(sQLiteDatabase));
        } catch (Throwable th) {
            throw new g(2, th);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        j.f("db", sQLiteDatabase);
        this.f15913l = true;
        try {
            this.f15911j.d(e(sQLiteDatabase), i10, i11);
        } catch (Throwable th) {
            throw new g(4, th);
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        j.f("db", sQLiteDatabase);
        if (!this.f15913l) {
            try {
                this.f15911j.e(e(sQLiteDatabase));
            } catch (Throwable th) {
                throw new g(5, th);
            }
        }
        this.f15915n = true;
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        j.f("sqLiteDatabase", sQLiteDatabase);
        this.f15913l = true;
        try {
            this.f15911j.f(e(sQLiteDatabase), i10, i11);
        } catch (Throwable th) {
            throw new g(3, th);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:12|11|13|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.database.sqlite.SQLiteDatabase v(boolean r6) {
        /*
            r5 = this;
            java.lang.String r0 = r5.getDatabaseName()
            boolean r1 = r5.f15915n
            android.content.Context r2 = r5.f15909h
            if (r0 == 0) goto L_0x0032
            if (r1 != 0) goto L_0x0032
            java.io.File r1 = r2.getDatabasePath(r0)
            java.io.File r1 = r1.getParentFile()
            if (r1 == 0) goto L_0x0032
            r1.mkdirs()
            boolean r3 = r1.isDirectory()
            if (r3 != 0) goto L_0x0032
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid database parent file, not a directory: "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "SupportSQLite"
            android.util.Log.w(r3, r1)
        L_0x0032:
            android.database.sqlite.SQLiteDatabase r6 = r5.k(r6)     // Catch:{ all -> 0x0037 }
            return r6
        L_0x0037:
            super.close()
            r3 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x003f }
        L_0x003f:
            android.database.sqlite.SQLiteDatabase r6 = r5.k(r6)     // Catch:{ all -> 0x0044 }
            return r6
        L_0x0044:
            r1 = move-exception
            super.close()
            boolean r3 = r1 instanceof v3.g
            if (r3 == 0) goto L_0x0068
            v3.g r1 = (v3.g) r1
            int r3 = r1.f15906h
            int r3 = s.i.a(r3)
            java.lang.Throwable r1 = r1.f15907i
            if (r3 == 0) goto L_0x0067
            r4 = 1
            if (r3 == r4) goto L_0x0067
            r4 = 2
            if (r3 == r4) goto L_0x0067
            r4 = 3
            if (r3 == r4) goto L_0x0067
            boolean r3 = r1 instanceof android.database.sqlite.SQLiteException
            if (r3 == 0) goto L_0x0066
            goto L_0x0072
        L_0x0066:
            throw r1
        L_0x0067:
            throw r1
        L_0x0068:
            boolean r3 = r1 instanceof android.database.sqlite.SQLiteException
            if (r3 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x007e
            boolean r3 = r5.f15912k
            if (r3 == 0) goto L_0x007e
        L_0x0072:
            r2.deleteDatabase(r0)
            android.database.sqlite.SQLiteDatabase r6 = r5.k(r6)     // Catch:{ g -> 0x007a }
            return r6
        L_0x007a:
            r6 = move-exception
            java.lang.Throwable r6 = r6.f15907i
            throw r6
        L_0x007e:
            throw r1
        L_0x007f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.i.v(boolean):android.database.sqlite.SQLiteDatabase");
    }
}
