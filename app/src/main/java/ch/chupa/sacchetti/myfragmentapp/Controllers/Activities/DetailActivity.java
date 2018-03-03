package ch.chupa.sacchetti.myfragmentapp.Controllers.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ch.chupa.sacchetti.myfragmentapp.Controllers.Fragments.DetailFragment;
import ch.chupa.sacchetti.myfragmentapp.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_BUTTON_TAG = "ch.chupa.sacchetti.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 2 - Configure and show home fragment
        this.configureAndShowDetailFragment();
    }


    @Override
    public void onResume() {
        super.onResume();
        // 3 - Call update method here because we are sure that DetailFragment is visible
        this.updateDetailFragmentTextViewWithIntentTag();
    }

    // --------------
    // UPDATE UI
    // --------------

    // 2 - Update DetailFragment with tag passed from Intent
    private void updateDetailFragmentTextViewWithIntentTag(){
        // Get button's tag from intent
        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        // Update DetailFragment's TextView
        detailFragment.updateTextView(buttonTag);
    }

    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowDetailFragment(){
        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null) {
            // B - Create new main fragment
            detailFragment = new DetailFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }
}
