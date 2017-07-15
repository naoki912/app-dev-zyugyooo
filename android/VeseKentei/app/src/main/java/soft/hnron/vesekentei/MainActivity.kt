package soft.hnron.vesekentei

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.opencsv.CSVReader
import soft.hnron.vesekentei.objects.Problem
import java.io.InputStreamReader

class MainActivity : AppCompatActivity(),
        MainActivityFragment.MainActivityFragmentListener,
        TestFragment.TestFragmentListener,
        ScoreFragment.ScoreFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, MainActivityFragment.newInstance())
                .commit()

        Problem.initialization(CSVReader(InputStreamReader( resources.assets.open("csv/tests.csv"))).toList())
    }

    override fun onStartButtonClick() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, TestFragment.newInstance(), TestFragment.TAG)
                .addToBackStack(TestFragment.TAG)
                .commit()
    }

    override fun onSelectorClick() {
        if (Problem.isProblemEnded) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, ScoreFragment.newInstance(), ScoreFragment.TAG)
                    .addToBackStack(ScoreFragment.TAG)
                    .commit()
        }
    }
}
