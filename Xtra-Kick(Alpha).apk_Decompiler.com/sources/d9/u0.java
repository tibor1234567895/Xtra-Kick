package d9;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public abstract class u0 extends m0 implements Set {

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ int f4677j = 0;

    /* renamed from: i  reason: collision with root package name */
    public transient r0 f4678i;

    public static int h(int i10) {
        int max = Math.max(i10, 2);
        boolean z10 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z10 = false;
        }
        if (z10) {
            return 1073741824;
        }
        throw new IllegalArgumentException("collection too large");
    }

    public static u0 i(int i10, Object... objArr) {
        if (i10 == 0) {
            return x1.f4702q;
        }
        boolean z10 = false;
        if (i10 != 1) {
            int h10 = h(i10);
            Object[] objArr2 = new Object[h10];
            int i11 = h10 - 1;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i12 < i10) {
                Object obj = objArr[i12];
                if (obj != null) {
                    int hashCode = obj.hashCode();
                    int a10 = h0.a(hashCode);
                    while (true) {
                        int i15 = a10 & i11;
                        Object obj2 = objArr2[i15];
                        if (obj2 == null) {
                            objArr[i14] = obj;
                            objArr2[i15] = obj;
                            i13 += hashCode;
                            i14++;
                            break;
                        } else if (obj2.equals(obj)) {
                            break;
                        } else {
                            a10++;
                        }
                    }
                    i12++;
                } else {
                    StringBuilder sb2 = new StringBuilder(20);
                    sb2.append("at index ");
                    sb2.append(i12);
                    throw new NullPointerException(sb2.toString());
                }
            }
            Arrays.fill(objArr, i14, i10, (Object) null);
            if (i14 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                return new g2(obj3);
            } else if (h(i14) < h10 / 2) {
                return i(i14, objArr);
            } else {
                int length = objArr.length;
                if (i14 < (length >> 1) + (length >> 2)) {
                    z10 = true;
                }
                if (z10) {
                    objArr = Arrays.copyOf(objArr, i14);
                }
                return new x1(i13, i11, i14, objArr, objArr2);
            }
        } else {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new g2(obj4);
        }
    }

    public static u0 j(Set set) {
        if ((set instanceof u0) && !(set instanceof SortedSet)) {
            u0 u0Var = (u0) set;
            if (!u0Var.f()) {
                return u0Var;
            }
        }
        Object[] array = set.toArray();
        return i(array.length, array);
    }

    public r0 a() {
        r0 r0Var = this.f4678i;
        if (r0Var != null) {
            return r0Var;
        }
        r0 k10 = k();
        this.f4678i = k10;
        return k10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof u0) && (this instanceof x1)) {
            u0 u0Var = (u0) obj;
            u0Var.getClass();
            if ((u0Var instanceof x1) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        return f2.a(this, obj);
    }

    public int hashCode() {
        return f2.c(this);
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public r0 k() {
        Object[] array = toArray();
        p0 p0Var = r0.f4657i;
        return r0.h(array.length, array);
    }
}
