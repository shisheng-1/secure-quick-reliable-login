package org.ea.sqrl.activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.ea.sqrl.R;
import org.ea.sqrl.processors.SQRLStorage;
import org.ea.sqrl.utils.EncryptionUtils;

/**
 * Start activity should be a base for the user so we bring them into the application and they know
 * how to use it when installed and identities are added. So where we add some text for to inform
 * as well as a link to import your first identity.
 *
 * @author Daniel Persson
 */
public class RekeyIdentityActivity extends BaseActivity {
    private static final String TAG = "RekeyIdentityActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekey_identity);

        SQRLStorage.getInstance().clear();

        final TextView txtRekeyIdentityMessage = findViewById(R.id.txtRekeyIdentityMessage);
        txtRekeyIdentityMessage.setMovementMethod(LinkMovementMethod.getInstance());

        final Button btnRekeyIdentityStart = findViewById(R.id.btnRekeyIdentityStart);
        btnRekeyIdentityStart.setOnClickListener(
                v -> {
                    Intent intent = new Intent(this, EntropyGatherActivity.class);
                    startActivity(intent);
                }
        );
    }
}