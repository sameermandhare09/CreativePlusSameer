package com.example.creativeplussameer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    MainActivity mainActivity;
    List<EmployeeList.LstEmployee> response;
    String countryName;


    public EmployeeAdapter(MainActivity mainActivity, List<EmployeeList.LstEmployee> response, String countryName) {
        this.mainActivity = mainActivity;
        this.response = response;
        this.countryName = countryName;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txt_employee.setText(response.get(position).getName());
        holder.txt_country.setText(countryName);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APIInterface apiService =
                        ApiClient.getClient().create(APIInterface.class);

                Call<EmployeeDetails> getDetails = apiService.getEmployeeDetails(response.get(position).getEmpId()+"");
                getDetails.enqueue(new Callback<EmployeeDetails>() {
                    @Override
                    public void onResponse(Call<EmployeeDetails> call, Response<EmployeeDetails> response) {


                        Gson gson = new Gson();
                        String s1 = gson.toJson(response);
                        Log.e("response",s1);


                        String name = response.body().getLstEmployee().get(0).getName();
                        String Email = response.body().getLstEmployee().get(0).getEmail();
                        String phone = response.body().getLstEmployee().get(0).getMobileNo();
                        String country =  response.body().getLstEmployee().get(0).getCountry();
                        String dob =  response.body().getLstEmployee().get(0).getDOB();

                        Intent intent = new Intent(mainActivity,EmployeeDetail.class);
//                        intent.putExtra("response", s1);
                        Bundle b = new Bundle();

                        b.putString("name",name);
                        b.putString("Email",Email);
                        b.putString("phone",phone);
                        b.putString("country",country);
                        b.putString("dob",dob);

                        intent.putExtras(b);
                        (mainActivity).startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<EmployeeDetails> call, Throwable t) {
                        Log.e("Error",t.getMessage());

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_employee,txt_country;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_employee = itemView.findViewById(R.id.txt_employee);
            txt_country = itemView.findViewById(R.id.txt_country);
        }
    }
    public void updateList(List<EmployeeList.LstEmployee> response){
        this.response = response;
        notifyDataSetChanged();

    }
}
