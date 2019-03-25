package com.opiumfive.telechart.chart.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Viewrect implements Parcelable {

    public float left;
    public float top;
    public float right;
    public float bottom;

    public static final Parcelable.Creator<Viewrect> CREATOR = new Parcelable.Creator<Viewrect>() {

        public Viewrect createFromParcel(Parcel in) {
            Viewrect v = new Viewrect();
            v.readFromParcel(in);
            return v;
        }

        public Viewrect[] newArray(int size) {
            return new Viewrect[size];
        }
    };

    public Viewrect() {
    }

    public Viewrect(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public Viewrect(Viewrect v) {
        if (v == null) {
            left = top = right = bottom = 0.0f;
        } else {
            left = v.left;
            top = v.top;
            right = v.right;
            bottom = v.bottom;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Viewrect other = (Viewrect) obj;
        if (Float.floatToIntBits(bottom) != Float.floatToIntBits(other.bottom)) return false;
        if (Float.floatToIntBits(left) != Float.floatToIntBits(other.left)) return false;
        if (Float.floatToIntBits(right) != Float.floatToIntBits(other.right)) return false;
        if (Float.floatToIntBits(top) != Float.floatToIntBits(other.top)) return false;
        return true;
    }

    public final float width() {
        return right - left;
    }

    public final float height() {
        return top - bottom;
    }

    public void set(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public void set(Viewrect src) {
        this.left = src.left;
        this.top = src.top;
        this.right = src.right;
        this.bottom = src.bottom;
    }

    public void inset(float dx, float dy) {
        left += dx;
        top -= dy;
        right -= dx;
        bottom += dy;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(bottom);
        result = prime * result + Float.floatToIntBits(left);
        result = prime * result + Float.floatToIntBits(right);
        result = prime * result + Float.floatToIntBits(top);
        return result;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeFloat(left);
        out.writeFloat(top);
        out.writeFloat(right);
        out.writeFloat(bottom);
    }

    public void readFromParcel(Parcel in) {
        left = in.readFloat();
        top = in.readFloat();
        right = in.readFloat();
        bottom = in.readFloat();
    }
}
