package c0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public final class a {
    private a() {
    }

    public static void a(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
    }

    public static void b(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
