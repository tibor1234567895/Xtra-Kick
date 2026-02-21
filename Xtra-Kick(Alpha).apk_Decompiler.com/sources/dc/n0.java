package dc;

import java.io.Closeable;
import java.io.Flushable;

public interface n0 extends Closeable, Flushable {
    void close();

    void flush();

    void o0(j jVar, long j10);

    s0 timeout();
}
