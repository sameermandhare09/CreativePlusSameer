package com.example.creativeplussameer;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeDetails {

    public static Object LstEmployee;
    @SerializedName("lst_Employee")
    @Expose
    private List<LstEmployee> lstEmployee = null;

    public List<LstEmployee> getLstEmployee() {
        return lstEmployee;
    }

    public void setLstEmployee(List<LstEmployee> lstEmployee) {
        this.lstEmployee = lstEmployee;
    }


    public class LstEmployee {

        @SerializedName("Emp_id")
        @Expose
        private Integer empId;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Email")
        @Expose
        private String email;
        @SerializedName("MobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("Country")
        @Expose
        private String country;
        @SerializedName("DOB")
        @Expose
        private String dOB;

        public Integer getEmpId() {
            return empId;
        }

        public void setEmpId(Integer empId) {
            this.empId = empId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDOB() {
            return dOB;
        }

        public void setDOB(String dOB) {
            this.dOB = dOB;
        }

    }

}

