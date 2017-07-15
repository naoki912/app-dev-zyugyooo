package soft.hnron.vesekentei

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import soft.hnron.vesekentei.objects.Problem

class TestFragment : Fragment() {

    private var mListener: TestFragmentListener? = null

    private var mProblemNumberTextView: TextView? = null
    private var mProblemStatementTextView: TextView? = null
    private var mSelectZeroButton: Button? = null
    private var mSelectOneButton: Button? = null
    private var mSelectTwoButton: Button? = null
    private var mSelectThreeButton: Button? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mProblemNumberTextView = view?.findViewById<TextView>(R.id.fragment_test__text_view__problem_number)
        mProblemStatementTextView = view?.findViewById<TextView>(R.id.fragment_test__text_view__problem_statement)
        mSelectZeroButton = view?.findViewById<Button>(R.id.fragment_test__button__select_zero)
        mSelectOneButton = view?.findViewById<Button>(R.id.fragment_test__button__select_one)
        mSelectTwoButton = view?.findViewById<Button>(R.id.fragment_test__button__select_two)
        mSelectThreeButton = view?.findViewById<Button>(R.id.fragment_test__button__select_three)

        mSelectZeroButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        mSelectOneButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        mSelectTwoButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        mSelectThreeButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }

        updateProblemDisplay()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is TestFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement TestFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    fun updateProblemDisplay() {
        mProblemNumberTextView?.text = Problem.problemNumber.toString()
        mProblemStatementTextView?.text = Problem.statement
        mSelectZeroButton?.text = Problem.selectZero
        mSelectOneButton?.text = Problem.selectOne
        mSelectTwoButton?.text = Problem.selectTwo
        mSelectThreeButton?.text = Problem.selectThree
    }

    fun onSelectorClick(selectorNumber: Int) {
        // 解答を表示させる
        // updateDisplay

        Problem.next()

        mListener?.onSelectorClick()
    }

    interface TestFragmentListener {
        fun onSelectorClick()
    }

    companion object {
        fun newInstance(): TestFragment = TestFragment()
        val TAG = "TestFragment"
    }
}
