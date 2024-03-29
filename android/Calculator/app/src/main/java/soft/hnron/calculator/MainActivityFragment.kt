package soft.hnron.calculator

import android.graphics.Typeface
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivityFragment : Fragment() {

    private var mResultTextView: TextView? = null

    private var mLeftNumber = BigDecimal.ZERO
    private var mRightNumber = BigDecimal.ZERO
    private var mResult = BigDecimal.ZERO
    private var mOperatorId = ""

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

        button0.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button1.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button2.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button3.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button4.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button5.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button6.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button7.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button8.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        button9.setOnClickListener { v -> numberButtonTapped(BigDecimal(v.tag.toString())) }
        buttonPlus.setOnClickListener { v -> operatorButtonTapped(v.tag.toString()) }
        buttonMinus.setOnClickListener { v -> operatorButtonTapped(v.tag.toString()) }
        buttonTimes.setOnClickListener { v -> operatorButtonTapped(v.tag.toString()) }
        buttonDivide.setOnClickListener { v -> operatorButtonTapped(v.tag.toString()) }
        buttonEqual.setOnClickListener { equalButtonTapped() }
        buttonClear.setOnClickListener { clearButtonTapped() }

        val typeface = Typeface.createFromAsset(context.assets, "font/lets_go_digital_regular.ttf")
        button0.typeface = typeface
        button1.typeface = typeface
        button2.typeface = typeface
        button3.typeface = typeface
        button4.typeface = typeface
        button5.typeface = typeface
        button6.typeface = typeface
        button7.typeface = typeface
        button8.typeface = typeface
        button9.typeface = typeface
        buttonPlus.typeface = typeface
        buttonMinus.typeface = typeface
        buttonTimes.typeface = typeface
        buttonDivide.typeface = typeface
        buttonEqual.typeface = typeface
        buttonClear.typeface = typeface
    }

    fun numberButtonTapped(number: BigDecimal) {
        mRightNumber = mRightNumber.times(BigDecimal.TEN).add(number)

        updateDisplay(mRightNumber)
    }

    fun operatorButtonTapped(operator: String) {
        mOperatorId = operator
        mLeftNumber = mRightNumber
        mRightNumber = BigDecimal.ZERO
    }

    fun equalButtonTapped() {
        when (mOperatorId) {
            resources.getString(R.string.plus) ->
                mResult = mLeftNumber.add(mRightNumber)
            resources.getString(R.string.minus) ->
                mResult = mLeftNumber.minus(mRightNumber)
            resources.getString(R.string.times) ->
                mResult = mLeftNumber.times(mRightNumber)
            resources.getString(R.string.divide) ->
                if (mRightNumber.compareTo(BigDecimal.ZERO) == 0) {
                    updateDisplay("Infinity")
                    return
                } else {
                    mResult = mLeftNumber.divide(mRightNumber, 6, RoundingMode.HALF_UP)
                }
        }

        mRightNumber = mResult

        updateDisplay(mResult)
    }

    fun clearButtonTapped() {
        mRightNumber = BigDecimal.ZERO
        mRightNumber = BigDecimal.ZERO
        mResult = BigDecimal.ZERO
        mOperatorId = ""

        updateDisplay(BigDecimal.ZERO)
    }

    fun updateDisplay(number: BigDecimal) {
        mResultTextView?.text = number.toPlainString()
    }

    fun updateDisplay(string: String) {
        mResultTextView?.text = string
    }
}
