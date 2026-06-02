package tests.osr;

import org.cef.CefApp;
import org.cef.CefClient;

public class Starter {
    public static void main(String[] args) {
        String[] cefArgs = {"--shared-texture-enabled", "--no-sandbox", "--disable-site-isolation"};

        CefApp app = CefApp.getInstance(cefArgs);
        CefClient client = app.createClient();

        TestBrowserImpl browser = new TestBrowserImpl(client, "google.com");
        browser.createImmediately();

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(10);
                app.rawMessageLoopWork();
            } catch (InterruptedException e) {
                break;
            }
        }
        browser.close(true);
        client.dispose();
        app.dispose();
    }
}
