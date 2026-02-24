package r3;

import a6.e;
import android.database.sqlite.SQLiteException;
import android.os.RemoteException;
import android.support.v4.media.n;
import android.util.Log;
import androidx.activity.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import la.v;
import ma.j0;
import ma.n0;
import ma.z;
import na.l;
import o.g;
import u3.f;
import u3.o;
import xa.j;

public final class y {

    /* renamed from: q  reason: collision with root package name */
    public static final s f13773q = new s(0);

    /* renamed from: r  reason: collision with root package name */
    public static final String[] f13774r = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    public final n0 f13775a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f13776b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f13777c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashMap f13778d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f13779e;

    /* renamed from: f  reason: collision with root package name */
    public b f13780f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f13781g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f13782h;

    /* renamed from: i  reason: collision with root package name */
    public volatile o f13783i;

    /* renamed from: j  reason: collision with root package name */
    public final u f13784j;

    /* renamed from: k  reason: collision with root package name */
    public final n f13785k;

    /* renamed from: l  reason: collision with root package name */
    public final g f13786l;

    /* renamed from: m  reason: collision with root package name */
    public d0 f13787m;

    /* renamed from: n  reason: collision with root package name */
    public final Object f13788n;

    /* renamed from: o  reason: collision with root package name */
    public final Object f13789o;

    /* renamed from: p  reason: collision with root package name */
    public final h f13790p;

