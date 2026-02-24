package androidx.recyclerview.widget;

import java.util.Arrays;
import java.util.List;

public final class v2 {

    /* renamed from: a  reason: collision with root package name */
    public int[] f2222a;

    /* renamed from: b  reason: collision with root package name */
    public List f2223b;

    public final void a() {
        int[] iArr = this.f2222a;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f2223b = null;
    }

    public final void b(int i10) {
        int[] iArr = this.f2222a;
        if (iArr == null) {
            int[] iArr2 = new int[(Math.max(i10, 10) + 1)];
            this.f2222a = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i10 >= iArr.length) {
            int length = iArr.length;
            while (length <= i10) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f2222a = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = this.f2222a;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c(int r6) {
        /*
            r5 = this;
            int[] r0 = r5.f2222a
            r1 = -1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r0.length
            if (r6 < r0) goto L_0x000a
            return r1
        L_0x000a:
            java.util.List r0 = r5.f2223b
            if (r0 != 0) goto L_0x000f
            goto L_0x005e
        L_0x000f:
            r2 = 0
            if (r0 != 0) goto L_0x0013
            goto L_0x002b
        L_0x0013:
            int r0 = r0.size()
            int r0 = r0 + r1
        L_0x0018:
            if (r0 < 0) goto L_0x002b
            java.util.List r3 = r5.f2223b
            java.lang.Object r3 = r3.get(r0)
            androidx.recyclerview.widget.u2 r3 = (androidx.recyclerview.widget.u2) r3
            int r4 = r3.f2210h
            if (r4 != r6) goto L_0x0028
            r2 = r3
            goto L_0x002b
        L_0x0028:
            int r0 = r0 + -1
            goto L_0x0018
        L_0x002b:
            if (r2 == 0) goto L_0x0032
            java.util.List r0 = r5.f2223b
            r0.remove(r2)
        L_0x0032:
            java.util.List r0 = r5.f2223b
            int r0 = r0.size()
            r2 = 0
        L_0x0039:
            if (r2 >= r0) goto L_0x004b
            java.util.List r3 = r5.f2223b
            java.lang.Object r3 = r3.get(r2)
            androidx.recyclerview.widget.u2 r3 = (androidx.recyclerview.widget.u2) r3
            int r3 = r3.f2210h
            if (r3 < r6) goto L_0x0048
            goto L_0x004c
        L_0x0048:
            int r2 = r2 + 1
            goto L_0x0039
        L_0x004b:
            r2 = -1
        L_0x004c:
            if (r2 == r1) goto L_0x005e
            java.util.List r0 = r5.f2223b
            java.lang.Object r0 = r0.get(r2)
            androidx.recyclerview.widget.u2 r0 = (androidx.recyclerview.widget.u2) r0
            java.util.List r3 = r5.f2223b
            r3.remove(r2)
            int r0 = r0.f2210h
            goto L_0x005f
        L_0x005e:
            r0 = -1
        L_0x005f:
            if (r0 != r1) goto L_0x006b
            int[] r0 = r5.f2222a
            int r2 = r0.length
            java.util.Arrays.fill(r0, r6, r2, r1)
            int[] r6 = r5.f2222a
            int r6 = r6.length
            return r6
        L_0x006b:
            int r0 = r0 + 1
            int[] r2 = r5.f2222a
            int r2 = r2.length
            int r0 = java.lang.Math.min(r0, r2)
            int[] r2 = r5.f2222a
            java.util.Arrays.fill(r2, r6, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.v2.c(int):int");
    }

    public final void d(int i10, int i11) {
        int[] iArr = this.f2222a;
        if (iArr != null && i10 < iArr.length) {
            int i12 = i10 + i11;
            b(i12);
            int[] iArr2 = this.f2222a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f2222a, i10, i12, -1);
            List list = this.f2223b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    u2 u2Var = (u2) this.f2223b.get(size);
                    int i13 = u2Var.f2210h;
                    if (i13 >= i10) {
                        u2Var.f2210h = i13 + i11;
                    }
                }
            }
        }
    }

    public final void e(int i10, int i11) {
        int[] iArr = this.f2222a;
        if (iArr != null && i10 < iArr.length) {
            int i12 = i10 + i11;
            b(i12);
            int[] iArr2 = this.f2222a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f2222a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            List list = this.f2223b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    u2 u2Var = (u2) this.f2223b.get(size);
                    int i13 = u2Var.f2210h;
                    if (i13 >= i10) {
                        if (i13 < i12) {
                            this.f2223b.remove(size);
                        } else {
                            u2Var.f2210h = i13 - i11;
                        }
                    }
                }
            }
        }
    }
}
