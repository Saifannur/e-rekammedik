package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class berhasilRegistrasi extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil_registrasi);

        Intent hasilIntent = getIntent();
        String hasil = hasilIntent.getStringExtra("berhasilRegistrasi");

        TextView hasilPeriksaNama = (TextView) findViewById(R.id.txt_namaPasien);
        hasilPeriksaNama.setText(hasil);

        TextView hasilPeriksaStatus = (TextView) findViewById(R.id.txt_status);
        hasilPeriksaStatus.setText(hasil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_berhasil_registrasi, menu);
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
    public void Login (View view){
        Intent intentHasil = new Intent(this, LoginActivity.class);
        startActivity(intentHasil);
    }
}
