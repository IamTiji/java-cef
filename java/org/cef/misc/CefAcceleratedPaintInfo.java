package org.cef.misc;

public class CefAcceleratedPaintInfo {
    public enum CefColorType {
        CEF_COLOR_TYPE_RGBA_8888,
        CEF_COLOR_TYPE_BGRA_8888
    }

    /**
     * The handle to the shared texture.
     */
    public long shared_texture_handle;

    /**
     * In what format the texture is stored.
     */
    public CefColorType format;
}
