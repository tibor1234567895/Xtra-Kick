package g1;

import android.net.Uri;
import android.os.Bundle;
import j1.l0;
import java.util.ArrayList;
import java.util.Arrays;

public final class c implements m {

    /* renamed from: n  reason: collision with root package name */
    public static final c f6321n = new c((Object) null, new b[0], 0, -9223372036854775807L, 0);

    /* renamed from: o  reason: collision with root package name */
    public static final b f6322o;

    /* renamed from: p  reason: collision with root package name */
    public static final String f6323p = l0.C(1);

    /* renamed from: q  reason: collision with root package name */
    public static final String f6324q = l0.C(2);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6325r = l0.C(3);

    /* renamed from: s  reason: collision with root package name */
    public static final String f6326s = l0.C(4);

    /* renamed from: t  reason: collision with root package name */
    public static final a f6327t = new a(0);

    /* renamed from: h  reason: collision with root package name */
    public final Object f6328h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6329i;

    /* renamed from: j  reason: collision with root package name */
    public final long f6330j;

    /* renamed from: k  reason: collision with root package name */
    public final long f6331k;

    /* renamed from: l  reason: collision with root package name */
    public final int f6332l;

    /* renamed from: m  reason: collision with root package name */
    public final b[] f6333m;

    static {
        b bVar = new b(0, -1, -1, new int[0], new Uri[0], new long[0], 0, false);
        int[] iArr = bVar.f6303l;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = bVar.f6304m;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        f6322o = new b(bVar.f6299h, 0, bVar.f6301j, copyOf, (Uri[]) Arrays.copyOf(bVar.f6302k, 0), copyOf2, bVar.f6305n, bVar.f6306o);
    }

    public c(Object obj, b[] bVarArr, long j10, long j11, int i10) {
        this.f6328h = obj;
        this.f6330j = j10;
        this.f6331k = j11;
        this.f6329i = bVarArr.length + i10;
        this.f6333m = bVarArr;
        this.f6332l = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return l0.a(this.f6328h, cVar.f6328h) && this.f6329i == cVar.f6329i && this.f6330j == cVar.f6330j && this.f6331k == cVar.f6331k && this.f6332l == cVar.f6332l && Arrays.equals(this.f6333m, cVar.f6333m);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (b h10 : this.f6333m) {
            arrayList.add(h10.h());
        }
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArrayList(f6323p, arrayList);
        }
        long j10 = this.f6330j;
        if (j10 != 0) {
            bundle.putLong(f6324q, j10);
        }
        long j11 = this.f6331k;
        if (j11 != -9223372036854775807L) {
            bundle.putLong(f6325r, j11);
        }
        int i10 = this.f6332l;
        if (i10 != 0) {
            bundle.putInt(f6326s, i10);
        }
        return bundle;
    }

    public final int hashCode() {
        int i10 = this.f6329i * 31;
        Object obj = this.f6328h;
        return ((((((((i10 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f6330j)) * 31) + ((int) this.f6331k)) * 31) + this.f6332l) * 31) + Arrays.hashCode(this.f6333m);
    }

    public final b i(int i10) {
        int i11 = this.f6332l;
        return i10 < i11 ? f6322o : this.f6333m[i10 - i11];
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AdPlaybackState(adsId=");
        sb2.append(this.f6328h);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f6330j);
        sb2.append(", adGroups=[");
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f6333m;
            if (i10 < bVarArr.length) {
                sb2.append("adGroup(timeUs=");
                sb2.append(bVarArr[i10].f6299h);
                sb2.append(", ads=[");
                for (int i11 = 0; i11 < bVarArr[i10].f6303l.length; i11++) {
                    sb2.append("ad(state=");
                    int i12 = bVarArr[i10].f6303l[i11];
                    sb2.append(i12 != 0 ? i12 != 1 ? i12 != 2 ? i12 != 3 ? i12 != 4 ? '?' : '!' : 'P' : 'S' : 'R' : '_');
                    sb2.append(", durationUs=");
                    sb2.append(bVarArr[i10].f6304m[i11]);
                    sb2.append(')');
                    if (i11 < bVarArr[i10].f6303l.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append("])");
                if (i10 < bVarArr.length - 1) {
                    sb2.append(", ");
                }
                i10++;
            } else {
                sb2.append("])");
                return sb2.toString();
            }
        }
    }
}
