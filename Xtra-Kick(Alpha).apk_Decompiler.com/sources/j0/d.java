package j0;

import android.content.Context;
import androidx.appcompat.widget.b0;
import java.util.concurrent.Callable;

public final class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8382a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8383b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f8384c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b0 f8385d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f8386e;

    public /* synthetic */ d(String str, Context context, b0 b0Var, int i10, int i11) {
        this.f8382a = i11;
        this.f8383b = str;
        this.f8384c = context;
        this.f8385d = b0Var;
        this.f8386e = i10;
    }

    public final f a() {
        int i10 = this.f8382a;
        Context context = this.f8384c;
        String str = this.f8383b;
        int i11 = this.f8386e;
        b0 b0Var = this.f8385d;
        switch (i10) {
            case 0:
                return g.a(str, context, b0Var, i11);
            default:
                try {
                    return g.a(str, context, b0Var, i11);
                } catch (Throwable unused) {
                    return new f(-3);
                }
        }
    }

    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f8382a) {
            case 0:
                return a();
            default:
                return a();
        }
    }
}
