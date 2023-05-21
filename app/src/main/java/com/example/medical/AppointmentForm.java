package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.medical.model.Appointment;
import com.example.medical.model.Doctor;
import com.example.medical.model.Patient;
import com.example.medical.model.ResponseObject;
import com.example.medical.model.Schedule;
import com.example.medical.model.TimeSlot;
import com.example.medical.service.ApiClient;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointmentForm extends AppCompatActivity {
    Doctor doctor;
    Schedule schedule;
    TimeSlot timeSlot;
    int gender = -1;
    ImageView img;
    TextView nameForm, priceForm, timeForm;
    EditText nameEdit, phoneEdit, cityEdit, districtEdit, wardEdit, addressEdit, noteEdit;
    TextView birthEdit;
    RadioGroup genderRadio;
    Button button;

    /*
    use case 2 Đăng ký lịch khám mới
    12. onCreate()
  */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_form);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        doctor = (Doctor) bundle.get("doctor");
        schedule = (Schedule) bundle.get("schedule");
        timeSlot = (TimeSlot) bundle.get("time");
        img = findViewById(R.id.image_form);
        Glide.with(img.getContext()).load(doctor.getUrlPhoto()).transform(new CircleCrop()).into(img);
        nameForm = findViewById(R.id.name_form);
        nameForm.setText(doctor.getEducation() + " " + doctor.getName());
        timeForm = findViewById(R.id.time_form);
        timeForm.setText(timeSlot.getTime() + " - " + schedule.getWorkDate());
        priceForm = findViewById(R.id.price_form);
        priceForm.setText(priceForm.getText().toString() + doctor.getFee() + "Đ");
        setUpForm();
    }

    /*
   use case 2 Đăng ký lịch khám mới
   13. Nhập thông tin và bấm xác nhận
  */
    public void setUpForm() {
        nameEdit = findViewById(R.id.name_edit);
        genderRadio = findViewById(R.id.gender_radio_group);
        RadioButton maleRadioButton = findViewById(R.id.male_radio_button);
        RadioButton femaleRadioButton = findViewById(R.id.female_radio_button);

        genderRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == maleRadioButton.getId()) {
                    gender = 0;
                } else if (i == femaleRadioButton.getId()) {
                    gender = 1;
                }
            }
        });


        phoneEdit = findViewById(R.id.phone_edit);
        birthEdit = findViewById(R.id.birth_edit);
        birthEdit.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(AppointmentForm.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String newMonth;
                    if (month + 1 < 10) newMonth = "0" + (month + 1);
                    else {
                        newMonth = "" + (month + 1);
                    }
                    String date = year + "-" + newMonth + "-" + dayOfMonth;
                    birthEdit.setText(date);
                }
            }, year, month, day);
            datePickerDialog.show();
        });
        cityEdit = findViewById(R.id.city_edit);
        districtEdit = findViewById(R.id.quan_edit);
        wardEdit = findViewById(R.id.phuong_edit);
        addressEdit = findViewById(R.id.address_edit);
        noteEdit = findViewById(R.id.note_edit);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            if (checlInfo(nameEdit.getText().toString(), gender, phoneEdit.getText().toString(), birthEdit.getText().toString(), cityEdit.getText().toString(), districtEdit.getText().toString(), wardEdit.getText().toString(), addressEdit.getText().toString())) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate;
                try {
                    birthDate = format.parse(birthEdit.getText().toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Patient patient = new Patient("BN-" + nameEdit.getText().toString() + "-" + phoneEdit.getText().toString(), phoneEdit.getText().toString(), nameEdit.getText().toString(), birthDate, gender, cityEdit.getText().toString(), districtEdit.getText().toString(), wardEdit.getText().toString(), addressEdit.getText().toString());
                checkPatient(patient);
            } else {
                Toast.makeText(v.getContext(), "Thông tin không chính xác", Toast.LENGTH_SHORT).show();
            }
        });


    }

    /*
    use case 2 Đăng ký lịch khám mới
    14. checkInfo()
    */
    public boolean checlInfo(String name, int gender, String phone, String birth, String city, String district, String ward, String address) {
        if (name.isBlank() || phone.isBlank() || city.isBlank() || district.isBlank() || ward.isBlank() || address.isBlank() || gender == -1 || birth.isBlank()) {
            Log.e("Lỗi", birth);
            Log.e("Lỗi", name);
            Log.e("Lỗi", phone);
            Log.e("Lỗi", city);
            Log.e("Lỗi", district);
            Log.e("Lỗi", ward);
            Log.e("Lỗi", address);
            Log.e("Lỗi", "" + gender);
            return false;
        }

        String[] names = name.split(" ");
        for (String s : names) {
            if (!Character.isUpperCase(s.charAt(0))) {
                Log.e("Lỗi", s);
                return false;
            }
        }
        if (phone.charAt(0) != '0') {
            Log.e("Lỗi", phone);
            return false;
        }
        String regex = ".*[!@#$%^&*()_+=\\[\\]{};':\"\\\\|,.<>\\/?].*";
        if (name.matches(regex)) {
            Log.e("Lỗi", name);
            return false;
        }
        return true;
    }

    /*
    use case 2 Đăng ký lịch khám mới
    15.checkPatient()
    */
    public void checkPatient(Patient patient) {
        Call<ResponseObject> call = ApiClient.getApiService().getPatientById(patient.getId());
        call.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getData() != null) {
                    Toast.makeText(AppointmentForm.this, "checkPatient bị Lỗi", Toast.LENGTH_LONG).show();
                    Appointment a = new Appointment();
                    a.setStatus(1);
                    a.setPatient(patient);
                    a.setDoctor(doctor);
                    a.setDescription("benh");
                    a.setSchedule(schedule);
                    a.setTimeSlot(timeSlot);
                    Log.e("Lỗi", a.toString());
                    saveAppointment(a);
                } else {
                    Log.e("Loi", patient.toString());
                    savePatient(patient);
                    Appointment a = new Appointment();
                    a.setStatus(1);
                    a.setPatient(patient);
                    a.setDoctor(doctor);
                    a.setDescription("benh");
                    a.setSchedule(schedule);
                    a.setTimeSlot(timeSlot);
                    saveAppointment(a);
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                Toast.makeText(AppointmentForm.this, "checkPatient bị Lỗi", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void savePatient(Patient patient) {
        Call<Patient> call = ApiClient.getApiService().addPatientDB(patient);
        call.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                Toast.makeText(AppointmentForm.this, "save thành công", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Toast.makeText(AppointmentForm.this, "savePatient bị lỗi", Toast.LENGTH_LONG).show();
            }
        });
    }

    /*
    use case 2 Đăng ký lịch khám mới
    16. Post: api/v1/
    */
    public void saveAppointment(Appointment appointment) {
        Call<Appointment> call = ApiClient.getApiService().addDB(appointment);
        call.enqueue(new Callback<Appointment>() {
            @Override
            public void onResponse(Call<Appointment> call, Response<Appointment> response) {
                    /*
                      use case 2 Đăng ký lịch khám mới
                     16.2 Toast.makeText().show()
                    */
                Toast.makeText(AppointmentForm.this, "Đặt lịch khám thành công", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AppointmentForm.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                AppointmentForm.this.startActivity(intent);
            }

            @Override
            public void onFailure(Call<Appointment> call, Throwable t) {

            }
        });
    }
}