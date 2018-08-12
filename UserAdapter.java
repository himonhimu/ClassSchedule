package bd.himu.himon.classschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Design on 8/11/2018.
 */

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<NotesModel> users;

    public UserAdapter(List<NotesModel> users) {
        this.users =users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.noteTitle.setText(users.get(position).getTitleText());
        holder.noteBody.setText(users.get(position).getBodyText());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle, noteBody;
        public ViewHolder(final View itemView) {
            super(itemView);
            noteTitle= itemView.findViewById(R.id.NoteTitle);
            noteBody = itemView.findViewById(R.id.noteBody);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    users.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                   notifyItemRangeChanged(getAdapterPosition(), users.size());
                   notifyDataSetChanged();

                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int p = getLayoutPosition();
                    Toast.makeText(view.getContext(), "You Clicked : "+p, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
