package q9;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import ma.j0;
import org.json.JSONObject;
import p9.c;
import p9.d;
import p9.e;
import p9.f;
import p9.o;
import p9.p;
import p9.q;
import p9.r;
import p9.w;
import p9.x;
import y9.j;

public final class a {
    public static d a(int i10) {
        d.f12635n.getClass();
        return c.a(i10);
    }

    public static f b(int i10) {
        f.O.getClass();
        return e.a(i10);
    }

    public static j c(String str) {
        xa.j.g("jsonString", str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        xa.j.b("json.keys()", keys);
        while (keys.hasNext()) {
            String next = keys.next();
            xa.j.b("it", next);
            String string = jSONObject.getString(next);
            xa.j.b("json.getString(it)", string);
            linkedHashMap.put(next, string);
        }
        return new j(linkedHashMap);
    }

    public static String d(j jVar) {
        xa.j.g("extras", jVar);
        Map map = jVar.f17264h;
        if (map.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : j0.g(map).entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        xa.j.b("json.toString()", jSONObject2);
        return jSONObject2;
    }

    public static LinkedHashMap e(String str) {
        xa.j.g("jsonString", str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        xa.j.b("json.keys()", keys);
        while (keys.hasNext()) {
            String next = keys.next();
            xa.j.b("it", next);
            String string = jSONObject.getString(next);
            xa.j.b("json.getString(it)", string);
            linkedHashMap.put(next, string);
        }
        return linkedHashMap;
    }

    public static p f(int i10) {
        p.f12708n.getClass();
        return o.a(i10);
    }

    public static r g(int i10) {
        r.f12714m.getClass();
        return q.a(i10);
    }

    public static x h(int i10) {
        x.f12743t.getClass();
        return w.a(i10);
    }

    public static String i(Map map) {
        xa.j.g("headerMap", map);
        if (map.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        xa.j.b("json.toString()", jSONObject2);
        return jSONObject2;
    }
}
