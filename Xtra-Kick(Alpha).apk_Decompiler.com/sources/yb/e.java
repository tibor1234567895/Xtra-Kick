package yb;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import ma.j0;
import pb.f1;
import sb.g;
import wb.i;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f17302a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final CopyOnWriteArraySet f17303b = new CopyOnWriteArraySet();

    /* renamed from: c  reason: collision with root package name */
    public static final Map f17304c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<f1> cls = f1.class;
        Package packageR = cls.getPackage();
        String name = packageR != null ? packageR.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(cls.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(i.class.getName(), "okhttp.Http2");
        linkedHashMap.put(g.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f17304c = j0.g(linkedHashMap);
    }

    private e() {
    }
}
