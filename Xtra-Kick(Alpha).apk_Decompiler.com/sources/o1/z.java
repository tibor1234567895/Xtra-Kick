package o1;

import android.os.SystemClock;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public Exception f12060a;

    /* renamed from: b  reason: collision with root package name */
    public long f12061b;

    public final void a(Exception exc) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f12060a == null) {
            this.f12060a = exc;
            this.f12061b = 100 + elapsedRealtime;
        }
        if (elapsedRealtime >= this.f12061b) {
            Exception exc2 = this.f12060a;
            if (exc2 != exc) {
                exc2.addSuppressed(exc);
            }
            Exception exc3 = this.f12060a;
            this.f12060a = null;
            throw exc3;
        }
    }
}
