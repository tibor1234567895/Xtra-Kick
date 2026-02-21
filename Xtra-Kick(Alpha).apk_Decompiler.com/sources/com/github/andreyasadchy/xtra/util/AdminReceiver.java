package com.github.andreyasadchy.xtra.util;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import s7.a;
import xa.j;

public final class AdminReceiver extends DeviceAdminReceiver {
    static {
        new a(0);
    }

    public final void onDisabled(Context context, Intent intent) {
        d1.a aVar;
        j.f("context", context);
        j.f("intent", intent);
        super.onDisabled(context, intent);
        synchronized (d1.a.f4129e) {
            if (d1.a.f4130f == null) {
                d1.a.f4130f = new d1.a(context.getApplicationContext());
            }
            aVar = d1.a.f4130f;
        }
        aVar.a(new Intent("device_admin_action_disabled"));
    }

    public final void onEnabled(Context context, Intent intent) {
        d1.a aVar;
        j.f("context", context);
        j.f("intent", intent);
        super.onEnabled(context, intent);
        synchronized (d1.a.f4129e) {
            if (d1.a.f4130f == null) {
                d1.a.f4130f = new d1.a(context.getApplicationContext());
            }
            aVar = d1.a.f4130f;
        }
        aVar.a(new Intent("device_admin_action_enabled"));
    }
}
