package dc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import xa.j;

public final class a0 extends z {
    public static Long m(FileTime fileTime) {
        Long valueOf = Long.valueOf(fileTime.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }

    public final void b(f0 f0Var, f0 f0Var2) {
        j.f("source", f0Var);
        j.f("target", f0Var2);
        try {
            Files.move(f0Var.e(), f0Var2.e(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});
        } catch (NoSuchFileException e10) {
            throw new FileNotFoundException(e10.getMessage());
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        }
    }

    public final p i(f0 f0Var) {
        Path path;
        f0 f0Var2;
        Long l10;
        Long l11;
        j.f("path", f0Var);
        Path e10 = f0Var.e();
        Long l12 = null;
        try {
            BasicFileAttributes readAttributes = Files.readAttributes(e10, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            if (readAttributes.isSymbolicLink()) {
                path = Files.readSymbolicLink(e10);
            } else {
                path = null;
            }
            boolean isRegularFile = readAttributes.isRegularFile();
            boolean isDirectory = readAttributes.isDirectory();
            if (path != null) {
                f0.f4761i.getClass();
                f0Var2 = e0.a(path.toString(), false);
            } else {
                f0Var2 = null;
            }
            Long valueOf = Long.valueOf(readAttributes.size());
            FileTime creationTime = readAttributes.creationTime();
            if (creationTime != null) {
                l10 = m(creationTime);
            } else {
                l10 = null;
            }
            FileTime lastModifiedTime = readAttributes.lastModifiedTime();
            if (lastModifiedTime != null) {
                l11 = m(lastModifiedTime);
            } else {
                l11 = null;
            }
            FileTime lastAccessTime = readAttributes.lastAccessTime();
            if (lastAccessTime != null) {
                l12 = m(lastAccessTime);
            }
            return new p(isRegularFile, isDirectory, f0Var2, valueOf, l10, l11, l12, 128);
        } catch (FileSystemException | NoSuchFileException unused) {
            return null;
        }
    }

    public final String toString() {
        return "NioSystemFileSystem";
    }
}
