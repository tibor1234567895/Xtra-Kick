package v3;

import android.database.DatabaseErrorHandler;
import com.google.gson.internal.bind.l;
import u3.h;

public final /* synthetic */ class f implements DatabaseErrorHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f15904a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f15905b;

    public /* synthetic */ f(h hVar, l lVar) {
        this.f15904a = hVar;
        this.f15905b = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
        if (r1 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        r4 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0059, code lost:
        if (r4.hasNext() != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        r1 = ((android.util.Pair) r4.next()).second;
        xa.j.e("p.second", r1);
        u3.h.a((java.lang.String) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        r4 = r4.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0070, code lost:
        if (r4 != null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0072, code lost:
        u3.h.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0049, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0049 A[ExcHandler: all (r2v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
      PHI: (r1v12 java.util.List) = (r1v5 java.util.List), (r1v6 java.util.List), (r1v6 java.util.List) binds: [B:5:0x0044, B:8:0x004b, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCorruption(android.database.sqlite.SQLiteDatabase r4) {
        /*
            r3 = this;
            java.lang.String r0 = "$callback"
            u3.h r1 = r3.f15904a
            xa.j.f(r0, r1)
            java.lang.String r0 = "$dbRef"
            com.google.gson.internal.bind.l r1 = r3.f15905b
            xa.j.f(r0, r1)
            java.lang.String r0 = "dbObj"
            xa.j.e(r0, r4)
            v3.h r0 = v3.i.f15908o
            r0.getClass()
            v3.d r4 = v3.h.a(r1, r4)
            java.lang.String r0 = "p.second"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Corruption reported by sqlite on database: "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r2 = ".path"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SupportSQLite"
            android.util.Log.e(r2, r1)
            boolean r1 = r4.isOpen()
            if (r1 != 0) goto L_0x0043
            java.lang.String r4 = r4.e()
            if (r4 == 0) goto L_0x009d
            goto L_0x009a
        L_0x0043:
            r1 = 0
            java.util.List r1 = r4.c()     // Catch:{ SQLiteException -> 0x004b, all -> 0x0049 }
            goto L_0x004b
        L_0x0049:
            r2 = move-exception
            goto L_0x004f
        L_0x004b:
            r4.close()     // Catch:{ IOException -> 0x0076, all -> 0x0049 }
            goto L_0x0077
        L_0x004f:
            if (r1 == 0) goto L_0x006c
            java.util.Iterator r4 = r1.iterator()
        L_0x0055:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0075
            java.lang.Object r1 = r4.next()
            android.util.Pair r1 = (android.util.Pair) r1
            java.lang.Object r1 = r1.second
            xa.j.e(r0, r1)
            java.lang.String r1 = (java.lang.String) r1
            u3.h.a(r1)
            goto L_0x0055
        L_0x006c:
            java.lang.String r4 = r4.e()
            if (r4 == 0) goto L_0x0075
            u3.h.a(r4)
        L_0x0075:
            throw r2
        L_0x0076:
        L_0x0077:
            if (r1 == 0) goto L_0x0094
            java.util.Iterator r4 = r1.iterator()
        L_0x007d:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x009d
            java.lang.Object r1 = r4.next()
            android.util.Pair r1 = (android.util.Pair) r1
            java.lang.Object r1 = r1.second
            xa.j.e(r0, r1)
            java.lang.String r1 = (java.lang.String) r1
            u3.h.a(r1)
            goto L_0x007d
        L_0x0094:
            java.lang.String r4 = r4.e()
            if (r4 == 0) goto L_0x009d
        L_0x009a:
            u3.h.a(r4)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.f.onCorruption(android.database.sqlite.SQLiteDatabase):void");
    }
}
