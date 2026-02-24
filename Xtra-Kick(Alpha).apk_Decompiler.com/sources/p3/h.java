package p3;

import android.content.pm.PackageInfo;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final e f12544a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final f f12545b = new f();

    private h() {
    }

    public static void a(PackageInfo packageInfo, File file) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
            return;
        } catch (IOException unused) {
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [byte[], p3.c[]] */
    /* JADX WARNING: type inference failed for: r1v1, types: [byte[], p3.c[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0233, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x023e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:?, code lost:
        r5.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b0, code lost:
        if (r8.canWrite() == false) goto L_0x00ba;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:195:0x0227, B:205:0x023a] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01b5 A[SYNTHETIC, Splitter:B:145:0x01b5] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x026f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00eb A[SYNTHETIC, Splitter:B:62:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r16, n.a r17, p3.g r18, boolean r19) {
        /*
            r1 = r16
            r5 = r18
            android.content.Context r0 = r16.getApplicationContext()
            java.lang.String r2 = r0.getPackageName()
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()
            android.content.res.AssetManager r4 = r0.getAssets()
            java.io.File r0 = new java.io.File
            java.lang.String r3 = r3.sourceDir
            r0.<init>(r3)
            java.lang.String r6 = r0.getName()
            android.content.pm.PackageManager r0 = r16.getPackageManager()
            r9 = 0
            android.content.pm.PackageInfo r10 = r0.getPackageInfo(r2, r9)     // Catch:{ NameNotFoundException -> 0x028a }
            java.io.File r11 = r16.getFilesDir()
            r12 = 1
            r13 = 0
            if (r19 != 0) goto L_0x0079
            java.io.File r0 = new java.io.File
            java.lang.String r3 = "profileinstaller_profileWrittenFor_lastUpdateTime.dat"
            r0.<init>(r11, r3)
            boolean r3 = r0.exists()
            if (r3 != 0) goto L_0x003e
            goto L_0x006c
        L_0x003e:
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ IOException -> 0x006b }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x006b }
            r7.<init>(r0)     // Catch:{ IOException -> 0x006b }
            r3.<init>(r7)     // Catch:{ IOException -> 0x006b }
            long r14 = r3.readLong()     // Catch:{ all -> 0x005f }
            r3.close()     // Catch:{ IOException -> 0x006b }
            long r8 = r10.lastUpdateTime
            int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x0057
            r0 = 1
            goto L_0x0058
        L_0x0057:
            r0 = 0
        L_0x0058:
            if (r0 == 0) goto L_0x006d
            r3 = 2
            r5.t(r3, r13)
            goto L_0x006d
        L_0x005f:
            r0 = move-exception
            r7 = r0
            r3.close()     // Catch:{ all -> 0x0065 }
            goto L_0x006a
        L_0x0065:
            r0 = move-exception
            r3 = r0
            r7.addSuppressed(r3)     // Catch:{ IOException -> 0x006b }
        L_0x006a:
            throw r7     // Catch:{ IOException -> 0x006b }
        L_0x006b:
        L_0x006c:
            r0 = 0
        L_0x006d:
            if (r0 != 0) goto L_0x0070
            goto L_0x0079
        L_0x0070:
            r16.getPackageName()
            r2 = 0
            p3.q.b(r1, r2)
            goto L_0x0277
        L_0x0079:
            r16.getPackageName()
            int r0 = android.os.Build.VERSION.SDK_INT
            java.io.File r8 = new java.io.File
            java.io.File r3 = new java.io.File
            java.lang.String r7 = "/data/misc/profiles/cur/0"
            r3.<init>(r7, r2)
            java.lang.String r2 = "primary.prof"
            r8.<init>(r3, r2)
            p3.b r9 = new p3.b
            r2 = r9
            r3 = r4
            r4 = r17
            r5 = r18
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = 4
            byte[] r3 = r9.f12529d
            if (r3 != 0) goto L_0x00a6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4 = 3
            r9.b(r4, r0)
            goto L_0x00bd
        L_0x00a6:
            boolean r0 = r8.exists()
            if (r0 == 0) goto L_0x00b3
            boolean r0 = r8.canWrite()
            if (r0 != 0) goto L_0x00b6
            goto L_0x00ba
        L_0x00b3:
            r8.createNewFile()     // Catch:{ IOException -> 0x00ba }
        L_0x00b6:
            r9.f12532g = r12
            r0 = 1
            goto L_0x00be
        L_0x00ba:
            r9.b(r2, r13)
        L_0x00bd:
            r0 = 0
        L_0x00be:
            if (r0 != 0) goto L_0x00c4
            r2 = 0
            r4 = 1
            goto L_0x026d
        L_0x00c4:
            android.content.res.AssetManager r4 = r9.f12526a
            p3.g r5 = r9.f12528c
            boolean r0 = r9.f12532g
            java.lang.String r6 = "This device doesn't support aot. Did you call deviceSupportsAotProfile()?"
            if (r0 == 0) goto L_0x0284
            byte[] r7 = p3.n.f12549a
            r14 = 8
            if (r3 != 0) goto L_0x00d6
            goto L_0x01a6
        L_0x00d6:
            java.lang.String r0 = "dexopt/baseline.prof"
            java.io.FileInputStream r0 = r9.a(r4, r0)     // Catch:{ FileNotFoundException -> 0x00e1, IOException -> 0x00de }
            r15 = r0
            goto L_0x00e7
        L_0x00de:
            r0 = move-exception
            r15 = 7
            goto L_0x00e3
        L_0x00e1:
            r0 = move-exception
            r15 = 6
        L_0x00e3:
            r5.t(r15, r0)
            r15 = r13
        L_0x00e7:
            java.lang.String r8 = "Invalid magic"
            if (r15 == 0) goto L_0x0139
            byte[] r0 = p3.d.b(r15, r2)     // Catch:{ IOException -> 0x010e, IllegalStateException -> 0x010a }
            boolean r0 = java.util.Arrays.equals(r7, r0)     // Catch:{ IOException -> 0x010e, IllegalStateException -> 0x010a }
            if (r0 == 0) goto L_0x0110
            byte[] r0 = p3.d.b(r15, r2)     // Catch:{ IOException -> 0x010e, IllegalStateException -> 0x010a }
            java.lang.String r12 = r9.f12531f     // Catch:{ IOException -> 0x010e, IllegalStateException -> 0x010a }
            p3.c[] r12 = p3.n.h(r15, r0, r12)     // Catch:{ IOException -> 0x010e, IllegalStateException -> 0x010a }
            r15.close()     // Catch:{ IOException -> 0x0103 }
            goto L_0x012b
        L_0x0103:
            r0 = move-exception
            r15 = r0
            r13 = 7
            r5.t(r13, r15)
            goto L_0x012b
        L_0x010a:
            r0 = move-exception
            goto L_0x0118
        L_0x010c:
            r0 = move-exception
            goto L_0x0116
        L_0x010e:
            r0 = move-exception
            goto L_0x011d
        L_0x0110:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x010e, IllegalStateException -> 0x010a }
            r0.<init>(r8)     // Catch:{ IOException -> 0x010e, IllegalStateException -> 0x010a }
            throw r0     // Catch:{ IOException -> 0x010e, IllegalStateException -> 0x010a }
        L_0x0116:
            r1 = r0
            goto L_0x012e
        L_0x0118:
            r5.t(r14, r0)     // Catch:{ all -> 0x010c }
            r12 = 7
            goto L_0x0121
        L_0x011d:
            r12 = 7
            r5.t(r12, r0)     // Catch:{ all -> 0x010c }
        L_0x0121:
            r15.close()     // Catch:{ IOException -> 0x0125 }
            goto L_0x012a
        L_0x0125:
            r0 = move-exception
            r13 = r0
            r5.t(r12, r13)
        L_0x012a:
            r12 = 0
        L_0x012b:
            r9.f12533h = r12
            goto L_0x0139
        L_0x012e:
            r15.close()     // Catch:{ IOException -> 0x0132 }
            goto L_0x0138
        L_0x0132:
            r0 = move-exception
            r2 = r0
            r3 = 7
            r5.t(r3, r2)
        L_0x0138:
            throw r1
        L_0x0139:
            p3.c[] r0 = r9.f12533h
            if (r0 == 0) goto L_0x01a6
            int r12 = android.os.Build.VERSION.SDK_INT
            r13 = 24
            if (r12 < r13) goto L_0x0154
            r15 = 34
            if (r12 <= r15) goto L_0x0148
            goto L_0x0154
        L_0x0148:
            if (r12 == r13) goto L_0x0152
            r13 = 25
            if (r12 == r13) goto L_0x0152
            switch(r12) {
                case 31: goto L_0x0152;
                case 32: goto L_0x0152;
                case 33: goto L_0x0152;
                case 34: goto L_0x0152;
                default: goto L_0x0151;
            }
        L_0x0151:
            goto L_0x0154
        L_0x0152:
            r12 = 1
            goto L_0x0155
        L_0x0154:
            r12 = 0
        L_0x0155:
            if (r12 == 0) goto L_0x01a6
            java.lang.String r12 = "dexopt/baseline.profm"
            java.io.FileInputStream r4 = r9.a(r4, r12)     // Catch:{ FileNotFoundException -> 0x019c, IOException -> 0x0199, IllegalStateException -> 0x0192 }
            if (r4 == 0) goto L_0x018c
            byte[] r12 = p3.n.f12550b     // Catch:{ all -> 0x0180 }
            byte[] r13 = p3.d.b(r4, r2)     // Catch:{ all -> 0x0180 }
            boolean r12 = java.util.Arrays.equals(r12, r13)     // Catch:{ all -> 0x0180 }
            if (r12 == 0) goto L_0x017a
            byte[] r2 = p3.d.b(r4, r2)     // Catch:{ all -> 0x0180 }
            p3.c[] r0 = p3.n.e(r4, r2, r3, r0)     // Catch:{ all -> 0x0180 }
            r9.f12533h = r0     // Catch:{ all -> 0x0180 }
            r4.close()     // Catch:{ FileNotFoundException -> 0x019c, IOException -> 0x0199, IllegalStateException -> 0x0192 }
            r0 = r9
            goto L_0x01a3
        L_0x017a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0180 }
            r0.<init>(r8)     // Catch:{ all -> 0x0180 }
            throw r0     // Catch:{ all -> 0x0180 }
        L_0x0180:
            r0 = move-exception
            r2 = r0
            r4.close()     // Catch:{ all -> 0x0186 }
            goto L_0x018b
        L_0x0186:
            r0 = move-exception
            r3 = r0
            r2.addSuppressed(r3)     // Catch:{ FileNotFoundException -> 0x019c, IOException -> 0x0199, IllegalStateException -> 0x0192 }
        L_0x018b:
            throw r2     // Catch:{ FileNotFoundException -> 0x019c, IOException -> 0x0199, IllegalStateException -> 0x0192 }
        L_0x018c:
            if (r4 == 0) goto L_0x01a2
            r4.close()     // Catch:{ FileNotFoundException -> 0x019c, IOException -> 0x0199, IllegalStateException -> 0x0192 }
            goto L_0x01a2
        L_0x0192:
            r0 = move-exception
            r2 = 0
            r9.f12533h = r2
            r2 = 8
            goto L_0x019f
        L_0x0199:
            r0 = move-exception
            r2 = 7
            goto L_0x019f
        L_0x019c:
            r0 = move-exception
            r2 = 9
        L_0x019f:
            r5.t(r2, r0)
        L_0x01a2:
            r0 = 0
        L_0x01a3:
            if (r0 == 0) goto L_0x01a6
            r9 = r0
        L_0x01a6:
            p3.g r2 = r9.f12528c
            p3.c[] r0 = r9.f12533h
            if (r0 == 0) goto L_0x01f8
            byte[] r3 = r9.f12529d
            if (r3 != 0) goto L_0x01b1
            goto L_0x01f8
        L_0x01b1:
            boolean r4 = r9.f12532g
            if (r4 == 0) goto L_0x01f2
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01e9, IllegalStateException -> 0x01e7 }
            r4.<init>()     // Catch:{ IOException -> 0x01e9, IllegalStateException -> 0x01e7 }
            r4.write(r7)     // Catch:{ all -> 0x01db }
            r4.write(r3)     // Catch:{ all -> 0x01db }
            boolean r0 = p3.n.j(r4, r3, r0)     // Catch:{ all -> 0x01db }
            if (r0 != 0) goto L_0x01d1
            r0 = 5
            r3 = 0
            r2.t(r0, r3)     // Catch:{ all -> 0x01db }
            r9.f12533h = r3     // Catch:{ all -> 0x01db }
            r4.close()     // Catch:{ IOException -> 0x01e9, IllegalStateException -> 0x01e7 }
            goto L_0x01f8
        L_0x01d1:
            byte[] r0 = r4.toByteArray()     // Catch:{ all -> 0x01db }
            r9.f12534i = r0     // Catch:{ all -> 0x01db }
            r4.close()     // Catch:{ IOException -> 0x01e9, IllegalStateException -> 0x01e7 }
            goto L_0x01ee
        L_0x01db:
            r0 = move-exception
            r3 = r0
            r4.close()     // Catch:{ all -> 0x01e1 }
            goto L_0x01e6
        L_0x01e1:
            r0 = move-exception
            r4 = r0
            r3.addSuppressed(r4)     // Catch:{ IOException -> 0x01e9, IllegalStateException -> 0x01e7 }
        L_0x01e6:
            throw r3     // Catch:{ IOException -> 0x01e9, IllegalStateException -> 0x01e7 }
        L_0x01e7:
            r0 = move-exception
            goto L_0x01eb
        L_0x01e9:
            r0 = move-exception
            r14 = 7
        L_0x01eb:
            r2.t(r14, r0)
        L_0x01ee:
            r2 = 0
            r9.f12533h = r2
            goto L_0x01f8
        L_0x01f2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r6)
            throw r0
        L_0x01f8:
            byte[] r0 = r9.f12534i
            if (r0 != 0) goto L_0x01ff
            r4 = 1
            goto L_0x0267
        L_0x01ff:
            boolean r2 = r9.f12532g
            if (r2 == 0) goto L_0x027e
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ FileNotFoundException -> 0x025e, IOException -> 0x0257 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x025e, IOException -> 0x0257 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0244 }
            java.io.File r0 = r9.f12530e     // Catch:{ all -> 0x0244 }
            r3.<init>(r0)     // Catch:{ all -> 0x0244 }
            r0 = 512(0x200, float:7.175E-43)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0237 }
        L_0x0213:
            int r4 = r2.read(r0)     // Catch:{ all -> 0x0237 }
            if (r4 <= 0) goto L_0x0222
            r5 = 0
            r3.write(r0, r5, r4)     // Catch:{ all -> 0x021e }
            goto L_0x0213
        L_0x021e:
            r0 = move-exception
            r5 = r0
            r4 = 1
            goto L_0x023a
        L_0x0222:
            r4 = 1
            r5 = 0
            r9.b(r4, r5)     // Catch:{ all -> 0x0235 }
            r3.close()     // Catch:{ all -> 0x0233 }
            r2.close()     // Catch:{ FileNotFoundException -> 0x0253, IOException -> 0x0251 }
            r9.f12534i = r5
            r9.f12533h = r5
            r2 = 1
            goto L_0x0268
        L_0x0233:
            r0 = move-exception
            goto L_0x0246
        L_0x0235:
            r0 = move-exception
            goto L_0x0239
        L_0x0237:
            r0 = move-exception
            r4 = 1
        L_0x0239:
            r5 = r0
        L_0x023a:
            r3.close()     // Catch:{ all -> 0x023e }
            goto L_0x0243
        L_0x023e:
            r0 = move-exception
            r3 = r0
            r5.addSuppressed(r3)     // Catch:{ all -> 0x0233 }
        L_0x0243:
            throw r5     // Catch:{ all -> 0x0233 }
        L_0x0244:
            r0 = move-exception
            r4 = 1
        L_0x0246:
            r3 = r0
            r2.close()     // Catch:{ all -> 0x024b }
            goto L_0x0250
        L_0x024b:
            r0 = move-exception
            r2 = r0
            r3.addSuppressed(r2)     // Catch:{ FileNotFoundException -> 0x0253, IOException -> 0x0251 }
        L_0x0250:
            throw r3     // Catch:{ FileNotFoundException -> 0x0253, IOException -> 0x0251 }
        L_0x0251:
            r0 = move-exception
            goto L_0x0259
        L_0x0253:
            r0 = move-exception
            goto L_0x0260
        L_0x0255:
            r0 = move-exception
            goto L_0x0278
        L_0x0257:
            r0 = move-exception
            r4 = 1
        L_0x0259:
            r2 = 7
        L_0x025a:
            r9.b(r2, r0)     // Catch:{ all -> 0x0255 }
            goto L_0x0262
        L_0x025e:
            r0 = move-exception
            r4 = 1
        L_0x0260:
            r2 = 6
            goto L_0x025a
        L_0x0262:
            r2 = 0
            r9.f12534i = r2
            r9.f12533h = r2
        L_0x0267:
            r2 = 0
        L_0x0268:
            if (r2 == 0) goto L_0x026d
            a(r10, r11)
        L_0x026d:
            if (r2 == 0) goto L_0x0273
            if (r19 == 0) goto L_0x0273
            r9 = 1
            goto L_0x0274
        L_0x0273:
            r9 = 0
        L_0x0274:
            p3.q.b(r1, r9)
        L_0x0277:
            return
        L_0x0278:
            r1 = 0
            r9.f12534i = r1
            r9.f12533h = r1
            throw r0
        L_0x027e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r6)
            throw r0
        L_0x0284:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r6)
            throw r0
        L_0x028a:
            r0 = move-exception
            r2 = r0
            r3 = 7
            r5.t(r3, r2)
            r2 = 0
            p3.q.b(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.h.b(android.content.Context, n.a, p3.g, boolean):void");
    }
}
