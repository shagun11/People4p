package com.example.people4p;
import android.content.Context;
import java.util.List;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by shagun11 on 06/04/18.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Tasks> listTasks;
    private Context mContext;

    public TaskAdapter(Context context, List<Tasks>listTasks) {
        this.listTasks = listTasks;
        this.mContext = context;
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {
         TextView description;
         TextView duration;
        public TaskViewHolder(View view) {
            super(view);
            description = (TextView) view.findViewById(R.id.description);
            duration = (TextView) view.findViewById(R.id.duration);

        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_layout, null);
        return new TaskViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TaskAdapter.TaskViewHolder holder, int position) {

        holder.description.setText(listTasks.get(position).getDescription());
        holder.duration.setText(String.valueOf(listTasks.get(position).getDuration()));
    }

    @Override
    public int getItemCount() {
        return listTasks.size();
    }
}