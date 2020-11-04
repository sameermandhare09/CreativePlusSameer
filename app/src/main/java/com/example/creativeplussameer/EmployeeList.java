package com.example.creativeplussameer;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeList {

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
        private Object email;
        @SerializedName("MobileNo")
        @Expose
        private Object mobileNo;
        @SerializedName("Country")
        @Expose
        private Object country;
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

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(Object mobileNo) {
            this.mobileNo = mobileNo;
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
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

