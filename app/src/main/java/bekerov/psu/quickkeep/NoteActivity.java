package bekerov.psu.quickkeep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    private String mIdHeadlineText;
    private String mIdAnotherText;

    private EditText mHeadlineText;
    private EditText mAnotherText;

    public NoteActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mIdHeadlineText = getResources().getString(R.string.id_headline_text);
        mIdAnotherText = getResources().getString(R.string.id_another_text);

        mHeadlineText = (EditText) findViewById(R.id.headLineEditText);
        mAnotherText = (EditText) findViewById(R.id.anotherEditText);

        Intent intent = getIntent();

        mHeadlineText.setText(intent.getStringExtra(mIdHeadlineText));
        mAnotherText.setText(intent.getStringExtra(mIdAnotherText));

    }

    public void backClick(View view) {
        finish();
    }

    public void acceptNoteClick(View view) {
        finish();
    }

    @Override
    public void finish() {
        String text = mHeadlineText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(mIdHeadlineText, text);
        text = mAnotherText.getText().toString();
        intent.putExtra(mIdAnotherText, text);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
