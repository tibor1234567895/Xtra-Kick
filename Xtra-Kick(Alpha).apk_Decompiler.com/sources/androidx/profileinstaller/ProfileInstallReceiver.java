package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import j1.p;
import java.io.File;
import n.a;
import p3.e;
import p3.h;

public class ProfileInstallReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        File file;
        int i10;
        int i11;
        if (intent != null) {
            String action = intent.getAction();
            if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
                h.b(context, new a(2), new e.a(28, (Object) this), true);
            } else if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                    if ("WRITE_SKIP_FILE".equals(string)) {
                        a aVar = new a(3);
                        e.a aVar2 = new e.a(28, (Object) this);
                        e eVar = h.f12544a;
                        try {
                            h.a(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                            aVar.execute(new p((Object) aVar2, 10, (Object) null, 6));
                        } catch (PackageManager.NameNotFoundException e10) {
                            aVar.execute(new p((Object) aVar2, 7, (Object) e10, 6));
                        }
                    } else if ("DELETE_SKIP_FILE".equals(string)) {
                        e.a aVar3 = new e.a(28, (Object) this);
                        e eVar2 = h.f12544a;
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        new p((Object) aVar3, 11, (Object) null, 6).run();
                    }
                }
            } else if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
                e.a aVar4 = new e.a(28, (Object) this);
                if (Build.VERSION.SDK_INT >= 24) {
                    Process.sendSignal(Process.myPid(), 10);
                    i11 = 12;
                } else {
                    i11 = 13;
                }
                aVar4.t(i11, (Object) null);
            } else if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) && (extras = intent.getExtras()) != null) {
                String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
                e.a aVar5 = new e.a(28, (Object) this);
                if ("DROP_SHADER_CACHE".equals(string2)) {
                    int i12 = Build.VERSION.SDK_INT;
                    if (i12 >= 24) {
                        file = context.createDeviceProtectedStorageContext().getCodeCacheDir();
                    } else if (i12 >= 23) {
                        file = context.getCodeCacheDir();
                    } else {
                        file = context.getCacheDir();
                    }
                    if (p3.a.a(file)) {
                        i10 = 14;
                    } else {
                        i10 = 15;
                    }
                    aVar5.t(i10, (Object) null);
                    return;
                }
                aVar5.t(16, (Object) null);
            }
        }
    }
}
