package dc;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface l extends p0, ReadableByteChannel {
    long D0();

    boolean E(long j10, n nVar);

    String E0(Charset charset);

    h G0();

    void H(j jVar, long j10);

    String K();

    int K0(d0 d0Var);

    byte[] M();

    int O();

    long Q(k kVar);

    boolean R();

    void a(long j10);

    j b();

    long d0();

    String e0(long j10);

    n m();

    n n(long j10);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    boolean t(long j10);

    void u0(long j10);
}
