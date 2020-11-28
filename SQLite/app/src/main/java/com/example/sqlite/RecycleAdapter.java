package com.example.sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.StudentViewer> {

    List<POJO> studentDetails;
    Context context;
    OpenHelper dbhelper;
    SQLiteDatabase sqLiteDatabase;

    public RecycleAdapter(List<POJO> studentDetails) {
        this.studentDetails = studentDetails;
    }

    @NonNull
    @Override
    public StudentViewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View iteView = inflater.inflate(R.layout.student_info, parent, false);
        StudentViewer viewHolder = new StudentViewer(iteView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewer holder, final int position) {
        final POJO pojo = studentDetails.get(position);

        holder.sID.setText("ID: " + pojo.getS_id());
        holder.sIdno.setText("ID number: " + pojo.getS_idno());
        holder.sName.setText("Name: " + pojo.getS_name());
        holder.sAddress.setText("Address: " + pojo.getS_address());
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int pId = pojo.getS_id();
                dbhelper = new OpenHelper(context);
                sqLiteDatabase = dbhelper.getWritableDatabase();
                sqLiteDatabase.delete(DatabaseInfo.TABLE_NAME, DatabaseInfo._ID+ " = " + pId,null);
                notifyItemRangeChanged(position,studentDetails.size());
                studentDetails.remove(position);
                notifyItemRemoved(position);
                sqLiteDatabase.close();
            }
        });

        holder.Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, update.class);
                intent.putExtra("stuId", pojo.getS_id());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentDetails.size();
    }

    public class StudentViewer extends RecyclerView.ViewHolder {
        TextView sID;
        TextView sIdno;
        TextView sName;
        TextView sAddress;
        TextView Delete;
        TextView Update;

        public StudentViewer(View itemView) {
            super(itemView);
            sID = itemView.findViewById(R.id.txtid);
            sIdno = itemView.findViewById(R.id.txtidno);
            sName = itemView.findViewById(R.id.txtname);
            sAddress = itemView.findViewById(R.id.txtaddress);
            Delete = itemView.findViewById(R.id.Delete);
            Update = itemView.findViewById(R.id.Update);
        }
    }
    public void deleteStudent() {

    }
}
