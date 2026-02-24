package h5;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a0 {

    /* renamed from: b  reason: collision with root package name */
    public static final Map f7550b;

    /* renamed from: a  reason: collision with root package name */
    public final Map f7551a = f7550b;

    static {
        String property = System.getProperty("http.agent");
        if (!TextUtils.isEmpty(property)) {
            int length = property.length();
            StringBuilder sb2 = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = property.charAt(i10);
                if ((charAt <= 31 && charAt != 9) || charAt >= 127) {
                    charAt = '?';
                }
                sb2.append(charAt);
            }
            property = sb2.toString();
        }
        HashMap hashMap = new HashMap(2);
        if (!TextUtils.isEmpty(property)) {
            hashMap.put("User-Agent", Collections.singletonList(new b0(property)));
        }
        f7550b = Collections.unmodifiableMap(hashMap);
    }
}
