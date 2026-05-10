package com.mahrus.androidid;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;

@DesignerComponent(
    version = 1,
    description = "Ekstensi untuk mengambil Android ID unik perangkat untuk aktivasi aplikasi.",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/extension.png")

public class AndroidID extends AndroidNonvisibleComponent {

    private Context context;

    public AndroidID(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
    }

    /**
     * Mengambil Android ID unik (SSAID).
     * @return String Android ID
     */
    @SimpleFunction(description = "Mengambil Android ID perangkat.")
    public String GetID() {
        try {
            // Mengambil ID unik dari setelan sistem Android
            String androidId = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
            return (androidId != null) ? androidId : "ID_TIDAK_DITEMUKAN";
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }
}
