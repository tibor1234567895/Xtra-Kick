package d5;

import android.util.Log;
import b5.a;
import b5.j;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class i0 extends Exception {

    /* renamed from: m  reason: collision with root package name */
    public static final StackTraceElement[] f4410m = new StackTraceElement[0];

    /* renamed from: h  reason: collision with root package name */
    public final List f4411h;

    /* renamed from: i  reason: collision with root package name */
    public j f4412i;

    /* renamed from: j  reason: collision with root package name */
    public a f4413j;

    /* renamed from: k  reason: collision with root package name */
    public Class f4414k;

    /* renamed from: l  reason: collision with root package name */
    public final String f4415l;

    public i0(String str) {
        this(str, Collections.emptyList());
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (th instanceof i0) {
            for (Throwable a10 : ((i0) th).f4411h) {
                a(a10, arrayList);
            }
            return;
        }
        arrayList.add(th);
    }

    public static void b(List list, h0 h0Var) {
        try {
            c(list, h0Var);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void c(List list, h0 h0Var) {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            h0Var.append((CharSequence) "Cause (");
            int i11 = i10 + 1;
            h0Var.append((CharSequence) String.valueOf(i11));
            h0Var.append(" of ");
            h0Var.append(String.valueOf(size));
            h0Var.append("): ");
            Throwable th = (Throwable) list.get(i10);
            if (th instanceof i0) {
                ((i0) th).f(h0Var);
            } else {
                d(th, h0Var);
            }
            i10 = i11;
        }
    }

    public static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            StringBuilder sb2 = new StringBuilder("Root cause (");
            int i11 = i10 + 1;
            sb2.append(i11);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(")");
            Log.i("Glide", sb2.toString(), (Throwable) arrayList.get(i10));
            i10 = i11;
        }
    }

    public final void f(Appendable appendable) {
        d(this, appendable);
        b(this.f4411h, new h0(appendable));
    }

    public final Throwable fillInStackTrace() {
        return this;
    }

    public final String getMessage() {
        String str;
        String str2;
        String str3;
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.f4415l);
        String str4 = "";
        if (this.f4414k != null) {
            str = ", " + this.f4414k;
        } else {
            str = str4;
        }
        sb2.append(str);
        if (this.f4413j != null) {
            str2 = ", " + this.f4413j;
        } else {
            str2 = str4;
        }
        sb2.append(str2);
        if (this.f4412i != null) {
            str4 = ", " + this.f4412i;
        }
        sb2.append(str4);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb2.toString();
        }
        if (arrayList.size() == 1) {
            str3 = "\nThere was 1 root cause:";
        } else {
            sb2.append("\nThere were ");
            sb2.append(arrayList.size());
            str3 = " root causes:";
        }
        sb2.append(str3);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb2.append(10);
            sb2.append(th.getClass().getName());
            sb2.append('(');
            sb2.append(th.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    public final void printStackTrace() {
        f(System.err);
    }

    public i0(String str, List list) {
        this.f4415l = str;
        setStackTrace(f4410m);
        this.f4411h = list;
    }

    public final void printStackTrace(PrintStream printStream) {
        f(printStream);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        f(printWriter);
    }
}
