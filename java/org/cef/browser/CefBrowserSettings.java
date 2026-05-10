package org.cef.browser;

public class CefBrowserSettings {
    public enum CefState {
        STATE_DISABLED,
        STATE_ENABLED,
        STATE_DEFAULT
    }

    public int windowless_frame_rate;
    
    public String standard_font_family   = "";
    public String fixed_font_family      = "";
    public String serif_font_family      = "";
    public String sans_serif_font_family = "";
    public String cursive_font_family    = "";
    public String fantasy_font_family    = "";

    public int default_font_size;
    public int default_fixed_font_size;
    public int minimum_font_size;
    public int minimum_logical_font_size;

    public String default_encoding     = "";
    public String accept_language_list = "";

    public CefState remote_fonts                = CefState.STATE_DEFAULT;
    public CefState javascript                  = CefState.STATE_DEFAULT;
    public CefState javascript_close_windows    = CefState.STATE_DEFAULT;
    public CefState javascript_access_clipboard = CefState.STATE_DEFAULT;
    public CefState javascript_dom_paste        = CefState.STATE_DEFAULT;
    public CefState image_loading               = CefState.STATE_DEFAULT;
    public CefState text_area_resize            = CefState.STATE_DEFAULT;
    public CefState tab_to_links                = CefState.STATE_DEFAULT;
    public CefState local_storage               = CefState.STATE_DEFAULT;
    public CefState databases                   = CefState.STATE_DEFAULT;
    public CefState webgl                       = CefState.STATE_DEFAULT;

    public CefState web_security                    = CefState.STATE_DEFAULT;
    public CefState file_access_from_file_urls      = CefState.STATE_DEFAULT;
    public CefState universal_access_from_file_urls = CefState.STATE_DEFAULT;
}
