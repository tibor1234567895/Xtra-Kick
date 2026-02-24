package ec;

import cc.g;
import dc.e0;
import dc.f0;
import dc.i0;
import dc.r;
import dc.u0;
import dc.z;
import fb.w;
import fb.y;
import hb.h0;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import la.i;
import la.v;
import tb.o;
import wa.a;
import xa.j;
import xa.k;

public final class e extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5362h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f5363i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i10, Object obj) {
        super(0);
        this.f5362h = i10;
        this.f5363i = obj;
    }

    /* JADX INFO: finally extract failed */
    public final Object b() {
        Iterator<T> it;
        String str;
        i iVar;
        int x10;
        i0 o10;
        Throwable th;
        Throwable th2;
        i iVar2;
        int i10 = this.f5362h;
        Object obj = this.f5363i;
        switch (i10) {
            case 0:
                ClassLoader classLoader = (ClassLoader) obj;
                f.f5364c.getClass();
                j.f("<this>", classLoader);
                Enumeration<URL> resources = classLoader.getResources("");
                j.e("getResources(\"\")", resources);
                ArrayList<T> list = Collections.list(resources);
                j.e("list(this)", list);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it2 = list.iterator();
                while (true) {
                    String str2 = "it";
                    if (it2.hasNext()) {
                        URL url = (URL) it2.next();
                        d dVar = f.f5364c;
                        j.e(str2, url);
                        dVar.getClass();
                        if (!j.a(url.getProtocol(), "file")) {
                            iVar2 = null;
                        } else {
                            iVar2 = new i(r.f4819a, e0.b(f0.f4761i, new File(url.toURI())));
                        }
                        if (iVar2 != null) {
                            arrayList.add(iVar2);
                        }
                    } else {
                        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
                        j.e("getResources(\"META-INF/MANIFEST.MF\")", resources2);
                        ArrayList<T> list2 = Collections.list(resources2);
                        j.e("list(this)", list2);
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<T> it3 = list2.iterator();
                        while (it3.hasNext()) {
                            URL url2 = (URL) it3.next();
                            d dVar2 = f.f5364c;
                            j.e(str2, url2);
                            dVar2.getClass();
                            String url3 = url2.toString();
                            j.e("toString()", url3);
                            if (w.m(url3, "jar:file:", false) && (x10 = y.x(url3, "!", 6)) != -1) {
                                e0 e0Var = f0.f4761i;
                                String substring = url3.substring(4, x10);
                                j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                                f0 b10 = e0.b(e0Var, new File(URI.create(substring)));
                                z zVar = r.f4819a;
                                j.f("fileSystem", zVar);
                                c cVar = c.f5361h;
                                j.f("predicate", cVar);
                                dc.y j10 = zVar.j(b10);
                                try {
                                    long e10 = j10.e() - ((long) 22);
                                    if (e10 >= 0) {
                                        str = str2;
                                        long max = Math.max(e10 - 65536, 0);
                                        while (true) {
                                            o10 = h0.o(j10.k(e10));
                                            if (o10.O() == 101010256) {
                                                short e11 = o10.e() & 65535;
                                                short e12 = o10.e() & 65535;
                                                long e13 = (long) (o10.e() & 65535);
                                                it = it3;
                                                i0 i0Var = o10;
                                                if (e13 == ((long) (o10.e() & 65535)) && e11 == 0 && e12 == 0) {
                                                    o10 = i0Var;
                                                    o10.a(4);
                                                    long O = ((long) o10.O()) & 4294967295L;
                                                    short e14 = o10.e() & 65535;
                                                    a aVar = new a(e14, e13, O);
                                                    o10.k((long) e14);
                                                    o10.close();
                                                    long j11 = e10 - ((long) 20);
                                                    if (j11 > 0) {
                                                        i0 o11 = h0.o(j10.k(j11));
                                                        try {
                                                            if (o11.O() == 117853008) {
                                                                int O2 = o11.O();
                                                                long d02 = o11.d0();
                                                                if (o11.O() == 1 && O2 == 0) {
                                                                    i0 o12 = h0.o(j10.k(d02));
                                                                    try {
                                                                        int O3 = o12.O();
                                                                        if (O3 == 101075792) {
                                                                            o12.a(12);
                                                                            int O4 = o12.O();
                                                                            int O5 = o12.O();
                                                                            long d03 = o12.d0();
                                                                            if (d03 == o12.d0() && O4 == 0 && O5 == 0) {
                                                                                o12.a(8);
                                                                                a aVar2 = new a(e14, d03, o12.d0());
                                                                                v vVar = v.f9814a;
                                                                                h0.A(o12, (Throwable) null);
                                                                                aVar = aVar2;
                                                                            } else {
                                                                                throw new IOException("unsupported zip: spanned");
                                                                            }
                                                                        } else {
                                                                            throw new IOException("bad zip: expected " + h0.q0(101075792) + " but was " + h0.q0(O3));
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        Throwable th4 = th3;
                                                                        h0.A(o12, th2);
                                                                        throw th4;
                                                                    }
                                                                } else {
                                                                    throw new IOException("unsupported zip: spanned");
                                                                }
                                                            }
                                                            v vVar2 = v.f9814a;
                                                            h0.A(o11, (Throwable) null);
                                                        } catch (Throwable th5) {
                                                            Throwable th6 = th5;
                                                            try {
                                                                throw th6;
                                                            } catch (Throwable th7) {
                                                                Throwable th8 = th7;
                                                                h0.A(o11, th6);
                                                                throw th8;
                                                            }
                                                        }
                                                    }
                                                    long j12 = aVar.f5357b;
                                                    ArrayList arrayList3 = new ArrayList();
                                                    i0 o13 = h0.o(j10.k(j12));
                                                    try {
                                                        long j13 = aVar.f5356a;
                                                        long j14 = 0;
                                                        while (j14 < j13) {
                                                            g o14 = h0.o1(o13);
                                                            long j15 = j13;
                                                            if (o14.f5373g < j12) {
                                                                if (((Boolean) cVar.invoke(o14)).booleanValue()) {
                                                                    arrayList3.add(o14);
                                                                }
                                                                j14++;
                                                                j13 = j15;
                                                            } else {
                                                                throw new IOException("bad zip: local file header offset >= central directory offset");
                                                            }
                                                        }
                                                        v vVar3 = v.f9814a;
                                                        h0.A(o13, (Throwable) null);
                                                        u0 u0Var = new u0(b10, zVar, h0.q(arrayList3));
                                                        h0.A(j10, (Throwable) null);
                                                        iVar = new i(u0Var, f.f5365d);
                                                    } catch (Throwable th9) {
                                                        Throwable th10 = th9;
                                                        h0.A(o13, th);
                                                        throw th10;
                                                    }
                                                } else {
                                                    o10 = i0Var;
                                                    throw new IOException("unsupported zip: spanned");
                                                }
                                            } else {
                                                Iterator<T> it4 = it3;
                                                o10.close();
                                                e10--;
                                                if (e10 >= max) {
                                                    it3 = it4;
                                                } else {
                                                    throw new IOException("not a zip: end of central directory signature not found");
                                                }
                                            }
                                        }
                                    } else {
                                        throw new IOException("not a zip: size=" + j10.e());
                                    }
                                } catch (Throwable th11) {
                                    Throwable th12 = th11;
                                    try {
                                        throw th12;
                                    } catch (Throwable th13) {
                                        Throwable th14 = th13;
                                        h0.A(j10, th12);
                                        throw th14;
                                    }
                                }
                            } else {
                                it = it3;
                                str = str2;
                                iVar = null;
                            }
                            if (iVar != null) {
                                arrayList2.add(iVar);
                            }
                            str2 = str;
                            it3 = it;
                        }
                        return ma.z.C(arrayList2, arrayList);
                    }
                }
                break;
            default:
                o oVar = ((g) obj).f3100h;
                j.c(oVar);
                oVar.cancel();
                return v.f9814a;
        }
    }
}
