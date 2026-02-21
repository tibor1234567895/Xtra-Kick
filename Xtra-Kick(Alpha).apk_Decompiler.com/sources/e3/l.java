package e3;

import android.graphics.Bitmap;
import android.text.Layout;
import i1.b;
import j1.a;
import j1.l0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import w2.d;

public final class l implements d {

    /* renamed from: h  reason: collision with root package name */
    public final List f5038h;

    /* renamed from: i  reason: collision with root package name */
    public final long[] f5039i;

    /* renamed from: j  reason: collision with root package name */
    public final long[] f5040j;

    public l(ArrayList arrayList) {
        this.f5038h = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f5039i = new long[(arrayList.size() * 2)];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            d dVar = (d) arrayList.get(i10);
            int i11 = i10 * 2;
            long[] jArr = this.f5039i;
            jArr[i11] = dVar.f5009b;
            jArr[i11 + 1] = dVar.f5010c;
        }
        long[] jArr2 = this.f5039i;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f5040j = copyOf;
        Arrays.sort(copyOf);
    }

    public final int a(long j10) {
        long[] jArr = this.f5040j;
        int b10 = l0.b(jArr, j10, false);
        if (b10 < jArr.length) {
            return b10;
        }
        return -1;
    }

    public final long b(int i10) {
        boolean z10 = true;
        a.b(i10 >= 0);
        long[] jArr = this.f5040j;
        if (i10 >= jArr.length) {
            z10 = false;
        }
        a.b(z10);
        return jArr[i10];
    }

    public final List c(long j10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            List list = this.f5038h;
            if (i11 >= list.size()) {
                break;
            }
            int i12 = i11 * 2;
            long[] jArr = this.f5039i;
            if (jArr[i12] <= j10 && j10 < jArr[i12 + 1]) {
                d dVar = (d) list.get(i11);
                b bVar = dVar.f5008a;
                if (bVar.f7976l == -3.4028235E38f) {
                    arrayList2.add(dVar);
                } else {
                    arrayList.add(bVar);
                }
            }
            i11++;
        }
        Collections.sort(arrayList2, new j0.a(18));
        while (i10 < arrayList2.size()) {
            b bVar2 = ((d) arrayList2.get(i10)).f5008a;
            bVar2.getClass();
            CharSequence charSequence = bVar2.f7972h;
            Bitmap bitmap = bVar2.f7975k;
            Layout.Alignment alignment = bVar2.f7973i;
            Layout.Alignment alignment2 = bVar2.f7974j;
            int i13 = bVar2.f7978n;
            float f10 = bVar2.f7979o;
            int i14 = bVar2.f7980p;
            int i15 = bVar2.f7985u;
            float f11 = bVar2.f7986v;
            float f12 = bVar2.f7981q;
            float f13 = bVar2.f7982r;
            boolean z10 = bVar2.f7983s;
            int i16 = bVar2.f7984t;
            float f14 = f12;
            float f15 = (float) (-1 - i10);
            b bVar3 = r5;
            boolean z11 = z10;
            b bVar4 = new b(charSequence, alignment, alignment2, bitmap, f15, 1, i13, f10, i14, i15, f11, f14, f13, z11, i16, bVar2.f7987w, bVar2.f7988x);
            arrayList.add(bVar3);
            i10++;
        }
        return arrayList;
    }

    public final int d() {
        return this.f5040j.length;
    }
}
