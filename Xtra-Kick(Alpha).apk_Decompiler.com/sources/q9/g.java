package q9;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v4.media.h;
import androidx.appcompat.widget.j3;
import androidx.fragment.app.k;
import androidx.fragment.app.y;
import com.tonyodev.fetch2.database.DownloadDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import la.i;
import la.v;
import ma.q;
import p9.s;
import r3.h0;
import r3.i0;
import r3.n0;
import r3.s0;
import r9.a;
import t9.o;
import t9.x;
import u3.f;
import xa.j;
import y9.b;
import y9.l;

public final class g implements f {

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f13452h;

    /* renamed from: i  reason: collision with root package name */
    public o f13453i;

    /* renamed from: j  reason: collision with root package name */
    public final DownloadDatabase f13454j;

    /* renamed from: k  reason: collision with root package name */
    public final f f13455k;

    /* renamed from: l  reason: collision with root package name */
    public final String f13456l;

    /* renamed from: m  reason: collision with root package name */
    public final String f13457m;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f13458n;

    /* renamed from: o  reason: collision with root package name */
    public final String f13459o;

    /* renamed from: p  reason: collision with root package name */
    public final l f13460p;

    /* renamed from: q  reason: collision with root package name */
    public final x f13461q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f13462r;

    /* renamed from: s  reason: collision with root package name */
    public final b f13463s;

    public g(Context context, String str, l lVar, a[] aVarArr, x xVar, boolean z10, b bVar) {
        j.g("context", context);
        j.g("namespace", str);
        j.g("logger", lVar);
        this.f13459o = str;
        this.f13460p = lVar;
        this.f13461q = xVar;
        this.f13462r = z10;
        this.f13463s = bVar;
        i0 a10 = h0.a(context, DownloadDatabase.class, str.concat(".db"));
        a[] aVarArr2 = (a[]) Arrays.copyOf(aVarArr, aVarArr.length);
        j.f("migrations", aVarArr2);
        if (a10.f13696o == null) {
            a10.f13696o = new HashSet();
        }
        for (a aVar : aVarArr2) {
            HashSet hashSet = a10.f13696o;
            j.c(hashSet);
            hashSet.add(Integer.valueOf(aVar.f13890a));
            HashSet hashSet2 = a10.f13696o;
            j.c(hashSet2);
            hashSet2.add(Integer.valueOf(aVar.f13891b));
        }
        a10.f13694m.a((a[]) Arrays.copyOf(aVarArr2, aVarArr2.length));
        DownloadDatabase downloadDatabase = (DownloadDatabase) a10.a();
        this.f13454j = downloadDatabase;
        f x02 = downloadDatabase.i().x0();
        j.b("requestDatabase.openHelper.writableDatabase", x02);
        this.f13455k = x02;
        p9.x xVar2 = p9.x.NONE;
        this.f13456l = "SELECT _id FROM requests WHERE _status = '1' OR _status = '2'";
        this.f13457m = "SELECT _id FROM requests WHERE _status = '1' OR _status = '2' OR _status = '9'";
        this.f13458n = new ArrayList();
    }

    public final long B0(boolean z10) {
        String str;
        if (z10) {
            try {
                str = this.f13457m;
            } catch (Exception unused) {
                return -1;
            }
        } else {
            str = this.f13456l;
        }
        Cursor C0 = this.f13455k.C0(str);
        long count = C0 != null ? (long) C0.getCount() : -1;
        if (C0 != null) {
            C0.close();
        }
        return count;
    }

