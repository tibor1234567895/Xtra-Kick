package q1;

import android.net.Uri;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k1.f0;
import k1.h;
import k1.j;
import k1.m;

public final class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public final h f13130a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f13131b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f13132c;

    /* renamed from: d  reason: collision with root package name */
    public CipherInputStream f13133d;

    public a(h hVar, byte[] bArr, byte[] bArr2) {
        this.f13130a = hVar;
        this.f13131b = bArr;
        this.f13132c = bArr2;
    }

    public final void close() {
        if (this.f13133d != null) {
            this.f13133d = null;
            this.f13130a.close();
        }
    }

    public final Map e() {
        return this.f13130a.e();
    }

    public final void i(f0 f0Var) {
        f0Var.getClass();
        this.f13130a.i(f0Var);
    }

    public final Uri j() {
        return this.f13130a.j();
    }

    public final int o(byte[] bArr, int i10, int i11) {
        this.f13133d.getClass();
        int read = this.f13133d.read(bArr, i10, i11);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    public final long q(m mVar) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.f13131b, "AES"), new IvParameterSpec(this.f13132c));
                j jVar = new j(this.f13130a, mVar);
                this.f13133d = new CipherInputStream(jVar, instance);
                jVar.c();
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e10) {
                throw new RuntimeException(e10);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
            throw new RuntimeException(e11);
        }
    }
}
