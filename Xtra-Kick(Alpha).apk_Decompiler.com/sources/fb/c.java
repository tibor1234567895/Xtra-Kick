package fb;

import java.nio.charset.Charset;
import xa.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f5985a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f5986b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f5987c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f5988d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile Charset f5989e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile Charset f5990f;

    static {
        Charset forName = Charset.forName("UTF-8");
        j.e("forName(\"UTF-8\")", forName);
        f5986b = forName;
        j.e("forName(\"UTF-16\")", Charset.forName("UTF-16"));
        Charset forName2 = Charset.forName("UTF-16BE");
        j.e("forName(\"UTF-16BE\")", forName2);
        f5987c = forName2;
        Charset forName3 = Charset.forName("UTF-16LE");
        j.e("forName(\"UTF-16LE\")", forName3);
        f5988d = forName3;
        j.e("forName(\"US-ASCII\")", Charset.forName("US-ASCII"));
        j.e("forName(\"ISO-8859-1\")", Charset.forName("ISO-8859-1"));
    }

    private c() {
    }
}
