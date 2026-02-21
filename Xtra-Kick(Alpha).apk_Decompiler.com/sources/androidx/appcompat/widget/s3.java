package androidx.appcompat.widget;

import androidx.recyclerview.widget.RecyclerView;

public final class s3 {

    /* renamed from: a  reason: collision with root package name */
    public int f1047a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1048b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1049c = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: d  reason: collision with root package name */
    public int f1050d = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: e  reason: collision with root package name */
    public int f1051e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1052f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1053g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1054h = false;

    public final void a(int i10, int i11) {
        this.f1049c = i10;
        this.f1050d = i11;
        this.f1054h = true;
        if (this.f1053g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f1047a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f1048b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1047a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1048b = i11;
        }
    }
}
