package u;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import s.j;
import v.i;
import v.p;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public HashSet f15071a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f15072b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15073c;

    /* renamed from: d  reason: collision with root package name */
    public final f f15074d;

    /* renamed from: e  reason: collision with root package name */
    public final d f15075e;

    /* renamed from: f  reason: collision with root package name */
    public e f15076f;

    /* renamed from: g  reason: collision with root package name */
    public int f15077g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f15078h = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: i  reason: collision with root package name */
    public j f15079i;

    public e(f fVar, d dVar) {
        this.f15074d = fVar;
        this.f15075e = dVar;
    }

    public final void a(e eVar, int i10) {
        b(eVar, i10, RecyclerView.UNDEFINED_DURATION, false);
    }

    public final boolean b(e eVar, int i10, int i11, boolean z10) {
        if (eVar == null) {
            j();
            return true;
        } else if (!z10 && !i(eVar)) {
            return false;
        } else {
            this.f15076f = eVar;
            if (eVar.f15071a == null) {
                eVar.f15071a = new HashSet();
            }
            HashSet hashSet = this.f15076f.f15071a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.f15077g = i10;
            this.f15078h = i11;
            return true;
        }
    }

    public final void c(int i10, p pVar, ArrayList arrayList) {
        HashSet hashSet = this.f15071a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                i.a(((e) it.next()).f15074d, i10, arrayList, pVar);
            }
        }
    }

    public final int d() {
        if (!this.f15073c) {
            return 0;
        }
        return this.f15072b;
    }

    public final int e() {
        e eVar;
        if (this.f15074d.f15095h0 == 8) {
            return 0;
        }
        int i10 = this.f15078h;
        if (i10 == Integer.MIN_VALUE || (eVar = this.f15076f) == null || eVar.f15074d.f15095h0 != 8) {
            return this.f15077g;
        }
        return i10;
    }

    public final e f() {
        d dVar = this.f15075e;
        int ordinal = dVar.ordinal();
        f fVar = this.f15074d;
        switch (ordinal) {
            case 0:
            case Constants.MAX_COMPATIBILITY_VERSION:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return fVar.L;
            case 2:
                return fVar.M;
            case 3:
                return fVar.J;
            case 4:
                return fVar.K;
            default:
                throw new AssertionError(dVar.name());
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f15071a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f15076f != null;
    }

    public final boolean i(e eVar) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (eVar == null) {
            return false;
        }
        d dVar = d.BASELINE;
        d dVar2 = this.f15075e;
        f fVar = eVar.f15074d;
        d dVar3 = eVar.f15075e;
        if (dVar3 != dVar2) {
            int ordinal = dVar2.ordinal();
            d dVar4 = d.CENTER_Y;
            d dVar5 = d.RIGHT;
            d dVar6 = d.CENTER_X;
            d dVar7 = d.LEFT;
            switch (ordinal) {
                case 0:
                case 7:
                case 8:
                    return false;
                case 1:
                case 3:
                    if (dVar3 == dVar7 || dVar3 == dVar5) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!(fVar instanceof j)) {
                        return z10;
                    }
                    if (z10 || dVar3 == dVar6) {
                        z12 = true;
                    }
                    return z12;
                case 2:
                case 4:
                    if (dVar3 == d.TOP || dVar3 == d.BOTTOM) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!(fVar instanceof j)) {
                        return z11;
                    }
                    if (z11 || dVar3 == dVar4) {
                        z12 = true;
                    }
                    return z12;
                case Constants.MAX_COMPATIBILITY_VERSION:
                    if (dVar3 == dVar7 || dVar3 == dVar5) {
                        return false;
                    }
                    return true;
                case 6:
                    if (dVar3 == dVar || dVar3 == dVar6 || dVar3 == dVar4) {
                        return false;
                    }
                    return true;
                default:
                    throw new AssertionError(dVar2.name());
            }
        } else if (dVar2 != dVar || (fVar.F && this.f15074d.F)) {
            return true;
        } else {
            return false;
        }
    }

    public final void j() {
        HashSet hashSet;
        e eVar = this.f15076f;
        if (!(eVar == null || (hashSet = eVar.f15071a) == null)) {
            hashSet.remove(this);
            if (this.f15076f.f15071a.size() == 0) {
                this.f15076f.f15071a = null;
            }
        }
        this.f15071a = null;
        this.f15076f = null;
        this.f15077g = 0;
        this.f15078h = RecyclerView.UNDEFINED_DURATION;
        this.f15073c = false;
        this.f15072b = 0;
    }

    public final void k() {
        j jVar = this.f15079i;
        if (jVar == null) {
            this.f15079i = new j(1);
        } else {
            jVar.c();
        }
    }

    public final void l(int i10) {
        this.f15072b = i10;
        this.f15073c = true;
    }

    public final String toString() {
        return this.f15074d.f15097i0 + Constants.EXT_TAG_END + this.f15075e.toString();
    }
}
