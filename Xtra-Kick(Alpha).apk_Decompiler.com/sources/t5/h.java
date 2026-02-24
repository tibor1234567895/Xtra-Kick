package t5;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;
import w5.n;
import z.f;

public final class h {

    /* renamed from: d  reason: collision with root package name */
    public static Integer f14562d;

    /* renamed from: a  reason: collision with root package name */
    public final View f14563a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f14564b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public f f14565c;

    public h(View view) {
        this.f14563a = view;
    }

    public final int a(int i10, int i11, int i12) {
        int i13 = i11 - i12;
        if (i13 > 0) {
            return i13;
        }
        int i14 = i10 - i12;
        if (i14 > 0) {
            return i14;
        }
        View view = this.f14563a;
        if (view.isLayoutRequested() || i11 != -2) {
            return 0;
        }
        if (Log.isLoggable("ViewTarget", 4)) {
            Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        Context context = view.getContext();
        if (f14562d == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            n.b(windowManager);
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f14562d = Integer.valueOf(Math.max(point.x, point.y));
        }
        return f14562d.intValue();
    }

    public final int b() {
        View view = this.f14563a;
        int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return a(view.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
    }

    public final int c() {
        View view = this.f14563a;
        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return a(view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
    }
}
