package soft.hnron.vesekentei

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity(),
        MainActivityFragment.MainActivityFragmentListener,
        KenteiFragment.KenteiFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, MainActivityFragment.newInstance())
                .commit()
    }

    override fun onStartButtonClick() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, KenteiFragment.newInstance(), KenteiFragment.TAG)
                .addToBackStack(KenteiFragment.TAG)
                .commit()
    }
}
