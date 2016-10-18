package id.sch.smktelkom_mlg.tugas01.xiirpl3031.aplikasikost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etAsal;
    EditText etTelp;
    Spinner spUkuran;
    CheckBox cbInternet, cbCuci, cbMakan;
    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        etTelp = (EditText) findViewById(R.id.editTextTelp);
        spUkuran = (Spinner) findViewById(R.id.spinnerUkuran);
        cbInternet = (CheckBox) findViewById(R.id.checkBoxInternet);
        cbCuci = (CheckBox) findViewById(R.id.checkBoxCuci);
        cbMakan = (CheckBox) findViewById(R.id.checkBoxMakan);
        bOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOk.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       doProcess();
                                       etNama.setText("");
                                       etAsal.setText("");
                                       etTelp.setText("");
                                   }
                               }
        );

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String asal = etAsal.getText().toString();
            String telp = etTelp.getText().toString();
            String ukuran = spUkuran.getSelectedItem().toString();
            String fasilitas = ", dengan fasilitas ";
            if (cbInternet.isChecked()) fasilitas += cbInternet.getText() + ", ";
            if (cbCuci.isChecked()) fasilitas += cbCuci.getText() + ", ";
            if (cbMakan.isChecked()) fasilitas += cbMakan.getText() + ". ";


            tvHasil.setText(" Nama\t:\t" + nama + "\n Asal\t\t:\t"
                    + asal + "\n No. Telp.\t:\t" + telp
                    + "\n\n Memesan kamar ukuran " + ukuran + fasilitas);
        }

    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String asal = etAsal.getText().toString();
        String telp = etTelp.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (asal.isEmpty()) {
            etAsal.setError("Nama belum diisi");
            valid = false;
        } else if (asal.length() < 3) {
            etAsal.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etAsal.setError(null);
        }

        if (telp.isEmpty()) {
            etTelp.setError("Nomer telepon belum diisi");
            valid = false;
        } else if (telp.length() < 8) {
            etTelp.setError("Nomer minimal 8 angka");
            valid = false;
        } else {
            etTelp.setError(null);
        }

        return valid;
    }
}
