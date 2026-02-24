package j3;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.h;
import fb.l;
import fb.w;
import fb.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import la.e;
import la.f;
import la.o;
import la.v;
import ma.b0;
import ma.q;
import ma.r;
import ma.s;
import ma.z;
import xa.j;

public final class u0 {

    /* renamed from: q  reason: collision with root package name */
    public static final Pattern f8692q = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f8693r = Pattern.compile("\\{(.+?)\\}");

    /* renamed from: a  reason: collision with root package name */
    public final String f8694a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8695b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8696c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f8697d;

    /* renamed from: e  reason: collision with root package name */
    public String f8698e;

    /* renamed from: f  reason: collision with root package name */
    public final o f8699f = f.b(new s0(this, 6));

    /* renamed from: g  reason: collision with root package name */
    public final o f8700g = f.b(new s0(this, 4));

    /* renamed from: h  reason: collision with root package name */
    public final e f8701h = f.a(new s0(this, 7));

    /* renamed from: i  reason: collision with root package name */
    public boolean f8702i;

    /* renamed from: j  reason: collision with root package name */
    public final e f8703j = f.a(new s0(this, 1));

    /* renamed from: k  reason: collision with root package name */
    public final e f8704k = f.a(new s0(this, 0));

    /* renamed from: l  reason: collision with root package name */
    public final e f8705l = f.a(new s0(this, 3));

    /* renamed from: m  reason: collision with root package name */
    public final o f8706m = f.b(new s0(this, 2));

    /* renamed from: n  reason: collision with root package name */
    public String f8707n;

    /* renamed from: o  reason: collision with root package name */
    public final o f8708o = f.b(new s0(this, 5));

    /* renamed from: p  reason: collision with root package name */
    public boolean f8709p;

    static {
        new q0(0);
    }

    public u0(String str, String str2, String str3) {
        List list;
        List list2;
        boolean z10;
        boolean z11;
        this.f8694a = str;
        this.f8695b = str2;
        this.f8696c = str3;
        ArrayList arrayList = new ArrayList();
        this.f8697d = arrayList;
        if (str != null) {
            StringBuilder sb2 = new StringBuilder("^");
            if (!f8692q.matcher(str).find()) {
                sb2.append("http[s]?://");
            }
            Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(str);
            matcher.find();
            String substring = str.substring(0, matcher.start());
            j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
            a(substring, arrayList, sb2);
            if (y.n(sb2, ".*", false) || y.n(sb2, "([^/]+?)", false)) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.f8709p = z11;
            sb2.append("($|(\\?(.)*)|(\\#(.)*))");
            String sb3 = sb2.toString();
            j.e("uriRegex.toString()", sb3);
            this.f8698e = w.k(sb3, ".*", "\\E.*\\Q");
        }
        if (str3 != null) {
            if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                l lVar = new l(Constants.LIST_SEPARATOR);
                y.C(0);
                Matcher matcher2 = lVar.f6013h.matcher(str3);
                if (!matcher2.find()) {
                    list = q.b(str3.toString());
                } else {
                    ArrayList arrayList2 = new ArrayList(10);
                    int i10 = 0;
                    do {
                        arrayList2.add(str3.subSequence(i10, matcher2.start()).toString());
                        i10 = matcher2.end();
                    } while (matcher2.find());
                    arrayList2.add(str3.subSequence(i10, str3.length()).toString());
                    list = arrayList2;
                }
                if (!list.isEmpty()) {
                    ListIterator listIterator = list.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            break;
                        }
                        if (((String) listIterator.previous()).length() == 0) {
                            z10 = true;
                            continue;
                        } else {
                            z10 = false;
                            continue;
                        }
                        if (!z10) {
                            list2 = z.G(list, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                    this.f8707n = w.k("^(" + ((String) list2.get(0)) + "|[*]+)/(" + ((String) list2.get(1)) + "|[*]+)$", "*|[*]", "[\\s\\S]");
                    return;
                }
                list2 = b0.f10801h;
                this.f8707n = w.k("^(" + ((String) list2.get(0)) + "|[*]+)/(" + ((String) list2.get(1)) + "|[*]+)$", "*|[*]", "[\\s\\S]");
                return;
            }
            throw new IllegalArgumentException(h.n("The given mimeType ", str3, " does not match to required \"type/subtype\" format").toString());
        }
    }

