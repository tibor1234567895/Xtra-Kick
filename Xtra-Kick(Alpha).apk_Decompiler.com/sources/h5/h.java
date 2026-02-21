package h5;

import android.util.Log;
import b5.d;
import b5.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import w5.a;

public final class h implements d {
    public final boolean c(Object obj, File file, n nVar) {
        try {
            a.d((ByteBuffer) obj, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}
