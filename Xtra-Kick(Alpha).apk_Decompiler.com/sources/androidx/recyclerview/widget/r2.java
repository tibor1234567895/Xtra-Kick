package androidx.recyclerview.widget;

import java.util.Arrays;

public final class r2 {

    /* renamed from: a  reason: collision with root package name */
    public int f2188a;

    /* renamed from: b  reason: collision with root package name */
    public int f2189b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2190c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2191d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2192e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f2193f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f2194g;

    public r2(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f2194g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f2188a = -1;
        this.f2189b = RecyclerView.UNDEFINED_DURATION;
        this.f2190c = false;
        this.f2191d = false;
        this.f2192e = false;
        int[] iArr = this.f2193f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
