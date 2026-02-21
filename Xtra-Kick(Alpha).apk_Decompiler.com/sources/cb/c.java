package cb;

import java.util.NoSuchElementException;
import ma.f0;

public final class c extends f0 {

    /* renamed from: h  reason: collision with root package name */
    public final int f3066h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3067i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3068j;

    /* renamed from: k  reason: collision with root package name */
    public int f3069k;

    public c(int i10, int i11, int i12) {
        this.f3066h = i12;
        this.f3067i = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f3068j = z10;
        this.f3069k = !z10 ? i11 : i10;
    }

    public final int a() {
        int i10 = this.f3069k;
        if (i10 != this.f3067i) {
            this.f3069k = this.f3066h + i10;
        } else if (this.f3068j) {
            this.f3068j = false;
        } else {
            throw new NoSuchElementException();
        }
        return i10;
    }

    public final boolean hasNext() {
        return this.f3068j;
    }
}
