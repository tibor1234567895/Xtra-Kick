package g9;

import c9.q;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class a extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final int[] f6865h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6866i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6867j;

    public a(int i10, int i11, int[] iArr) {
        this.f6865h = iArr;
        this.f6866i = i10;
        this.f6867j = i11;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i10 = this.f6866i;
            while (true) {
                if (i10 >= this.f6867j) {
                    i10 = -1;
                    break;
                } else if (this.f6865h[i10] == intValue) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 != -1) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return super.equals(obj);
        }
        a aVar = (a) obj;
        int i10 = this.f6867j;
        int i11 = this.f6866i;
        int i12 = i10 - i11;
        if (aVar.f6867j - aVar.f6866i != i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (this.f6865h[i11 + i13] != aVar.f6865h[aVar.f6866i + i13]) {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i10) {
        int i11 = this.f6867j;
        int i12 = this.f6866i;
        q.b(i10, i11 - i12);
        return Integer.valueOf(this.f6865h[i12 + i10]);
    }

    public final int hashCode() {
        int i10 = 1;
        for (int i11 = this.f6866i; i11 < this.f6867j; i11++) {
            i10 = (i10 * 31) + this.f6865h[i11];
        }
        return i10;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i10 = this.f6866i;
            int i11 = i10;
            while (true) {
                if (i11 >= this.f6867j) {
                    i11 = -1;
                    break;
                } else if (this.f6865h[i11] == intValue) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 >= 0) {
                return i11 - i10;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final int lastIndexOf(Object obj) {
        int i10;
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i11 = this.f6867j - 1;
            while (true) {
                i10 = this.f6866i;
                if (i11 < i10) {
                    i11 = -1;
                    break;
                } else if (this.f6865h[i11] == intValue) {
                    break;
                } else {
                    i11--;
                }
            }
            if (i11 >= 0) {
                return i11 - i10;
            }
        }
        return -1;
    }

    public final Object set(int i10, Object obj) {
        Integer num = (Integer) obj;
        int i11 = this.f6867j;
        int i12 = this.f6866i;
        q.b(i10, i11 - i12);
        int i13 = i12 + i10;
        int[] iArr = this.f6865h;
        int i14 = iArr[i13];
        num.getClass();
        iArr[i13] = num.intValue();
        return Integer.valueOf(i14);
    }

    public final int size() {
        return this.f6867j - this.f6866i;
    }

    public final List subList(int i10, int i11) {
        int i12 = this.f6867j;
        int i13 = this.f6866i;
        q.e(i10, i11, i12 - i13);
        if (i10 == i11) {
            return Collections.emptyList();
        }
        return new a(i10 + i13, i13 + i11, this.f6865h);
    }

    public final String toString() {
        int i10 = this.f6867j;
        int i11 = this.f6866i;
        StringBuilder sb2 = new StringBuilder((i10 - i11) * 5);
        sb2.append('[');
        int[] iArr = this.f6865h;
        int i12 = iArr[i11];
        while (true) {
            sb2.append(i12);
            i11++;
            if (i11 < i10) {
                sb2.append(", ");
                i12 = iArr[i11];
            } else {
                sb2.append(']');
                return sb2.toString();
            }
        }
    }
}
