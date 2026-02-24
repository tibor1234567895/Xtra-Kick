package lb;

import android.support.v4.media.h;
import fb.o;
import fb.w;
import fb.y;
import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kb.j;
import ma.r;
import ma.s;
import ma.z;
import n3.u0;
import pa.e;
import pa.k;
import pa.l;
import qa.a;
import ra.c;
import ra.d;
import wa.q;

public final class v extends c implements j {

    /* renamed from: h  reason: collision with root package name */
    public final j f9864h;

    /* renamed from: i  reason: collision with root package name */
    public final k f9865i;

    /* renamed from: j  reason: collision with root package name */
    public final int f9866j;

    /* renamed from: k  reason: collision with root package name */
    public k f9867k;

    /* renamed from: l  reason: collision with root package name */
    public e f9868l;

    public v(j jVar, k kVar) {
        super(r.f9859h, l.f12754h);
        this.f9864h = jVar;
        this.f9865i = kVar;
        this.f9866j = ((Number) kVar.j0(0, u.f9863h)).intValue();
    }

    public final Object a(Object obj, e eVar) {
        try {
            Object l10 = l(eVar, obj);
            a aVar = a.COROUTINE_SUSPENDED;
            if (l10 == aVar) {
                h0.m1(eVar);
            }
            return l10 == aVar ? l10 : la.v.f9814a;
        } catch (Throwable th) {
            this.f9867k = new p(eVar.getContext(), th);
            throw th;
        }
    }

    public final d getCallerFrame() {
        e eVar = this.f9868l;
        if (eVar instanceof d) {
            return (d) eVar;
        }
        return null;
    }

    public final k getContext() {
        k kVar = this.f9867k;
        return kVar == null ? l.f12754h : kVar;
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object invokeSuspend(Object obj) {
        Throwable a10 = la.l.a(obj);
        if (a10 != null) {
            this.f9867k = new p(getContext(), a10);
        }
        e eVar = this.f9868l;
        if (eVar != null) {
            eVar.resumeWith(obj);
        }
        return a.COROUTINE_SUSPENDED;
    }

    public final Object l(e eVar, Object obj) {
        Comparable comparable;
        int i10;
        boolean z10;
        k context = eVar.getContext();
        h0.T(context);
        k kVar = this.f9867k;
        if (kVar != context) {
            if (kVar instanceof p) {
                String str = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((p) kVar).f9857h + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                xa.j.f("<this>", str);
                List y10 = y.y(str);
                ArrayList arrayList = new ArrayList();
                for (Object next : y10) {
                    if (!w.h((String) next)) {
                        arrayList.add(next);
                    }
                }
                ArrayList arrayList2 = new ArrayList(s.i(arrayList));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    int length = str2.length();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (!fb.a.b(str2.charAt(i11))) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 == -1) {
                        i11 = str2.length();
                    }
                    arrayList2.add(Integer.valueOf(i11));
                }
                Iterator it2 = arrayList2.iterator();
                if (!it2.hasNext()) {
                    comparable = null;
                } else {
                    comparable = (Comparable) it2.next();
                    while (it2.hasNext()) {
                        Comparable comparable2 = (Comparable) it2.next();
                        if (comparable.compareTo(comparable2) > 0) {
                            comparable = comparable2;
                        }
                    }
                }
                Integer num = (Integer) comparable;
                if (num != null) {
                    i10 = num.intValue();
                } else {
                    i10 = 0;
                }
                int size = (y10.size() * 0) + str.length();
                int d10 = r.d(y10);
                ArrayList arrayList3 = new ArrayList();
                int i12 = 0;
                for (Object next2 : y10) {
                    int i13 = i12 + 1;
                    if (i12 >= 0) {
                        String str3 = (String) next2;
                        if ((i12 == 0 || i12 == d10) && w.h(str3)) {
                            str3 = null;
                        } else {
                            xa.j.f("<this>", str3);
                            if (i10 >= 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                int length2 = str3.length();
                                if (i10 <= length2) {
                                    length2 = i10;
                                }
                                String substring = str3.substring(length2);
                                xa.j.e("this as java.lang.String).substring(startIndex)", substring);
                                String str4 = (String) o.f6015h.invoke(substring);
                                if (str4 != null) {
                                    str3 = str4;
                                }
                            } else {
                                throw new IllegalArgumentException(h.j("Requested character count ", i10, " is less than zero.").toString());
                            }
                        }
                        if (str3 != null) {
                            arrayList3.add(str3);
                        }
                        i12 = i13;
                    } else {
                        r.h();
                        throw null;
                    }
                }
                StringBuilder sb2 = new StringBuilder(size);
                z.w(arrayList3, sb2, Constants.WRITE_NEW_LINE, "", "", -1, "...", (wa.l) null);
                String sb3 = sb2.toString();
                xa.j.e("mapIndexedNotNull { inde…\"\\n\")\n        .toString()", sb3);
                throw new IllegalStateException(sb3.toString());
            } else if (((Number) context.j0(0, new u0(1, this))).intValue() == this.f9866j) {
                this.f9867k = context;
            } else {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f9865i + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
        }
        this.f9868l = eVar;
        q qVar = x.f9870a;
        j jVar = this.f9864h;
        xa.j.d("null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>", jVar);
        Object e10 = qVar.e(jVar, obj, this);
        if (!xa.j.a(e10, a.COROUTINE_SUSPENDED)) {
            this.f9868l = null;
        }
        return e10;
    }

    public final void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
