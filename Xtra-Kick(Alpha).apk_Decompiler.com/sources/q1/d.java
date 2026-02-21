package q1;

import java.util.ArrayList;

public final class d implements l {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f13148d = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b  reason: collision with root package name */
    public final int f13149b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f13150c = true;

    public static void a(ArrayList arrayList, int i10) {
        int[] iArr = f13148d;
        int i11 = 0;
        while (true) {
            if (i11 >= 7) {
                i11 = -1;
                break;
            } else if (iArr[i11] == i10) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1 && !arrayList.contains(Integer.valueOf(i10))) {
            arrayList.add(Integer.valueOf(i10));
        }
    }
}
