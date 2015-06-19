package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.app.Activity;
import android.os.Debug;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class RegistrasiActivity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    Button Register;
    EditText Nama, Email,TglLahir,Password,KonfPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        spinner= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.status,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Nama = (EditText) findViewById(R.id.edit_nama);
        Email = (EditText) findViewById(R.id.edit_Email);
        TglLahir = (EditText) findViewById(R.id.edit_TglLahir);
        Password = (EditText) findViewById(R.id.edit_pass);
        KonfPassword = (EditText) findViewById(R.id.edit_confPass);

        Register =(Button) findViewById(R.id.btn_registrasi);

        Register.setOnClickListener(this);

        if (Password.equals(KonfPassword)){
            Toast.makeText(getApplicationContext(),"Pass Sesuai",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getApplicationContext(),"Pass Harus Sesuai",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registrasi, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView mytext=(TextView)view;
        Toast.makeText(this,"Anda masuk sebagai "+mytext.getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_registrasi:

                break;
        }

    }
}
