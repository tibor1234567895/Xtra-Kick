package r1;

import android.net.Uri;
import g1.a0;
import g1.o1;
import g1.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class o extends p {

    /* renamed from: n  reason: collision with root package name */
    public static final o f13610n = new o("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (a0) null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: d  reason: collision with root package name */
    public final List f13611d;

    /* renamed from: e  reason: collision with root package name */
    public final List f13612e;

    /* renamed from: f  reason: collision with root package name */
    public final List f13613f;

    /* renamed from: g  reason: collision with root package name */
    public final List f13614g;

    /* renamed from: h  reason: collision with root package name */
    public final List f13615h;

    /* renamed from: i  reason: collision with root package name */
    public final List f13616i;

    /* renamed from: j  reason: collision with root package name */
    public final a0 f13617j;

    /* renamed from: k  reason: collision with root package name */
    public final List f13618k;

    /* renamed from: l  reason: collision with root package name */
    public final Map f13619l;

    /* renamed from: m  reason: collision with root package name */
    public final List f13620m;

    public o(String str, List list, List list2, List list3, List list4, List list5, List list6, a0 a0Var, List list7, boolean z10, Map map, List list8) {
        super(str, list, z10);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list2.size(); i10++) {
            Uri uri = ((n) list2.get(i10)).f13604a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        b(list6, arrayList);
        this.f13611d = Collections.unmodifiableList(arrayList);
        this.f13612e = Collections.unmodifiableList(list2);
        this.f13613f = Collections.unmodifiableList(list3);
        this.f13614g = Collections.unmodifiableList(list4);
        this.f13615h = Collections.unmodifiableList(list5);
        this.f13616i = Collections.unmodifiableList(list6);
        this.f13617j = a0Var;
        this.f13618k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f13619l = Collections.unmodifiableMap(map);
        this.f13620m = Collections.unmodifiableList(list8);
    }

    public static void b(List list, ArrayList arrayList) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Uri uri = ((m) list.get(i10)).f13601a;
            if (uri != null && !arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
    }

    public static ArrayList c(int i10, List list, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            Object obj = list.get(i11);
            int i12 = 0;
            while (true) {
                if (i12 >= list2.size()) {
                    break;
                }
                o1 o1Var = (o1) list2.get(i12);
                if (o1Var.f6499i == i10 && o1Var.f6500j == i11) {
                    arrayList.add(obj);
                    break;
                }
                i12++;
            }
        }
        return arrayList;
    }

    public static o d(String str) {
        Uri parse = Uri.parse(str);
        z zVar = new z();
        zVar.f6744a = "0";
        zVar.f6753j = "application/x-mpegURL";
        return new o("", Collections.emptyList(), Collections.singletonList(new n(parse, zVar.a(), (String) null, (String) null, (String) null, (String) null)), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (a0) null, (List) null, false, Collections.emptyMap(), Collections.emptyList());
    }

    public final Object a(List list) {
        return new o(this.f13621a, this.f13622b, c(0, this.f13612e, list), Collections.emptyList(), c(1, this.f13614g, list), c(2, this.f13615h, list), Collections.emptyList(), this.f13617j, this.f13618k, this.f13623c, this.f13619l, this.f13620m);
    }
}
