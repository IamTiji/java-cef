package tests.osr;

import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.handler.CefAppHandlerAdapter;

public class Starter {
    private static long nextTimer = -1;
    private static final Object timerLock = new Object();

    private static TestBrowserImpl browser;

    public static void main(String[] args) throws InterruptedException {
        //Thread.sleep(10000);

        String[] cefArgs = {"--shared-texture-enabled", "--no-sandbox", "--disable-features=ThreadNaming"};

        CefApp app = CefApp.getInstance(cefArgs);
        CefClient client = app.createClient();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Browser created @"+ Thread.currentThread());

            TestBrowserImpl browser = new TestBrowserImpl(client, "google.com");
            browser.createImmediately();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Browser closed @"+ Thread.currentThread());

            browser.setCloseAllowed();
            browser.close(true);
        }).start();

        System.out.println(Thread.currentThread());
        app.runMessageLoop();
        client.dispose();
        app.dispose();
    }
}
