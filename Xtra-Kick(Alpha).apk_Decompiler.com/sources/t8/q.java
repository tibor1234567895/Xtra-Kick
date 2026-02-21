package t8;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;
import s8.a;

public final class q extends w {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f14803c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Matrix f14804d;

    public q(ArrayList arrayList, Matrix matrix) {
        this.f14803c = arrayList;
        this.f14804d = matrix;
    }

    public final void a(Matrix matrix, a aVar, int i10, Canvas canvas) {
        for (w a10 : this.f14803c) {
            a10.a(this.f14804d, aVar, i10, canvas);
        }
    }
}
