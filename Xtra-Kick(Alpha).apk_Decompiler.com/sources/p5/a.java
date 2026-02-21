package p5;

import android.graphics.Bitmap;
import b5.n;
import d5.o0;
import java.io.ByteArrayOutputStream;
import k5.h0;

public final class a implements c {

    /* renamed from: h  reason: collision with root package name */
    public final Bitmap.CompressFormat f12568h = Bitmap.CompressFormat.JPEG;

    /* renamed from: i  reason: collision with root package name */
    public final int f12569i = 100;

    public final o0 d(o0 o0Var, n nVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) o0Var.get()).compress(this.f12568h, this.f12569i, byteArrayOutputStream);
        o0Var.e();
        return new h0(byteArrayOutputStream.toByteArray());
    }
}
