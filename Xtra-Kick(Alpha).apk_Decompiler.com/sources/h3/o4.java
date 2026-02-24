package h3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.media.h;
import e9.b;
import j1.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

public final /* synthetic */ class o4 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7269a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f7270b;

    public /* synthetic */ o4(int i10, Object obj) {
        this.f7269a = i10;
        this.f7270b = obj;
    }

    public final Object call() {
        boolean z10 = true;
        int i10 = this.f7269a;
        Object obj = this.f7270b;
        switch (i10) {
            case 0:
                byte[] bArr = (byte[]) obj;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (decodeByteArray == null) {
                    z10 = false;
                }
                a.a("Could not decode image data", z10);
                return decodeByteArray;
            default:
                Uri uri = (Uri) obj;
                if ("file".equals(uri.getScheme())) {
                    String path = uri.getPath();
                    if (path != null) {
                        Bitmap decodeFile = BitmapFactory.decodeFile(path);
                        if (decodeFile != null) {
                            return decodeFile;
                        }
                        throw new IllegalArgumentException("Could not read image from file");
                    }
                    throw new IllegalArgumentException("Could not read image from file");
                }
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            byte[] a10 = b.a(inputStream);
                            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(a10, 0, a10.length);
                            if (decodeByteArray2 == null) {
                                z10 = false;
                            }
                            a.a("Could not decode image data", z10);
                            inputStream.close();
                            return decodeByteArray2;
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                            break;
                        }
                    } else {
                        throw new IOException(h.i("Invalid response status code: ", responseCode));
                    }
                } else {
                    throw new UnsupportedOperationException("Unsupported scheme: " + uri.getScheme());
                }
                break;
        }
        throw th;
    }
}
