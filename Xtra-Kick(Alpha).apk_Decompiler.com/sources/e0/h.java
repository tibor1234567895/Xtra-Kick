package e0;

import android.graphics.Path;
import android.util.Log;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public char f4862a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f4863b;

    public h(char c10, float[] fArr) {
        this.f4862a = c10;
        this.f4863b = fArr;
    }

    public static void a(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
        double d10;
        double d11;
        float f17 = f10;
        float f18 = f12;
        float f19 = f14;
        boolean z12 = z11;
        double radians = Math.toRadians((double) f16);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d12 = (double) f17;
        double d13 = (double) f11;
        double d14 = (d13 * sin) + (d12 * cos);
        double d15 = d12;
        double d16 = (double) f19;
        double d17 = d14 / d16;
        double d18 = radians;
        double d19 = (double) f15;
        double d20 = ((d13 * cos) + (((double) (-f17)) * sin)) / d19;
        double d21 = d13;
        double d22 = (double) f13;
        double d23 = ((d22 * sin) + (((double) f18) * cos)) / d16;
        double d24 = ((d22 * cos) + (((double) (-f18)) * sin)) / d19;
        double d25 = d17 - d23;
        double d26 = d20 - d24;
        double d27 = (d17 + d23) / 2.0d;
        double d28 = (d20 + d24) / 2.0d;
        double d29 = sin;
        double d30 = (d26 * d26) + (d25 * d25);
        if (d30 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d31 = (1.0d / d30) - 0.25d;
        if (d31 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d30);
            float sqrt = (float) (Math.sqrt(d30) / 1.99999d);
            a(path, f10, f11, f12, f13, f19 * sqrt, f15 * sqrt, f16, z10, z11);
            return;
        }
        double sqrt2 = Math.sqrt(d31);
        double d32 = d25 * sqrt2;
        double d33 = sqrt2 * d26;
        if (z10 == z12) {
            d11 = d27 - d33;
            d10 = d28 + d32;
        } else {
            d11 = d27 + d33;
            d10 = d28 - d32;
        }
        double atan2 = Math.atan2(d20 - d10, d17 - d11);
        double atan22 = Math.atan2(d24 - d10, d23 - d11) - atan2;
        int i10 = 0;
        int i11 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
        if (z12 != (i11 >= 0)) {
            atan22 = i11 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d34 = d11 * d16;
        double d35 = d10 * d19;
        double d36 = (d34 * cos) - (d35 * d29);
        double d37 = (d35 * cos) + (d34 * d29);
        int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
        double cos2 = Math.cos(d18);
        double sin2 = Math.sin(d18);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d38 = -d16;
        double d39 = d38 * cos2;
        double d40 = d19 * sin2;
        double d41 = (d39 * sin3) - (d40 * cos3);
        double d42 = d38 * sin2;
        double d43 = d19 * cos2;
        double d44 = (cos3 * d43) + (sin3 * d42);
        double d45 = atan22 / ((double) ceil);
        double d46 = atan2;
        while (i10 < ceil) {
            double d47 = d46 + d45;
            double sin4 = Math.sin(d47);
            double cos4 = Math.cos(d47);
            double d48 = d45;
            double d49 = (((d16 * cos2) * cos4) + d36) - (d40 * sin4);
            double d50 = d36;
            double d51 = (d43 * sin4) + (d16 * sin2 * cos4) + d37;
            double d52 = (d39 * sin4) - (d40 * cos4);
            double d53 = (cos4 * d43) + (sin4 * d42);
            double d54 = d47 - d46;
            double tan = Math.tan(d54 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d54)) / 3.0d;
            double d55 = (d41 * sqrt3) + d15;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) d55, (float) ((d44 * sqrt3) + d21), (float) (d49 - (sqrt3 * d52)), (float) (d51 - (sqrt3 * d53)), (float) d49, (float) d51);
            i10++;
            d43 = d43;
            d42 = d42;
            ceil = ceil;
            cos2 = cos2;
            d46 = d47;
            d16 = d16;
            d44 = d53;
            d41 = d52;
            d15 = d49;
            d21 = d51;
            d45 = d48;
            d36 = d50;
        }
    }

    public static void b(h[] hVarArr, Path path) {
        int i10;
        float f10;
        float f11;
        int i11;
        int i12;
        char c10;
        h hVar;
        int i13;
        char c11;
        h hVar2;
        int i14;
        boolean z10;
        boolean z11;
        float f12;
        float f13;
        float f14;
        float f15;
        int i15;
        boolean z12;
        boolean z13;
        float f16;
        float f17;
        int i16;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        float f27;
        float f28;
        float f29;
        float f30;
        float f31;
        float f32;
        float f33;
        float f34;
        h[] hVarArr2 = hVarArr;
        Path path2 = path;
        float[] fArr = new float[6];
        char c12 = 'm';
        char c13 = 0;
        char c14 = 'm';
        int i17 = 0;
        while (i17 < hVarArr2.length) {
            h hVar3 = hVarArr2[i17];
            char c15 = hVar3.f4862a;
            float f35 = fArr[c13];
            float f36 = fArr[1];
            float f37 = fArr[2];
            float f38 = fArr[3];
            float f39 = fArr[4];
            float f40 = fArr[5];
            switch (c15) {
                case 'A':
                case 'a':
                    i10 = 7;
                    break;
                case 'C':
                case 'c':
                    i10 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i10 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i10 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f39, f40);
                    f35 = f39;
                    f37 = f35;
                    f36 = f40;
                    f38 = f36;
                    break;
            }
            i10 = 2;
            float f41 = f39;
            float f42 = f40;
            float f43 = f35;
            float f44 = f36;
            int i18 = 0;
            while (true) {
                float[] fArr2 = hVar3.f4863b;
                if (i18 < fArr2.length) {
                    if (c15 != 'A') {
                        if (c15 != 'C') {
                            if (c15 == 'H') {
                                float[] fArr3 = fArr2;
                                i11 = i18;
                                c10 = c15;
                                hVar = hVar3;
                                i12 = i17;
                                int i19 = i11 + 0;
                                path2.lineTo(fArr3[i19], f44);
                                f43 = fArr3[i19];
                            } else if (c15 == 'Q') {
                                float[] fArr4 = fArr2;
                                i15 = i18;
                                c10 = c15;
                                hVar = hVar3;
                                i12 = i17;
                                int i20 = i15 + 0;
                                int i21 = i15 + 1;
                                int i22 = i15 + 2;
                                int i23 = i15 + 3;
                                path2.quadTo(fArr4[i20], fArr4[i21], fArr4[i22], fArr4[i23]);
                                f15 = fArr4[i20];
                                f14 = fArr4[i21];
                                f43 = fArr4[i22];
                                f44 = fArr4[i23];
                            } else if (c15 == 'V') {
                                float[] fArr5 = fArr2;
                                i11 = i18;
                                c10 = c15;
                                hVar = hVar3;
                                i12 = i17;
                                int i24 = i11 + 0;
                                path2.lineTo(f43, fArr5[i24]);
                                f44 = fArr5[i24];
                            } else if (c15 != 'a') {
                                if (c15 != 'c') {
                                    if (c15 == 'h') {
                                        float[] fArr6 = fArr2;
                                        i11 = i18;
                                        float f45 = f44;
                                        int i25 = i11 + 0;
                                        path2.rLineTo(fArr6[i25], 0.0f);
                                        f43 += fArr6[i25];
                                    } else if (c15 != 'q') {
                                        if (c15 != 'v') {
                                            if (c15 != 'L') {
                                                if (c15 == 'M') {
                                                    float[] fArr7 = fArr2;
                                                    i11 = i18;
                                                    f26 = fArr7[i11 + 0];
                                                    f25 = fArr7[i11 + 1];
                                                    if (i11 > 0) {
                                                        path2.lineTo(f26, f25);
                                                    } else {
                                                        path2.moveTo(f26, f25);
                                                        f41 = f26;
                                                        f42 = f25;
                                                    }
                                                } else if (c15 == 'S') {
                                                    float[] fArr8 = fArr2;
                                                    i16 = i18;
                                                    float f46 = f44;
                                                    float f47 = f43;
                                                    if (c14 == 'c' || c14 == 's' || c14 == 'C' || c14 == 'S') {
                                                        f27 = (f46 * 2.0f) - f10;
                                                        f28 = (f47 * 2.0f) - f11;
                                                    } else {
                                                        f28 = f47;
                                                        f27 = f46;
                                                    }
                                                    int i26 = i16 + 0;
                                                    int i27 = i16 + 1;
                                                    int i28 = i16 + 2;
                                                    int i29 = i16 + 3;
                                                    path.cubicTo(f28, f27, fArr8[i26], fArr8[i27], fArr8[i28], fArr8[i29]);
                                                    float f48 = fArr8[i26];
                                                    float f49 = fArr8[i27];
                                                    f17 = fArr8[i28];
                                                    f16 = fArr8[i29];
                                                    f11 = f48;
                                                    f10 = f49;
                                                    f43 = f17;
                                                    f44 = f16;
                                                } else if (c15 == 'T') {
                                                    float[] fArr9 = fArr2;
                                                    i11 = i18;
                                                    float f50 = f44;
                                                    float f51 = f43;
                                                    if (c14 == 'q' || c14 == 't' || c14 == 'Q' || c14 == 'T') {
                                                        f29 = (f51 * 2.0f) - f11;
                                                        f30 = (f50 * 2.0f) - f10;
                                                    } else {
                                                        f29 = f51;
                                                        f30 = f50;
                                                    }
                                                    int i30 = i11 + 0;
                                                    int i31 = i11 + 1;
                                                    path2.quadTo(f29, f30, fArr9[i30], fArr9[i31]);
                                                    f10 = f30;
                                                    f11 = f29;
                                                    c10 = c15;
                                                    hVar = hVar3;
                                                    i12 = i17;
                                                    f43 = fArr9[i30];
                                                    f44 = fArr9[i31];
                                                } else if (c15 == 'l') {
                                                    float[] fArr10 = fArr2;
                                                    i11 = i18;
                                                    f23 = f44;
                                                    int i32 = i11 + 0;
                                                    int i33 = i11 + 1;
                                                    path2.rLineTo(fArr10[i32], fArr10[i33]);
                                                    f43 += fArr10[i32];
                                                    f24 = fArr10[i33];
                                                } else if (c15 == c12) {
                                                    float[] fArr11 = fArr2;
                                                    i11 = i18;
                                                    float f52 = fArr11[i11 + 0];
                                                    f43 += f52;
                                                    float f53 = fArr11[i11 + 1];
                                                    f44 += f53;
                                                    if (i11 > 0) {
                                                        path2.rLineTo(f52, f53);
                                                    } else {
                                                        path2.rMoveTo(f52, f53);
                                                        f42 = f44;
                                                        f41 = f43;
                                                    }
                                                } else if (c15 != 's') {
                                                    if (c15 == 't') {
                                                        if (c14 == 'q' || c14 == 't' || c14 == 'Q' || c14 == 'T') {
                                                            f33 = f43 - f11;
                                                            f34 = f44 - f10;
                                                        } else {
                                                            f34 = 0.0f;
                                                            f33 = 0.0f;
                                                        }
                                                        int i34 = i18 + 0;
                                                        int i35 = i18 + 1;
                                                        path2.rQuadTo(f33, f34, fArr2[i34], fArr2[i35]);
                                                        float f54 = f33 + f43;
                                                        float f55 = f34 + f44;
                                                        f43 += fArr2[i34];
                                                        f44 += fArr2[i35];
                                                        f10 = f55;
                                                        f11 = f54;
                                                    }
                                                    i11 = i18;
                                                } else {
                                                    if (c14 == 'c' || c14 == 's' || c14 == 'C' || c14 == 'S') {
                                                        float f56 = f43 - f11;
                                                        f32 = f44 - f10;
                                                        f31 = f56;
                                                    } else {
                                                        f32 = 0.0f;
                                                        f31 = 0.0f;
                                                    }
                                                    int i36 = i18 + 0;
                                                    float f57 = fArr2[i36];
                                                    int i37 = i18 + 1;
                                                    float f58 = fArr2[i37];
                                                    int i38 = i18 + 2;
                                                    int i39 = i18 + 3;
                                                    float[] fArr12 = fArr2;
                                                    i16 = i18;
                                                    float f59 = f32;
                                                    float f60 = f57;
                                                    float f61 = f58;
                                                    f18 = f44;
                                                    float f62 = f43;
                                                    path.rCubicTo(f31, f59, f60, f61, fArr2[i38], fArr2[i39]);
                                                    f21 = fArr12[i36] + f62;
                                                    f20 = fArr12[i37] + f18;
                                                    f19 = f62 + fArr12[i38];
                                                    f22 = fArr12[i39];
                                                }
                                                f43 = f41;
                                                f44 = f42;
                                            } else {
                                                float[] fArr13 = fArr2;
                                                i11 = i18;
                                                int i40 = i11 + 0;
                                                int i41 = i11 + 1;
                                                path2.lineTo(fArr13[i40], fArr13[i41]);
                                                f26 = fArr13[i40];
                                                f25 = fArr13[i41];
                                            }
                                            f43 = f26;
                                            f44 = f25;
                                        } else {
                                            float[] fArr14 = fArr2;
                                            i11 = i18;
                                            f23 = f44;
                                            float f63 = f43;
                                            int i42 = i11 + 0;
                                            path2.rLineTo(0.0f, fArr14[i42]);
                                            f24 = fArr14[i42];
                                        }
                                        f44 = f23 + f24;
                                    } else {
                                        float[] fArr15 = fArr2;
                                        i16 = i18;
                                        f18 = f44;
                                        float f64 = f43;
                                        int i43 = i16 + 0;
                                        int i44 = i16 + 1;
                                        int i45 = i16 + 2;
                                        int i46 = i16 + 3;
                                        path2.rQuadTo(fArr15[i43], fArr15[i44], fArr15[i45], fArr15[i46]);
                                        f21 = fArr15[i43] + f64;
                                        f20 = fArr15[i44] + f18;
                                        float f65 = f64 + fArr15[i45];
                                        float f66 = fArr15[i46];
                                        f19 = f65;
                                        f22 = f66;
                                    }
                                    c10 = c15;
                                    hVar = hVar3;
                                    i12 = i17;
                                } else {
                                    float[] fArr16 = fArr2;
                                    i16 = i18;
                                    f18 = f44;
                                    float f67 = f43;
                                    int i47 = i16 + 2;
                                    int i48 = i16 + 3;
                                    int i49 = i16 + 4;
                                    int i50 = i16 + 5;
                                    path.rCubicTo(fArr16[i16 + 0], fArr16[i16 + 1], fArr16[i47], fArr16[i48], fArr16[i49], fArr16[i50]);
                                    f21 = fArr16[i47] + f67;
                                    f20 = fArr16[i48] + f18;
                                    f19 = f67 + fArr16[i49];
                                    f22 = fArr16[i50];
                                }
                                f16 = f18 + f22;
                                f11 = f21;
                                f10 = f20;
                                f17 = f19;
                                f43 = f17;
                                f44 = f16;
                                c10 = c15;
                                hVar = hVar3;
                                i12 = i17;
                            } else {
                                float[] fArr17 = fArr2;
                                i13 = i18;
                                float f68 = f44;
                                float f69 = f43;
                                int i51 = i13 + 5;
                                float f70 = fArr17[i51] + f69;
                                int i52 = i13 + 6;
                                float f71 = fArr17[i52] + f68;
                                float f72 = fArr17[i13 + 0];
                                float f73 = fArr17[i13 + 1];
                                float f74 = fArr17[i13 + 2];
                                if (fArr17[i13 + 3] != 0.0f) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (fArr17[i13 + 4] != 0.0f) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                c11 = c15;
                                float f75 = f74;
                                hVar2 = hVar3;
                                i14 = i17;
                                a(path, f69, f68, f70, f71, f72, f73, f75, z12, z13);
                                f12 = f69 + fArr17[i51];
                                f13 = f68 + fArr17[i52];
                            }
                            i18 = i11 + i10;
                            hVar3 = hVar;
                            c14 = c10;
                            c15 = c14;
                            i17 = i12;
                            c12 = 'm';
                            h[] hVarArr3 = hVarArr;
                        } else {
                            float[] fArr18 = fArr2;
                            i15 = i18;
                            c10 = c15;
                            hVar = hVar3;
                            i12 = i17;
                            int i53 = i15 + 2;
                            int i54 = i15 + 3;
                            int i55 = i15 + 4;
                            int i56 = i15 + 5;
                            path.cubicTo(fArr18[i15 + 0], fArr18[i15 + 1], fArr18[i53], fArr18[i54], fArr18[i55], fArr18[i56]);
                            float f76 = fArr18[i55];
                            float f77 = fArr18[i56];
                            f15 = fArr18[i53];
                            f43 = f76;
                            f44 = f77;
                            f14 = fArr18[i54];
                        }
                        f11 = f15;
                        f10 = f14;
                        i18 = i11 + i10;
                        hVar3 = hVar;
                        c14 = c10;
                        c15 = c14;
                        i17 = i12;
                        c12 = 'm';
                        h[] hVarArr32 = hVarArr;
                    } else {
                        float[] fArr19 = fArr2;
                        i13 = i18;
                        float f78 = f44;
                        float f79 = f43;
                        c11 = c15;
                        hVar2 = hVar3;
                        i14 = i17;
                        int i57 = i13 + 5;
                        float f80 = fArr19[i57];
                        int i58 = i13 + 6;
                        float f81 = fArr19[i58];
                        float f82 = fArr19[i13 + 0];
                        float f83 = fArr19[i13 + 1];
                        float f84 = fArr19[i13 + 2];
                        if (fArr19[i13 + 3] != 0.0f) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (fArr19[i13 + 4] != 0.0f) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        a(path, f79, f78, f80, f81, f82, f83, f84, z10, z11);
                        f12 = fArr19[i57];
                        f13 = fArr19[i58];
                    }
                    f10 = f44;
                    f11 = f43;
                    i18 = i11 + i10;
                    hVar3 = hVar;
                    c14 = c10;
                    c15 = c14;
                    i17 = i12;
                    c12 = 'm';
                    h[] hVarArr322 = hVarArr;
                } else {
                    int i59 = i17;
                    fArr[0] = f43;
                    fArr[1] = f44;
                    fArr[2] = f11;
                    fArr[3] = f10;
                    fArr[4] = f41;
                    fArr[5] = f42;
                    i17 = i59 + 1;
                    c14 = hVarArr[i59].f4862a;
                    c12 = 'm';
                    c13 = 0;
                    hVarArr2 = hVarArr;
                }
            }
        }
    }

    public h(h hVar) {
        this.f4862a = hVar.f4862a;
        float[] fArr = hVar.f4863b;
        this.f4863b = i.b(fArr, fArr.length);
    }
}
