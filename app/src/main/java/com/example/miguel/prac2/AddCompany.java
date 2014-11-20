package com.example.miguel.prac2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddCompany extends Activity {
    EditText etCompany, etBusiness;
    String sComp, sBuss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_company, menu);
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

    public void addCompanyEvt (View v) {
        etCompany = (EditText) findViewById(R.id.editText);
        etBusiness  = (EditText) findViewById(R.id.editText2);
        sComp = etCompany.getText().toString().trim();
        sBuss = etBusiness.getText().toString().trim();


        if(TextUtils.isEmpty(sComp)) {
            Toast.makeText(this, "Debe proporcionar nombre ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(sBuss)) {
            Toast.makeText(this, "Debe proporcionar tipo negocio ", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra("CMP", sComp);
        data.putExtra("BUSS", sBuss);
        setResult(Activity.RESULT_OK, data);
        super.onBackPressed();
    }
}
