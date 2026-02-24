package b2;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import f5.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f2428a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2429b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2430c;

    public /* synthetic */ e(int i10, int i11, int i12) {
        this.f2428a = i10;
        this.f2429b = i11;
        this.f2430c = i12;
    }

    public e(j jVar) {
        Context context = jVar.f5825a;
        ActivityManager activityManager = jVar.f5826b;
        int i10 = activityManager.isLowRamDevice() ? 2097152 : 4194304;
        this.f2430c = i10;
        int round = Math.round(((float) (activityManager.getMemoryClass() * 1024 * 1024)) * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = (DisplayMetrics) jVar.f5827c.f2538i;
        float f10 = (float) (displayMetrics.widthPixels * displayMetrics.heightPixels * 4);
        float f11 = jVar.f5828d;
        int round2 = Math.round(f10 * f11);
        int round3 = Math.round(f10 * 2.0f);
        int i11 = round - i10;
        if (round3 + round2 <= i11) {
            this.f2429b = round3;
            this.f2428a = round2;
        } else {
            float f12 = ((float) i11) / (f11 + 2.0f);
            this.f2429b = Math.round(2.0f * f12);
            this.f2428a = Math.round(f12 * f11);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Formatter.formatFileSize(context, (long) this.f2429b);
            Formatter.formatFileSize(context, (long) this.f2428a);
            Formatter.formatFileSize(context, (long) i10);
            Formatter.formatFileSize(context, (long) round);
            activityManager.getMemoryClass();
            activityManager.isLowRamDevice();
        }
    }
}
