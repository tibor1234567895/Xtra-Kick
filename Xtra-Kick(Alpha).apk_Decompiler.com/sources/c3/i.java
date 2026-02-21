package c3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import i1.a;
import j1.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import w2.d;

public final class i implements d {

    /* renamed from: h  reason: collision with root package name */
    public final e f2860h;

    /* renamed from: i  reason: collision with root package name */
    public final long[] f2861i;

    /* renamed from: j  reason: collision with root package name */
    public final Map f2862j;

    /* renamed from: k  reason: collision with root package name */
    public final Map f2863k;

    /* renamed from: l  reason: collision with root package name */
    public final Map f2864l;

    public i(e eVar, HashMap hashMap, HashMap hashMap2, HashMap hashMap3) {
        this.f2860h = eVar;
        this.f2863k = hashMap2;
        this.f2864l = hashMap3;
        this.f2862j = Collections.unmodifiableMap(hashMap);
        TreeSet treeSet = new TreeSet();
        int i10 = 0;
        eVar.d(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i10] = ((Long) it.next()).longValue();
            i10++;
        }
        this.f2861i = jArr;
    }

    public final int a(long j10) {
        long[] jArr = this.f2861i;
        int b10 = l0.b(jArr, j10, false);
        if (b10 < jArr.length) {
            return b10;
        }
        return -1;
    }

    public final long b(int i10) {
        return this.f2861i[i10];
    }

    public final List c(long j10) {
        Map map = this.f2862j;
        Map map2 = this.f2863k;
        e eVar = this.f2860h;
        eVar.getClass();
        ArrayList arrayList = new ArrayList();
        eVar.g(j10, eVar.f2825h, arrayList);
        TreeMap treeMap = new TreeMap();
        eVar.i(j10, false, eVar.f2825h, treeMap);
        eVar.h(j10, map, map2, eVar.f2825h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) this.f2864l.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                f fVar = (f) map2.get(pair.first);
                fVar.getClass();
                a aVar = new a();
                aVar.f7954b = decodeByteArray;
                aVar.f7960h = fVar.f2832b;
                aVar.f7961i = 0;
                aVar.f7957e = fVar.f2833c;
                aVar.f7958f = 0;
                aVar.f7959g = fVar.f2835e;
                aVar.f7964l = fVar.f2836f;
                aVar.f7965m = fVar.f2837g;
                aVar.f7968p = fVar.f2840j;
                arrayList2.add(aVar.a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            f fVar2 = (f) map2.get(entry.getKey());
            fVar2.getClass();
            a aVar2 = (a) entry.getValue();
            CharSequence charSequence = aVar2.f7953a;
            charSequence.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (a aVar3 : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar3), spannableStringBuilder.getSpanEnd(aVar3), "");
            }
            for (int i10 = 0; i10 < spannableStringBuilder.length(); i10++) {
                if (spannableStringBuilder.charAt(i10) == ' ') {
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (i12 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i12) == ' ') {
                        i12++;
                    }
                    int i13 = i12 - i11;
                    if (i13 > 0) {
                        spannableStringBuilder.delete(i10, i13 + i10);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i14 = 0; i14 < spannableStringBuilder.length() - 1; i14++) {
                if (spannableStringBuilder.charAt(i14) == 10) {
                    int i15 = i14 + 1;
                    if (spannableStringBuilder.charAt(i15) == ' ') {
                        spannableStringBuilder.delete(i15, i14 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i16 = 0; i16 < spannableStringBuilder.length() - 1; i16++) {
                if (spannableStringBuilder.charAt(i16) == ' ') {
                    int i17 = i16 + 1;
                    if (spannableStringBuilder.charAt(i17) == 10) {
                        spannableStringBuilder.delete(i16, i17);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            aVar2.f7957e = fVar2.f2833c;
            aVar2.f7958f = fVar2.f2834d;
            aVar2.f7959g = fVar2.f2835e;
            aVar2.f7960h = fVar2.f2832b;
            aVar2.f7964l = fVar2.f2836f;
            aVar2.f7963k = fVar2.f2839i;
            aVar2.f7962j = fVar2.f2838h;
            aVar2.f7968p = fVar2.f2840j;
            arrayList2.add(aVar2.a());
        }
        return arrayList2;
    }

    public final int d() {
        return this.f2861i.length;
    }
}
