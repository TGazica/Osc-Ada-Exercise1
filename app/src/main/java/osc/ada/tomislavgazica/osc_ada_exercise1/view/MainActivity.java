package osc.ada.tomislavgazica.osc_ada_exercise1.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import osc.ada.tomislavgazica.osc_ada_exercise1.R;
import osc.ada.tomislavgazica.osc_ada_exercise1.TasksRepository;
import osc.ada.tomislavgazica.osc_ada_exercise1.model.Task;

public class MainActivity extends AppCompatActivity {

	TasksRepository mRepository = TasksRepository.getInstance();

    @BindView(R.id.edittext_newtask_title) EditText mTitle;
    @BindView(R.id.edittext_newtask_summary) EditText mSummary;
    @BindView(R.id.edittext_newtask_importance) EditText mImportance;
    @BindView(R.id.textview_newtask_display) TextView mDisplay;
    Task task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

	}

	@OnClick(R.id.button_newtask_save)
	public void storeTask(View view){

		// ToDo: 	store the task
		// Parse data from the widgets and store it in a task
		// Store the task in the fake database using the repository

        task = new Task(Integer.parseInt(mImportance.getText().toString()), mTitle.getText().toString(), mSummary.getText().toString());
        mRepository.save(task);

		// ToDo:	clear the UI for the new task
		// Clear all of the editText controls

        mTitle.setText(null);
        mSummary.setText(null);
        mImportance.setText(null);

		// ToDo: 	define a method
		// Create a method for displaying the tasks in the textview as strings
		// one below the other and call it on each new task.

        listTasks();

	}

	public void listTasks(){
	    StringBuilder sb = new StringBuilder();

	    for (int i= 0; i < mRepository.getTasks().size(); i++){
	        sb.append(mRepository.getTasks().get(i));
        }

        mDisplay.setText(sb);

    }

}
