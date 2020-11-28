package com.example.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class add extends AppCompatActivity {

    OpenHelper openHelper;
    String SID;
    String SName;
    String SAddress;
    SQLiteDatabase sqLiteDatabase;
    EditText editID;
    EditText editName;
    EditText editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        openHelper = new OpenHelper(this);
        sqLiteDatabase = openHelper.getWritableDatabase();
        editID = findViewById(R.id.studentID);
        editName = findViewById(R.id.studentName);
        editAddress = findViewById(R.id.studentAdd);
    }
    public void clickAdd(View view) {
        SID = editID.getText().toString();
        SName = editName.getText().toString();
        SAddress = editAddress.getText().toString();

        if(TextUtils.isEmpty(SID) || TextUtils.isEmpty(SName) || TextUtils.isEmpty(SAddress)) {
            Toast.makeText(this, "Required Fields", Toast.LENGTH_SHORT).show();
        }
        else
            {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseInfo._ID, (byte[]) null);
            contentValues.put(DatabaseInfo.StudentID, SID);
            contentValues.put(DatabaseInfo.StudentName, SName);
            contentValues.put(DatabaseInfo.StudentAddress, SAddress);
            long rowId = sqLiteDatabase.insert(DatabaseInfo.TABLE_NAME, null, contentValues);

            if (rowId != -1) {
                Toast.makeText(this, "Record Added",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }
            else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}