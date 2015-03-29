package com.starbox.puzzlecar;

import org.onepf.oms.OpenIabHelper;
import org.onepf.oms.SkuManager;

import java.util.HashMap;
import java.util.Map;
public final class Config {

    // SKUs for our products: the premium upgrade (non-consumable) and gas (consumable)
    public static final String SKU_PREMIUM = "premium";

    /**
     * Google play public key.
     */
    public static final String GOOGLE_PLAY_KEY
    				="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtZzy+dSMGUz/YHEH+4xdTI7U6CoV7RcST"+
            		"oZVcT75ZSSUoqpQuTUm6iGfwhth/YRjOUvpkmGw4jn2TNEgOPBh8JjeCmttz6DigFb/sfuaTgOZz/x"+
            		"B09rV9g/yjC0wG+tQu3WLtbMa4rqcw1O0SJjNw8diGwavZags0U3p2cEZ+sr9mesjKut2DXj/lfgCZ"+
            		"9BzF3qiT38FjWoYCPRdalwm/CzcIJheEvC6M8NkGGfAPiYZSMzHc62lRGlTYJ2P5b5BEhuHR2W4zgVR"+
            		"th+Xhq6MJwTtoXc769wfimCcYEE/6pEKgySUo8lKr6jzY+olnh1n8S3gNxJ1akshhJ4I0YxFQQIDAQAB"; 
    /**
     * Yandex.Store public key.
     */
    public static final String YANDEX_PUBLIC_KEY
    			  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtUsZnEM8BcWSv5aBpX53dmVo2UEycx+cIfLqgYcuyab"+
            		"uzR7gzJvP3oGXbZ3YgQZFCkamLaG6GxUrW0ryzTtPoq/z4KQ1L7o2cWbWjCmLqqWIFl28DPiJXMvB3LZ92hxHJUHhNu"+
            		"TwmXBH63IsGiHXiva99ttsGMufR94tNoiIeqXLLospz7W52O0mjTTpLxGXopTDYI0O7t36qyEC+VJqN33TG6Y2B5NhrEM0v"+
            		"1A1vPRRjNyQkQVucW+/AoT1Kn/Oz8Pl98k88rKkEIdMFVGohUuXep2Q7fRAsNzE3u0QQGUEird1jWuK8wtVQYZXcxmjDICfPUQ5AQUDU+wj9QIh7wIDAQAB";

    /**
     * Appland store public key.
     */
 /*   public static final String APPLAND_PUBLIC_KEY =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5idC9c24V7a7qCJu7kdIyOZsk\n" +
                    "W0Rc7/q+K+ujEXsUaAdb5nwmlOJqpoJeCh5Fmq5A1NdF3BwkI8+GwTkH757NBZAS\n" +
                    "SdEuN0pLZmA6LopOiMIy0LoIWknM5eWMa3e41CxCEFoMv48gFIVxDNJ/KAQAX7+K\n" +
                    "ysYzIdlA3W3fBXXyGQIDAQAB";
*/
    /**
     * SlideMe store public key.
     */
 /*   public static final String SLIDEME_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBC" +
            "gKCAQEAq6rFm2wb9sm" +
            "bcowrfZHYw71ISHYxF/tG9Jn9c+nRzFCVDSXjvedBxKllw16/GEx9DQ32Ut8azVAznB2wBDNUsS" +
            "M8nzNhHeCSDvEX2/Ozq1dEq3V3DF4jBEKDAkIOMzIBRWN8fpA5MU/9m8QD9xkJDfP7Mw/6zEMidk" +
            "2CEE8EZRTlpQ8ULVgBlFISd8Mt9w8ZFyeTyJTZhF2Z9+RZN8woU+cSXiVRmiA0+v2R8Pf+YNJb9fd" +
            "V5yvM8r9K1MEdRaXisJyMOnjL7H2mZWigWLm7uGoUGuIg9HHi09COBMm3dzAe9yLZoPSG75SvYDs" +
            "AZ6ms8IYxF6FAniNqfMOuMFV8zwIDAQAB";
*/
    
 //   public static final String SKU_PREMIUM_NOKIA_STORE = "1290315";
   
 //   public static final String SKU_PREMIUM_AMAZON = "amazon.sku_premium";
    
    public static final String SKU_PREMIUM_YANDEX = "premium";

  //  public static final String SKU_PREMIUM_APPLAND = "appland.sku_premium";

  
  //  public static final String SKU_PREMIUM_SLIDEME = "slideme.sku_premium";

    public static final Map<String, String> STORE_KEYS_MAP;

    static {
        STORE_KEYS_MAP = new HashMap<String, String>();
        STORE_KEYS_MAP.put(OpenIabHelper.NAME_GOOGLE, Config.GOOGLE_PLAY_KEY);
        STORE_KEYS_MAP.put(OpenIabHelper.NAME_YANDEX, Config.YANDEX_PUBLIC_KEY);
       // STORE_KEYS_MAP.put(OpenIabHelper.NAME_APPLAND, Config.APPLAND_PUBLIC_KEY);
     //   STORE_KEYS_MAP.put(OpenIabHelper.NAME_SLIDEME, Config.SLIDEME_PUBLIC_KEY);
//        STORE_KEYS_MAP.put(OpenIabHelper.NAME_AMAZON,
//                "Unavailable. Amazon doesn't support RSA verification. So this mapping is not needed");
//        STORE_KEYS_MAP.put(OpenIabHelper.NAME_SAMSUNG,
//                "Unavailable. SamsungApps doesn't support RSA verification. So this mapping is not needed");

        //Only map SKUs for stores where SKU that using in app different from described in store console.
        // In this sample only Google Play store use the same skus.
        SkuManager.getInstance()  
             //   .mapSku(SKU_PREMIUM, OpenIabHelper.NAME_NOKIA, SKU_PREMIUM_NOKIA_STORE)
                .mapSku(SKU_PREMIUM, OpenIabHelper.NAME_YANDEX, SKU_PREMIUM_YANDEX);
             //   .mapSku(SKU_PREMIUM, OpenIabHelper.NAME_AMAZON, SKU_PREMIUM_AMAZON)
             //   .mapSku(SKU_PREMIUM, OpenIabHelper.NAME_APPLAND, SKU_PREMIUM_APPLAND)
              //  .mapSku(SKU_PREMIUM, OpenIabHelper.NAME_SLIDEME, SKU_PREMIUM_SLIDEME);
    }

    private Config() {
    }
}
