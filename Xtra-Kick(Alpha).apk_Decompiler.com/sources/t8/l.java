package t8;

public final class l extends d {

    /* renamed from: a  reason: collision with root package name */
    public final float f14764a = -1.0f;

    public final void a(float f10, float f11, x xVar) {
        xVar.d(f11 * f10, 180.0f, 90.0f);
        float f12 = f11 * 2.0f * f10;
        t tVar = new t(0.0f, 0.0f, f12, f12);
        tVar.f14814f = 180.0f;
        tVar.f14815g = 90.0f;
        xVar.f14827g.add(tVar);
        r rVar = new r(tVar);
        xVar.a(180.0f);
        xVar.f14828h.add(rVar);
        xVar.f14825e = 270.0f;
        float f13 = (f12 + 0.0f) * 0.5f;
        float f14 = (f12 - 0.0f) / 2.0f;
        double d10 = (double) 270.0f;
        xVar.f14823c = (((float) Math.cos(Math.toRadians(d10))) * f14) + f13;
        xVar.f14824d = (f14 * ((float) Math.sin(Math.toRadians(d10)))) + f13;
    }
}
