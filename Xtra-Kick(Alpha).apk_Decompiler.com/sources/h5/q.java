package h5;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import b5.j;
import b5.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l0.d;
import m5.e;
import v5.b;

public final class q implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7604a = 3;

    /* renamed from: b  reason: collision with root package name */
    public final Object f7605b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f7606c;

    public q(Context context, p pVar) {
        this.f7605b = context.getApplicationContext();
        this.f7606c = pVar;
    }

    public final h0 a(Object obj, int i10, int i11, n nVar) {
        h0 a10;
        int i12 = this.f7604a;
        Object obj2 = this.f7606c;
        Object obj3 = this.f7605b;
        switch (i12) {
            case 0:
                return c((Integer) obj, i10, i11, nVar);
            case 1:
                List list = (List) obj3;
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                j jVar = null;
                for (int i13 = 0; i13 < size; i13++) {
                    i0 i0Var = (i0) list.get(i13);
                    if (i0Var.b(obj) && (a10 = i0Var.a(obj, i10, i11, nVar)) != null) {
                        arrayList.add(a10.f7577c);
                        jVar = a10.f7575a;
                    }
                }
                if (arrayList.isEmpty() || jVar == null) {
                    return null;
                }
                return new h0(jVar, new m0(arrayList, (d) obj2));
            case 2:
                return c((Integer) obj, i10, i11, nVar);
            default:
                Uri uri = (Uri) obj;
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments.size() == 1) {
                    try {
                        int parseInt = Integer.parseInt(uri.getPathSegments().get(0));
                        if (parseInt != 0) {
                            return ((i0) obj2).a(Integer.valueOf(parseInt), i10, i11, nVar);
                        }
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return null;
                        }
                        Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
                        return null;
                    } catch (NumberFormatException e10) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return null;
                        }
                        Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e10);
                        return null;
                    }
                } else if (pathSegments.size() == 2) {
                    List<String> pathSegments2 = uri.getPathSegments();
                    Context context = (Context) obj3;
                    int identifier = context.getResources().getIdentifier(pathSegments2.get(1), pathSegments2.get(0), context.getPackageName());
                    if (identifier != 0) {
                        return ((i0) obj2).a(Integer.valueOf(identifier), i10, i11, nVar);
                    }
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
                    return null;
                } else if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                } else {
                    Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
                    return null;
                }
        }
    }

    public final boolean b(Object obj) {
        int i10 = this.f7604a;
        Object obj2 = this.f7605b;
        switch (i10) {
            case 0:
                Integer num = (Integer) obj;
                return true;
            case 1:
                for (i0 b10 : (List) obj2) {
                    if (b10.b(obj)) {
                        return true;
                    }
                }
                return false;
            case 2:
                Integer num2 = (Integer) obj;
                return true;
            default:
                Uri uri = (Uri) obj;
                if (!"android.resource".equals(uri.getScheme()) || !((Context) obj2).getPackageName().equals(uri.getAuthority())) {
                    return false;
                }
                return true;
        }
    }

    public final h0 c(Integer num, int i10, int i11, n nVar) {
        Uri uri;
        Resources resources;
        int i12 = this.f7604a;
        Object obj = this.f7606c;
        Object obj2 = this.f7605b;
        switch (i12) {
            case 0:
                Resources.Theme theme = (Resources.Theme) nVar.c(e.f10607b);
                if (theme != null) {
                    resources = theme.getResources();
                } else {
                    resources = ((Context) obj2).getResources();
                }
                return new h0(new b(num), new o(theme, resources, (p) obj, num.intValue()));
            default:
                try {
                    uri = Uri.parse("android.resource://" + ((Resources) obj).getResourcePackageName(num.intValue()) + '/' + ((Resources) obj).getResourceTypeName(num.intValue()) + '/' + ((Resources) obj).getResourceEntryName(num.intValue()));
                } catch (Resources.NotFoundException e10) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num, e10);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((i0) obj2).a(uri, i10, i11, nVar);
        }
    }

    public final String toString() {
        switch (this.f7604a) {
            case 1:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((List) this.f7605b).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public q(Context context, i0 i0Var) {
        this.f7605b = context.getApplicationContext();
        this.f7606c = i0Var;
    }

    public q(Resources resources, i0 i0Var) {
        this.f7606c = resources;
        this.f7605b = i0Var;
    }

    public q(ArrayList arrayList, d dVar) {
        this.f7605b = arrayList;
        this.f7606c = dVar;
    }
}
