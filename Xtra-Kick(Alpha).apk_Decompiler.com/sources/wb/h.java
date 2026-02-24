package wb;

import dc.n;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import xa.j;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f16252a = new h();

    /* renamed from: b  reason: collision with root package name */
    public static final e[] f16253b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map f16254c;

    static {
        e eVar = new e(e.f16209i, "");
        n nVar = e.f16206f;
        n nVar2 = e.f16207g;
        n nVar3 = e.f16208h;
        n nVar4 = e.f16205e;
        e[] eVarArr = {eVar, new e(nVar, "GET"), new e(nVar, "POST"), new e(nVar2, (String) Constants.LIST_SEPARATOR), new e(nVar2, "/index.html"), new e(nVar3, "http"), new e(nVar3, "https"), new e(nVar4, "200"), new e(nVar4, "204"), new e(nVar4, "206"), new e(nVar4, "304"), new e(nVar4, "400"), new e(nVar4, "404"), new e(nVar4, "500"), new e("accept-charset", ""), new e("accept-encoding", "gzip, deflate"), new e("accept-language", ""), new e("accept-ranges", ""), new e("accept", ""), new e("access-control-allow-origin", ""), new e("age", ""), new e("allow", ""), new e("authorization", ""), new e("cache-control", ""), new e("content-disposition", ""), new e("content-encoding", ""), new e("content-language", ""), new e("content-length", ""), new e("content-location", ""), new e("content-range", ""), new e("content-type", ""), new e("cookie", ""), new e("date", ""), new e("etag", ""), new e("expect", ""), new e("expires", ""), new e("from", ""), new e("host", ""), new e("if-match", ""), new e("if-modified-since", ""), new e("if-none-match", ""), new e("if-range", ""), new e("if-unmodified-since", ""), new e("last-modified", ""), new e("link", ""), new e("location", ""), new e("max-forwards", ""), new e("proxy-authenticate", ""), new e("proxy-authorization", ""), new e("range", ""), new e("referer", ""), new e("refresh", ""), new e("retry-after", ""), new e("server", ""), new e("set-cookie", ""), new e("strict-transport-security", ""), new e("transfer-encoding", ""), new e("user-agent", ""), new e("vary", ""), new e("via", ""), new e("www-authenticate", "")};
        f16253b = eVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(eVarArr.length);
        int length = eVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!linkedHashMap.containsKey(eVarArr[i10].f16210a)) {
                linkedHashMap.put(eVarArr[i10].f16210a, Integer.valueOf(i10));
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        j.e("unmodifiableMap(result)", unmodifiableMap);
        f16254c = unmodifiableMap;
    }

    private h() {
    }

    public static void a(n nVar) {
        boolean z10;
        j.f("name", nVar);
        int d10 = nVar.d();
        int i10 = 0;
        while (i10 < d10) {
            byte b10 = (byte) 65;
            byte b11 = (byte) 90;
            byte i11 = nVar.i(i10);
            if (b10 > i11 || i11 > b11) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                i10++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(nVar.q()));
            }
        }
    }
}
