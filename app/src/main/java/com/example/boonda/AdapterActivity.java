package com.example.boonda;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.MyViewHolder> {

    ArrayList<ModelActivity> mList;
    Context context;

    public AdapterActivity(Context context, ArrayList<ModelActivity> mList){
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.carddiscussion, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        MyViewHolder viewHolder = (MyViewHolder)holder;
        final ModelActivity model = mList.get(position);
        holder.topic.setText(mList.get(position).getTopic());
        holder.title.setText(mList.get(position).getTitle());
        holder.name.setText(mList.get(position).getName());
        holder.date.setText(mList.get(position).getDate());
        holder.question.setText(mList.get(position).getQuestion());
        holder.like.setText(mList.get(position).getLike());
        holder.reply.setText(mList.get(position).getReply());

        Glide.with(holder.imgProfile.getContext()).load(mList.get(position).getAskerphoto()).placeholder(R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imgProfile);
        Glide.with(holder.imgProfileUser.getContext()).load(mList.get(position).getPhoto()).placeholder(R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imgProfileUser);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),CommentActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("key", model);
//                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgProfile, imgProfileUser;
        TextView topic, title, name, date, question, like, reply;
        public MyViewHolder(View itemView){
            super(itemView);
            imgProfile = itemView.findViewById(R.id.img_profile);
            imgProfileUser = itemView.findViewById(R.id.img_profileuser);
            topic = itemView.findViewById(R.id.tv_theme);
            title = itemView.findViewById(R.id.tv_question);
            name = itemView.findViewById(R.id.tv_name);
            date = itemView.findViewById(R.id.tv_posted);
            question = itemView.findViewById(R.id.tv_detailquestion);
            like = itemView.findViewById(R.id.tv_like);
            reply = itemView.findViewById(R.id.et_replies);
        }
    }
}
