package c3;

import java.util.Map;

public final class g {
    private g() {
    }

    public static h a(h hVar, String[] strArr, Map map) {
        int i10 = 0;
        if (hVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (h) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                h hVar2 = new h();
                int length = strArr.length;
                while (i10 < length) {
                    hVar2.a((h) map.get(strArr[i10]));
                    i10++;
                }
                return hVar2;
            }
        } else if (strArr != null && strArr.length == 1) {
            hVar.a((h) map.get(strArr[0]));
            return hVar;
        } else if (strArr != null && strArr.length > 1) {
            int length2 = strArr.length;
            while (i10 < length2) {
                hVar.a((h) map.get(strArr[i10]));
                i10++;
            }
        }
        return hVar;
    }
}
