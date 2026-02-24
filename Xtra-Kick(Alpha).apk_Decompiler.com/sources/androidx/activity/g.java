package androidx.activity;

import android.os.Bundle;
import androidx.fragment.app.c0;
import androidx.fragment.app.e0;
import androidx.fragment.app.f0;
import d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public final /* synthetic */ class g implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f481a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f482b;

    public /* synthetic */ g(ComponentActivity componentActivity, int i10) {
        this.f481a = i10;
        this.f482b = componentActivity;
    }

    public final void a() {
        int i10 = this.f481a;
        ComponentActivity componentActivity = this.f482b;
        switch (i10) {
            case 0:
                Bundle a10 = componentActivity.f451l.f14540b.a("android:support:activity-result");
                if (a10 != null) {
                    i iVar = componentActivity.f455p;
                    iVar.getClass();
                    ArrayList<Integer> integerArrayList = a10.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = a10.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList != null && integerArrayList != null) {
                        iVar.f513e = a10.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                        iVar.f509a = (Random) a10.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                        Bundle bundle = a10.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                        Bundle bundle2 = iVar.f516h;
                        bundle2.putAll(bundle);
                        for (int i11 = 0; i11 < stringArrayList.size(); i11++) {
                            String str = stringArrayList.get(i11);
                            HashMap hashMap = iVar.f511c;
                            boolean containsKey = hashMap.containsKey(str);
                            HashMap hashMap2 = iVar.f510b;
                            if (containsKey) {
                                Integer num = (Integer) hashMap.remove(str);
                                if (!bundle2.containsKey(str)) {
                                    hashMap2.remove(num);
                                }
                            }
                            int intValue = integerArrayList.get(i11).intValue();
                            String str2 = stringArrayList.get(i11);
                            hashMap2.put(Integer.valueOf(intValue), str2);
                            hashMap.put(str2, Integer.valueOf(intValue));
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                e0 e0Var = (e0) ((f0) componentActivity).f1416x.f1532i;
                e0Var.f1405k.b(e0Var, e0Var, (c0) null);
                return;
        }
    }
}
