package androidx.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import androidx.fragment.app.c1;
import androidx.fragment.app.f0;
import androidx.lifecycle.r;
import androidx.navigation.fragment.NavHostFragment;
import hb.h0;
import j3.j1;
import j3.o2;
import j3.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import la.i;
import ma.j0;
import ma.l;
import t3.d;
import xa.j;

public final /* synthetic */ class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f479a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f480b;

    public /* synthetic */ f(int i10, Object obj) {
        this.f479a = i10;
        this.f480b = obj;
    }

    public final Bundle a() {
        Bundle bundle;
        int i10 = this.f479a;
        Object obj = this.f480b;
        switch (i10) {
            case 0:
                ComponentActivity componentActivity = (ComponentActivity) obj;
                componentActivity.getClass();
                Bundle bundle2 = new Bundle();
                i iVar = componentActivity.f455p;
                iVar.getClass();
                HashMap hashMap = iVar.f511c;
                bundle2.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(hashMap.values()));
                bundle2.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(hashMap.keySet()));
                bundle2.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(iVar.f513e));
                bundle2.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) iVar.f516h.clone());
                bundle2.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", iVar.f509a);
                return bundle2;
            case 1:
                f0 f0Var = (f0) obj;
                int i11 = f0.C;
                do {
                } while (f0.B(f0Var.A()));
                f0Var.f1417y.f(r.ON_STOP);
                return new Bundle();
            case 2:
                return ((c1) obj).W();
            case 3:
                j1 j1Var = (j1) obj;
                j.f("$this_apply", j1Var);
                ArrayList arrayList = new ArrayList();
                Bundle bundle3 = new Bundle();
                for (Map.Entry entry : j0.g(j1Var.f8596u.f8658a).entrySet()) {
                    String str = (String) entry.getKey();
                    Bundle h10 = ((o2) entry.getValue()).h();
                    if (h10 != null) {
                        arrayList.add(str);
                        bundle3.putBundle(str, h10);
                    }
                }
                if (!arrayList.isEmpty()) {
                    bundle = new Bundle();
                    bundle3.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
                    bundle.putBundle("android-support-nav:controller:navigatorState", bundle3);
                } else {
                    bundle = null;
                }
                l lVar = j1Var.f8582g;
                if (!lVar.isEmpty()) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    Parcelable[] parcelableArr = new Parcelable[lVar.f10819j];
                    Iterator it = lVar.iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        parcelableArr[i12] = new u((j3.r) it.next());
                        i12++;
                    }
                    bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
                }
                LinkedHashMap linkedHashMap = j1Var.f8587l;
                if (!linkedHashMap.isEmpty()) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    int[] iArr = new int[linkedHashMap.size()];
                    ArrayList arrayList2 = new ArrayList();
                    int i13 = 0;
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        iArr[i13] = ((Number) entry2.getKey()).intValue();
                        arrayList2.add((String) entry2.getValue());
                        i13++;
                    }
                    bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
                    bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
                }
                LinkedHashMap linkedHashMap2 = j1Var.f8588m;
                if (!linkedHashMap2.isEmpty()) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                        String str2 = (String) entry3.getKey();
                        l lVar2 = (l) entry3.getValue();
                        arrayList3.add(str2);
                        Parcelable[] parcelableArr2 = new Parcelable[lVar2.f10819j];
                        Iterator it2 = lVar2.iterator();
                        int i14 = 0;
                        while (it2.hasNext()) {
                            Object next = it2.next();
                            int i15 = i14 + 1;
                            if (i14 >= 0) {
                                parcelableArr2[i14] = (u) next;
                                i14 = i15;
                            } else {
                                ma.r.h();
                                throw null;
                            }
                        }
                        bundle.putParcelableArray(h.m("android-support-nav:controller:backStackStates:", str2), parcelableArr2);
                    }
                    bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
                }
                if (j1Var.f8581f) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putBoolean("android-support-nav:controller:deepLinkHandled", j1Var.f8581f);
                }
                if (bundle != null) {
                    return bundle;
                }
                Bundle bundle4 = Bundle.EMPTY;
                j.e("EMPTY", bundle4);
                return bundle4;
            default:
                NavHostFragment navHostFragment = (NavHostFragment) obj;
                j.f("this$0", navHostFragment);
                int i16 = navHostFragment.f1873f0;
                if (i16 != 0) {
                    return h0.r(new i("android-support-nav:fragment:graphId", Integer.valueOf(i16)));
                }
                Bundle bundle5 = Bundle.EMPTY;
                j.e("{\n                    Bu…e.EMPTY\n                }", bundle5);
                return bundle5;
        }
    }
}
