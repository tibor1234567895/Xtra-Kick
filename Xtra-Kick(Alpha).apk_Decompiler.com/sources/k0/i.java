package k0;

public final class i implements j {

    /* renamed from: a  reason: collision with root package name */
    public static final i f8955a = new i();

    private i() {
    }

    public final int a(CharSequence charSequence, int i10) {
        int i11 = i10 + 0;
        int i12 = 2;
        for (int i13 = 0; i13 < i11 && i12 == 2; i13++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i13));
            l lVar = n.f8959a;
            if (directionality != 0) {
                if (!(directionality == 1 || directionality == 2)) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case Constants.IV_SIZE:
                        case 17:
                            break;
                        default:
                            i12 = 2;
                            break;
                    }
                }
                i12 = 0;
            }
            i12 = 1;
        }
        return i12;
    }
}
