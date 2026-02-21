package j4;

import java.util.LinkedHashSet;
import ma.i0;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    public static final LinkedHashSet f8772a;

    static {
        String[] strArr = {"image/jpeg", "image/webp", "image/heic", "image/heif"};
        LinkedHashSet linkedHashSet = new LinkedHashSet(i0.a(4));
        for (int i10 = 0; i10 < 4; i10++) {
            linkedHashSet.add(strArr[i10]);
        }
        f8772a = linkedHashSet;
    }
}
