package f3;

import androidx.recyclerview.widget.RecyclerView;

public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f5627a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5628b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5629c;

    /* renamed from: d  reason: collision with root package name */
    public int f5630d;

    /* renamed from: e  reason: collision with root package name */
    public String f5631e;

    public j0(int i10, int i11) {
        this(RecyclerView.UNDEFINED_DURATION, i10, i11);
    }

    public final void a() {
        int i10 = this.f5630d;
        this.f5630d = i10 == Integer.MIN_VALUE ? this.f5628b : i10 + this.f5629c;
        this.f5631e = this.f5627a + this.f5630d;
    }

    public final void b() {
        if (this.f5630d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public j0(int i10, int i11, int i12) {
        String str;
        if (i10 != Integer.MIN_VALUE) {
            str = i10 + Constants.LIST_SEPARATOR;
        } else {
            str = "";
        }
        this.f5627a = str;
        this.f5628b = i11;
        this.f5629c = i12;
        this.f5630d = RecyclerView.UNDEFINED_DURATION;
        this.f5631e = "";
    }
}
