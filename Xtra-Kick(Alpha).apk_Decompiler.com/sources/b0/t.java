package b0;

import android.app.Notification;
import android.os.Bundle;

public final class t {
    private t() {
    }

    public static Notification.Builder a(Notification.Builder builder, Bundle bundle) {
        return builder.setExtras(bundle);
    }
}