    public final List G(int i10) {
        s0 s0Var;
        int c02;
        boolean z10;
        e();
        j3 t10 = this.f13454j.t();
        t10.getClass();
        s0 k10 = s0.k(1, "SELECT * FROM requests WHERE _group = ?");
        k10.g0(1, (long) i10);
        n0 n0Var = (n0) t10.f894a;
        n0Var.b();
        Cursor n12 = hb.h0.n1(n0Var, k10);
        try {
            int c03 = hb.h0.c0(n12, "_id");
            int c04 = hb.h0.c0(n12, "_namespace");
            int c05 = hb.h0.c0(n12, "_url");
            int c06 = hb.h0.c0(n12, "_file");
            int c07 = hb.h0.c0(n12, "_group");
            int c08 = hb.h0.c0(n12, "_priority");
            int c09 = hb.h0.c0(n12, "_headers");
            int c010 = hb.h0.c0(n12, "_written_bytes");
            int c011 = hb.h0.c0(n12, "_total_bytes");
            int c012 = hb.h0.c0(n12, "_status");
            int c013 = hb.h0.c0(n12, "_error");
            int c014 = hb.h0.c0(n12, "_network_type");
            try {
                c02 = hb.h0.c0(n12, "_created");
                s0Var = k10;
            } catch (Throwable th) {
                th = th;
                s0Var = k10;
                n12.close();
                s0Var.v();
                throw th;
            }
            try {
                int c015 = hb.h0.c0(n12, "_tag");
                int c016 = hb.h0.c0(n12, "_enqueue_action");
                int c017 = hb.h0.c0(n12, "_identifier");
                int c018 = hb.h0.c0(n12, "_download_on_enqueue");
                int c019 = hb.h0.c0(n12, "_extras");
                int c020 = hb.h0.c0(n12, "_auto_retry_max_attempts");
                int c021 = hb.h0.c0(n12, "_auto_retry_attempts");
                int i11 = c02;
                ArrayList arrayList = new ArrayList(n12.getCount());
                while (true) {
                    ArrayList arrayList2 = arrayList;
                    if (n12.moveToNext()) {
                        e eVar = new e();
                        eVar.f13433h = n12.getInt(c03);
                        eVar.H(n12.getString(c04));
                        eVar.M(n12.getString(c05));
                        eVar.G(n12.getString(c06));
                        eVar.f13437l = n12.getInt(c07);
                        int i12 = n12.getInt(c08);
                        int i13 = c03;
                        ((a) t10.f896c).getClass();
                        eVar.J(a.g(i12));
                        String string = n12.getString(c09);
                        ((a) t10.f896c).getClass();
                        eVar.f13439n = a.e(string);
                        int i14 = c04;
                        eVar.f13440o = n12.getLong(c010);
                        eVar.f13441p = n12.getLong(c011);
                        int i15 = n12.getInt(c012);
                        ((a) t10.f896c).getClass();
                        eVar.K(a.h(i15));
                        int i16 = n12.getInt(c013);
                        ((a) t10.f896c).getClass();
                        eVar.D(a.b(i16));
                        int i17 = n12.getInt(c014);
                        ((a) t10.f896c).getClass();
                        eVar.I(a.f(i17));
                        int i18 = c014;
                        int i19 = i11;
                        int i20 = i14;
                        eVar.f13445t = n12.getLong(i19);
                        int i21 = c015;
                        eVar.f13446u = n12.getString(i21);
                        int i22 = c016;
                        int i23 = n12.getInt(i22);
                        c015 = i21;
                        ((a) t10.f896c).getClass();
                        eVar.C(a.a(i23));
                        int i24 = i19;
                        int i25 = c017;
                        int i26 = i18;
                        eVar.f13448w = n12.getLong(i25);
                        int i27 = c018;
                        if (n12.getInt(i27) != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        eVar.f13449x = z10;
                        int i28 = c019;
                        String string2 = n12.getString(i28);
                        int i29 = i25;
                        ((a) t10.f896c).getClass();
                        eVar.F(a.c(string2));
                        j3 j3Var = t10;
                        int i30 = c020;
                        eVar.f13451z = n12.getInt(i30);
                        c020 = i30;
                        int i31 = c021;
                        eVar.A = n12.getInt(i31);
                        ArrayList arrayList3 = arrayList2;
                        arrayList3.add(eVar);
                        c021 = i31;
                        t10 = j3Var;
                        c018 = i27;
                        c03 = i13;
                        int i32 = i22;
                        arrayList = arrayList3;
                        c014 = i26;
                        c017 = i29;
                        c019 = i28;
                        c04 = i20;
                        i11 = i24;
                        c016 = i32;
                    } else {
                        ArrayList arrayList4 = arrayList2;
                        n12.close();
                        s0Var.v();
                        c(false, arrayList4);
                        return arrayList4;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                n12.close();
                s0Var.v();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            s0Var = k10;
            n12.close();
            s0Var.v();
            throw th;
        }
    }

    public final void I(e eVar) {
        j.g("downloadInfo", eVar);
        e();
        j3 t10 = this.f13454j.t();
        Object obj = t10.f894a;
        n0 n0Var = (n0) obj;
        n0Var.b();
        n0Var.c();
        try {
            ((r3.l) t10.f898e).i(eVar);
            ((n0) obj).r();
        } finally {
            n0Var.g();
        }
    }

    public final void J(o oVar) {
        this.f13453i = oVar;
    }

    public final List L0(List list) {
        s0 s0Var;
        int c02;
        boolean z10;
        e();
        j3 t10 = this.f13454j.t();
        t10.getClass();
        StringBuilder sb2 = new StringBuilder("SELECT * FROM requests WHERE _id IN (");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append("?");
            if (i10 < size - 1) {
                sb2.append(",");
            }
        }
        sb2.append(")");
        s0 k10 = s0.k(size + 0, sb2.toString());
        Iterator it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num == null) {
                k10.F(i11);
            } else {
                k10.g0(i11, (long) num.intValue());
            }
            i11++;
        }
        n0 n0Var = (n0) t10.f894a;
        n0Var.b();
        Cursor n12 = hb.h0.n1(n0Var, k10);
        try {
            int c03 = hb.h0.c0(n12, "_id");
            int c04 = hb.h0.c0(n12, "_namespace");
            int c05 = hb.h0.c0(n12, "_url");
            int c06 = hb.h0.c0(n12, "_file");
            int c07 = hb.h0.c0(n12, "_group");
            int c08 = hb.h0.c0(n12, "_priority");
            int c09 = hb.h0.c0(n12, "_headers");
            int c010 = hb.h0.c0(n12, "_written_bytes");
            int c011 = hb.h0.c0(n12, "_total_bytes");
            int c012 = hb.h0.c0(n12, "_status");
            int c013 = hb.h0.c0(n12, "_error");
            int c014 = hb.h0.c0(n12, "_network_type");
            try {
                c02 = hb.h0.c0(n12, "_created");
                s0Var = k10;
            } catch (Throwable th) {
                th = th;
                s0Var = k10;
                n12.close();
                s0Var.v();
                throw th;
            }
            try {
                int c015 = hb.h0.c0(n12, "_tag");
                int c016 = hb.h0.c0(n12, "_enqueue_action");
                int c017 = hb.h0.c0(n12, "_identifier");
                int c018 = hb.h0.c0(n12, "_download_on_enqueue");
                int c019 = hb.h0.c0(n12, "_extras");
                int c020 = hb.h0.c0(n12, "_auto_retry_max_attempts");
                int c021 = hb.h0.c0(n12, "_auto_retry_attempts");
                int i12 = c02;
                ArrayList arrayList = new ArrayList(n12.getCount());
                while (n12.moveToNext()) {
                    e eVar = new e();
                    ArrayList arrayList2 = arrayList;
                    eVar.f13433h = n12.getInt(c03);
                    eVar.H(n12.getString(c04));
                    eVar.M(n12.getString(c05));
                    eVar.G(n12.getString(c06));
                    eVar.f13437l = n12.getInt(c07);
                    int i13 = n12.getInt(c08);
                    int i14 = c03;
                    ((a) t10.f896c).getClass();
                    eVar.J(a.g(i13));
                    String string = n12.getString(c09);
                    ((a) t10.f896c).getClass();
                    eVar.f13439n = a.e(string);
                    int i15 = c04;
                    eVar.f13440o = n12.getLong(c010);
                    eVar.f13441p = n12.getLong(c011);
                    int i16 = n12.getInt(c012);
                    ((a) t10.f896c).getClass();
                    eVar.K(a.h(i16));
                    int i17 = n12.getInt(c013);
                    ((a) t10.f896c).getClass();
                    eVar.D(a.b(i17));
                    int i18 = n12.getInt(c014);
                    ((a) t10.f896c).getClass();
                    eVar.I(a.f(i18));
                    int i19 = c013;
                    int i20 = i12;
                    int i21 = c014;
                    eVar.f13445t = n12.getLong(i20);
                    int i22 = c015;
                    eVar.f13446u = n12.getString(i22);
                    int i23 = c016;
                    int i24 = n12.getInt(i23);
                    int i25 = i15;
                    ((a) t10.f896c).getClass();
                    eVar.C(a.a(i24));
                    c015 = i22;
                    int i26 = c017;
                    int i27 = i23;
                    eVar.f13448w = n12.getLong(i26);
                    int i28 = c018;
                    if (n12.getInt(i28) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    eVar.f13449x = z10;
                    int i29 = c019;
                    String string2 = n12.getString(i29);
                    int i30 = i26;
                    ((a) t10.f896c).getClass();
                    eVar.F(a.c(string2));
                    j3 j3Var = t10;
                    int i31 = c020;
                    eVar.f13451z = n12.getInt(i31);
                    c020 = i31;
                    int i32 = c021;
                    eVar.A = n12.getInt(i32);
                    arrayList = arrayList2;
                    arrayList.add(eVar);
                    c021 = i32;
                    t10 = j3Var;
                    c018 = i28;
                    c014 = i21;
                    i12 = i20;
                    c03 = i14;
                    int i33 = i30;
                    c019 = i29;
                    c013 = i19;
                    c04 = i25;
                    c016 = i27;
                    c017 = i33;
                }
                n12.close();
                s0Var.v();
                c(false, arrayList);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                n12.close();
                s0Var.v();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            s0Var = k10;
            n12.close();
            s0Var.v();
            throw th;
        }
    }

    public final e P() {
        return new e();
    }

    public final void V(e eVar) {
        l lVar = this.f13460p;
        f fVar = this.f13455k;
        j.g("downloadInfo", eVar);
        e();
        try {
            fVar.h();
            fVar.l0("UPDATE requests SET _written_bytes = ?, _total_bytes = ?, _status = ? WHERE _id = ?", new Object[]{Long.valueOf(eVar.f13440o), Long.valueOf(eVar.f13441p), Integer.valueOf(eVar.f13442q.f12744h), Integer.valueOf(eVar.f13433h)});
            fVar.h0();
        } catch (SQLiteException e10) {
            lVar.b("DatabaseManager exception", e10);
        }
        try {
            fVar.g();
        } catch (SQLiteException e11) {
            lVar.b("DatabaseManager exception", e11);
        }
    }

    public final boolean c(boolean z10, List list) {
        p9.x xVar;
        ArrayList arrayList = this.f13458n;
        arrayList.clear();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) list.get(i10);
            int ordinal = eVar.f13442q.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal == 4 && eVar.f13441p < 1) {
                            long j10 = eVar.f13440o;
                            if (j10 > 0) {
                                eVar.f13441p = j10;
                                eVar.D(x9.a.f16791d);
                                arrayList.add(eVar);
                            }
                        }
                    }
                } else if (z10) {
                    long j11 = eVar.f13440o;
                    if (j11 > 0) {
                        long j12 = eVar.f13441p;
                        if (j12 > 0 && j11 >= j12) {
                            xVar = p9.x.COMPLETED;
                            eVar.K(xVar);
                            eVar.D(x9.a.f16791d);
                            arrayList.add(eVar);
                        }
                    }
                    xVar = p9.x.QUEUED;
                    eVar.K(xVar);
                    eVar.D(x9.a.f16791d);
                    arrayList.add(eVar);
                }
            }
            if (eVar.f13440o > 0 && this.f13462r) {
                if (!this.f13463s.b(eVar.f13436k)) {
                    eVar.f13440o = 0;
                    eVar.f13441p = -1;
                    eVar.D(x9.a.f16791d);
                    arrayList.add(eVar);
                    o oVar = this.f13453i;
                    if (oVar != null) {
                        oVar.a(eVar);
                    }
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            try {
                p0(arrayList);
            } catch (Exception e10) {
                this.f13460p.b("Failed to update", e10);
            }
        }
        arrayList.clear();
        if (size2 > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r2 = this;
            boolean r0 = r2.f13452h
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            r2.f13452h = r0
            u3.f r0 = r2.f13455k     // Catch:{ Exception -> 0x000d }
            r0.close()     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            com.tonyodev.fetch2.database.DownloadDatabase r0 = r2.f13454j     // Catch:{ Exception -> 0x0012 }
            r0.d()     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            y9.l r0 = r2.f13460p
            java.lang.String r1 = "Database closed"
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.g.close():void");
    }

    public final o d() {
        return this.f13453i;
    }

    public final void e() {
        if (this.f13452h) {
            throw new y(h.p(new StringBuilder(), this.f13459o, " database is closed"));
        }
    }

    public final void f0(List list) {
        j.g("downloadInfoList", list);
        e();
        j3 t10 = this.f13454j.t();
        Object obj = t10.f894a;
        n0 n0Var = (n0) obj;
        n0Var.b();
        n0Var.c();
        try {
            ((r3.l) t10.f897d).j(list);
            ((n0) obj).r();
        } finally {
            n0Var.g();
        }
    }

    public final List get() {
        s0 s0Var;
        int c02;
        boolean z10;
        e();
        j3 t10 = this.f13454j.t();
        t10.getClass();
        s0 k10 = s0.k(0, "SELECT * FROM requests");
        n0 n0Var = (n0) t10.f894a;
        n0Var.b();
        Cursor n12 = hb.h0.n1(n0Var, k10);
        try {
            int c03 = hb.h0.c0(n12, "_id");
            int c04 = hb.h0.c0(n12, "_namespace");
            int c05 = hb.h0.c0(n12, "_url");
            int c06 = hb.h0.c0(n12, "_file");
            int c07 = hb.h0.c0(n12, "_group");
            int c08 = hb.h0.c0(n12, "_priority");
            int c09 = hb.h0.c0(n12, "_headers");
            int c010 = hb.h0.c0(n12, "_written_bytes");
            int c011 = hb.h0.c0(n12, "_total_bytes");
            int c012 = hb.h0.c0(n12, "_status");
            int c013 = hb.h0.c0(n12, "_error");
            int c014 = hb.h0.c0(n12, "_network_type");
            try {
                c02 = hb.h0.c0(n12, "_created");
                s0Var = k10;
            } catch (Throwable th) {
                th = th;
                s0Var = k10;
                n12.close();
                s0Var.v();
                throw th;
            }
            try {
                int c015 = hb.h0.c0(n12, "_tag");
                int c016 = hb.h0.c0(n12, "_enqueue_action");
                int c017 = hb.h0.c0(n12, "_identifier");
                int c018 = hb.h0.c0(n12, "_download_on_enqueue");
                int c019 = hb.h0.c0(n12, "_extras");
                int c020 = hb.h0.c0(n12, "_auto_retry_max_attempts");
                int c021 = hb.h0.c0(n12, "_auto_retry_attempts");
                int i10 = c02;
                ArrayList arrayList = new ArrayList(n12.getCount());
                while (n12.moveToNext()) {
                    e eVar = new e();
                    ArrayList arrayList2 = arrayList;
                    eVar.f13433h = n12.getInt(c03);
                    eVar.H(n12.getString(c04));
                    eVar.M(n12.getString(c05));
                    eVar.G(n12.getString(c06));
                    eVar.f13437l = n12.getInt(c07);
                    int i11 = n12.getInt(c08);
                    int i12 = c03;
                    ((a) t10.f896c).getClass();
                    eVar.J(a.g(i11));
                    String string = n12.getString(c09);
                    ((a) t10.f896c).getClass();
                    eVar.f13439n = a.e(string);
                    int i13 = c04;
                    eVar.f13440o = n12.getLong(c010);
                    eVar.f13441p = n12.getLong(c011);
                    int i14 = n12.getInt(c012);
                    ((a) t10.f896c).getClass();
                    eVar.K(a.h(i14));
                    int i15 = n12.getInt(c013);
                    ((a) t10.f896c).getClass();
                    eVar.D(a.b(i15));
                    int i16 = n12.getInt(c014);
                    ((a) t10.f896c).getClass();
                    eVar.I(a.f(i16));
                    int i17 = c014;
                    int i18 = i10;
                    int i19 = i13;
                    eVar.f13445t = n12.getLong(i18);
                    int i20 = c015;
                    eVar.f13446u = n12.getString(i20);
                    int i21 = c016;
                    int i22 = n12.getInt(i21);
                    int i23 = i20;
                    ((a) t10.f896c).getClass();
                    eVar.C(a.a(i22));
                    int i24 = i18;
                    int i25 = c017;
                    int i26 = i17;
                    eVar.f13448w = n12.getLong(i25);
                    int i27 = c018;
                    if (n12.getInt(i27) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    eVar.f13449x = z10;
                    int i28 = c019;
                    String string2 = n12.getString(i28);
                    int i29 = i25;
                    ((a) t10.f896c).getClass();
                    eVar.F(a.c(string2));
                    j3 j3Var = t10;
                    int i30 = c020;
                    eVar.f13451z = n12.getInt(i30);
                    c020 = i30;
                    int i31 = c021;
                    eVar.A = n12.getInt(i31);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(eVar);
                    c021 = i31;
                    t10 = j3Var;
                    c018 = i27;
                    c03 = i12;
                    int i32 = i21;
                    arrayList = arrayList3;
                    c014 = i26;
                    c017 = i29;
                    c019 = i28;
                    c04 = i19;
                    i10 = i24;
                    c015 = i23;
                    c016 = i32;
                }
                ArrayList arrayList4 = arrayList;
                n12.close();
                s0Var.v();
                c(false, arrayList4);
                return arrayList4;
            } catch (Throwable th2) {
                th = th2;
                n12.close();
                s0Var.v();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            s0Var = k10;
            n12.close();
            s0Var.v();
            throw th;
        }
    }

    public final i i(e eVar) {
        r3.l lVar;
        u3.o c10;
        boolean z10;
        e();
        j3 t10 = this.f13454j.t();
        Object obj = t10.f894a;
        n0 n0Var = (n0) obj;
        n0Var.b();
        n0Var.c();
        try {
            lVar = (r3.l) t10.f895b;
            c10 = lVar.c();
            lVar.h(c10, eVar);
            long A0 = c10.A0();
            lVar.g(c10);
            ((n0) obj).r();
            n0Var.g();
            if (A0 != ((long) -1)) {
                z10 = true;
            } else {
                z10 = false;
            }
            return new i(eVar, Boolean.valueOf(z10));
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }

    public final void j() {
        e();
        x xVar = this.f13461q;
        k kVar = new k(16, this);
        xVar.getClass();
        synchronized (xVar.f14915a) {
            kVar.invoke((Object) xVar);
            v vVar = v.f9814a;
        }
    }

    public final e m0(String str) {
        s0 s0Var;
        int c02;
        e eVar;
        boolean z10;
        String str2 = str;
        j.g("file", str2);
        e();
        j3 t10 = this.f13454j.t();
        t10.getClass();
        s0 k10 = s0.k(1, "SELECT * FROM requests WHERE _file = ?");
        k10.q(1, str2);
        n0 n0Var = (n0) t10.f894a;
        n0Var.b();
        Cursor n12 = hb.h0.n1(n0Var, k10);
        try {
            int c03 = hb.h0.c0(n12, "_id");
            int c04 = hb.h0.c0(n12, "_namespace");
            int c05 = hb.h0.c0(n12, "_url");
            int c06 = hb.h0.c0(n12, "_file");
            int c07 = hb.h0.c0(n12, "_group");
            int c08 = hb.h0.c0(n12, "_priority");
            int c09 = hb.h0.c0(n12, "_headers");
            int c010 = hb.h0.c0(n12, "_written_bytes");
            int c011 = hb.h0.c0(n12, "_total_bytes");
            int c012 = hb.h0.c0(n12, "_status");
            int c013 = hb.h0.c0(n12, "_error");
            int c014 = hb.h0.c0(n12, "_network_type");
            try {
                c02 = hb.h0.c0(n12, "_created");
                s0Var = k10;
            } catch (Throwable th) {
                th = th;
                s0Var = k10;
                n12.close();
                s0Var.v();
                throw th;
            }
            try {
                int c015 = hb.h0.c0(n12, "_tag");
                int c016 = hb.h0.c0(n12, "_enqueue_action");
                int c017 = hb.h0.c0(n12, "_identifier");
                int c018 = hb.h0.c0(n12, "_download_on_enqueue");
                int c019 = hb.h0.c0(n12, "_extras");
                int c020 = hb.h0.c0(n12, "_auto_retry_max_attempts");
                int c021 = hb.h0.c0(n12, "_auto_retry_attempts");
                if (n12.moveToFirst()) {
                    eVar = new e();
                    eVar.f13433h = n12.getInt(c03);
                    eVar.H(n12.getString(c04));
                    eVar.M(n12.getString(c05));
                    eVar.G(n12.getString(c06));
                    eVar.f13437l = n12.getInt(c07);
                    int i10 = n12.getInt(c08);
                    ((a) t10.f896c).getClass();
                    eVar.J(a.g(i10));
                    String string = n12.getString(c09);
                    ((a) t10.f896c).getClass();
                    eVar.f13439n = a.e(string);
                    eVar.f13440o = n12.getLong(c010);
                    eVar.f13441p = n12.getLong(c011);
                    int i11 = n12.getInt(c012);
                    ((a) t10.f896c).getClass();
                    eVar.K(a.h(i11));
                    int i12 = n12.getInt(c013);
                    ((a) t10.f896c).getClass();
                    eVar.D(a.b(i12));
                    int i13 = n12.getInt(c014);
                    ((a) t10.f896c).getClass();
                    eVar.I(a.f(i13));
                    eVar.f13445t = n12.getLong(c02);
                    eVar.f13446u = n12.getString(c015);
                    int i14 = n12.getInt(c016);
                    ((a) t10.f896c).getClass();
                    eVar.C(a.a(i14));
                    eVar.f13448w = n12.getLong(c017);
                    if (n12.getInt(c018) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    eVar.f13449x = z10;
                    String string2 = n12.getString(c019);
                    ((a) t10.f896c).getClass();
                    eVar.F(a.c(string2));
                    eVar.f13451z = n12.getInt(c020);
                    eVar.A = n12.getInt(c021);
                } else {
                    eVar = null;
                }
                n12.close();
                s0Var.v();
                if (eVar != null) {
                    c(false, q.b(eVar));
                }
                return eVar;
            } catch (Throwable th2) {
                th = th2;
                n12.close();
                s0Var.v();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            s0Var = k10;
            n12.close();
            s0Var.v();
            throw th;
        }
    }

    public final void p0(ArrayList arrayList) {
        j.g("downloadInfoList", arrayList);
        e();
        j3 t10 = this.f13454j.t();
        Object obj = t10.f894a;
        n0 n0Var = (n0) obj;
        n0Var.b();
        n0Var.c();
        try {
            ((r3.l) t10.f898e).j(arrayList);
            ((n0) obj).r();
        } finally {
            n0Var.g();
        }
    }

    public final void u(e eVar) {
        e();
        j3 t10 = this.f13454j.t();
        Object obj = t10.f894a;
        n0 n0Var = (n0) obj;
        n0Var.b();
        n0Var.c();
        try {
            ((r3.l) t10.f897d).i(eVar);
            ((n0) obj).r();
        } finally {
            n0Var.g();
        }
    }

    public final List z0(s sVar) {
        g gVar;
        ArrayList arrayList;
        boolean z10;
        s0 s0Var;
        boolean z11;
        s0 s0Var2;
        boolean z12;
        e();
        s sVar2 = s.ASC;
        String str = "_auto_retry_attempts";
        String str2 = "_auto_retry_max_attempts";
        String str3 = "_extras";
        String str4 = "_download_on_enqueue";
        String str5 = "_identifier";
        String str6 = "_enqueue_action";
        String str7 = "_tag";
        DownloadDatabase downloadDatabase = this.f13454j;
        if (sVar == sVar2) {
            j3 t10 = downloadDatabase.t();
            p9.x xVar = p9.x.NONE;
            t10.getClass();
            s0 k10 = s0.k(1, "SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created ASC");
            ((a) t10.f896c).getClass();
            String str8 = "_created";
            String str9 = "_network_type";
            k10.g0(1, (long) 1);
            n0 n0Var = (n0) t10.f894a;
            n0Var.b();
            Cursor n12 = hb.h0.n1(n0Var, k10);
            try {
                int c02 = hb.h0.c0(n12, "_id");
                int c03 = hb.h0.c0(n12, "_namespace");
                int c04 = hb.h0.c0(n12, "_url");
                int c05 = hb.h0.c0(n12, "_file");
                int c06 = hb.h0.c0(n12, "_group");
                int c07 = hb.h0.c0(n12, "_priority");
                int c08 = hb.h0.c0(n12, "_headers");
                int c09 = hb.h0.c0(n12, "_written_bytes");
                int c010 = hb.h0.c0(n12, "_total_bytes");
                int c011 = hb.h0.c0(n12, "_status");
                int c012 = hb.h0.c0(n12, "_error");
                int c013 = hb.h0.c0(n12, str9);
                int c014 = hb.h0.c0(n12, str8);
                s0Var2 = k10;
                try {
                    int c015 = hb.h0.c0(n12, str7);
                    int c016 = hb.h0.c0(n12, str6);
                    int c017 = hb.h0.c0(n12, str5);
                    int c018 = hb.h0.c0(n12, str4);
                    int c019 = hb.h0.c0(n12, str3);
                    int c020 = hb.h0.c0(n12, str2);
                    int c021 = hb.h0.c0(n12, str);
                    int i10 = c014;
                    arrayList = new ArrayList(n12.getCount());
                    while (n12.moveToNext()) {
                        e eVar = new e();
                        ArrayList arrayList2 = arrayList;
                        eVar.f13433h = n12.getInt(c02);
                        eVar.H(n12.getString(c03));
                        eVar.M(n12.getString(c04));
                        eVar.G(n12.getString(c05));
                        eVar.f13437l = n12.getInt(c06);
                        int i11 = n12.getInt(c07);
                        int i12 = c07;
                        ((a) t10.f896c).getClass();
                        eVar.J(a.g(i11));
                        String string = n12.getString(c08);
                        ((a) t10.f896c).getClass();
                        eVar.f13439n = a.e(string);
                        eVar.f13440o = n12.getLong(c09);
                        eVar.f13441p = n12.getLong(c010);
                        int i13 = n12.getInt(c011);
                        ((a) t10.f896c).getClass();
                        eVar.K(a.h(i13));
                        int i14 = n12.getInt(c012);
                        ((a) t10.f896c).getClass();
                        eVar.D(a.b(i14));
                        int i15 = n12.getInt(c013);
                        ((a) t10.f896c).getClass();
                        eVar.I(a.f(i15));
                        int i16 = i10;
                        int i17 = c06;
                        eVar.f13445t = n12.getLong(i16);
                        int i18 = c015;
                        eVar.f13446u = n12.getString(i18);
                        int i19 = c016;
                        int i20 = n12.getInt(i19);
                        int i21 = i16;
                        ((a) t10.f896c).getClass();
                        eVar.C(a.a(i20));
                        c016 = i19;
                        int i22 = c017;
                        int i23 = i18;
                        eVar.f13448w = n12.getLong(i22);
                        int i24 = c018;
                        if (n12.getInt(i24) != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        eVar.f13449x = z12;
                        int i25 = c019;
                        String string2 = n12.getString(i25);
                        int i26 = i22;
                        ((a) t10.f896c).getClass();
                        eVar.F(a.c(string2));
                        int i27 = c020;
                        j3 j3Var = t10;
                        eVar.f13451z = n12.getInt(i27);
                        int i28 = c021;
                        int i29 = i27;
                        eVar.A = n12.getInt(i28);
                        arrayList = arrayList2;
                        arrayList.add(eVar);
                        c019 = i25;
                        c06 = i17;
                        i10 = i21;
                        c015 = i23;
                        c017 = i26;
                        c018 = i24;
                        c07 = i12;
                        int i30 = i29;
                        c021 = i28;
                        t10 = j3Var;
                        c020 = i30;
                    }
                    n12.close();
                    s0Var2.v();
                    gVar = this;
                } catch (Throwable th) {
                    th = th;
                    n12.close();
                    s0Var2.v();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                s0Var2 = k10;
                n12.close();
                s0Var2.v();
                throw th;
            }
        } else {
            String str10 = str6;
            String str11 = str7;
            j3 t11 = downloadDatabase.t();
            p9.x xVar2 = p9.x.NONE;
            t11.getClass();
            String str12 = str10;
            String str13 = "_created";
            s0 k11 = s0.k(1, "SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created DESC");
            ((a) t11.f896c).getClass();
            String str14 = "_network_type";
            k11.g0(1, (long) 1);
            n0 n0Var2 = (n0) t11.f894a;
            n0Var2.b();
            Cursor n13 = hb.h0.n1(n0Var2, k11);
            try {
                int c022 = hb.h0.c0(n13, "_id");
                int c023 = hb.h0.c0(n13, "_namespace");
                int c024 = hb.h0.c0(n13, "_url");
                int c025 = hb.h0.c0(n13, "_file");
                int c026 = hb.h0.c0(n13, "_group");
                int c027 = hb.h0.c0(n13, "_priority");
                int c028 = hb.h0.c0(n13, "_headers");
                int c029 = hb.h0.c0(n13, "_written_bytes");
                int c030 = hb.h0.c0(n13, "_total_bytes");
                int c031 = hb.h0.c0(n13, "_status");
                int c032 = hb.h0.c0(n13, "_error");
                int c033 = hb.h0.c0(n13, str14);
                int c034 = hb.h0.c0(n13, str13);
                s0Var = k11;
                try {
                    int c035 = hb.h0.c0(n13, str7);
                    int c036 = hb.h0.c0(n13, str12);
                    int c037 = hb.h0.c0(n13, str5);
                    int c038 = hb.h0.c0(n13, str4);
                    int c039 = hb.h0.c0(n13, str3);
                    int c040 = hb.h0.c0(n13, str2);
                    int c041 = hb.h0.c0(n13, str);
                    int i31 = c034;
                    ArrayList arrayList3 = new ArrayList(n13.getCount());
                    while (n13.moveToNext()) {
                        e eVar2 = new e();
                        ArrayList arrayList4 = arrayList3;
                        eVar2.f13433h = n13.getInt(c022);
                        eVar2.H(n13.getString(c023));
                        eVar2.M(n13.getString(c024));
                        eVar2.G(n13.getString(c025));
                        eVar2.f13437l = n13.getInt(c026);
                        int i32 = n13.getInt(c027);
                        int i33 = c022;
                        ((a) t11.f896c).getClass();
                        eVar2.J(a.g(i32));
                        String string3 = n13.getString(c028);
                        ((a) t11.f896c).getClass();
                        eVar2.f13439n = a.e(string3);
                        int i34 = c027;
                        int i35 = c026;
                        eVar2.f13440o = n13.getLong(c029);
                        eVar2.f13441p = n13.getLong(c030);
                        int i36 = n13.getInt(c031);
                        ((a) t11.f896c).getClass();
                        eVar2.K(a.h(i36));
                        int i37 = n13.getInt(c032);
                        ((a) t11.f896c).getClass();
                        eVar2.D(a.b(i37));
                        int i38 = n13.getInt(c033);
                        ((a) t11.f896c).getClass();
                        eVar2.I(a.f(i38));
                        int i39 = i31;
                        int i40 = c029;
                        eVar2.f13445t = n13.getLong(i39);
                        int i41 = c035;
                        eVar2.f13446u = n13.getString(i41);
                        int i42 = c036;
                        int i43 = n13.getInt(i42);
                        int i44 = i35;
                        ((a) t11.f896c).getClass();
                        eVar2.C(a.a(i43));
                        int i45 = i41;
                        int i46 = c037;
                        int i47 = i39;
                        eVar2.f13448w = n13.getLong(i46);
                        int i48 = c038;
                        if (n13.getInt(i48) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        eVar2.f13449x = z11;
                        int i49 = c039;
                        String string4 = n13.getString(i49);
                        int i50 = i46;
                        ((a) t11.f896c).getClass();
                        eVar2.F(a.c(string4));
                        int i51 = c040;
                        int i52 = i48;
                        eVar2.f13451z = n13.getInt(i51);
                        int i53 = c041;
                        int i54 = i51;
                        eVar2.A = n13.getInt(i53);
                        ArrayList arrayList5 = arrayList4;
                        arrayList5.add(eVar2);
                        c039 = i49;
                        c026 = i44;
                        c035 = i45;
                        c036 = i42;
                        c029 = i40;
                        i31 = i47;
                        c037 = i50;
                        c038 = i52;
                        c040 = i54;
                        c041 = i53;
                        c027 = i34;
                        arrayList3 = arrayList5;
                        c022 = i33;
                    }
                    n13.close();
                    s0Var.v();
                    gVar = this;
                    arrayList = arrayList3;
                } catch (Throwable th3) {
                    th = th3;
                    n13.close();
                    s0Var.v();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                s0Var = k11;
                n13.close();
                s0Var.v();
                throw th;
            }
        }
        if (!gVar.c(false, arrayList)) {
            return arrayList;
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object next : arrayList) {
            if (((e) next).f13442q == p9.x.QUEUED) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                arrayList6.add(next);
            }
        }
        return arrayList6;
    }
}
