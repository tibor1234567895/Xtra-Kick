package d5;

import android.support.v4.media.j;
import java.util.concurrent.ThreadFactory;

public final class a implements ThreadFactory {
    public final Thread newThread(Runnable runnable) {
        return new Thread(new j((Object) this, 6, (Object) runnable), "glide-active-resources");
    }
}
