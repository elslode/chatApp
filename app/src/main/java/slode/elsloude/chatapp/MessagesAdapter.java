package slode.elsloude.chatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesVieHolder> {

    private List<Message> messages;

    public MessagesAdapter() {
        messages  = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessagesVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_message, parent, false);
        return new MessagesVieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesVieHolder holder, int position) {
        Message message = messages.get(position);
        String author = message.getAuthor();
        String textOfMessage = message.getTextOfMessage();
        String urlToImage = message.getImageUrl();
        holder.textViewAuthor.setText(messages.get(position).getAuthor());
        if (textOfMessage != null && !textOfMessage.isEmpty()) {
            holder.textViewOfMessage.setText(messages.get(position).getTextOfMessage());
        }
        if (urlToImage != null && !urlToImage.isEmpty()) {
            holder.imageViewImage.setVisibility(View.VISIBLE);
            Picasso.get().load(urlToImage).into(holder.imageViewImage);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessagesVieHolder extends RecyclerView.ViewHolder {

        private TextView textViewAuthor;
        private TextView textViewOfMessage;
        private ImageView imageViewImage;

        public MessagesVieHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewOfMessage = itemView.findViewById(R.id.textViewTextOfMessage);
            imageViewImage = itemView.findViewById(R.id.imageViewImage);
        }
    }
}
