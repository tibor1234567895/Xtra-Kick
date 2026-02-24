package z1;

import a2.j;
import android.os.SystemClock;

public final class w {
    private w() {
    }

    public static j a(s sVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = sVar.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (sVar.b(i11, elapsedRealtime)) {
                i10++;
            }
        }
        return new j(1, 0, length, i10);
    }
}