    public static void a(String str, List list, StringBuilder sb2) {
        Matcher matcher = f8693r.matcher(str);
        int i10 = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            j.d("null cannot be cast to non-null type kotlin.String", group);
            list.add(group);
            if (matcher.start() > i10) {
                String substring = str.substring(i10, matcher.start());
                j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                sb2.append(Pattern.quote(substring));
            }
            sb2.append("([^/]+?)");
            i10 = matcher.end();
        }
        if (i10 < str.length()) {
            String substring2 = str.substring(i10);
            j.e("this as java.lang.String).substring(startIndex)", substring2);
            sb2.append(Pattern.quote(substring2));
        }
    }

    public static void d(Bundle bundle, String str, String str2, m mVar) {
        if (mVar != null) {
            g2 g2Var = mVar.f8611a;
            g2Var.getClass();
            j.f("key", str);
            g2Var.e(bundle, str, g2Var.c(str2));
            return;
        }
        bundle.putString(str, str2);
    }

    public final boolean b(Matcher matcher, Bundle bundle, Map map) {
        ArrayList arrayList = this.f8697d;
        ArrayList arrayList2 = new ArrayList(s.i(arrayList));
        Iterator it = arrayList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 >= 0) {
                String str = (String) next;
                String decode = Uri.decode(matcher.group(i11));
                m mVar = (m) map.get(str);
                try {
                    j.e("value", decode);
                    d(bundle, str, decode, mVar);
                    arrayList2.add(v.f9814a);
                    i10 = i11;
                } catch (IllegalArgumentException unused) {
                    return false;
                }
            } else {
                r.h();
                throw null;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x013e A[LOOP:0: B:1:0x0014->B:66:0x013e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(android.net.Uri r20, android.os.Bundle r21, java.util.Map r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            la.e r2 = r0.f8701h
            java.lang.Object r2 = r2.getValue()
            java.util.Map r2 = (java.util.Map) r2
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0014:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0144
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.getValue()
            j3.r0 r3 = (j3.r0) r3
            r6 = r20
            java.util.List r5 = r6.getQueryParameters(r5)
            boolean r7 = r0.f8702i
            if (r7 == 0) goto L_0x004a
            java.lang.String r7 = r20.getQuery()
            if (r7 == 0) goto L_0x004a
            java.lang.String r8 = r20.toString()
            boolean r8 = xa.j.a(r7, r8)
            if (r8 != 0) goto L_0x004a
            java.util.List r5 = ma.q.b(r7)
        L_0x004a:
            if (r5 == 0) goto L_0x0134
            java.util.Iterator r5 = r5.iterator()
        L_0x0050:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0134
            java.lang.Object r8 = r5.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = r3.f8672a
            if (r9 == 0) goto L_0x006b
            r11 = 32
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9, r11)
            java.util.regex.Matcher r8 = r9.matcher(r8)
            goto L_0x006c
        L_0x006b:
            r8 = 0
        L_0x006c:
            if (r8 == 0) goto L_0x012d
            boolean r9 = r8.matches()
            if (r9 != 0) goto L_0x0076
            goto L_0x012d
        L_0x0076:
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            java.util.ArrayList r11 = r3.f8673b     // Catch:{ IllegalArgumentException -> 0x0124 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ IllegalArgumentException -> 0x0124 }
            int r13 = ma.s.i(r11)     // Catch:{ IllegalArgumentException -> 0x0124 }
            r12.<init>(r13)     // Catch:{ IllegalArgumentException -> 0x0124 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ IllegalArgumentException -> 0x0124 }
            r13 = 0
        L_0x008b:
            boolean r14 = r11.hasNext()     // Catch:{ IllegalArgumentException -> 0x0124 }
            if (r14 == 0) goto L_0x011c
            java.lang.Object r14 = r11.next()     // Catch:{ IllegalArgumentException -> 0x0124 }
            int r15 = r13 + 1
            if (r13 < 0) goto L_0x0113
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ IllegalArgumentException -> 0x0124 }
            java.lang.String r13 = r8.group(r15)     // Catch:{ IllegalArgumentException -> 0x0124 }
            if (r13 != 0) goto L_0x00a6
            java.lang.String r13 = ""
            goto L_0x00a6
        L_0x00a4:
            goto L_0x0050
        L_0x00a6:
            r4 = r22
            java.lang.Object r17 = r4.get(r14)     // Catch:{ IllegalArgumentException -> 0x00df }
            r7 = r17
            j3.m r7 = (j3.m) r7     // Catch:{ IllegalArgumentException -> 0x00df }
            boolean r17 = r1.containsKey(r14)     // Catch:{ IllegalArgumentException -> 0x00df }
            if (r17 != 0) goto L_0x00ba
            r18 = r2
            r0 = 1
            goto L_0x00e6
        L_0x00ba:
            if (r7 == 0) goto L_0x00e3
            j3.g2 r10 = r7.f8611a     // Catch:{ IllegalArgumentException -> 0x00df }
            java.lang.Object r0 = r10.a(r1, r14)     // Catch:{ IllegalArgumentException -> 0x00df }
            r18 = r2
            java.lang.String r2 = "key"
            xa.j.f(r2, r14)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            boolean r2 = r1.containsKey(r14)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            if (r2 == 0) goto L_0x00d7
            java.lang.Object r0 = r10.d(r13, r0)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            r10.e(r1, r14, r0)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            goto L_0x00e5
        L_0x00d7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x00e1 }
            java.lang.String r2 = "There is no previous value in this bundle."
            r0.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00e1 }
        L_0x00df:
            r18 = r2
        L_0x00e1:
            goto L_0x0127
        L_0x00e3:
            r18 = r2
        L_0x00e5:
            r0 = 0
        L_0x00e6:
            if (r0 == 0) goto L_0x0107
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x00e1 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x00e1 }
            r2 = 123(0x7b, float:1.72E-43)
            r0.append(r2)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            r0.append(r14)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            r2 = 125(0x7d, float:1.75E-43)
            r0.append(r2)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            java.lang.String r0 = r0.toString()     // Catch:{ IllegalArgumentException -> 0x00e1 }
            boolean r0 = xa.j.a(r13, r0)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            if (r0 != 0) goto L_0x0107
            d(r9, r14, r13, r7)     // Catch:{ IllegalArgumentException -> 0x00e1 }
        L_0x0107:
            la.v r0 = la.v.f9814a     // Catch:{ IllegalArgumentException -> 0x00e1 }
            r12.add(r0)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            r0 = r19
            r13 = r15
            r2 = r18
            goto L_0x008b
        L_0x0113:
            r4 = r22
            r18 = r2
            ma.r.h()     // Catch:{ IllegalArgumentException -> 0x00e1 }
            r0 = 0
            throw r0     // Catch:{ IllegalArgumentException -> 0x00e1 }
        L_0x011c:
            r4 = r22
            r18 = r2
            r1.putAll(r9)     // Catch:{ IllegalArgumentException -> 0x00e1 }
            goto L_0x0127
        L_0x0124:
            r4 = r22
            goto L_0x00df
        L_0x0127:
            r0 = r19
            r2 = r18
            goto L_0x0050
        L_0x012d:
            r4 = r22
            r18 = r2
            r16 = 0
            goto L_0x013a
        L_0x0134:
            r4 = r22
            r18 = r2
            r16 = 1
        L_0x013a:
            if (r16 != 0) goto L_0x013e
            r0 = 0
            return r0
        L_0x013e:
            r0 = r19
            r2 = r18
            goto L_0x0014
        L_0x0144:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.u0.c(android.net.Uri, android.os.Bundle, java.util.Map):boolean");
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return j.a(this.f8694a, u0Var.f8694a) && j.a(this.f8695b, u0Var.f8695b) && j.a(this.f8696c, u0Var.f8696c);
    }

    public final int hashCode() {
        int i10 = 0;
        String str = this.f8694a;
        int hashCode = ((str != null ? str.hashCode() : 0) + 0) * 31;
        String str2 = this.f8695b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8696c;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode2 + i10;
    }
}
