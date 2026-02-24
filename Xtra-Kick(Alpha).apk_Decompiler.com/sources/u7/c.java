package u7;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f15370a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f15371b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public int f15372c = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: d  reason: collision with root package name */
    public int f15373d = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: e  reason: collision with root package name */
    public int f15374e;

    /* renamed from: f  reason: collision with root package name */
    public int f15375f;

    /* renamed from: g  reason: collision with root package name */
    public int f15376g;

    /* renamed from: h  reason: collision with root package name */
    public int f15377h;

    /* renamed from: i  reason: collision with root package name */
    public int f15378i;

    /* renamed from: j  reason: collision with root package name */
    public float f15379j;

    /* renamed from: k  reason: collision with root package name */
    public float f15380k;

    /* renamed from: l  reason: collision with root package name */
    public int f15381l;

    /* renamed from: m  reason: collision with root package name */
    public int f15382m;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f15383n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public int f15384o;

    /* renamed from: p  reason: collision with root package name */
    public int f15385p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f15386q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f15387r;

    public final void a(View view, int i10, int i11, int i12, int i13) {
        b bVar = (b) view.getLayoutParams();
        this.f15370a = Math.min(this.f15370a, (view.getLeft() - bVar.q()) - i10);
        this.f15371b = Math.min(this.f15371b, (view.getTop() - bVar.t()) - i11);
        this.f15372c = Math.max(this.f15372c, bVar.i() + view.getRight() + i12);
        this.f15373d = Math.max(this.f15373d, bVar.p() + view.getBottom() + i13);
    }
}
