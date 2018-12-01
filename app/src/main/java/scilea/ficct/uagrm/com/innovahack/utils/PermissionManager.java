package scilea.ficct.uagrm.com.innovahack.utils;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import scilea.ficct.uagrm.com.innovahack.activities.MapsActivity;

/**
 * Created by Genaro Mauricio on 30/11/2018.
 */

public class PermissionManager {

    public static void verifyWriteExternalStoragePermission(AppCompatActivity context) {
        if (Build.VERSION.SDK_INT > 23) {
            int permisionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permisionCheck != PackageManager.PERMISSION_GRANTED) {
                context.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    public static void verifyAccessCoarseLocationPermission(MapsActivity context) {
        System.out.println("Verify access coarse location");
        if (Build.VERSION.SDK_INT > 23) {
            int permisionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);
            if (permisionCheck != PackageManager.PERMISSION_GRANTED) {
                context.requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            }
        }
    }

    public static void verifyAccessFineLocationPermission(MapsActivity context) {
        System.out.println("Verify access fine location");
        if (Build.VERSION.SDK_INT > 23) {
            int permisionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
            if (permisionCheck != PackageManager.PERMISSION_GRANTED) {
                context.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    public static void requestEnableLocation(final MapsActivity mapsActivity){
        String message, title, btnText;
        message = "La ubicación de este dispositivo está desactivada. Por favor, habilite la ubicación para usar esta app.";
        title = "Habilitar ubicación";
        btnText = "Ir a configuración";
        final AlertDialog.Builder dialog = new AlertDialog.Builder(mapsActivity);
        dialog.setCancelable(false);
        dialog.setTitle(title)
                .setMessage(message)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        mapsActivity.startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        mapsActivity.finish();
                    }
                });
        dialog.show();
    }
}
