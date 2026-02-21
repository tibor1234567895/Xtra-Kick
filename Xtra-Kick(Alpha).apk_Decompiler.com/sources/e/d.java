package e;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import c0.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import ma.i0;
import ma.j0;
import ma.z;
import xa.j;

public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final c f4853a = new c(0);

    public final Intent a(ComponentActivity componentActivity, Intent intent) {
        j.f("context", componentActivity);
        f4853a.getClass();
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) intent);
        j.e("Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)", putExtra);
        return putExtra;
    }

    public final a b(ComponentActivity componentActivity, Intent intent) {
        boolean z10;
        boolean z11;
        String[] strArr = (String[]) intent;
        j.f("context", componentActivity);
        boolean z12 = true;
        if (strArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new a(0, (Object) j0.d());
        }
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (g.a(componentActivity, strArr[i10]) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                z12 = false;
                break;
            }
            i10++;
        }
        if (!z12) {
            return null;
        }
        int a10 = i0.a(strArr.length);
        if (a10 < 16) {
            a10 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
        for (String put : strArr) {
            linkedHashMap.put(put, Boolean.TRUE);
        }
        return new a(0, (Object) linkedHashMap);
    }

    public final Object c(int i10, Intent intent) {
        boolean z10;
        if (i10 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (!(intArrayExtra == null || stringArrayExtra == null)) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i11 : intArrayExtra) {
                    if (i11 == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    arrayList.add(Boolean.valueOf(z10));
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str : stringArrayExtra) {
                    if (str != null) {
                        arrayList2.add(str);
                    }
                }
                return j0.f(z.O(arrayList2, arrayList));
            }
        }
        return j0.d();
    }
}
