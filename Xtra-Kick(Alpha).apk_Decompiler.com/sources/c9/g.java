package c9;

public abstract class g implements r {
    public int a(int i10, CharSequence charSequence) {
        int length = charSequence.length();
        q.d(i10, length);
        while (i10 < length) {
            if (b(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public boolean apply(Object obj) {
        return b(((Character) obj).charValue());
    }

    public abstract boolean b(char c10);

    public String toString() {
        return super.toString();
    }
}
