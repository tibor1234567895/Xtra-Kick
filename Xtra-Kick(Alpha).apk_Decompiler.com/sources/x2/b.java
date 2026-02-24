package x2;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import i1.a;
import j1.l0;
import java.util.ArrayList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f16568a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f16569b;

    /* renamed from: c  reason: collision with root package name */
    public final StringBuilder f16570c;

    /* renamed from: d  reason: collision with root package name */
    public int f16571d = 15;

    /* renamed from: e  reason: collision with root package name */
    public int f16572e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f16573f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f16574g;

    /* renamed from: h  reason: collision with root package name */
    public int f16575h;

    public b(int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f16568a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f16569b = arrayList2;
        StringBuilder sb2 = new StringBuilder();
        this.f16570c = sb2;
        this.f16574g = i10;
        arrayList.clear();
        arrayList2.clear();
        sb2.setLength(0);
        this.f16575h = i11;
    }

    public final void a(char c10) {
        StringBuilder sb2 = this.f16570c;
        if (sb2.length() < 32) {
            sb2.append(c10);
        }
    }

    public final void b() {
        a aVar;
        int i10;
        StringBuilder sb2 = this.f16570c;
        int length = sb2.length();
        if (length > 0) {
            sb2.delete(length - 1, length);
            ArrayList arrayList = this.f16568a;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size >= 0 && (i10 = (aVar = (a) arrayList.get(size)).f16567c) == length) {
                    aVar.f16567c = i10 - 1;
                } else {
                    return;
                }
            }
        }
    }

    public final i1.b c(int i10) {
        float f10;
        int i11 = this.f16572e + this.f16573f;
        int i12 = 32 - i11;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i13 = 0;
        while (true) {
            ArrayList arrayList = this.f16569b;
            if (i13 >= arrayList.size()) {
                break;
            }
            CharSequence charSequence = (CharSequence) arrayList.get(i13);
            int i14 = l0.f8453a;
            if (charSequence.length() > i12) {
                charSequence = charSequence.subSequence(0, i12);
            }
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(10);
            i13++;
        }
        SpannableString d10 = d();
        int i15 = l0.f8453a;
        int length = d10.length();
        CharSequence charSequence2 = d10;
        if (length > i12) {
            charSequence2 = d10.subSequence(0, i12);
        }
        spannableStringBuilder.append(charSequence2);
        if (spannableStringBuilder.length() == 0) {
            return null;
        }
        int length2 = i12 - spannableStringBuilder.length();
        int i16 = i11 - length2;
        if (i10 == Integer.MIN_VALUE) {
            if (this.f16574g == 2 && (Math.abs(i16) < 3 || length2 < 0)) {
                i10 = 1;
            } else if (this.f16574g != 2 || i16 <= 0) {
                i10 = 0;
            } else {
                i10 = 2;
            }
        }
        if (i10 != 1) {
            if (i10 == 2) {
                i11 = 32 - length2;
            }
            f10 = ((((float) i11) / 32.0f) * 0.8f) + 0.1f;
        } else {
            f10 = 0.5f;
        }
        int i17 = this.f16571d;
        if (i17 > 7) {
            i17 = (i17 - 15) - 2;
        } else if (this.f16574g == 1) {
            i17 -= this.f16575h - 1;
        }
        a aVar = new a();
        aVar.f7953a = spannableStringBuilder;
        aVar.f7955c = Layout.Alignment.ALIGN_NORMAL;
        aVar.f7957e = (float) i17;
        aVar.f7958f = 1;
        aVar.f7960h = f10;
        aVar.f7961i = i10;
        return aVar.a();
    }

    public final SpannableString d() {
        int i10;
        boolean z10;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f16570c);
        int length = spannableStringBuilder.length();
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        int i14 = 0;
        int i15 = -1;
        boolean z11 = false;
        int i16 = -1;
        while (true) {
            ArrayList arrayList = this.f16568a;
            if (i11 >= arrayList.size()) {
                break;
            }
            a aVar = (a) arrayList.get(i11);
            boolean z12 = aVar.f16566b;
            int i17 = aVar.f16565a;
            if (i17 != 8) {
                if (i17 == 7) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (i17 != 7) {
                    i16 = c.A[i17];
                }
                z11 = z10;
            }
            int i18 = aVar.f16567c;
            i11++;
            if (i11 < arrayList.size()) {
                i10 = ((a) arrayList.get(i11)).f16567c;
            } else {
                i10 = length;
            }
            if (i18 != i10) {
                if (i12 != -1 && !z12) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i12, i18, 33);
                    i12 = -1;
                } else if (i12 == -1 && z12) {
                    i12 = i18;
                }
                if (i13 != -1 && !z11) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), i13, i18, 33);
                    i13 = -1;
                } else if (i13 == -1 && z11) {
                    i13 = i18;
                }
                if (i16 != i15) {
                    if (i15 != -1) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(i15), i14, i18, 33);
                    }
                    i15 = i16;
                    i14 = i18;
                }
            }
        }
        if (!(i12 == -1 || i12 == length)) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i12, length, 33);
        }
        if (!(i13 == -1 || i13 == length)) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i13, length, 33);
        }
        if (!(i14 == length || i15 == -1)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i15), i14, length, 33);
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final boolean e() {
        return this.f16568a.isEmpty() && this.f16569b.isEmpty() && this.f16570c.length() == 0;
    }
}
