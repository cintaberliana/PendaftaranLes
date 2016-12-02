package id.sch.smktelkom_mlg.tugas01.xiirpl2008.pendaftaranles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etnama, ettelp;
    TextView tvhasil;
    CheckBox cbm, cbb, cbi, cbk;
    RadioGroup rg;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnama = (EditText) findViewById(R.id.editTextnama);
        ettelp = (EditText) findViewById(R.id.editTexttelp);
        tvhasil = (TextView) findViewById(R.id.textViewh);
        cbb = (CheckBox) findViewById(R.id.checkBoxb);
        cbm = (CheckBox) findViewById(R.id.checkBoxm);
        cbi = (CheckBox) findViewById(R.id.checkBoxing);
        cbk = (CheckBox) findViewById(R.id.checkBoxk);
        rg = (RadioGroup) findViewById(R.id.rgw);
        sp = (Spinner) findViewById(R.id.spinner);

        findViewById(R.id.buttonh).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                doclick();
            }
        });
    }

    private void doclick() {
        String nama = etnama.getText().toString();
        int telp = Integer.parseInt(ettelp.getText().toString());
        String program = "Mata Pelajaran yang dipilih \t\n";
        int startlen = program.length();
        if (cbm.isChecked()) program += "\t " + cbm.getText() + "\n";
        if (cbb.isChecked()) program += "\t " + cbb.getText() + "\n";
        if (cbi.isChecked()) program += "\t " + cbi.getText() + "\n";
        if (cbk.isChecked()) program += "\t " + cbk.getText() + "\n";
        if (program.length() == startlen) {
            tvhasil.setText("Tidak ada Mata pelajaran yang dipilih\n");
        }
        else {
            String hasil = null;
            if (rg.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvhasil.setText("Anda belum memilih Waktu Les\n");
            }
            else {
                StringBuilder builder = new StringBuilder();
                builder.append("Nama : " + nama + "\n");
                builder.append("Telp : " + telp + "\n");
                builder.append(program);
                builder.append("Waktu Les : " + hasil + "\n");
                builder.append(sp.getSelectedItem().toString() + "\n");
                tvhasil.setText(builder);
            }
        }

    }
}
