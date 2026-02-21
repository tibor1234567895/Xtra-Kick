package pb;

import fb.l;
import fb.y;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import qb.f;
import xa.j;

public final class t0 {

    /* renamed from: k  reason: collision with root package name */
    public static final s0 f12987k = new s0(0);

    /* renamed from: l  reason: collision with root package name */
    public static final char[] f12988l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public final String f12989a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12990b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12991c;

    /* renamed from: d  reason: collision with root package name */
    public final String f12992d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12993e;

    /* renamed from: f  reason: collision with root package name */
    public final List f12994f;

    /* renamed from: g  reason: collision with root package name */
    public final List f12995g;

    /* renamed from: h  reason: collision with root package name */
    public final String f12996h;

    /* renamed from: i  reason: collision with root package name */
    public final String f12997i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f12998j;

    public t0(String str, String str2, String str3, String str4, int i10, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        this.f12989a = str;
        this.f12990b = str2;
        this.f12991c = str3;
        this.f12992d = str4;
        this.f12993e = i10;
        this.f12994f = arrayList;
        this.f12995g = arrayList2;
        this.f12996h = str5;
        this.f12997i = str6;
        this.f12998j = j.a(str, "https");
    }

    public final String a() {
        if (this.f12991c.length() == 0) {
            return "";
        }
        String str = this.f12997i;
        String substring = str.substring(y.t(str, ':', this.f12989a.length() + 3, false, 4) + 1, y.t(str, '@', 0, false, 6));
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public final String b() {
        String str = this.f12997i;
        int t10 = y.t(str, '/', this.f12989a.length() + 3, false, 4);
        String substring = str.substring(t10, f.c(t10, str.length(), str, "?#"));
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public final ArrayList c() {
        String str = this.f12997i;
        int t10 = y.t(str, '/', this.f12989a.length() + 3, false, 4);
        int c10 = f.c(t10, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (t10 < c10) {
            int i10 = t10 + 1;
            int d10 = f.d(str, '/', i10, c10);
            String substring = str.substring(i10, d10);
            j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
            arrayList.add(substring);
            t10 = d10;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f12995g == null) {
            return null;
        }
        String str = this.f12997i;
        int t10 = y.t(str, '?', 0, false, 6) + 1;
        String substring = str.substring(t10, f.d(str, '#', t10, str.length()));
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public final String e() {
        if (this.f12990b.length() == 0) {
            return "";
        }
        int length = this.f12989a.length() + 3;
        String str = this.f12997i;
        String substring = str.substring(length, f.c(length, str.length(), str, ":@"));
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof t0) && j.a(((t0) obj).f12997i, this.f12997i);
    }

    public final String f() {
        return this.f12992d;
    }

    public final String g() {
        r0 r0Var;
        try {
            r0Var = new r0();
            r0Var.c(this, "/...");
        } catch (IllegalArgumentException unused) {
            r0Var = null;
        }
        j.c(r0Var);
        s0 s0Var = f12987k;
        r0Var.f12954b = s0.a(s0Var, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251);
        r0Var.f12955c = s0.a(s0Var, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251);
        return r0Var.a().f12997i;
    }

    public final t0 h(String str) {
        r0 r0Var;
        j.f("link", str);
        try {
            r0Var = new r0();
            r0Var.c(this, str);
        } catch (IllegalArgumentException unused) {
            r0Var = null;
        }
        if (r0Var != null) {
            return r0Var.a();
        }
        return null;
    }

    public final int hashCode() {
        return this.f12997i.hashCode();
    }

    public final URI i() {
        String str;
        String str2;
        String str3;
        r0 r0Var = new r0();
        String str4 = this.f12989a;
        r0Var.f12953a = str4;
        r0Var.f12954b = e();
        r0Var.f12955c = a();
        r0Var.f12956d = this.f12992d;
        f12987k.getClass();
        int b10 = s0.b(str4);
        int i10 = this.f12993e;
        if (i10 == b10) {
            i10 = -1;
        }
        r0Var.f12957e = i10;
        ArrayList arrayList = r0Var.f12958f;
        arrayList.clear();
        arrayList.addAll(c());
        r0Var.b(d());
        String str5 = null;
        if (this.f12996h == null) {
            str = null;
        } else {
            String str6 = this.f12997i;
            str = str6.substring(y.t(str6, '#', 0, false, 6) + 1);
            j.e("this as java.lang.String).substring(startIndex)", str);
        }
        r0Var.f12960h = str;
        String str7 = r0Var.f12956d;
        if (str7 != null) {
            str2 = new l("[\"<>^`{|}]").f6013h.matcher(str7).replaceAll("");
            j.e("nativePattern.matcher(in…).replaceAll(replacement)", str2);
        } else {
            str2 = null;
        }
        r0Var.f12956d = str2;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.set(i11, s0.a(f12987k, (String) arrayList.get(i11), 0, 0, "[]", true, true, false, false, (Charset) null, 227));
        }
        ArrayList arrayList2 = r0Var.f12959g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                String str8 = (String) arrayList2.get(i12);
                if (str8 != null) {
                    str3 = s0.a(f12987k, str8, 0, 0, "\\^`{|}", true, true, true, false, (Charset) null, 195);
                } else {
                    str3 = null;
                }
                arrayList2.set(i12, str3);
            }
        }
        String str9 = r0Var.f12960h;
        if (str9 != null) {
            str5 = s0.a(f12987k, str9, 0, 0, " \"#<>\\^`{|}", true, true, false, true, (Charset) null, 163);
        }
        r0Var.f12960h = str5;
        String r0Var2 = r0Var.toString();
        try {
            return new URI(r0Var2);
        } catch (URISyntaxException e10) {
            try {
                String replaceAll = new l("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").f6013h.matcher(r0Var2).replaceAll("");
                j.e("nativePattern.matcher(in…).replaceAll(replacement)", replaceAll);
                URI create = URI.create(replaceAll);
                j.e("{\n      // Unlikely edge…Unexpected!\n      }\n    }", create);
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final String toString() {
        return this.f12997i;
    }
}
