package h3;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.text.TextUtils;
import androidx.fragment.app.f0;
import g1.m;
import j1.l0;
import java.util.List;

public final class l4 implements m {

    /* renamed from: i  reason: collision with root package name */
    public static final String f7189i = l0.C(0);

    /* renamed from: j  reason: collision with root package name */
    public static final String f7190j = l0.C(1);

    /* renamed from: h  reason: collision with root package name */
    public final k4 f7191h;

    public l4(int i10, int i11, int i12, String str, r rVar, Bundle bundle) {
        str.getClass();
        IBinder asBinder = rVar.asBinder();
        bundle.getClass();
        this.f7191h = new m4(i10, 0, i11, i12, str, "", (ComponentName) null, asBinder, bundle);
    }

    public static boolean i(PackageManager packageManager, String str, ComponentName componentName) {
        ServiceInfo serviceInfo;
        Intent intent = new Intent(str);
        intent.setPackage(componentName.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (queryIntentServices != null) {
            for (int i10 = 0; i10 < queryIntentServices.size(); i10++) {
                ResolveInfo resolveInfo = queryIntentServices.get(i10);
                if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && TextUtils.equals(serviceInfo.name, componentName.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l4)) {
            return false;
        }
        return this.f7191h.equals(((l4) obj).f7191h);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        k4 k4Var = this.f7191h;
        bundle.putInt(f7189i, k4Var instanceof m4 ? 0 : 1);
        bundle.putBundle(f7190j, k4Var.h());
        return bundle;
    }

    public final int hashCode() {
        return this.f7191h.hashCode();
    }

    public final String toString() {
        return this.f7191h.toString();
    }

    public l4(f0 f0Var, ComponentName componentName) {
        int i10;
        int i11;
        PackageManager packageManager = f0Var.getPackageManager();
        try {
            i10 = packageManager.getApplicationInfo(componentName.getPackageName(), 0).uid;
        } catch (PackageManager.NameNotFoundException unused) {
            i10 = -1;
        }
        if (i(packageManager, "androidx.media3.session.MediaLibraryService", componentName)) {
            i11 = 2;
        } else if (i(packageManager, "androidx.media3.session.MediaSessionService", componentName)) {
            i11 = 1;
        } else if (i(packageManager, "android.media.browse.MediaBrowserService", componentName)) {
            i11 = 101;
        } else {
            throw new IllegalArgumentException("Failed to resolve SessionToken for " + componentName + ". Manifest doesn't declare one of either MediaSessionService, MediaLibraryService, MediaBrowserService or MediaBrowserServiceCompat. Use service's full name.");
        }
        if (i11 != 101) {
            this.f7191h = new m4(i10, i11, 0, 0, componentName.getPackageName(), componentName.getClassName(), componentName, (IBinder) null, Bundle.EMPTY);
            return;
        }
        this.f7191h = new n4((MediaSessionCompat$Token) null, i10, 101, componentName, componentName.getPackageName(), Bundle.EMPTY);
    }
}
