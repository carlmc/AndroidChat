package com.example.cmunayll.androidchat.chat.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cmunayll.androidchat.R;
import com.example.cmunayll.androidchat.chat.entities.ChatMessage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class ChatAdapter extends RecyclerView.Adapter <ChatAdapter.ViewHolder> {

    private Context context;
    private List<ChatMessage> chatMessages;

    public ChatAdapter(Context context, List<ChatMessage> chatMessages) {
        this.context = context;
        this.chatMessages = chatMessages;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_chat, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        ChatMessage chatMessage = chatMessages.get(position);

        String msg = chatMessage.getMsg();
        holder.tvMessage.setText(msg);

        int color = fetchColor(R.attr.colorPrimary);
        int gravity = Gravity.LEFT;

        if (!chatMessage.isSentByMe()) {
            gravity = Gravity.RIGHT;
            color = fetchColor(R.attr.colorAccent);
        }

        holder.tvMessage.setBackgroundColor(color);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.tvMessage.getLayoutParams();
        params.gravity = gravity;
        holder.tvMessage.setLayoutParams(params);
    }

    private int fetchColor(int color) {
        TypedValue typedValue = new TypedValue();
        TypedArray a = context.obtainStyledAttributes(typedValue.data, new int[] {color});
        int returnColor = a.getColor(0, 0);
        a.recycle();

        return returnColor;
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    private boolean alreadyInAdapter(ChatMessage newMsg) {
        boolean alreadyInAdapter = false;
        for (ChatMessage msg : this.chatMessages) {
            if (msg.getMsg().equals(newMsg.getMsg()) && msg.getSender().equals(newMsg.getSender())) {
                alreadyInAdapter = true;
                break;
            }
        }

        return alreadyInAdapter;
    }

    public void add(ChatMessage message) {
        if (!alreadyInAdapter(message)) {
            this.chatMessages.add(message);
            this.notifyDataSetChanged();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvMessage) TextView tvMessage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
