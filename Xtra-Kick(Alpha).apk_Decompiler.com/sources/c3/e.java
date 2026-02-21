package c3;

import android.text.SpannableStringBuilder;
import android.util.Pair;
import i1.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f2818a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2819b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2820c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2821d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2822e;

    /* renamed from: f  reason: collision with root package name */
    public final h f2823f;

    /* renamed from: g  reason: collision with root package name */
    public final String[] f2824g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2825h;

    /* renamed from: i  reason: collision with root package name */
    public final String f2826i;

    /* renamed from: j  reason: collision with root package name */
    public final e f2827j;

    /* renamed from: k  reason: collision with root package name */
    public final HashMap f2828k;

    /* renamed from: l  reason: collision with root package name */
    public final HashMap f2829l;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList f2830m;

    public e(String str, String str2, long j10, long j11, h hVar, String[] strArr, String str3, String str4, e eVar) {
        boolean z10;
        this.f2818a = str;
        this.f2819b = str2;
        this.f2826i = str4;
        this.f2823f = hVar;
        this.f2824g = strArr;
        if (str2 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f2820c = z10;
        this.f2821d = j10;
        this.f2822e = j11;
        str3.getClass();
        this.f2825h = str3;
        this.f2827j = eVar;
        this.f2828k = new HashMap();
        this.f2829l = new HashMap();
    }

    public static e a(String str) {
        return new e((String) null, str.replaceAll("\r\n", Constants.WRITE_NEW_LINE).replaceAll(" *\n *", Constants.WRITE_NEW_LINE).replaceAll(Constants.WRITE_NEW_LINE, " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, (h) null, (String[]) null, "", (String) null, (e) null);
    }

    public static SpannableStringBuilder e(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            a aVar = new a();
            aVar.f7953a = new SpannableStringBuilder();
            treeMap.put(str, aVar);
        }
        CharSequence charSequence = ((a) treeMap.get(str)).f7953a;
        charSequence.getClass();
        return (SpannableStringBuilder) charSequence;
    }

    public final e b(int i10) {
        ArrayList arrayList = this.f2830m;
        if (arrayList != null) {
            return (e) arrayList.get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int c() {
        ArrayList arrayList = this.f2830m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void d(TreeSet treeSet, boolean z10) {
        String str = this.f2818a;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z10 || equals || (equals2 && this.f2826i != null)) {
            long j10 = this.f2821d;
            if (j10 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j10));
            }
            long j11 = this.f2822e;
            if (j11 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j11));
            }
        }
        if (this.f2830m != null) {
            for (int i10 = 0; i10 < this.f2830m.size(); i10++) {
                ((e) this.f2830m.get(i10)).d(treeSet, z10 || equals);
            }
        }
    }

    public final boolean f(long j10) {
        long j11 = this.f2822e;
        long j12 = this.f2821d;
        return (j12 == -9223372036854775807L && j11 == -9223372036854775807L) || (j12 <= j10 && j11 == -9223372036854775807L) || ((j12 == -9223372036854775807L && j10 < j11) || (j12 <= j10 && j10 < j11));
    }

    public final void g(long j10, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.f2825h;
        if (!"".equals(str3)) {
            str = str3;
        }
        if (!f(j10) || !"div".equals(this.f2818a) || (str2 = this.f2826i) == null) {
            for (int i10 = 0; i10 < c(); i10++) {
                b(i10).g(j10, str, arrayList);
            }
            return;
        }
        arrayList.add(new Pair(str, str2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0023 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(long r18, java.util.Map r20, java.util.Map r21, java.lang.String r22, java.util.TreeMap r23) {
        /*
            r17 = this;
            r0 = r17
            r8 = r20
            boolean r1 = r17.f(r18)
            if (r1 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r1 = ""
            java.lang.String r2 = r0.f2825h
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0018
            r9 = r22
            goto L_0x0019
        L_0x0018:
            r9 = r2
        L_0x0019:
            java.util.HashMap r1 = r0.f2829l
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0023:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0275
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.util.HashMap r5 = r0.f2828k
            boolean r6 = r5.containsKey(r4)
            if (r6 == 0) goto L_0x0048
            java.lang.Object r5 = r5.get(r4)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x0049
        L_0x0048:
            r5 = 0
        L_0x0049:
            java.lang.Object r2 = r2.getValue()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r5 == r2) goto L_0x026f
            r10 = r23
            java.lang.Object r4 = r10.get(r4)
            i1.a r4 = (i1.a) r4
            r4.getClass()
            r11 = r21
            java.lang.Object r6 = r11.get(r9)
            c3.f r6 = (c3.f) r6
            r6.getClass()
            c3.h r7 = r0.f2823f
            java.lang.String[] r12 = r0.f2824g
            c3.h r7 = c3.g.a(r7, r12, r8)
            java.lang.CharSequence r12 = r4.f7953a
            android.text.SpannableStringBuilder r12 = (android.text.SpannableStringBuilder) r12
            if (r12 != 0) goto L_0x0080
            android.text.SpannableStringBuilder r12 = new android.text.SpannableStringBuilder
            r12.<init>()
            r4.f7953a = r12
        L_0x0080:
            if (r7 == 0) goto L_0x0023
            int r13 = r7.f2848h
            r15 = -1
            r3 = 1
            if (r13 != r15) goto L_0x008e
            int r14 = r7.f2849i
            if (r14 != r15) goto L_0x008e
            r13 = -1
            goto L_0x009b
        L_0x008e:
            if (r13 != r3) goto L_0x0092
            r13 = 1
            goto L_0x0093
        L_0x0092:
            r13 = 0
        L_0x0093:
            int r14 = r7.f2849i
            if (r14 != r3) goto L_0x0099
            r14 = 2
            goto L_0x009a
        L_0x0099:
            r14 = 0
        L_0x009a:
            r13 = r13 | r14
        L_0x009b:
            if (r13 == r15) goto L_0x00c0
            android.text.style.StyleSpan r13 = new android.text.style.StyleSpan
            int r14 = r7.f2848h
            if (r14 != r15) goto L_0x00a9
            int r3 = r7.f2849i
            if (r3 != r15) goto L_0x00a8
            goto L_0x00b7
        L_0x00a8:
            r3 = 1
        L_0x00a9:
            if (r14 != r3) goto L_0x00ad
            r14 = 1
            goto L_0x00ae
        L_0x00ad:
            r14 = 0
        L_0x00ae:
            int r15 = r7.f2849i
            if (r15 != r3) goto L_0x00b4
            r3 = 2
            goto L_0x00b5
        L_0x00b4:
            r3 = 0
        L_0x00b5:
            r3 = r3 | r14
            r15 = r3
        L_0x00b7:
            r13.<init>(r15)
            r3 = 33
            r12.setSpan(r13, r5, r2, r3)
            goto L_0x00c2
        L_0x00c0:
            r3 = 33
        L_0x00c2:
            int r13 = r7.f2846f
            r14 = 1
            if (r13 != r14) goto L_0x00ca
            r16 = 1
            goto L_0x00cc
        L_0x00ca:
            r16 = 0
        L_0x00cc:
            if (r16 == 0) goto L_0x00d6
            android.text.style.StrikethroughSpan r13 = new android.text.style.StrikethroughSpan
            r13.<init>()
            r12.setSpan(r13, r5, r2, r3)
        L_0x00d6:
            int r13 = r7.f2847g
            if (r13 != r14) goto L_0x00dc
            r13 = 1
            goto L_0x00dd
        L_0x00dc:
            r13 = 0
        L_0x00dd:
            if (r13 == 0) goto L_0x00e7
            android.text.style.UnderlineSpan r13 = new android.text.style.UnderlineSpan
            r13.<init>()
            r12.setSpan(r13, r5, r2, r3)
        L_0x00e7:
            boolean r3 = r7.f2843c
            if (r3 == 0) goto L_0x0102
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            boolean r13 = r7.f2843c
            if (r13 == 0) goto L_0x00fa
            int r13 = r7.f2842b
            r3.<init>(r13)
            i1.h.a(r12, r3, r5, r2)
            goto L_0x0102
        L_0x00fa:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Font color has not been defined."
            r1.<init>(r2)
            throw r1
        L_0x0102:
            boolean r3 = r7.f2845e
            if (r3 == 0) goto L_0x011d
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            boolean r13 = r7.f2845e
            if (r13 == 0) goto L_0x0115
            int r13 = r7.f2844d
            r3.<init>(r13)
            i1.h.a(r12, r3, r5, r2)
            goto L_0x011d
        L_0x0115:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Background color has not been defined."
            r1.<init>(r2)
            throw r1
        L_0x011d:
            java.lang.String r3 = r7.f2841a
            if (r3 == 0) goto L_0x012b
            android.text.style.TypefaceSpan r3 = new android.text.style.TypefaceSpan
            java.lang.String r13 = r7.f2841a
            r3.<init>(r13)
            i1.h.a(r12, r3, r5, r2)
        L_0x012b:
            c3.b r3 = r7.f2858r
            r13 = 3
            if (r3 == 0) goto L_0x0154
            int r14 = r3.f2802a
            r15 = -1
            if (r14 != r15) goto L_0x0144
            int r6 = r6.f2840j
            r14 = 2
            if (r6 == r14) goto L_0x0140
            r14 = 1
            if (r6 != r14) goto L_0x013e
            goto L_0x0140
        L_0x013e:
            r6 = 1
            goto L_0x0141
        L_0x0140:
            r6 = 3
        L_0x0141:
            r14 = r6
            r6 = 1
            goto L_0x0146
        L_0x0144:
            int r6 = r3.f2803b
        L_0x0146:
            r15 = -2
            int r3 = r3.f2804c
            if (r3 != r15) goto L_0x014c
            r3 = 1
        L_0x014c:
            i1.i r15 = new i1.i
            r15.<init>(r14, r6, r3)
            i1.h.a(r12, r15, r5, r2)
        L_0x0154:
            int r3 = r7.f2853m
            r6 = 2
            if (r3 == r6) goto L_0x0169
            if (r3 == r13) goto L_0x015f
            r6 = 4
            if (r3 == r6) goto L_0x015f
            goto L_0x01c0
        L_0x015f:
            c3.a r3 = new c3.a
            r3.<init>()
            r6 = 33
            r13 = 0
            goto L_0x01ff
        L_0x0169:
            c3.e r3 = r0.f2827j
        L_0x016b:
            if (r3 == 0) goto L_0x0180
            c3.h r14 = r3.f2823f
            java.lang.String[] r15 = r3.f2824g
            c3.h r14 = c3.g.a(r14, r15, r8)
            if (r14 == 0) goto L_0x017d
            int r14 = r14.f2853m
            r15 = 1
            if (r14 != r15) goto L_0x017d
            goto L_0x0181
        L_0x017d:
            c3.e r3 = r3.f2827j
            goto L_0x016b
        L_0x0180:
            r3 = 0
        L_0x0181:
            if (r3 != 0) goto L_0x0184
            goto L_0x01c0
        L_0x0184:
            java.util.ArrayDeque r14 = new java.util.ArrayDeque
            r14.<init>()
            r14.push(r3)
        L_0x018c:
            boolean r15 = r14.isEmpty()
            if (r15 != 0) goto L_0x01bd
            java.lang.Object r15 = r14.pop()
            c3.e r15 = (c3.e) r15
            c3.h r6 = r15.f2823f
            java.lang.String[] r13 = r15.f2824g
            c3.h r6 = c3.g.a(r6, r13, r8)
            if (r6 == 0) goto L_0x01a9
            int r6 = r6.f2853m
            r13 = 3
            if (r6 != r13) goto L_0x01a9
            r6 = r15
            goto L_0x01be
        L_0x01a9:
            int r6 = r15.c()
            r13 = -1
            int r6 = r6 + r13
        L_0x01af:
            if (r6 < 0) goto L_0x01bb
            c3.e r13 = r15.b(r6)
            r14.push(r13)
            int r6 = r6 + -1
            goto L_0x01af
        L_0x01bb:
            r13 = 3
            goto L_0x018c
        L_0x01bd:
            r6 = 0
        L_0x01be:
            if (r6 != 0) goto L_0x01c2
        L_0x01c0:
            r13 = 0
            goto L_0x020b
        L_0x01c2:
            int r13 = r6.c()
            r14 = 1
            if (r13 != r14) goto L_0x0203
            r13 = 0
            c3.e r14 = r6.b(r13)
            java.lang.String r14 = r14.f2819b
            if (r14 == 0) goto L_0x0204
            c3.e r14 = r6.b(r13)
            java.lang.String r14 = r14.f2819b
            int r15 = j1.l0.f8453a
            c3.h r15 = r6.f2823f
            java.lang.String[] r6 = r6.f2824g
            c3.h r6 = c3.g.a(r15, r6, r8)
            if (r6 == 0) goto L_0x01e8
            int r15 = r6.f2854n
            r6 = -1
            goto L_0x01ea
        L_0x01e8:
            r6 = -1
            r15 = -1
        L_0x01ea:
            if (r15 != r6) goto L_0x01f8
            c3.h r6 = r3.f2823f
            java.lang.String[] r3 = r3.f2824g
            c3.h r3 = c3.g.a(r6, r3, r8)
            if (r3 == 0) goto L_0x01f8
            int r15 = r3.f2854n
        L_0x01f8:
            i1.g r3 = new i1.g
            r3.<init>(r14, r15)
            r6 = 33
        L_0x01ff:
            r12.setSpan(r3, r5, r2, r6)
            goto L_0x020b
        L_0x0203:
            r13 = 0
        L_0x0204:
            java.lang.String r3 = "TtmlRenderUtil"
            java.lang.String r6 = "Skipping rubyText node without exactly one text child."
            j1.v.f(r3, r6)
        L_0x020b:
            int r3 = r7.f2857q
            r6 = 1
            if (r3 != r6) goto L_0x0212
            r3 = 1
            goto L_0x0213
        L_0x0212:
            r3 = 0
        L_0x0213:
            if (r3 == 0) goto L_0x021d
            i1.e r3 = new i1.e
            r3.<init>()
            i1.h.a(r12, r3, r5, r2)
        L_0x021d:
            int r3 = r7.f2850j
            r13 = 1120403456(0x42c80000, float:100.0)
            if (r3 == r6) goto L_0x023b
            r6 = 2
            if (r3 == r6) goto L_0x0233
            r6 = 3
            if (r3 == r6) goto L_0x022a
            goto L_0x0247
        L_0x022a:
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            float r6 = r7.f2851k
            float r6 = r6 / r13
            r3.<init>(r6)
            goto L_0x0244
        L_0x0233:
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            float r6 = r7.f2851k
            r3.<init>(r6)
            goto L_0x0244
        L_0x023b:
            android.text.style.AbsoluteSizeSpan r3 = new android.text.style.AbsoluteSizeSpan
            float r6 = r7.f2851k
            int r6 = (int) r6
            r14 = 1
            r3.<init>(r6, r14)
        L_0x0244:
            i1.h.a(r12, r3, r5, r2)
        L_0x0247:
            java.lang.String r2 = "p"
            java.lang.String r3 = r0.f2818a
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0023
            float r2 = r7.f2859s
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0261
            r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
            float r2 = r2 * r3
            float r2 = r2 / r13
            r4.f7969q = r2
        L_0x0261:
            android.text.Layout$Alignment r2 = r7.f2855o
            if (r2 == 0) goto L_0x0267
            r4.f7955c = r2
        L_0x0267:
            android.text.Layout$Alignment r2 = r7.f2856p
            if (r2 == 0) goto L_0x0023
            r4.f7956d = r2
            goto L_0x0023
        L_0x026f:
            r11 = r21
            r10 = r23
            goto L_0x0023
        L_0x0275:
            r11 = r21
            r10 = r23
            r13 = 0
        L_0x027a:
            int r1 = r17.c()
            if (r13 >= r1) goto L_0x0293
            c3.e r1 = r0.b(r13)
            r2 = r18
            r4 = r20
            r5 = r21
            r6 = r9
            r7 = r23
            r1.h(r2, r4, r5, r6, r7)
            int r13 = r13 + 1
            goto L_0x027a
        L_0x0293:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.e.h(long, java.util.Map, java.util.Map, java.lang.String, java.util.TreeMap):void");
    }

    public final void i(long j10, boolean z10, String str, TreeMap treeMap) {
        String str2;
        boolean z11;
        TreeMap treeMap2 = treeMap;
        HashMap hashMap = this.f2828k;
        hashMap.clear();
        HashMap hashMap2 = this.f2829l;
        hashMap2.clear();
        String str3 = this.f2818a;
        if (!"metadata".equals(str3)) {
            String str4 = this.f2825h;
            if ("".equals(str4)) {
                str2 = str;
            } else {
                str2 = str4;
            }
            if (this.f2820c && z10) {
                SpannableStringBuilder e10 = e(str2, treeMap2);
                String str5 = this.f2819b;
                str5.getClass();
                e10.append(str5);
            } else if ("br".equals(str3) && z10) {
                e(str2, treeMap2).append(10);
            } else if (f(j10)) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    CharSequence charSequence = ((a) entry.getValue()).f7953a;
                    charSequence.getClass();
                    hashMap.put((String) entry.getKey(), Integer.valueOf(charSequence.length()));
                }
                boolean equals = "p".equals(str3);
                for (int i10 = 0; i10 < c(); i10++) {
                    e b10 = b(i10);
                    if (z10 || equals) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    b10.i(j10, z11, str2, treeMap);
                }
                if (equals) {
                    SpannableStringBuilder e11 = e(str2, treeMap2);
                    int length = e11.length();
                    do {
                        length--;
                        if (length < 0 || e11.charAt(length) != ' ') {
                            if (length >= 0 && e11.charAt(length) != 10) {
                                e11.append(10);
                            }
                        }
                        length--;
                        break;
                    } while (e11.charAt(length) != ' ');
                    e11.append(10);
                }
                for (Map.Entry entry2 : treeMap.entrySet()) {
                    CharSequence charSequence2 = ((a) entry2.getValue()).f7953a;
                    charSequence2.getClass();
                    hashMap2.put((String) entry2.getKey(), Integer.valueOf(charSequence2.length()));
                }
            }
        }
    }
}
