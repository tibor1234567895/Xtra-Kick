package p3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f12551a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12552b;

    /* renamed from: c  reason: collision with root package name */
    public final long f12553c;

    /* renamed from: d  reason: collision with root package name */
    public final long f12554d;

    public p(int i10, int i11, long j10, long j11) {
        this.f12551a = i10;
        this.f12552b = i11;
        this.f12553c = j10;
        this.f12554d = j11;
    }

    public static p a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            p pVar = new p(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return pVar;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f12551a);
            dataOutputStream.writeInt(this.f12552b);
            dataOutputStream.writeLong(this.f12553c);
            dataOutputStream.writeLong(this.f12554d);
            dataOutputStream.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f12552b == pVar.f12552b && this.f12553c == pVar.f12553c && this.f12551a == pVar.f12551a && this.f12554d == pVar.f12554d;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f12552b), Long.valueOf(this.f12553c), Integer.valueOf(this.f12551a), Long.valueOf(this.f12554d)});
    }
}
