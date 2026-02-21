package r3;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import xa.j;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f13682a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f13683b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13684c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f13685d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f13686e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f13687f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public Executor f13688g;

    /* renamed from: h  reason: collision with root package name */
    public Executor f13689h;

    /* renamed from: i  reason: collision with root package name */
    public final int f13690i = 1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13691j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f13692k;

    /* renamed from: l  reason: collision with root package name */
    public final long f13693l = -1;

    /* renamed from: m  reason: collision with root package name */
    public final l0 f13694m = new l0();

    /* renamed from: n  reason: collision with root package name */
    public final LinkedHashSet f13695n = new LinkedHashSet();

    /* renamed from: o  reason: collision with root package name */
    public HashSet f13696o;

    public i0(Context context, Class cls, String str) {
        j.f("context", context);
        this.f13682a = context;
        this.f13683b = cls;
        this.f13684c = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x031d A[LOOP:6: B:119:0x02e9->B:133:0x031d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0327 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final r3.n0 a() {
        /*
            r22 = this;
            r0 = r22
            java.util.concurrent.Executor r1 = r0.f13688g
            if (r1 != 0) goto L_0x000f
            java.util.concurrent.Executor r2 = r0.f13689h
            if (r2 != 0) goto L_0x000f
            n.a r1 = n.b.f10893c
            r0.f13689h = r1
            goto L_0x001c
        L_0x000f:
            if (r1 == 0) goto L_0x0018
            java.util.concurrent.Executor r2 = r0.f13689h
            if (r2 != 0) goto L_0x0018
            r0.f13689h = r1
            goto L_0x001e
        L_0x0018:
            if (r1 != 0) goto L_0x001e
            java.util.concurrent.Executor r1 = r0.f13689h
        L_0x001c:
            r0.f13688g = r1
        L_0x001e:
            java.util.HashSet r1 = r0.f13696o
            java.util.LinkedHashSet r13 = r0.f13695n
            r2 = 1
            if (r1 == 0) goto L_0x0055
            java.util.Iterator r1 = r1.iterator()
        L_0x0029:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0055
            java.lang.Object r3 = r1.next()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            boolean r4 = r13.contains(r4)
            r4 = r4 ^ r2
            if (r4 == 0) goto L_0x0045
            goto L_0x0029
        L_0x0045:
            java.lang.String r1 = "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: "
            java.lang.String r1 = android.support.v4.media.h.i(r1, r3)
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x0055:
            v3.k r5 = new v3.k
            r5.<init>()
            long r3 = r0.f13693l
            r6 = 0
            java.lang.String r1 = "Required value was null."
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0080
            java.lang.String r2 = r0.f13684c
            if (r2 == 0) goto L_0x0074
            r3.b r2 = new r3.b
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x0074:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Cannot create auto-closing database for an in-memory database."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0080:
            r3.j r15 = new r3.j
            java.lang.String r4 = r0.f13684c
            r3.l0 r6 = r0.f13694m
            java.util.ArrayList r7 = r0.f13685d
            r16 = 0
            int r3 = r0.f13690i
            if (r3 == 0) goto L_0x040a
            java.lang.String r14 = "context"
            android.content.Context r8 = r0.f13682a
            xa.j.f(r14, r8)
            if (r3 == r2) goto L_0x0099
            r9 = r3
            goto L_0x00b3
        L_0x0099:
            java.lang.String r2 = "activity"
            java.lang.Object r2 = r8.getSystemService(r2)
            java.lang.String r3 = "null cannot be cast to non-null type android.app.ActivityManager"
            xa.j.d(r3, r2)
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2
            int r3 = u3.d.f15349a
            boolean r2 = r2.isLowRamDevice()
            if (r2 != 0) goto L_0x00b1
            r2 = 3
            r9 = 3
            goto L_0x00b3
        L_0x00b1:
            r2 = 2
            r9 = 2
        L_0x00b3:
            java.util.concurrent.Executor r10 = r0.f13688g
            if (r10 == 0) goto L_0x03fd
            java.util.concurrent.Executor r11 = r0.f13689h
            if (r11 == 0) goto L_0x03f0
            boolean r12 = r0.f13691j
            boolean r3 = r0.f13692k
            java.util.ArrayList r2 = r0.f13686e
            r17 = r1
            java.util.ArrayList r1 = r0.f13687f
            r0 = 1
            r18 = r2
            r2 = r15
            r19 = r3
            r3 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r19
            r20 = r14
            r14 = r18
            r21 = r15
            r15 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            java.lang.String r1 = "klass"
            r2 = r22
            java.lang.Class r3 = r2.f13683b
            xa.j.f(r1, r3)
            java.lang.Package r1 = r3.getPackage()
            xa.j.c(r1)
            java.lang.String r1 = r1.getName()
            java.lang.String r4 = r3.getCanonicalName()
            xa.j.c(r4)
            java.lang.String r5 = "fullPackage"
            xa.j.e(r5, r1)
            int r5 = r1.length()
            r6 = 0
            if (r5 != 0) goto L_0x0105
            r5 = 1
            goto L_0x0106
        L_0x0105:
            r5 = 0
        L_0x0106:
            if (r5 == 0) goto L_0x0109
            goto L_0x0117
        L_0x0109:
            int r5 = r1.length()
            int r5 = r5 + r0
            java.lang.String r4 = r4.substring(r5)
            java.lang.String r5 = "this as java.lang.String).substring(startIndex)"
            xa.j.e(r5, r4)
        L_0x0117:
            r5 = 95
            r7 = 46
            java.lang.String r4 = fb.w.j(r4, r7, r5)
            java.lang.String r5 = "_Impl"
            java.lang.String r4 = r4.concat(r5)
            int r5 = r1.length()     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            if (r5 != 0) goto L_0x012d
            r5 = 1
            goto L_0x012e
        L_0x012d:
            r5 = 0
        L_0x012e:
            if (r5 == 0) goto L_0x0132
            r1 = r4
            goto L_0x0144
        L_0x0132:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            r5.append(r1)     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            r5.append(r7)     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            r5.append(r4)     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            java.lang.String r1 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
        L_0x0144:
            java.lang.ClassLoader r5 = r3.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            java.lang.Class r1 = java.lang.Class.forName(r1, r0, r5)     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>"
            xa.j.d(r5, r1)     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x03cb, IllegalAccessException -> 0x03b3, InstantiationException -> 0x039b }
            r3.n0 r1 = (r3.n0) r1
            r1.getClass()
            r3 = r21
            u3.l r4 = r1.f(r3)
            r1.f13721d = r4
            java.util.Set r4 = r1.j()
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0177:
            boolean r7 = r4.hasNext()
            java.util.LinkedHashMap r8 = r1.f13725h
            r9 = -1
            java.util.List r10 = r3.f13712p
            if (r7 == 0) goto L_0x01d9
            java.lang.Object r7 = r4.next()
            java.lang.Class r7 = (java.lang.Class) r7
            int r11 = r10.size()
            int r11 = r11 + r9
            if (r11 < 0) goto L_0x01a9
        L_0x018f:
            int r12 = r11 + -1
            java.lang.Object r13 = r10.get(r11)
            java.lang.Class r13 = r13.getClass()
            boolean r13 = r7.isAssignableFrom(r13)
            if (r13 == 0) goto L_0x01a4
            r5.set(r11)
            r9 = r11
            goto L_0x01a9
        L_0x01a4:
            if (r12 >= 0) goto L_0x01a7
            goto L_0x01a9
        L_0x01a7:
            r11 = r12
            goto L_0x018f
        L_0x01a9:
            if (r9 < 0) goto L_0x01ad
            r11 = 1
            goto L_0x01ae
        L_0x01ad:
            r11 = 0
        L_0x01ae:
            if (r11 == 0) goto L_0x01b8
            java.lang.Object r9 = r10.get(r9)
            r8.put(r7, r9)
            goto L_0x0177
        L_0x01b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "A required auto migration spec ("
            r0.<init>(r1)
            java.lang.String r1 = r7.getCanonicalName()
            r0.append(r1)
            java.lang.String r1 = ") is missing in the database configuration."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x01d9:
            int r4 = r10.size()
            int r4 = r4 + r9
            if (r4 < 0) goto L_0x01f9
        L_0x01e0:
            int r7 = r4 + -1
            boolean r4 = r5.get(r4)
            if (r4 == 0) goto L_0x01ed
            if (r7 >= 0) goto L_0x01eb
            goto L_0x01f9
        L_0x01eb:
            r4 = r7
            goto L_0x01e0
        L_0x01ed:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01f9:
            java.util.List r4 = r1.h(r8)
            java.util.Iterator r4 = r4.iterator()
        L_0x0201:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0243
            java.lang.Object r5 = r4.next()
            r9.a r5 = (r9.a) r5
            int r7 = r5.f13890a
            r3.l0 r8 = r3.f13700d
            java.util.LinkedHashMap r10 = r8.f13713a
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            boolean r11 = r10.containsKey(r11)
            if (r11 == 0) goto L_0x0238
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object r7 = r10.get(r7)
            java.util.Map r7 = (java.util.Map) r7
            if (r7 != 0) goto L_0x022d
            ma.c0 r7 = ma.j0.d()
        L_0x022d:
            int r10 = r5.f13891b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            boolean r7 = r7.containsKey(r10)
            goto L_0x0239
        L_0x0238:
            r7 = 0
        L_0x0239:
            if (r7 != 0) goto L_0x0201
            r9.a[] r7 = new r9.a[r0]
            r7[r6] = r5
            r8.a(r7)
            goto L_0x0201
        L_0x0243:
            u3.l r4 = r1.i()
            java.lang.Class<r3.v0> r5 = r3.v0.class
            java.lang.Object r4 = r3.n0.s(r5, r4)
            r3.v0 r4 = (r3.v0) r4
            if (r4 == 0) goto L_0x0254
            r4.getClass()
        L_0x0254:
            u3.l r4 = r1.i()
            java.lang.Class<r3.e> r5 = r3.e.class
            java.lang.Object r4 = r3.n0.s(r5, r4)
            r3.e r4 = (r3.e) r4
            r3.y r5 = r1.f13722e
            if (r4 != 0) goto L_0x0382
            int r4 = r3.f13703g
            r6 = 3
            if (r4 != r6) goto L_0x026b
            r4 = 1
            goto L_0x026c
        L_0x026b:
            r4 = 0
        L_0x026c:
            u3.l r6 = r1.i()
            r6.setWriteAheadLoggingEnabled(r4)
            java.util.List r4 = r3.f13701e
            r1.f13724g = r4
            java.util.concurrent.Executor r4 = r3.f13704h
            r1.f13719b = r4
            g.s0 r4 = new g.s0
            java.util.concurrent.Executor r6 = r3.f13705i
            r4.<init>(r6, r0)
            r1.f13720c = r4
            boolean r0 = r3.f13702f
            r1.f13723f = r0
            android.content.Intent r13 = r3.f13706j
            if (r13 == 0) goto L_0x02ba
            java.lang.String r12 = r3.f13698b
            if (r12 == 0) goto L_0x02b0
            r5.getClass()
            android.content.Context r11 = r3.f13697a
            r0 = r20
            xa.j.f(r0, r11)
            r3.d0 r0 = new r3.d0
            r3.n0 r4 = r5.f13775a
            java.util.concurrent.Executor r15 = r4.f13719b
            if (r15 == 0) goto L_0x02aa
            r10 = r0
            r14 = r5
            r10.<init>(r11, r12, r13, r14, r15)
            r5.f13787m = r0
            goto L_0x02ba
        L_0x02aa:
            java.lang.String r0 = "internalQueryExecutor"
            xa.j.l(r0)
            throw r16
        L_0x02b0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r17.toString()
            r0.<init>(r1)
            throw r0
        L_0x02ba:
            java.util.Map r0 = r1.k()
            java.util.BitSet r4 = new java.util.BitSet
            r4.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x02cb:
            boolean r5 = r0.hasNext()
            java.util.List r6 = r3.f13711o
            if (r5 == 0) goto L_0x0350
            java.lang.Object r5 = r0.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r7 = r5.getKey()
            java.lang.Class r7 = (java.lang.Class) r7
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x02e9:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x02cb
            java.lang.Object r8 = r5.next()
            java.lang.Class r8 = (java.lang.Class) r8
            int r10 = r6.size()
            int r10 = r10 + r9
            if (r10 < 0) goto L_0x0315
        L_0x02fc:
            int r11 = r10 + -1
            java.lang.Object r12 = r6.get(r10)
            java.lang.Class r12 = r12.getClass()
            boolean r12 = r8.isAssignableFrom(r12)
            if (r12 == 0) goto L_0x0310
            r4.set(r10)
            goto L_0x0316
        L_0x0310:
            if (r11 >= 0) goto L_0x0313
            goto L_0x0315
        L_0x0313:
            r10 = r11
            goto L_0x02fc
        L_0x0315:
            r10 = -1
        L_0x0316:
            if (r10 < 0) goto L_0x031a
            r11 = 1
            goto L_0x031b
        L_0x031a:
            r11 = 0
        L_0x031b:
            if (r11 == 0) goto L_0x0327
            java.util.LinkedHashMap r11 = r1.f13730m
            java.lang.Object r10 = r6.get(r10)
            r11.put(r8, r10)
            goto L_0x02e9
        L_0x0327:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "A required type converter ("
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r1 = ") for "
            r0.append(r1)
            java.lang.String r1 = r7.getCanonicalName()
            r0.append(r1)
            java.lang.String r1 = " is missing in the database configuration."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0350:
            int r0 = r6.size()
            int r0 = r0 + r9
            if (r0 < 0) goto L_0x0381
        L_0x0357:
            int r3 = r0 + -1
            boolean r5 = r4.get(r0)
            if (r5 == 0) goto L_0x0364
            if (r3 >= 0) goto L_0x0362
            goto L_0x0381
        L_0x0362:
            r0 = r3
            goto L_0x0357
        L_0x0364:
            java.lang.Object r0 = r6.get(r0)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected type converter "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder."
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        L_0x0381:
            return r1
        L_0x0382:
            r0 = 0
            r4.getClass()
            r1.f13727j = r0
            r5.getClass()
            java.lang.String r1 = "autoCloser"
            xa.j.f(r1, r0)
            r5.f13780f = r0
            androidx.activity.e r0 = new androidx.activity.e
            r1 = 19
            r0.<init>(r1, r5)
            r0 = 0
            throw r0
        L_0x039b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to create an instance of "
            r1.<init>(r4)
            java.lang.String r3 = r3.getCanonicalName()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03b3:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "Cannot access the constructor "
            r1.<init>(r4)
            java.lang.String r3 = r3.getCanonicalName()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03cb:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "Cannot find implementation for "
            r1.<init>(r5)
            java.lang.String r3 = r3.getCanonicalName()
            r1.append(r3)
            java.lang.String r3 = ". "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = " does not exist"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03f0:
            r2 = r0
            r17 = r1
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r17.toString()
            r0.<init>(r1)
            throw r0
        L_0x03fd:
            r2 = r0
            r17 = r1
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r17.toString()
            r0.<init>(r1)
            throw r0
        L_0x040a:
            r2 = r0
            throw r16
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.i0.a():r3.n0");
    }
}
