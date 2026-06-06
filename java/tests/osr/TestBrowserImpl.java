package tests.osr;

import org.cef.CefClient;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefBrowser_N;
import org.cef.browser.CefPaintEvent;
import org.cef.browser.CefRequestContext;
import org.cef.callback.CefDragData;
import org.cef.handler.CefRenderHandler;
import org.cef.handler.CefScreenInfo;
import org.cef.misc.CefAcceleratedPaintInfo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Test browser implementation, just enough to run without causing issues.
 * It does not paint anything to screen, it is to check if certain methods
 * are called as expected.
 */
public class TestBrowserImpl extends CefBrowser_N implements CefRenderHandler {
    protected TestBrowserImpl(CefClient client, String url) {
        super(client, url, CefRequestContext.getGlobalContext(), null, null, null);
    }

    @Override
    public CefRenderHandler getRenderHandler() {
        return this;
    }

    @Override
    protected CefBrowser_N createDevToolsBrowser(CefClient client, String url, CefRequestContext context, CefBrowser_N parent, Point inspectAt) {
        return null;
    }

    @Override
    public void createImmediately() {
        if (getNativeRef("CefBrowser") == 0) {
            createBrowser(getClient(), 0L, getUrl(), true, false, null,
                    getRequestContext());
        }
    }

    @Override
    public Component getUIComponent() {
        return null;
    }

    @Override
    public CompletableFuture<BufferedImage> createScreenshot(boolean nativeResolution) {
        return null;
    }

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
    public void onAcceleratedPaint(CefBrowser browser, boolean popup, Rectangle[] dirtyRects, CefAcceleratedPaintInfo info) {
        System.out.println(info.shared_texture_handle);
    }
}