    public y(n0 n0Var, HashMap hashMap, HashMap hashMap2, String... strArr) {
        String str;
        j.f("database", n0Var);
        this.f13775a = n0Var;
        this.f13776b = hashMap;
        this.f13777c = hashMap2;
        this.f13784j = new u(strArr.length);
        this.f13785k = new n(n0Var);
        this.f13786l = new g();
        this.f13788n = new Object();
        this.f13789o = new Object();
        this.f13778d = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str2 = strArr[i10];
            Locale locale = Locale.US;
            j.e("US", locale);
            String lowerCase = str2.toLowerCase(locale);
            j.e("this as java.lang.String).toLowerCase(locale)", lowerCase);
            this.f13778d.put(lowerCase, Integer.valueOf(i10));
            String str3 = (String) this.f13776b.get(strArr[i10]);
            if (str3 != null) {
                str = str3.toLowerCase(locale);
                j.e("this as java.lang.String).toLowerCase(locale)", str);
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i10] = lowerCase;
        }
        this.f13779e = strArr2;
        for (Map.Entry entry : this.f13776b.entrySet()) {
            Locale locale2 = Locale.US;
            j.e("US", locale2);
            String lowerCase2 = ((String) entry.getValue()).toLowerCase(locale2);
            j.e("this as java.lang.String).toLowerCase(locale)", lowerCase2);
            if (this.f13778d.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                j.e("this as java.lang.String).toLowerCase(locale)", lowerCase3);
                LinkedHashMap linkedHashMap = this.f13778d;
                linkedHashMap.put(lowerCase3, j0.e(linkedHashMap, lowerCase2));
            }
        }
        this.f13790p = new h(12, this);
    }

    public final void a(v vVar) {
        w wVar;
        String[] e10 = e(vVar.f13765a);
        ArrayList arrayList = new ArrayList(e10.length);
        int length = e10.length;
        int i10 = 0;
        while (i10 < length) {
            String str = e10[i10];
            LinkedHashMap linkedHashMap = this.f13778d;
            Locale locale = Locale.US;
            j.e("US", locale);
            String lowerCase = str.toLowerCase(locale);
            j.e("this as java.lang.String).toLowerCase(locale)", lowerCase);
            Integer num = (Integer) linkedHashMap.get(lowerCase);
            if (num != null) {
                arrayList.add(Integer.valueOf(num.intValue()));
                i10++;
            } else {
                throw new IllegalArgumentException("There is no table with name ".concat(str));
            }
        }
        int[] I = z.I(arrayList);
        w wVar2 = new w(vVar, I, e10);
        synchronized (this.f13786l) {
            wVar = (w) this.f13786l.b(vVar, wVar2);
        }
        if (wVar == null && this.f13784j.b(Arrays.copyOf(I, I.length))) {
            n0 n0Var = this.f13775a;
            if (n0Var.p()) {
                i(n0Var.i().x0());
            }
        }
    }

    public final u0 b(String[] strArr, e eVar) {
        String[] e10 = e(strArr);
        int length = e10.length;
        int i10 = 0;
        while (i10 < length) {
            String str = e10[i10];
            LinkedHashMap linkedHashMap = this.f13778d;
            Locale locale = Locale.US;
            j.e("US", locale);
            String lowerCase = str.toLowerCase(locale);
            j.e("this as java.lang.String).toLowerCase(locale)", lowerCase);
            if (linkedHashMap.containsKey(lowerCase)) {
                i10++;
            } else {
                throw new IllegalArgumentException("There is no table with name ".concat(str).toString());
            }
        }
        n nVar = this.f13785k;
        nVar.getClass();
        return new u0((n0) nVar.f337i, nVar, eVar, e10);
    }

    public final boolean c() {
        if (!this.f13775a.p()) {
            return false;
        }
        if (!this.f13782h) {
            this.f13775a.i().x0();
        }
        if (this.f13782h) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void d(v vVar) {
        w wVar;
        j.f("observer", vVar);
        synchronized (this.f13786l) {
            wVar = (w) this.f13786l.c(vVar);
        }
        if (wVar != null) {
            u uVar = this.f13784j;
            int[] iArr = wVar.f13767b;
            if (uVar.c(Arrays.copyOf(iArr, iArr.length))) {
                n0 n0Var = this.f13775a;
                if (n0Var.p()) {
                    i(n0Var.i().x0());
                }
            }
        }
    }

    public final String[] e(String[] strArr) {
        l lVar = new l();
        for (String str : strArr) {
            Locale locale = Locale.US;
            j.e("US", locale);
            String lowerCase = str.toLowerCase(locale);
            j.e("this as java.lang.String).toLowerCase(locale)", lowerCase);
            Map map = this.f13777c;
            if (map.containsKey(lowerCase)) {
                String lowerCase2 = str.toLowerCase(locale);
                j.e("this as java.lang.String).toLowerCase(locale)", lowerCase2);
                Object obj = map.get(lowerCase2);
                j.c(obj);
                lVar.addAll((Collection) obj);
            } else {
                lVar.add(str);
            }
        }
        n0.a(lVar);
        return (String[]) lVar.toArray(new String[0]);
    }

    public final void f(f fVar, int i10) {
        fVar.p("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f13779e[i10];
        for (String str2 : f13774r) {
            StringBuilder sb2 = new StringBuilder("CREATE TEMP TRIGGER IF NOT EXISTS ");
            f13773q.getClass();
            sb2.append(s.a(str, str2));
            sb2.append(" AFTER ");
            sb2.append(str2);
            sb2.append(" ON `");
            sb2.append(str);
            sb2.append("` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
            sb2.append(i10);
            sb2.append(" AND invalidated = 0; END");
            String sb3 = sb2.toString();
            j.e("StringBuilder().apply(builderAction).toString()", sb3);
            fVar.p(sb3);
        }
    }

    public final void g() {
        d0 d0Var = this.f13787m;
        if (d0Var != null && d0Var.f13672i.compareAndSet(false, true)) {
            v vVar = d0Var.f13669f;
            if (vVar != null) {
                d0Var.f13665b.d(vVar);
                try {
                    r rVar = d0Var.f13670g;
                    if (rVar != null) {
                        rVar.m0(d0Var.f13671h, d0Var.f13668e);
                    }
                } catch (RemoteException e10) {
                    Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e10);
                }
                d0Var.f13667d.unbindService(d0Var.f13673j);
            } else {
                j.l("observer");
                throw null;
            }
        }
        this.f13787m = null;
    }

    public final void h(f fVar, int i10) {
        String str = this.f13779e[i10];
        for (String a10 : f13774r) {
            StringBuilder sb2 = new StringBuilder("DROP TRIGGER IF EXISTS ");
            f13773q.getClass();
            sb2.append(s.a(str, a10));
            String sb3 = sb2.toString();
            j.e("StringBuilder().apply(builderAction).toString()", sb3);
            fVar.p(sb3);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void i(f fVar) {
        j.f("database", fVar);
        if (!fVar.U()) {
            try {
                ReentrantReadWriteLock.ReadLock readLock = this.f13775a.f13726i.readLock();
                j.e("readWriteLock.readLock()", readLock);
                readLock.lock();
                try {
                    synchronized (this.f13788n) {
                        int[] a10 = this.f13784j.a();
                        if (a10 != null) {
                            f13773q.getClass();
                            if (fVar.c0()) {
                                fVar.n0();
                            } else {
                                fVar.h();
                            }
                            try {
                                int length = a10.length;
                                int i10 = 0;
                                int i11 = 0;
                                while (i10 < length) {
                                    int i12 = a10[i10];
                                    int i13 = i11 + 1;
                                    if (i12 == 1) {
                                        f(fVar, i11);
                                    } else if (i12 == 2) {
                                        h(fVar, i11);
                                    }
                                    i10++;
                                    i11 = i13;
                                }
                                fVar.h0();
                                fVar.g();
                                v vVar = v.f9814a;
                                readLock.unlock();
                            } catch (Throwable th) {
                                fVar.g();
                                throw th;
                            }
                        }
                    }
                } finally {
                    readLock.unlock();
                }
            } catch (SQLiteException | IllegalStateException e10) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
            }
        }
    }
}
