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
public class TestBrowserImpl extends CefBrowser_N {
    TestRenderHandlerImpl renderHandler;

    protected TestBrowserImpl(CefClient client, String url) {
        super(client, url, CefRequestContext.getGlobalContext(), null, null, null);
        renderHandler = new TestRenderHandlerImpl();
    }

    @Override
    public CefRenderHandler getRenderHandler() {
        return renderHandler;
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
}
