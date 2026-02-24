package x0;

import android.support.v4.media.h;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

public class b extends InputStream implements DataInput {

    /* renamed from: l  reason: collision with root package name */
    public static final ByteOrder f16512l = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: m  reason: collision with root package name */
    public static final ByteOrder f16513m = ByteOrder.BIG_ENDIAN;

    /* renamed from: h  reason: collision with root package name */
    public final DataInputStream f16514h;

    /* renamed from: i  reason: collision with root package name */
    public ByteOrder f16515i;

    /* renamed from: j  reason: collision with root package name */
    public int f16516j;

    /* renamed from: k  reason: collision with root package name */
    public byte[] f16517k;

    public b(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    public final int available() {
        return this.f16514h.available();
    }

    public final void c(int i10) {
        int i11 = 0;
        while (i11 < i10) {
            DataInputStream dataInputStream = this.f16514h;
            int i12 = i10 - i11;
            int skip = (int) dataInputStream.skip((long) i12);
            if (skip <= 0) {
                if (this.f16517k == null) {
                    this.f16517k = new byte[8192];
                }
                skip = dataInputStream.read(this.f16517k, 0, Math.min(8192, i12));
                if (skip == -1) {
                    throw new EOFException(h.j("Reached EOF while skipping ", i10, " bytes."));
                }
            }
            i11 += skip;
        }
        this.f16516j += i11;
    }

    public final void mark(int i10) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    public final int read() {
        this.f16516j++;
        return this.f16514h.read();
    }

    public final boolean readBoolean() {
        this.f16516j++;
        return this.f16514h.readBoolean();
    }

    public final byte readByte() {
        this.f16516j++;
        int read = this.f16514h.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    public final char readChar() {
        this.f16516j += 2;
        return this.f16514h.readChar();
    }

    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public final void readFully(byte[] bArr) {
        this.f16516j += bArr.length;
        this.f16514h.readFully(bArr);
    }

    public final int readInt() {
        this.f16516j += 4;
        DataInputStream dataInputStream = this.f16514h;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            ByteOrder byteOrder = this.f16515i;
            if (byteOrder == f16512l) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f16513m) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.f16515i);
        }
        throw new EOFException();
    }

    public final String readLine() {
        return null;
    }

    public final long readLong() {
        this.f16516j += 8;
        DataInputStream dataInputStream = this.f16514h;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        int read5 = dataInputStream.read();
        int read6 = dataInputStream.read();
        int read7 = dataInputStream.read();
        int read8 = dataInputStream.read();
        if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
            ByteOrder byteOrder = this.f16515i;
            if (byteOrder == f16512l) {
                return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
            }
            int i10 = read;
            if (byteOrder == f16513m) {
                return (((long) i10) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
            }
            throw new IOException("Invalid byte order: " + this.f16515i);
        }
        throw new EOFException();
    }

    public final short readShort() {
        this.f16516j += 2;
        DataInputStream dataInputStream = this.f16514h;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) >= 0) {
            ByteOrder byteOrder = this.f16515i;
            if (byteOrder == f16512l) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == f16513m) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.f16515i);
        }
        throw new EOFException();
    }

    public final String readUTF() {
        this.f16516j += 2;
        return this.f16514h.readUTF();
    }

    public final int readUnsignedByte() {
        this.f16516j++;
        return this.f16514h.readUnsignedByte();
    }

    public final int readUnsignedShort() {
        this.f16516j += 2;
        DataInputStream dataInputStream = this.f16514h;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) >= 0) {
            ByteOrder byteOrder = this.f16515i;
            if (byteOrder == f16512l) {
                return (read2 << 8) + read;
            }
            if (byteOrder == f16513m) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.f16515i);
        }
        throw new EOFException();
    }

    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    public final int skipBytes(int i10) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    public b(InputStream inputStream, ByteOrder byteOrder) {
        this.f16515i = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f16514h = dataInputStream;
        dataInputStream.mark(0);
        this.f16516j = 0;
        this.f16515i = byteOrder;
    }

    public final int read(byte[] bArr, int i10, int i11) {
        int read = this.f16514h.read(bArr, i10, i11);
        this.f16516j += read;
        return read;
    }

    public final void readFully(byte[] bArr, int i10, int i11) {
        this.f16516j += i11;
        this.f16514h.readFully(bArr, i10, i11);
    }

    public b(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
    }
}
