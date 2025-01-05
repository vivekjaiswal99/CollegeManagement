package com.example.collegemanagement;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdmissionDeleteAdaptor extends RecyclerView.Adapter<AdmissionDeleteAdaptor.ViewHolder>{
    ArrayList<OnlineAdmissionUserModel> admissionUserModelArrayList;
    Context context;
    public AdmissionDeleteAdaptor(ArrayList<OnlineAdmissionUserModel> admissionUserModelArrayList, Context context) {
        this.admissionUserModelArrayList = admissionUserModelArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delete_addmission_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        OnlineAdmissionUserModel userModel = admissionUserModelArrayList.get(position);
        holder.textViewN.setText(userModel.getName());
        holder.textViewE.setText(userModel.getEmail());
        holder.textViewF.setText(userModel.getFather());
        holder.textViewC.setText(userModel.getCourse());
        holder.textViewL.setText(userModel.getLocation());
        holder.textViewP.setText(userModel.getPhone());
        holder.textViewG.setText(userModel.getGender());
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                OnlineAdmissionDataBase dataBase = new OnlineAdmissionDataBase(context);
                dataBase.GetDeleteAdmissionData(userModel.getId());
                AlertDialog.Builder builder  = new AlertDialog.Builder(v.getContext());
                builder.setIcon(R.drawable.delete1);
                builder.setTitle("DELETE");
                builder.setMessage("Do You Want To Delete Specific Items");
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        admissionUserModelArrayList.remove(position);
                        notifyItemChanged(position);
                        notifyItemChanged(position,admissionUserModelArrayList.size());
                        Toast.makeText(context, "Delete SuccessFully.........", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return admissionUserModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewN,textViewE,textViewF,textViewG,textViewC,textViewL,textViewP;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewN = itemView.findViewById(R.id.Name_tv);
            textViewE = itemView.findViewById(R.id.Email_tv);
            textViewG = itemView.findViewById(R.id.Gender_tv);
            textViewF = itemView.findViewById(R.id.Father_tv);
            textViewC = itemView.findViewById(R.id.Course_tv);
            textViewL = itemView.findViewById(R.id.Location_tv);
            textViewP = itemView.findViewById(R.id.Phone_tv);
            cardView = itemView.findViewById(R.id.CardViews);
        }
    }
}
