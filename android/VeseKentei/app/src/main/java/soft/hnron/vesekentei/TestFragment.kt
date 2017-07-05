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

    private var problemNumberTextView: TextView? = null
    private var problemStatementTextView: TextView? = null
    private var selectZeroButton: Button? = null
    private var selectOneButton: Button? = null
    private var selectTwoButton: Button? = null
    private var selectThreeButton: Button? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        problemNumberTextView = view?.findViewById<TextView>(R.id.fragment_test__text_view__problem_number)
        problemStatementTextView = view?.findViewById<TextView>(R.id.fragment_test__text_view__problem_statement)
        selectZeroButton = view?.findViewById<Button>(R.id.fragment_test__button__select_zero)
        selectOneButton = view?.findViewById<Button>(R.id.fragment_test__button__select_one)
        selectTwoButton = view?.findViewById<Button>(R.id.fragment_test__button__select_two)
        selectThreeButton = view?.findViewById<Button>(R.id.fragment_test__button__select_three)

        selectZeroButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        selectOneButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        selectTwoButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        selectThreeButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }

        problemNumberTextView?.text = Problem.problemNumber.toString()
        problemStatementTextView?.text = Problem.statement
        selectZeroButton?.text = Problem.selectZero
        selectOneButton?.text = Problem.selectOne
        selectTwoButton?.text = Problem.selectTwo
        selectThreeButton?.text = Problem.selectThree
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

    fun onSelectorClick(selectorNumber: Int) {
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
