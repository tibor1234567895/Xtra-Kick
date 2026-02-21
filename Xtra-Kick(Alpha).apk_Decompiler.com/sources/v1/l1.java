package v1;

import android.os.Bundle;
import d9.r0;
import d9.r1;
import g1.m;
import g1.v1;
import i1.c;
import j1.l0;
import j1.v;

public final class l1 implements m {

    /* renamed from: k  reason: collision with root package name */
    public static final l1 f15714k = new l1(new v1[0]);

    /* renamed from: l  reason: collision with root package name */
    public static final String f15715l = l0.C(0);

    /* renamed from: h  reason: collision with root package name */
    public final int f15716h;

    /* renamed from: i  reason: collision with root package name */
    public final r1 f15717i;

    /* renamed from: j  reason: collision with root package name */
    public int f15718j;

    static {
        new c(14);
    }

    public l1(v1... v1VarArr) {
        this.f15717i = r0.k(v1VarArr);
        this.f15716h = v1VarArr.length;
        int i10 = 0;
        while (true) {
            r1 r1Var = this.f15717i;
            if (i10 < r1Var.f4660k) {
                int i11 = i10 + 1;
                for (int i12 = i11; i12 < r1Var.f4660k; i12++) {
                    if (((v1) r1Var.get(i10)).equals(r1Var.get(i12))) {
                        v.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                    }
                }
                i10 = i11;
            } else {
                return;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l1.class != obj.getClass()) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.f15716h == l1Var.f15716h && this.f15717i.equals(l1Var.f15717i);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f15715l, j1.c.b(this.f15717i));
        return bundle;
    }

    public final int hashCode() {
        if (this.f15718j == 0) {
            this.f15718j = this.f15717i.hashCode();
        }
        return this.f15718j;
    }

    public final v1 i(int i10) {
        return (v1) this.f15717i.get(i10);
    }

    public final int j(v1 v1Var) {
        int indexOf = this.f15717i.indexOf(v1Var);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }
}
