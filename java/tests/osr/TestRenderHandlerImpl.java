package tests.osr;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefPaintEvent;
import org.cef.callback.CefDragData;
import org.cef.handler.CefRenderHandler;
import org.cef.handler.CefScreenInfo;
import org.cef.misc.CefAcceleratedPaintInfo;

import java.awt.*;
import java.nio.ByteBuffer;
import java.util.function.Consumer;

public class TestRenderHandlerImpl implements CefRenderHandler {
    @Override
    public Rectangle getViewRect(CefBrowser browser) {
        return new Rectangle(0, 0, 300, 300);
    }

    @Override
    public boolean getScreenInfo(CefBrowser browser, CefScreenInfo screenInfo) {
        return false;
    }

    @Override
    public Point getScreenPoint(CefBrowser browser, Point viewPoint) {
        return null;
    }

    @Override
    public void onPopupShow(CefBrowser browser, boolean show) {

    }

    @Override
    public void onPopupSize(CefBrowser browser, Rectangle size) {

    }

    @Override
    public void onPaint(CefBrowser browser, boolean popup, Rectangle[] dirtyRects, ByteBuffer buffer, int width, int height) {

    }

    @Override
    public void addOnPaintListener(Consumer<CefPaintEvent> listener) {

    }

    @Override
    public void setOnPaintListener(Consumer<CefPaintEvent> listener) {

    }

    @Override
    public void removeOnPaintListener(Consumer<CefPaintEvent> listener) {

    }

    @Override
    public boolean onCursorChange(CefBrowser browser, int cursorType) {
        return false;
    }

    @Override
    public boolean startDragging(CefBrowser browser, CefDragData dragData, int mask, int x, int y) {
        return false;
    }

    @Override
    public void updateDragCursor(CefBrowser browser, int operation) {

    }

    @Override
    public void onAcceleratedPaint(CefBrowser browser, boolean popup, Rectangle[] dirtyRects, CefAcceleratedPaintInfo info, int width, int height) {
        System.out.println(info.shared_texture_handle);
    }
}
