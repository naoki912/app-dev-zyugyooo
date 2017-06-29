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
import java.util.*


class MainActivityFragment : Fragment() {

    private var BLUE_SIGNAL: Int = 0
    private var YELLOW_SIGNAL: Int = 1
    private var RED_SIGNAL: Int = 2

    private var mCurrentSignal: Int = 0

    private var mSignalImageView: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val blueButton = view?.findViewById<ImageButton>(R.id.blueButton)
        val yellowButton = view?.findViewById<ImageButton>(R.id.yellowButton)
        val redButton = view?.findViewById<ImageButton>(R.id.redButton)

        val resultTextView = view?.findViewById<TextView>(R.id.resultTextView)

        mSignalImageView = view?.findViewById<ImageView>(R.id.signalImageView)
        randomSignal()

        blueButton?.setOnClickListener { v ->
            resultTextView?.setTextColor(Color.BLUE)

            if (mCurrentSignal == BLUE_SIGNAL) {
                resultTextView?.text = resources.getString(R.string.correct)
            } else {
                resultTextView?.text = resources.getString(R.string.incorrect)
            }

            randomSignal()
        }

        yellowButton?.setOnClickListener { v ->
            resultTextView?.setTextColor(Color.YELLOW)

            if (mCurrentSignal == YELLOW_SIGNAL) {
                resultTextView?.text = resources.getString(R.string.correct)
            } else {
                resultTextView?.text = resources.getString(R.string.incorrect)
            }

            randomSignal()
        }

        redButton?.setOnClickListener { v ->
            resultTextView?.setTextColor(Color.RED)

            if (mCurrentSignal == RED_SIGNAL) {
                resultTextView?.text = resources.getString(R.string.correct)
            } else {
                resultTextView?.text = resources.getString(R.string.incorrect)
            }

            randomSignal()
        }
    }

    fun randomSignal() {
        val randomNumber = Random().nextInt(3)

        if (randomNumber == BLUE_SIGNAL) {
            mCurrentSignal = BLUE_SIGNAL
            mSignalImageView?.setImageResource(R.drawable.signal_blue)
        } else if (randomNumber == YELLOW_SIGNAL) {
            mCurrentSignal = YELLOW_SIGNAL
            mSignalImageView?.setImageResource(R.drawable.signal_yellow)
        } else if (randomNumber == RED_SIGNAL) {
            mCurrentSignal = RED_SIGNAL
            mSignalImageView?.setImageResource(R.drawable.signal_red)
        }
    }
}
