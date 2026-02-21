package g1;

import android.os.Bundle;
import android.support.v4.media.h;
import j1.a;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Arrays;

public final class v1 implements m {

    /* renamed from: m  reason: collision with root package name */
    public static final String f6670m = l0.C(0);

    /* renamed from: n  reason: collision with root package name */
    public static final String f6671n = l0.C(1);

    /* renamed from: o  reason: collision with root package name */
    public static final a f6672o = new a(23);

    /* renamed from: h  reason: collision with root package name */
    public final int f6673h;

    /* renamed from: i  reason: collision with root package name */
    public final String f6674i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6675j;

    /* renamed from: k  reason: collision with root package name */
    public final a0[] f6676k;

    /* renamed from: l  reason: collision with root package name */
    public int f6677l;

    public v1(String str, a0... a0VarArr) {
        boolean z10;
        String str2;
        String str3;
        String str4;
        int i10 = 1;
        if (a0VarArr.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        this.f6674i = str;
        this.f6676k = a0VarArr;
        this.f6673h = a0VarArr.length;
        int h10 = a1.h(a0VarArr[0].f6276s);
        this.f6675j = h10 == -1 ? a1.h(a0VarArr[0].f6275r) : h10;
        String str5 = a0VarArr[0].f6267j;
        str5 = (str5 == null || str5.equals("und")) ? "" : str5;
        int i11 = a0VarArr[0].f6269l | 16384;
        while (i10 < a0VarArr.length) {
            String str6 = a0VarArr[i10].f6267j;
            if (!str5.equals((str6 == null || str6.equals("und")) ? "" : str6)) {
                str2 = a0VarArr[0].f6267j;
                str3 = a0VarArr[i10].f6267j;
                str4 = "languages";
            } else if (i11 != (a0VarArr[i10].f6269l | 16384)) {
                str2 = Integer.toBinaryString(a0VarArr[0].f6269l);
                str3 = Integer.toBinaryString(a0VarArr[i10].f6269l);
                str4 = "role flags";
            } else {
                i10++;
            }
            v.d("TrackGroup", "", new IllegalStateException("Different " + str4 + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i10 + ")"));
            return;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v1.class != obj.getClass()) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return this.f6674i.equals(v1Var.f6674i) && Arrays.equals(this.f6676k, v1Var.f6676k);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        a0[] a0VarArr = this.f6676k;
        ArrayList arrayList = new ArrayList(a0VarArr.length);
        for (a0 l10 : a0VarArr) {
            arrayList.add(l10.l(true));
        }
        bundle.putParcelableArrayList(f6670m, arrayList);
        bundle.putString(f6671n, this.f6674i);
        return bundle;
    }

    public final int hashCode() {
        if (this.f6677l == 0) {
            this.f6677l = h.e(this.f6674i, 527, 31) + Arrays.hashCode(this.f6676k);
        }
        return this.f6677l;
    }

    public final int i(a0 a0Var) {
        int i10 = 0;
        while (true) {
            a0[] a0VarArr = this.f6676k;
            if (i10 >= a0VarArr.length) {
                return -1;
            }
            if (a0Var == a0VarArr[i10]) {
                return i10;
            }
            i10++;
        }
    }
}
