package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.Arrays;

import com.facebook.react.ReactPackage;
import com.picnic.vgs.collect.VGSCollectPackage;
import com.picnic.vgs.fields.cvc.CardCVCPackage;
import com.picnic.vgs.fields.number.CardNumberPackage;
import com.picnic.vgs.fields.expiration.CardExpirationPackage;
import com.picnic.vgs.fields.OnCreateViewInstanceListener;

public class VGSManagerPackagePlugin implements ReactPlugin {
    VGSCollectPackage collect = new VGSCollectPackage();
    OnCreateViewInstanceListener listener = collect.getListener();
    CardCVCPackage cvc = new CardCVCPackage(listener);
    CardExpirationPackage expiration = new CardExpirationPackage(listener);
    CardNumberPackage number = new CardNumberPackage(listener);

    public ReactPackage hook(@NonNull Application application, @Nullable ReactPluginConfig config) {
        return Arrays.<ReactPackage>asList(
            collect,
            cvc,
            expiration,
            number
        );
    }
}