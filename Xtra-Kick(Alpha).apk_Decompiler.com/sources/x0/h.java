package x0;

import android.system.ErrnoException;
import android.system.Os;
import java.io.FileDescriptor;

public final class h {
    private h() {
    }

    public static void a(FileDescriptor fileDescriptor) throws ErrnoException {
        Os.close(fileDescriptor);
    }

    public static FileDescriptor b(FileDescriptor fileDescriptor) throws ErrnoException {
        return Os.dup(fileDescriptor);
    }

    public static long c(FileDescriptor fileDescriptor, long j10, int i10) throws ErrnoException {
        return Os.lseek(fileDescriptor, j10, i10);
    }
}
