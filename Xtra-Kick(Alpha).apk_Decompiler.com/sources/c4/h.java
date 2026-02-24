package c4;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import d0.t;
import e0.i;
import java.util.ArrayList;

public final class h {
    private h() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.animation.Animator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: android.animation.ObjectAnimator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x030a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.Animator a(android.content.Context r27, android.content.res.Resources r28, android.content.res.Resources.Theme r29, android.content.res.XmlResourceParser r30, android.util.AttributeSet r31, android.animation.AnimatorSet r32, int r33) {
        /*
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r32
            int r11 = r30.getDepth()
            r0 = 0
            r13 = 0
        L_0x000e:
            int r1 = r30.next()
            r2 = 3
            r14 = 0
            if (r1 != r2) goto L_0x001c
            int r3 = r30.getDepth()
            if (r3 <= r11) goto L_0x0330
        L_0x001c:
            r3 = 1
            if (r1 == r3) goto L_0x0330
            r4 = 2
            if (r1 == r4) goto L_0x0023
            goto L_0x000e
        L_0x0023:
            java.lang.String r1 = r30.getName()
            java.lang.String r5 = "objectAnimator"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0043
            android.animation.ObjectAnimator r6 = new android.animation.ObjectAnimator
            r6.<init>()
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r31
            r4 = r6
            r5 = r30
            e(r0, r1, r2, r3, r4, r5)
            goto L_0x005a
        L_0x0043:
            java.lang.String r5 = "animator"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x005d
            r4 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r31
            r5 = r30
            android.animation.ValueAnimator r6 = e(r0, r1, r2, r3, r4, r5)
        L_0x005a:
            r0 = r6
            goto L_0x0304
        L_0x005d:
            java.lang.String r5 = "set"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0090
            android.animation.AnimatorSet r15 = new android.animation.AnimatorSet
            r15.<init>()
            int[] r0 = c4.a.f2872h
            r6 = r31
            android.content.res.TypedArray r5 = d0.t.h(r7, r8, r6, r0)
            java.lang.String r0 = "ordering"
            int r16 = d0.t.d(r5, r9, r0, r14, r14)
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r17 = r5
            r5 = r15
            r6 = r16
            a(r0, r1, r2, r3, r4, r5, r6)
            r17.recycle()
            r0 = r15
            goto L_0x0304
        L_0x0090:
            java.lang.String r5 = "propertyValuesHolder"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0318
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r30)
            r6 = 0
        L_0x009d:
            int r15 = r30.getEventType()
            if (r15 == r2) goto L_0x02de
            if (r15 == r3) goto L_0x02de
            if (r15 == r4) goto L_0x00ab
            r30.next()
            goto L_0x009d
        L_0x00ab:
            java.lang.String r15 = r30.getName()
            boolean r15 = r15.equals(r5)
            if (r15 == 0) goto L_0x02c6
            int[] r15 = c4.a.f2873i
            android.content.res.TypedArray r15 = d0.t.h(r7, r8, r1, r15)
            java.lang.String r12 = "propertyName"
            java.lang.String r12 = d0.t.e(r15, r9, r12, r2)
            java.lang.String r14 = "valueType"
            r3 = 4
            int r14 = d0.t.d(r15, r9, r14, r4, r3)
            r4 = r14
            r19 = 0
        L_0x00cb:
            int r3 = r30.next()
            r21 = r1
            if (r3 == r2) goto L_0x01c0
            r1 = 1
            if (r3 == r1) goto L_0x01c0
            java.lang.String r1 = r30.getName()
            java.lang.String r3 = "keyframe"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x01ae
            int[] r1 = c4.a.f2874j
            java.lang.String r3 = "value"
            r2 = 4
            if (r4 != r2) goto L_0x0117
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r30)
            android.content.res.TypedArray r2 = d0.t.h(r7, r8, r2, r1)
            boolean r4 = d0.t.g(r9, r3)
            if (r4 != 0) goto L_0x00f9
            r4 = 0
            goto L_0x0100
        L_0x00f9:
            r4 = 0
            android.util.TypedValue r23 = r2.peekValue(r4)
            r4 = r23
        L_0x0100:
            if (r4 == 0) goto L_0x0105
            r23 = 1
            goto L_0x0107
        L_0x0105:
            r23 = 0
        L_0x0107:
            if (r23 == 0) goto L_0x0113
            int r4 = r4.type
            boolean r4 = d(r4)
            if (r4 == 0) goto L_0x0113
            r4 = 3
            goto L_0x0114
        L_0x0113:
            r4 = 0
        L_0x0114:
            r2.recycle()
        L_0x0117:
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r30)
            android.content.res.TypedArray r1 = d0.t.h(r7, r8, r2, r1)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r23 = r5
            java.lang.String r5 = "fraction"
            r7 = 3
            float r2 = d0.t.c(r1, r9, r5, r7, r2)
            boolean r5 = d0.t.g(r9, r3)
            if (r5 != 0) goto L_0x0132
            r7 = 0
            goto L_0x0137
        L_0x0132:
            r5 = 0
            android.util.TypedValue r7 = r1.peekValue(r5)
        L_0x0137:
            if (r7 == 0) goto L_0x013b
            r5 = 1
            goto L_0x013c
        L_0x013b:
            r5 = 0
        L_0x013c:
            r8 = 4
            if (r4 != r8) goto L_0x014d
            if (r5 == 0) goto L_0x014b
            int r7 = r7.type
            boolean r7 = d(r7)
            if (r7 == 0) goto L_0x014b
            r7 = 3
            goto L_0x014e
        L_0x014b:
            r7 = 0
            goto L_0x014e
        L_0x014d:
            r7 = r4
        L_0x014e:
            if (r5 == 0) goto L_0x016f
            if (r7 == 0) goto L_0x0164
            r5 = 1
            if (r7 == r5) goto L_0x015a
            r5 = 3
            if (r7 == r5) goto L_0x015a
            r2 = 0
            goto L_0x017a
        L_0x015a:
            r5 = 0
            int r3 = d0.t.d(r1, r9, r3, r5, r5)
            android.animation.Keyframe r2 = android.animation.Keyframe.ofInt(r2, r3)
            goto L_0x017a
        L_0x0164:
            r5 = 0
            r7 = 0
            float r3 = d0.t.c(r1, r9, r3, r5, r7)
            android.animation.Keyframe r2 = android.animation.Keyframe.ofFloat(r2, r3)
            goto L_0x017a
        L_0x016f:
            if (r7 != 0) goto L_0x0176
            android.animation.Keyframe r2 = android.animation.Keyframe.ofFloat(r2)
            goto L_0x017a
        L_0x0176:
            android.animation.Keyframe r2 = android.animation.Keyframe.ofInt(r2)
        L_0x017a:
            java.lang.String r3 = "interpolator"
            boolean r3 = d0.t.g(r9, r3)
            if (r3 != 0) goto L_0x0184
            r7 = 0
            goto L_0x018a
        L_0x0184:
            r3 = 0
            r5 = 1
            int r7 = r1.getResourceId(r5, r3)
        L_0x018a:
            r3 = r27
            if (r7 <= 0) goto L_0x0195
            android.view.animation.Interpolator r5 = android.view.animation.AnimationUtils.loadInterpolator(r3, r7)
            r2.setInterpolator(r5)
        L_0x0195:
            r1.recycle()
            r1 = r19
            if (r2 == 0) goto L_0x01aa
            if (r1 != 0) goto L_0x01a5
            java.util.ArrayList r19 = new java.util.ArrayList
            r19.<init>()
            r1 = r19
        L_0x01a5:
            r1.add(r2)
            r19 = r1
        L_0x01aa:
            r30.next()
            goto L_0x01b5
        L_0x01ae:
            r8 = 4
            r3 = r27
            r23 = r5
            r1 = r19
        L_0x01b5:
            r7 = r28
            r8 = r29
            r1 = r21
            r5 = r23
            r2 = 3
            goto L_0x00cb
        L_0x01c0:
            r3 = r27
            r23 = r5
            r1 = r19
            if (r1 == 0) goto L_0x02a9
            int r2 = r1.size()
            if (r2 <= 0) goto L_0x02a9
            r5 = 0
            java.lang.Object r7 = r1.get(r5)
            android.animation.Keyframe r7 = (android.animation.Keyframe) r7
            int r5 = r2 + -1
            java.lang.Object r5 = r1.get(r5)
            android.animation.Keyframe r5 = (android.animation.Keyframe) r5
            float r8 = r5.getFraction()
            r3 = 1065353216(0x3f800000, float:1.0)
            int r19 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r19 >= 0) goto L_0x01fe
            r19 = 0
            int r8 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r8 >= 0) goto L_0x01f1
            r5.setFraction(r3)
            goto L_0x01fe
        L_0x01f1:
            int r8 = r1.size()
            android.animation.Keyframe r5 = b(r5, r3)
            r1.add(r8, r5)
            int r2 = r2 + 1
        L_0x01fe:
            float r5 = r7.getFraction()
            r8 = 0
            int r19 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r19 == 0) goto L_0x0219
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x020f
            r7.setFraction(r8)
            goto L_0x0219
        L_0x020f:
            android.animation.Keyframe r5 = b(r7, r8)
            r7 = 0
            r1.add(r7, r5)
            int r2 = r2 + 1
        L_0x0219:
            android.animation.Keyframe[] r5 = new android.animation.Keyframe[r2]
            r1.toArray(r5)
            r1 = 0
        L_0x021f:
            if (r1 >= r2) goto L_0x029a
            r7 = r5[r1]
            float r8 = r7.getFraction()
            r19 = 0
            int r8 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r8 >= 0) goto L_0x028d
            if (r1 != 0) goto L_0x0231
            r8 = 0
            goto L_0x0237
        L_0x0231:
            int r8 = r2 + -1
            if (r1 != r8) goto L_0x023b
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0237:
            r7.setFraction(r8)
            goto L_0x028d
        L_0x023b:
            int r7 = r1 + 1
            r3 = r1
        L_0x023e:
            if (r7 >= r8) goto L_0x0255
            r20 = r5[r7]
            float r20 = r20.getFraction()
            r22 = 0
            int r20 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r20 < 0) goto L_0x024d
            goto L_0x0257
        L_0x024d:
            int r3 = r7 + 1
            r26 = r7
            r7 = r3
            r3 = r26
            goto L_0x023e
        L_0x0255:
            r22 = 0
        L_0x0257:
            int r7 = r3 + 1
            r7 = r5[r7]
            float r7 = r7.getFraction()
            int r8 = r1 + -1
            r8 = r5[r8]
            float r8 = r8.getFraction()
            float r7 = r7 - r8
            int r8 = r3 - r1
            r18 = 2
            int r8 = r8 + 2
            float r8 = (float) r8
            float r7 = r7 / r8
            r8 = r1
        L_0x0271:
            r20 = r2
            if (r8 > r3) goto L_0x0293
            r2 = r5[r8]
            int r24 = r8 + -1
            r24 = r5[r24]
            float r24 = r24.getFraction()
            r25 = r3
            float r3 = r24 + r7
            r2.setFraction(r3)
            int r8 = r8 + 1
            r2 = r20
            r3 = r25
            goto L_0x0271
        L_0x028d:
            r20 = r2
            r18 = 2
            r22 = 0
        L_0x0293:
            int r1 = r1 + 1
            r2 = r20
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L_0x021f
        L_0x029a:
            r18 = 2
            android.animation.PropertyValuesHolder r1 = android.animation.PropertyValuesHolder.ofKeyframe(r12, r5)
            r2 = 3
            if (r4 != r2) goto L_0x02ad
            c4.i r3 = c4.i.f2891a
            r1.setEvaluator(r3)
            goto L_0x02ad
        L_0x02a9:
            r2 = 3
            r18 = 2
            r1 = 0
        L_0x02ad:
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x02b5
            android.animation.PropertyValuesHolder r1 = c(r15, r14, r3, r4, r12)
        L_0x02b5:
            if (r1 == 0) goto L_0x02c2
            if (r6 != 0) goto L_0x02bf
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = r5
        L_0x02bf:
            r6.add(r1)
        L_0x02c2:
            r15.recycle()
            goto L_0x02ce
        L_0x02c6:
            r21 = r1
            r23 = r5
            r3 = 0
            r4 = 1
            r18 = 2
        L_0x02ce:
            r30.next()
            r7 = r28
            r8 = r29
            r1 = r21
            r5 = r23
            r3 = 1
            r4 = 2
            r14 = 0
            goto L_0x009d
        L_0x02de:
            r3 = 0
            r4 = 1
            if (r6 == 0) goto L_0x02f6
            int r1 = r6.size()
            android.animation.PropertyValuesHolder[] r2 = new android.animation.PropertyValuesHolder[r1]
            r14 = 0
        L_0x02e9:
            if (r14 >= r1) goto L_0x02f7
            java.lang.Object r3 = r6.get(r14)
            android.animation.PropertyValuesHolder r3 = (android.animation.PropertyValuesHolder) r3
            r2[r14] = r3
            int r14 = r14 + 1
            goto L_0x02e9
        L_0x02f6:
            r2 = 0
        L_0x02f7:
            if (r2 == 0) goto L_0x0303
            boolean r1 = r0 instanceof android.animation.ValueAnimator
            if (r1 == 0) goto L_0x0303
            r1 = r0
            android.animation.ValueAnimator r1 = (android.animation.ValueAnimator) r1
            r1.setValues(r2)
        L_0x0303:
            r14 = 1
        L_0x0304:
            if (r10 == 0) goto L_0x0312
            if (r14 != 0) goto L_0x0312
            if (r13 != 0) goto L_0x030f
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
        L_0x030f:
            r13.add(r0)
        L_0x0312:
            r7 = r28
            r8 = r29
            goto L_0x000e
        L_0x0318:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown animator name: "
            r1.<init>(r2)
            java.lang.String r2 = r30.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0330:
            r3 = 0
            if (r10 == 0) goto L_0x035b
            if (r13 == 0) goto L_0x035b
            int r1 = r13.size()
            android.animation.Animator[] r1 = new android.animation.Animator[r1]
            java.util.Iterator r2 = r13.iterator()
            r14 = 0
        L_0x0340:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0352
            java.lang.Object r3 = r2.next()
            android.animation.Animator r3 = (android.animation.Animator) r3
            int r4 = r14 + 1
            r1[r14] = r3
            r14 = r4
            goto L_0x0340
        L_0x0352:
            if (r33 != 0) goto L_0x0358
            r10.playTogether(r1)
            goto L_0x035b
        L_0x0358:
            r10.playSequentially(r1)
        L_0x035b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.h.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, android.content.res.XmlResourceParser, android.util.AttributeSet, android.animation.AnimatorSet, int):android.animation.Animator");
    }

    public static Keyframe b(Keyframe keyframe, float f10) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f10) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f10) : Keyframe.ofObject(f10);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.PropertyValuesHolder c(android.content.res.TypedArray r11, int r12, int r13, int r14, java.lang.String r15) {
        /*
            android.util.TypedValue r0 = r11.peekValue(r13)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000a
            r3 = 1
            goto L_0x000b
        L_0x000a:
            r3 = 0
        L_0x000b:
            if (r3 == 0) goto L_0x0010
            int r0 = r0.type
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            android.util.TypedValue r4 = r11.peekValue(r14)
            if (r4 == 0) goto L_0x0019
            r5 = 1
            goto L_0x001a
        L_0x0019:
            r5 = 0
        L_0x001a:
            if (r5 == 0) goto L_0x001f
            int r4 = r4.type
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            r6 = 4
            r7 = 3
            if (r12 != r6) goto L_0x0037
            if (r3 == 0) goto L_0x002c
            boolean r12 = d(r0)
            if (r12 != 0) goto L_0x0034
        L_0x002c:
            if (r5 == 0) goto L_0x0036
            boolean r12 = d(r4)
            if (r12 == 0) goto L_0x0036
        L_0x0034:
            r12 = 3
            goto L_0x0037
        L_0x0036:
            r12 = 0
        L_0x0037:
            if (r12 != 0) goto L_0x003b
            r6 = 1
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            r8 = 0
            r9 = 2
            if (r12 != r9) goto L_0x00a6
            java.lang.String r12 = r11.getString(r13)
            java.lang.String r11 = r11.getString(r14)
            e0.h[] r13 = e0.i.c(r12)
            e0.h[] r14 = e0.i.c(r11)
            if (r13 != 0) goto L_0x0054
            if (r14 == 0) goto L_0x0162
        L_0x0054:
            if (r13 == 0) goto L_0x0095
            c4.g r0 = new c4.g
            r0.<init>()
            if (r14 == 0) goto L_0x008a
            boolean r3 = e0.i.a(r13, r14)
            if (r3 == 0) goto L_0x006e
            java.lang.Object[] r11 = new java.lang.Object[r9]
            r11[r2] = r13
            r11[r1] = r14
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r0, r11)
            goto L_0x0092
        L_0x006e:
            android.view.InflateException r13 = new android.view.InflateException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = " Can't morph from "
            r14.<init>(r15)
            r14.append(r12)
            java.lang.String r12 = " to "
            r14.append(r12)
            r14.append(r11)
            java.lang.String r11 = r14.toString()
            r13.<init>(r11)
            throw r13
        L_0x008a:
            java.lang.Object[] r11 = new java.lang.Object[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r0, r11)
        L_0x0092:
            r8 = r11
            goto L_0x0162
        L_0x0095:
            if (r14 == 0) goto L_0x0162
            c4.g r11 = new c4.g
            r11.<init>()
            java.lang.Object[] r12 = new java.lang.Object[r1]
            r12[r2] = r14
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofObject(r15, r11, r12)
            goto L_0x0162
        L_0x00a6:
            if (r12 != r7) goto L_0x00ab
            c4.i r12 = c4.i.f2891a
            goto L_0x00ac
        L_0x00ab:
            r12 = r8
        L_0x00ac:
            r7 = 5
            r10 = 0
            if (r6 == 0) goto L_0x00f4
            if (r3 == 0) goto L_0x00de
            if (r0 != r7) goto L_0x00b9
            float r13 = r11.getDimension(r13, r10)
            goto L_0x00bd
        L_0x00b9:
            float r13 = r11.getFloat(r13, r10)
        L_0x00bd:
            if (r5 == 0) goto L_0x00d5
            if (r4 != r7) goto L_0x00c6
            float r11 = r11.getDimension(r14, r10)
            goto L_0x00ca
        L_0x00c6:
            float r11 = r11.getFloat(r14, r10)
        L_0x00ca:
            float[] r14 = new float[r9]
            r14[r2] = r13
            r14[r1] = r11
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofFloat(r15, r14)
            goto L_0x00f1
        L_0x00d5:
            float[] r11 = new float[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofFloat(r15, r11)
            goto L_0x00f1
        L_0x00de:
            if (r4 != r7) goto L_0x00e5
            float r11 = r11.getDimension(r14, r10)
            goto L_0x00e9
        L_0x00e5:
            float r11 = r11.getFloat(r14, r10)
        L_0x00e9:
            float[] r13 = new float[r1]
            r13[r2] = r11
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofFloat(r15, r13)
        L_0x00f1:
            r8 = r11
            goto L_0x015b
        L_0x00f4:
            if (r3 == 0) goto L_0x013a
            if (r0 != r7) goto L_0x00fe
            float r13 = r11.getDimension(r13, r10)
            int r13 = (int) r13
            goto L_0x010d
        L_0x00fe:
            boolean r0 = d(r0)
            if (r0 == 0) goto L_0x0109
            int r13 = r11.getColor(r13, r2)
            goto L_0x010d
        L_0x0109:
            int r13 = r11.getInt(r13, r2)
        L_0x010d:
            if (r5 == 0) goto L_0x0131
            if (r4 != r7) goto L_0x0117
            float r11 = r11.getDimension(r14, r10)
            int r11 = (int) r11
            goto L_0x0126
        L_0x0117:
            boolean r0 = d(r4)
            if (r0 == 0) goto L_0x0122
            int r11 = r11.getColor(r14, r2)
            goto L_0x0126
        L_0x0122:
            int r11 = r11.getInt(r14, r2)
        L_0x0126:
            int[] r14 = new int[r9]
            r14[r2] = r13
            r14[r1] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r14)
            goto L_0x015b
        L_0x0131:
            int[] r11 = new int[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r11)
            goto L_0x015b
        L_0x013a:
            if (r5 == 0) goto L_0x015b
            if (r4 != r7) goto L_0x0144
            float r11 = r11.getDimension(r14, r10)
            int r11 = (int) r11
            goto L_0x0153
        L_0x0144:
            boolean r13 = d(r4)
            if (r13 == 0) goto L_0x014f
            int r11 = r11.getColor(r14, r2)
            goto L_0x0153
        L_0x014f:
            int r11 = r11.getInt(r14, r2)
        L_0x0153:
            int[] r13 = new int[r1]
            r13[r2] = r11
            android.animation.PropertyValuesHolder r8 = android.animation.PropertyValuesHolder.ofInt(r15, r13)
        L_0x015b:
            if (r8 == 0) goto L_0x0162
            if (r12 == 0) goto L_0x0162
            r8.setEvaluator(r12)
        L_0x0162:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.h.c(android.content.res.TypedArray, int, int, int, java.lang.String):android.animation.PropertyValuesHolder");
    }

    public static boolean d(int i10) {
        return i10 >= 28 && i10 <= 31;
    }

    public static ValueAnimator e(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlResourceParser xmlResourceParser) {
        ValueAnimator valueAnimator;
        TypedArray typedArray;
        ValueAnimator valueAnimator2;
        TypedArray typedArray2;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        AttributeSet attributeSet2 = attributeSet;
        XmlResourceParser xmlResourceParser2 = xmlResourceParser;
        TypedArray h10 = t.h(resources2, theme2, attributeSet2, a.f2871g);
        TypedArray h11 = t.h(resources2, theme2, attributeSet2, a.f2875k);
        if (objectAnimator == null) {
            valueAnimator = new ValueAnimator();
        } else {
            valueAnimator = objectAnimator;
        }
        long d10 = (long) t.d(h10, xmlResourceParser2, "duration", 1, 300);
        int i12 = 0;
        long d11 = (long) t.d(h10, xmlResourceParser2, "startOffset", 2, 0);
        int d12 = t.d(h10, xmlResourceParser2, "valueType", 7, 4);
        if (t.g(xmlResourceParser2, "valueFrom") && t.g(xmlResourceParser2, "valueTo")) {
            if (d12 == 4) {
                TypedValue peekValue = h10.peekValue(5);
                if (peekValue != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    i10 = peekValue.type;
                } else {
                    i10 = 0;
                }
                TypedValue peekValue2 = h10.peekValue(6);
                if (peekValue2 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    i11 = peekValue2.type;
                } else {
                    i11 = 0;
                }
                if ((!z10 || !d(i10)) && (!z11 || !d(i11))) {
                    d12 = 0;
                } else {
                    d12 = 3;
                }
            }
            PropertyValuesHolder c10 = c(h10, d12, 5, 6, "");
            if (c10 != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{c10});
            }
        }
        valueAnimator.setDuration(d10);
        valueAnimator.setStartDelay(d11);
        valueAnimator.setRepeatCount(t.d(h10, xmlResourceParser2, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(t.d(h10, xmlResourceParser2, "repeatMode", 4, 1));
        if (h11 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator;
            String e10 = t.e(h11, xmlResourceParser2, "pathData", 1);
            if (e10 != null) {
                String e11 = t.e(h11, xmlResourceParser2, "propertyXName", 2);
                String e12 = t.e(h11, xmlResourceParser2, "propertyYName", 3);
                if (e11 == null && e12 == null) {
                    throw new InflateException(h11.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path d13 = i.d(e10);
                PathMeasure pathMeasure = new PathMeasure(d13, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f10 = 0.0f;
                do {
                    f10 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f10));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(d13, false);
                int min = Math.min(100, ((int) (f10 / 0.5f)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f11 = f10 / ((float) (min - 1));
                valueAnimator2 = valueAnimator;
                typedArray = h10;
                int i13 = 0;
                float f12 = 0.0f;
                while (true) {
                    propertyValuesHolder = null;
                    if (i12 >= min) {
                        break;
                    }
                    int i14 = min;
                    pathMeasure2.getPosTan(f12 - ((Float) arrayList.get(i13)).floatValue(), fArr3, (float[]) null);
                    fArr[i12] = fArr3[0];
                    fArr2[i12] = fArr3[1];
                    f12 += f11;
                    int i15 = i13 + 1;
                    if (i15 < arrayList.size() && f12 > ((Float) arrayList.get(i15)).floatValue()) {
                        pathMeasure2.nextContour();
                        i13 = i15;
                    }
                    i12++;
                    min = i14;
                }
                if (e11 != null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofFloat(e11, fArr);
                } else {
                    propertyValuesHolder2 = null;
                }
                if (e12 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(e12, fArr2);
                }
                if (propertyValuesHolder2 == null) {
                    i12 = 0;
                    objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
                } else {
                    i12 = 0;
                    if (propertyValuesHolder == null) {
                        objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder2});
                    } else {
                        objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder2, propertyValuesHolder});
                    }
                }
            } else {
                valueAnimator2 = valueAnimator;
                typedArray = h10;
                objectAnimator2.setPropertyName(t.e(h11, xmlResourceParser2, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator;
            typedArray = h10;
        }
        if (!t.g(xmlResourceParser2, "interpolator")) {
            typedArray2 = typedArray;
        } else {
            typedArray2 = typedArray;
            i12 = typedArray2.getResourceId(i12, i12);
        }
        if (i12 > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, i12));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (h11 != null) {
            h11.recycle();
        }
        return valueAnimator3;
    }
}
