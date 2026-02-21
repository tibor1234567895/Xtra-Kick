package androidx.recyclerview.widget;

import java.util.Arrays;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public int f2045a;

    /* renamed from: b  reason: collision with root package name */
    public int f2046b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f2047c;

    /* renamed from: d  reason: collision with root package name */
    public int f2048d;

    public final void a(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        } else if (i11 >= 0) {
            int i12 = this.f2048d * 2;
            int[] iArr = this.f2047c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f2047c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i12 >= iArr.length) {
                int[] iArr3 = new int[(i12 * 2)];
                this.f2047c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f2047c;
            iArr4[i12] = i10;
            iArr4[i12 + 1] = i11;
            this.f2048d++;
        } else {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
    }

    public final void b(RecyclerView recyclerView, boolean z10) {
        this.f2048d = 0;
        int[] iArr = this.f2047c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        q1 q1Var = recyclerView.mLayout;
        if (recyclerView.mAdapter != null && q1Var != null && q1Var.f2151p) {
            if (z10) {
                if (!recyclerView.mAdapterHelper.g()) {
                    q1Var.t(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                q1Var.s(this.f2045a, this.f2046b, recyclerView.mState, this);
            }
            int i10 = this.f2048d;
            if (i10 > q1Var.f2152q) {
                q1Var.f2152q = i10;
                q1Var.f2153r = z10;
                recyclerView.mRecycler.o();
            }
        }
    }
}
