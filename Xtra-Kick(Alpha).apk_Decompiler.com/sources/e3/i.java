package e3;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import j1.b0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f5031a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f5032b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c  reason: collision with root package name */
    public static final Map f5033c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map f5034d;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f5033c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f5034d = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:149:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x025c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.text.SpannableStringBuilder r19, e3.f r20, java.lang.String r21, java.util.List r22, java.util.List r23) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            int r4 = r1.f5015b
            int r5 = r19.length()
            java.lang.String r6 = r1.f5014a
            r6.getClass()
            int r7 = r6.hashCode()
            r9 = -1
            r12 = 2
            if (r7 == 0) goto L_0x0087
            r13 = 105(0x69, float:1.47E-43)
            if (r7 == r13) goto L_0x007c
            r13 = 3314158(0x3291ee, float:4.644125E-39)
            if (r7 == r13) goto L_0x0071
            r13 = 3511770(0x3595da, float:4.921038E-39)
            if (r7 == r13) goto L_0x0066
            r13 = 98
            if (r7 == r13) goto L_0x005b
            r13 = 99
            if (r7 == r13) goto L_0x0050
            r13 = 117(0x75, float:1.64E-43)
            if (r7 == r13) goto L_0x0045
            r13 = 118(0x76, float:1.65E-43)
            if (r7 == r13) goto L_0x003a
            goto L_0x008f
        L_0x003a:
            java.lang.String r7 = "v"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0043
            goto L_0x008f
        L_0x0043:
            r6 = 5
            goto L_0x0092
        L_0x0045:
            java.lang.String r7 = "u"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x004e
            goto L_0x008f
        L_0x004e:
            r6 = 4
            goto L_0x0092
        L_0x0050:
            java.lang.String r7 = "c"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0059
            goto L_0x008f
        L_0x0059:
            r6 = 2
            goto L_0x0092
        L_0x005b:
            java.lang.String r7 = "b"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0064
            goto L_0x008f
        L_0x0064:
            r6 = 1
            goto L_0x0092
        L_0x0066:
            java.lang.String r7 = "ruby"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x006f
            goto L_0x008f
        L_0x006f:
            r6 = 7
            goto L_0x0092
        L_0x0071:
            java.lang.String r7 = "lang"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x007a
            goto L_0x008f
        L_0x007a:
            r6 = 6
            goto L_0x0092
        L_0x007c:
            java.lang.String r7 = "i"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0085
            goto L_0x008f
        L_0x0085:
            r6 = 3
            goto L_0x0092
        L_0x0087:
            java.lang.String r7 = ""
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0091
        L_0x008f:
            r6 = -1
            goto L_0x0092
        L_0x0091:
            r6 = 0
        L_0x0092:
            r7 = 33
            switch(r6) {
                case 0: goto L_0x0163;
                case 1: goto L_0x015a;
                case 2: goto L_0x0115;
                case 3: goto L_0x010f;
                case 4: goto L_0x0109;
                case 5: goto L_0x0163;
                case 6: goto L_0x0163;
                case 7: goto L_0x0098;
                default: goto L_0x0097;
            }
        L_0x0097:
            return
        L_0x0098:
            int r6 = c(r3, r2, r1)
            java.util.ArrayList r13 = new java.util.ArrayList
            int r14 = r22.size()
            r13.<init>(r14)
            r14 = r22
            r13.addAll(r14)
            j0.a r14 = e3.e.f5011c
            java.util.Collections.sort(r13, r14)
            int r14 = r1.f5015b
            r15 = 0
            r16 = 0
        L_0x00b4:
            int r10 = r13.size()
            if (r15 >= r10) goto L_0x0163
            java.lang.Object r10 = r13.get(r15)
            e3.e r10 = (e3.e) r10
            e3.f r10 = r10.f5012a
            java.lang.String r10 = r10.f5014a
            java.lang.String r8 = "rt"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x00cd
            goto L_0x0105
        L_0x00cd:
            java.lang.Object r8 = r13.get(r15)
            e3.e r8 = (e3.e) r8
            e3.f r10 = r8.f5012a
            int r10 = c(r3, r2, r10)
            if (r10 == r9) goto L_0x00dc
            goto L_0x00e1
        L_0x00dc:
            if (r6 == r9) goto L_0x00e0
            r10 = r6
            goto L_0x00e1
        L_0x00e0:
            r10 = 1
        L_0x00e1:
            e3.f r9 = r8.f5012a
            int r9 = r9.f5015b
            int r9 = r9 - r16
            int r8 = r8.f5013b
            int r8 = r8 - r16
            java.lang.CharSequence r17 = r0.subSequence(r9, r8)
            r0.delete(r9, r8)
            i1.g r8 = new i1.g
            java.lang.String r11 = r17.toString()
            r8.<init>(r11, r10)
            r0.setSpan(r8, r14, r9, r7)
            int r8 = r17.length()
            int r16 = r8 + r16
            r14 = r9
        L_0x0105:
            int r15 = r15 + 1
            r9 = -1
            goto L_0x00b4
        L_0x0109:
            android.text.style.UnderlineSpan r6 = new android.text.style.UnderlineSpan
            r6.<init>()
            goto L_0x0160
        L_0x010f:
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r12)
            goto L_0x0160
        L_0x0115:
            java.util.Set r6 = r1.f5017d
            java.util.Iterator r6 = r6.iterator()
        L_0x011b:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0163
            java.lang.Object r8 = r6.next()
            java.lang.String r8 = (java.lang.String) r8
            java.util.Map r9 = f5033c
            boolean r10 = r9.containsKey(r8)
            if (r10 == 0) goto L_0x013f
            java.lang.Object r8 = r9.get(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            android.text.style.ForegroundColorSpan r9 = new android.text.style.ForegroundColorSpan
            r9.<init>(r8)
            goto L_0x0156
        L_0x013f:
            java.util.Map r9 = f5034d
            boolean r10 = r9.containsKey(r8)
            if (r10 == 0) goto L_0x011b
            java.lang.Object r8 = r9.get(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            android.text.style.BackgroundColorSpan r9 = new android.text.style.BackgroundColorSpan
            r9.<init>(r8)
        L_0x0156:
            r0.setSpan(r9, r4, r5, r7)
            goto L_0x011b
        L_0x015a:
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r8 = 1
            r6.<init>(r8)
        L_0x0160:
            r0.setSpan(r6, r4, r5, r7)
        L_0x0163:
            java.util.ArrayList r1 = b(r3, r2, r1)
            r2 = 0
        L_0x0168:
            int r3 = r1.size()
            if (r2 >= r3) goto L_0x0260
            java.lang.Object r3 = r1.get(r2)
            e3.g r3 = (e3.g) r3
            e3.c r3 = r3.f5019i
            if (r3 != 0) goto L_0x017d
            r6 = -1
            r9 = 3
            r11 = 1
            goto L_0x025c
        L_0x017d:
            int r6 = r3.f5002l
            r8 = -1
            if (r6 != r8) goto L_0x0188
            int r9 = r3.f5003m
            if (r9 != r8) goto L_0x0188
            r8 = -1
            goto L_0x0196
        L_0x0188:
            r8 = 1
            if (r6 != r8) goto L_0x018d
            r6 = 1
            goto L_0x018e
        L_0x018d:
            r6 = 0
        L_0x018e:
            int r9 = r3.f5003m
            if (r9 != r8) goto L_0x0194
            r8 = 2
            goto L_0x0195
        L_0x0194:
            r8 = 0
        L_0x0195:
            r8 = r8 | r6
        L_0x0196:
            r6 = -1
            if (r8 == r6) goto L_0x01b9
            android.text.style.StyleSpan r8 = new android.text.style.StyleSpan
            int r9 = r3.f5002l
            if (r9 != r6) goto L_0x01a5
            int r10 = r3.f5003m
            if (r10 != r6) goto L_0x01a5
            r9 = -1
            goto L_0x01b3
        L_0x01a5:
            r10 = 1
            if (r9 != r10) goto L_0x01aa
            r9 = 1
            goto L_0x01ab
        L_0x01aa:
            r9 = 0
        L_0x01ab:
            int r11 = r3.f5003m
            if (r11 != r10) goto L_0x01b1
            r10 = 2
            goto L_0x01b2
        L_0x01b1:
            r10 = 0
        L_0x01b2:
            r9 = r9 | r10
        L_0x01b3:
            r8.<init>(r9)
            i1.h.a(r0, r8, r4, r5)
        L_0x01b9:
            int r8 = r3.f5000j
            r9 = 1
            if (r8 != r9) goto L_0x01c1
            r18 = 1
            goto L_0x01c3
        L_0x01c1:
            r18 = 0
        L_0x01c3:
            if (r18 == 0) goto L_0x01cd
            android.text.style.StrikethroughSpan r8 = new android.text.style.StrikethroughSpan
            r8.<init>()
            r0.setSpan(r8, r4, r5, r7)
        L_0x01cd:
            int r8 = r3.f5001k
            if (r8 != r9) goto L_0x01d3
            r8 = 1
            goto L_0x01d4
        L_0x01d3:
            r8 = 0
        L_0x01d4:
            if (r8 == 0) goto L_0x01de
            android.text.style.UnderlineSpan r8 = new android.text.style.UnderlineSpan
            r8.<init>()
            r0.setSpan(r8, r4, r5, r7)
        L_0x01de:
            boolean r8 = r3.f4997g
            if (r8 == 0) goto L_0x01f9
            android.text.style.ForegroundColorSpan r8 = new android.text.style.ForegroundColorSpan
            boolean r9 = r3.f4997g
            if (r9 == 0) goto L_0x01f1
            int r9 = r3.f4996f
            r8.<init>(r9)
            i1.h.a(r0, r8, r4, r5)
            goto L_0x01f9
        L_0x01f1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Font color not defined"
            r0.<init>(r1)
            throw r0
        L_0x01f9:
            boolean r8 = r3.f4999i
            if (r8 == 0) goto L_0x0214
            android.text.style.BackgroundColorSpan r8 = new android.text.style.BackgroundColorSpan
            boolean r9 = r3.f4999i
            if (r9 == 0) goto L_0x020c
            int r9 = r3.f4998h
            r8.<init>(r9)
            i1.h.a(r0, r8, r4, r5)
            goto L_0x0214
        L_0x020c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Background color not defined."
            r0.<init>(r1)
            throw r0
        L_0x0214:
            java.lang.String r8 = r3.f4995e
            if (r8 == 0) goto L_0x0222
            android.text.style.TypefaceSpan r8 = new android.text.style.TypefaceSpan
            java.lang.String r9 = r3.f4995e
            r8.<init>(r9)
            i1.h.a(r0, r8, r4, r5)
        L_0x0222:
            int r8 = r3.f5004n
            r9 = 1
            if (r8 == r9) goto L_0x0243
            if (r8 == r12) goto L_0x0239
            r9 = 3
            if (r8 == r9) goto L_0x022e
            r11 = 1
            goto L_0x0250
        L_0x022e:
            android.text.style.RelativeSizeSpan r8 = new android.text.style.RelativeSizeSpan
            float r10 = r3.f5005o
            r11 = 1120403456(0x42c80000, float:100.0)
            float r10 = r10 / r11
            r8.<init>(r10)
            goto L_0x0241
        L_0x0239:
            r9 = 3
            android.text.style.RelativeSizeSpan r8 = new android.text.style.RelativeSizeSpan
            float r10 = r3.f5005o
            r8.<init>(r10)
        L_0x0241:
            r11 = 1
            goto L_0x024d
        L_0x0243:
            r9 = 3
            android.text.style.AbsoluteSizeSpan r8 = new android.text.style.AbsoluteSizeSpan
            float r10 = r3.f5005o
            int r10 = (int) r10
            r11 = 1
            r8.<init>(r10, r11)
        L_0x024d:
            i1.h.a(r0, r8, r4, r5)
        L_0x0250:
            boolean r3 = r3.f5007q
            if (r3 == 0) goto L_0x025c
            i1.e r3 = new i1.e
            r3.<init>()
            r0.setSpan(r3, r4, r5, r7)
        L_0x025c:
            int r2 = r2 + 1
            goto L_0x0168
        L_0x0260:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.i.a(android.text.SpannableStringBuilder, e3.f, java.lang.String, java.util.List, java.util.List):void");
    }

    public static ArrayList b(List list, String str, f fVar) {
        int i10;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = (c) list.get(i11);
            String str2 = fVar.f5014a;
            if (!cVar.f4991a.isEmpty() || !cVar.f4992b.isEmpty() || !cVar.f4993c.isEmpty() || !cVar.f4994d.isEmpty()) {
                int a10 = c.a(c.a(c.a(0, 1073741824, cVar.f4991a, str), 2, cVar.f4992b, str2), 4, cVar.f4994d, fVar.f5016c);
                if (a10 != -1) {
                    if (fVar.f5017d.containsAll(cVar.f4993c)) {
                        i10 = a10 + (cVar.f4993c.size() * 4);
                    }
                }
                i10 = 0;
            } else {
                i10 = TextUtils.isEmpty(str2);
            }
            if (i10 > 0) {
                arrayList.add(new g(i10, cVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int c(List list, String str, f fVar) {
        ArrayList b10 = b(list, str, fVar);
        for (int i10 = 0; i10 < b10.size(); i10++) {
            int i11 = ((g) b10.get(i10)).f5019i.f5006p;
            if (i11 != -1) {
                return i11;
            }
        }
        return -1;
    }

    public static d d(String str, Matcher matcher, b0 b0Var, ArrayList arrayList) {
        h hVar = new h();
        try {
            String group = matcher.group(1);
            group.getClass();
            hVar.f5020a = k.c(group);
            String group2 = matcher.group(2);
            group2.getClass();
            hVar.f5021b = k.c(group2);
            String group3 = matcher.group(3);
            group3.getClass();
            e(group3, hVar);
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String g10 = b0Var.g();
                if (!TextUtils.isEmpty(g10)) {
                    if (sb2.length() > 0) {
                        sb2.append(Constants.WRITE_NEW_LINE);
                    }
                    sb2.append(g10.trim());
                } else {
                    hVar.f5022c = f(str, sb2.toString(), arrayList);
                    return new d(hVar.a().a(), hVar.f5020a, hVar.f5021b);
                }
            }
        } catch (NumberFormatException unused) {
            v.g("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c6, code lost:
        if (r7.equals("start") == false) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(java.lang.String r18, e3.h r19) {
        /*
            r0 = r19
            java.lang.String r1 = "WebvttCueParser"
            java.util.regex.Pattern r2 = f5032b
            r3 = r18
            java.util.regex.Matcher r2 = r2.matcher(r3)
        L_0x000c:
            boolean r3 = r2.find()
            if (r3 == 0) goto L_0x0189
            r3 = 1
            java.lang.String r4 = r2.group(r3)
            r4.getClass()
            r5 = 2
            java.lang.String r6 = r2.group(r5)
            r6.getClass()
            java.lang.String r7 = "line"
            boolean r7 = r7.equals(r4)     // Catch:{ NumberFormatException -> 0x0172 }
            if (r7 == 0) goto L_0x002e
            g(r6, r0)     // Catch:{ NumberFormatException -> 0x0172 }
            goto L_0x000c
        L_0x002e:
            java.lang.String r7 = "align"
            boolean r7 = r7.equals(r4)     // Catch:{ NumberFormatException -> 0x0172 }
            java.lang.String r8 = "start"
            java.lang.String r9 = "end"
            java.lang.String r10 = "middle"
            java.lang.String r11 = "center"
            r12 = 5
            r13 = 4
            r14 = 3
            r15 = -1
            r3 = 0
            if (r7 == 0) goto L_0x009e
            int r4 = r6.hashCode()
            switch(r4) {
                case -1364013995: goto L_0x007c;
                case -1074341483: goto L_0x0073;
                case 100571: goto L_0x006a;
                case 3317767: goto L_0x005f;
                case 108511772: goto L_0x0054;
                case 109757538: goto L_0x004b;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x0084
        L_0x004b:
            boolean r3 = r6.equals(r8)
            if (r3 != 0) goto L_0x0052
            goto L_0x0084
        L_0x0052:
            r15 = 5
            goto L_0x0084
        L_0x0054:
            java.lang.String r3 = "right"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x005d
            goto L_0x0084
        L_0x005d:
            r15 = 4
            goto L_0x0084
        L_0x005f:
            java.lang.String r3 = "left"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0068
            goto L_0x0084
        L_0x0068:
            r15 = 3
            goto L_0x0084
        L_0x006a:
            boolean r3 = r6.equals(r9)
            if (r3 != 0) goto L_0x0071
            goto L_0x0084
        L_0x0071:
            r15 = 2
            goto L_0x0084
        L_0x0073:
            boolean r3 = r6.equals(r10)
            if (r3 != 0) goto L_0x007a
            goto L_0x0084
        L_0x007a:
            r15 = 1
            goto L_0x0084
        L_0x007c:
            boolean r4 = r6.equals(r11)
            if (r4 != 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r15 = 0
        L_0x0084:
            switch(r15) {
                case 0: goto L_0x0099;
                case 1: goto L_0x0099;
                case 2: goto L_0x0097;
                case 3: goto L_0x0095;
                case 4: goto L_0x0093;
                case 5: goto L_0x0091;
                default: goto L_0x0087;
            }
        L_0x0087:
            java.lang.String r3 = "Invalid alignment value: "
            java.lang.String r3 = r3.concat(r6)     // Catch:{ NumberFormatException -> 0x0172 }
            j1.v.g(r1, r3)     // Catch:{ NumberFormatException -> 0x0172 }
            goto L_0x0099
        L_0x0091:
            r3 = 1
            goto L_0x009a
        L_0x0093:
            r3 = 5
            goto L_0x009a
        L_0x0095:
            r3 = 4
            goto L_0x009a
        L_0x0097:
            r3 = 3
            goto L_0x009a
        L_0x0099:
            r3 = 2
        L_0x009a:
            r0.f5023d = r3     // Catch:{ NumberFormatException -> 0x0172 }
            goto L_0x000c
        L_0x009e:
            java.lang.String r7 = "position"
            boolean r7 = r7.equals(r4)     // Catch:{ NumberFormatException -> 0x0172 }
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r7 == 0) goto L_0x0119
            r4 = 44
            int r4 = r6.indexOf(r4)     // Catch:{ NumberFormatException -> 0x0172 }
            if (r4 == r15) goto L_0x0111
            int r7 = r4 + 1
            java.lang.String r7 = r6.substring(r7)     // Catch:{ NumberFormatException -> 0x0172 }
            r7.getClass()     // Catch:{ NumberFormatException -> 0x0172 }
            int r17 = r7.hashCode()
            switch(r17) {
                case -1842484672: goto L_0x00ef;
                case -1364013995: goto L_0x00e6;
                case -1276788989: goto L_0x00db;
                case -1074341483: goto L_0x00d2;
                case 100571: goto L_0x00c9;
                case 109757538: goto L_0x00c2;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            r12 = -1
            goto L_0x00f9
        L_0x00c2:
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00f9
            goto L_0x00c0
        L_0x00c9:
            boolean r8 = r7.equals(r9)
            if (r8 != 0) goto L_0x00d0
            goto L_0x00c0
        L_0x00d0:
            r12 = 4
            goto L_0x00f9
        L_0x00d2:
            boolean r8 = r7.equals(r10)
            if (r8 != 0) goto L_0x00d9
            goto L_0x00c0
        L_0x00d9:
            r12 = 3
            goto L_0x00f9
        L_0x00db:
            java.lang.String r8 = "line-right"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00e4
            goto L_0x00c0
        L_0x00e4:
            r12 = 2
            goto L_0x00f9
        L_0x00e6:
            boolean r8 = r7.equals(r11)
            if (r8 != 0) goto L_0x00ed
            goto L_0x00c0
        L_0x00ed:
            r12 = 1
            goto L_0x00f9
        L_0x00ef:
            java.lang.String r8 = "line-left"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00f8
            goto L_0x00c0
        L_0x00f8:
            r12 = 0
        L_0x00f9:
            switch(r12) {
                case 0: goto L_0x010a;
                case 1: goto L_0x0108;
                case 2: goto L_0x010b;
                case 3: goto L_0x0108;
                case 4: goto L_0x010b;
                case 5: goto L_0x010a;
                default: goto L_0x00fc;
            }
        L_0x00fc:
            java.lang.String r5 = "Invalid anchor value: "
            java.lang.String r5 = r5.concat(r7)     // Catch:{ NumberFormatException -> 0x0172 }
            j1.v.g(r1, r5)     // Catch:{ NumberFormatException -> 0x0172 }
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x010b
        L_0x0108:
            r5 = 1
            goto L_0x010b
        L_0x010a:
            r5 = 0
        L_0x010b:
            r0.f5028i = r5     // Catch:{ NumberFormatException -> 0x0172 }
            java.lang.String r6 = r6.substring(r3, r4)     // Catch:{ NumberFormatException -> 0x0172 }
        L_0x0111:
            float r3 = e3.k.b(r6)     // Catch:{ NumberFormatException -> 0x0172 }
            r0.f5027h = r3     // Catch:{ NumberFormatException -> 0x0172 }
            goto L_0x000c
        L_0x0119:
            java.lang.String r3 = "size"
            boolean r3 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x0172 }
            if (r3 == 0) goto L_0x0129
            float r3 = e3.k.b(r6)     // Catch:{ NumberFormatException -> 0x0172 }
            r0.f5029j = r3     // Catch:{ NumberFormatException -> 0x0172 }
            goto L_0x000c
        L_0x0129:
            java.lang.String r3 = "vertical"
            boolean r3 = r3.equals(r4)     // Catch:{ NumberFormatException -> 0x0172 }
            if (r3 == 0) goto L_0x0154
            java.lang.String r3 = "lr"
            boolean r3 = r6.equals(r3)     // Catch:{ NumberFormatException -> 0x0172 }
            if (r3 != 0) goto L_0x014f
            java.lang.String r3 = "rl"
            boolean r3 = r6.equals(r3)     // Catch:{ NumberFormatException -> 0x0172 }
            if (r3 != 0) goto L_0x014d
            java.lang.String r3 = "Invalid 'vertical' value: "
            java.lang.String r3 = r3.concat(r6)     // Catch:{ NumberFormatException -> 0x0172 }
            j1.v.g(r1, r3)     // Catch:{ NumberFormatException -> 0x0172 }
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0150
        L_0x014d:
            r3 = 1
            goto L_0x0150
        L_0x014f:
            r3 = 2
        L_0x0150:
            r0.f5030k = r3     // Catch:{ NumberFormatException -> 0x0172 }
            goto L_0x000c
        L_0x0154:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0172 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x0172 }
            java.lang.String r5 = "Unknown cue setting "
            r3.append(r5)     // Catch:{ NumberFormatException -> 0x0172 }
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x0172 }
            java.lang.String r4 = ":"
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x0172 }
            r3.append(r6)     // Catch:{ NumberFormatException -> 0x0172 }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x0172 }
            j1.v.g(r1, r3)     // Catch:{ NumberFormatException -> 0x0172 }
            goto L_0x000c
        L_0x0172:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Skipping bad cue setting: "
            r3.<init>(r4)
            java.lang.String r4 = r2.group()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            j1.v.g(r1, r3)
            goto L_0x000c
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.i.e(java.lang.String, e3.h):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.text.SpannedString f(java.lang.String r16, java.lang.String r17, java.util.List r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder
            r3.<init>()
            java.util.ArrayDeque r4 = new java.util.ArrayDeque
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r7 = 0
        L_0x0016:
            int r8 = r17.length()
            java.lang.String r9 = ""
            if (r7 >= r8) goto L_0x0229
            char r8 = r1.charAt(r7)
            r11 = 38
            r12 = 62
            r13 = 2
            r14 = -1
            r15 = 1
            java.lang.String r10 = " "
            r6 = 60
            if (r8 == r11) goto L_0x019e
            if (r8 == r6) goto L_0x0037
            r3.append(r8)
            int r7 = r7 + 1
            goto L_0x0016
        L_0x0037:
            int r6 = r7 + 1
            int r8 = r17.length()
            if (r6 < r8) goto L_0x0041
        L_0x003f:
            r7 = r6
            goto L_0x0016
        L_0x0041:
            char r8 = r1.charAt(r6)
            r11 = 47
            if (r8 != r11) goto L_0x004b
            r8 = 1
            goto L_0x004c
        L_0x004b:
            r8 = 0
        L_0x004c:
            int r6 = r1.indexOf(r12, r6)
            if (r6 != r14) goto L_0x0057
            int r6 = r17.length()
            goto L_0x0059
        L_0x0057:
            int r6 = r6 + 1
        L_0x0059:
            int r12 = r6 + -2
            char r14 = r1.charAt(r12)
            if (r14 != r11) goto L_0x0063
            r11 = 1
            goto L_0x0064
        L_0x0063:
            r11 = 0
        L_0x0064:
            if (r8 == 0) goto L_0x0068
            r14 = 2
            goto L_0x0069
        L_0x0068:
            r14 = 1
        L_0x0069:
            int r7 = r7 + r14
            if (r11 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            int r12 = r6 + -1
        L_0x006f:
            java.lang.String r7 = r1.substring(r7, r12)
            java.lang.String r12 = r7.trim()
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x007e
            goto L_0x003f
        L_0x007e:
            java.lang.String r12 = r7.trim()
            boolean r14 = r12.isEmpty()
            r14 = r14 ^ r15
            j1.a.b(r14)
            int r14 = j1.l0.f8453a
            java.lang.String r14 = "[ \\.]"
            java.lang.String[] r12 = r12.split(r14, r13)
            r14 = 0
            r12 = r12[r14]
            r12.getClass()
            int r14 = r12.hashCode()
            r13 = 98
            if (r14 == r13) goto L_0x010c
            r13 = 99
            if (r14 == r13) goto L_0x0101
            r13 = 105(0x69, float:1.47E-43)
            if (r14 == r13) goto L_0x00f6
            r13 = 3650(0xe42, float:5.115E-42)
            if (r14 == r13) goto L_0x00eb
            r13 = 3314158(0x3291ee, float:4.644125E-39)
            if (r14 == r13) goto L_0x00e0
            r13 = 3511770(0x3595da, float:4.921038E-39)
            if (r14 == r13) goto L_0x00d5
            r13 = 117(0x75, float:1.64E-43)
            if (r14 == r13) goto L_0x00ca
            r13 = 118(0x76, float:1.65E-43)
            if (r14 == r13) goto L_0x00bf
            goto L_0x0114
        L_0x00bf:
            java.lang.String r13 = "v"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00c8
            goto L_0x0114
        L_0x00c8:
            r13 = 4
            goto L_0x0117
        L_0x00ca:
            java.lang.String r13 = "u"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00d3
            goto L_0x0114
        L_0x00d3:
            r13 = 3
            goto L_0x0117
        L_0x00d5:
            java.lang.String r13 = "ruby"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00de
            goto L_0x0114
        L_0x00de:
            r13 = 7
            goto L_0x0117
        L_0x00e0:
            java.lang.String r13 = "lang"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00e9
            goto L_0x0114
        L_0x00e9:
            r13 = 6
            goto L_0x0117
        L_0x00eb:
            java.lang.String r13 = "rt"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00f4
            goto L_0x0114
        L_0x00f4:
            r13 = 5
            goto L_0x0117
        L_0x00f6:
            java.lang.String r13 = "i"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00ff
            goto L_0x0114
        L_0x00ff:
            r13 = 2
            goto L_0x0117
        L_0x0101:
            java.lang.String r13 = "c"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x010a
            goto L_0x0114
        L_0x010a:
            r13 = 1
            goto L_0x0117
        L_0x010c:
            java.lang.String r13 = "b"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x0116
        L_0x0114:
            r13 = -1
            goto L_0x0117
        L_0x0116:
            r13 = 0
        L_0x0117:
            switch(r13) {
                case 0: goto L_0x011c;
                case 1: goto L_0x011c;
                case 2: goto L_0x011c;
                case 3: goto L_0x011c;
                case 4: goto L_0x011c;
                case 5: goto L_0x011c;
                case 6: goto L_0x011c;
                case 7: goto L_0x011c;
                default: goto L_0x011a;
            }
        L_0x011a:
            r13 = 0
            goto L_0x011d
        L_0x011c:
            r13 = 1
        L_0x011d:
            if (r13 != 0) goto L_0x0121
            goto L_0x003f
        L_0x0121:
            if (r8 == 0) goto L_0x0154
        L_0x0123:
            boolean r7 = r4.isEmpty()
            if (r7 == 0) goto L_0x012b
            goto L_0x003f
        L_0x012b:
            java.lang.Object r7 = r4.pop()
            e3.f r7 = (e3.f) r7
            a(r3, r7, r0, r5, r2)
            boolean r8 = r4.isEmpty()
            if (r8 != 0) goto L_0x0147
            e3.e r8 = new e3.e
            int r9 = r3.length()
            r8.<init>(r7, r9)
            r5.add(r8)
            goto L_0x014a
        L_0x0147:
            r5.clear()
        L_0x014a:
            java.lang.String r7 = r7.f5014a
            boolean r7 = r7.equals(r12)
            if (r7 == 0) goto L_0x0123
            goto L_0x003f
        L_0x0154:
            if (r11 != 0) goto L_0x003f
            int r8 = r3.length()
            java.lang.String r7 = r7.trim()
            boolean r11 = r7.isEmpty()
            r11 = r11 ^ r15
            j1.a.b(r11)
            int r10 = r7.indexOf(r10)
            r11 = -1
            if (r10 != r11) goto L_0x016f
            r12 = 0
            goto L_0x017c
        L_0x016f:
            java.lang.String r9 = r7.substring(r10)
            java.lang.String r9 = r9.trim()
            r12 = 0
            java.lang.String r7 = r7.substring(r12, r10)
        L_0x017c:
            java.lang.String r10 = "\\."
            java.lang.String[] r7 = r7.split(r10, r11)
            r10 = r7[r12]
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
        L_0x0189:
            int r12 = r7.length
            if (r15 >= r12) goto L_0x0194
            r12 = r7[r15]
            r11.add(r12)
            int r15 = r15 + 1
            goto L_0x0189
        L_0x0194:
            e3.f r7 = new e3.f
            r7.<init>(r10, r8, r9, r11)
            r4.push(r7)
            goto L_0x003f
        L_0x019e:
            int r7 = r7 + 1
            r9 = 59
            int r9 = r1.indexOf(r9, r7)
            r13 = 32
            int r14 = r1.indexOf(r13, r7)
            r6 = -1
            if (r9 != r6) goto L_0x01b1
            r9 = r14
            goto L_0x01b8
        L_0x01b1:
            if (r14 != r6) goto L_0x01b4
            goto L_0x01b8
        L_0x01b4:
            int r9 = java.lang.Math.min(r9, r14)
        L_0x01b8:
            if (r9 == r6) goto L_0x0224
            java.lang.String r7 = r1.substring(r7, r9)
            r7.getClass()
            int r8 = r7.hashCode()
            switch(r8) {
                case 3309: goto L_0x01ea;
                case 3464: goto L_0x01df;
                case 96708: goto L_0x01d4;
                case 3374865: goto L_0x01c9;
                default: goto L_0x01c8;
            }
        L_0x01c8:
            goto L_0x01f4
        L_0x01c9:
            java.lang.String r8 = "nbsp"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x01d2
            goto L_0x01f4
        L_0x01d2:
            r6 = 3
            goto L_0x01f4
        L_0x01d4:
            java.lang.String r8 = "amp"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x01dd
            goto L_0x01f4
        L_0x01dd:
            r6 = 2
            goto L_0x01f4
        L_0x01df:
            java.lang.String r8 = "lt"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x01e8
            goto L_0x01f4
        L_0x01e8:
            r6 = 1
            goto L_0x01f4
        L_0x01ea:
            java.lang.String r8 = "gt"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x01f3
            goto L_0x01f4
        L_0x01f3:
            r6 = 0
        L_0x01f4:
            switch(r6) {
                case 0: goto L_0x0216;
                case 1: goto L_0x0213;
                case 2: goto L_0x0218;
                case 3: goto L_0x0210;
                default: goto L_0x01f7;
            }
        L_0x01f7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "ignoring unsupported entity: '&"
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r7 = ";'"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "WebvttCueParser"
            j1.v.g(r7, r6)
            goto L_0x021b
        L_0x0210:
            r11 = 32
            goto L_0x0218
        L_0x0213:
            r11 = 60
            goto L_0x0218
        L_0x0216:
            r11 = 62
        L_0x0218:
            r3.append(r11)
        L_0x021b:
            if (r9 != r14) goto L_0x0220
            r3.append(r10)
        L_0x0220:
            int r7 = r9 + 1
            goto L_0x0016
        L_0x0224:
            r3.append(r8)
            goto L_0x0016
        L_0x0229:
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x0239
            java.lang.Object r1 = r4.pop()
            e3.f r1 = (e3.f) r1
            a(r3, r1, r0, r5, r2)
            goto L_0x0229
        L_0x0239:
            e3.f r1 = new e3.f
            java.util.Set r4 = java.util.Collections.emptySet()
            r5 = 0
            r1.<init>(r9, r5, r9, r4)
            java.util.List r4 = java.util.Collections.emptyList()
            a(r3, r1, r0, r4, r2)
            android.text.SpannedString r0 = android.text.SpannedString.valueOf(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.i.f(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    public static void g(String str, h hVar) {
        int indexOf = str.indexOf(44);
        char c10 = 65535;
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 1);
            substring.getClass();
            int i10 = 2;
            switch (substring.hashCode()) {
                case -1364013995:
                    if (substring.equals("center")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1074341483:
                    if (substring.equals("middle")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (substring.equals("end")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 109757538:
                    if (substring.equals("start")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                case 1:
                    i10 = 1;
                    break;
                case 2:
                    break;
                case 3:
                    i10 = 0;
                    break;
                default:
                    v.g("WebvttCueParser", "Invalid anchor value: ".concat(substring));
                    i10 = RecyclerView.UNDEFINED_DURATION;
                    break;
            }
            hVar.f5026g = i10;
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            hVar.f5024e = k.b(str);
            hVar.f5025f = 0;
            return;
        }
        hVar.f5024e = (float) Integer.parseInt(str);
        hVar.f5025f = 1;
    }
}
