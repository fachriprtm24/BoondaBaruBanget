package com.example.boonda;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.annotations.NotNull;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import de.hdodenhof.circleimageview.CircleImageView;


public class DiscussionAdapter extends FirebaseRecyclerAdapter<Model, DiscussionAdapter.MyViewHolder> {

    public DiscussionAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Model model) {
        holder.topic.setText(model.getTopic());
        holder.title.setText(model.getTitle());
        holder.name.setText(model.getName());
        holder.date.setText(model.getDate());
        holder.question.setText(model.getQuestion());
        holder.like.setText(model.getLike());
        holder.reply.setText(model.getReply());

        Glide.with(holder.imgProfile.getContext()).load(model.getAskerphoto()).placeholder(R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imgProfile);
        Glide.with(holder.imgProfileUser.getContext()).load(model.getPhoto()).placeholder(R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark_normal).into(holder.imgProfileUser);
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

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddiscussion,parent,false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgProfile, imgProfileUser;
        TextView topic, question, name, date, title, like, reply;

        public MyViewHolder(@NonNull View itemView) {
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
