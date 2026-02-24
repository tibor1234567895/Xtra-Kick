package androidx.recyclerview.widget;

public final class g2 {

    /* renamed from: a  reason: collision with root package name */
    public int f2018a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f2019b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f2020c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f2021d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f2022e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2023f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2024g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2025h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2026i = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2027j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2028k = false;

    /* renamed from: l  reason: collision with root package name */
    public int f2029l;

    /* renamed from: m  reason: collision with root package name */
    public long f2030m;

    /* renamed from: n  reason: collision with root package name */
    public int f2031n;

    public final void a(int i10) {
        if ((this.f2021d & i10) == 0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f2021d));
        }
    }

    public final int b() {
        return this.f2024g ? this.f2019b - this.f2020c : this.f2022e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f2018a + ", mData=null, mItemCount=" + this.f2022e + ", mIsMeasuring=" + this.f2026i + ", mPreviousLayoutItemCount=" + this.f2019b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2020c + ", mStructureChanged=" + this.f2023f + ", mInPreLayout=" + this.f2024g + ", mRunSimpleAnimations=" + this.f2027j + ", mRunPredictiveAnimations=" + this.f2028k + '}';
    }
}
