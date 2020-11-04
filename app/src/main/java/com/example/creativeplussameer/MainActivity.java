package com.example.creativeplussameer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.creativeplussameer.R.layout.support_simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp_country;
    RecyclerView rv_employee;
    EditText editSearch;

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;


    List<String> countries = new ArrayList<>();
    List<EmployeeList.LstEmployee> responseLstEmployee;
    EmployeeAdapter employeeAdapter;

    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_country = findViewById(R.id.sp_country);
        rv_employee = findViewById(R.id.rv_employee);
        editSearch = findViewById(R.id.editSearch);

        apiCall();
        sp_country.setOnItemSelectedListener(this);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());

            }
        });


    }

    void filter(String text){
        List<EmployeeList.LstEmployee> temp = new ArrayList();
        for(EmployeeList.LstEmployee d: responseLstEmployee){
            if(d.getName().contains(text)){
                temp.add(d);
            }
        }
        employeeAdapter.updateList(temp);
    }

    private void apiCall() {

        APIInterface apiService =
                ApiClient.getClient().create(APIInterface.class);
        Call<Country> getCountry = apiService.getCountry();
        getCountry.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {


                if (response!=null){


                    for (int i=0; i<response.body().getLstCountryData().size();i++){
                        countries.add(response.body().getLstCountryData().get(i).getCountry());
                    }
                     arrayAdapter = new ArrayAdapter(MainActivity.this, support_simple_spinner_dropdown_item,countries);
                    sp_country.setAdapter(arrayAdapter);
                }



            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.e("Error",t.getMessage());

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


//        Toast.makeText(this, "Selected item"+countries.get(i), Toast.LENGTH_SHORT).show();

        getEmployeeList(countries.get(i));

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void getEmployeeList(String countryName) {


        APIInterface apiService =
                ApiClient.getClient().create(APIInterface.class);
        JsonObject mainJson = new JsonObject();
        mainJson.addProperty("Country",countryName);
        Call<EmployeeList> getEmployeeList = apiService.getEmployeeList(mainJson);
        getEmployeeList.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {

                Gson gson = new Gson();
                String s = gson.toJson(response);
                Log.e("response",s);

                ;
                responseLstEmployee = response.body().getLstEmployee();
                 employeeAdapter = new EmployeeAdapter(MainActivity.this,responseLstEmployee,countryName);
                rv_employee.setAdapter(employeeAdapter);

            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {

            }
        });

    }
}