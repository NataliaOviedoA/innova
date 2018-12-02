package scilea.ficct.uagrm.com.innovahack.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import scilea.ficct.uagrm.com.innovahack.R;

public class DetalleReservaActivity extends AppCompatActivity {

    private ImageView imgView;
    private Button btnOk;
    private int idMicro;
    private int nombreLinea;
    private int capacidadPasajeros;
    private int idParada;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva);

        imgView = findViewById(R.id.imgView);
        btnOk = findViewById(R.id.btnOk);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            idMicro = extras.getInt("idMicro");
            nombreLinea = extras.getInt("nombreLinea");
            capacidadPasajeros = extras.getInt("capacidadPasajeros");
            idParada = extras.getInt("idParada");
            token = extras.getString("token");
        }



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "{\n" +
                        "  \"idMicro\": "+idMicro+",\n" +
                        "  \"nombreLinea\": "+nombreLinea+",\n" +
                        "  \"capacidadPasajeros\": "+capacidadPasajeros+",\n" +
                        "  \"idParada\" : "+idParada+";\n" +
                        "  \"token\": \""+token+"\"\n" +
                        "}";

                if( text != null){
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try {
                        BitMatrix bitMatrix= multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 1000, 1000 );
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        imgView.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }




            }
        });
    }
}
