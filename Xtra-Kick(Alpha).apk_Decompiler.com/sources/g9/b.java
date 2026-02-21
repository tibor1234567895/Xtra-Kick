package g9;

import androidx.recyclerview.widget.RecyclerView;
import c9.v;
import java.util.Arrays;
import java.util.Collection;

public final class b extends c {
    private b() {
    }

    public static int a(long j10) {
        int i10 = (int) j10;
        if (((long) i10) == j10) {
            return i10;
        }
        throw new IllegalArgumentException(v.a("Out of range: %s", Long.valueOf(j10)));
    }

    public static int b(int i10, int i11) {
        boolean z10;
        if (i11 <= 1073741823) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return Math.min(Math.max(i10, i11), 1073741823);
        }
        throw new IllegalArgumentException(v.a("min (%s) must be less than or equal to max (%s)", Integer.valueOf(i11), 1073741823));
    }

    public static int c(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return j10 < -2147483648L ? RecyclerView.UNDEFINED_DURATION : (int) j10;
    }

    public static int[] d(Collection collection) {
        if (collection instanceof a) {
            a aVar = (a) collection;
            return Arrays.copyOfRange(aVar.f6865h, aVar.f6866i, aVar.f6867j);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = array[i10];
            obj.getClass();
            iArr[i10] = ((Number) obj).intValue();
        }
        return iArr;
    }
}
