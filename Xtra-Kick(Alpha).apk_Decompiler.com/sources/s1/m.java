package s1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import b2.f;
import java.nio.ByteBuffer;
import l1.d;

public interface m {
    void a();

    int b(MediaCodec.BufferInfo bufferInfo);

    void c();

    void d(int i10, boolean z10);

    void e(f fVar, Handler handler);

    void f(int i10);

    void flush();

    void g(int i10, d dVar, long j10);

    MediaFormat h();

    ByteBuffer i(int i10);

    void j(Surface surface);

    void k(Bundle bundle);

    ByteBuffer l(int i10);

    void m(int i10, long j10);

    int n();

    void o(int i10, int i11, long j10, int i12);
}
