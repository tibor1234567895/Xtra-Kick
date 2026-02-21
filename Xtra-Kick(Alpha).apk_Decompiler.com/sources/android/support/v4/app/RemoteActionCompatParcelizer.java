package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import d4.c;

public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(c cVar) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(cVar);
    }

    public static void write(RemoteActionCompat remoteActionCompat, c cVar) {
        androidx.core.app.RemoteActionCompatParcelizer.write(remoteActionCompat, cVar);
    }
}
