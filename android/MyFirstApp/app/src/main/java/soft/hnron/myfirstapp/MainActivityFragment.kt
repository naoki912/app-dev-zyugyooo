package soft.hnron.myfirstapp

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (view != null) {
            val textView = view.findViewById<TextView>(R.id.text_view)
            val button = view.findViewById<Button>(R.id.button)

            button.setOnClickListener {
                textView.text = resources.getString(R.string.label_tapped_text)
            }
        }
    }
}
