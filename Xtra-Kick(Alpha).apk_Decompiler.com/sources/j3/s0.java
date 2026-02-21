package j3;

import android.net.Uri;
import fb.w;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import la.i;
import ma.z;
import wa.a;
import xa.j;
import xa.k;

public final class s0 extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8680h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ u0 f8681i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(u0 u0Var, int i10) {
        super(0);
        this.f8680h = i10;
        this.f8681i = u0Var;
    }

    public final Pattern a() {
        int i10 = this.f8680h;
        u0 u0Var = this.f8681i;
        switch (i10) {
            case 2:
                String str = (String) u0Var.f8705l.getValue();
                if (str != null) {
                    return Pattern.compile(str, 2);
                }
                return null;
            case Constants.MAX_COMPATIBILITY_VERSION:
                String str2 = u0Var.f8707n;
                if (str2 != null) {
                    return Pattern.compile(str2);
                }
                return null;
            default:
                String str3 = u0Var.f8698e;
                if (str3 != null) {
                    return Pattern.compile(str3, 2);
                }
                return null;
        }
    }

    public final Object b() {
        boolean z10;
        List list;
        boolean z11 = false;
        int i10 = this.f8680h;
        u0 u0Var = this.f8681i;
        switch (i10) {
            case 0:
                i iVar = (i) u0Var.f8703j.getValue();
                if (iVar == null || (list = (List) iVar.f9799h) == null) {
                    return new ArrayList();
                }
                return list;
            case 1:
                String str = u0Var.f8694a;
                if (str == null || Uri.parse(str).getFragment() == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                String fragment = Uri.parse(str).getFragment();
                StringBuilder sb2 = new StringBuilder();
                j.c(fragment);
                u0.a(fragment, arrayList, sb2);
                String sb3 = sb2.toString();
                j.e("fragRegex.toString()", sb3);
                return new i(arrayList, sb3);
            case 2:
                return a();
            case 3:
                i iVar2 = (i) u0Var.f8703j.getValue();
                if (iVar2 != null) {
                    return (String) iVar2.f9800i;
                }
                return null;
            case 4:
                String str2 = u0Var.f8694a;
                if (!(str2 == null || Uri.parse(str2).getQuery() == null)) {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            case Constants.MAX_COMPATIBILITY_VERSION:
                return a();
            case 6:
                return a();
            default:
                u0Var.getClass();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (((Boolean) u0Var.f8700g.getValue()).booleanValue()) {
                    String str3 = u0Var.f8694a;
                    Uri parse = Uri.parse(str3);
                    for (String next : parse.getQueryParameterNames()) {
                        StringBuilder sb4 = new StringBuilder();
                        List<String> queryParameters = parse.getQueryParameters(next);
                        if (queryParameters.size() <= 1) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            String str4 = (String) z.u(queryParameters);
                            if (str4 == null) {
                                u0Var.f8702i = true;
                                str4 = next;
                            }
                            Matcher matcher = u0.f8693r.matcher(str4);
                            r0 r0Var = new r0();
                            int i11 = 0;
                            while (matcher.find()) {
                                String group = matcher.group(1);
                                j.d("null cannot be cast to non-null type kotlin.String", group);
                                r0Var.f8673b.add(group);
                                j.e("queryParam", str4);
                                String substring = str4.substring(i11, matcher.start());
                                j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                                sb4.append(Pattern.quote(substring));
                                sb4.append("(.+?)?");
                                i11 = matcher.end();
                            }
                            if (i11 < str4.length()) {
                                String substring2 = str4.substring(i11);
                                j.e("this as java.lang.String).substring(startIndex)", substring2);
                                sb4.append(Pattern.quote(substring2));
                            }
                            String sb5 = sb4.toString();
                            j.e("argRegex.toString()", sb5);
                            r0Var.f8672a = w.k(sb5, ".*", "\\E.*\\Q");
                            j.e("paramName", next);
                            linkedHashMap.put(next, r0Var);
                        } else {
                            throw new IllegalArgumentException(("Query parameter " + next + " must only be present once in " + str3 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                        }
                    }
                }
                return linkedHashMap;
        }
    }
}
