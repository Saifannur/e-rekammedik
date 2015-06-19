package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    public final static String MESSAGE = "id.ac.unsyiah.elektro.mobile";

    private String email;
    private String password;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new GcmRegistrationAsyncTask(this).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }
    public void doLogin(View view){

        String error;
        Intent intent = new Intent(this, HomeKlinikActivity.class);
        intent.putExtra(MESSAGE, "Login berhasil!");
        startActivity(intent);
/**
        if(email.contains("@"))
        {

            // periksa apakah email ada di datastore
            // periksa apakah password sesuai dengan yang tersimpan di datastore
            if (password.equals("passworddidatastore")){
                Intent intent = new Intent(this, HomeKlinikActivity.class);
                intent.putExtra(MESSAGE, "Login berhasil!");
                startActivity(intent);
            }else{
                error = "Password tidak valid!";
                Toast.makeText(context, error, Toast.LENGTH_LONG).show();
            }
        }
        else {
            error = "Email tidak valid!";
            Toast.makeText(context, error, Toast.LENGTH_LONG).show();
        }
 */
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
    public void doDaftar(View view){
        Intent intent = new Intent(this, RegistrasiActivity.class);
        startActivity(intent);
    }
    private class LoginAsyncTask extends AsyncTask<Void, Void, String>{

        public Context context;

        public LoginAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        private void setupVariable() throws Exception{
            EditText editemail = (EditText) findViewById(R.id.edit_email);
            EditText editpassword = (EditText) findViewById(R.id.edit_password);

            // Hash for given password
            password = editpassword.getText().toString();
            password = MD5Digest.doHash(password);

        }
    }
}