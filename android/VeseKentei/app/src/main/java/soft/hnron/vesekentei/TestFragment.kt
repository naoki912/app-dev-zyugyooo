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

    private var mListener: KenteiFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val problemNumberTextView = view?.findViewById<TextView>(R.id.fragment_test__text_view__problem_number)
        val problemStatementTextView = view?.findViewById<TextView>(R.id.fragment_test__text_view__problem_statement)
        val answerZeroButton = view?.findViewById<Button>(R.id.fragment_test__button__answer_zero)
        val answerOneButton = view?.findViewById<Button>(R.id.fragment_test__button__answer_one)
        val answerTwoButton = view?.findViewById<Button>(R.id.fragment_test__button__answer_two)
        val answerThreeButton = view?.findViewById<Button>(R.id.fragment_test__button__answer_three)

        answerZeroButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        answerOneButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        answerTwoButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }
        answerThreeButton?.setOnClickListener { v -> onSelectorClick(v.tag.toString().toInt()) }

        problemNumberTextView?.text = Problem.problemNumber.toString()
        problemStatementTextView?.text = Problem.statement
        answerZeroButton?.text = Problem.selectorZero
        answerOneButton?.text = Problem.selectorOne
        answerTwoButton?.text = Problem.selectorTwo
        answerThreeButton?.text = Problem.selectorThree
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is KenteiFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement KenteiFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    fun onSelectorClick(selectorNumber: Int) {
        mListener?.onSelectorClick()
    }

    interface KenteiFragmentListener {
        fun onSelectorClick()
    }

    companion object {
        fun newInstance(): TestFragment = TestFragment()
        val TAG = "TestFragment"
    }
}
