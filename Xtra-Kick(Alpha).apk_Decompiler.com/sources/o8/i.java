package o8;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import b4.x;
import m.c0;
import m.i0;
import m.o;
import m.q;
import m8.j;
import y7.a;
import y7.c;

public final class i implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public f f12351h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12352i = false;

    /* renamed from: j  reason: collision with root package name */
    public int f12353j;

    public final void a(o oVar, boolean z10) {
    }

    public final void c(Parcelable parcelable) {
        SparseArray sparseArray;
        if (parcelable instanceof h) {
            f fVar = this.f12351h;
            h hVar = (h) parcelable;
            int i10 = hVar.f12349h;
            int size = fVar.J.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                MenuItem item = fVar.J.getItem(i11);
                if (i10 == item.getItemId()) {
                    fVar.f12336n = i10;
                    fVar.f12337o = i11;
                    item.setChecked(true);
                    break;
                }
                i11++;
            }
            Context context = this.f12351h.getContext();
            j jVar = hVar.f12350i;
            SparseArray sparseArray2 = new SparseArray(jVar.size());
            int i12 = 0;
            while (i12 < jVar.size()) {
                int keyAt = jVar.keyAt(i12);
                c cVar = (c) jVar.valueAt(i12);
                if (cVar != null) {
                    sparseArray2.put(keyAt, new a(context, cVar));
                    i12++;
                } else {
                    throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
                }
            }
            f fVar2 = this.f12351h;
            fVar2.getClass();
            int i13 = 0;
            while (true) {
                int size2 = sparseArray2.size();
                sparseArray = fVar2.f12347y;
                if (i13 >= size2) {
                    break;
                }
                int keyAt2 = sparseArray2.keyAt(i13);
                if (sparseArray.indexOfKey(keyAt2) < 0) {
                    sparseArray.append(keyAt2, (a) sparseArray2.get(keyAt2));
                }
                i13++;
            }
            d[] dVarArr = fVar2.f12335m;
            if (dVarArr != null) {
                for (d dVar : dVarArr) {
                    dVar.setBadge((a) sparseArray.get(dVar.getId()));
                }
            }
        }
    }

    public final void e(boolean z10) {
        boolean z11;
        b4.a aVar;
        if (!this.f12352i) {
            if (z10) {
                this.f12351h.a();
                return;
            }
            f fVar = this.f12351h;
            o oVar = fVar.J;
            if (oVar != null && fVar.f12335m != null) {
                int size = oVar.size();
                if (size != fVar.f12335m.length) {
                    fVar.a();
                    return;
                }
                int i10 = fVar.f12336n;
                for (int i11 = 0; i11 < size; i11++) {
                    MenuItem item = fVar.J.getItem(i11);
                    if (item.isChecked()) {
                        fVar.f12336n = item.getItemId();
                        fVar.f12337o = i11;
                    }
                }
                if (!(i10 == fVar.f12336n || (aVar = fVar.f12330h) == null)) {
                    x.a(fVar, aVar);
                }
                int i12 = fVar.f12334l;
                int size2 = fVar.J.l().size();
                if (i12 != -1 ? i12 != 0 : size2 <= 3) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                for (int i13 = 0; i13 < size; i13++) {
                    fVar.I.f12352i = true;
                    fVar.f12335m[i13].setLabelVisibilityMode(fVar.f12334l);
                    fVar.f12335m[i13].setShifting(z11);
                    fVar.f12335m[i13].b((q) fVar.J.getItem(i13));
                    fVar.I.f12352i = false;
                }
            }
        }
    }

    public final boolean g(q qVar) {
        return false;
    }

    public final int getId() {
        return this.f12353j;
    }

    public final void h(Context context, o oVar) {
        this.f12351h.J = oVar;
    }

    public final boolean i() {
        return false;
    }

    public final Parcelable j() {
        h hVar = new h();
        hVar.f12349h = this.f12351h.getSelectedItemId();
        SparseArray<a> badgeDrawables = this.f12351h.getBadgeDrawables();
        j jVar = new j();
        int i10 = 0;
        while (i10 < badgeDrawables.size()) {
            int keyAt = badgeDrawables.keyAt(i10);
            a valueAt = badgeDrawables.valueAt(i10);
            if (valueAt != null) {
                jVar.put(keyAt, valueAt.f17078l.f17106a);
                i10++;
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        hVar.f12350i = jVar;
        return hVar;
    }

    public final boolean k(i0 i0Var) {
        return false;
    }

    public final boolean m(q qVar) {
        return false;
    }
}
