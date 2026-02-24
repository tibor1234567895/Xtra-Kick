package y9;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import fb.y;
import hb.h0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import va.k;
import xa.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17239a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17240b;

    public b(Context context, String str) {
        j.g("context", context);
        j.g("defaultTempDir", str);
        this.f17239a = context;
        this.f17240b = str;
    }

    public final String a(String str, boolean z10) {
        j.g("file", str);
        Context context = this.f17239a;
        j.g("context", context);
        if (h0.a1(str)) {
            Uri parse = Uri.parse(str);
            j.b("uri", parse);
            if (j.a(parse.getScheme(), "file")) {
                String path = parse.getPath();
                if (path != null) {
                    str = path;
                }
            } else if (!j.a(parse.getScheme(), "content")) {
                throw new IOException("FNC");
            } else if (context.getContentResolver().openFileDescriptor(parse, "w") != null) {
                return str;
            } else {
                throw new IOException("FNC");
            }
        }
        if (!z10) {
            h0.J(new File(str));
            return str;
        }
        File file = new File(str);
        if (file.exists()) {
            String str2 = file.getParent() + '/';
            String b10 = k.b(file);
            String name = file.getName();
            j.e("name", name);
            String P = y.P(name, ".", name);
            int i10 = 0;
            while (file.exists()) {
                i10++;
                file = new File(str2 + (P + " (" + i10 + ')') + '.' + b10);
            }
        }
        h0.J(file);
        String absolutePath = file.getAbsolutePath();
        j.b("getIncrementedFileIfOrig…ts(filePath).absolutePath", absolutePath);
        return absolutePath;
    }

    public final boolean b(String str) {
        j.g("file", str);
        if (str.length() == 0) {
            return false;
        }
        try {
            ContentResolver contentResolver = this.f17239a.getContentResolver();
            j.b("context.contentResolver", contentResolver);
            h0.z0(str, contentResolver).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void c(String str, long j10) {
        boolean z10;
        File file;
        j.g("file", str);
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            throw new FileNotFoundException(str.concat(" file_not_found"));
        } else if (j10 >= 1) {
            Context context = this.f17239a;
            j.g("context", context);
            if (h0.a1(str)) {
                Uri parse = Uri.parse(str);
                j.b("uri", parse);
                if (j.a(parse.getScheme(), "file")) {
                    String path = parse.getPath();
                    if (path != null) {
                        str = path;
                    }
                    file = new File(str);
                } else if (j.a(parse.getScheme(), "content")) {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(parse, "w");
                    if (openFileDescriptor == null) {
                        throw new IOException("file_allocation_error");
                    } else if (j10 > 0) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
                            if (fileOutputStream.getChannel().size() != j10) {
                                fileOutputStream.getChannel().position(j10 - 1);
                                fileOutputStream.write(1);
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            throw new IOException("file_allocation_error");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("file_allocation_error");
                }
            } else {
                file = new File(str);
            }
            if (!file.exists()) {
                h0.J(file);
            }
            if (file.length() != j10 && j10 > 0) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(j10);
                    randomAccessFile.close();
                } catch (Exception unused2) {
                    throw new IOException("file_allocation_error");
                }
            }
        }
    }
}
