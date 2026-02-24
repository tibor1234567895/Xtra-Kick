package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.h;
import android.text.TextUtils;
import androidx.activity.result.g;
import androidx.activity.result.k;
import b0.c;
import b0.d;
import b0.e;
import c.f;
import e.a;
import e.b;
import java.util.Arrays;
import java.util.HashSet;

public final class i extends g {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f485i;

    public i(ComponentActivity componentActivity) {
        this.f485i = componentActivity;
    }

    public final void b(int i10, b bVar, Intent intent) {
        Bundle bundle;
        String[] strArr;
        ComponentActivity componentActivity = this.f485i;
        a b10 = bVar.b(componentActivity, intent);
        if (b10 != null) {
            new Handler(Looper.getMainLooper()).post(new f((g) this, i10, (Object) b10, 1));
            return;
        }
        Intent a10 = bVar.a(componentActivity, intent);
        if (a10.getExtras() != null && a10.getExtras().getClassLoader() == null) {
            a10.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (a10.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a10.getAction())) {
            String[] stringArrayExtra = a10.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            int i11 = e.f2338b;
            HashSet hashSet = new HashSet();
            int i12 = 0;
            while (i12 < stringArrayExtra.length) {
                if (!TextUtils.isEmpty(stringArrayExtra[i12])) {
                    if (!i0.b.a() && TextUtils.equals(stringArrayExtra[i12], "android.permission.POST_NOTIFICATIONS")) {
                        hashSet.add(Integer.valueOf(i12));
                    }
                    i12++;
                } else {
                    throw new IllegalArgumentException(h.p(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                }
            }
            int size = hashSet.size();
            if (size > 0) {
                strArr = new String[(stringArrayExtra.length - size)];
            } else {
                strArr = stringArrayExtra;
            }
            if (size > 0) {
                if (size != stringArrayExtra.length) {
                    int i13 = 0;
                    for (int i14 = 0; i14 < stringArrayExtra.length; i14++) {
                        if (!hashSet.contains(Integer.valueOf(i14))) {
                            strArr[i13] = stringArrayExtra[i14];
                            i13++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (componentActivity instanceof d) {
                    ((d) componentActivity).getClass();
                }
                b0.b.b(componentActivity, stringArrayExtra, i10);
            } else if (componentActivity instanceof c) {
                new Handler(Looper.getMainLooper()).post(new f(componentActivity, strArr, i10));
            }
        } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a10.getAction())) {
            k kVar = (k) a10.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                IntentSender intentSender = kVar.f521h;
                Intent intent2 = kVar.f522i;
                int i15 = kVar.f523j;
                int i16 = kVar.f524k;
                int i17 = e.f2338b;
                b0.a.c(componentActivity, intentSender, i10, intent2, i15, i16, 0, bundle);
            } catch (IntentSender.SendIntentException e10) {
                new Handler(Looper.getMainLooper()).post(new f((g) this, i10, (Object) e10, 2));
            }
        } else {
            int i18 = e.f2338b;
            b0.a.b(componentActivity, a10, i10, bundle);
        }
    }
}
