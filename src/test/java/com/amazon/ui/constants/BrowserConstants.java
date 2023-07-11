package com.amazon.ui.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrowserConstants {
    /*******************
     * TYPES OF BROWSERS
     ******************/
    public static final String CHROMIUM = "chromium";
    public static final String BROWSER = "browser";

    /******************************
     * BROWSER CONTEXT (Playwright)
     *****************************/
    public static final String GEOLOCATION = "geolocation";
    public static final String REDUCE_MOTION = "reduce-motion";
    public static final String REDUCE = "reduce";

    /************************
     * BROWSER LAUNCH OPTIONS
     ***********************/
    public static final String DISABLE_GPU = "--disable-gpu";
    public static final String DISABLE_SOFTWARE_RASTERIZER = "--disable-software-rasterizer";
}
