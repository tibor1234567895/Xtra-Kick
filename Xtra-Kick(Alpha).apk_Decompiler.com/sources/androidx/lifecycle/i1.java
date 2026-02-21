package androidx.lifecycle;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import xa.j;

public final class i1 {
    private i1() {
    }

    public /* synthetic */ i1(int i10) {
        this();
    }

    public static j1 a(Bundle bundle, Bundle bundle2) {
        if (bundle != null) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if ((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj = parcelableArrayList.get(i10);
                    j.d("null cannot be cast to non-null type kotlin.String", obj);
                    linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
                }
                return new j1(linkedHashMap);
            }
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        } else if (bundle2 == null) {
            return new j1();
        } else {
            HashMap hashMap = new HashMap();
            for (String next : bundle2.keySet()) {
                j.e("key", next);
                hashMap.put(next, bundle2.get(next));
            }
            return new j1(hashMap);
        }
    }
}
