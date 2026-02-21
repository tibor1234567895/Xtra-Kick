package qb;

import cb.e;
import fb.f;
import fb.g;
import fb.h;
import fb.l;
import fb.w;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import ma.k0;
import pb.x0;
import xa.j;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final l f13477a = new l("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b  reason: collision with root package name */
    public static final l f13478b = new l(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final x0 a(String str) {
        h hVar;
        h hVar2;
        boolean z10;
        String str2;
        String str3;
        j.f("<this>", str);
        byte[] bArr = f.f13487a;
        l lVar = f13477a;
        j.f("<this>", lVar);
        Matcher matcher = lVar.f6013h.matcher(str);
        j.e("nativePattern.matcher(input)", matcher);
        if (!matcher.find(0)) {
            hVar = null;
        } else {
            hVar = new h(matcher, str);
        }
        if (hVar == null || hVar.b().f3063h != 0) {
            hVar = null;
        }
        if (hVar != null) {
            Locale locale = Locale.ROOT;
            String lowerCase = ((String) ((k0) hVar.a()).get(1)).toLowerCase(locale);
            j.e("this as java.lang.String).toLowerCase(Locale.ROOT)", lowerCase);
            String lowerCase2 = ((String) ((k0) hVar.a()).get(2)).toLowerCase(locale);
            j.e("this as java.lang.String).toLowerCase(Locale.ROOT)", lowerCase2);
            ArrayList arrayList = new ArrayList();
            e b10 = hVar.b();
            while (true) {
                int i10 = b10.f3064i + 1;
                if (i10 < str.length()) {
                    l lVar2 = f13478b;
                    j.f("<this>", lVar2);
                    Matcher matcher2 = lVar2.f6013h.matcher(str);
                    j.e("nativePattern.matcher(input)", matcher2);
                    if (!matcher2.find(i10)) {
                        hVar2 = null;
                    } else {
                        hVar2 = new h(matcher2, str);
                    }
                    if (hVar2 == null || hVar2.b().f3063h != i10) {
                        hVar2 = null;
                    }
                    if (hVar2 != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        f b11 = hVar2.f6006c.b(1);
                        if (b11 != null) {
                            str2 = b11.f6001a;
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            g gVar = hVar2.f6006c;
                            f b12 = gVar.b(2);
                            if (b12 != null) {
                                str3 = b12.f6001a;
                            } else {
                                str3 = null;
                            }
                            if (str3 == null) {
                                f b13 = gVar.b(3);
                                j.c(b13);
                                str3 = b13.f6001a;
                            } else if (w.m(str3, "'", false) && w.f(str3, "'", false) && str3.length() > 2) {
                                str3 = str3.substring(1, str3.length() - 1);
                                j.e("this as java.lang.String…ing(startIndex, endIndex)", str3);
                            }
                            arrayList.add(str2);
                            arrayList.add(str3);
                        }
                        b10 = hVar2.b();
                    } else {
                        StringBuilder sb2 = new StringBuilder("Parameter is not formatted correctly: \"");
                        String substring = str.substring(i10);
                        j.e("this as java.lang.String).substring(startIndex)", substring);
                        sb2.append(substring);
                        sb2.append("\" for: \"");
                        sb2.append(str);
                        sb2.append('\"');
                        throw new IllegalArgumentException(sb2.toString().toString());
                    }
                } else {
                    Object[] array = arrayList.toArray(new String[0]);
                    j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
                    return new x0(str, lowerCase, lowerCase2, (String[]) array);
                }
            }
        } else {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
    }
}
