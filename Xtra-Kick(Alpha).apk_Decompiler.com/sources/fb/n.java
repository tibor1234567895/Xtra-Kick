package fb;

import wa.l;

public class n {
    public static final void a(StringBuilder sb2, Object obj, l lVar) {
        CharSequence charSequence;
        if (lVar != null) {
            obj = lVar.invoke(obj);
        } else {
            if (!(obj == null ? true : obj instanceof CharSequence)) {
                if (obj instanceof Character) {
                    sb2.append(((Character) obj).charValue());
                    return;
                }
                charSequence = String.valueOf(obj);
                sb2.append(charSequence);
            }
        }
        charSequence = (CharSequence) obj;
        sb2.append(charSequence);
    }
}
