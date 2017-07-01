package soft.hnron.calculator

import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class MainActivityFragment : Fragment() {

    private var mResultTextView: TextView? = null

    private var mLeftNumber: Double = 0.0
    private var mRightNumber: Double = 0.0
    private var mResult: Double = 0.0
    private var mOperatorId: String = ""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mResultTextView = view?.findViewById(R.id.result_text_view)

        val button0 = view?.findViewById<Button>(R.id.button_0)!!
        val button1 = view.findViewById<Button>(R.id.button_1)!!
        val button2 = view.findViewById<Button>(R.id.button_2)!!
        val button3 = view.findViewById<Button>(R.id.button_3)!!
        val button4 = view.findViewById<Button>(R.id.button_4)!!
        val button5 = view.findViewById<Button>(R.id.button_5)!!
        val button6 = view.findViewById<Button>(R.id.button_6)!!
        val button7 = view.findViewById<Button>(R.id.button_7)!!
        val button8 = view.findViewById<Button>(R.id.button_8)!!
        val button9 = view.findViewById<Button>(R.id.button_9)!!
        val buttonPlus = view.findViewById<Button>(R.id.button_plus)!!
        val buttonMinus = view.findViewById<Button>(R.id.button_minus)!!
        val buttonTimes = view.findViewById<Button>(R.id.button_times)!!
        val buttonDivide = view.findViewById<Button>(R.id.button_divide)!!
        val buttonEqual = view.findViewById<Button>(R.id.button_equal)!!
        val buttonClear = view.findViewById<Button>(R.id.button_clear)!!

        button0.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button1.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button2.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button3.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button4.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button5.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button6.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button7.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button8.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        button9.setOnClickListener { v -> numberButtonTapped(v.tag.toString().toDouble()) }
        buttonPlus.setOnClickListener { v -> operatorButtonTapped(v.tag.toString()) }
        buttonMinus.setOnClickListener { v -> operatorButtonTapped(v.tag.toString()) }
        buttonTimes.setOnClickListener { v -> operatorButtonTapped(v.tag.toString()) }
        buttonDivide.setOnClickListener { v -> operatorButtonTapped(v.tag.toString()) }
        buttonEqual.setOnClickListener { equalButtonTapped() }
        buttonClear.setOnClickListener { clearButtonTapped() }
    }

    fun numberButtonTapped(number: Double) {
        Log.d("numberButtonTapped", number.toString())
        mRightNumber = mRightNumber * 10 + number

        updateDisplay(mRightNumber)
    }

    fun operatorButtonTapped(operator: String) {
        Log.d("operatorButtonTapped", operator)
        mOperatorId = operator
        mLeftNumber = mRightNumber
        mRightNumber = 0.0
    }

    fun equalButtonTapped() {
        Log.d("equalButtonTapped", "equal")

        when (mOperatorId) {
            resources.getString(R.string.plus) ->
                mResult = mLeftNumber + mRightNumber
            resources.getString(R.string.minus) ->
                mResult = mLeftNumber - mRightNumber
            resources.getString(R.string.times) ->
                mResult = mLeftNumber * mRightNumber
            resources.getString(R.string.divide) ->
                mResult = mLeftNumber / mRightNumber
        }

        Log.d("equalButtonTapped", "mLeftNumber: " + mLeftNumber)
        Log.d("equalButtonTapped", "mOperatorId: " + mOperatorId)
        Log.d("equalButtonTapped", "mRightNumber: " + mRightNumber)
        Log.d("equalButtonTapped", "mResult: " + mResult)

        mRightNumber = mResult

        mResultTextView?.text = mResult.toString()
    }

    fun clearButtonTapped() {
        Log.d("clearButtonTapped", "clear")

        mRightNumber = 0.0
        mRightNumber = 0.0
        mResult = 0.0
        mOperatorId = ""

        updateDisplay(0.0)
    }

    fun updateDisplay(number: Double) {
        mResultTextView?.text = String.format("%.0f", number)
    }
}
