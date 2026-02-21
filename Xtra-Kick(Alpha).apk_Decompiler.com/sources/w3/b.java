package w3;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final a f16067e = new a(0);

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap f16068f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f16069a;

    /* renamed from: b  reason: collision with root package name */
    public final File f16070b;

    /* renamed from: c  reason: collision with root package name */
    public final Lock f16071c;

    /* renamed from: d  reason: collision with root package name */
    public FileChannel f16072d;

    public b(String str, File file, boolean z10) {
        File file2;
        Lock lock;
        this.f16069a = z10;
        if (file != null) {
            file2 = new File(file, str.concat(".lck"));
        } else {
            file2 = null;
        }
        this.f16070b = file2;
        f16067e.getClass();
        HashMap hashMap = f16068f;
        synchronized (hashMap) {
            Object obj = hashMap.get(str);
            if (obj == null) {
                obj = new ReentrantLock();
                hashMap.put(str, obj);
            }
            lock = (Lock) obj;
        }
        this.f16071c = lock;
    }

    public final void a(boolean z10) {
        this.f16071c.lock();
        if (z10) {
            File file = this.f16070b;
            if (file != null) {
                try {
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    FileChannel channel = new FileOutputStream(file).getChannel();
                    channel.lock();
                    this.f16072d = channel;
                } catch (IOException e10) {
                    this.f16072d = null;
                    Log.w("SupportSQLiteLock", "Unable to grab file lock.", e10);
                }
            } else {
                throw new IOException("No lock directory was provided.");
            }
        }
    }

    public final void b() {
        try {
            FileChannel fileChannel = this.f16072d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f16071c.unlock();
    }
}
