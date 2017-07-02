package soft.hnron.vesekentei

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.opencsv.CSVReader
import java.io.InputStreamReader

class TestFragment : Fragment() {

    private var mListener: KenteiFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val answerZeroButton = view?.findViewById<Button>(R.id.fragment_test__button__answer_zero)
        val answerOneButton = view?.findViewById<Button>(R.id.fragment_test__button__answer_one)
        val answerTwoButton = view?.findViewById<Button>(R.id.fragment_test__button__answer_two)
        val answerThreeButton = view?.findViewById<Button>(R.id.fragment_test__button__answer_three)

        answerZeroButton?.setOnClickListener {  }
        answerOneButton?.setOnClickListener {  }
        answerTwoButton?.setOnClickListener {  }
        answerThreeButton?.setOnClickListener {  }

        val csvReader = CSVReader(InputStreamReader(resources.assets.open("csv/tests.csv")))

        for (questions in csvReader.readAll()) {
            for (item in questions) {
                println(item.toString())
            }
        }
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

    interface KenteiFragmentListener { }

    companion object {
        fun newInstance(): TestFragment = TestFragment()
        val TAG = "TestFragment"
    }
}
