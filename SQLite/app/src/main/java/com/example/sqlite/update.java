package com.example.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class update  extends AppCompatActivity {

    EditText updateSID;
    EditText updateSName;
    EditText updateSAddress;
    String SID;
    String SName;
    String SAddress;

    List<POJO> studentDetails;
    OpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;

    int rowId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        openHelper = new OpenHelper(this);
        sqLiteDatabase = openHelper.getWritableDatabase();
        updateSID = findViewById(R.id.update_studentID);
        updateSName = findViewById(R.id.update_studentName);
        updateSAddress = findViewById(R.id.update_studentAdd);

        rowId = getIntent().getIntExtra("stuId", -1);

        Cursor cursor = sqLiteDatabase.query(DatabaseInfo.TABLE_NAME, null, DatabaseInfo._ID + " = " + rowId, null, null,null, null);
        studentDetails = new ArrayList<POJO>();
        studentDetails.clear();

        if(cursor != null && cursor.getCount() != 0) {
            while(cursor.moveToNext()) {
                updateSID.setText(cursor.getString(cursor.getColumnIndex(DatabaseInfo.StudentID)));
                updateSName.setText(cursor.getString(cursor.getColumnIndex(DatabaseInfo.StudentName)));
                updateSAddress.setText(cursor.getString(cursor.getColumnIndex(DatabaseInfo.StudentAddress)));
            }
        }
        else {
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show();
        }

    }
    public void clickUpdate(View view) {
        SID = updateSID.getText().toString();
        SName = updateSName.getText().toString();
        SAddress = updateSAddress.getText().toString();

        if (TextUtils.isEmpty(SID) || TextUtils.isEmpty(SName) || TextUtils.isEmpty(SAddress)) {
            Toast.makeText(this, "Check the Empty Fields", Toast.LENGTH_LONG).show();
        }
        else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseInfo.StudentID, SID);
            contentValues.put(DatabaseInfo.StudentName, SName);
            contentValues.put(DatabaseInfo.StudentAddress, SAddress);

            int updateId = sqLiteDatabase.update(DatabaseInfo.TABLE_NAME, contentValues, DatabaseInfo._ID + " = " + rowId, null);
            if(updateId != -1) {
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
            else {
                Toast.makeText(this, "Not Updated!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        sqLiteDatabase.close();
        super.onDestroy();
    }
}