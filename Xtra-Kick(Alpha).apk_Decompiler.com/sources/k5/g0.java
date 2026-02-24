package k5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import e5.c;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Paint f9155a = new Paint(6);

    /* renamed from: b  reason: collision with root package name */
    public static final Paint f9156b = new Paint(7);

    /* renamed from: c  reason: collision with root package name */
    public static final Paint f9157c;

    /* renamed from: d  reason: collision with root package name */
    public static final Lock f9158d = (new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"})).contains(Build.MODEL) ? new ReentrantLock() : new f0());

    static {
        Paint paint = new Paint(7);
        f9157c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private g0() {
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = f9158d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f9155a);
            canvas.setBitmap((Bitmap) null);
        } finally {
            lock.unlock();
        }
    }

    public static Bitmap b(c cVar, Bitmap bitmap, int i10, int i11) {
        Bitmap.Config config;
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        float min = Math.min(((float) i10) / ((float) bitmap.getWidth()), ((float) i11) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        int width = (int) (((float) bitmap.getWidth()) * min);
        int height = (int) (((float) bitmap.getHeight()) * min);
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap b10 = cVar.b(width, height, config);
        b10.setHasAlpha(bitmap.hasAlpha());
        if (Log.isLoggable("TransformationUtils", 2)) {
            bitmap.getWidth();
            bitmap.getHeight();
            b10.getWidth();
            b10.getHeight();
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, b10, matrix);
        return b10;
    }

    public static int c(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return 180;
            case Constants.MAX_COMPATIBILITY_VERSION:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static boolean d(int i10) {
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case Constants.MAX_COMPATIBILITY_VERSION:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap e(c cVar, Bitmap bitmap, int i10) {
        Bitmap.Config config;
        if (!d(i10)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (i10) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case Constants.MAX_COMPATIBILITY_VERSION:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        matrix.postScale(-1.0f, 1.0f);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap b10 = cVar.b(round, round2, config);
        matrix.postTranslate(-rectF.left, -rectF.top);
        b10.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, b10, matrix);
        return b10;
    }
}
