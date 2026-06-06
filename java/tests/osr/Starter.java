package tests.osr;

import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.handler.CefAppHandlerAdapter;

public class Starter {
    private static long nextTimer = -1;
    private static final Object timerLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        //Thread.sleep(10000);

        String[] cefArgs = {"--shared-texture-enabled", "--no-sandbox", "--disable-features=ThreadNaming"};

        CefApp app = CefApp.getInstance(cefArgs);
        CefClient client = app.createClient();

        TestBrowserImpl browser = new TestBrowserImpl(client, "google.com");
        browser.createImmediately();

        System.out.println(Thread.currentThread());
        app.runMessageLoop();
        browser.close(true);
        client.dispose();
        app.dispose();
    }
}
