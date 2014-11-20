package com.example.miguel.prac2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;


public class CompanyMgmt extends Activity {
    private ArrayList<ListItem> companylist =new ArrayList<ListItem>();
    public final static String LIST_ID= "com.example.miguel.prac2.LIST_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_mgmt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_company_mgmt, menu);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView msg = (TextView) findViewById(R.id.textView2);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String company = data.getStringExtra("CMP");
            String business = data.getStringExtra("BUSS");

            ListItem cmpList = new ListItem();
            cmpList.setCompLogo(getResources().getDrawable(R.drawable.ic_launcher));
            cmpList.setCompany(company);
            cmpList.setBusiness(business);

            companylist.add(cmpList);

            msg.setText("Compañia almacenada");
        } else {
            msg.setText("");
        }
    }

    public void addCompanyEvt (View v) {
        TextView msg = (TextView) findViewById(R.id.textView2);
        msg.setText("");
        Intent btnIntent = new Intent(getApplicationContext(), AddCompany.class);
        startActivityForResult(btnIntent, 1);
    }

    public void displayCmp(View v) {
        Intent intent = new Intent(this, DispCompanies.class);

        /*ListItem listItem = new ListItem();
        listItem.setImageUser(getResources().getDrawable(R.drawable.ic_launcher));
        listItem.setHeader("Daniel");
        listItem.setSubHeader("Rodriguez");

        ListItem listItem2 = new ListItem();
        listItem2.setImageUser(getResources().getDrawable(R.drawable.ic_launcher));
        listItem2.setHeader("Laura");
        listItem2.setSubHeader("Elisa");*/

        TextView msg = (TextView) findViewById(R.id.textView2);
        msg.setText("");

        intent.putParcelableArrayListExtra(LIST_ID, companylist);
        startActivity(intent);
    }

}
