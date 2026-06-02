// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefPaintEvent;
import org.cef.callback.CefDragData;
import org.cef.misc.CefAcceleratedPaintInfo;

import java.awt.Point;
import java.awt.Rectangle;
import java.nio.ByteBuffer;
import java.util.function.Consumer;

/**
 * Implement this interface to handle events when window rendering is disabled.
 * The methods of this class will be called on the UI thread.
 */
public interface CefRenderHandler {
    /**
     * Retrieve the view rectangle.
     * @param browser The browser generating the event.
     * @return The view rectangle.
     */
    public Rectangle getViewRect(CefBrowser browser);

    /**
     * Retrieve the screen info.
     * @param browser The browser generating the event.
     * @param screenInfo The screenInfo
     * @return True if this callback was handled.  False to fallback to defaults.
     */
    public boolean getScreenInfo(CefBrowser browser, CefScreenInfo screenInfo);

    /**
     * Retrieve the screen point for the specified view point.
     * @param browser The browser generating the event.
     * @param viewPoint The point in the view.
     * @return The screen point.
     */
    public Point getScreenPoint(CefBrowser browser, Point viewPoint);

    /**
     * Show or hide the popup window.
     * @param browser The browser generating the event.
     * @param show True if the popup window is being shown.
     */
    public void onPopupShow(CefBrowser browser, boolean show);

    /**
     * Size the popup window.
     * @param browser The browser generating the event.
     * @param size Size of the popup window.
     */
    public void onPopupSize(CefBrowser browser, Rectangle size);

    /**
     * Handle painting.
     * @param browser The browser generating the event.
     * @param popup True if painting a popup window.
     * @param dirtyRects Array of dirty regions.
     * @param buffer Pixel buffer for the whole window.
     * @param width Width of the buffer.
     * @param height Height of the buffer.
     */
    public void onPaint(CefBrowser browser, boolean popup, Rectangle[] dirtyRects,
            ByteBuffer buffer, int width, int height);

    /**
     * Add provided listener.
     * @param listener Code that gets executed after a frame was rendered.
     */
    public void addOnPaintListener(Consumer<CefPaintEvent> listener);

    /**
     * Remove existing listeners and replace with provided listener.
     * @param listener Code that gets executed after a frame was rendered.
     */
    public void setOnPaintListener(Consumer<CefPaintEvent> listener);

    /**
     * Remove provided listener.
     * @param listener Code that gets executed after a frame was rendered.
     */
    public void removeOnPaintListener(Consumer<CefPaintEvent> listener);

    public class CursorTypes {
        public static final int CT_POINTER = 0;
        public static final int CT_CROSS = 1;
        public static final int CT_HAND = 2;
        public static final int CT_IBEAM = 3;
        public static final int CT_WAIT = 4;
        public static final int CT_HELP = 5;
        public static final int CT_EASTRESIZE = 6;
        public static final int CT_NORTHRESIZE = 7;
        public static final int CT_NORTHEASTRESIZE = 8;
        public static final int CT_NORTHWESTRESIZE = 9;
        public static final int CT_SOUTHRESIZE = 10;
        public static final int CT_SOUTHEASTRESIZE = 11;
        public static final int CT_SOUTHWESTRESIZE = 12;
        public static final int CT_WESTRESIZE = 13;
        public static final int CT_NORTHSOUTHRESIZE = 14;
        public static final int CT_EASTWESTRESIZE = 15;
        public static final int CT_NORTHEASTSOUTHWESTRESIZE = 16;
        public static final int CT_NORTHWESTSOUTHEASTRESIZE = 17;
        public static final int CT_COLUMNRESIZE = 18;
        public static final int CT_ROWRESIZE = 19;
        public static final int CT_MIDDLEPANNING = 20;
        public static final int CT_EASTPANNING = 21;
        public static final int CT_NORTHPANNING = 22;
        public static final int CT_NORTHEASTPANNING = 23;
        public static final int CT_NORTHWESTPANNING = 24;
        public static final int CT_SOUTHPANNING = 25;
        public static final int CT_SOUTHEASTPANNING = 26;
        public static final int CT_SOUTHWESTPANNING = 27;
        public static final int CT_WESTPANNING = 28;
        public static final int CT_MOVE = 29;
        public static final int CT_VERTICALTEXT = 30;
        public static final int CT_CELL = 31;
        public static final int CT_CONTEXTMENU = 32;
        public static final int CT_ALIAS = 33;
        public static final int CT_PROGRESS = 34;
        public static final int CT_NODROP = 35;
        public static final int CT_COPY = 36;
        public static final int CT_NONE = 37;
        public static final int CT_NOTALLOWED = 38;
        public static final int CT_ZOOMIN = 39;
        public static final int CT_ZOOMOUT = 40;
        public static final int CT_GRAB = 41;
        public static final int CT_GRABBING = 42;
        public static final int CT_CUSTOM = 43;
    }

    /**
     * Handle cursor changes.
     * @param browser The browser generating the event.
     * @param cursorType The new cursor type.
     * @return true if the cursor change was handled.
     */
    public boolean onCursorChange(CefBrowser browser, int cursorType);

    /**
     * Called when the user starts dragging content in the web view. Contextual
     * information about the dragged content is supplied by dragData.
     * OS APIs that run a system message loop may be used within the
     * StartDragging call.
     *
     * Return false to abort the drag operation. Don't call any of
     * CefBrowser-dragSource*Ended* methods after returning false.
     *
     * Return true to handle the drag operation. Call
     * CefBrowser.dragSourceEndedAt and CefBrowser.ragSourceSystemDragEnded either
     * synchronously or asynchronously to inform the web view that the drag
     * operation has ended.
     * @param browser The browser generating the event.
     * @param dragData Contextual information about the dragged content
     * @param mask Describes the allowed operation (none, move, copy, link).
     * @param x Coordinate within CefBrowser
     * @param y Coordinate within CefBrowser
     * @return false to abort the drag operation or true to handle the drag operation.
     */
    public boolean startDragging(CefBrowser browser, CefDragData dragData, int mask, int x, int y);

    /**
     * Called when the web view wants to update the mouse cursor during a
     * drag & drop operation.
     *
     * @param browser The browser generating the event.
     * @param operation Describes the allowed operation (none, move, copy, link).
     */
    public void updateDragCursor(CefBrowser browser, int operation);

    /**
     * Handles painting
     *
     * @param browser The browser generating the event.
     * @param popup True if painting a popup window.
     * @param dirtyRects Array of dirty regions.
     * @param info Accelerated paint info.
     */
    public void onAcceleratedPaint(CefBrowser browser, boolean popup, Rectangle[] dirtyRects, CefAcceleratedPaintInfo info);
}
