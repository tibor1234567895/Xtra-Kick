package j9;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.b;
import com.google.gson.internal.bind.g;
import com.google.gson.internal.bind.j;
import com.google.gson.internal.bind.k;
import com.google.gson.internal.bind.s0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import k5.a;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadLocal f8858a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap f8859b;

    /* renamed from: c  reason: collision with root package name */
    public final a f8860c;

    /* renamed from: d  reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f8861d;

    /* renamed from: e  reason: collision with root package name */
    public final List f8862e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8863f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f8864g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f8865h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f8866i;

    static {
        new o9.a(Object.class);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n() {
        /*
            r6 = this;
            com.google.gson.internal.Excluder r1 = com.google.gson.internal.Excluder.f3971m
            j9.b r2 = j9.h.f8852h
            java.util.Map r3 = java.util.Collections.emptyMap()
            j9.y r4 = j9.a0.f8850h
            java.util.Collections.emptyList()
            java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.n.<init>():void");
    }

    public static void a(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final b0 b(o9.a aVar) {
        boolean z10;
        ConcurrentHashMap concurrentHashMap = this.f8859b;
        b0 b0Var = (b0) concurrentHashMap.get(aVar);
        if (b0Var != null) {
            return b0Var;
        }
        ThreadLocal threadLocal = this.f8858a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z10 = true;
        } else {
            z10 = false;
        }
        m mVar = (m) map.get(aVar);
        if (mVar != null) {
            return mVar;
        }
        try {
            m mVar2 = new m();
            map.put(aVar, mVar2);
            for (c0 a10 : this.f8862e) {
                b0 a11 = a10.a(this, aVar);
                if (a11 != null) {
                    if (mVar2.f8857a == null) {
                        mVar2.f8857a = a11;
                        concurrentHashMap.put(aVar, a11);
                        return a11;
                    }
                    throw new AssertionError();
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z10) {
                threadLocal.remove();
            }
        }
    }

    public final b0 c(c0 c0Var, o9.a aVar) {
        List<c0> list = this.f8862e;
        if (!list.contains(c0Var)) {
            c0Var = this.f8861d;
        }
        boolean z10 = false;
        for (c0 c0Var2 : list) {
            if (z10) {
                b0 a10 = c0Var2.a(this, aVar);
                if (a10 != null) {
                    return a10;
                }
            } else if (c0Var2 == c0Var) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public final String toString() {
        return "{serializeNulls:" + this.f8863f + ",factories:" + this.f8862e + ",instanceCreators:" + this.f8860c + "}";
    }

    public n(Excluder excluder, b bVar, Map map, y yVar, List list) {
        this.f8858a = new ThreadLocal();
        this.f8859b = new ConcurrentHashMap();
        a aVar = new a(map);
        this.f8860c = aVar;
        this.f8863f = false;
        this.f8864g = false;
        this.f8865h = false;
        this.f8866i = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(s0.B);
        arrayList.add(g.f4020b);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(s0.f4063p);
        arrayList.add(s0.f4054g);
        arrayList.add(s0.f4051d);
        arrayList.add(s0.f4052e);
        arrayList.add(s0.f4053f);
        b0 kVar = yVar == a0.f8850h ? s0.f4058k : new k();
        arrayList.add(s0.b(Long.TYPE, Long.class, kVar));
        arrayList.add(s0.b(Double.TYPE, Double.class, new j(0)));
        arrayList.add(s0.b(Float.TYPE, Float.class, new j(1)));
        arrayList.add(s0.f4059l);
        arrayList.add(s0.f4055h);
        arrayList.add(s0.f4056i);
        arrayList.add(s0.a(AtomicLong.class, new l(kVar, 0).a()));
        arrayList.add(s0.a(AtomicLongArray.class, new l(kVar, 1).a()));
        arrayList.add(s0.f4057j);
        arrayList.add(s0.f4060m);
        arrayList.add(s0.f4064q);
        arrayList.add(s0.f4065r);
        arrayList.add(s0.a(BigDecimal.class, s0.f4061n));
        arrayList.add(s0.a(BigInteger.class, s0.f4062o));
        arrayList.add(s0.f4066s);
        arrayList.add(s0.f4067t);
        arrayList.add(s0.f4069v);
        arrayList.add(s0.f4070w);
        arrayList.add(s0.f4073z);
        arrayList.add(s0.f4068u);
        arrayList.add(s0.f4049b);
        arrayList.add(b.f4005b);
        arrayList.add(s0.f4072y);
        arrayList.add(k.f4035b);
        arrayList.add(j.f4033b);
        arrayList.add(s0.f4071x);
        arrayList.add(com.google.gson.internal.bind.a.f4002c);
        arrayList.add(s0.f4048a);
        arrayList.add(new CollectionTypeAdapterFactory(aVar));
        arrayList.add(new MapTypeAdapterFactory(aVar));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(aVar);
        this.f8861d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(s0.C);
        arrayList.add(new ReflectiveTypeAdapterFactory(aVar, bVar, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f8862e = Collections.unmodifiableList(arrayList);
    }
}
