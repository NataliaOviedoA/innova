package scilea.ficct.uagrm.com.innovahack.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Genaro Mauricio on 30/11/2018.
 */

public class SessionManager {

    public static boolean isSessionStarted(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConfig.PREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getBoolean("session", false);
    }

    public static void sessionDestroy(Context context) {
        SharedPreferences settings = context.getSharedPreferences(AppConfig.PREFERENCES, MODE_PRIVATE);
        settings.edit().putBoolean("session", false).apply();
    }

//    public static void storeUserData(Context context, Chofer chofer) {
//        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConfig.PREFERENCES, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean("session", true);
//        editor.putInt("id", chofer.numero);
//        editor.putString("ci", chofer.exci);
//        editor.putString("nombre", chofer.nombre);
//        editor.putString("email", chofer.email);
//        editor.putString("foto", chofer.foto);
//        editor.putString("telefono", chofer.telefono);
//        editor.apply();
//    }
}
