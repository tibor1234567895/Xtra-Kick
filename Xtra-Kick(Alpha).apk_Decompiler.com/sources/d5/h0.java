package d5;

public final class h0 implements Appendable {

    /* renamed from: h  reason: collision with root package name */
    public final Appendable f4390h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4391i = true;

    public h0(Appendable appendable) {
        this.f4390h = appendable;
    }

    public final Appendable append(char c10) {
        boolean z10 = this.f4391i;
        Appendable appendable = this.f4390h;
        boolean z11 = false;
        if (z10) {
            this.f4391i = false;
            appendable.append("  ");
        }
        if (c10 == 10) {
            z11 = true;
        }
        this.f4391i = z11;
        appendable.append(c10);
        return this;
    }

    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    public final Appendable append(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z10 = this.f4391i;
        Appendable appendable = this.f4390h;
        boolean z11 = false;
        if (z10) {
            this.f4391i = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i11 - 1) == 10) {
            z11 = true;
        }
        this.f4391i = z11;
        appendable.append(charSequence, i10, i11);
        return this;
    }
}
