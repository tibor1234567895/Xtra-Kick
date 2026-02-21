package s;

import l0.d;

public class f implements d {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13949h;

    /* renamed from: i  reason: collision with root package name */
    public final Object[] f13950i;

    /* renamed from: j  reason: collision with root package name */
    public int f13951j;

    public f(int i10, int i11) {
        this.f13949h = i11;
        if (i11 != 1) {
            if (i10 > 0) {
                this.f13950i = new Object[i10];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        } else if (i10 > 0) {
            this.f13950i = new Object[i10];
        } else {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
    }

    public boolean e(Object obj) {
        int i10;
        boolean z10;
        int i11 = this.f13949h;
        Object[] objArr = this.f13950i;
        switch (i11) {
            case 0:
                int i12 = this.f13951j;
                if (i12 >= objArr.length) {
                    return false;
                }
                objArr[i12] = obj;
                this.f13951j = i12 + 1;
                return true;
            default:
                int i13 = 0;
                while (true) {
                    i10 = this.f13951j;
                    if (i13 >= i10) {
                        z10 = false;
                    } else if (objArr[i13] == obj) {
                        z10 = true;
                    } else {
                        i13++;
                    }
                }
                if (z10) {
                    throw new IllegalStateException("Already in the pool!");
                } else if (i10 >= objArr.length) {
                    return false;
                } else {
                    objArr[i10] = obj;
                    this.f13951j = i10 + 1;
                    return true;
                }
        }
    }

    public Object j() {
        int i10 = this.f13949h;
        Object[] objArr = this.f13950i;
        switch (i10) {
            case 0:
                int i11 = this.f13951j;
                if (i11 <= 0) {
                    return null;
                }
                int i12 = i11 - 1;
                Object obj = objArr[i12];
                objArr[i12] = null;
                this.f13951j = i12;
                return obj;
            default:
                int i13 = this.f13951j;
                if (i13 <= 0) {
                    return null;
                }
                int i14 = i13 - 1;
                Object obj2 = objArr[i14];
                objArr[i14] = null;
                this.f13951j = i14;
                return obj2;
        }
    }
}
