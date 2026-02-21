package u2;

import android.support.v4.media.h;
import d0.d;
import j1.b0;
import j1.v;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class q {
    private q() {
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (!(bArr == null || bArr.length == 0)) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [byte[], java.io.Serializable] */
    public static d b(byte[] bArr) {
        b0 b0Var = new b0(bArr);
        if (b0Var.f8416c < 32) {
            return null;
        }
        b0Var.G(0);
        if (b0Var.f() != (b0Var.f8416c - b0Var.f8415b) + 4 || b0Var.f() != 1886614376) {
            return null;
        }
        int f10 = (b0Var.f() >> 24) & 255;
        if (f10 > 1) {
            h.z("Unsupported pssh version: ", f10, "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(b0Var.o(), b0Var.o());
        if (f10 == 1) {
            b0Var.H(b0Var.y() * 16);
        }
        int y10 = b0Var.y();
        if (y10 != b0Var.f8416c - b0Var.f8415b) {
            return null;
        }
        ? r22 = new byte[y10];
        b0Var.d(r22, 0, y10);
        return new d((Object) uuid, f10, (Serializable) r22);
    }

    public static byte[] c(UUID uuid, byte[] bArr) {
        d b10 = b(bArr);
        if (b10 == null) {
            return null;
        }
        Object obj = b10.f4091i;
        if (uuid.equals((UUID) obj)) {
            return (byte[]) b10.f4092j;
        }
        v.g("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + ((UUID) obj) + ".");
        return null;
    }
}
