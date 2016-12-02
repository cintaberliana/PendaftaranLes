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

    }
}
