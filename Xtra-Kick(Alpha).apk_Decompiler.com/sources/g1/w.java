package g1;

import android.net.Uri;
import java.util.List;
import java.util.Map;

public final class w {
    private w() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0196, code lost:
        if (r0.equals("video/mp2t") == false) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r23) {
        /*
            r0 = r23
            r1 = -1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.ArrayList r2 = g1.a1.f6284a
            int r2 = r23.hashCode()
            r3 = 2
            r4 = 1
            r5 = 0
            switch(r2) {
                case -1007807498: goto L_0x002a;
                case -586683234: goto L_0x001f;
                case 187090231: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            r2 = -1
            goto L_0x0034
        L_0x0014:
            java.lang.String r2 = "audio/mp3"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x001d
            goto L_0x0012
        L_0x001d:
            r2 = 2
            goto L_0x0034
        L_0x001f:
            java.lang.String r2 = "audio/x-wav"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0028
            goto L_0x0012
        L_0x0028:
            r2 = 1
            goto L_0x0034
        L_0x002a:
            java.lang.String r2 = "audio/x-flac"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0033
            goto L_0x0012
        L_0x0033:
            r2 = 0
        L_0x0034:
            java.lang.String r6 = "audio/mpeg"
            java.lang.String r7 = "audio/wav"
            java.lang.String r8 = "audio/flac"
            switch(r2) {
                case 0: goto L_0x0042;
                case 1: goto L_0x0040;
                case 2: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0043
        L_0x003e:
            r0 = r6
            goto L_0x0043
        L_0x0040:
            r0 = r7
            goto L_0x0043
        L_0x0042:
            r0 = r8
        L_0x0043:
            int r2 = r0.hashCode()
            r9 = 16
            r10 = 15
            r11 = 14
            r12 = 13
            r13 = 12
            r14 = 11
            r15 = 10
            r16 = 9
            r17 = 8
            r18 = 7
            r19 = 6
            r20 = 5
            r21 = 4
            r22 = 3
            switch(r2) {
                case -2123537834: goto L_0x01a6;
                case -1662384011: goto L_0x019a;
                case -1662384007: goto L_0x0190;
                case -1662095187: goto L_0x0184;
                case -1606874997: goto L_0x0178;
                case -1487394660: goto L_0x016c;
                case -1248337486: goto L_0x0160;
                case -1079884372: goto L_0x0154;
                case -1004728940: goto L_0x0147;
                case -387023398: goto L_0x0139;
                case -43467528: goto L_0x012b;
                case 13915911: goto L_0x011d;
                case 187078296: goto L_0x010f;
                case 187078297: goto L_0x0101;
                case 187078669: goto L_0x00f3;
                case 187090232: goto L_0x00e5;
                case 187091926: goto L_0x00d8;
                case 187099443: goto L_0x00cd;
                case 1331848029: goto L_0x00c0;
                case 1503095341: goto L_0x00b3;
                case 1504578661: goto L_0x00a6;
                case 1504619009: goto L_0x009b;
                case 1504824762: goto L_0x008e;
                case 1504831518: goto L_0x0083;
                case 1505118770: goto L_0x0076;
                case 2039520277: goto L_0x0069;
                default: goto L_0x0066;
            }
        L_0x0066:
            r3 = -1
            goto L_0x01b1
        L_0x0069:
            java.lang.String r2 = "video/x-matroska"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0072
            goto L_0x0066
        L_0x0072:
            r3 = 25
            goto L_0x01b1
        L_0x0076:
            java.lang.String r2 = "audio/webm"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x007f
            goto L_0x0066
        L_0x007f:
            r3 = 24
            goto L_0x01b1
        L_0x0083:
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x008a
            goto L_0x0066
        L_0x008a:
            r3 = 23
            goto L_0x01b1
        L_0x008e:
            java.lang.String r2 = "audio/midi"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0097
            goto L_0x0066
        L_0x0097:
            r3 = 22
            goto L_0x01b1
        L_0x009b:
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x00a2
            goto L_0x0066
        L_0x00a2:
            r3 = 21
            goto L_0x01b1
        L_0x00a6:
            java.lang.String r2 = "audio/eac3"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00af
            goto L_0x0066
        L_0x00af:
            r3 = 20
            goto L_0x01b1
        L_0x00b3:
            java.lang.String r2 = "audio/3gpp"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00bc
            goto L_0x0066
        L_0x00bc:
            r3 = 19
            goto L_0x01b1
        L_0x00c0:
            java.lang.String r2 = "video/mp4"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00c9
            goto L_0x0066
        L_0x00c9:
            r3 = 18
            goto L_0x01b1
        L_0x00cd:
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x00d4
            goto L_0x0066
        L_0x00d4:
            r3 = 17
            goto L_0x01b1
        L_0x00d8:
            java.lang.String r2 = "audio/ogg"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00e1
            goto L_0x0066
        L_0x00e1:
            r3 = 16
            goto L_0x01b1
        L_0x00e5:
            java.lang.String r2 = "audio/mp4"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00ef
            goto L_0x0066
        L_0x00ef:
            r3 = 15
            goto L_0x01b1
        L_0x00f3:
            java.lang.String r2 = "audio/amr"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00fd
            goto L_0x0066
        L_0x00fd:
            r3 = 14
            goto L_0x01b1
        L_0x0101:
            java.lang.String r2 = "audio/ac4"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x010b
            goto L_0x0066
        L_0x010b:
            r3 = 13
            goto L_0x01b1
        L_0x010f:
            java.lang.String r2 = "audio/ac3"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0119
            goto L_0x0066
        L_0x0119:
            r3 = 12
            goto L_0x01b1
        L_0x011d:
            java.lang.String r2 = "video/x-flv"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0127
            goto L_0x0066
        L_0x0127:
            r3 = 11
            goto L_0x01b1
        L_0x012b:
            java.lang.String r2 = "application/webm"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0135
            goto L_0x0066
        L_0x0135:
            r3 = 10
            goto L_0x01b1
        L_0x0139:
            java.lang.String r2 = "audio/x-matroska"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0143
            goto L_0x0066
        L_0x0143:
            r3 = 9
            goto L_0x01b1
        L_0x0147:
            java.lang.String r2 = "text/vtt"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0151
            goto L_0x0066
        L_0x0151:
            r3 = 8
            goto L_0x01b1
        L_0x0154:
            java.lang.String r2 = "video/x-msvideo"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x015e
            goto L_0x0066
        L_0x015e:
            r3 = 7
            goto L_0x01b1
        L_0x0160:
            java.lang.String r2 = "application/mp4"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x016a
            goto L_0x0066
        L_0x016a:
            r3 = 6
            goto L_0x01b1
        L_0x016c:
            java.lang.String r2 = "image/jpeg"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0176
            goto L_0x0066
        L_0x0176:
            r3 = 5
            goto L_0x01b1
        L_0x0178:
            java.lang.String r2 = "audio/amr-wb"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0182
            goto L_0x0066
        L_0x0182:
            r3 = 4
            goto L_0x01b1
        L_0x0184:
            java.lang.String r2 = "video/webm"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x018e
            goto L_0x0066
        L_0x018e:
            r3 = 3
            goto L_0x01b1
        L_0x0190:
            java.lang.String r2 = "video/mp2t"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01b1
            goto L_0x0066
        L_0x019a:
            java.lang.String r2 = "video/mp2p"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01a4
            goto L_0x0066
        L_0x01a4:
            r3 = 1
            goto L_0x01b1
        L_0x01a6:
            java.lang.String r2 = "audio/eac3-joc"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01b0
            goto L_0x0066
        L_0x01b0:
            r3 = 0
        L_0x01b1:
            switch(r3) {
                case 0: goto L_0x01c4;
                case 1: goto L_0x01c3;
                case 2: goto L_0x01c2;
                case 3: goto L_0x01c1;
                case 4: goto L_0x01c0;
                case 5: goto L_0x01bf;
                case 6: goto L_0x01be;
                case 7: goto L_0x01bd;
                case 8: goto L_0x01bc;
                case 9: goto L_0x01c1;
                case 10: goto L_0x01c1;
                case 11: goto L_0x01bb;
                case 12: goto L_0x01c4;
                case 13: goto L_0x01ba;
                case 14: goto L_0x01c0;
                case 15: goto L_0x01be;
                case 16: goto L_0x01b9;
                case 17: goto L_0x01b8;
                case 18: goto L_0x01be;
                case 19: goto L_0x01c0;
                case 20: goto L_0x01c4;
                case 21: goto L_0x01b7;
                case 22: goto L_0x01b6;
                case 23: goto L_0x01b5;
                case 24: goto L_0x01c1;
                case 25: goto L_0x01c1;
                default: goto L_0x01b4;
            }
        L_0x01b4:
            return r1
        L_0x01b5:
            return r18
        L_0x01b6:
            return r10
        L_0x01b7:
            return r21
        L_0x01b8:
            return r13
        L_0x01b9:
            return r16
        L_0x01ba:
            return r4
        L_0x01bb:
            return r20
        L_0x01bc:
            return r12
        L_0x01bd:
            return r9
        L_0x01be:
            return r17
        L_0x01bf:
            return r11
        L_0x01c0:
            return r22
        L_0x01c1:
            return r19
        L_0x01c2:
            return r14
        L_0x01c3:
            return r15
        L_0x01c4:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.w.a(java.lang.String):int");
    }

    public static int b(Map map) {
        List list = (List) map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        return lastPathSegment.endsWith(".avi") ? 16 : -1;
    }
}
