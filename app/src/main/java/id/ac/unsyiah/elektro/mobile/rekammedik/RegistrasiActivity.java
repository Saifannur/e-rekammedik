package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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


public class RegistrasiActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public static final String NAME = "id.ac.unsyiah.mobile.elektro.rekammedik";
    public static final String ROLE = "id.ac.unsyiah.mobile.elektro.rekammedik";

    Context context;

    Spinner  spinner= (Spinner) findViewById(R.id.spinner);
    EditText editnama = (EditText) findViewById(R.id.edit_nama);
    EditText editemail = (EditText) findViewById(R.id.edit_email);
    EditText edittanggallahir = (EditText) findViewById(R.id.edit_TglLahir);
    EditText editpass = (EditText) findViewById(R.id.edit_pass);
    EditText editconfpass = (EditText) findViewById(R.id.edit_confPass);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.status,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        setContentView(R.layout.activity_registrasi);
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

    public void doRegister(View view)throws Exception{
        String nama, email, tgllahir, pass, confpass, role;
        nama = editnama.getText().toString();
        email = editemail.getText().toString();
        tgllahir = edittanggallahir.getText().toString();
        pass = editpass.getText().toString();
        try{
            pass = MD5Digest.doHash(pass);
        }catch (Exception ex){
            Toast.makeText(context, "Password tidak valid", Toast.LENGTH_LONG);
        }
        role = spinner.getSelectedItem().toString();
        confpass = editconfpass.getText().toString();
        if (email.contains("@")){
            if(pass.equals(confpass)){
                /**
                Intent intent = new Intent(this, )
                intent.putExtra(NAME, nama);
                intent.putExtra(ROLE, role);
                 startActivity(intent);
                 */
            }else{
                Toast.makeText(this, "Password tidak sama", Toast.LENGTH_LONG);
            }
        }else{
            Toast.makeText(this, "Email tidak valid", Toast.LENGTH_LONG);
        }

    }
}
