package dc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import xa.j;

public class z extends r {
    public final n0 a(f0 f0Var) {
        File d10 = f0Var.d();
        Logger logger = b0.f4742a;
        return new c((OutputStream) new FileOutputStream(d10, true), new s0());
    }

    public void b(f0 f0Var, f0 f0Var2) {
        j.f("source", f0Var);
        j.f("target", f0Var2);
        if (!f0Var.d().renameTo(f0Var2.d())) {
            throw new IOException("failed to move " + f0Var + " to " + f0Var2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r0.f4812b == true) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(dc.f0 r4) {
        /*
            r3 = this;
            java.io.File r0 = r4.d()
            boolean r0 = r0.mkdir()
            if (r0 != 0) goto L_0x002e
            dc.p r0 = r3.i(r4)
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.f4812b
            r1 = 1
            if (r0 != r1) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 == 0) goto L_0x001a
            return
        L_0x001a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "failed to create directory: "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.z.c(dc.f0):void");
    }

    public final void d(f0 f0Var) {
        j.f("path", f0Var);
        if (!Thread.interrupted()) {
            File d10 = f0Var.d();
            if (!d10.delete() && d10.exists()) {
                throw new IOException("failed to delete " + f0Var);
            }
            return;
        }
        throw new InterruptedIOException("interrupted");
    }

    public final List g(f0 f0Var) {
        j.f("dir", f0Var);
        File d10 = f0Var.d();
        String[] list = d10.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                j.e("it", str);
                arrayList.add(f0Var.c(str));
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList);
            }
            return arrayList;
        } else if (!d10.exists()) {
            throw new FileNotFoundException("no such file: " + f0Var);
        } else {
            throw new IOException("failed to list " + f0Var);
        }
    }

    public p i(f0 f0Var) {
        j.f("path", f0Var);
        File d10 = f0Var.d();
        boolean isFile = d10.isFile();
        boolean isDirectory = d10.isDirectory();
        long lastModified = d10.lastModified();
        long length = d10.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !d10.exists()) {
            return null;
        }
        return new p(isFile, isDirectory, (f0) null, Long.valueOf(length), (Long) null, Long.valueOf(lastModified), (Long) null, 128);
    }

    public final y j(f0 f0Var) {
        j.f("file", f0Var);
        return new y(new RandomAccessFile(f0Var.d(), "r"));
    }

    public final n0 k(f0 f0Var) {
        j.f("file", f0Var);
        File d10 = f0Var.d();
        Logger logger = b0.f4742a;
        return new c((OutputStream) new FileOutputStream(d10, false), new s0());
    }

    public final p0 l(f0 f0Var) {
        j.f("file", f0Var);
        File d10 = f0Var.d();
        Logger logger = b0.f4742a;
        return new d((InputStream) new FileInputStream(d10), (s0) s0.f4821d);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
