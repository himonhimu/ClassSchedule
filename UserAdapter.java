package bd.himu.himon.classschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import android.content.*;


/**
 * Created by Design on 8/11/2018.
 */

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<NotesModel> noteList;


    public UserAdapter(List<NotesModel> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.noteTitle.setText(noteList.get(position).getTitleText());
        holder.noteBody.setText(noteList.get(position).getBodyText()+"     "+noteList.get(position).getId());

    }

    @Override
    public int getItemCount() {
       //  if (noteList != null) return noteList.size();else return 0;
        return noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle, noteBody;

        public ViewHolder(final View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.NoteTitle);
            noteBody = itemView.findViewById(R.id.noteBody);

         itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {


                    NotesFragment.appsDatabase.classDao().deletenow(noteList.get(getAdapterPosition()));


                    noteList.remove(getAdapterPosition());
                    Toast.makeText(view.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(), noteList.size());
                    notifyDataSetChanged();
                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int p = getLayoutPosition();
                    String sendTitle = noteList.get(p).getTitleText();
                    String sendBody = noteList.get(p).getBodyText();
                    //context.startActivity(context, UpdateNotes.class);
                    /*Intent himon = new Intent(context, UpdateNotes.class);
                    himon.putExtra("getTitle", sendTitle);
                    himon.putExtra("getBody", sendBody);
                    context.startActivity(himon);*/
                    sendData(itemView, sendTitle,sendBody,p);

                   // Toast.makeText(view.getContext(), "You Clicked : " + p + sendTitle, Toast.LENGTH_SHORT).show();


                }
            });
        }

    }
    public void sendData(View view, String data1, String data2, int a) {
        Intent himon = new Intent(view.getContext(), UpdateNotes.class);
        himon.putExtra("getTitle", data1);
        himon.putExtra("getBody", data2);
        himon.putExtra("getInt", a);
        view.getContext().startActivity(himon);
    }




}
