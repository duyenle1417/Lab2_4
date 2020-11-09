package com.example.listview_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText_name, editText_id;
    Button button_add;
    CheckBox checkBox_isManager;
    ListView listView_employee;
    ArrayList<Employee> employees;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gán các view
        editText_id = findViewById(R.id.edit_text_id);
        editText_name = findViewById(R.id.edit_text_name);
        button_add = findViewById(R.id.btn_nhap);
        checkBox_isManager = findViewById(R.id.checkBox_isManager);
        listView_employee = findViewById(R.id.list_view_employee);
        employees = new ArrayList<>();
        //adapter cho listview thêm item
        adapter = new EmployeeAdapter(this, R.layout.employee_item_lv, employees);
        listView_employee.setAdapter(adapter);

        //xử lý sự kiện button click
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý dữ liệu, thêm vào listview
                if (editText_id.length() > 0 && editText_name.length() > 0) {
                    addNewEmployee();
                    //dữ liệu vè mặc định
                    editText_id.getText().clear();
                    editText_name.getText().clear();
                    checkBox_isManager.setChecked(false);
                    editText_id.requestFocus();
                } else
                    Toast.makeText(MainActivity.this, "Không được để khung nhập dữ liệu trống", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //xử lý dữ liệu employee
    public void addNewEmployee() {
        String id = editText_id.getText().toString();
        String name = editText_name.getText().toString();
        Boolean isManager = checkBox_isManager.isChecked();
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setManager(isManager);

        //thêm vào mảng employees
        employees.add(employee);
        adapter.notifyDataSetChanged();
    }
}