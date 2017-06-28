package soft.hnron.shingohananiiro

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val blueButton = view?.findViewById<ImageButton>(R.id.blueButton)
        val yellowButton = view?.findViewById<ImageButton>(R.id.yellowButton)
        val redButton = view?.findViewById<ImageButton>(R.id.redButton)

        val blueImage = resources.getDrawable(R.drawable.signal_blue)
        val yellowImage = resources.getDrawable(R.drawable.signal_yellow)
        val redImage = resources.getDrawable(R.drawable.signal_red)

        val imageView = view?.findViewById<ImageView>(R.id.imageView)
        imageView?.setImageDrawable(redImage)

        blueButton?.setOnClickListener { v ->
            val resultTextView = view.findViewById<TextView>(R.id.resultTextView)
            resultTextView.setTextColor(Color.BLUE)
            resultTextView.setText(R.string.result_blue)
        }

        yellowButton?.setOnClickListener { v ->
            val resultTextView = view.findViewById<TextView>(R.id.resultTextView)
            resultTextView.setTextColor(Color.YELLOW)
            resultTextView.setText(R.string.result_yellow)
        }

        redButton?.setOnClickListener { v ->
            val resultTextView = view.findViewById<TextView>(R.id.resultTextView)
            resultTextView.setTextColor(Color.RED)
            resultTextView.setText(R.string.result_red)
        }
    }
}
