package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;


public class PilihDokter extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_dokter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pilih_dokter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {

        RadioButton drSatu = (RadioButton) findViewById(R.id.drsatu);
        String drsatu = drSatu.getText().toString();

        RadioButton drDua = (RadioButton) findViewById(R.id.drDua);
        String drdua = drDua.getText().toString();

        RadioButton drTiga = (RadioButton) findViewById(R.id.drTiga);
        String drtiga = drTiga.getText().toString();

        RadioButton drEmpat = (RadioButton) findViewById(R.id.drEmpat);
        String drempat = drEmpat.getText().toString();

        Intent hasilIntent = new Intent(this, BerhasilPilihDokter.class);
        //Boolean hasil = false ;

        if (drSatu.isChecked()) {
            //  hasil=true;
            hasilIntent.putExtra("hasilPilih", drsatu + "\nSpesialis Kandungan");
        } else if (drDua.isChecked()) {
            // hasil=true;
            hasilIntent.putExtra("hasilPilih", drdua + "\nSpesialis Gizi Klinik");
        } else if (drTiga.isChecked()) {
            //hasil=true;
            hasilIntent.putExtra("hasilPilih", drtiga + "\nSpesialis Mata");
        } else if (drEmpat.isChecked()) {
            //hasil=true;
            hasilIntent.putExtra("hasilPilih", drempat + "\nSpesialis Saraf");
        }
        startActivity(hasilIntent);
    }
}