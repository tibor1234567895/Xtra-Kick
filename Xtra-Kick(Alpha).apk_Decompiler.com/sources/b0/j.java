package b0;

import android.os.Bundle;
import android.os.IBinder;

public final class j {
    private j() {
    }

    public static IBinder a(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    public static void b(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
