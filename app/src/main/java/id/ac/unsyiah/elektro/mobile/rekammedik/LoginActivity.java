package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {

    public static final String MESSAGE = "id.ac.unsyiah.elektro.mobile";

    private String email;
    private String password;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }
    public void doLogin(View view){
        String error;
        if(email.contains("@"))
        {

            //DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
            // periksa apakah email ada di datastore
            // periksa apakah password sesuai dengan yang tersimpan di datastore
            if (password.equals("passworddidatastore")){
                Intent intent = new Intent();
                intent.putExtra(MESSAGE, "Login berhasil!");
            }else{
                error = "Password tidak valid!";
                Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                return;
            }
        }
        else {
            error = "Email tidak valid!";
            Toast.makeText(context, error, Toast.LENGTH_LONG).show();
            return;
        }
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
    private void setupVariable() throws Exception{
        EditText editemail = (EditText) findViewById(R.id.edit_email);
        EditText editpassword = (EditText) findViewById(R.id.edit_password);
        // Hash for given password
        password = editpassword.getText().toString();
        password = MD5Digest.doHash(password);

    }
    public void doDaftar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MESSAGE, "Silahkan lakukan pendaftaran!");
    }
}
